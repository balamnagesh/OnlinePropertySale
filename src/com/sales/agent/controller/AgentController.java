package com.sales.agent.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;






import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sales.admin.bean.AgentRegistration;
import com.sales.admin.bean.FeedBackBean;
import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;
import com.sales.admin.validator.AgentRegistrationValidator;
import com.sales.agent.bean.AddProperty;
import com.sales.agent.bean.AgentFeedback;
import com.sales.agent.service.ServiceAgent;
import com.sales.agent.validator.AgentChangepasswordvalidator;
import com.sales.agent.validator.AgentValidator;
import com.sales.agent.validator.Agentfeedbackvalidator;
import com.sales.agent.validator.PropertyValidation;
import com.sales.home.bean.Registration;
import com.sales.home.controller.HomeController;
import com.sales.home.model.RegistrationModel;
import com.sales.home.validator.RegistrationValidator;
import com.sales.transactionlog.bean.Transactionbean;
import com.sales.transactionlog.model.TransactionLog;
import com.sales.user.validator.Changepasswordvalidator;
import com.sales.agent.bean.PropertyBean;
import com.sales.agent.model.PropertyModel;

@Controller
public class AgentController {
	
	@Autowired
	private HttpServletRequest req;
	
	@Autowired
	private HttpSession ses;
	
	@Autowired
	private ServiceAgent serviceagent;
	
	private Logger log = Logger.getLogger(AgentController.class);

	
	@RequestMapping(value = "/agenthome", method = RequestMethod.GET)
	public ModelAndView agentHome() {
		System.out.println("enter into agenthome1 in agent controller");
		return new ModelAndView("agenthome");
	}

	
	@RequestMapping(value = "/viewuser", method = RequestMethod.GET)
	public ModelAndView viewProperty(@ModelAttribute("command")Registration reg,BindingResult result) {
		System.out.println("viewusersssss");
		
		return new ModelAndView("viewuser");
	}
	
	
	// users grid view
	
