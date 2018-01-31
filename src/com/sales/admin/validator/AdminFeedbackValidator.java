package com.sales.admin.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.sales.admin.bean.FeedBackBean;


	public class AdminFeedbackValidator implements Validator{

		public boolean supports(Class<?> clazz) {
			return FeedBackBean.class.isAssignableFrom(clazz);
		}

		public void validate(Object target, Errors errors) {
			
			FeedBackBean r=(FeedBackBean)target;
			String rply=r.getReply();
			if(rply == null||rply.trim().equals("")){
				errors.rejectValue("reply","errors.reply.required","Reply is required");
			}
			else if(rply.length()<4||rply.length()>100){
				errors.rejectValue("reply","errors.reply.length","Reply must be minimum length 4 or max 100 ");
		}
			else {
          	  try{
          		  if(!rply.substring(0, 1).matches("^[a-zA-Z]+$")){
						errors.rejectValue("reply","errors.reply.startltr","Reply starts with alphabets only");
					}
          		  else if(rply.toLowerCase().equalsIgnoreCase("reply")){
						errors.rejectValue("reply","errors.reply.same","Reply should not entered as reply");

					}
          		  else if (!rply.matches("^(?!.*?[:.,/ _-]{2})[a-zA-Z0-9 :.,/_-]+$")){
						errors.rejectValue("reply","errors.reply.special","Reply don't allow special characters or consecutive spaces");
					}
          		  else if(rply.replaceAll(" ", "").toLowerCase().equals("reply")){
  						errors.rejectValue("reply","errors.reply.same","Reply should not entered as reply");

        		  }  
          	  }
          	  catch(Exception e){
          		  
          	  }
            }	
}
}