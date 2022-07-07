//ѡ�α��������
package Final.user.login;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Final.user.model.Course;
import Final.user.model.SelectedCourse;
import Final.user.model.Student;

public class SelectedCourseObj extends BaseObj {
	public boolean addSelectedCourse(SelectedCourse selectedCourse){
		String sql = "insert into s_selected_course values(null,?,?)";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);//��sql��䴫�����ݿ��������
			preparedStatement.setInt(1, selectedCourse.getStudent_id());
			preparedStatement.setInt(2, selectedCourse.getCourse_id());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean updateSelectedCourse(SelectedCourse selectedCourse){
		String sql = "update s_selected_course set student_id = ?,course_id = ? where id = ?";
		try {
			java.sql.PreparedStatement preparedStatement = con.prepareStatement(sql);
			preparedStatement.setInt(1, selectedCourse.getStudent_id());
			preparedStatement.setInt(2, selectedCourse.getCourse_id());
			preparedStatement.setInt(3, selectedCourse.getId());
			if(preparedStatement.executeUpdate() > 0)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public List<SelectedCourse> getSelectedCourseList(SelectedCourse selectedCourse){
		List<SelectedCourse> retList = new ArrayList<SelectedCourse>();
		StringBuffer sqlString = new StringBuffer("select * from s_selected_course");
		if(selectedCourse.getStudent_id() != 0){
			sqlString.append(" and student_id = "+selectedCourse.getStudent_id());
		}
		if(selectedCourse.getCourse_id() != 0){
			sqlString.append(" and course_id ="+selectedCourse.getCourse_id());
		}
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString().replaceFirst("and", "where"));
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				SelectedCourse sc = new SelectedCourse();
				sc.setId(executeQuery.getInt("id"));
				sc.setStudent_id(executeQuery.getInt("student_id"));
				sc.setCourse_id(executeQuery.getInt("course_id"));
				retList.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
	public boolean isSelected(SelectedCourse selectedCourse){
		String sql = "select * from s_selected_course where student_id=? and course_id = ?";
		try {
			PreparedStatement prst = con.prepareStatement(sql);
			prst.setInt(1, selectedCourse.getStudent_id());
			prst.setInt(2, selectedCourse.getCourse_id());
			ResultSet executeQuery = prst.executeQuery();
			if(executeQuery.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean delete(int id){
		String sql = "delete from s_selected_course where id=?";
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
	public List<Student> getSelectedCourseStudentList(Course course){
		List<Student> retList = new ArrayList<Student>();
		StringBuffer sqlString = new StringBuffer("select sc.course_id,s.* from s_selected_course sc , s_student s where sc.student_id = s.id and course_id = ?");
		try {
			PreparedStatement preparedStatement = con.prepareStatement(sqlString.toString());
			preparedStatement.setInt(1, course.getId());
			ResultSet executeQuery = preparedStatement.executeQuery();
			while(executeQuery.next()){
				Student s = new Student();
				s.setId(executeQuery.getInt("id"));
				s.setClassId(executeQuery.getInt("classId"));
				s.setName(executeQuery.getString("name"));
				s.setSex(executeQuery.getString("sex"));
				retList.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return retList;
	}
}