//课程信息
package Final.user.model;
public class Course {
	private int id;
	private String name;//课程名字
	private int selected_num=0;//选课的编号
	private String info;//课程信息
	private int max_student_num;//课程最大学生数
	private int teacher_id;//与老师名字有关的id
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
	public int getTeacher_id() {
		return teacher_id;
	}
	public void setTeacher_id(int teacher_id) {
		this.teacher_id=teacher_id;
	}
	public int getMax_student_num() {
		return max_student_num;
	}
	public void setMax_student_num(int max_student_num) {
		this.max_student_num=max_student_num;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info=info;
	}
	public int getSelected_num() {
		return selected_num;
	}
	public void setSelecter_num(int selected_num) {
		this.selected_num=selected_num;
	}
	public String toString() {
		return this.name;
	}
}
