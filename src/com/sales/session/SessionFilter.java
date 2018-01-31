package com.sales.session;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.OncePerRequestFilter;

public class SessionFilter  extends OncePerRequestFilter  {

	@SuppressWarnings("unused")
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		    // TODO Auto-generated method stub
			HttpSession ses=request.getSession();
			RequestDispatcher rd=null;
		    String path = request.getServletPath();
		    System.out.println("the Path is : "+path);
		    
		    if(path.equals("/index.html")||path.equals("/aboutus.html")||path.equals("/contactus.html")||path.equals("/forgotpassword.html")||path.equals("/forgotpasswordcheck.html")||path.equals("/usernameuniquehome.html")
		    		||path.equals("/emailduniquehome.html")||path.equals("/registration.html")||path.equals("/registersuccess.html")||path.equals("/homemailapproveagentregister.html")||path.equals("/login1.html")
		    		||path.equals("/loginsuccess.html"))
		    		
		{
			
			 chain.doFilter(request, response);
			 
	
		}
		else
		{
			String username = null;
			try
			{
				 HttpSession as = request.getSession(false);
				 username = (String) as.getAttribute("username");
			}
			catch(Exception e)
			{
				System.out.println(e);
				
			}
		   
			if(username==null)
			{

				if(path.equals("/viewusers.html")||path.equals("/usersgrid.html")||path.equals("/admindeluser.html")||path.equals("/adminusergridsearch.html")||path.equals("/adminusergriddate.html")
						
						||path.equals("/viewagents.html")||path.equals("/agentsgrid.html")||path.equals("/addagent.html")||path.equals("/addagentsuccess.html")||path.equals("/mailapproveagentregister.html")||path.equals("/admindelagent.html")
						||path.equals("/adminagentgridsearch.html")||path.equals("/adminagentgriddate.html")||path.equals("/updateagent.html")||path.equals("/updateagentsuccess.html")||path.equals("/adminupdateprofile.html")||path.equals("/adminupdateprofilesucc.html")||path.equals("/adminchangepassword.html")
						||path.equals("/adminchangepwdsucc.html")||path.equals("/viewadminfeedbacks.html")||path.equals("/adminfeedbackgrid.html")||path.equals("/replyfeedbackadmin.html")
						||path.equals("/replyfeedbacksuccess.html")||path.equals("/adminfeedbackgridsearch.html")||path.equals("/adminfeedbackgriddate.html")||path.equals("/adminviewproperties.html")||path.equals("/adminpropertylist.html")||path.equals("/adminpropertygrididserach.html")
						||path.equals("/adminpropertygriddate.html")||path.equals("/adminpropertyrefresh.html")||path.equals("/adminlogout.html")||path.equals("/agenthome.html")||path.equals("/viewuser.html")||path.equals("/agentsusersgrid.html")||path.equals("/adduser.html")
						||path.equals("/agentaddusersuccess.html")||path.equals("/mailapproveagentregisteruser.html")||path.equals("/updateuser.html")||path.equals("/updateusersuccess.html")
						||path.equals("/agentdeluser.html")||path.equals("/agentusergridsearch.html")||path.equals("/agentusergriddate.html")||path.equals("/agentusersrefresh.html")||path.equals("/propertyagentdeletegrid.html")||path.equals("/viewagentfeedback.html")
						||path.equals("/addagentfeedback.html")||path.equals("/agentfeedbackgrid.html")||path.equals("/agentfeedbacksave.html")||path.equals("/viewproperty.html")||path.equals("/propertyadd.html")||path.equals("/agentpropertysuccess.html")||path.equals("/agentupdateproperty.html")
						||path.equals("/agentpudatepropertysuccess.html")||path.equals("/agentpropertylist.html")||path.equals("/agentpropertygrididserach.html")||path.equals("/agentpropertygriddate.html")
						||path.equals("/agentpropertyrefresh.html")||path.equals("/agentupdateprofile.html")||path.equals("/agentupdatesuccess1.html")||path.equals("/agentchangepassword.html")||path.equals("/agentchangepwdsucc1.html")||path.equals("/addproperty.html")
						||path.equals("/agentlogout.html")||path.equals("/userhome.html")||path.equals("/viewuserfeedback.html")||path.equals("/userfeedbacksave.html")||path.equals("/userupdateprofile.html")||path.equals("/userupdateprofilesucc.html")||path.equals("/propertyview.html")
						||path.equals("/userpropertylist.html")||path.equals("/userpropertyrefresh.html")||path.equals("/userpropertygrididserach.html")||path.equals("/userpropertygriddate.html")
						||path.equals("/userchangepassword.html")||path.equals("/userchangepwdsucc.html")||path.equals("/userlogout.html"))
				
				
				{
					rd=request.getRequestDispatcher("psessionexpire.html");
			        rd.forward(request,response);
				}
				else
				{
					rd=request.getRequestDispatcher("sessionexpire.html");
					rd.forward(request,response);
				}
				
			}
			else
			{
				chain.doFilter(request, response);
			}
		}
		
	}
	}