//数据库模块，学生教师管理员所有数都由本模块进行处理
package Final.work.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/test1";//数据库的连接地址
	private String dbUserName="root";//用户名
	private String dbPassword="123456";//密码	
	private String jdbcName="com.mysql.jdbc.Driver";//数据库的驱动
//获取数据库连接
	public Connection getCon() {
		try {
			Class.forName(jdbcName);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con=DriverManager.getConnection(dbUrl,dbUserName,dbPassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	//关闭数据库
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
}
