//�γ���Ϣ
package Final.user.model;
public class Course {
	private int id;
	private String name;//�γ�����
	private int selected_num=0;//ѡ�εı��
	private String info;//�γ���Ϣ
	private int max_student_num;//�γ����ѧ����
	private int teacher_id;//����ʦ�����йص�id
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
