package dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.Response;
import dao.ResultObj;
import dao.StaffDetails;
import dao.StudentDetails;
import dao.User;
import dao.placementDetails;

public class DbOperation {
	private Connection con;
	public Response userLogin(String userName, String pass,String role ){
		String branch="";
		Response response = new Response(); 
		try{
			con = GetDbCon.getCon();
			Statement getUesr = con.createStatement();
			if(role.equals("Student")){
				if(userName.contains("@")){
					ResultSet status_=	getUesr.executeQuery("SELECT * FROM students WHERE email='"+userName+"' and PASSWORD='"+pass+"' and studentStatus = 'true'");
					if(status_.next()){
					//branch = status_.getString(1);
					
					response.setBranch(status_.getString("branch"));
					response.setSem(status_.getString("sem"));
					response.setRole(status_.getString("role"));
					response.setId(status_.getString("studentUSN"));
					
					}else{
						response.setBranch("");
					}
				}else{
					ResultSet status_ = getUesr.executeQuery("SELECT * FROM students WHERE studentUSN='"+userName+"' and PASSWORD='"+pass+"'and  studentStatus = 'true'");
					if(status_.next()){
						//branch = status_.getString(1);
						response.setBranch(status_.getString("branch"));
						response.setSem(status_.getString("sem"));
						response.setRole(status_.getString("role"));
						response.setId(status_.getString("studentUSN"));
						}else{
							response.setBranch("");
					}
					System.out.println(branch); 
				}	
				
			}else{
				ResultSet status = getUesr.executeQuery("SELECT * FROM faculty WHERE usn_id='"+userName+"' and PASSWORD='"+pass+"' facstatus='true'");
				if(status.next()){
				response.setBranch(status.getString("dept"));
				response.setRole(status.getString("designation"));
				}else{
					response.setBranch("");
					
				}
			}
			//status = getUesr.execute("SELECT * FROM USER_REG WHERE USERNAME='"+userName+"' and PASSWORD='"+pass+"'");
		}catch(Exception e){
			e.printStackTrace();
			branch =null;
		}
		return response;
	}
	
