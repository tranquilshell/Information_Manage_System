package Final.system.view;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;

import Final.user.login.CourseObj;
import Final.user.login.TeacherObj;
import Final.user.model.Course;
import Final.user.model.Teacher;
import Final.work.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.List;

public class AddCourseFrm extends JInternalFrame {
	private JTextField courseNameTextField;
	private JTextField studentNumTextField;
	private JComboBox teacherListComboBox;
	private JTextArea courseInfoTextArea;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCourseFrm frame = new AddCourseFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AddCourseFrm() {
		setClosable(true);
		setIconifiable(true);
		setTitle("\u6DFB\u52A0\u8BFE\u7A0B");
		setBounds(100, 100, 453, 471);
		
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseNameTextField = new JTextField();
		courseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		teacherListComboBox = new JComboBox();
		
		JLabel label_2 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_2.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		studentNumTextField = new JTextField();
		studentNumTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label_3.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		label_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		courseInfoTextArea = new JTextArea();
		
		JButton addCourseButton = new JButton("\u786E\u8BA4\u6DFB\u52A0");
		addCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				addCourseAct(ae);
			}
		});
		addCourseButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		addCourseButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		
		JButton resetButton = new JButton("\u91CD\u7F6E\u4FE1\u606F");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				resetValue(ae);
			}
		});
		resetButton.setIcon(new ImageIcon(AddCourseFrm.class.getResource("")));
		resetButton.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(label)
							.addGap(10)
							.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(label_1)
							.addGap(10)
							.addComponent(teacherListComboBox, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(label_2)
							.addGap(10)
							.addComponent(studentNumTextField, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(88)
							.addComponent(label_3)
							.addGap(10)
							.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(127)
							.addComponent(addCourseButton, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addGap(29)
							.addComponent(resetButton, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)))
					.addGap(77))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(19)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(courseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(35)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_1)
						.addComponent(teacherListComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(37)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label_2)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(studentNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(1)
							.addComponent(label_3))
						.addComponent(courseInfoTextArea, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(42)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(addCourseButton)
						.addComponent(resetButton)))
		);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
	}

	protected void resetValue(ActionEvent ae) {
		courseNameTextField.setText("");
		courseInfoTextArea.setText("");
		studentNumTextField.setText("");
		teacherListComboBox.setSelectedIndex(0);
	}

	protected void addCourseAct(ActionEvent ae) {
		String couserName = courseNameTextField.getText().toString();
		String courseInfo = courseInfoTextArea.getText().toString();
		Teacher selectedTeacher = (Teacher)teacherListComboBox.getSelectedItem();
		int studentMaxNum = 0;
		try {
			studentMaxNum = Integer.parseInt(studentNumTextField.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "学生人数只能输入数字!");
			return;
		}
		if(StringUtil.isEmpty(couserName)){
			JOptionPane.showMessageDialog(this, "请输入课程名称!");
			return;
		}
		if(studentMaxNum <= 0){
			JOptionPane.showMessageDialog(this, "学生人数只能输入大于0的数字!");
			return;
		}
		Course course = new Course();
		course.setName(couserName);
		course.setMax_student_num(studentMaxNum);
		course.setInfo(courseInfo);
		course.setTeacher_id(selectedTeacher.getId());
		CourseObj courseObj = new CourseObj();
		if(courseObj.addCourse(course)){
			JOptionPane.showMessageDialog(this, "添加成功!");
		}else{
			JOptionPane.showMessageDialog(this, "添加失败!");
		}
		courseObj.closeObj();
		resetValue(ae);
	}
	private void setTeacherCombox(){
		TeacherObj teacherObj = new TeacherObj();
		List<Teacher> teacherList = teacherObj.getTeacherList(new Teacher());
		teacherObj.closeObj();
		for (Teacher teacher : teacherList) {
			teacherListComboBox.addItem(teacher);
		}
	}
}
