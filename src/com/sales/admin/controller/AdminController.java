package com.sales.admin.controller;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import net.sf.json.JSONArray;
import net.sf.json.JsonConfig;
import net.sf.json.util.CycleDetectionStrategy;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import org.springframework.web.servlet.ModelAndView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.sales.admin.model.AdminFeedBackModel;
import com.sales.admin.model.AgentRegistrationModel;

import com.sales.admin.bean.AgentRegistration;
import com.sales.admin.bean.FeedBackBean;
import com.sales.admin.service.ServiceAd;
import com.sales.admin.service.ServiceAdmin;
import com.sales.admin.validator.AdminFeedbackValidator;
import com.sales.admin.validator.AgentRegistrationValidator;
import com.sales.agent.bean.PropertyBean;
import com.sales.agent.model.PropertyModel;
import com.sales.home.bean.Registration;
import com.sales.home.model.RegistrationModel;
import com.sales.home.model.UserRole;
import com.sales.home.model.Userslist;
import com.sales.home.validator.RegistrationValidator;
import com.sales.user.validator.Changepasswordvalidator;

@Controller
public class AdminController {
	
	@Autowired
	private ServiceAdmin serviceadmin;     //Service admin is a interface 
	
	@SuppressWarnings("rawtypes")
	@Autowired
	private ServiceAd servicead;      // ServiceAd is a interface
	
	
	private Logger log = Logger.getLogger(AdminController.class);  // apply log4g because find out the errors
	
	
	// admin home view 
	@RequestMapping(value = "/adminhome", method = RequestMethod.GET)
	public ModelAndView welcome() {
		
		return new ModelAndView("adminhome");
	}
	
	
	// view all user list
	@RequestMapping(value = "/viewusers", method = RequestMethod.GET)
	public ModelAndView viewUsers(@ModelAttribute("command")Registration reg,BindingResult result) {
		System.out.println("viewusersssss");
		
		return new ModelAndView("viewusers");
	}
	
	// users grid view
	
