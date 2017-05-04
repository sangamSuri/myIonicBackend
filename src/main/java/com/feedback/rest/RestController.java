package com.feedback.rest;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.feedback.model.Issuer;

import dao.Response;
import dao.StaffDetails;
import dao.StudentDetails;
import dao.User;
import dao.placementDetails;
import dto.DbOperation;

/**
 * Handles requests for the application home page.
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	private Map<String, Issuer> issuers = new HashMap<String, Issuer>();
	private ArrayList<Issuer> ListUser = new ArrayList<Issuer>();
	private Map<String, ArrayList> MapListUser = new HashMap<String, ArrayList>();
	
	/*public RestController() {
		// pre-initialize the list of issuers available ...
		ListUser.add(new Issuer("who is the president of India.?", "false"));
		ListUser.add(new Issuer("who is the president of US?", "false"));
		ListUser.add(new Issuer("who is the president of China?","false"));
		ListUser.add(new Issuer("who is the president of Pak?", "false"));
	}*/
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "status";
	}
	
	@RequestMapping(value="/issuers", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Issuer> getAllIssuers() {
		logger.info("Inside getAllIssuers() method...");
		
		return issuers;
	}
	
	/*@RequestMapping(value="/List", method=RequestMethod.GET)
	@ResponseBody
	public Map<String,ArrayList> getAllIssuersList() {
		logger.info("Inside getAllIssuers() method...");
		MapListUser.put("List", ListUser);
		return MapListUser;
	}*/
	
	@RequestMapping(value="/ListStudentDetails/{id}/sem/{sem}", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentDetails> getStudents(@PathVariable("id") String id,@PathVariable("sem") String sem) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<StudentDetails> questions = new DbOperation().getAllStudents(id,sem);
		return questions;
	}
	
	@RequestMapping(value="/ListStudents/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StudentDetails> getStudent(@PathVariable("id") String id) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<StudentDetails> questions = new DbOperation().getAllStudent(id);
		return questions;
	}
	
	@RequestMapping(value="/ListFac/{id}", method=RequestMethod.GET)
	@ResponseBody
	public ArrayList<StaffDetails> getFaculties(@PathVariable("id") String id) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<StaffDetails> questions = new DbOperation().getAllFaculties();
		return questions;
	}
	 
	@RequestMapping(value="/Login" , method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<Response> deleteIssuerByTicker(@RequestBody User user) {
		ArrayList<Response> LoginStatus = new ArrayList<Response>();
		boolean status=false;
		String branch="";
		System.out.println("UserName"+user.getRole());
		Response _response = new DbOperation().userLogin(user.getUsername(), user.getPassword(),user.getRole());
		 if( _response != null){
			 status = true;
		 }else{
			 status = false;
		 }
		 System.out.println("branch-->"+branch);
		user.setBranch(branch);
		user.setUsername(user.getUsername());
		if(_response.getBranch().toString().equals("")){
			_response.setStatus(false);
		}else{
			_response.setStatus(true);
		}
//		_response.setStatus(status);
		LoginStatus.add(_response);
		 
		return LoginStatus;
	}
 	
	@RequestMapping(value="/RegisterStudent" , method=RequestMethod.POST)
	@ResponseBody
	public boolean registerUser(@RequestBody StudentDetails user) {
		boolean status=false;
		//System.out.println("user"+user.getBranch());
		status = new DbOperation().registerUser(user);
		
		return status;
	}
	
	@RequestMapping(value="/RegisterFac" , method=RequestMethod.POST)
	@ResponseBody
	public boolean registerFac(@RequestBody StaffDetails user) {
		boolean status=false;
		//System.out.println("user"+user.getBranch());
		status = new DbOperation().registerStaf(user);
		
		return status;
	}
	
	@RequestMapping(value="/placement", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> placement(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getPlacementDetaisl(user);
		return _placementDetails;
	}
	
	@RequestMapping(value="/placementText", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> placementText(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getPlacementDetaislText(user);
		return _placementDetails;
	}
	
	@RequestMapping(value="/exams", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> exam(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getExamDetaisl(user);
		return _placementDetails;
	}

	@RequestMapping(value="/examsText", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> examText(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getExamDetaislText(user);
		return _placementDetails;
	}

	@RequestMapping(value="/sports", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> sports(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getSportsDetaisl(user);
		return _placementDetails;
	}
	
	@RequestMapping(value="/sportsText", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> sportsText(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getSportsDetaislText(user);
		return _placementDetails;
	}
	
	
	@RequestMapping(value="/result", method=RequestMethod.POST)
	@ResponseBody
	public ArrayList<placementDetails> result(@RequestBody StudentDetails user) {
		logger.info("Inside getAllIssuers() method...");
		ArrayList<placementDetails> _placementDetails = new DbOperation().getMyResultDetaisl(user);
		return _placementDetails;
	}
	
}
