//��ʦ��Ϣ
package Final.user.model;
public class Teacher {
	private int id;
	private String name;//��ʦ����
	private String password;
	private String title;//��ʦְ�Ʊ��磺xxx����ѧ��ʦ
	private int age;
	private String sex;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title=title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public String toString() {
		return this.name;
	}
}
