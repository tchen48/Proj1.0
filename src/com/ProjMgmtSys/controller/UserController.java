package com.ProjMgmtSys.controller;


import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import com.ProjMgmtSys.model.User.*;

@Controller("userController")
public class UserController {
	@RequestMapping("/login")
    public String login(@ModelAttribute("user") User user, Model model){	
        return "login";
    }
	
	@RequestMapping("/home")
	public String home(@ModelAttribute("user") User user, Model model, HttpSession session) throws InvalidKeyException, NoSuchAlgorithmException, ParseException, IOException{
		LoginResult loginResult = UserManager.validate(user.getUserId(), user.getPassword());
		if(loginResult.getUser() == null){
			String ErrorMsg = StatusCode.LOGIN_STATUS[loginResult.getStatusCode()];
			model.addAttribute("ErrorMsg", ErrorMsg);
			return "login";
		}	
		user = loginResult.getUser();
		int usertype = user.getUserType();
		session.setMaxInactiveInterval(1200);
		session.setAttribute("userName", user.getUserName());
		model.addAttribute("userName", user.getUserName());
		if(usertype == UserType.SUPERADMIN){			
			return "adminHome";
		}
		else if(usertype == UserType.DEPTMANAGER){
			return "deptMngHome";
		}
		else if(usertype == UserType.GROUPMANAGER){
			return "groMngHome";
		}
		else{
			return "empHome";
		}
//			
//			if(roletype != Roletype.INTERNALUSER){
//				Account account = AccountManager.queryAccount(strID);
//				String checkingID = String.valueOf(account.getCheckingID());
//				String savingID = String.valueOf(account.getSavingID());
//				String creditID = String.valueOf(account.getCreditID());			
//				model.addAttribute("checkingLastFour", checkingID.substring(checkingID.length() - 4, checkingID.length()));
//				model.addAttribute("savingLastFour", savingID.substring(savingID.length() - 4, savingID.length()));
//				model.addAttribute("creditLastFour", creditID.substring(creditID.length() - 4, creditID.length()));
//				model.addAttribute("checkingBalance", account.getCheckingBalance());
//				model.addAttribute("savingBalance", account.getSavingBalance());
//				model.addAttribute("creditBalance", account.getCreditBalance());
//				VisitorManager.deleteVisitor(machineID);
//				session.setMaxInactiveInterval(1200);
//				return "account";
//			}
//			else{
//				session.setMaxInactiveInterval(1200);
//				Employee employee = EmployeeManager.queryEmployee(strID);
//				if(employee == null){
//					Account account = AccountManager.queryAccount(strID);
//					String checkingID = String.valueOf(account.getCheckingID());
//					String savingID = String.valueOf(account.getSavingID());
//					String creditID = String.valueOf(account.getCreditID());			
//					model.addAttribute("checkingLastFour", checkingID.substring(checkingID.length() - 4, checkingID.length()));
//					model.addAttribute("savingLastFour", savingID.substring(savingID.length() - 4, savingID.length()));
//					model.addAttribute("creditLastFour", creditID.substring(creditID.length() - 4, creditID.length()));
//					model.addAttribute("checkingBalance", account.getCheckingBalance());
//					model.addAttribute("savingBalance", account.getSavingBalance());
//					model.addAttribute("creditBalance", account.getCreditBalance());
//					model.addAttribute("employee", "Employee");
//					session.setAttribute("employeepage", "EmployeeNotReady.html");
//					return "account";
//				}
//				if(user.getStrID().equals("admin1")){
//					session.setAttribute("employeepage", "SystemAdmin.html");
//					VisitorManager.deleteVisitor(machineID);
//					return "SystemAdmin";
//				}
//				else if(((String)employee.getdepartment()).equalsIgnoreCase("Corporate Management") && ((String)employee.getrole()).equalsIgnoreCase("Manager")){
//					session.setAttribute("employeepage", "CorporateHomePage.html");
//					VisitorManager.deleteVisitor(machineID);
//					return "CorporateHomePage";
//				}
//				else if(((String)employee.getrole()).equalsIgnoreCase("Manager")){
//					session.setAttribute("employeepage", "DepartmentManager.html");
//					VisitorManager.deleteVisitor(machineID);
//					return "DepartmentManager";
//				}
//				else{
//					session.setAttribute("employeepage", "RegularEmployee.html");
//					VisitorManager.deleteVisitor(machineID);
//					return "RegularEmployee";
//				}
//					
//			}
	}
}
