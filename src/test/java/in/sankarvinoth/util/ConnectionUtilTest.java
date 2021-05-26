package in.sankarvinoth.util;

import static org.junit.Assert.assertNotNull;
import java.sql.Connection;
import org.junit.Test;
import in.sankarvinoth.util.connection.ConnectionUtil;
public class ConnectionUtilTest {
   @Test
   public static void main(String args[]) throws Exception {
	   Connection con =ConnectionUtil.getConnection();
	   assertNotNull(con);
	   
	   
	   
	   
   }
}