	public boolean registerUser(StudentDetails userDetails){
		boolean status=false;
		try{
			con = GetDbCon.getCon();
			PreparedStatement insertUesr = con.prepareStatement("INSERT INTO ait_student.students values(?,?,?,?,?,?,?,?,?,?)");
			insertUesr.setString(1, userDetails.getStudentName().toString());
			insertUesr.setString(2, userDetails.getStudentUSN().toString());
			insertUesr.setString(3, userDetails.getStuuserName().toString());
			insertUesr.setString(4, userDetails.getMobileNo().toString());
			insertUesr.setString(5, userDetails.getEmail().toString());
			insertUesr.setString(6, userDetails.getBranch().toString());
			insertUesr.setString(7, userDetails.getSem().toString());
			insertUesr.setString(8, userDetails.getPassword().toString());
			insertUesr.setString(9, "Student");
			insertUesr.setString(10, "false");
			
			
			int x  = insertUesr.executeUpdate();
//			int x = insertUesr.executeUpdate("INSERT INTO ait_student.students (`studentName`, `studentUSN`, `stuuserName`, `mobileNo`, email, branch, sem, password) VALUES "
					
			if(x!=0){
				status = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
	public boolean registerStaf(StaffDetails userDetails){
		boolean status=false;
		try{
			con = GetDbCon.getCon();
			PreparedStatement insertUesr = con.prepareStatement("INSERT INTO ait_student.faculty values(?,?,?,?,?,?,?,?,?)");
			insertUesr.setString(1, userDetails.getFname().toString());
			insertUesr.setString(2, userDetails.getLname().toString());
			insertUesr.setString(3, userDetails.getFmobile().toString());
			insertUesr.setString(4, userDetails.getUsn_id().toString());
			insertUesr.setString(5, userDetails.getDept().toString());
			insertUesr.setString(6, userDetails.getDesination().toString());
			insertUesr.setString(7, userDetails.getPassword().toString());
			insertUesr.setString(8, "false");
			insertUesr.setString(9, userDetails.getEmail().toString());
			
			int x  = insertUesr.executeUpdate();

			if(x!=0){
				status = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
	
/*	public boolean insertQuestion(String question){
		boolean status=false;
		try{
			con = GetDbCon.getCon();
			Statement insertQuestion = con.createStatement();
			int x = insertQuestion.executeUpdate("INSERT INTO feedback.question (`QUESTION`, `CAT`) VALUES ('ASD', 'ASD')");
			if(x!=0){
				status = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return status;
	}
*/	
	public ArrayList<StudentDetails> getAllStudents(String branch,String id){
		ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet student = getQuestion.executeQuery("SELECT * FROM ait_student.students where branch='"+branch+"' and sem='"+id+"'");
			while(student.next()){
				students.add(new StudentDetails(student.getString(1).toString(),student.getString(2).toString(),student.getString(4).toString()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return students;
	}
	
	public ArrayList<StudentDetails> getAllStudent(String id){
		ArrayList<StudentDetails> students = new ArrayList<StudentDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet student=null;
			if(!id.contains("@")){
			student = getQuestion.executeQuery("SELECT * FROM ait_student.students where StudentUSN='"+id+"'");
			}else{
				student = getQuestion.executeQuery("SELECT * FROM ait_student.students where Email='"+id+"'");
			}
			if(student.next()){
				students.add(new StudentDetails(student.getString(1).toString(),
						student.getString(2).toString(),
						student.getString(3).toString(),
						student.getString(4).toString(),
						student.getString(5).toString(),
						student.getString(6).toString(),
						student.getString(7).toString(),
						student.getString(8).toString()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return students;
	}
	
	public ArrayList<StaffDetails> getAllFaculties(){
		ArrayList<StaffDetails> faculties = new ArrayList<StaffDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet faculty = getQuestion.executeQuery("SELECT * FROM ait_student.faculty");
			while(faculty.next()){
				faculties.add(new StaffDetails(faculty.getString(1).toString(),faculty.getString(2).toString(),faculty.getString(3).toString(),faculty.getString(4).toString(),faculty.getString(5).toString(),faculty.getString(6).toString(),faculty.getString(7).toString()));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return faculties;
	}
	
	public ArrayList<placementDetails> getPlacementDetaisl(StudentDetails user){
		ArrayList<placementDetails> _placementDetails = new ArrayList<placementDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.notification where type='placements' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_placementDetails.add(new placementDetails(pla.getString(1)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _placementDetails;
	}
	
	public ArrayList<placementDetails> getPlacementDetaislText(StudentDetails user){
		ArrayList<placementDetails> _placementDetails = new ArrayList<placementDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.textnotify where type='placements' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"' desc");
			while(pla.next()){
				_placementDetails.add(new placementDetails(pla.getString("notificationText")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _placementDetails;
	}
	
	public ArrayList<placementDetails> getExamDetaisl(StudentDetails user){
		ArrayList<placementDetails> _Exam = new ArrayList<placementDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.notification where type='exam' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_Exam.add(new placementDetails(pla.getString(1)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _Exam;
	}
	
	public ArrayList<placementDetails> getExamDetaislText(StudentDetails user){
		ArrayList<placementDetails> _Exam = new ArrayList<placementDetails>();
		try{
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.textnotify where type='exam' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_Exam.add(new placementDetails(pla.getString("notificationText")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _Exam;
	}	
	
	public ArrayList<placementDetails> getSportsDetaisl(StudentDetails user){
		ArrayList<placementDetails> _Sports = new ArrayList<placementDetails>();
		try{
			System.out.println(user.getStudentUSN());
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.notification where type='sports' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_Sports.add(new placementDetails(pla.getString(1)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _Sports;
	}
	
	public ArrayList<placementDetails> getSportsDetaislText(StudentDetails user){
		ArrayList<placementDetails> _Sports = new ArrayList<placementDetails>();
		try{
			System.out.println(user.getStudentUSN());
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.textnotify where type='sports' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_Sports.add(new placementDetails(pla.getString("notificationText")));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _Sports;
	}
	
	
	public ArrayList<ResultObj> getMyResultDetaisl(StudentDetails user){
		
		ArrayList<ResultObj> _Sports = new ArrayList<ResultObj>();
		try{
			System.out.println(user.getStudentUSN());
			con = GetDbCon.getCon();
			Statement getQuestion = con.createStatement();
			ResultSet pla = getQuestion.executeQuery("SELECT * FROM ait_student.resultable where USN='"+user.getStudentUSN()+"' and branch='"+user.getBranch()+"' and sem='"+user.getSem()+"'");
			while(pla.next()){
				_Sports.add(new ResultObj(pla.getString(1),pla.getString(2),pla.getString(3),pla.getString(8),pla.getString(5),pla.getString(6),pla.getString(7),pla.getString(8),pla.getString(9),pla.getString(10),
						pla.getString(11),pla.getString(12),pla.getString(13),pla.getString(14),pla.getString(15),pla.getString(16),pla.getString(17),pla.getString(18),pla.getString(19),pla.getString(20),
						pla.getString(21),pla.getString(22),pla.getString(23),pla.getString(24),pla.getString(25),pla.getString(26)));
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return _Sports;
		
	}
	

}
