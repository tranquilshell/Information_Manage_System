//ѧ���༶��Ϣ
package Final.user.model;
public class StudentClass {
	private int id;//�༶�����ݿ��id
	private String name;//�༶����
	private String info;//�༶��Ϣ
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
