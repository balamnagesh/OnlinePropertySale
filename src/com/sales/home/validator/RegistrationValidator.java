package com.sales.home.validator;



import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



import org.apache.commons.lang.WordUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;



import com.sales.home.bean.Registration;

   public class RegistrationValidator implements Validator
   {

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("coming to support method");
		return Registration.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object ob, Errors errors) 
	{
		System.out.println("coming to validate method");
		Registration rb=(Registration)ob;
		  String id=rb.getId();
		  //System.out.println(rb.getId());
		     String firstName=rb.getFirstname();
		     String middleName=rb.getMiddlename();
		     String lastName=rb.getLastname();
		     String userName=rb.getUsername();
		     String password=rb.getPassword();
		     String conformPassword=rb.getConformpassword();
		     String phoneNumber=rb.getMobileno();
		     String emailId=rb.getEmail();
		     String dateOfBirth=rb.getDateofbirth();
		     String country=rb.getCountry();
		     String state=rb.getState();
		     String city=rb.getCity();
		     String address=rb.getAddress();
		     
		    
		     String pincode=rb.getPincode();
		     String language=rb.getLanguage();
		     String gender=rb.getGender();
	
		     
		  
		        
		     
		 	String email=rb.getEmail();
			emailId=email.replaceAll(" ", "");
					rb.setEmail(emailId);
					    
			
					
					
					
		
				 
				
					
					
					
					String f=firstName.toLowerCase();
    				
					String mn1=middleName.toLowerCase();	
					String l=lastName.toLowerCase();
					
					
					
					
					
					
					firstName=firstName.trim().replaceAll(" ","");
					 //   firstname= StringUtils.capitalize(firstname);
				    
					firstName=WordUtils.capitalizeFully(firstName);
					  rb.setFirstname(firstName);
					 	System.out.println("Firstname is "+firstName);
					 
					  if(firstName==null||firstName.isEmpty())
				       {
				       	errors.rejectValue("firstname","firstname.requiredfirst", "First name is Required.");

				       }
				    
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
					   {
						  errors.rejectValue("firstname", "firstname.fir", "Firstname should not be firstname");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
					   {
						  errors.rejectValue("firstname", "firstname.mid", "Firstname should not be middlename");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
					   {
						  errors.rejectValue("firstname","firstname.las", "Firstname should not be lastname");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("username"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be username");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be city");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be password");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("confirmpassword"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be confirmpassword");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("gender"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be gender");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("emailid"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be emailid");
					   }
					  else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("dateofbirth"))
					   {
						  errors.rejectValue("firstname", "firstname.use", "Firstname should not be dateofbirth");
					   }
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("country"))
					   {
						   errors.rejectValue("firstname", "firstname.use", "Firstname should not be country");
					   }
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("state"))
					   {
						   errors.rejectValue("firstname", "firstname.use", "Firstname should not be state");
					   }
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("address"))
					   {
						   errors.rejectValue("firstname", "firstname.use", "Firstname should not be address");
					   }
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("pincode"))
					   {
						   errors.rejectValue("firstname", "firstname.use", "Firstname should not be pincode");
					   }
					   
					   else if(firstName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("mobileno"))
					   {
						   errors.rejectValue("firstname", "firstname.use", "Firstname should not be mobileno");
					   }
					  
					  
					     
				   else if(!firstName.matches("^[A-Za-z]+$"))
				   {
				   	errors.rejectValue("firstname","firstname.requiredfirst", "FirstName should contain only Alphabets.");
				   }
				   else  if(firstName.length()<2||firstName.length()>30 )
				   {
				   	errors.rejectValue("firstname","firstname.requiredfirst", " FirstName length is minimum 2 maximum 30.");
				   }
				   
				//***********************MiddleName validation Starts*************************************************

					  
					  middleName=middleName.trim().replaceAll(" ","");
						 //   middlename= StringUtils.capitalize(middlename);
					    
					  middleName=WordUtils.capitalizeFully(middleName);
					 rb.setMiddlename(middleName);
					 	System.out.println("Middlename is "+middleName);
						 
						  if(middleName==null||middleName.isEmpty())
					       {
					       	errors.rejectValue("middlename","middlename.requiredmiddle", "Middlename is Required.");
					       }
					   		   
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
						   {
							 errors.rejectValue("middlename", "middlename.fir", "Middlename should not be firstname");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
						   {
							  errors.rejectValue("middlename", "middlename.mid", "Middlename should not be middlename");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
						   {
							  errors.rejectValue("middlename","middlename.las", "Middlename should not be lastname");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("username"))
						   {
							  errors.rejectValue("middlename", "middlename.use", "Middlename should not be username");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
						   {
							  errors.rejectValue("middlename", "middlename.use", "Middlename should not be city");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
						   {
							  errors.rejectValue("middlename", "firstname.use", "Middlename should not be password");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("confirmpassword"))
						   {
							  errors.rejectValue("middlename", "firstname.use", "Middlename should not be confirmpassword");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("gender"))
						   {
							  errors.rejectValue("middlename", "firstname.use", "Middlename should not be gender");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("emailid"))
						   {
							  errors.rejectValue("middlename", "firstname.use", "Middlename should not be emailid");
						   }
						  else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("dateofbirth"))
						   {
							  errors.rejectValue("middlename", "firstname.use", "Middlename should not be dateofbirth");
						   }
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("country"))
						   {
							   errors.rejectValue("middleName", "firstname.use", "Middlename should not be country");
						   }
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("state"))
						   {
							   errors.rejectValue("middlename", "firstname.use", "Middlename should not be state");
						   }
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("address"))
						   {
							   errors.rejectValue("middlename", "firstname.use", "Middlename should not be address");
						   }
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("pincode"))
						   {
							   errors.rejectValue("middlename", "firstname.use", "Middlename should not be pincode");
						   }
						   else if(middleName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("mobileno"))
						   {
							   errors.rejectValue("middlename", "firstname.use", "Middlename should not be mobileno");
						   }
						  
					   
						   else if(!middleName.matches("^[A-Za-z]+$"))
						   {
							   errors.rejectValue("middlename","middlename.requiredmiddle", "Middlename should contain only Alphabets.");
						   }
						   else if(middleName.equals(firstName))
						   {
							   errors.rejectValue("middlename","middlename.requiredmiddle", "Middlename should not match with Firstname.");
						   }
						   else  if(middleName.length()<2||middleName.length()>30 )
						   {
							   errors.rejectValue("middlename","middlename.requiredmiddle", " Middlename length is minimum 2 maximum 30.");
						   }
					   
						
						  
						  //********************************lastname vallidation start*************************************
					        
					     	
						  lastName=lastName.trim().replaceAll(" ","");
					   //   lastname= StringUtils.capitalize(lastname);

						  lastName=WordUtils.capitalizeFully(lastName);
					 rb.setLastname(lastName);
					    System.out.println("Lastname is "+lastName);
					         
					         
					  if(lastName.equalsIgnoreCase(null)||lastName.length()<1||lastName.trim().equals(""))
					       {
					       	  errors.rejectValue("lastname","lastname.requiredlast", "Lastname is Required.");
					       }
				     
					  
				      else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
					   {
						 errors.rejectValue("lastname", "lastname.fir", "Lastname should not be firstname");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
					   {
						  errors.rejectValue("lastname", "lastname.mid", "Lastname should not be middlename");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
					   {
						  errors.rejectValue("lastname","lastname.las", "Lastname should not be lastname");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("username"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be username");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be city");
					   }
					 else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
					   {
						 errors.rejectValue("lastname", "lastname.use", "Lastname should not be password");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("confirmpassword"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be confirmpassword");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("gender"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be gender");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("emailid"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be emailid");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("dateofbirth"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be dateofbirth");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("mobileno"))
					   {
						  errors.rejectValue("lastname", "middlename.use", "Lastname should not be mobileno");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("country"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be country");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("state"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be state");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("address"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be address");
					   }
					  else if(lastName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("pincode"))
					   {
						  errors.rejectValue("lastname", "lastname.use", "Lastname should not be pincode");
					   }
					  
					  
					  
					          else if(!lastName.matches("^[A-Za-z]+$"))
					          {
					        	  errors.rejectValue("lastname","lastname.requiredlast", "Lastname  should contain only alphabets'.");
					          }
					          else if(lastName.equals(firstName))
					          {
					        	  errors.rejectValue("lastname","lastname.requiredlast", "Lastname should not match with  Firstname.");
					          }
					          else if(lastName.equals(middleName))
					          {
					        	  errors.rejectValue("lastname","lastname.requiredlast", "Lastname should not match with  Middlename.");
					          }
					          else   if(lastName.length()<2 ||lastName.length()>30 )
					          {
					        	  errors.rejectValue("lastname","lastname.requiredlast", "Lastname length is minimum 2 maximum 30.");
					          }	
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					  /* //------------------UserName---------------------------------
						
						
					  userName=userName.trim().replaceAll(" ","");
			  		   	//   firstname= StringUtils.capitalize(firstname);
			    	  	// username=WordUtils.capitalizeFully(username);
			  		  rb.setUsername(userName);
			  		    System.out.println("Username is "+userName);
			        
			       if(userName.equalsIgnoreCase(null)||userName.length()<1||userName.trim().equals(""))
			          {
			        	  errors.rejectValue("Username","username.requireduser", "Username is Required.");
			          }
			        
			       else if(userName.length()<6 ||userName.length()>30 )
			       {
			     	  errors.rejectValue("Username","username.requireduser", "Username length is minimum 6 maximum 30.");
			       }
			    
			      
			       
			       
			       else if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
				   {
					errors.rejectValue("Username", "username.fir", "Username should not be firstname");
				   }
			       
			       else if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
				   {
					  errors.rejectValue("Username", "username.mid", "Username should not be middlename");
				   }
				  else if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
				   {
					  errors.rejectValue("Username","username.las", "Username should not be lastname");
				   }
			       
				  else  if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
				   {
					  errors.rejectValue("Username", "username.use", "Username should not be password");
				   }
			       
				  else  if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(firstName))
				   {
					  errors.rejectValue("Username", "username.use", "Username should not be firstname");
				   }
				
				  else  if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(middleName))
				   {
					  errors.rejectValue("Username", "username.use", "Username should not be middlename");
				   }
			       
				  else  if(userName.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(lastName))
				   {
					  errors.rejectValue("Username", "username.use", "Username should not be lastname");
				   }
			       
				  else if(!userName.matches("^[A-Za-z]+[A-Za-z0-9]+$"))
		          {
		        	  errors.rejectValue("Username","username.required", "Username should be Alphabets or Alphabets followed by digits only");
		          }
			       
			          else if(userName.matches("^[A-Za-z]+[0-9]+[a-zA-Z]+$")||userName.matches("^[A-Za-z]+[0-9]+[a-zA-Z]+[0-9]+$")||userName.matches("^[A-Za-z]+[0-9]+[a-zA-Z]+[0-9]+[a-zA-Z]+$"))
			          {
			        	  errors.rejectValue("Username","username.required", "Username should be Alphabets or Alphabets followed by digits only");
			          }
			          else
			          {
			       try
			       {
			       
			       
			      
			        if(userName.toLowerCase().substring(0,3).equals(firstName.toLowerCase().substring(0,3)))
			       {
			     	  errors.rejectValue("Username","username.use", "Username First 3 Letters not match with Firstname'.");
			       }
			      
			       
				   if(userName.toLowerCase().substring(0,3).equals(middleName.toLowerCase().substring(0,3)))
			       {
			     	  errors.rejectValue("Username","username.use", "Username First 3 Letters not match with middlename'.");
			       }
			      
			    
			        if(userName.toLowerCase().substring(0,3).equals(lastName.toLowerCase().substring(0,3)))
			       {
			     	  errors.rejectValue("Username","username.use", "Username First 3 Letters not match with lastname'.");
			       }
			       
			        if(userName.replaceAll("\\s+", "").substring(0, 8).toLowerCase().equalsIgnoreCase("username"))
					   {
						  errors.rejectValue("Username", "username.use", "Username should not be username");
					   }
				     
				      
			       
			       
			       
			       
			       }catch(Exception e)
			          {
			          	System.out.println("username issss"+e);
			          }
					  
			          }
			       
			       */
			       
			       
			     //......................username................................	
			   	String username=rb.getUsername();
				username=username.replaceAll(" ", "");
				String us=WordUtils.capitalizeFully(username);
				System.out.println("un ctpl..."+us);
				rb.setUsername(username);
				if(username == null ||username .trim().equals("")){
					errors.rejectValue("username","errors.username.required","Username is required");
				}
         else if(username .substring(0,1).matches("^[0-9]")){
					
					errors.rejectValue("username","errors.username.start","Username starts with alphabets");
				}
				else if(username .length()<6||username .length()>30){
					errors.rejectValue("username","errors.username.length","Username must be minimum length 6 and maximum 30");
				}
				
			       else if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
				   {
					errors.rejectValue("username", "username.fir", "Username should not be firstname");
				   }
			       
			       else if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
				   {
					  errors.rejectValue("username", "username.mid", "Username should not be middlename");
				   }
				  else if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
				   {
					  errors.rejectValue("username","username.las", "Username should not be lastname");
				   }
				
				
				  else  if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
				   {
					  errors.rejectValue("username", "username.use", "Username should not be password");
				   }
			       
				  else  if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(firstName))
				   {
					  errors.rejectValue("username", "username.use", "Username should not be firstname");
				   }
				
				  else  if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(middleName))
				   {
					  errors.rejectValue("username", "username.use", "Username should not be middlename");
				   }
			       
				  else  if(username.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase(lastName))
				   {
					  errors.rejectValue("username", "username.use", "Username should not be lastname");
				   }
				
				else if(!(username .matches("^[a-zA-Z]+[0-9]+$")||(username.matches("^[a-zA-Z]+$")))){
					errors.rejectValue("username","errors.username.match","Username should be alphabets followed by digits(Ex:abc123/abc)");
				}
				
				
				else if(username.toLowerCase().contains("firstname")|username.toLowerCase().contains("middlename")|username.toLowerCase().contains("lastname")){
					
					errors.rejectValue("username","errors.username.equalss","Username should not entered as firstname or lastname or middlename");
				}	
				else if(username.toLowerCase().contains("username")){
					errors.rejectValue("username","errors.username.equalss","Username should not entered as Username");
				}
				
				
				else 
				{
					try{
						  
				        if(username.toLowerCase().substring(0,3).equals(firstName.toLowerCase().substring(0,3)))
				       {
				     	  errors.rejectValue("username","username.use", "Username First 3 Letters not match with Firstname'.");
				       }
				      
				       
					   if(username.toLowerCase().substring(0,3).equals(middleName.toLowerCase().substring(0,3)))
				       {
				     	  errors.rejectValue("username","username.use", "Username First 3 Letters not match with middlename'.");
				       }
				      
				    
				        if(username.toLowerCase().substring(0,3).equals(lastName.toLowerCase().substring(0,3)))
				       {
				     	  errors.rejectValue("username","username.use", "Username First 3 Letters not match with lastname'.");
				       }
				       
				        if(username.replaceAll("\\s+", "").substring(0, 8).toLowerCase().equalsIgnoreCase("username"))
						   {
							  errors.rejectValue("username", "username.use", "Username should not be username");
						   }
					}
					catch(Exception e){
						 
					}
				}
	      
		     	//----------------------Password--------------------------------
			
			
					  
					  
					  
					  
					  try
					  {
					
					      password=password.trim().replaceAll(" ","");
							   //   firstname= StringUtils.capitalize(firstname);
							    // firstname=WordUtils.capitalizeFully(firstname);
						  rb.setPassword(password);
						  	System.out.println("Password is "+password);
					    
							 String pl=password.toLowerCase();
					      
						if(password.equalsIgnoreCase(null)||password.length()<1||password.trim().equals(""))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password is Required.");
					      }
					    
					     
						
					      else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("username"))
						   {
							 errors.rejectValue("password", "username.use", "Password should not be username");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be firstname");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be middlename");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be lastname");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be password");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("confirmpassword"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be confirmpassword");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("gender"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be gender");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("emailid"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be emailid");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("dateofbirth"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be dateofbirth");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("country"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be country");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("state"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be state");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be city");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("address"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be address");
						   }
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("pincode"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be pincode");
						   }
						   
						   else if(password.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("mobileno"))
						   {
							   errors.rejectValue("password", "username.use", "Password should not be mobileno");
						   }
						   
						
					      else  if(password.length()<6 ||password.length()>24 )
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password length is minimum 6 maximum 24.");
					      }
					      else if((password.endsWith("@")) || (password.endsWith("#")) || (password.endsWith("$")) || (password.endsWith("&")) || (password.endsWith(".")) || (password.endsWith("_")))
					 	 	{
					    	  errors.rejectValue("password","password.requiredpass", "Password not end with special characters.");
					 	 	}
					      else if(!password.matches("^[A-Za-z0-9]+[@_.]+[0-9]+$"))
							{
							   errors.rejectValue("password","password.requiredpass", "Password invalid (ex:Abc@123) and it allow special characters @._ only");
							}
					      else if(!password.matches("^(?!.*?[.@_]{2})[a-z A-Z0-9_.,@)(-]+$"))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Consecutive special characters are not allowed.");
					      }
					     
					      else if(!password.matches("^[A-Z0-9@_.]+[a-z]+[A-Za-z0-9@_.]+$"))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password Should contain atleast one lowercase.");
					      }
					      else if(!password.matches("^[A-Za-z@_.]+[0-9]+[A-Za-z0-9@_.]+$"))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password should contain atleast one digit.");
					      }
						 
					      else if(pl.substring(0, 2).equals(firstName.substring(0, 2).toLowerCase()))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password first 3 letters should not match with firstname.");
					      }
					      else if(pl.substring(0, 2).equals(middleName.substring(0, 2).toLowerCase()))
					  {
						  errors.rejectValue("password","password.requiredpass", "Password first 3 letters should not match with middlename.");
					  }
					  else  if(pl.substring(0,2).equals(lastName.substring(0, 2).toLowerCase()))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password first 3 letters should not match with lastname.");
					      }
					  else  if(pl.substring(0,2).equals(userName.substring(0, 2).toLowerCase()))
					      {
					    	  errors.rejectValue("password","password.requiredpass", "Password first 3 letters should not match with username.");
					      }
					  


					      
					      }catch(Exception e)
					      {
					      	System.out.println(e);
					      }			  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
			
			
			//------------------------ConformPassword----------------------------
					  
					  
					  
					  
					  
					  
					  
					  try{
						  conformPassword=conformPassword.trim().replaceAll(" ","");
							   //   firstname= StringUtils.capitalize(firstname);
							    // firstname=WordUtils.capitalizeFully(firstname);
					      rb.setConformpassword(conformPassword);
						   System.out.println("Confirm Password is "+conformPassword);
					      
					      if(conformPassword.equalsIgnoreCase(null)||conformPassword.length()<1||conformPassword.trim().equals(""))
					      {
					    	  errors.rejectValue("conformpassword","password.requiredpass", "ConfirmPassword is Required.");
					      }
					      else if(!conformPassword.equals(password))
					      {
					    	  errors.rejectValue("conformpassword","password.requiredpass", "Confirmpassword should match with password.");
					      }
					      else  if(conformPassword.length()<6 ||conformPassword.length()>24 )
					      {
					    	  errors.rejectValue("conformpassword","confirmpassword.requiredpass", "confirmpassword length is minimum 6 maximum 24.");
					      }
					      else if(!conformPassword.matches("^[A-Za-z0-9]+[@_.]+[A-Za-z0-9]+$"))
							{
					  	  errors.rejectValue("conformpassword","confirmpassword.requiredpass", "confirmpassword required like Abcd@123 ");
							}
					      }catch(Exception e)
					      {
					      	System.out.println(e);
					      }
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
					  
	

      
      //----------------------------PhoneNumber---------------------------------------
					  
					  
					  
					  phoneNumber=phoneNumber.trim().replaceAll(" ","");
				      rb.setMobileno(phoneNumber);
				      	System.out.println("Mobile Number is "+phoneNumber);
						   //   firstname= StringUtils.capitalize(firstname);
						   //  phone=WordUtils.capitalizeFully(phone);
				       
				       if(phoneNumber.equalsIgnoreCase(null)||phoneNumber.length()<1||phoneNumber.trim().equals(""))
				       {
				     	  errors.rejectValue("mobileno","mobileno.requiredphone", "Mobile Number is Required.");
				       }
				       else if(!phoneNumber.matches("^[0-9]+$"))
				       {
				     	  errors.rejectValue("mobileno","mobileno.requiredphone", "Mobile Number Should contain only digits.");
				       }
				      
				       else  if(phoneNumber.length()<8 ||phoneNumber.length()>15 )
				       {
				     	  errors.rejectValue("mobileno","mobileno.requiredphone", "Mobile Number length is minimum 8 maximum 15.");
				       }
				      
				       else if(phoneNumber.length()>5)
				 	  {
				 	  String j1 = phoneNumber.substring(0,5);
				 	  if(j1.equals("00000"))
				       {
				     	  errors.rejectValue("mobileno","mobileno.requiredphone", "Mobile Number First Five Zeroes are not allowed");
				       }
				 	  }	  
					  
					  
					  
					  
					  
					  
	
				//---------------------------EmailId----------------------------------
			  
			  
	    	  
		    	 email=email.trim().replaceAll(" ","");
		    
		    	   
		    		if(email == null||email.trim().equals("")){
		    			errors.rejectValue("email","errors.emailid.required","Email Id is required");
		    		}
		    		else if(email.length()<12||email.length()>70){
		    			errors.rejectValue("email","errors.emailid.length","Email-id minimum length 12 or max 70 ");
		    		}
		    		 
		    	
		    		else if(!email.matches("^(?!.*?[@._]{2})[a-zA-Z0-9@._]+$")){
		    			errors.rejectValue("email","errors.emailid.special","Email-id don't allow special characters consecutive");
		    		}
		    		
		    		 else if(!email.matches("[a-zA-Z]{1,}[a-zA-Z0-9._@]{1,}$")){
		    	     		errors.rejectValue("email", "email","Email-id should start with alphabets");
		    	     	 }
		    		
		    		else if(!email.matches("^[A-Za-z._0-9]+[@]+[a-zA-Z]+[.]+[a-zA-Z.]+$")){
		    			errors.rejectValue("email","errors.emailid.match","Enter valid Email-id (ex:abcd@gmail.com)");
		    		}
		    	
		    		
		    		
		    		
		    		else if(email.toLowerCase().contains("emailid")||email.toLowerCase().contains("email")){
		    			errors.rejectValue("email","errors.emailid.mat","Email-id should not entered as email or emailid");

		    		 }
		    		   else if((email.endsWith("@")) || (email.endsWith("#")) || (email.endsWith("$")) || (email.endsWith("&")) || (email.endsWith(".")) || (email.endsWith("_")))
		    			 {
		    	   	  errors.rejectValue("email","emailid.requiredemail", "Emailid not end with special characters.");
		    			 }
		    	   		
		    		
		    		else{
		    			   try{
		    			   final String[] e1=email.split("@");
		    	 	   String e11=e1[0];
		    	 	   String e12=e1[1];
		    	 	
		    	 	  if(e1[0].length()<6||e1[0].length()>30){
		    				errors.rejectValue("email","errors.emailid.actlngth","Email-id account name length minimum 6 and maximum 30");
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
		    					errors.rejectValue("email","errors.emailid.samedomainmame","Email-id address name or domain name should not be same");
		    	 		   }
		    	 		 else if(e11.matches(em12)){
		    					errors.rejectValue("email","errors.emailid.sameservmame","Email-id address name or service name should not be same");
		    	 		  }
		    	 		  else if(em11.equals(em12)){
		    					errors.rejectValue("email","errors.emailid.domservmame","Email-id domain name or service name should not be same");

		    	 		  }
		    	 		 else if(em1[0].length()<2||em1[0].length()>30){
		    					errors.rejectValue("email","errors.emailid.domainnamelgth1","Email-id domain name length minimum 2 and maximum 30");
		    	  		 }
		    	 		 else if(em1[1].length()<2||em1[1].length()>4){
		    					errors.rejectValue("email","errors.emailid.domainnamelgth2","Email-id service name length minimum 2 and maximum 4");
		    	 		 }
		    	 		else if(em1[2].length()<2||em1[2].length()>4){
		    				errors.rejectValue("email","errors.emailid.domainnamelgth2","Email-id second service name minimum 2 and maximum 4");
		    			 }
		    	 		  
		    	 		
		    	 		 else if(em1[2].toLowerCase().equals(e11.toLowerCase())){
		    					errors.rejectValue("email","errors.emailid.sameservmame1","Email-id address name or service name should not be same");

		    				 }
		    				 else if(em1[2].toLowerCase().equals(em11.toLowerCase())){
		    					errors.rejectValue("email","errors.emailid.domservmame1","Email-id domain name or service name should not be same");

		    				 }		
		    	 		 
		    	 		 else if(esl<2||esl>3){
		    					errors.rejectValue("email","errors.emailid.domainnamelgth4","Email-id invalid service name");

		    	 		 }
		    	 		
		    	 		 else if(em1[1].toLowerCase().equals("com")&&em1[2].toLowerCase().equals("in")){
		    					errors.rejectValue("email","errors.emailid.domservmamew","Enter valid service name");
		    	 				
		    	 		  }
		    	 		 else if(em1[1].toLowerCase().equals(em1[2])){
		    					errors.rejectValue("email","errors.emailid.domservmamewsam","Emailid Service Names Shouldn't be Same.");

		    	 		 }
		    	 		 
		    	 	   }
		    			   }
		    			   catch(Exception e){

		    		   }}

		
		    		 //.................dateofbirth.................
		    		String dob=rb.getDateofbirth();
					if(dob==null||dob.trim().equals("")){
						errors.rejectValue("dateofbirth","errors.dateofbirth.required","Date Of Birth is required");
					}	
					
					else
					{	 
						 try
						 {
						  DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						   //get current date time with Date()
						   Date date = new Date();
						  // System.out.println(date);
						   int  yr=date.getYear()+1900;
					     	 int mm=date.getMonth()+1;
					     	 int dd=date.getDate();
							   /*System.out.println("year..."+yr);
							   System.out.println("momth.."+mm);
							   System.out.println("date..."+dd);*/

					     	 
					     	String[] s = dob.split("/");
					     	
					     	int mth = Integer.parseInt(s[0]);
					     	int dat = Integer.parseInt(s[1]);
					     	int yrr = Integer.parseInt(s[2]);
					     	
					     	/*System.out.println("ctn year..."+yrr);
							   System.out.println(" ctn momth.."+mth);
							   System.out.println("ctn date..."+dat);*/
					     	
					     	
					     	
					     	int  ny=yr-yrr;
					     	int nm=mm-mth;
					     	int nd=dd-dat;
					     	if ((ny ==0 && nm == 0 && nd < 0)||(ny==0 && nm<0 && nd<=nd) || ny< 0)
					     	{
					     		errors.rejectValue("dateofbirth", "errors.dateofbirth.feature", " Future date is not allowed.");
					           
					        }
					     	else if((yr==yrr)&&(mm==mth)&&(dd==dat)){
					     		errors.rejectValue("dateofbirth", "errors.dateofbirth.curreent", "Current date not allowed");

					     	}
					     	else if ((ny == 18 && nm == 0 && nd < 0)||(ny==18 && nm<0 && nd<=nd) || ny< 18) 
					     	{
					     		errors.rejectValue("dateofbirth", "errors.dateofbirth.below", "Age must be greater than 18 years.");
					        }
					     	
					     	
					      }
					      catch(Exception e)
					      {
					    	  System.out.println(e);
					      }
					}
					
					
	    	//-------------------------Gender-------------------------------------
			 
			
	    	 if(gender==null||gender.trim().equals(""))
		 		{
		 			
		 			errors.rejectValue("gender","errors.gender.required","Gender is required");		
		 			
		 		}
	    	 
	    
	    	  /*COUNTRY VALIDATION*/
		    	
			 if(country.equals("") || country==null )
				{
					
			errors.rejectValue("country", "errors.country.required","Country is required");		
				
				}
					
				/*	STATE*/
				 if(state.equals("")||state==null)
			
				{
					
			errors.rejectValue("state", "errors.state.required","State is required");
			
				
				}
			    
		      //----------------------------City------------------------------------
				
					city=city.trim();
					city=city.replaceAll(" ", "");
					city=WordUtils.capitalizeFully(city);
					rb.setCity(city);
				 
				 
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
					else 
					{
					try{
						/*if(username.contains(lastname)||username.contains(middlename)||username.contains(firstname)){
							errors.rejectValue("username","errors.username.equal","Username should not be same as Firstname or Middlename or Lastname");
						}*/
						 
				   if(city.equalsIgnoreCase(firstName)){
					errors.rejectValue("city","errors.city.lowerf","City not match with Firstname");
			    	}
				   else if(city.equalsIgnoreCase(middleName)){
					errors.rejectValue("city","errors.city.lowerm","City not match with Middlename");
				   }
				   else if(city.equalsIgnoreCase(lastName)){
					errors.rejectValue("city","errors.city.lowerl","City not match with Lastname");
				}
					}
					catch(Exception e){
						e.printStackTrace();
					}
					}
				 
				 
				 
				 
				 
		       /* city=WordUtils.capitalizeFully(city).replace("  ", "");
		        rb.setCity(city);
		        String regexpcty="^[A-Za-z]+$";
		        
		        
		        
		 if( city==null||city.trim().equals(""))
			{
				errors.rejectValue("city", "errors.required.cty","City is required.");
			}
	        else if( city.length()<6||  city.length()>30)
			{
				errors.rejectValue("city", "errors.length.cty","City length is minimum 3 maximum 30.");
			}
			else if(! city.matches(regexpcty))
			{
				errors.rejectValue("city", "errors.regexp.cty","City should be alphabets only.");
			}
			
*/
//---------------------------address---------
		 
		 
					
					
					
					
					
					 address=address.trim().replaceAll("\\s+"," ");
					   //   firstname= StringUtils.capitalize(firstname);
					   //   address=WordUtils.capitalizeFully(address);
			        rb.setAddress(address);
			        System.out.println("address is "+address);
						
			        		if(address.isEmpty())
							{
								errors.rejectValue("address","address.required", "Address is Required.");
							}
							
							
							
							/*else if(!address.matches("^(?!.*?[ ]{2})[a-z A-Z0-9_.,@)(-]+$"))
							{
								errors.rejectValue("address","address.required", "Consecutive Characters are not Allowed in Address");
							}*/
							 else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("firstname"))
			  			   {
			  		    	errors.rejectValue("address", "address.fir", "Address should not be firstname");
			  			   }
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("middlename"))
			  			   {
			  				  errors.rejectValue("address", "address.mid", "Address should not be middlename");
			  			   }
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("lastname"))
			  			   {
			  				  errors.rejectValue("address","address.las", "Address should not be lastname");
			  			   }
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("username"))
			  			   {
			  				  errors.rejectValue("address", "address.use", "Address should not be username");
			  			   }
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
			  			   {
			  				  errors.rejectValue("address", "address.use", "Address should not be city");
			  			   }
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("password"))
			  			   {
			  				  errors.rejectValue("address", "address.use", "Address should not be password");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("confirmpassword"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be confirmpassword");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("gender"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be gender");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("emailid"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be emailid");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("dateofbirth"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be dateofbirth");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("country"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be country");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("state"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be state");
			  			   }
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be city");
			  			   }
			  			  
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("pincode"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be pincode");
			  			   }
			  			   
			  			   else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("address"))
			  			   {
			  				   errors.rejectValue("address", "address.use", "Address should not be address");
			  			   }
			  			 else if(address.length()<4 || rb.getAddress().length()>100)
							{
								errors.rejectValue("address", "address.requried" , "Address length is minimum 4 and maximum 100.");
							}
			  			
					   
			  			  else if(!address.matches("^[0-9a-zA-Z-/_@.,)( \n]+$"))
						   {
								errors.rejectValue("address","errors.address.match","Enter valid address it allow special characters -/_@.,)( only");
						   }
			  			  else if((address.endsWith("@")) || (address.endsWith("#")) || (address.endsWith("$")) || (address.endsWith("&")) ||(address.endsWith("_")) || (address.endsWith(",")) || (address.endsWith(".")) || (address.endsWith("!")) || (address.endsWith("?")))
			  			  {
			  				  errors.rejectValue("address","address.required", "Address not end with special characters.");
			  			  }
						   else if (!address.matches("^(?!.*?[:.,/ _-]{2})[a-zA-Z0-9 :.,/_-]+$"))
						   {
								errors.rejectValue("address","errors.address.special","Address don't allow consecutive special characters ");
						   }
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
				/*	address=address.trim();
					//address = address.replaceAll("  "," ");
					rb.setAddress(address);
					
					
					
					if(address==null||address.trim().equals("")){
						errors.rejectValue("address","errors.address.required","Address is required");
					}
					else if(!address.matches("^[0-9a-zA-Z-/_@.,)( \n]+$")){
						errors.rejectValue("address","errors.address.match","Enter valid address it allow special characters -/_@.,)( only");
					}
					else if(address.length()<4||address.length()>100){
						errors.rejectValue("address","errors.address.length","Address length must be minimum length 4 or max 100");
					}
					
		              
		              else {
		            	  try{
		            		  if(!address.substring(0, 1).matches("^[a-zA-Z]+$")){
		  						errors.rejectValue("address","errors.address.startltr","Address starts with alphabets only");
		  					}
		            		  else if(address.toLowerCase().equalsIgnoreCase("address")){
		  						errors.rejectValue("address","errors.address.same","Address should not entered as address");

		  					}
		            		  else if (!address.matches("^(?!.*?[:.,/ _-]{2})[a-zA-Z0-9 :.,/_-]+$")){
		  						errors.rejectValue("address","errors.address.special","Address don't allow special characters or consecutive spaces");
		  					}
		            		  else if(address.replaceAll(" ", "").toLowerCase().equals("address")){
		  						System.out.println("enter address...");
		    						errors.rejectValue("address","errors.address.same","Address should not entered as address");

		          		  }  
		            	  }
		            	  catch(Exception e){
		            		  
		            	  }
		              }	*/
					
					
					  //********************************  pincode validations starts*******************************************    
					
					
				    pincode=pincode.trim().replaceAll(" ","");
				       rb.setPincode(pincode);
				       System.out.println("Pincode is "+pincode);
				  	   	//   firstname= StringUtils.capitalize(firstname);
				  	 	//  pincode=WordUtils.capitalizeFully(pincode);
				        
				        if(pincode.equalsIgnoreCase(null)||pincode.length()<1||pincode.trim().equals(""))
				        {
				      	  errors.rejectValue("pincode","pincode.required", "Pincode is Required.");
				        }
				       
				        else if(!pincode.matches("^[0-9]+$"))
				        {
				      	  errors.rejectValue("pincode","pincode.required", "pincode contains only Numbers.");
				        }
				        else  if(pincode.length()<3 ||pincode.length()>8)
				        {
				      	  errors.rejectValue("pincode","pincode.required", " Pincode length is minimum 3 maximum 8.");
				        }
				        else if(pincode.equalsIgnoreCase("000"))
				    	{
				    		errors.rejectValue("pincode","pincode.required", "Pincode First Three Zeroes are not allowed");
				    	}
				    	else if(pincode.equalsIgnoreCase("0000"))
				    	{
				    		errors.rejectValue("pincode","pincode.required", "Pincode First Four Zeroes are not allowed");
				    	}
				        
				        else if(pincode.length()>=5)
						  {
				        	String pin = pincode.substring(0,5);
				        	if(pin.equals("00000"))
				        	{
				        		errors.rejectValue("pincode","pincode.required", "Pincode First Five Zeroes are not allowed");
				        	}
				        	
						  }	
					
					
				        //-------------------------Language----------------------------------
					
					
				        rb.setLanguage(language);
						 if( language==null||language.trim().equals(""))
				        {
							 System.out.println("in language");
				        	errors.rejectValue("language", "errors.required.lan","Language is required.");
				        	 System.out.println("in language");
				        }
					
					
					
					
					
					
	}
   }
					
					
					
					
					
					
					
		 
	/*	 address=address.replace("  ", "");
	        rb.setAddress(address);
			String regexpadd="^[a-zA-Z]+[0-9.,-/_@()a-zA-Z\n ]+$";
			boolean add=false;
			String regadd="^[().,-/@ ]+$";
	        for(int i=0;i<address.length()-1;i++)
			  {
		     char aa=address.charAt(i);
		     String aa1 = Character.toString(aa);
		     char bb=address.charAt(i+1);
				String bb1=Character.toString(bb);
				if(aa1.matches(regadd)&&bb1.matches(regadd))
				{
					
					add=true;
					break;
					
				}
	     	  }
	       
		 
		 
		 

	   	 
			 if( address.equals("null")||address.trim().equals(""))
					{
						 System.out.println(" in address");
						errors.rejectValue("address", "errors.required.add","Address is required.");
						System.out.println(" in address");
					}
			        else if( address.length()<4|| address.length()>100)
					{
						errors.rejectValue("address", "errors.length.add","Address length is  minimum 4 maximum 100.");
					}
					else if(!address.matches(regexpadd))
					{
						errors.rejectValue("address", "errors.regexp.add","Address should be alphabets followed by digits/special characters only,should not allow special characters other then[.,()-/_@] .");
					}
					else if(add==true)
					{
						errors.rejectValue("address","errors.repeat.add","consecutive special characters are not allowed[().,-/@ ].");
					}
				
			*/
				
				
				
		 /*PINCODE*/
			
		/*if(pincode == null||pincode.trim().equals(""))
		{
			
	errors.rejectValue("pincode", "errors.pin.required","Pincode is required");		
		
		}
			
		else if(!(pincode.matches("^[A-Za-z0-9]+$")))	
		{
			
	errors.rejectValue("pincode", "errors.pin.regexpress","Pin code number should be numbers or alphanumeric and not allow any special characters");	
			
		}	
			
			
		else if(pincode.length()<1||pincode.length()>15)		
		{
			
			errors.rejectValue("pincode", "errors.pin.length","The Pin code length should be between 1 to 15");	
		}
					 //-------------------------Language----------------------------------
					//rb.setLanguage(language);
					 if( language==null||language.trim().equals(""))
			        {
						 System.out.println("in language");
			        	errors.rejectValue("language", "errors.required.lan","Language is required.");
			        	 System.out.println("in language");
			        }
					
					
		
			
			
	}

	
	}
*/