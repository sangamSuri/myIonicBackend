package dao;

public class Response {

	public boolean status;
	public String role;
	public String id;
	public String branch;
	public String sem;
	
	
	
	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getBranch() {
		return branch;
	}



	public void setBranch(String branch) {
		this.branch = branch;
	}



	public String getSem() {
		return sem;
	}



	public void setSem(String sem) {
		this.sem = sem;
	}


	public Response(){
		super();
	}
	public Response(boolean status,String role,String id,String branch,String sem) {
		super();
		this.status = status;
		this.id = id;
		this.branch = branch;
		this.role = role;
		this.sem = sem;
	}
	
	
}
