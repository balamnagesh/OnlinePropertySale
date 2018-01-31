package com.sales.user.controller;




import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;





























import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;
















import org.apache.log4j.Logger;





























import com.sales.admin.model.AdminFeedBackModel;

import com.sales.agent.bean.AgentFeedback;
import com.sales.agent.bean.PropertyBean;
import com.sales.agent.model.PropertyModel;
import com.sales.agent.validator.Agentfeedbackvalidator;
import com.sales.home.bean.Registration;

import com.sales.home.model.RegistrationModel;
import com.sales.home.validator.RegistrationValidator;


import com.sales.user.service.ServiceUser;
import com.sales.user.validator.Changepasswordvalidator;





@Controller


public class UserController {
	
	
	@Autowired
	private ServiceUser serviceuser;
	
	
	private Logger log = Logger.getLogger(UserController.class);

	
	@RequestMapping(value = "/userhome", method = RequestMethod.GET)
	public ModelAndView welcome() {
    	System.out.println("userhome");
		return new ModelAndView("userhome");
	}
    
	// view feedback page 
	
	@RequestMapping(value = "/viewuserfeedback", method = RequestMethod.GET)
	public ModelAndView feedBack(@ModelAttribute("command")AgentFeedback reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		
		return new ModelAndView("viewuserfeedback");
	}
	
	
	// save user feed back
	
		@SuppressWarnings("unused")
		@RequestMapping(value = "/userfeedbacksave", method = RequestMethod.POST)
		public ModelAndView feedBackSuccess(@ModelAttribute("command")AgentFeedback reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
			
			
			HttpSession hs=request.getSession(false);
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("in session un"+username);
			System.out.println("in session pwd"+password);
			Agentfeedbackvalidator fv=new Agentfeedbackvalidator();
			fv.validate(reg,result);
			if(result.hasErrors())
	{
				return new ModelAndView("viewuserfeedback");	
				
			}
			else
			{
			AdminFeedBackModel feedback=new AdminFeedBackModel() ;
			List<RegistrationModel> li=serviceuser.loginlist(username,password);
			System.out.println("list for login------------------------"+li.size());
			
			String type=li.get(0).getType();
			
			
			String usernam=li.get(0).getUsername();
			
			String email=li.get(0).getEmail();
			String cit=li.get(0).getCity();
			DateFormat dff = new SimpleDateFormat("yyyy-dd-MM");
			System.out.println("dateformat"+dff);
			Date date = new Date();
			System.out.println("date isssss"+date);
			String d=dff.format(date);
			System.out.println("string dateeeee"+d);
			
			
			String comments=reg.getComments();
		feedback.setUsername(usernam);
			feedback.setStatus("pending");
			feedback.setType(type);
			feedback.setDate(d);
		
			feedback.setEmail(email);
			feedback.setComments(comments);
			BeanUtils.copyProperties(reg,feedback);
			serviceuser.adduserfeedback(feedback);
			}
		
			
			
			
			
		return new ModelAndView("feedbacksuccess1");
	
		}
	
	
	
	//user update profile page
	@RequestMapping(value = "/userupdateprofile", method = RequestMethod.GET)
	public ModelAndView updateProfile(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		try
		{
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("in session un"+username);
		System.out.println("in session pwd"+password);
		RegistrationModel rm=null;
		List<RegistrationModel> li=serviceuser.loginlist(username,password);
		System.out.println("list for login..."+li.size());
		String i=li.get(0).getId();
		String st=li.get(0).getStatus();
		String tp=li.get(0).getType();
		String rg=li.get(0).getRegisterdate();
		System.out.println("regdate..."+rg);
		reg.setId(i);
		reg.setStatus(st);
		reg.setType(tp);
		reg.setRegisterdate(rg);
		System.out.println("id....in adminprofile"+i);
	
for (Iterator<RegistrationModel> iterator = li.iterator(); iterator.hasNext();) {
			rm = (RegistrationModel) iterator.next();
			System.out.println(rm.getId());
			System.out.println(rm.getRegisterdate());

		}
		System.out.println(reg.getId());
		System.out.println(reg.getRegisterdate());
		//rm.setRegisterdate(rg);
		BeanUtils.copyProperties(reg,rm);
		}
		catch(Exception e)
		{
			log.error("Online Property Sales::UserController ::userupdateprofile",e);
		}
		return new ModelAndView("userupdateprofile1");
	}
	
	
	
	

	
	
	
	