		@RequestMapping(value="/agentsusersgrid", method = RequestMethod.GET)
		public void usersGrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletResponse response) throws IOException {
			System.out.println("enter agentuser grid..");
			PrintWriter out=null;
			out=response.getWriter();
			System.out.println("enter into datagrid list");
			List<RegistrationModel> li=serviceagent.getallusers();
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
	
		// agent add user
				@RequestMapping(value = "/adduser", method = RequestMethod.GET)
				public ModelAndView addUser(@ModelAttribute("command")Registration reg,BindingResult result) {
					
					return new ModelAndView("adduser");
				}
		
				
				@SuppressWarnings("unused")
				@RequestMapping(value = "/agentaddusersuccess", method = RequestMethod.POST)
				public ModelAndView addAgentSuccess(@ModelAttribute("command")Registration reg,BindingResult result, HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
					System.out.println("enter register controller..");
					try
			    	{
			    	
					RegistrationModel mode=new RegistrationModel();
			    	
			    	

					RegistrationValidator r=new RegistrationValidator();
					r.validate(reg, result);
					if(result.hasErrors()){
						System.out.println("error..page..");
						return new ModelAndView("adduser");
					}
					else{
						TransactionLog tllog=new TransactionLog();
						
						Transactionbean tlbean=new Transactionbean();
						Date dt=new Date();
						SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			       		String sd=sdf.format(dt);
			    	   
			    	BeanUtils.copyProperties(mode,reg);
			    	
			    	HttpSession hs=request.getSession(false);
					String username=(String) hs.getAttribute("username");
					String password=(String) hs.getAttribute("password");
					System.out.println("username...."+username);
					System.out.println("password....."+password);
			    	List<AgentRegistrationModel> logli=serviceagent.agentloginlist(username,password);
					List<RegistrationModel> li= serviceagent.registrationList();
					System.out.println("list size..."+li.size());
					if(li.size()>0)
					{	
						DateFormat dateFormat = new SimpleDateFormat("yyyy-dd-MM");
					Date date = new Date();
					String d=dateFormat.format(date);
					System.out.println("today date and time...."+d);
						
					String usern=logli.get(0).getUsername();
					String atype=logli.get(0).getType();
				 	 tlbean.setUsername(usern);
			       	 tlbean.setType(atype);
			       	 tlbean.setTask("New User add");
			       	 tlbean.setTaskdt(sd);
			       	 BeanUtils.copyProperties(tllog, tlbean);
			       	
					
						mode.setType("ROLE_USER");
						mode.setRegisterdate(d);
						mode.setStatus("Pending");
						serviceagent.addRegistration(mode);

						serviceagent.Transactionlogdetails(tllog);
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
						String url = "http://localhost:2223/OnlinePropertySale/mailapproveagentregisteruser.html?unme="+umne+"&status="+status;
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
					log.error("Online Property Sales::AgentController ::agentaddusersuccess",e);
				}
		    	
				return new ModelAndView("addagentsuccess1");
			}
				
				//mail approve 
				@SuppressWarnings("unused")
				@RequestMapping(value="mailapproveagentregisteruser", method = RequestMethod.GET)
				public ModelAndView mailApprove(@ModelAttribute("command") Registration reg,HttpServletRequest request) {
					
					System.out.println("enter....mail approve...");
					String status = request.getParameter("status");
					String unme = request.getParameter("unme");
					String pwd=request.getParameter("pwd");
					System.out.println("status.."+status);
					System.out.println("username..."+unme);
					
					serviceagent.statususerchange(unme,status);
					System.out.println("end sts...");
					
					
					return new ModelAndView("login2");
				}
				
				
				//UPDATE list view 
				
				@SuppressWarnings("rawtypes")
				@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
				public ModelAndView updateAgent(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
					try
					{
					System.out.println("enter edit cntlr...");
					String username=request.getParameter("username");
					System.out.println("username....."+username);
					RegistrationModel sb=null;
					List<RegistrationModel> li=serviceagent.getallusers(username);
					for (Iterator iterator = li.iterator(); iterator.hasNext();) {
						sb = (RegistrationModel) iterator.next();
						
					}
					BeanUtils.copyProperties(reg, sb);
					}
					catch(Exception e)
					{
						log.error("Online Property Sales::AgentController ::updateuser",e);
					}
					return new ModelAndView("updateuser");
				}
			
				//UPDATE user grid SUCCESS PAGE
			
				@RequestMapping(value = "/updateusersuccess", method = RequestMethod.POST)
				public ModelAndView updateAgentSuccess(@ModelAttribute("command")Registration reg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
					
					System.out.println("enter update controller..");
					try
					{
						RegistrationModel am=new RegistrationModel();
						RegistrationValidator r=new RegistrationValidator();
						r.validate(reg, result);
						if(result.hasErrors()){
							System.out.println("error..page..");
							return new ModelAndView("updateuser");
						}
						else{
				    	
					BeanUtils.copyProperties(am, reg);	
					serviceagent.updateusertgrid(am);
						}
					}
					catch(Exception e)
					{
						log.error("Online Property Sales::AgentController ::updateusersuccess",e);
					}
					return new ModelAndView("updateusersuccess");
					}
					
				
		//agent delete user
		@RequestMapping(value = "/agentdeluser", method = RequestMethod.GET)
		public ModelAndView adminDeleteUser(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
			System.out.println("enter delete..usergrid..");
			String ss=request.getParameter("username");
			System.out.println("ids value in delete..."+ss);
			String[] sp=ss.split(",");
			System.out.println("length...."+sp.length);
			for(int i=0;i<sp.length;i++){
				String s=sp[i];
				System.out.println(s);
				serviceagent.deleteusergrid(s);
				
			}
			
			
			return new ModelAndView("viewuser");
		}
		
		
		
		//agent user grid id search
		@RequestMapping(value="/agentusergridsearch", method = RequestMethod.GET)
		public void agentUsergridSearch(@ModelAttribute("command") AgentRegistration dd, 
				
			BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
		

				
				
				PrintWriter pw=null;
		    	pw=response.getWriter();
		    	String uname1=request.getParameter("value");
		    	System.out.println("User:"+uname1);
		    	HttpSession hs=request.getSession();
		    	
		    	
		    	
		    	
		    	hs.setAttribute("user", uname1);
		    	System.out.println("before");
		    	String username=uname1.toLowerCase();
		    	List<RegistrationModel> li=serviceagent.searchuserusername(username);
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
		
		
		//admin user grid date
		@SuppressWarnings("rawtypes")
		@RequestMapping(value="/agentusergriddate", method = RequestMethod.GET)
		public void adminUserGridDate(@ModelAttribute("command") Registration dd, 
					BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException{
			
		PrintWriter out=null;
		out=response.getWriter();
			System.out.println("enter into date list");
			
			String fromm=request.getParameter("from");  // getting from date
			System.out.println("date from isssssssssssss"+fromm);
			String[] sd = fromm.split("/");
			
			String from = sd[2]+"-"+sd[1]+"-"+sd[0];
			System.out.println(from);
			String to=request.getParameter("to");  // getting to date 
			System.out.println("date to isssssssssssss"+to);
			String[] ts = to.split("/");
			
			String t = ts[2]+"-"+ts[1]+"-"+ts[0];
			System.out.println(t);
			List l=serviceagent.usersGriddateSearch(from,t);
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
		
		
		
		//view all agents grid list 
		@RequestMapping(value="/agentusersrefresh", method = RequestMethod.GET)
		public void agentsGrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletResponse response) throws IOException {
			
			PrintWriter out=null;
			out=response.getWriter();
			System.out.println("enter into datagrid list");
			List<RegistrationModel> li=serviceagent.getallusers();
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
		
		
		//agent property delete user
		@RequestMapping(value = "/propertyagentdeletegrid", method = RequestMethod.GET)
		public ModelAndView AgentDeleteUser(@ModelAttribute("command")PropertyBean reg,BindingResult result,HttpServletRequest request) {
			System.out.println("enter delete..usergrid..");
			String ss=request.getParameter("id");
			System.out.println("ids value in delete..."+ss);
			String[] sp=ss.split(",");
			System.out.println("length...."+sp.length);
			for(int i=0;i<sp.length;i++){
				String s=sp[i];
				System.out.println(s);
				serviceagent.deleteagentgrid(s);
				/*String modelname="Superadminmodel";
				spradmser.delete(s, modelname);*/
			}
			
			
			return new ModelAndView("viewproperty1");
		}
		//view agents feedback
	@RequestMapping(value = "/viewagentfeedback", method = RequestMethod.GET)
	public ModelAndView viewAgentFeedBack(@ModelAttribute("command")FeedBackBean reg,BindingResult result) {
		System.out.println("viewusersssss");
		
		return new ModelAndView("viewagentfeedback");
	}
	
	// add agent feed back
	@RequestMapping(value = "/addagentfeedback", method = RequestMethod.GET)
	public ModelAndView addAgentFeedBack(@ModelAttribute("command")AgentFeedback reg,BindingResult result) {
		System.out.println("viewusersssss");
		
		return new ModelAndView("addagentfeedback");
	}
	
	
	//agent feedback grid view list
		@RequestMapping(value="/agentfeedbackgrid", method = RequestMethod.GET)
		public void agentFeedBackGrid(@ModelAttribute("command") FeedBackBean fb,HttpServletResponse response) throws IOException {
			
			PrintWriter out=null;
			out=response.getWriter();
			System.out.println("enter into datagrid list");
			
			List<AdminFeedBackModel> li=serviceagent.getAllFeedbacks();
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
	
	
		
		
		
	//agent feedback save
	@RequestMapping(value = "/agentfeedbacksave", method = RequestMethod.POST)
	public ModelAndView agentFeedBackSuccess(@ModelAttribute("command")AgentFeedback reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		
		try
		{
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("in session un"+username);
		System.out.println("in session pwd"+password);
		
		Agentfeedbackvalidator fv=new Agentfeedbackvalidator();
		fv.validate(reg,result);
		if(result.hasErrors())
{
			return new ModelAndView("addagentfeedback");	
			
		}
		else
		{
		AdminFeedBackModel feedback=new AdminFeedBackModel() ;
		List<AgentRegistrationModel> li=serviceagent.loginlistagent(username,password);
		System.out.println("list for login------------------------"+li.size());
		
		String type=li.get(0).getType();
		
		String email=li.get(0).getEmail();
		String userna=li.get(0).getUsername();
		
		DateFormat dff = new SimpleDateFormat("yyyy-dd-MM");
		System.out.println("dateformat"+dff);
		Date date = new Date();
		System.out.println("date isssss"+date);
		String d=dff.format(date);
		System.out.println("string dateeeee"+d);
		
	
		String comments=reg.getComments();
		feedback.setStatus("pending");
		feedback.setType(type);
		feedback.setDate(d);
		feedback.setEmail(email);
		feedback.setUsername(userna);
		feedback.setComments(comments);
		BeanUtils.copyProperties(reg,feedback);
		serviceagent.addagentfeedback(feedback);
	
		}
		}
	
		catch(Exception e)
		{
			log.error("Online Property Sales::AgentController ::agentfeedbacksave",e);
		}
	
	return new ModelAndView("agentfeedbacksuccess1");
}
	
	//view property
	@RequestMapping(value = "/viewproperty", method = RequestMethod.GET)
	public ModelAndView viewUsers(@ModelAttribute("command")PropertyBean reg,BindingResult result) {
		System.out.println("viewusersssss");
		
		return new ModelAndView("viewproperty1");
	}
	
	
	
	//user property add
		@RequestMapping(value = "/propertyadd", method = RequestMethod.GET)
		public ModelAndView addProperty(@ModelAttribute("command")PropertyBean pr,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
			
			
			return new ModelAndView("propertyadd");
		}
		
		//add property success page


		/*@RequestMapping(value = "/propertysuccess", method = RequestMethod.GET)
		public ModelAndView addpropertysuccess(@ModelAttribute("command")PropertyBean pr,BindingResult result,HttpServletRequest request,@RequestParam(value="image",required = false)MultipartFile image) throws IllegalAccessException, InvocationTargetException, IOException {
		*/
			 @SuppressWarnings("null")
			@RequestMapping(value = "/agentpropertysuccess",method = RequestMethod.POST)
		 public ModelAndView addPropertySuccess(@ModelAttribute("command")  PropertyBean pr,BindingResult result, HttpServletRequest request, PropertyModel model, @RequestParam(value = "files", required = false) MultipartFile image) throws IOException, IllegalAccessException, InvocationTargetException 
			   {
			System.out.println("comming.................................... ");
			 
			/*	 PropertyModel model=new PropertyModel();*/
		
			try
			{
		
			
			HttpSession hs=request.getSession(false);
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("in session un"+username);
			System.out.println("in session pwd"+password);
			
			
			PropertyValidation r=new PropertyValidation();
			String filename = null;
			List<MultipartFile> files;
			r.validate(pr,result);
			if(result.hasErrors())
			{
				
				List<MultipartFile> files1=pr.getFile();
				 for (MultipartFile multipartFile : files1) {	
				 	   System.out.println("image uploading start");
				 	   
				 	   
				 	  System.out.println("..................................."+multipartFile.getSize());
				 	  
				 	   filename=multipartFile.getOriginalFilename();  
				 	   System.out.println(".........................fil////////////////////////////........."+filename);
				 	   
				 	   long fsize=multipartFile.getSize();
				 	   System.out.println("..............;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;....................."+fsize);
				 	   if((fsize<=0)&&(filename.equalsIgnoreCase("")))
				 	   {
				 		  result.rejectValue("file","file.invalid","File image is required.");
				 		  
				 	   }
				 	   
				 }
				
				return new ModelAndView("propertyadd");	
				
				
			}
			
			else
			{
		
			List<AgentRegistrationModel> logli=serviceagent.agentloginlist(username,password);
			String user=logli.get(0).getUsername();
			
			String type=logli.get(0).getType();
			String gender=logli.get(0).getGender();
			DateFormat dff = new SimpleDateFormat("yyyy-dd-MM");
			System.out.println("dateformat"+dff);
			Date date = new Date();
			System.out.println("date isssss"+date);
			String d=dff.format(date);
			System.out.println("string dateeeee"+d);
			
			
			
		
		
			
			System.out.println("coommmingg");
			 	 
			 	
			 	  
			 	   files = pr.getFile();
			 	  System.out.println("the file list size is:"  +files.size());
			 	  List<String> fileNames = new ArrayList<String>();
			 	if (null != files && files.size() > 0) 
			 		
			 	 {
			         for (MultipartFile multipartFile : files) {	
			 	 
			 	   
			 	  System.out.println("..................................."+multipartFile.getSize());
			 	  
			 	   filename=multipartFile.getOriginalFilename();  
			 	   System.out.println(".........................fil////////////////////////////........."+filename);
			 	   
			 	   long fsize=multipartFile.getSize();
			 	   System.out.println("..............;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;....................."+fsize);
			 	   if((fsize<=0)&&(filename.equalsIgnoreCase("")))
			 	   {
			 		  result.rejectValue("file","file.invalid","file is required.");
			 		  
			 	   }
			 	  
			 	  
			 	   System.out.println(filename+"      jbvhdbvdhjbg");
			 	   String arnpath="E:/NAGESH_WORK_SPACE/Oline-Property-Sales/OnlinePropertySale/WebContent/images/User";
			 	   File file = new File(arnpath + "/"
			 	+ filename);
			       
			 		FileUtils.writeByteArrayToFile(file, multipartFile.getBytes()); 
			/* try {
				BeanUtils.copyProperties(pr,model);
			} catch (IllegalAccessException | InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			 		
				
			 		
			 		

					AgentRegistrationModel agent=new AgentRegistrationModel();
					
					String did=model.getId();
					String id=logli.get(0).getId();
					System.out.println("id issssss00000000000"+id);
					List<AgentRegistrationModel> li1 = serviceagent.viewagents(id);
					System.out.println("list issss"+li1.size());
					
					for (Iterator<AgentRegistrationModel> iterator = li1.iterator(); iterator.hasNext();) {
						agent = (AgentRegistrationModel) iterator.next();
						
						
					}
					 
					
					 
					Set s = new HashSet();
				
					s.add(model);
					System.out.println("agenttt1111111111111111"+s.add(agent));
					
					s.add(agent);
					
					System.out.println("modellllll222222222222222"+s.add(model));
						
					
			 		
/*
					agent.setChildren(s);
			 		*/
			 		
					BeanUtils.copyProperties(model, pr);
			 		
					//serviceagent.addagent(agent);
					
			 		
			 		
			 	
			
				
			
			  model.setFilepath("/User/"+filename);
		
			
			  model.setPropertyregisterdate(d);
			
			  model.setAgentid(id);
				model.setUsername(user);
				model.setType(type);
				model.setGender(gender);
				
				serviceagent.addPropertyRegistration(model);
				 /* serviceagent.addPropertyRegistration(model);
*/			 		
			 	
			 	}
			

		         }
			}
			}
				catch(Exception e)
				{
					log.error("Online Property Sales::AgentController ::propertyadd",e);
				}
			
			 	 return new ModelAndView("propertysuccess");
			 	 }
			   
			
			//agent update property
			 @SuppressWarnings("rawtypes")
				@RequestMapping(value = "/agentupdateproperty", method = RequestMethod.GET)
				public ModelAndView updateUserProperty(@ModelAttribute("command")PropertyBean reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
					try
					{
					System.out.println("enter edit cntlr........................................");
					String username=request.getParameter("id");
					System.out.println("username..........................."+username);
String path=req.getParameter("path");
					
					System.out.println("the file path is.................."+path);
					ses.setAttribute("fpath", path);
					PropertyModel prop=null;
					List<PropertyModel> li=serviceagent.getallpropeties(username);
					/*for (Iterator iterator = li.iterator(); iterator.hasNext();) {
						sb = (PropertyModel) iterator.next();
						
					}*/
					for(Iterator iterator=li.iterator();iterator.hasNext();){
						
						prop=(PropertyModel) iterator.next();
						
						
					}
					
					
					
					BeanUtils.copyProperties(reg, prop);
					
					System.out.println("........................................getting image pah............"+prop.getFilepath());
					String s=prop.getFilepath();
					}
				
					catch(Exception e)
					{
						log.error("Online Property Sales::AgentController ::propertyadd",e);
					}
					return new ModelAndView("propertyupdate");
				}
			
			
			 // agent update success
			 @SuppressWarnings("unused")
				@RequestMapping(value = "/agentpudatepropertysuccess", method = RequestMethod.POST)
				public ModelAndView agentUpdatePropertySucess(@ModelAttribute("command")PropertyBean pb,BindingResult result, HttpServletRequest request, @RequestParam(value = "files", required = false)MultipartFile image) throws IllegalAccessException, InvocationTargetException, IOException {
					
				 try
				 {
				 
				    PropertyModel pm=new PropertyModel();
					HttpSession hs=request.getSession(false);
					String username=(String) hs.getAttribute("username");
					String password=(String) hs.getAttribute("password");
					System.out.println("in session un"+username);
					System.out.println("in session pwd"+password);
			
					
					
					PropertyValidation r=new PropertyValidation();
					r.validate(pb,result);
					if(result.hasErrors())
					{
						
						System.out.println("error page........");
						String filename=(String) ses.getAttribute("fpath");
						pb.setFilepath(filename);
						
						return new ModelAndView("propertyupdate");	
						
						
					}
					else
					{
				
					
					List<AgentRegistrationModel> logli=serviceagent.agentloginlist(username,password);
					String user=logli.get(0).getUsername();
					
					String type=logli.get(0).getType();
					String gender=logli.get(0).getGender();
					List<PropertyModel> logl=serviceagent.agentpropertyloginlist(username);
					String reg=logl.get(0).getPropertyregisterdate();
					System.out.println("prperttt registerd date"+reg);
                    String path=(String) ses.getAttribute("fpath");
					
					String filename = null;
					System.out.println("the file path is.................."+path);
				
					List<MultipartFile> files = pb.getFile();
					
					System.out.println("..................."+files.size());
					try{
					
					System.out.println("......................%%%%%%%%%%%%%%%%%%%%%%%%%%%"+!(image.getOriginalFilename().equalsIgnoreCase("")));
					
					}catch(Exception e){}
					if (null != files && files.size() > 0 ) 
				 		
				 	 {
				         for (MultipartFile multipartFile : files) {	
				 	   System.out.println("image uploading start..................in updating");
				 	   
				 	   
				 	  System.out.println("................................"+multipartFile.getSize());
				 	  
				 	  if(multipartFile.getSize()>0){
				 	   filename=multipartFile.getOriginalFilename();  
				 	   
				 	   System.out.println(filename+"      jbvhdbvdhjbg");
				 	   String arnpath="E:/NAGESH_WORK_SPACE/Oline-Property-Sales/OnlinePropertySale/WebContent/images/User";
				 	   File file = new File(arnpath + "/"
				 	+ filename);
				       System.out.println("store pathhhhh"+arnpath);
				 		FileUtils.writeByteArrayToFile(file, multipartFile.getBytes()); 
					/*BeanUtils.copyProperties(pr, reg);
						
					System.out.println("The registration model path is "+reg.getFilepath());
					
				
					serviceagent.updateagentproperty(pr);
				*/
				 	    String npath="/User"+"/"+filename;
				 	
						System.out.println("The npath is......................"+npath);
						
					
						 //serviceagent.updateagentproperty(pm);
						String id=logli.get(0).getId();
				 		BeanUtils.copyProperties(pm, pb);
				 		pm.setFilepath(npath);
				 		 pm.setAgentid(id);
						pm.setUsername(user);
						pm.setType(type);
						pm.setGender(gender);
						pm.setPropertyregisterdate(reg);
                         System.out.println("................................."+pm);
                         System.out.println("........."+pm.getId());
			        	 
				         serviceagent.updateagentproperty(pm);
				         
				         
				 	
				        
				 	  }
				 	  
				 	  else{
				 			String id=logli.get(0).getId();
				 		 BeanUtils.copyProperties(pm, pb); 
			        	 pm.setFilepath(path);
			        	 pm.setAgentid(id);
			        	 pm.setUsername(user);
							pm.setType(type);
							pm.setGender(gender);
							pm.setPropertyregisterdate(reg);
			        	 System.out.println("111111111111110000000000000");
			        	 System.out.println("........."+pm.getId());
			        	 
			        	  serviceagent.updateagentproperty(pm);   
			        	  
				 		  
				 		  
				 	  } 	
				 	 }
				 	 
				     	
				 	 }
					}
				 }
					catch(Exception e)
					{
						log.error("Online Property Sales::AgentController ::agentpudatepropertysuccess",e);
					}
					
					return new ModelAndView("agentpudatepropertysuccess");
				         
				 	 
					
			 }
			 
		
		//property Details view 
		@RequestMapping(value="/agentpropertylist", method = RequestMethod.GET)
		public void usersGrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
			System.out.println("enter property list grid..");
			PrintWriter out=null;
			out=response.getWriter();
			HttpSession hs=request.getSession(false);
			String username=(String) hs.getAttribute("username");
			System.out.println("enter into datagrid property  list");
			List<PropertyModel> li=serviceagent.getallproperties(username);
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
		
		//agent property grid date search
		
		@RequestMapping(value="/agentpropertygrididserach", method = RequestMethod.GET)
		public void userPropertyGrid(@ModelAttribute("command") PropertyBean pr, 
				
			BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
		

				
				
				PrintWriter pw=null;
		    	pw=response.getWriter();
		    	String uname1=request.getParameter("value");
		    	System.out.println("User:"+uname1);
		    	HttpSession hs=request.getSession();
		    	
		    	
		    	String a[]=uname1.split("");
		    	String username=a[0].toUpperCase()+a[1].toLowerCase();
		    	System.out.println("username0000000000"+username);
		    	
		    	
		    	hs.setAttribute("user", uname1);
		    	
		    	
		    	
		    	List<PropertyModel> li=serviceagent.searchagentusername(username);
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
		
		
		

		// agent property grid date
		@RequestMapping(value="/agentpropertygriddate", method = RequestMethod.GET)
		public void agentPrpertyGridDate(@ModelAttribute("command") PropertyBean dd, 
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
			List l=serviceagent.agentGriddateSearch(from,t);
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
	
	
	
	
		//property refresh
				@RequestMapping(value="/agentpropertyrefresh", method = RequestMethod.GET)
				public void agentRefresh(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
					System.out.println("enter property list grid..");
					PrintWriter out=null;
					out=response.getWriter();
					
					System.out.println("enter into datagrid property  list");
					List<PropertyModel> li=serviceagent.getallproperties();
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
				
	
	
	
	
	
		
		//AGENT UPDATE PROFILE.....................
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/agentupdateprofile", method = RequestMethod.GET)
		public ModelAndView agentupdateprofile1	(@ModelAttribute("command")AgentRegistration arg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
			
			try{
			System.out.println("enter into 	agentupdateprofile1	 in agent controller");
			AgentRegistrationModel arm=new AgentRegistrationModel();
			String username=(String) ses.getAttribute("username");
			String password=(String) ses.getAttribute("password");
			List li=serviceagent.loginlist(username,password);
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				 arm = (AgentRegistrationModel) iterator.next();
				
			}
			BeanUtils.copyProperties(arg, arm);
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::AgentController ::agentupdateprofile",e);
			}
			return new ModelAndView("agentupdateprofile2");
		}
		
		//agent update success
		
		
		@SuppressWarnings("unused")
		@RequestMapping(value = "/agentupdatesuccess1", method = RequestMethod.POST)
		public ModelAndView agentupdatesuccess1	(@ModelAttribute("command")AgentRegistration reg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
			AgentRegistrationModel rm=new AgentRegistrationModel();
			System.out.println("The registration model is "+rm);
			try
			{
			AgentValidator r=new AgentValidator();
			r.validate(reg, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("agentupdateprofile2");
			}
			else
			{
			BeanUtils.copyProperties(rm, reg);
			
			System.out.println(reg.getId());
			System.out.println(reg.getRegisterdate());
			
				
		
		
			serviceagent.updateagentprofile(rm);
			}
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::AgentController ::agentupdatesuccess1",e);
			}
				return new ModelAndView("agentupdatesuccess2");
			
		}
		
		
		//AGENT CHANGE PASSWORD......................
	
		@RequestMapping(value = "/agentchangepassword", method = RequestMethod.GET)
		public ModelAndView agentChangePassword1(@ModelAttribute("command")AgentRegistration arg,BindingResult result,HttpServletRequest request) {
			System.out.println("enter into 	agentchangepassword1	 in agent controller");
			try
			{
			HttpSession hs=request.getSession(false);
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("username...."+username);
			System.out.println("password....."+password);
			List<AgentRegistrationModel> li=serviceagent.loginlist(username, password);
			System.out.println(li.size());
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::AgentController ::agentchangepassword",e);
			}

			return new ModelAndView("agentchangepassword2");
		}
		
		//agent change password success
		@RequestMapping(value = "/agentchangepwdsucc1", method = RequestMethod.POST)
		public ModelAndView agentChangepwdSucc1(@ModelAttribute("command")AgentRegistration reg,BindingResult result, HttpServletRequest request) {
			System.out.println("enter into 	agentchangepwdsucc1	 in agent controller");
			
			
			
			
			
			AgentChangepasswordvalidator r=new AgentChangepasswordvalidator();
			r.validate(reg, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("agentchangepassword2");
			}
			
			else{
			String opd=reg.getOldpassword();
			String npd=reg.getPassword();
			String cnpd=reg.getConformpassword();
			System.out.println("oldp..."+opd);
			System.out.println("npd..."+npd);
			System.out.println("cnpd..."+cnpd);
			HttpSession hs=req.getSession(false);
			String username=(String) hs.getAttribute("username");
			String password=(String) hs.getAttribute("password");
			System.out.println("username...."+username);
			System.out.println("password....."+password);

			
			if(opd.equalsIgnoreCase(password)){
			serviceagent.agentChangePassword(username,npd,cnpd);
			serviceagent.agentChangePassworduserlis(username,npd);


				return new ModelAndView("agentchangepwdsucc2");

			}
			else {
				return new ModelAndView("agentchangepassworderror2");
			}
			}
			
		}	
		
			
			
		
		
		//add property
				@RequestMapping(value = "/addproperty", method = RequestMethod.GET)
				public ModelAndView addProperty(@ModelAttribute("command")AddProperty reg,BindingResult result) {
					
					return new ModelAndView("addproperty");
				}
				
		
		//user logout
		@RequestMapping(value = "/agentlogout", method = RequestMethod.GET)
		public ModelAndView agentLogout(@ModelAttribute("command") AgentRegistration bean,BindingResult result,HttpServletRequest request)
		{
				
						HttpSession ses=request.getSession();
						//ses.invalidate();
						String username=(String)ses.getAttribute("username");
						String logintime=(String)ses.getAttribute("logintime");
						DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
						Date dateobj1 = new Date();
						String logouttime = df1.format(dateobj1);
						
						serviceagent.logoutAppLog(username,logintime,logouttime);
				       
				        ses.invalidate();
			return new ModelAndView("agentlogout1");
		
		}
}
