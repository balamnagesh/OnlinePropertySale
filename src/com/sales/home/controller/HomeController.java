package com.sales.home.controller;







import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.InetAddress;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.apache.log4j.Logger;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.applicationlog.bean.ApplicationLogBean;
import com.sales.applicationlog.model.ApplicationLog;
import com.sales.home.bean.LoginBean;
import com.sales.home.bean.Registration;
import com.sales.home.model.RegistrationModel;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;
import com.sales.home.service.ServiceHome;
import com.sales.home.validator.Forgotpasswordvalidator;
import com.sales.home.validator.RegistrationValidator;





@Controller
public class HomeController
{
	@Autowired
	private ServiceHome homeservice;
   
	private Logger log = Logger.getLogger(HomeController.class);
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView welcome() {
    	System.out.println("home");
		return new ModelAndView("index1");
	}
    
    @RequestMapping(value = "/aboutus", method = RequestMethod.GET)
   	public ModelAndView aboutUs() {
       	System.out.println("aboutus");
   		return new ModelAndView("aboutus");
   	}
    @RequestMapping(value = "/contactus", method = RequestMethod.GET)
   	public ModelAndView contactus() {
       
   		return new ModelAndView("contactus");
   	}
    @RequestMapping(value = "/forgotpassword", method = RequestMethod.GET)
	public ModelAndView forgotPassword(@ModelAttribute("command")Registration reg,BindingResult result) {
		
		return new ModelAndView("forgot");
	}
    @SuppressWarnings("unused")
	@RequestMapping(value = "/forgotpasswordcheck", method = RequestMethod.POST)
	public ModelAndView forgotPasswordCheck(@ModelAttribute("command")Registration reg,BindingResult result) throws AddressException, javax.mail.MessagingException {
		
		String username=reg.getUsername();
		String emailid=reg.getEmail();
		System.out.println("username for forgotpassword......"+reg.getUsername());
		System.out.println("email for forgotpassword......"+reg.getEmail());
		List<RegistrationModel> li=homeservice.forgotpasswordlist(username,emailid);
		System.out.println("forgot password list...."+li.size());
		
		Forgotpasswordvalidator r=new Forgotpasswordvalidator();
		r.validate(reg, result);
		
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("forgot");
		
		}
			else if(li.size()==1){
				String pwd=li.get(0).getPassword();
		System.out.println("email in forgot pswd list...."+emailid);
		System.out.println("password in forgot pswd list...."+pwd);
		final String Username = "schimaticsoft@gmail.com";
		final String Password = "Naresh@5009";
		
		String r1 = null;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			           return new PasswordAuthentication(
			            		"schimaticsoft@gmail.com", "Naresh@5009");
			        }
			});


			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(
							emailid));
		
			message.setSubject("Forgot Password for your account");
			message.setText("Your Password is:"
					+ pwd
					);
			 Transport.send(message);						
			System.out.println("mail sent successfuly");
			return new ModelAndView("forgotpasswordsu");

			}

		else{
			return new ModelAndView("forgotpassworde");
		}
		
		
	}
   
   /* // username unique in registration 
    @RequestMapping(value="/usernameuniquehome",method=RequestMethod.GET)
	public void usernameunique(@ModelAttribute("command")Registration r,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
		
		System.out.println("enter unique username....");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("un");
		System.out.println("the username is........in unique...."+username);
		
		List<RegistrationModel> li=homeservice.getuniqueusernamelist(username);
		
	System.out.println("registartation model list isss ....."+li);
		List<AgentRegistrationModel> li1=homeservice.getallagent(username);
		
		System.out.println("agent registration model list issss66666"+li1);
		
		if(li.size()>0){
			System.out.println("enter into 1st list............................");
			out.println(username);
			
		}
		else if(li1.size()>0){
			System.out.println("enter into 2nd list............................");
			
			out.println(username);
				
		}
		
		else{
			out.println();
			
		}
	}
    */
    
    
    //email id unique in registration
    @RequestMapping(value="/emailduniquehome",method=RequestMethod.GET)
	public void emaildUniqueHome(@ModelAttribute("command")Registration r,BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException
	{
    	try{
    		
		System.out.println("enter unique email....");
		PrintWriter out=response.getWriter();
		List<RegistrationModel> li=homeservice.emailuniquelist();
		System.out.println("list in unique.."+li.size());
		java.util.Iterator<RegistrationModel> i=li.iterator();
		String undb=null;
		while(i.hasNext()){
			
			RegistrationModel ul=(RegistrationModel) i.next();
			System.out.println("size..."+ul.getEmail());
			if(undb==null){
				undb=ul.getEmail();
			}
			
			else{
				undb=undb+","+ul.getEmail();
			}
		}
		
		out.println(undb);
		}
    	catch(Exception e)
		{
			log.error("Online Property Sales::HomeController ::emailduniquehome",e);
		}
	}
    
    //registration view page
    @RequestMapping(value = "/registration", method = RequestMethod.GET)
	public ModelAndView registration(@ModelAttribute("command")Registration reg,BindingResult result) {
		return new ModelAndView("registration1");
	}
       
    // Registration success 
    @SuppressWarnings("unused")
	@RequestMapping(value = "/registersuccess", method = RequestMethod.POST)
   	public ModelAndView registersuccess(@ModelAttribute("command")Registration reg,BindingResult result, Userslist uli,UserRole ur) throws IllegalAccessException, InvocationTargetException {
    	try
    	{
    	
    	System.out.println("enter register controller..");
    	RegistrationModel mode=new RegistrationModel();
    	
    	
      	
		RegistrationValidator r=new RegistrationValidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("registration1");
		}
		else{
    	
    	 
    	   
    	BeanUtils.copyProperties(mode,reg);
    	
    	
    	
    	
    	
    
    
    	
    	List<RegistrationModel> li= homeservice.registrationList();
		System.out.println("list size..."+li.size());
		
		if(li.size()==0){
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
		Date date = new Date();
		String d=dateFormat.format(date);
		System.out.println("today date and time...."+d);
		mode.setType("ROLE_ADMIN");
		mode.setStatus("Pending");
		mode.setRegisterdate(d);
	
		homeservice.addRegistration(mode);
		
		
		// Spring security
		 
		  uli.setUsername(reg.getUsername());
		  uli.setPassword(reg.getPassword());
		  uli.setEnabled(false);
		  uli.setStatus("inactive");
		  homeservice.saveuserslist(uli); 
		  
		  ur.setRole("ROLE_ADMIN");				  
		  ur.setUsersListModel(uli);
		  homeservice.saveuserrole(ur);		
		
		}
		else if(li.size()>0)
		{	
			DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
		Date date = new Date();
		String d=dateFormat.format(date);
		System.out.println("today date and time...."+d);
			
			mode.setType("ROLE_USER");
			mode.setStatus("Pending");
			mode.setRegisterdate(d);
			homeservice.addRegistration(mode);

// Spring security
			  
			uli.setUsername(reg.getUsername());
			uli.setPassword(reg.getPassword());
			uli.setEnabled(false);
			uli.setStatus("inactive");
			homeservice.saveuserslist(uli); 
	  
			ur.setRole("ROLE_USER");				  
			ur.setUsersListModel(uli);
			homeservice.saveuserrole(ur);	
		}
    	
    	
		String umne=reg.getUsername();
		String pwd=reg.getPassword();
		System.out.println("username..."+umne);
		System.out.println("pwd.."+pwd);
		final String Username = "schimaticsoft@gmail.com";
		final String Password = "Naresh@5009";
		
		String r1 = null;
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getDefaultInstance(props, 
			    new javax.mail.Authenticator(){
			        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
			           return new PasswordAuthentication(
			            		"schimaticsoft@gmail.com", "Naresh@5009");
			        }
			});

		try {
			String status ="Approved";
			String url = "http://localhost:2223/OnlinePropertySale/homemailapproveagentregister.html?unme="+umne+"&status="+status;
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(Username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(
							reg.getEmail()));
			
			message.setSubject("You are Registered successfully!");
			message.setText("Your username  is : "
					+reg.getUsername()
					+ " \nYour Password is:"
					+ reg.getPassword()
					
					+"\n"
					
                     +url
      +"\n click this link to activate your account"
					
					);
			 Transport.send(message);						
			System.out.println("mail sent successfuly");
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	System.out.println("registration is success");
		}
    	}
    	
		catch(Exception e)
		{
			log.error("Online Property Sales::HomeController ::registersuccess",e);
		}
    	
    
		return new ModelAndView("registersuccess1");

   	
    }
    
    