	@RequestMapping(value="/usersgrid", method = RequestMethod.GET)
	public void usersGrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletResponse response) throws IOException {
		System.out.println("enter user grid..");
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<RegistrationModel> li=serviceadmin.getallusers();
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

	//admin delete user
	@RequestMapping(value = "/admindeluser", method = RequestMethod.GET)
	public ModelAndView adminDeleteUser(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
		System.out.println("enter delete..usergrid..");
		String ss=request.getParameter("username");
		System.out.println("ids value in delete..."+ss);
		String[] sp=ss.split(",");
		System.out.println("length...."+sp.length);
		for(int i=0;i<sp.length;i++){
			String s=sp[i];
			System.out.println(s);
			serviceadmin.deleteusergrid(s);             // delete user data in grid (we can use id delete the user data)
			/*String modelname="Superadminmodel";
			spradmser.delete(s, modelname);*/
		}
		
		
		return new ModelAndView("viewusers");
	}
	
	
	
	//admin user grid id search
	@RequestMapping(value="/adminusergridsearch", method = RequestMethod.GET)
	public void adminUserGridSearch(@ModelAttribute("command") AgentRegistration dd, 
			
		BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
	

			
			
			PrintWriter pw=null;
	    	pw=response.getWriter();
	    	String uname1=request.getParameter("value");
	    	System.out.println("User:"+uname1);
	    	HttpSession hs=request.getSession();
	    	
	    	
	    	
	    	
	    	hs.setAttribute("user", uname1);
	    
	    	String username=uname1.toLowerCase();
	    	
	    	System.out.println("username isss 123123333"+username);
	    	List<AgentRegistrationModel> li=serviceadmin.searchuserusername(username);
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
	@RequestMapping(value="/adminusergriddate", method = RequestMethod.GET)
	public void adminUserGridDate(@ModelAttribute("command") Registration dd, 
				BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException{
		
	PrintWriter out=null;
	out=response.getWriter();
		System.out.println("enter into date list");
		
		String fromm=request.getParameter("from");  // getting from date to databse 
		System.out.println("date from isssssssssssss"+fromm);
		String[] sd = fromm.split("/");
		
		String from = sd[2]+"-"+sd[1]+"-"+sd[0];
		System.out.println(from);
		String to=request.getParameter("to");     // getting to date from database
		System.out.println("date to isssssssssssss"+to);
		String[] ts = to.split("/");       // split to date
		
		String t = ts[2]+"-"+ts[1]+"-"+ts[0];
		System.out.println(t);
		List l=serviceadmin.userGriddateSearch(from,t);  // sending from date and to date to database and getting the details 
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
	
	//view agents grid page
	@RequestMapping(value = "/viewagents", method = RequestMethod.GET)
	public ModelAndView viewAgents(@ModelAttribute("command")AgentRegistration reg,BindingResult result) {
		System.out.println("viewagentssssss");
		
		return new ModelAndView("viewagents");
		
		}
	
	//view all agents grid list 
	@RequestMapping(value="/agentsgrid", method = RequestMethod.GET)
	public void agentsGrid(@ModelAttribute("command")AgentRegistration sb,BindingResult result,HttpServletResponse response) throws IOException {
		
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();
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
	
	
	//coversation html
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/conversion999",method= RequestMethod.GET)
	public List conversion(@ModelAttribute("command")AgentRegistration ag,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
   {
		System.out.println("enter into conversion999 requestmapping");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();
		String aa="agentsdetails.html";
		res.addHeader("Content-Disposition", "attachment;filename="+aa);
		AgentRegistrationModel agent=new AgentRegistrationModel();
		PrintWriter out=res.getWriter();
		System.out.println("conversiton html@@@@@@@@@@@@@@@@@@@@@@@@@@"+out);
		out.print("<b>AGENTSDETAILS</b>");
		out.print("<table border='1'><tr><th>AGENTID</th><th>ADDRESS</th><th>CITY</th><th>COUNTRY</th><th>DATEOFBIRTH</th><th>DATEOFJOINING</th><th>EMAILID</th><th>FIRSTNAME</th><th>GENDER</th><th>LANGUAGE</th><th>LASTNAME</th><th>MIDDLENAME</th><th>MOBILENUMBER</th><th>PINCODE</th><th>STATE</th><th>USERNAME</th><th>TYPE</th></tr>");
		for (Iterator<AgentRegistrationModel> iterator = li.iterator(); iterator.hasNext();) {
			agent = (AgentRegistrationModel) iterator.next();
			out.print("<tr><td>"+agent.getId()+"</td><td>"+agent.getAddress()+"</td><td>"+agent.getCity()+"</td><td>"+agent.getCountry()+"</td><td>"+agent.getDateofbirth()+"</td><td>"+agent.getDateofjoining()+"</td><td>"+agent.getEmail()+"</td><td>"+agent.getFirstname()+"</td><td>"+agent.getGender()+"</td><td>"+agent.getLanguage()+"</td><td>"+agent.getLastname()+"</td><td>"+agent.getMiddlename()+"</td><td>"+agent.getMobileno()+"</td><td>"+agent.getPincode()+"</td><td>"+agent.getState()+"</td><td>"+agent.getUsername()+"</td><td>"+agent.getType()+"</td></tr>");
		}
	
		out.print("</table>");
		return null;
		
	}
	//conversation pdf
	@RequestMapping(value="/conversionofpdf999",method= RequestMethod.GET)
	public ModelAndView conversionOfPdf(@ModelAttribute("command")AgentRegistration ag,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
	  {
		System.out.println("enter into conversionofpdf999");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();
		return new ModelAndView("pdfView", "listagents",li);
			
			
		}
	//excel view
	
	@RequestMapping(value="/conversionofexcel999",method= RequestMethod.GET)
	public ModelAndView conversionOfExcel(@ModelAttribute("command")AgentRegistration ag,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
		  {
	System.out.println("enter into conversionofexcel999");

	List<AgentRegistrationModel> li=serviceadmin.getallagents();
	

	return new ModelAndView("excelView","listagents",li);
				
			}
	
	// CSV is a comma separated values file which allows data to be saved in a table structured format
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/conversionofcsv999",method= RequestMethod.GET)
	public List conversionOfCsv(@ModelAttribute("command")AgentRegistration ag,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
   {
		System.out.println("enter into conversionofcsv999 requestmapping");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();
		
		String csvFileName = "agentsdetails.csv";
		res.setContentType("text/csv");
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        res.setHeader(headerKey, headerValue);
		//PrintWriter out=response.getWriter();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(res.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "id", "firstname", "middlename", "lastname","username","country","state","city","language","pincode","type","dateofbirth","dateofjoining"};
 
        csvWriter.writeHeader(header);
        for ( AgentRegistrationModel event : li) {
            csvWriter.write(event, header);
        }
 
        csvWriter.close();
		return null;
		
	}
	
	//text view
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/conversionoftext999",method= RequestMethod.GET)
	public List conversionOfText(@ModelAttribute("command")AgentRegistration ag,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
   {
		System.out.println("enter into conversionoftext999 requestmapping");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();

		String csvFileName = "agentsdetails.txt";
		res.setContentType("text/csv");
		String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                csvFileName);
        res.setHeader(headerKey, headerValue);
		//PrintWriter out=response.getWriter();
		
		ICsvBeanWriter csvWriter = new CsvBeanWriter(res.getWriter(),
                CsvPreference.STANDARD_PREFERENCE);
 
        String[] header = { "id", "firstname", "middlename", "lastname","username","country","state","city","language","pincode","type","dateofbirth","dateofjoining"};
 
        csvWriter.writeHeader(header);
        for ( AgentRegistrationModel event : li) {
            csvWriter.write(event, header);
        }
 
        csvWriter.close();
		return null;
		
	}
	
	//conversation of document
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/conversionofdoc999",method= RequestMethod.GET)
	public List conversionOfDoc(@ModelAttribute("command")AgentRegistration bcb,BindingResult result,HttpServletRequest req,HttpServletResponse res,ModelMap map) throws IOException
   {
		System.out.println("enter into conversionofdoc999 requestmapping");
		List<AgentRegistrationModel> li=serviceadmin.getallagents();
		String aa="campdetails.doc";
		res.addHeader("Content-Disposition", "attachment;filename="+aa);
		AgentRegistrationModel agent=new AgentRegistrationModel();
		PrintWriter out=res.getWriter();
		out.print("<b>AGENTSDETAILS</b>");
		out.print("<table border='1'><tr><th>AGENTID</th><th>ADDRESS</th><th>CITY</th><th>COUNTRY</th><th>DATEOFBIRTH</th><th>DATEOFJOINING</th><th>EMAILID</th><th>FIRSTNAME</th><th>GENDER</th><th>LANGUAGE</th><th>LASTNAME</th><th>MIDDLENAME</th><th>MOBILENUMBER</th><th>PINCODE</th><th>STATE</th><th>USERNAME</th><th>TYPE</th></tr>");
		for (Iterator<AgentRegistrationModel> iterator = li.iterator(); iterator.hasNext();) {
			 agent = (AgentRegistrationModel) iterator.next();
				out.print("<tr><td>"+agent.getId()+"</td><td>"+agent.getAddress()+"</td><td>"+agent.getCity()+"</td><td>"+agent.getCountry()+"</td><td>"+agent.getDateofbirth()+"</td><td>"+agent.getDateofjoining()+"</td><td>"+agent.getEmail()+"</td><td>"+agent.getFirstname()+"</td><td>"+agent.getGender()+"</td><td>"+agent.getLanguage()+"</td><td>"+agent.getLastname()+"</td><td>"+agent.getMiddlename()+"</td><td>"+agent.getMobileno()+"</td><td>"+agent.getPincode()+"</td><td>"+agent.getState()+"</td><td>"+agent.getUsername()+"</td><td>"+agent.getType()+"</td></tr>");
		}
	
		out.print("</table>");
		
		return null;
		
	}
	
	//EXPORT TO XML
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/conversionofxml999",method= RequestMethod.GET)
	public List conversionofXml(@ModelAttribute("command")AgentRegistration ag,BindingResult res,HttpServletRequest req,HttpServletResponse resp,ModelMap map) throws IOException
   {
		System.out.println("enter into conversionofxml999 requestmapping");
		try
		{
			DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			System.out.println("...////.....1111");
			// root elements
			Document doc = docBuilder.newDocument();
			Element rootElement = doc.createElement("online");
			doc.appendChild(rootElement);
			System.out.println("....////.... 2222");
			// camp elements
			List<AgentRegistrationModel> li=serviceadmin.getallagents();
			System.out.println("hoo");
			Iterator<AgentRegistrationModel> it = li.iterator();
			while (it.hasNext()) {
				AgentRegistrationModel sm = (AgentRegistrationModel) it.next();
				Element camp = doc.createElement("AGENTSDETAILS");
				rootElement.appendChild(camp);
				
			/*	Attr attr = doc.createAttribute("ID");
				String id=sm.getId();
				attr.setValue(id);             
				camp.setAttributeNode(attr);*/
				
				/*Element id = doc.createElement("ID");
				id.appendChild(doc.createTextNode(sm.getId()));
				camp.appendChild(id);
				*/
				
				Element cn = doc.createElement("ADDRESS");
				cn.appendChild(doc.createTextNode(sm.getAddress()));
				camp.appendChild(cn);
				
				Element contactname = doc.createElement("CITY");
				contactname.appendChild(doc.createTextNode(sm.getCity()));
				camp.appendChild(contactname);
				
				Element dt = doc.createElement("COUNTRY");
				dt.appendChild(doc.createTextNode(sm.getCountry()));
				camp.appendChild(dt);
				
				
				Element city = doc.createElement("DATEOFBIRTH");
				city.appendChild(doc.createTextNode(sm.getDateofbirth()));
				camp.appendChild(city);
				
				Element cpno = doc.createElement("DATEOFJOINING");
				cpno.appendChild(doc.createTextNode(sm.getDateofjoining()));
				camp.appendChild(cpno);
				
				Element cpem = doc.createElement("EMAILID");
				cpem.appendChild(doc.createTextNode(sm.getEmail()));
				camp.appendChild(cpem);
				
				Element co = doc.createElement("FIRSTNAME");
				co.appendChild(doc.createTextNode(sm.getFirstname()));
				camp.appendChild(co);
				
				Element st = doc.createElement("GENDER");
				st.appendChild(doc.createTextNode(sm.getGender()));
				camp.appendChild(st);
				
				Element cpad = doc.createElement("LANGUAGE");
				cpad.appendChild(doc.createTextNode(sm.getLanguage()));
				camp.appendChild(cpad);
				
				
				Element cpdon = doc.createElement("LASTNAME");
				cpdon.appendChild(doc.createTextNode(sm.getLastname()));
				camp.appendChild(cpdon);
				
				
				Element cppin = doc.createElement("MIDDLENAME");
				cppin.appendChild(doc.createTextNode(sm.getMiddlename()));
				camp.appendChild(cppin);
				
				
				Element cpstatus = doc.createElement("MOBILENUMBER");
				cpstatus.appendChild(doc.createTextNode(sm.getMobileno()));
				camp.appendChild(cpstatus);
				
				
				Element cpuser = doc.createElement("PINCODE");
				cpuser.appendChild(doc.createTextNode(sm.getPincode()));
				camp.appendChild(cpuser);
				
				Element cptype = doc.createElement("TYPE");
				cptype .appendChild(doc.createTextNode(sm.getType()));
				camp.appendChild(cptype);
				

				Element cpusername = doc.createElement("username");
				cpusername .appendChild(doc.createTextNode(sm.getUsername()));
				camp.appendChild(cpusername);
				
				
			}
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				
				
				StreamResult result =  new StreamResult("E:\\agents.xml");
				System.out.println("agents details iss"+result);
				transformer.transform(source, result);
				
			System.out.println("ending.......");
		
		}
		catch (ParserConfigurationException pce) {
			pce.printStackTrace();
		  } catch (TransformerException tfe) {
			tfe.printStackTrace();
		  }
		PrintWriter out = resp.getWriter();  
		String filename = "agents.xml";   
		String filepath = "E:\\";   
		resp.setContentType("APPLICATION/OCTET-STREAM");   
		resp.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");   
		  
		FileInputStream fileInputStream = new FileInputStream(filepath + filename);  
		            
		int i;   
		while ((i=fileInputStream.read()) != -1) {  
		out.write(i);   
		}   
		fileInputStream.close();   
		out.close();  
		
		return null;
		
	}
	
	
	
	
	// Import files
	
				@RequestMapping(value = "/openjsp", method = RequestMethod.GET)
				public ModelAndView openJspExel(@ModelAttribute("command")  AgentRegistration ag, ServletResponse response, ServletRequest request  ){

					
				     return new ModelAndView("openjsp");
				 }
				
				@SuppressWarnings("deprecation")
				@RequestMapping(value = "/gettingexcel",method=RequestMethod.POST)
				public ModelAndView processExcel2003(@RequestParam(value = "excelfile", required = false) MultipartFile  excelfile) {		
					
					System.out.println("comming1 ");
					
					try {
						
						System.out.println("comming ");
						List<AgentRegistrationModel> liagent=serviceadmin.getallagents();						int i = 1;
						System.out.println("age2222222222222222222222"+excelfile.getInputStream());
						// Creates a workbook object from the uploaded excelfile
						HSSFWorkbook workbook = new HSSFWorkbook(excelfile.getInputStream());
						System.out.println(workbook.getNumberOfSheets());
						// Creates a worksheet object representing the first sheet
						HSSFSheet worksheet = workbook.getSheetAt(0);
						// Reads the data in excel file until last row is encountered
						while (i <= worksheet.getLastRowNum()) {
						
							System.out.println("i isss @@@@@@@@@@"+(i <= worksheet.getLastRowNum()));
							// Creates an object representing a single row in excel
							HSSFRow row = worksheet.getRow(i++);
							System.out.println("row lengthhhhhh"+row);
							// Sets the Read data to the model class
							//fir.setId( (int) row.getCell( (short) 0).getNumericCellValue());
							
							AgentRegistrationModel agent=new AgentRegistrationModel();
							
							agent.setAddress(row.getCell((short) 1).getStringCellValue());
							
							agent.setCity(row.getCell((short) 2).getStringCellValue());
							agent.setCountry(row.getCell((short) 3).getStringCellValue());
						agent.setDateofbirth(row.getCell((short) 4).getStringCellValue());
							
							agent.setDateofjoining(row.getCell((short) 5).getStringCellValue());
							
                          
							
							agent.setEmail(row.getCell((short) 6).getStringCellValue());
							
                            agent.setFirstname(row.getCell((short) 7).getStringCellValue());
							
							agent.setGender(row.getCell((short) 8).getStringCellValue());
							
                             agent.setLanguage(row.getCell((short) 9).getStringCellValue());
							
							agent.setLastname(row.getCell((short) 10).getStringCellValue());
							
                              agent.setMiddlename(row.getCell((short) 11).getStringCellValue());
							
							agent.setMobileno(row.getCell((short) 12).getStringCellValue());
							
                              agent.setPincode(row.getCell((short) 13).getStringCellValue());
							
							agent.setState(row.getCell((short) 14).getStringCellValue());
							
                          agent.setType(row.getCell((short) 15).getStringCellValue());
							
							agent.setUsername(row.getCell((short) 16).getStringCellValue());
						
							
							String at="AGENT001";
							
							agent.setId(at);

							
							String l=at.substring(0,5);
							
							String l2=at.substring(5,8);
							
							Integer l3 = Integer.valueOf(l2);
							
							

							List<AgentRegistrationModel> li=serviceadmin.getallagents();
							 
							 
							 for(int i1 =0; i1<=li.size(); i1++){
								 l3=i1;
								 
								 
								 System.out.println("looppppppppp"+l3);
							 }
							 
							 
							 l3=l3+1;
							 System.out.println("last values"+l3);
							  l2=Integer.toString(l3);
							  
							   if(l2.length()==1){
								   
								   System.out.println("l2 lengthhhhhh"+(l2.length()==1));
								   
								String id=l+"00"+l3;
								System.out.println("id valueeeeeeeeeeeeeeee"+id);
								
								agent.setId(id);
							   }
							   
							   else if(l2.length()==2){
								   
								   System.out.println("l2 lengthhhhhh"+(l2.length()==1));
								 
								   
								String id=l+"0"+l3;
								System.out.println("id valueeeeeeeeeeeeeeee"+id);
								agent.setId(id);
							
							
							
							   }
							 
							
							serviceadmin.addagents(agent);
						liagent.add(agent);
									
						}
					

					} catch (Exception e) {
						e.printStackTrace();
					}
					return new ModelAndView("addexcel");
				}

	//add agent 
	@RequestMapping(value = "/addagent", method = RequestMethod.GET)
	public ModelAndView addAgent(@ModelAttribute("command")AgentRegistration reg,BindingResult result) {
		
		return new ModelAndView("addagent1");
	}
	
	
	@SuppressWarnings("unused")
	@RequestMapping(value = "/addagentsuccess", method = RequestMethod.POST)
	public ModelAndView addAgentSuccess(@ModelAttribute("command")AgentRegistration rg,BindingResult result,AgentRegistrationModel agntmdl,Userslist uli,UserRole ur) {
		
		
		try
		{
		System.out.println("enter register controller..");
		AgentRegistrationValidator r=new AgentRegistrationValidator();
		r.validate(rg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("addagent1");
		}
		else
		{
		String from=rg.getDateofjoining();
		System.out.println(from);
		DateFormat dff = new SimpleDateFormat("yyyy-dd-MM");
		Date date = new Date();
		String d=dff.format(date);
		String[] sd = from.split("/");
		
		String sentdate = sd[2]+"-"+sd[1]+"-"+sd[0];
		System.out.println(sentdate);
		agntmdl.setDateofjoining(sentdate);
		agntmdl.setType("ROLE_AGENT");
		agntmdl.setStatus("Pending");
		String at="AGENT001";
		
		agntmdl.setId(at);

		
		
		// Spring security
		  
					uli.setUsername(rg.getUsername());
					uli.setPassword(rg.getPassword());
					uli.setEnabled(false);
					uli.setStatus("inactive");
					servicead.add(uli);     //save user name and password user list model 
			  
					ur.setRole("ROLE_AGENT");				  
					ur.setUsersListModel(uli);
					servicead.add(ur);          // spring security close
		
		String l=at.substring(0,5);
		
		String l2=at.substring(5,8);
		
		Integer l3 = Integer.valueOf(l2);
		
		

		List<AgentRegistrationModel> li=serviceadmin.getallagents();
		 
		 
		 for(int i =0; i<=li.size(); i++){
			 l3=i;
			 
			 
			 System.out.println("looppppppppp"+l3);
		 }
		 
		 
		 l3=l3+1;
		 System.out.println("last values"+l3);
		  l2=Integer.toString(l3);
		  
		   if(l2.length()==1){
			   
			   System.out.println("l2 lengthhhhhh"+(l2.length()==1));
			   
			String id=l+"00"+l3;
			System.out.println("id valueeeeeeeeeeeeeeee"+id);
			agntmdl.setDateofjoining(sentdate);
			agntmdl.setId(id);
		   }
		   
		   else if(l2.length()==2){
			   
			   System.out.println("l2 lengthhhhhh"+(l2.length()==1));
			   agntmdl.setDateofjoining(sentdate);
			   
			String id=l+"0"+l3;
			System.out.println("id valueeeeeeeeeeeeeeee"+id);
			agntmdl.setId(id);
		
		
		
		   }
		 
		
		/*serviceadmin.addagentregistration(agntmdl);
		*/
		
			servicead.add(agntmdl);
		String umne=rg.getUsername();
		String pwd=rg.getPassword();
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
			String url = "http://localhost:2223/OnlinePropertySale/mailapproveagentregister.html?unme="+umne+"&status="+status;
			Message message = new MimeMessage(session); 
			message.setFrom(new InternetAddress(Username));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(
							rg.getEmail()));
			
			message.setSubject("You are Registered successfully!");
			message.setText("Your username  is : "
					+rg.getUsername()
					+ " \nYour Password is:"
					+ rg.getPassword()
					
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
		log.error("Online Property Sales::AdminController ::addagentsuccess",e);
	}
		   	
	return new ModelAndView("addagentsuccess1");

	
	}
	//mail approve
	
	@SuppressWarnings("unused")
	@RequestMapping(value="mailapproveagentregister", method = RequestMethod.GET)
	public ModelAndView mailApprove(@ModelAttribute("command") AgentRegistration reg,HttpServletRequest request) {
		
		System.out.println("enter....mail approve...");
		String status = request.getParameter("status");    // getting agent status 
		String unme = request.getParameter("unme");       // getting agent name 
		String pwd=request.getParameter("pwd");
		System.out.println("status.."+status);
		System.out.println("username..."+unme);
		
		serviceadmin.statusagentchange(unme,status);  // where user name is status change approved when user click the mail link
		System.out.println("end sts...");
		serviceadmin.statusenable(unme);
		
		return new ModelAndView("login2");
	}
	
	//admin agent delete user
		@RequestMapping(value = "/admindelagent", method = RequestMethod.GET)
		public ModelAndView adminDeleteAgent(@ModelAttribute("command")AgentRegistration reg,BindingResult result,HttpServletRequest request) {
			System.out.println("enter delete..usergrid..");
			String ss=request.getParameter("username");
			System.out.println("ids value in delete..."+ss);
			String[] sp=ss.split(",");     // admin agent id split because getting more ids delete 
			System.out.println("length...."+sp.length);
			for(int i=0;i<sp.length;i++){
				String s=sp[i];
				System.out.println(s);
				serviceadmin.deleteagentgrid(s);
				/*String modelname="Superadminmodel";
				spradmser.delete(s, modelname);*/
			}
			
			
			return new ModelAndView("viewagents");
		}
		
	
	//admin agent grid id search 

		@RequestMapping(value="/adminagentgridsearch", method = RequestMethod.GET)
		public void adminAgentGridSearch(@ModelAttribute("command") AgentRegistration dd, 
				
			BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
		

				
				
				PrintWriter pw=null;
		    	pw=response.getWriter();
		    	String uname1=request.getParameter("value");
		    	System.out.println("User:"+uname1);
		    	HttpSession hs=request.getSession();
		    	
		    	
		    	
		    	
		    	hs.setAttribute("user", uname1);
		    	System.out.println("before");
		    	String username=uname1.toLowerCase();
		    	List<AgentRegistrationModel> li=serviceadmin.searchagentusername(username);    // getting agent list
		    	System.out.println(li.size());
		    	JsonConfig jsonConfig = new JsonConfig();
				jsonConfig.setExcludes(new String[]{"li"});   // put jsn config agnet list
				jsonConfig.setIgnoreDefaultExcludes(false);
				jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
				JSONArray array = JSONArray.fromObject(li,jsonConfig);
				System.out.println(array);
				pw.print(array);
				 pw.flush();
			     pw.close();
				
			
			}
		
		
		// admin agent grid date
		@RequestMapping(value="/adminagentgriddate", method = RequestMethod.GET)
		public void adminAgentGridDate(@ModelAttribute("command") AgentRegistration dd, 
					BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException{
			
		PrintWriter out=null;
		out=response.getWriter();
			System.out.println("enter into date list");
			
			String fromm=request.getParameter("from");  // getting from date in database
			System.out.println("date from isssssssssssss"+fromm);
			String[] sd = fromm.split("/");
			
			String from = sd[2]+"-"+sd[1]+"-"+sd[0];
			System.out.println(from);
			String to=request.getParameter("to");      // getting to date form database
			System.out.println("date to isssssssssssss"+to);
			String[] ts = to.split("/");
			
			String t = ts[2]+"-"+ts[1]+"-"+ts[0];
			System.out.println(t);
			List<AgentRegistrationModel> l=serviceadmin.agentGriddateSearch(from,t);
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
		
	
		//UPDATE list view 
	
		@SuppressWarnings("rawtypes")
		@RequestMapping(value = "/updateagent", method = RequestMethod.GET)
		public ModelAndView updateAgent(@ModelAttribute("command")AgentRegistration reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
			try
			{
			System.out.println("enter edit cntlr...");
			String username=request.getParameter("username");
			System.out.println("username....."+username);
			AgentRegistrationModel sb=null;
			List<AgentRegistrationModel> li=serviceadmin.getallagent(username);  // update agent profile where user name
			for (Iterator iterator = li.iterator(); iterator.hasNext();) {
				sb = (AgentRegistrationModel) iterator.next();
				
			}
			BeanUtils.copyProperties(reg, sb);
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::AdminController ::updateagent",e);
			}
				
			return new ModelAndView("updateagent1");
		}
	
		//UPDATE SUCCESS PAGE
	
		@RequestMapping(value = "/updateagentsuccess", method = RequestMethod.POST)
		public ModelAndView updateAgentSuc(@ModelAttribute("command")AgentRegistration reg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
			try
			{
			System.out.println("enter register controller..");
			AgentRegistrationValidator r=new AgentRegistrationValidator();
			r.validate(reg, result);
			if(result.hasErrors()){
				System.out.println("error..page..");
				return new ModelAndView("updateagent1");
			}
			else{
				AgentRegistrationModel am=new AgentRegistrationModel();
				BeanUtils.copyProperties(am,reg);	
			serviceadmin.updateagentgrid(am);
			}
			}
			catch(Exception e)
			{
				log.error("Online Property Sales::AdminController ::updateagentsuccess",e);
			}
			return new ModelAndView("addagentsuccess1");
			
			
		}
		
	//ADMIN UPDATE PROFILE VIEW PAGE	
		
	@RequestMapping(value = "/adminupdateprofile", method = RequestMethod.GET)
	public ModelAndView adminUpdateProfile(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
	 	
		try
		{
		
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("in session un"+username);
		System.out.println("in session pwd"+password);
		RegistrationModel rm=null;
		
		List<RegistrationModel> li=serviceadmin.loginlist(username,password);
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
			log.error("Online Property Sales::AdminController ::adminupdateprofile",e);
		}
		return new ModelAndView("adminupdateprofile1");
	}
	
	
// ADMIN UPDATE PROFILE SUCCESS
	@RequestMapping(value = "/adminupdateprofilesucc", method = RequestMethod.POST)
	public ModelAndView adminUpdateProfileSuccess(@ModelAttribute("command")Registration reg,BindingResult result) throws IllegalAccessException, InvocationTargetException {
		
		try
		{
		RegistrationModel rm=new RegistrationModel();
		System.out.println("The registration model is "+rm);

		RegistrationValidator r=new RegistrationValidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			
			return new ModelAndView("adminupdateprofile1");
		}
		else
		{
		BeanUtils.copyProperties(rm, reg);
		
		System.out.println(reg.getId());
		System.out.println(reg.getRegisterdate());
		
			
	
	
		serviceadmin.updateadminprofile(rm);
		}
		}
		catch(Exception e)
		{   
			log.error("Online Property Sales::AdminController ::adminupdateprofilesucc",e);
		}
			
		return new ModelAndView("adminupdateprofilesucc1");
		
	}
	
	//admin change password
	@RequestMapping(value = "/adminchangepassword", method = RequestMethod.GET)
	public ModelAndView adminChangePassword(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
		HttpSession hs=request.getSession(false);
		String username=(String) hs.getAttribute("username");
		String password=(String) hs.getAttribute("password");
		System.out.println("username...."+username);
		System.out.println("password....."+password);
		List<RegistrationModel> li=serviceadmin.loginlist(username, password);
		System.out.println(li.size());
		
		return new ModelAndView("adminchangepassword1");
	}
	
	// admin change password success
	@SuppressWarnings("unused")
	@RequestMapping(value = "/adminchangepwdsucc", method = RequestMethod.POST)
	public ModelAndView adminChangePwdSuccess(@ModelAttribute("command")Registration reg,BindingResult result,HttpServletRequest request) {
	
		
		
		
		
		

		Changepasswordvalidator r=new Changepasswordvalidator();
		r.validate(reg, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("adminchangepassword1");
		}
		
		HttpSession ses=request.getSession(false);
		String username=(String) ses.getAttribute("username");
		String password=(String) ses.getAttribute("password");
		List<RegistrationModel> li=serviceadmin.loginlist(username,password);
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
			
				serviceadmin.adminchangepassword(id,newpassword,confirmnewpwd);
				serviceadmin.adminchangepassworduserli(id,newpassword);

				 return new ModelAndView("userchangepwdsucc1");
			}
		}
		 return new ModelAndView("userchangepwdfail");
			
	
	}
	
		
	
	
	//admin feedback grid view
	@RequestMapping(value = "/viewadminfeedbacks", method = RequestMethod.GET)
	public ModelAndView viewFeedBacks() {
		
		return new ModelAndView("viewadminfeedbacks1");
	}
	//admin feedback grid view list
	@RequestMapping(value="/adminfeedbackgrid", method = RequestMethod.GET)
	public void adminFeedBackGrid(@ModelAttribute("command") FeedBackBean fb,HttpServletResponse response) throws IOException {
		
		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
		List<AdminFeedBackModel> li=serviceadmin.getAllFeedbacks();
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
	//replay feed back admin
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/replyfeedbackadmin",method=RequestMethod.GET)
	public ModelAndView replyFeedBackAdmin(@ModelAttribute("command")FeedBackBean fdb,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException{
		
		
		System.out.println("enter edit cntlr...");
		String id=request.getParameter("id");
		System.out.println("username....."+id);
		AdminFeedBackModel sb=null;
		List<AdminFeedBackModel> li=serviceadmin.getallfeedbacks(id);
		for (Iterator iterator = li.iterator(); iterator.hasNext();) {
			sb = (AdminFeedBackModel) iterator.next();
			
		}
		BeanUtils.copyProperties(fdb, sb);
		
		return new ModelAndView("replyfeedbackadmin1");

	}
	
	//replay feedback success 
	
	@SuppressWarnings("unused")
	@RequestMapping(value="/replyfeedbacksuccess",method=RequestMethod.POST)
	public ModelAndView replyFeedbackSuccess(@ModelAttribute("command")FeedBackBean fdb,BindingResult result,HttpServletRequest request) throws IllegalAccessException, InvocationTargetException, AddressException, MessagingException{
		
		AdminFeedbackValidator a=new AdminFeedbackValidator();
		a.validate(fdb, result);
		if(result.hasErrors()){
			System.out.println("error..page..");
			return new ModelAndView("replyfeedbackadmin1");
		}
		else{
		AdminFeedBackModel am=new AdminFeedBackModel();
			BeanUtils.copyProperties(am,fdb);
			am.setStatus("Close");
			String eml=fdb.getEmail();
			//System.out.println(eml);
			String rpl=fdb.getReply();
			//System.out.println(rpl);
		serviceadmin.replyupdateadmin(am);
		
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
							eml));
		
			message.setSubject("Your FeedBack has been recieved");
			message.setText("Reply: "
					+ rpl
					);
			 Transport.send(message);						
			System.out.println("mail sent successfuly");
		return new ModelAndView("addagentsuccess1");

	}
	}
	
	//admin feed back grid id search
	@RequestMapping(value="/adminfeedbackgridsearch", method = RequestMethod.GET)
	public void adminFeedBackgridSearch(@ModelAttribute("command") FeedBackBean dd, 
			
		BindingResult result,HttpServletResponse response,HttpServletRequest request) throws IOException {
	

		PrintWriter out=null;
		out=response.getWriter();
		System.out.println("enter into datagrid list");
			String usernam=request.getParameter("value");
			
			System.out.println("value isssssssssssss"+usernam);
			String username=usernam.toLowerCase();
			List<AdminFeedBackModel> li=serviceadmin.searchadminfeedback(username);
			System.out.println("list size is gid1: "+li.size());
			JsonConfig jsonConfig = new JsonConfig();
			jsonConfig.setExcludes(new String[]{"li"});
			jsonConfig.setIgnoreDefaultExcludes(false);
			jsonConfig.setCycleDetectionStrategy(CycleDetectionStrategy.LENIENT);
			JSONArray array = JSONArray.fromObject(li,jsonConfig);
			//System.out.println(array);
			out.print(array);
			 out.flush();
		     out.close();
		
		}
	
	//admin feed back grid date
	@SuppressWarnings({ "rawtypes" })
	@RequestMapping(value="/adminfeedbackgriddate", method = RequestMethod.GET)
	public void date(@ModelAttribute("command") FeedBackBean dd, 
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
		     List l=serviceadmin.datefeedbackSearch(from,t);
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
						
						//return array;
		
		}
	
	//view all properties
	@RequestMapping(value = "/adminviewproperties", method = RequestMethod.GET)
	public ModelAndView viewProperties() {
		
		return new ModelAndView("adminviewproperties");
	}
	
	//admin property Details view 
			@RequestMapping(value="/adminpropertylist", method = RequestMethod.GET)
			public void adminpropertygrid(@ModelAttribute("command")Registration sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
				System.out.println("enter property list grid..");
				PrintWriter out=null;
				out=response.getWriter();
				
				System.out.println("enter into datagrid property  list");
				List<PropertyModel> li=serviceadmin.getallproperties();
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
			//admin property grid id search
			
			@RequestMapping(value="/adminpropertygrididserach", method = RequestMethod.GET)
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
			    	
			    	List<PropertyModel> li=serviceadmin.searchpropertyusername(username);
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
			
			// admin property grid date
						@SuppressWarnings("rawtypes")
						@RequestMapping(value="/adminpropertygriddate", method = RequestMethod.GET)
						public void adminprPertyGridDate(@ModelAttribute("command") PropertyBean dd, 
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
							List l=serviceadmin.adminpropertyGriddateSearch(from,t);
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
					
					
						
						
						//admin property refresh
						@RequestMapping(value="/adminpropertyrefresh", method = RequestMethod.GET)
						public void agentRefresh(@ModelAttribute("command")PropertyBean sb,BindingResult result,HttpServletRequest request,HttpServletResponse response) throws IOException {
							System.out.println("enter property list grid..");
							PrintWriter out=null;
							out=response.getWriter();
							
							System.out.println("enter into datagrid property  list");
							List<PropertyModel> li=serviceadmin.getallproperties();
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
						
				
						
						// Database  export and import
						
						@SuppressWarnings("unused")
						@RequestMapping(value="/exportdb" ,method = RequestMethod.GET)
						public ModelAndView exportDb(@ModelAttribute("command") Registration bean,BindingResult result)
						{
							
							try {
						    	  
								  String path="D:/nagesh/onlinepropertyDmp";
								
						    	  String str = "exp sales/sales file= "+path;
						    	  
						    	  Process process = Runtime.getRuntime().exec(str);
								  BufferedReader in = 
								             new BufferedReader(new InputStreamReader(process.getErrorStream()));
								  String line = null;
								  while ((line = in.readLine()) != null) {
								  
								  }
								    	  
						          
							   
							   }
								catch (Exception e) {
							    System.out.println(e);
							   }
							return new ModelAndView("dbexport1");	
							
							
						}
						@SuppressWarnings("unused")
						@RequestMapping(value="/importdb" ,method = RequestMethod.GET)
						public ModelAndView importDb(@ModelAttribute("command") Registration bean,BindingResult result)
						{
						
							
						 try {
						    	  
						    	  String[] str = {"imp", "sales/sales file=D:/nagesh/onlinepropertyDmp.DMP", 
						                  "fromuser=sales", "touser=nagesh", 
						                  "full=N ignore=Y grants=Y indexes=Y;"};

						    	  Process process = Runtime.getRuntime().exec(str);
								  BufferedReader in = 
								             new BufferedReader(new InputStreamReader(process.getErrorStream()));
								  String line = null;
								  while ((line = in.readLine()) != null) {
								  }
								    	  
						          
							   
							 }
							 catch (Exception e) {
							   System.out.println(e);
							 }
						 return new ModelAndView("dbimport1");
						}
					
					
								
						
						
						
						
						
			
	//Admin logout page
	
	@RequestMapping(value = "/adminlogout", method = RequestMethod.GET)

		public ModelAndView adminLogout(@ModelAttribute("command") Registration bean,BindingResult result,HttpServletRequest request){

		HttpSession ses=request.getSession();
		
		String username=(String)ses.getAttribute("username");
		
		System.out.println("username isssss "+username);
		String logintime=(String)ses.getAttribute("logintime");
		DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		Date dateobj1 = new Date();
		String logouttime = df1.format(dateobj1);
		
		serviceadmin.logoutAppLog(username,logintime,logouttime);
       
        ses.invalidate();
		return new ModelAndView("adminlogout1");
	}
	
	
	
	}
	
	
	
	
	
	
