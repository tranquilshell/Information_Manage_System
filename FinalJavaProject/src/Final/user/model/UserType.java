//登录的类型，有3种身份可以选择
package Final.user.model;
public enum UserType {//利用了枚举法定义登录类型，不同身份登录的消息不同
	ADMIN("系统管理员",0),TEACHER("教师",1),STUDENT("学生",2);
	private String name;
	private int index;
	private UserType(String name,int index) {
		this.name=name;
		this.index=index;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return this.name;
	}
	public void setIndex(int index) {
		this.index=index;
	}
	public int getIndex() {
		return this.index;
	}
	public String toString() {
		return this.name;
	}
}
