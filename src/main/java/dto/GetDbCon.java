package dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetDbCon {

	 public static  Connection getCon(){ 
	        Connection con=null;
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/ait_student","root","root");
	            System.out.println("connected.....");
	        	} catch (Exception ex) {
	        			ex.printStackTrace();
	        	}
	        return con;
	    }
}
