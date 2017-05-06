import dao.StudentDetails;
import dto.DbOperation;


public class runmain {

	public static void main(String[] args) {
		DbOperation db = new DbOperation();
		StudentDetails s = new StudentDetails();
		s.setBranch("CSE");
		s.setSem("1");
		
		db.getMyResultDetaisl(s);
		
		
	}
}
