package com.sales.agent.validator;

import java.util.List;

import org.apache.commons.lang.WordUtils;
import org.apache.taglibs.standard.lang.jstl.NotEqualsOperator;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;









import org.springframework.web.multipart.MultipartFile;

import com.sales.agent.bean.PropertyBean;


	public class PropertyValidation implements Validator{

		public boolean supports(Class<?> clazz) {
			return PropertyBean.class.isAssignableFrom(clazz);
		}

		public void validate(Object target, Errors errors) {
			
			PropertyBean r=(PropertyBean)target;
			
			 String phoneNumber=r.getMobileno();
		    
		   
		    
		   
		     String city=r.getCity();
		     String address=r.getAddress();
		     
		    
		     String pincode=r.getPincode();
			 /*COUNTRY VALIDATION*/
			 String country=r.getCountry();
			 if(country.equals("") || country==null )
				{
					
			errors.rejectValue("country", "errors.country.required","Country is required");		
				
				}
					
				/*	STATE*/
		     String state=r.getState();

				 if(state.equals("")||state==null)
			
				{
					
			errors.rejectValue("state", "errors.state.required","State is required");
			
				
				}	
				 
				 /*	property type*/
			     String propertytype=r.getPropertytype();
System.out.println("properttype isss"+propertytype);
					 if(propertytype.equals("")||propertytype==null)
				
					{
						
				errors.rejectValue("propertytype", "errors.propertytype.required","Propertytype is required");
				
					
					}	
					 
					 
					 /*	upload image*/
				     String file=r.getFilepath();
						String imgsize=r.getImagesize();

System.out.println("image path issss"+r.getFile()!=null && r.getFile().isEmpty());
if(r.getFile().size() == 0)
{	System.out.println("gfasdfajsfgfg");
errors.rejectValue("file", "file.required", "File Image is requird");
}    
						
						

						
						
					//plot area
						 String plot=r.getPlotarea();
						  
						  plot=plot.trim().replaceAll(" ","");
						r.setPlotarea(plot);
						
						  if(plot.equalsIgnoreCase(null)||plot.length()<1||plot.trim().equals(""))
					       {
					     	  errors.rejectValue("plotarea","plot.requiredplot", "Plotarea is Required.");
					       }
						  
						  else  if(plot.length()<1 ||plot.length()>10000 )
					       {
					     	  errors.rejectValue("plotarea","plot.requiredplot", "Plotarea length is minimum 10 maximum 10000.");
					       }
						  else if(plot.equalsIgnoreCase("00000"))
					    	{
					    		errors.rejectValue("plotarea","plot.required", "Plotarea First Five Zeroes are not allowed");
					    	}
						  
						  else if(plot.equalsIgnoreCase("0000"))
					    	{
					    		errors.rejectValue("plotarea","plot.requiredplot", "Plotarea First Four Zeroes are not allowed");
					    	}
						  
						  else if(!plot.matches("^[0-9]+[sq]+[.]+[ft]+$"))
					       {
					     	  errors.rejectValue("plotarea","plot.requiredplot", "Plotarea Should contain digits followed by squares and feets like As:-(4500sq.ft).");
					       }
						  
						  
						  //property price
							 String price=r.getPropertyprice();

							  price=price.trim().replaceAll(" ","");
								r.setPropertyprice(price);
								if(price.equalsIgnoreCase(null)||price.length()<1||price.trim().equals(""))
							       {
							     	  errors.rejectValue("propertyprice","price.requiredprice", "Propertyprice is Required.");
							       }
								 else  if(price.length()<2 ||price.length()>1000000000 )
							       {
							     	  errors.rejectValue("propertyprice","price.requiredprice", "Propertyprice length is minimum 1 maximum 1000000000.");
							       }
								
								 else if(price.equalsIgnoreCase("0000"))
							    	{
							    		errors.rejectValue("propertyprice","price.required", "Propertyprice First Four Zeroes are not allowed");
							    	}
								 else if(price.equalsIgnoreCase("00000"))
							    	{
							    		errors.rejectValue("propertyprice","price.required", "Propertyprice First Five Zeroes are not allowed");
							    	}
								
								 else if(!price.matches("^[0-9]+$"))
							       {
							     	  errors.rejectValue("propertyprice","price.requiredprice", "Propertyprice Should contain digits only.");
							       }
								
								
				   //----------------------------PhoneNumber---------------------------------------
				  
				  
				  
				  phoneNumber=phoneNumber.trim().replaceAll(" ","");
			      r.setMobileno(phoneNumber);
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
				  
							 	  
			       
			       //----------------------------City------------------------------------
					
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
					
					//---------------------------address---------
					 
					 
					
					
					
					
					
					 address=address.trim().replaceAll("\\s+"," ");
					   //   firstname= StringUtils.capitalize(firstname);
					   //   address=WordUtils.capitalizeFully(address);
			        r.setAddress(address);
			        System.out.println("address is "+address);
						
			        		if(address.isEmpty())
							{
								errors.rejectValue("address","address.required", "Address is Required.");
							}
							
							
							
							/*else if(!address.matches("^(?!.*?[ ]{2})[a-z A-Z0-9_.,@)(-]+$"))
							{
								errors.rejectValue("address","address.required", "Consecutive Characters are not Allowed in Address");
							}*/
							 
			  			  else if(address.replaceAll("\\s+", "").toLowerCase().equalsIgnoreCase("city"))
			  			   {
			  				  errors.rejectValue("address", "address.use", "Address should not be city");
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
			  			 else if(address.length()<4 || r.getAddress().length()>100)
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
					
					
					
					
					
			        		 //********************************  pincode validations starts*******************************************    
							
							
						    pincode=pincode.trim().replaceAll(" ","");
						       r.setPincode(pincode);
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
							
					
					
					
					
					
					
				  
}
}
		