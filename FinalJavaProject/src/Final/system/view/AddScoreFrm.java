package Final.system.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import Final.user.login.CourseObj;
import Final.user.login.ScoreObj;
import Final.user.login.SelectedCourseObj;
import Final.user.login.StudentObj;
import Final.user.model.Course;
import Final.user.model.Score;
import Final.user.model.Student;
import Final.user.model.Teacher;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class AddScoreFrm extends JInternalFrame {
	private JTextField scoreTextField;
	private JComboBox studentComboBox;
	private JComboBox courseComboBox;
	private List<Course> courseList;
	private List<Student> studentList;

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddScoreFrm frame = new AddScoreFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public AddScoreFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6210\u7EE9\u5F55\u5165\u754C\u9762");
		setBounds(100, 100, 641, 474);
		
		JLabel label = new JLabel("\u5B66\u751F\u59D3\u540D\uFF1A");
		label.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u5B66\u751F\u7BA1\u7406.png")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		studentComboBox = new JComboBox();
		
		JLabel label_1 = new JLabel("\u8BFE\u7A0B\u4FE1\u606F\uFF1A");
		label_1.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseComboBox = new JComboBox();
		courseComboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ae) {
				courseChangeAct(ae);
			}
		});
		courseComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
			}
		});
		
		JLabel label_2 = new JLabel("\u6240\u5F97\u6210\u7EE9\uFF1A");
		label_2.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u6210\u7EE9.png")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		scoreTextField = new JTextField();
		scoreTextField.setColumns(10);
		
		JButton submitButton = new JButton("\u5F55\u5165\u6210\u7EE9");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				submitAct(ae);
			}
		});
		submitButton.setIcon(new ImageIcon(AddScoreFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(142)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(scoreTextField))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(courseComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(label)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(213, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(311, Short.MAX_VALUE)
					.addComponent(submitButton)
					.addGap(249))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(63)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(studentComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(62)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1)
						.addComponent(courseComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(66)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(scoreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(74)
					.addComponent(submitButton)
					.addContainerGap(89, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		setCourseCombox();
		setStudentCombox();
	}
	protected void submitAct(ActionEvent ae) {
		int score = 0;
		try {
			score = Integer.parseInt(scoreTextField.getText().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "成绩必须输入大于0的整数！");
			return;
		}
		if(score <= 0){
			JOptionPane.showMessageDialog(this, "成绩必须输入大于0的整数！");
			return;
		}
		Student student = (Student) studentComboBox.getSelectedItem();
		Course course = (Course)courseComboBox.getSelectedItem();
		Score scoreObj = new Score();
		scoreObj.setStudent_id(student.getId());
		scoreObj.setCourse_id(course.getId());
		scoreObj.setScore(score);
		ScoreObj scoreobj = new ScoreObj();
		if(scoreobj.isAdd(scoreObj)){
			JOptionPane.showMessageDialog(this, "成绩已经录入，请勿重复录入！");
			return;
		}
		if(scoreobj.addScore(scoreObj)){
			JOptionPane.showMessageDialog(this, "成绩录入成功！");
			scoreTextField.setText("");
		}else{
			JOptionPane.showMessageDialog(this, "成绩录入失败！");
		}
		scoreobj.closeObj();
	}

	protected void courseChangeAct(ItemEvent ae) {
		if(ae.getStateChange() == ItemEvent.SELECTED){
			setStudentCombox();
		}
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
}
