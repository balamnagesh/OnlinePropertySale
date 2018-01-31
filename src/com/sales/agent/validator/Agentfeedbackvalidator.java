package com.sales.agent.validator;

import org.apache.commons.lang.WordUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sales.admin.bean.FeedBackBean;
import com.sales.agent.bean.AgentFeedback;



public class Agentfeedbackvalidator implements Validator{

	public boolean supports(Class<?> clazz) {
		return AgentFeedback.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		AgentFeedback r=(AgentFeedback)target;
		/*String email=r.getEmail();
		email=email.replaceAll(" ", "");
		r.setEmail(email);
		 */
		String comment=r.getComments();
		/*email=email.replaceAll(" ", "");
		r.setEmail(email);
		 
		if(email == null||email.trim().equals("")){
			errors.rejectValue("email","errors.email.required","Email Id is required");
		}
		else if(email.length()<12||email.length()>70){
			errors.rejectValue("email","errors.email.length","Email-id must be minimum length 12 or max 70 ");
	}
		else if(!email.matches("^[A-Za-z._0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z.]+$")){
			errors.rejectValue("email","errors.email.match","Enter valid Email-id (ex:abcd@gmail.com)");
		}
		
		else if(!email.matches("^(?!.*?[@._]{2})[a-zA-Z0-9@._]+$")){
			errors.rejectValue("email","errors.email.special","Email-id don't allow special characters consecutive");
		}
		else if(email.toLowerCase().contains("emailid")||email.toLowerCase().contains("email")){
			errors.rejectValue("email","errors.email.mat","Email-id should not entered as email or emailid");

		 }
	
		
		
		else{
			   try{
			   final String[] e1=email.split("@");
	 	   String e11=e1[0];
	 	   String e12=e1[1];
	 	  if(!email.substring(0, 1).matches("^[a-zA-Z]+$"))
			{
				errors.rejectValue("email","errors.email.firstltr","Email-id starts with alphabets only");
			}
	 	  else if(e1[0].length()<6||e1[0].length()>30){
				errors.rejectValue("email","errors.email.actlngth","Email-id account name length should be minimum 6 and maximum 30");
	      }
	 	   else if(e12.contains(".")){
	 		   final String [] em1=e12.split("\\.");
	 		   System.out.println("em1......."+em1);
	 		   String em11=em1[0];
	 		   System.out.println("em11......."+em11);
	 		   String em12=em1[1];
	 		   System.out.println("em12......."+em12);
	 		   System.out.println("em1[0]..."+em1[0]);
	 		   System.out.println("e11...."+e11);
	 		   int esl=em1.length;
	 		   System.out.println("lgth..."+esl);
	 		  if(e11.matches(em11)){
					errors.rejectValue("email","errors.email.samedomainmame","Email-id address name or domain name should not be same");
	 		   }
	 		  else if(e11.matches(em12)){
					errors.rejectValue("email","errors.email.sameservmame","Email-id address name or service name should not be same");
	 		  }
	 		  else if(em11.matches(em12)){
					errors.rejectValue("email","errors.email.domservmame","Email-id domain name or service name should not be same");

	 		  }
	 		
	 		 else if(em1[2].toLowerCase().equals(e11.toLowerCase())){
					errors.rejectValue("email","errors.email.sameservmame1","Email-id address name or service name should not be same");

				 }
				 else if(em1[2].toLowerCase().equals(em11.toLowerCase())){
					errors.rejectValue("email","errors.email.domservmame1","Email-id domain name or service name should not be same");

				 }		
	 	   
	 		  else if(em1.length>3){
					errors.rejectValue("email","errors.email.domainnamelgth","Email-id domain name length should not be more than 3");
	 		  }
	 		  else if(em1[0].length()<2||em1[0].length()>30){
					errors.rejectValue("email","errors.email.domainnamelgth1","Email-id domain name length should be minimum 2 and maximum 30");
	  		 }
	 		 else if(em1[1].length()<2||em1[1].length()>4){
					errors.rejectValue("email","errors.email.domainnamelgth2","Email-id service name length should be minimum 2 and maximum 4");
	 		 }
	 		else if(em1[2].length()<2||em1[2].length()>4){
				errors.rejectValue("email","errors.email.domainnamelgth2","Email-id second service name length should be minimum 2 and maximum 4");
 		 }
	 		 else if(esl<2||esl>3){
					errors.rejectValue("email","errors.email.domainnamelgth4","Email-id valid service name");

	 		 }
	 		 else if(email.endsWith(".")){
					errors.rejectValue("email","errors.email.ends","Email-id last character not ends with special characters");
				}
	 		 else if(em1[1].toLowerCase().equals("com")&&em1[2].toLowerCase().equals("in")){
					errors.rejectValue("email","errors.email.domservmamew","Enter valid service name");
	 				
	 		  }
	 		 else if(em1[1].toLowerCase().equals(em1[2])){
					errors.rejectValue("email","errors.email.domservmamewsam","Enter valid service name");

	 		 }
	 		 
	 	   }
			   }
			   catch(Exception e){

		   }}
		if(email == null||email.trim().equals("")){
			errors.rejectValue("email","errors.email.required","");
		}
		
		//city validation
		  String city=r.getCity();
		
		city=city.trim();
		city=city.replaceAll(" ", "");
		city=WordUtils.capitalizeFully(city);
		r.setCity(city);
	 
	 
		if(city==null||city.trim().equals("")){
			errors.rejectValue("city","errors.city.required","City is required");
		}
		else if(city.length()<2||city.length()>30){
			errors.rejectValue("city","errors.citylength","City length should be minimum 2 and maximum 30");
		}
		else if(!city.matches("^[a-zA-Z ]+$")){
			errors.rejectValue("city","errors.city.match","City accepts only alphabets");
		}
		else if(city.toLowerCase().contains("city")){
			errors.rejectValue("city","errors.city.match","City Should not be entered as city");

		}
		else if(city.toLowerCase().contains("firstname")||city.toLowerCase().contains("middlename")||city.toLowerCase().contains("lastname")){
			errors.rejectValue("city","errors.city.match","City Should not be entered as firstname or middlename or lastname");

		}
		
		//name validations
		 //......................username................................	
	   	String username=r.getName();
		username=username.replaceAll(" ", "");
		String us=WordUtils.capitalizeFully(username);
		System.out.println("un ctpl..."+us);
		r.setName(username);
		if(username == null ||username .trim().equals("")){
			errors.rejectValue("name","errors.username.required","Name is required");
		}
 else if(username .substring(0,1).matches("^[0-9]")){
			
			errors.rejectValue("name","errors.username.start","Name starts with alphabets");
		}
		else if(username .length()<6||username .length()>30){
			errors.rejectValue("name","errors.username.length","Name must be minimum length 6 and maximum 30");
		}
		
	      
		else if(!(username .matches("^[a-zA-Z]+[0-9]+$")||(username.matches("^[a-zA-Z]+$")))){
			errors.rejectValue("name","errors.username.match","Name should be alphabets followed by digits(Ex:abc123/abc)");
		}
		
		
		else if(username.toLowerCase().contains("name")){
			errors.rejectValue("name","errors.username.equalss","Name should not entered as name");
		}
		
		
		else 
		{
			try{
				  
		        
		       
		        if(username.replaceAll("\\s+", "").substring(0, 4).toLowerCase().equalsIgnoreCase("name"))
				   {
					  errors.rejectValue("name", "username.use", "Name should not be name");
				   }
			}
			catch(Exception e){
				 
			}
		}
	 
*/	//comments validation
	if(comment == null||comment.trim().equals("")){
		errors.rejectValue("comments","errors.comments.required","Comments is required");
	}
	else if(comment.length()<4||comment.length()>100){
		errors.rejectValue("comments","errors.comments.length","Comment must be minimum length 4 or max 100 ");
}
	else if(comment.toLowerCase().matches("comments")){
		errors.rejectValue("comments","errors.comments.match","Comment should not be entered as comments ");
}
	}
}

