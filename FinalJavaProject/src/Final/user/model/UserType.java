//��¼�����ͣ���3����ݿ���ѡ��
package Final.user.model;
public enum UserType {//������ö�ٷ������¼���ͣ���ͬ��ݵ�¼����Ϣ��ͬ
	ADMIN("ϵͳ����Ա",0),TEACHER("��ʦ",1),STUDENT("ѧ��",2);
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
