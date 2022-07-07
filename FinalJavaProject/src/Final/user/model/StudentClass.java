//学生班级信息
package Final.user.model;
public class StudentClass {
	private int id;//班级在数据库的id
	private String name;//班级名字
	private String info;//班级信息
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString(){
		return this.name;
	}
}
