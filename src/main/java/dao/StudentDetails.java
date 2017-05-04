package dao;


public class StudentDetails {
	
	private String StudentName;
	private String StudentUSN;
	private String StuuserName;
	private String MobileNo;
	private String Email;
	private String branch;
	private String Sem;
	private String password;
	
	public StudentDetails(){
		super();
	}
	
	public StudentDetails(String studentName, String password) {
		super();
		StudentName = studentName;
		this.password = password;
	}
	
	public StudentDetails(String studentName, String USN,String contactNo) {
		super();
		StudentName = studentName;
		this.StudentUSN = USN;
		this.MobileNo = contactNo;
	}
	
	public StudentDetails(String studentName, String studentUSN,
			String stuuserName, String mobileNo, String email, String branch,
			String sem, String password) {
		super();
		StudentName = studentName;
		StudentUSN = studentUSN;
		StuuserName = stuuserName;
		MobileNo = mobileNo;
		Email = email;
		this.branch = branch;
		Sem = sem;
		this.password = password;
	}
	public StudentDetails(String studentName, String studentUSN,
			String stuuserName, String mobileNo, String email, String branch,
			String sem) {
		super();
		StudentName = studentName;
		StudentUSN = studentUSN;
		StuuserName = stuuserName;
		MobileNo = mobileNo;
		Email = email;
		this.branch = branch;
		Sem = sem;
	}

	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentUSN() {
		return StudentUSN;
	}
	public void setStudentUSN(String studentUSN) {
		StudentUSN = studentUSN;
	}
	public String getStuuserName() {
		return StuuserName;
	}
	public void setStuuserName(String stuuserName) {
		StuuserName = stuuserName;
	}
	public String getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(String mobileNo) {
		MobileNo = mobileNo;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getSem() {
		return Sem;
	}
	public void setSem(String sem) {
		Sem = sem;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