	@RequestMapping(value = "/userupdateprofilesucc", method = RequestMethod.POST)
	public ModelAndView updateProfileSuccess(@ModelAttribute("command")Registration reg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
		try
		{
		RegistrationModel rm=new RegistrationModel();
		System.out.println("The registration model is "+rm);
		
		
		
		RegistrationValidator r=new RegistrationValidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			
			return new ModelAndView("userupdateprofile1");
		}
		
		
		BeanUtils.copyProperties(rm, reg);
		
		System.out.println(reg.getId());
		System.out.println(reg.getRegisterdate());
		
			
	
	
		serviceuser.updateuserprofile(rm);
		}
		catch(Exception e)
		{
			log.error("Online Property Sales::UserController ::userupdateprofilesucc",e);
		}
		
			
			return new ModelAndView("userupdateprofilesucc1");
		}
		
	
	
	
		
		//view property
		
		@RequestMapping(value = "/propertyview", method = RequestMethod.GET)
		public ModelAndView viewAgents(@ModelAttribute("command")PropertyBean reg, BindingResult result) {
			System.out.println("view property");
			
			return new ModelAndView("propertyview");
			
			}
		
		
		//user property Details view 
		@RequestMapping(value="/userpropertylist", method = RequestMethod.GET)
		public void usersGrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
			System.out.println("enter property list grid..");
			PrintWriter out=null;
			out=response.getWriter();
			
			System.out.println("enter into datagrid property  list");
			List<PropertyModel> li=serviceuser.getallproperties();
			System.out.println("list size is: "+li.size());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"li"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(li,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
			//return array;
			}
		
		//user property refresh
		@RequestMapping(value="/userpropertyrefresh", method = RequestMethod.GET)
		public void agentRefresh(@ModelAttribute("command")PropertyBean sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
			System.out.println("enter property list grid..");
			PrintWriter out=null;
			out=response.getWriter();
			
			System.out.println("enter into datagrid property  list");
			List<PropertyModel> li=serviceuser.getallproperties();
			System.out.println("list size is: "+li.size());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"li"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(li,jsonConfig);
			System.out.println(array);
			out.print(array);
			out.flush();
		    out.close();
			//return array;
			}
		
		
		
		
		//user property grid date search
		
				@RequestMapping(value="/userpropertygrididserach", method = RequestMethod.GET)
				public void userPropertyGrid(@ModelAttribute("command") PropertyBean pr, 
						
					BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
				

						
						
						PrintWriter pw=null;
				    	pw=response.getWriter();
				    	String uname1=request.getParameter("value");
				    System.out.println("usernameeee"+uname1);
				    	HttpSession hs=request.getSession();
				    	
				    	
				    	String a[]=uname1.split("");
				    	String username=a[0].toUpperCase()+a[1].toLowerCase();
				    	System.out.println("username0000000000"+username);
				    	
				    	
				    	hs.setAttribute("user", username);
				    	System.out.println("before");
				    	/*String username=uname1.toLowerCase();*/
				    	List<PropertyModel> li=serviceuser.searchagentusername(username);
				    	System.out.println(li.size());
				    	JsonConfig jsonConfig = new JsonConfig();
						jsonConfig.setExcludes(new String[]{"li"});
						jsonConfig.setIgnoreDefaultExcludes(false);
						jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
						JSONArray array = JSONArray.fromObject(li,jsonConfig);
						System.out.println(array);
						pw.print(array);
						 pw.flush();
					     pw.close();
						
					
					}
				
				
				
		
		
		
		
		
			// user property grid date
			@SuppressWarnings("rawtypes")
			@RequestMapping(value="/userpropertygriddate", method = RequestMethod.GET)
			public void agentPropertyGridDate(@ModelAttribute("command") PropertyBean dd, 
						BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException{
				
			PrintWriter out=null;
			out=response.getWriter();
				System.out.println("enter into date list");
				
				String fromm=request.getParameter("from");
				System.out.println("date from isssssssssssss"+fromm);
				String[] sd = fromm.split("/");
				
				String from = sd[2]+"-"+sd[1]+"-"+sd[0];
				System.out.println(from);
				String to=request.getParameter("to");
				System.out.println("date to isssssssssssss"+to);
				String[] ts = to.split("/");
				
				String t = ts[2]+"-"+ts[1]+"-"+ts[0];
				System.out.println(t);
				List l=serviceuser.agentGriddateSearch(from,t);
			 System.out.println("list size in date is"+l.size());
			    
							JsonConfig jsonConfig = new JsonConfig();
							jsonConfig.setExcludes(new String[]{"l"});
							jsonConfig.setIgnoreDefaultExcludes(false);
							jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
							JSONArray array = JSONArray.fromObject(l,jsonConfig);
							//System.out.println(array);
							out.print(array);
							 out.flush();
						     out.close();
		}
		
			
			// Change Password
			
				@RequestMapping(value = "/userchangepassword", method = RequestMethod.GET)
				public ModelAndView changePassword(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
					try
					{
					HttpSession hs=request.getSession(false);
					String username=(String) hs.getAttribute("username");
					String password=(String) hs.getAttribute("password");
					System.out.println("username...."+username);
					System.out.println("password....."+password);
					List<RegistrationModel> li=serviceuser.loginlist(username, password);
					System.out.println(li.size());
					}
					catch(Exception e)
					{
						log.error("Online Property Sales::UserController ::userchangepassword",e);
					}
					
					return new ModelAndView("userchangepassword1");
				}
		
		
		// Change Password success
		
		@SuppressWarnings("unused")
		@RequestMapping(value = "/userchangepwdsucc", method = RequestMethod.POST)
		public ModelAndView changePasswordSuccess(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
		
			
			
			
			
			
			try
			{
			Changepasswordvalidator r=new Changepasswordvalidator();
			r.validate(reg, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("userchangepassword1");
			}
			
			HttpSession ses=request.getSession(false);
			String username=(String) ses.getAttribute("username");
			String password=(String) ses.getAttribute("password");
			List<RegistrationModel> li=serviceuser.loginlist(username,password);
			String id=li.get(0).getUsername();
			//Integer id=li.get(0).getId();
			String pass=li.get(0).getPassword();
			String currentpassword=reg.getOldpassword();
			String newpassword=reg.getPassword();
			System.out.println("new password is "+newpassword);
			String confirmnewpwd=reg.getConformpassword();
			if(password.equals(currentpassword))
			{
				if(newpassword.equals(confirmnewpwd))
				{
				
					serviceuser.userChangePassword(id,newpassword,confirmnewpwd);
					serviceuser.userChangePassworduserli(id,newpassword);

					
					 return new ModelAndView("userchangepwdsucc1");
				}
			}
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::UserController ::userchangepwdsucc",e);
			}
			 return new ModelAndView("userchangepwdfail");
				
		
		}
		
			
		
		
		// Logout	
		@RequestMapping(value = "/userlogout", method = RequestMethod.GET)
		public ModelAndView userLogout(@ModelAttribute("command") Registration bean,BindingResult result,HttpServletRequest request)
		{
				
						HttpSession ses=request.getSession();
						
						String username=(String)ses.getAttribute("username");
						String logintime=(String)ses.getAttribute("logintime");
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						Date dateobj1 = new Date();
						String logouttime = df1.format(dateobj1);
						
						serviceuser.logoutAppLog(username,logintime,logouttime);
				       
				        ses.invalidate();
				       
			return new ModelAndView("userlogout1");
		}
	
}
