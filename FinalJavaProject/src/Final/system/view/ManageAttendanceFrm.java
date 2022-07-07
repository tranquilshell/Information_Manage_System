package Final.system.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Final.user.login.AttendanceObj;
import Final.user.login.CourseObj;
import Final.user.login.SelectedCourseObj;
import Final.user.login.StudentObj;
import Final.user.model.Attendance;
import Final.user.model.Course;
import Final.user.model.Student;
import Final.user.model.Teacher;
import Final.work.util.DateFormatUtil;

public class ManageAttendanceFrm extends JInternalFrame {
	private JTable attendancedListTable;
	private JComboBox courseComboBox ;
	private JComboBox studentComboBox;
	private List<Student> studentList = new ArrayList<Student>();
	private List<Course> courseList = new ArrayList<Course>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageAttendanceFrm frame = new ManageAttendanceFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ManageAttendanceFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u7B7E\u5230\u8003\u52E4\u7BA1\u7406");
		setBounds(100, 100, 784, 654);
		
		JLabel label = new JLabel("\u5B66\u751F\uFF1A");
		label.setIcon(new ImageIcon(ManageAttendanceFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		studentComboBox = new JComboBox();
		studentComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				studentChangedAct(ie);
			}
		});
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\uFF1A");
		label_1.setIcon(new ImageIcon(ManageAttendanceFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseComboBox = new JComboBox();
		courseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				courseChangedAct(ie);
			}
		});
		
		JButton attendanceAddButton = new JButton("\u786E\u8BA4\u7B7E\u5230");
		attendanceAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addAttendanceAct(ae);
			}
		});
		attendanceAddButton.setIcon(new ImageIcon(ManageAttendanceFrm.class.getResource("/images/\u786E\u8BA4.png")));
		attendanceAddButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u5DF2\u7B7E\u5230\u5217\u8868", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(label_1)
							.addGap(18)
							.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(attendanceAddButton)))
					.addContainerGap(72, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(57)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(attendanceAddButton))
					.addGap(47)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 457, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(36, Short.MAX_VALUE))
		);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton cancelButton = new JButton("\u6DFB\u52A0\u7F3A\u5E2D");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				cancelAttendanceAct(ae);
			}
		});
		cancelButton.setIcon(new ImageIcon(ManageAttendanceFrm.class.getResource("/images/\u5220\u9664.png")));
		cancelButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(cancelButton, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 373, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cancelButton)
					.addContainerGap(13, Short.MAX_VALUE))
		);
		
		attendancedListTable = new JTable();
		attendancedListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u7B7E\u5230ID", "\u5B66\u751F\u59D3\u540D", "\u8BFE\u7A0B\u540D\u79F0", "\u7B7E\u5230\u65F6\u95F4"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(attendancedListTable);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		setCourseCombox();
		setStudentCombox();
	}
	protected void cancelAttendanceAct(ActionEvent ae) {
		if(JOptionPane.showConfirmDialog(this, "确定删除签到信息么？") != JOptionPane.OK_OPTION)return;
		int row = attendancedListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "请先选择一行数据！");
			return;
		}
		int attendanceId = Integer.parseInt(attendancedListTable.getValueAt(row, 0).toString());
		AttendanceObj attendanceObj = new AttendanceObj();
		if(attendanceObj.delete(attendanceId)){
			JOptionPane.showMessageDialog(this, "成功删除签到信息！");
		}else{
			JOptionPane.showMessageDialog(this, "操作失败！");
		}
		setTable();
	}

	protected void addAttendanceAct(ActionEvent ae) {
		// TODO Auto-generated method stub
		Student student = (Student)studentComboBox.getSelectedItem();
		Course course = (Course)courseComboBox.getSelectedItem();
		String dateString = DateFormatUtil.getDateString(new Date(System.currentTimeMillis()), "yyyy-MM-dd");
		Attendance attendance = new Attendance();
		attendance.setAttendance_date(dateString);
		attendance.setStudent_id(student.getId());
		attendance.setCourse_id(course.getId());
		AttendanceObj attendanceObj = new AttendanceObj();
		if(attendanceObj.isAttendanced(attendance)){
			JOptionPane.showMessageDialog(this, "已经签到，请勿重复签到！");
			return;
		}
		if(attendanceObj.addAttendance(attendance)){
			JOptionPane.showMessageDialog(this, "签到成功！");
		}else{
			JOptionPane.showMessageDialog(this, "签到失败！");
		}
		attendanceObj.closeObj();
		setTable();
	}

	protected void studentChangedAct(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED){
			setTable();
		}
	}

	protected void courseChangedAct(ItemEvent ie) {
		if(ie.getStateChange() == ItemEvent.SELECTED){
			setStudentCombox();
		}
	}

	private void setStudentCombox(){
		studentComboBox.removeAllItems();
		StudentObj studentObj = new StudentObj();
		studentList = studentObj.getStudentList(new Student());
		studentObj.closeObj();
		Course course = (Course)courseComboBox.getSelectedItem();
		List<Student> selectedCourseStudentList = getSelectedCourseStudentList(course);
		for (Student student : studentList) {
			for(Student student2 : selectedCourseStudentList){
				if(student.getId() == student2.getId())
					studentComboBox.addItem(student);
			}
		}
		
	}
	private List<Student> getSelectedCourseStudentList(Course course){
		SelectedCourseObj scObj = new SelectedCourseObj();
		List<Student> selectedCourseStudentList = scObj.getSelectedCourseStudentList(course);
		return selectedCourseStudentList;
	}
	private void setCourseCombox(){
		CourseObj courseObj = new CourseObj();
		courseList = courseObj.getCourseList(new Course());
		courseObj.closeObj();
		for (Course course : courseList) {
			if("教师".equals(MainFrm.userType.getName())){
				Teacher teacher = (Teacher)MainFrm.userObject;
				if(course.getTeacher_id() == teacher.getId()){
					courseComboBox.addItem(course);
				}
				continue;
			}
			//执行到这里一定是超级管理员身份
			courseComboBox.addItem(course);
		}
		
	}
	private void setTable(){
		Student student = (Student)studentComboBox.getSelectedItem();
		DefaultTableModel dft = (DefaultTableModel) attendancedListTable.getModel();
		dft.setRowCount(0);
		AttendanceObj attendanceObj = new AttendanceObj();
		Attendance attendance = new Attendance();
		attendance.setStudent_id(student.getId());
		List<Attendance> attendanceList = attendanceObj.getAttendancedList(attendance);
		for (Attendance a : attendanceList) {
			Vector v = new Vector();
			v.add(a.getId());
			v.add(student.getName());
			v.add(getCourseById(a.getCourse_id()));
			v.add(a.getAttendance_date());
			dft.addRow(v);
		}
		attendanceObj.closeObj();
	}
	private Course getCourseById(int id){
		for (int i = 0; i < courseList.size(); i++) {
			if(id == courseList.get(i).getId())return courseList.get(i);
		}
		return null;
	}
	
}
