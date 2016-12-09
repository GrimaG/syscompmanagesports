package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAO
{
	Connection con;
	Statement st;
	PreparedStatement stmt;
	ResultSet rs;
	String url="jdbc:mysql://localhost:3306/mydb";
	String usuario="root";
	String senha= "ifes";
	
	public void open()throws Exception
	{
	  Class.forName("com.mysql.jdbc.Driver").newInstance();
		con = DriverManager.getConnection(url, usuario, senha);
	}
	
	public void close()throws Exception
	{
		con.close();
	}
}