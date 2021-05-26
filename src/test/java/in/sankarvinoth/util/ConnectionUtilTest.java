package in.sankarvinoth.util;

import java.sql.Connection;


import in.sankarvinoth.util.Connection.ConnectionUtil;



public class ConnectionUtilTest {
	public static void main(String[] args) throws Exception{
		    Connection connection =ConnectionUtil. getConnection();
		    System.out.println(connection +  " Connection established");
		    ConnectionUtil.close(connection);
		    
		  
}
	
	
}