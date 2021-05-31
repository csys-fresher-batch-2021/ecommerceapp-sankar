package in.sankarvinoth.util.validator;

public class UserInputsValidator {

	private UserInputsValidator() {
		
	}
	
     /**
      * method to validate the user inputs such as fullname , username, phone number, email .
      * 
      * @param fullname
      * @param username
      * @param email
      * @param mobileNumber
      * @return
      */
	
	public  static boolean usersInputValidator(String fullname,String username,String email,Long mobileNumber) {
		boolean isValidInputs=false;
		// fullname validation
		boolean isValidfullname=StringValidator.isValidString(fullname);
		//username validation
		boolean isValidusername=StringValidator.isValidString(username);
		// email validation
		boolean isValidemail=StringValidator.isValidString(email);
		// phone number validation
		boolean isValidMobileNumber=UserInputValidator.phoneNumberValidation(mobileNumber);
		if(isValidfullname && isValidusername && isValidemail && isValidMobileNumber ) {
			isValidInputs=true;
		}
		return isValidInputs;
		
	
	}

}
