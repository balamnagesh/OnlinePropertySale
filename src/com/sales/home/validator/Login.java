package com.sales.home.validator;



import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sales.home.bean.LoginBean;



public class Login implements Validator {
	
	
	
	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("coming to support method");
		return LoginBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object ob, Errors errors) 
	{
		System.out.println("coming to validate method");
		LoginBean rb=(LoginBean)ob;
		  
		    
		    
		     String userName=rb.getUsername();
		     String password=rb.getPassword();
		    
		    
		     
		     
		     userName=userName.replace(" ","");
	         String un1=userName.toLowerCase();
	         rb.setUsername(userName);
	         String regexpun="^[a-zA-Z]+[a-zA-Z0-9]+$";
	         String pwd1=password.toLowerCase();
	         
	         
			 if( userName == null ||  userName.trim().equals(""))
			{
				errors.rejectValue("username","errors.required.un","UserName is required.");
			}
			/*else if( userName.length()<6||  userName.length()>30)
			{
				errors.rejectValue("userName", "errors.length.un","UserName length is minimum 6 and maximum 30.");
			}
			else if(! userName.matches(regexpun))
			{
				errors.rejectValue("userName", "errors.regexp.un","UserName should be alphaNumerical only.characters followed by digits.");
			}*/
			
			 
			 password=password.replace(" ","");
			 rb.setPassword(password);
		        String regexppswd="^[A-Z]+[a-z]+[.@_]+[0-9]+$";
		        String reg="^[.@_]+$";
		        boolean st=false;
		        for(int i=0;i<password.length()-1;i++)
				  {
			  char a=password.charAt(i);
			  String a1 = Character.toString(a);
			  char b=password.charAt(i+1);
					String b1=Character.toString(b);
					if(a1.matches(reg)&&b1.matches(reg))
					{
						
						st=true;
						break;
						
					}
		     	  }
		        
		        
		        
      if( password==null|| password.trim().equals(""))
		{
			errors.rejectValue("password","errors.required.pwd","Password is required.");
		}
		/*else if( password.length()<6||  password.length()>24)
		{
			errors.rejectValue("password", "errors.length.pwd","Password length is minimum 6 maximum 24.");
		}
		else if(! password.matches(regexppswd))
		{
			errors.rejectValue("password", "errors.regexp.pwd","Password should be  First letter must be capital,Second letter on words small letters and followed by one special character,followed by digits&special characters allow only these[.@_](Like this:Nagesh@517).");
		}
		
		else if(st==true)
		{
			errors.rejectValue("password","errors.repeat.pwd","consecutive special characters are not allowed(.@_)[please enter like this:Nagesh@517].");
		}
		
		     */
	}

	
	

}
