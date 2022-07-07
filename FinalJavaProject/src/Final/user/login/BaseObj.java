//创建数据库对象，所有数据依靠此对象连接数据库
package Final.user.login;

import java.sql.Connection;
import java.sql.SQLException;

import Final.work.util.DbUtil;

public class BaseObj {
	public Connection con=new DbUtil().getCon();
	public void closeObj() {
		try{
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
