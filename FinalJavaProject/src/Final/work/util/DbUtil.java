//���ݿ�ģ�飬ѧ����ʦ����Ա���������ɱ�ģ����д���
package Final.work.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	private String dbUrl="jdbc:mysql://localhost:3306/test1";//���ݿ�����ӵ�ַ
	private String dbUserName="root";//�û���
	private String dbPassword="123456";//����	
	private String jdbcName="com.mysql.jdbc.Driver";//���ݿ������
//��ȡ���ݿ�����
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
	
	//�ر����ݿ�
	public void closeCon(Connection con)throws Exception{
		if(con!=null) {
			con.close();
		}
	}
}
