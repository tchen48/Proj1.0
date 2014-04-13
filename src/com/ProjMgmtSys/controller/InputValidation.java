package com.ProjMgmtSys.controller;

import com.asubank.model.combinedcommand.UserInformation;
import com.asubank.model.merchant.MerchantInput;
import com.asubank.model.recipient.RecipientInput;
import com.asubank.model.transfer.Transaction;
import com.asubank.model.transfer.TransactionInput;
import com.asubank.model.user.ContactSet;
import com.asubank.model.user.PasswordSet;

public class InputValidation {
	public static String validateUserInformation(UserInformation userInformation){
		if(RegExPattern.validateName(userInformation.getFirstname()) == false){
			return InputErrorCode.FIRSTNAME_ERROR;
		}
		if(RegExPattern.validateName(userInformation.getLastname()) == false){
			return InputErrorCode.LASTNAME_ERROR;
		}
		if((RegExPattern.validateDobYear(userInformation.getDobYear()) == false) ||
		   (RegExPattern.validateDobDay(userInformation.getDobDay()) == false) ||
		   (RegExPattern.validateDobMonth(userInformation.getDobMonth()) == false)){
			return InputErrorCode.DOB_ERROR;
		}
		if(RegExPattern.validateSsn(userInformation.getSsn()) == false){
			return InputErrorCode.SSN_ERROR;
		}
		if(RegExPattern.validateAddress(userInformation.getAddress()) == false){
			return InputErrorCode.ADDRESS_ERROR;
		}
		if(RegExPattern.validateEmail(userInformation.getEmail()) == false){
			return InputErrorCode.EMAIL_ERROR;
		}
		if(RegExPattern.validateTelephone(userInformation.getTelephone()) == false){
			return InputErrorCode.TELEPHONE_ERROR;
		}
		if(RegExPattern.validatePassword(userInformation.getPassword()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		if(RegExPattern.validatePassword(userInformation.getPwdConfirm()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		if(RegExPattern.validatePassword(userInformation.getTransPwd()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		if(RegExPattern.validatePassword(userInformation.getTransPwdConfirm()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		return null;
	}
	
	public static String validateLogin(String strID, String password){
		if(RegExPattern.validateStrID(strID) == false){
			return InputErrorCode.STRID_ERROR;
		}
		if(RegExPattern.validatePassword(password) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		return null;
	}
	
	public static String validateOTP(String otp){
		if(RegExPattern.validateOTP(otp) == false){
			return InputErrorCode.OTP_ERROR;
		}
		return null;
	}
	
	public static String validateCaptcha(String captcha){
		if(RegExPattern.validateCaptcha (captcha) == false){
			return InputErrorCode.CAPTCHA_ERROR;
		}
		return null;
	}
	
	public static String validateStrID(String strID){
		if(RegExPattern.validateStrID(strID) == false){
			return InputErrorCode.STRID_ERROR;
		}
		return null;
	}
	
	public static String validateTransfer(TransactionInput transfer){
		if(RegExPattern.validateAccountID(transfer.getFromIDInput()) == false){
			return InputErrorCode.ACCOUNTID_ERROR;
		}
		if(RegExPattern.validateAccountID(transfer.getFromIDInput()) == false){
			return InputErrorCode.ACCOUNTID_ERROR;
		}
		if(RegExPattern.validateAmount(transfer.getAmountInput()) == false){
			return InputErrorCode.AMOUNT_ERROR;
		}
		return null;
	}
	public static String validateRecipient(RecipientInput recipient){
		if(RegExPattern.validateName(recipient.getRecipient_lastnameInput()) == false){
			return InputErrorCode.LASTNAME_ERROR;
		}
		if(RegExPattern.validateName(recipient.getRecipient_nicknameInput()) == false){
			return InputErrorCode.NICKNAME_ERROR;
		}
		if(RegExPattern.validateAccountID(recipient.getRecipient_accountnumberInput()) == false){
			return InputErrorCode.ACCOUNTID_ERROR;
		}
		return null;
	}
	public static String validatePasswordSet(PasswordSet passwordSet){
		if(RegExPattern.validatePassword(passwordSet.getOldPassword()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		if(RegExPattern.validatePassword(passwordSet.getNewPassword()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		if(RegExPattern.validatePassword(passwordSet.getConfirmPassword()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		return null;
	}
	public static String validateContactSet(ContactSet contactSet){
		if(RegExPattern.validateAddress(contactSet.getAddress()) == false && contactSet.getAddress() != ""){
			return InputErrorCode.ADDRESS_ERROR;
		}
		if(RegExPattern.validateEmail(contactSet.getEmail()) == false && contactSet.getEmail() != ""){
			return InputErrorCode.EMAIL_ERROR;
		}
		if(RegExPattern.validateTelephone(contactSet.getTelephone()) == false && contactSet.getTelephone() != ""){
			return InputErrorCode.TELEPHONE_ERROR;
		}
		if(RegExPattern.validatePassword(contactSet.getPassword()) == false){
			return InputErrorCode.PASSWORD_ERROR;
		}
		return null;
	}
	public static String validateAccount(MerchantInput merchantInput){
		if(RegExPattern.validateAccountID(merchantInput.getCustomerid()) == false){
			return InputErrorCode.ACCOUNTID_ERROR;
		}
		return null;
	}
	public static String validateMerchantInput(MerchantInput merchantInput){
        if(RegExPattern.validateAccountID(merchantInput.getFromIDInput()) == false){
                return InputErrorCode.ACCOUNTID_ERROR;                        
        }
        if(RegExPattern.validateAccountID(merchantInput.getToIDInput()) == false){
                return InputErrorCode.ACCOUNTID_ERROR;                        
        }
        if(RegExPattern.validatePassword(merchantInput.getTransactionpasswordInput()) == false){
                return InputErrorCode.PASSWORD_ERROR;                        
        }
        if(RegExPattern.validateAmount(merchantInput.getAmountInput()) == false){
                return InputErrorCode.AMOUNT_ERROR;                        
        }
        return null;
}

}
