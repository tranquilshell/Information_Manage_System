//学生信息
package Final.user.model;
public class Student {
	private int id;
	private String name;//学生姓名
	private int classId;//班级在数据库的id
	private String password;
	private String sex;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId=classId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public String toString() {
		return this.name;
	}
}