//home mail approval register
	@SuppressWarnings("unused")
	@RequestMapping(value="homemailapproveagentregister", method = RequestMethod.GET)
	public ModelAndView mailApprove(@ModelAttribute("command") Registration reg,HttpServletRequest request) {
		
		System.out.println("enter....mail approve...");
		String status = request.getParameter("status");
		String unme = request.getParameter("unme");
		String pwd=request.getParameter("pwd");
		System.out.println("status.."+status);
		System.out.println("username..."+unme);
		
		
		homeservice.statushomechange(unme,status);
		
		homeservice.statusenable(unme);
		System.out.println("end sts...");
		
		
		return new ModelAndView("login2");
	}
//session expired

	 @RequestMapping(value = "/sessionexpired", method = RequestMethod.GET)
	   	public ModelAndView sessionExper(@ModelAttribute("command")  LoginBean lb,BindingResult result,HttpServletRequest request,HttpServletResponse response) {
	   		return new ModelAndView("sessionexpired1");
	   	}
	 
	// Sessions 
			@RequestMapping(value="/psessionexpire" ,method = RequestMethod.GET)
			public ModelAndView psession(@ModelAttribute("command") Registration bean,BindingResult result)
			{
				return new ModelAndView("psessionexpire");			
			}
	
    //login view page
    @RequestMapping(value = "/login1", method = RequestMethod.GET)
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error,@RequestParam(value = "logout", required = false) String logout,ModelAndView model)
	{
		
		if (error!= null) {
			model.addObject("error", "Invalid Username Or Password");
			System.out.println("Error is not null : so error is adding in the "
					+ "mylogin controller : error:" + error + ":");
			
		}
		
		model.setViewName("login2");
		model.addObject("command",new Registration());
		return model;
		
	}
	/*public ModelAndView login(@ModelAttribute("command") LoginBean lb) {
		
		return new ModelAndView("login2");
	}*/
    
  //for 403 access denied page
	
  	@RequestMapping(value = "/denied", method = RequestMethod.GET)
  		public ModelAndView accesssDenied() {

  		  ModelAndView model = new ModelAndView();

  		  //check if user is login
  		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
  		  if (!(auth instanceof AnonymousAuthenticationToken)) {
  			UserDetails userDetail = (UserDetails) auth.getPrincipal();
  			model.addObject("username", userDetail.getUsername());
  		  }

  		  model.setViewName("403");
  		  return model;

  	}
	
    //login success 
    
    @RequestMapping(value = "/loginsuccess", method = RequestMethod.GET)
	public ModelAndView loginSuccess(@ModelAttribute("command")LoginBean lb, BindingResult result,HttpServletResponse response,HttpServletRequest request,Principal prince) {
		
		try
		{
		try
		{
			
    	/*String user=lb.getUsername();
		String password=lb.getPassword();*/
		
		
		
	
		
		HttpSession s=request.getSession();
		/*Login Validator=new Login();
		Validator.validate(lb, result);
    	if(result.hasErrors())
    	{
    		  return new ModelAndView("login2");
    	}
    	else 
    	{*/
		lb.setUsername(prince.getName());
		
		Registration reg1=new Registration();  // registartion model
		
		BeanUtils.copyProperties(lb,reg1);
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();  // spring security authentication
   		String user= auth.getName();
   		
   		System.out.println("username issss authentication"+user);
   		String password = (String) auth.getCredentials();              // Getting Password
   		System.out.println("password credentila isssss"+password);
   		String uname=prince.getName();
   		System.out.println("unameeeeeee 444444"+uname);
   		lb.setPassword(password);
   	
   		List<RegistrationModel> li=homeservice.loginList(user,password);  //registration user and admin list
		System.out.println("login list size "+li.size());
		
		
		
		List<AgentRegistrationModel> la=homeservice.loginagentlist(user,password); // agent list
		System.out.println("agent login list.."+la.size());
		
    		ApplicationLog almodel=new ApplicationLog();     // application log maintain data  which  user login 
			ApplicationLogBean albean=new ApplicationLogBean();

    		InetAddress ip = InetAddress.getLocalHost();
            String hostname = ip.getHostName();
            Date dt=new Date();
      		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
      		String sd=sdf.format(dt);
      		s.setAttribute("logintime", sd);
      	
      		
      		String s1=ip.toString();
      		albean.setIp(s1);
      		albean.setHostname(hostname);
      		albean.setUserame(user);
      		albean.setLogindate(sd);
    		
    		
    		
		if(li.size()>0){
			String log=li.get(0).getPassword();
			System.out.println("list..loglist"+li.size());
			 s.setAttribute("username", user);
			s.setAttribute("password", log);
			
	
			Iterator<RegistrationModel> i=li.iterator();
			System.out.println("after iterator..");
			while(i.hasNext()){
				RegistrationModel rm=(RegistrationModel) i.next();
				
				String type= rm.getType();
				System.out.println("login typeeeee"+type);
				String ts=rm.getStatus();
				System.out.println(ts);
				albean.setType(type);
		if(type.equalsIgnoreCase("ROLE_ADMIN")&&ts.equalsIgnoreCase("Active")){
			
			System.out.println("enter the admin home");
			
			albean.setOpenPage("AdminLoginSuccess");
		BeanUtils.copyProperties(almodel, albean);
			homeservice.appLog(almodel);
			HttpSession session=request.getSession(true);
			session.setMaxInactiveInterval(5*60);
		return new ModelAndView("adminhome");
		}
		
		else if(type.equalsIgnoreCase("ROLE_USER")&&ts.equalsIgnoreCase("Active")){
			System.out.println("enter into userlogin in userhome");
			HttpSession session=request.getSession(true);
			session.setMaxInactiveInterval(5*60);
			
			albean.setOpenPage("UserLoginSuccess");
			BeanUtils.copyProperties(almodel, albean);
			homeservice.appLog(almodel);
			return new ModelAndView("userhome");
		
		    }	
			}
		}
		
		else if(la.size()>0){
			System.out.println("hss");
			String agnepwd=la.get(0).getPassword();
			String atype=la.get(0).getType();
			albean.setType(atype);
			System.out.println("list..lp"+li.size());
			 s.setAttribute("username", user);
			s.setAttribute("password", agnepwd);
			String agtp=la.get(0).getType();
			String agsts=la.get(0).getStatus();
			if(agtp.matches("ROLE_AGENT")&&agsts.matches("Active"))
			{
				HttpSession session=request.getSession(true);
				session.setMaxInactiveInterval(5*60);
				albean.setOpenPage("AgentLoginSuccess");
				BeanUtils.copyProperties(almodel, albean);
				homeservice.appLog(almodel);
			return new ModelAndView("agenthome");
			}
		
		
		
			}
    	
		}
    	
		catch(Exception e){
			System.out.println(e);
			 
		 }
		
		
		
		
		}
		catch(Exception e){
			System.out.println(e);
			 
		 }
		return new ModelAndView("loginfailpage");
		}
    }



    

    
    
    
    
    
    

