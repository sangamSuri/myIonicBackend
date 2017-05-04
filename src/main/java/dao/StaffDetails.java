package dao;

public class StaffDetails {

	private String Fname;
	private String Lname;
	private String Fmobile;
	private String usn_id;
	private String dept;
	private String desination;
	private String password;
	private String email;
	
	StaffDetails(){
		super();
	}
	
	
	
	public StaffDetails(String fname, String lname, String fmobile,
			String usn_id, String dept, String desination,String email) {
		super();
		Fname = fname;
		Lname = lname;
		Fmobile = fmobile;
		this.usn_id = usn_id;
		this.dept = dept;
		this.desination = desination;
		this.email = email;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public StaffDetails(String fname, String usn_id, String dept) {
		super();
		Fname = fname;
		this.usn_id = usn_id;
		this.dept = dept;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getFmobile() {
		return Fmobile;
	}
	public void setFmobile(String fmobile) {
		Fmobile = fmobile;
	}
	public String getUsn_id() {
		return usn_id;
	}
	public void setUsn_id(String usn_id) {
		this.usn_id = usn_id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDesination() {
		return desination;
	}
	public void setDesination(String desination) {
		this.desination = desination;
	}
	
	
}
