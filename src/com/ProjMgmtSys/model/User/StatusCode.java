package com.ProjMgmtSys.model.User;

public class StatusCode {
	public static final int ACCT_NOT_BLOCKED = 0;
	public static final int ACCT_BLOCKED = 1;
	
	public static final int LOGIN_SUCCESS = 0;
	public static final int USERID_NOT_EXIST = 1;
	public static final int PASSWORD_NOT_CORRECT = 2;
	public static final int ACCOUNT_BLOCK = 3;
	public static final String[] LOGIN_STATUS = {"Login success", "UserID not exist", "Incorrect Password", "Account is Blocked. Please contact the administrator."};
}
