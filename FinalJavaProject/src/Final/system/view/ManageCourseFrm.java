package Final.system.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import Final.user.login.CourseObj;
import Final.user.login.TeacherObj;
import Final.user.model.Course;
import Final.user.model.Teacher;
import Final.work.util.StringUtil;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageCourseFrm extends JInternalFrame {
	private JTextField searchCourseNameTextField;
	private JTable courseListTable;
	private JTextField editCourseTextField;
	private JTextField editCourseStudentNumTextField;
	private JComboBox editCourseTeachComboBox;
	private JTextArea editCourseInfoTextArea;
	private List<Teacher> teacherList = new ArrayList<Teacher>();
	private JComboBox searchTeacherComboBox;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageCourseFrm frame = new ManageCourseFrm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ManageCourseFrm() {
		setTitle("\u8BFE\u7A0B\u4FE1\u606F\u7BA1\u7406");
		setBounds(100, 100, 819, 704);
		setClosable(true);
		setIconifiable(true);
		JLabel label = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		searchCourseNameTextField = new JTextField();
		searchCourseNameTextField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_1.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		label_1.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		searchTeacherComboBox = new JComboBox();
		
		JButton searchButton = new JButton("\u67E5\u8BE2");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				searchCourse(ae);
			}
		});
		searchButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u641C\u7D22.png")));
		searchButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "\u7F16\u8F91\u8BFE\u7A0B\u4FE1\u606F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(81)
							.addComponent(label)
							.addGap(18)
							.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addComponent(label_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addGap(50)
							.addComponent(searchButton))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(scrollPane, Alignment.LEADING)
								.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 603, Short.MAX_VALUE))))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(label)
						.addComponent(searchCourseNameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_1)
						.addComponent(searchTeacherComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(searchButton))
					.addGap(37)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
					.addGap(1)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		
		JLabel label_2 = new JLabel("\u8BFE\u7A0B\u540D\u79F0\uFF1A");
		label_2.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8BFE\u7A0B.png")));
		label_2.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editCourseTextField = new JTextField();
		editCourseTextField.setColumns(10);
		
		JLabel label_3 = new JLabel("\u6388\u8BFE\u8001\u5E08\uFF1A");
		label_3.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u8001\u5E08.png")));
		label_3.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editCourseTeachComboBox = new JComboBox();
		
		JLabel label_4 = new JLabel("\u5B66\u751F\u4EBA\u6570\uFF1A");
		label_4.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u4EBA\u6570.png")));
		label_4.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editCourseStudentNumTextField = new JTextField();
		editCourseStudentNumTextField.setColumns(10);
		
		JLabel label_5 = new JLabel("\u8BFE\u7A0B\u4ECB\u7ECD\uFF1A");
		label_5.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u4ECB\u7ECD.png")));
		label_5.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		editCourseInfoTextArea = new JTextArea();
		
		JButton submitEditButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		submitEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				editCourseSubmit(ae);
			}
		});
		submitEditButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u786E\u8BA4.png")));
		submitEditButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		
		JButton deleteCourseButton = new JButton("\u5220\u9664\u8BFE\u7A0B");
		deleteCourseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				deleteCourse(ae);
			}
		});
		deleteCourseButton.setIcon(new ImageIcon(ManageCourseFrm.class.getResource("/images/\u5220\u9664.png")));
		deleteCourseButton.setFont(new Font("΢���ź�", Font.PLAIN, 14));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(37)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_4)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCourseStudentNumTextField))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_2)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE))))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addContainerGap(157, Short.MAX_VALUE)
							.addComponent(submitEditButton)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_3)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editCourseTeachComboBox, GroupLayout.PREFERRED_SIZE, 153, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(label_5)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(editCourseInfoTextArea)))
							.addContainerGap(77, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(67)
							.addComponent(deleteCourseButton)
							.addContainerGap())))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_2)
						.addComponent(editCourseTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(label_3)
						.addComponent(editCourseTeachComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_4)
								.addComponent(editCourseStudentNumTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_5))
							.addPreferredGap(ComponentPlacement.RELATED))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
							.addComponent(editCourseInfoTextArea, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
							.addGap(20)))
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(deleteCourseButton)
						.addComponent(submitEditButton))
					.addContainerGap(12, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		courseListTable = new JTable();
		courseListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent me) {
				selectedCourse(me);
			}
		});
		courseListTable.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\u8BFE\u7A0B\u7F16\u53F7", "\u8BFE\u7A0B\u540D\u79F0", "\u6388\u8BFE\u8001\u5E08", "\u8BFE\u7A0B\u6700\u5927\u4EBA\u6570", "\u5DF2\u9009\u4EBA\u6570", "\u8BFE\u7A0B\u4ECB\u7ECD"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		courseListTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		courseListTable.getColumnModel().getColumn(5).setPreferredWidth(225);
		scrollPane.setViewportView(courseListTable);
		getContentPane().setLayout(groupLayout);
		setTeacherCombox();
		setCourseListTable(new Course());
	}
	protected void editCourseSubmit(ActionEvent ae) {
		int row = courseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵ����ݣ�");
			return;
		}
		int course_id = Integer.parseInt(courseListTable.getValueAt(row, 0).toString());
		Teacher teacher = (Teacher) editCourseTeachComboBox.getSelectedItem();
		String courseName = editCourseTextField.getText().toString();
		if(StringUtil.isEmpty(courseName)){
			JOptionPane.showMessageDialog(this, "�γ����Ʋ���Ϊ�գ�");
			return;
		}
		int max_student_num = 0;
		try {
			max_student_num = Integer.parseInt(editCourseStudentNumTextField.getText().toString());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "ѧ���������������0��������");
			return;
		}
		if(max_student_num <= 0){
			JOptionPane.showMessageDialog(this, "ѧ���������������0��������");
			return;
		}
		String courseInfo = editCourseInfoTextArea.getText().toString();
		Course course = new Course();
		course.setId(course_id);
		course.setName(courseName);
		course.setTeacher_id(teacher.getId());
		course.setMax_student_num(max_student_num);
		course.setInfo(courseInfo);
		CourseObj courseObj = new CourseObj();
		if(courseObj.update(course)){
			JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
		}else{
			JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
		}
		courseObj.closeObj();
		setCourseListTable(new Course());
		
	}

	protected void selectedCourse(MouseEvent me) {
		int row = courseListTable.getSelectedRow();
		String couseName = courseListTable.getValueAt(row, 1).toString();
		int teacher_id = getTeacherIdByName(courseListTable.getValueAt(row, 2).toString());
		int max_student_num = Integer.parseInt(courseListTable.getValueAt(row, 3).toString());
		String couseInfo = courseListTable.getValueAt(row, 5).toString();
		editCourseTextField.setText(couseName);
		editCourseStudentNumTextField.setText(max_student_num+"");
		editCourseInfoTextArea.setText(couseInfo);
		for(int i=0;i<editCourseTeachComboBox.getItemCount();i++){
			Teacher t = (Teacher) editCourseTeachComboBox.getItemAt(i);
			if(t.getId() == teacher_id){
				editCourseTeachComboBox.setSelectedIndex(i);
				break;
			}
		}
	}

	protected void searchCourse(ActionEvent ae) {
		String searchCourseName = searchCourseNameTextField.getText().toString();
		Teacher teacher = (Teacher) searchTeacherComboBox.getSelectedItem();
		Course course = new Course();
		course.setName(searchCourseName);
		course.setTeacher_id(teacher.getId());
		setCourseListTable(course);
	}

	protected void deleteCourse(ActionEvent ae) {
		int row = courseListTable.getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ�������ݣ�");
			return;
		}
		int course_id = Integer.parseInt(courseListTable.getValueAt(row, 0).toString());
		CourseObj courseObj = new CourseObj();
		if(courseObj.delete(course_id)){
			JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
		}else{
			JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
		}
		courseObj.closeObj();
		setCourseListTable(new Course());
	}

	private void setCourseListTable(Course course){
		CourseObj courseObj = new CourseObj();
		List<Course> courseList = courseObj.getCourseList(course);
		DefaultTableModel dft = (DefaultTableModel) courseListTable.getModel();
		dft.setRowCount(0);
		for (Course c : courseList) {
			Vector v = new Vector();
			v.add(c.getId());
			v.add(c.getName());
			v.add(getTeacherNameById(c.getTeacher_id()));
			v.add(c.getMax_student_num());
			v.add(c.getSelected_num());
			v.add(c.getInfo());
			dft.addRow(v);
		}
		courseObj.closeObj();
	}
	private void setTeacherCombox(){
		TeacherObj teacherObj = new TeacherObj();
		teacherList = teacherObj.getTeacherList(new Teacher());
		teacherObj.closeObj();
		for (Teacher teacher : teacherList) {
			editCourseTeachComboBox.addItem(teacher);
			searchTeacherComboBox.addItem(teacher);
		}
	}
	private String getTeacherNameById(int teacher_id){
		String retString = "";
		for (Teacher teacher : teacherList) {
			if(teacher.getId() == teacher_id){
				retString = teacher.getName();
				break;
			}
		}
		return retString;
	}
	private int getTeacherIdByName(String teacher_name){
		int retId = -1;
		for (Teacher teacher : teacherList) {
			if(teacher_name.equals(teacher.getName())){
				retId = teacher.getId();
				break;
			}
		}
		return retId;
	}
}
