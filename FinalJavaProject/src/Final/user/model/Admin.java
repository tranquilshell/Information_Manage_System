//管理员信息
package Final.user.model;
public class Admin {
	private int id;
	private String name;//管理员姓名
	private String password;//密码
	private String createDate;//创建用户
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
