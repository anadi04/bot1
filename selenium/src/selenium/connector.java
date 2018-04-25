package selenium;
import java.sql.*;
public class connector
{
	public  static void setValues (String a) throws Exception
	{  
		String url="jdbc:mysql://localhost:3306/list";
		String uname="root";
		String pass="1234";
		String query="select* from list1 where CustomerID= '"+ a+"'";
	Class.forName("com.mysql.jdbc.Driver");
	Connection con= DriverManager.getConnection(url,uname,pass);
	Statement st=con.createStatement();
	ResultSet rs=st.executeQuery(query);
	rs.next();
	String email=rs.getString("email");
	String pwd=rs.getString("password");
	//System.out.println(email);
	//System.out.println(pwd);
	interface1.username=email;
	interface1.flipkartpassword=pwd;
	st.close();
	con.close();
	
	}
	public static void main(String []args) throws Exception
	{

		 connector.setValues(interface1.value);
	}
}
