//创建班级对象连接数据库
package Final.user.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Final.work.util.StringUtil;

import Final.user.model.StudentClass;
public class ClassObj extends BaseObj {
	public boolean addClass(StudentClass sc) {
		String sql="insert into s_class values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			if(preparedStatement.executeUpdate()>0)
				return true;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<StudentClass> getClassList(StudentClass studentClass){
		List<StudentClass> retList = new ArrayList<StudentClass>();
		String sqlString = "select * from s_class";
		if(!StringUtil.isEmpty(studentClass.getName())){
			sqlString += " where name like '%"+studentClass.getName()+"%'";
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString);
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				StudentClass sc = new StudentClass();
				sc.setId(executeQuery.getInt("id"));
				sc.setName(executeQuery.getString("name"));
				sc.setInfo(executeQuery.getString("info"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean delete(int id){
		String sql = "delete from s_class where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean update(StudentClass sc){
		String sql = "update s_class set name=?, info=? where id=?";
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setString(1, sc.getName());
			preparedStatement.setString(2, sc.getInfo());
			preparedStatement.setInt(3, sc.getId());
			if(preparedStatement.executeUpdate() > 0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
}
}
