//����Ա��Ϣ
package Final.user.model;
public class Admin {
	private int id;
	private String name;//����Ա����
	private String password;//����
	private String createDate;//�����û�
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getCreateData() {
		return createDate;
	}
	public void setCreateData(String createData) {
		this.createDate=createData;
	}
}
