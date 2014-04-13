package com.ProjMgmtSys.model.User;
 
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;


public class UserManager {
	private static Session session;
	private static final int MAXFAIL = 3;
	private static void createSession(){
		session = SessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
	}
	
	public static String createUser(String userName, String password, int userType, int groId, int depId){
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserType(userType);
		user.setGroId(groId);
		user.setDepId(depId);
		
		createSession();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		return  "" + user.getUserId();
	}
	
	
	@SuppressWarnings("unchecked")
	public static User queryUser(String userId){
		createSession();
		String hql = "from User as user where user.userId=:userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		List <User>list = query.list();
		User user = null;
		java.util.Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			user = iter.next();
		}					
		session.getTransaction().commit();
		session.close();
		return user;		
	}
	
	public static void updatePassword(String userId, String password){
		createSession();
		String hql1 = "update User as u set u.password=:password where userId=:userId";
		Query query1 = session.createQuery(hql1);
		query1.setString("userId", userId);
		query1.setString("password", password);
		query1.executeUpdate(); 
		session.getTransaction().commit();
		session.close();
	}
	
	
//	private static int queryStrID(String shortname){
//		createSession();
//		String hql = "select count(strID) from User as user where user.shortname=:shortname";
//		Query query = session.createQuery(hql);  
//		query.setString("shortname",shortname);
//		int num = ((Number)query.uniqueResult()).intValue();
//		session.getTransaction().commit();
//		session.close();
//		return num;		
//	}
	
	public static int validatePassword(String userId, String password){
		createSession();
		String hql = "from User as user where user.userId=:userId"; //and user.password=:password";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		List <User>list = query.list();
		User user = null;
		java.util.Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			user = iter.next();
		}		
		session.getTransaction().commit();
		session.close();
		if(user == null){
			return StatusCode.USERID_NOT_EXIST;
		}
		String correctPassword = user.getPassword();
		if(password.equals(correctPassword)){
			return StatusCode.LOGIN_SUCCESS;
		}
		else{
			return StatusCode.PASSWORD_NOT_CORRECT;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static LoginResult validate(String userId, String password){
		LoginResult loginResult = new LoginResult();
		createSession();
		String hql = "from User as user where user.userId=:userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		List <User>list = query.list();
		User user = null;
		java.util.Iterator<User> iter = list.iterator();
		while (iter.hasNext()) {
			user = iter.next();
		}		
		session.getTransaction().commit();
		session.close();
		if(user == null){
			loginResult.setUser(null);
			loginResult.setStatusCode(StatusCode.USERID_NOT_EXIST);
			return loginResult;
		}
		String correctPassword = user.getPassword();
		if(password.equals(correctPassword) == true && user.isBlock() == false){
			resetFail(userId);
			loginResult.setUser(user);
			loginResult.setStatusCode(StatusCode.LOGIN_SUCCESS);
			return loginResult;
		}
		else if(user.isBlock() == true){
			loginResult.setUser(null);
			loginResult.setStatusCode(StatusCode.ACCOUNT_BLOCK);
			return loginResult;
		}
		else{
			increaseFail(user);
			loginResult.setUser(null);
			loginResult.setStatusCode(StatusCode.PASSWORD_NOT_CORRECT);
			return loginResult;
		}	
	}
	
	public static int increaseFail(User user){
		int fail = user.getFail();
		String userId = user.getUserId();
		fail++;
		if(fail == MAXFAIL){
			blockUser(userId);
			return StatusCode.ACCT_BLOCKED;
		}
		else{			
			createSession();
			String hql = "update User as u set u.fail=:fail where userId=:userId";
			Query query = session.createQuery(hql);
			query.setString("userId", userId);
			query.setInteger("fail", fail);
			query.executeUpdate(); 
			session.getTransaction().commit();
			session.close();
			return StatusCode.ACCT_NOT_BLOCKED;
		}		
	}
	public static void resetFail(String userId){
		createSession();
		String hql = "update User as u set u.fail=:fail where userId=:userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		query.setInteger("fail", 0);
		query.executeUpdate(); 
		session.getTransaction().commit();
		session.close();
		return;
	}
	public static void blockUser(String userId){
		createSession();
		String hql = "update User as u set u.block=:block where userId=:userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		query.setBoolean("block", true);
		query.executeUpdate(); 
		session.getTransaction().commit();
		session.close();
		return;
	}
	public static void unblockUser(String userId){
		createSession();
		String hql = "update User as u set u.block=:block where userId=:userId";
		Query query = session.createQuery(hql);
		query.setString("userId", userId);
		query.setBoolean("block", false);
		query.executeUpdate(); 
		session.getTransaction().commit();
		session.close();
		return;
	}
}