package Final.work.util;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.PopupFactory;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;


public class Choose extends JPanel{
		private Calendar calendar;
		private Calendar now=Calendar.getInstance();
		private JPanel calendarPanel;
		private java.awt.Font font=new java.awt.Font("Times",java.awt.Font.PLAIN,12);//字体
		private java.text.SimpleDateFormat SDF;
		private final LabelManager LM=new LabelManager();
		private javax.swing.Popup pop;//信息弹窗
		private TitlePanel titlePanel;
		private BodyPanel bodyPanel;
		private FooterPanel footerPanel;
		
		private JComponent showDate;
		private boolean isShow =false;
		private static final String DEFAULTFORMAT="yyyy-MM-dd";//设置默认的年-月-份
		private static final String[] showTEXT= {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
		private static WeekLabel[] weekLabels=new WeekLabel[7];//定义为一星期有7天的数组
		private static int defaultStartDAY=0;//定义0为星期天开始，1为星期一
		private static Color hoverColor = Color.BLUE;//设置默认颜色为蓝色
		
		private Choose(java.util.Date date,String format,int startDAY) {
			if(startDAY>-1 &&startDAY<7) defaultStartDAY=startDAY;
			int dayIndex=defaultStartDAY;
			for(int i=0;i<7;i++) {
				if(dayIndex>6)dayIndex=0;
				weekLabels[i]=new WeekLabel(dayIndex,showTEXT[dayIndex]);
				dayIndex ++;
			}
			SDF=new java.text.SimpleDateFormat(format);
			calendar=Calendar.getInstance();
			initCalendarPanel();
			calendar.setTime(date);
		}
		public static Choose getInstance(java.util.Date date,String format) {
			return new Choose(date,format,defaultStartDAY);
		}
		public static Choose getInstance(java.util.Date date) {
			return getInstance(date,DEFAULTFORMAT);
		}
		public static Choose getInstance(String format) {
			return getInstance(new java.util.Date(),format);
		}
		public static Choose getInstance() {
			return getInstance(new java.util.Date(),DEFAULTFORMAT);
		}
		
		private void initCalendarPanel() {
			calendarPanel=new JPanel(new java.awt.BorderLayout());
			calendarPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0xAA,0xAA,0xAA)));
			calendarPanel.add(titlePanel = new TitlePanel(), java.awt.BorderLayout.NORTH);
			calendarPanel.add(bodyPanel = new BodyPanel(), java.awt.BorderLayout.CENTER);
	        calendarPanel.add(footerPanel = new FooterPanel(),java.awt.BorderLayout.SOUTH);
	        this.addAncestorListener(new AncestorListener() {
	        	public void ancestorAdded(AncestorEvent event) {}
	        	public void ancestorRemoved(AncestorEvent event) {hidePanel();}
	        	
	        	public void ancestorMoved(AncestorEvent event) {
	        		hidePanel();
	        	}
	        });
		}
		public void register(final JComponent showComponent) {
			this.showDate=showComponent;
			showComponent.setRequestFocusEnabled(true);
			showComponent.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent me) {
					showComponent.requestFocusInWindow();
				}
			});
			this.add(showComponent,BorderLayout.CENTER);
			this.setPreferredSize(new Dimension(90,25));
			this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
			showComponent.addMouseListener(new MouseAdapter() {
				public void mouseEntered(MouseEvent me) {
					if(showComponent.isEnabled()) {
						showComponent.setCursor(new Cursor(Cursor.HAND_CURSOR));
					}
				}
				public void mouseExited(MouseEvent me) {
					if(showComponent.isEnabled()) {
						showComponent.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
						showComponent.setForeground(Color.BLACK);
					}
				}
				public void mousePressed(MouseEvent me) {
					if(showComponent.isEnabled()) {
						showComponent.setForeground(hoverColor);
						if(isShow) {
							hidePanel();
						}else {
							showPanel(showComponent);
						}
					}
				}
				public void mouseReleased(MouseEvent me) {
					if(showComponent.isEnabled()) {
						showComponent.setForeground(Color.BLACK);
					}
				}
			});
			showComponent.addFocusListener(new FocusListener() {
				public void focusLost(FocusEvent e) {
					hidePanel();
				}
				public void focusGained(FocusEvent e) {}//设置光标边框
			});
		}
		//隐藏画布
		private void hidePanel() {
			if(pop!=null) {
				isShow=false;
				pop.hide();
				pop=null;
			}
		}
		//打开主画布
		private void showPanel(Component owner) {
			if(pop!=null)
				pop.hide();
			Point show=new Point(0,showDate.getHeight());
			SwingUtilities.convertPointToScreen(show, showDate);
			Dimension size=Toolkit.getDefaultToolkit().getScreenSize();
			int x=show.x;
			int y=show.y;
			if(x<0)
				x=0;
			if(x>size.width - 212)
				x=size.width -212;
			if(y>size.height-167)
				y-=165;
			pop=PopupFactory.getSharedInstance().getPopup(owner, calendarPanel, x, y);
			pop.show();
			isShow=true;
		}
		//更改文本或者标签目录
		private void commit() {
			if(showDate instanceof JTextField) {
				((JTextField) showDate).setText(SDF.format(calendar.getTime()));
			}else if(showDate instanceof JLabel) {
				((JLabel) showDate).setText(SDF.format(calendar.getTime()));
			}
			hidePanel();
		}
		
		//控制panel
		private class TitlePanel extends JPanel{
			private JLabel lastYear,lastMonth,center,nextMonth,nextYear,centercontainer;
			
			public TitlePanel() {
				super(new java.awt.BorderLayout());
				this.setBackground(new java.awt.Color(190,200,200));
				initTitlePanel();
			}
			private void initTitlePanel() {
				lastYear =new JLabel("<<",JLabel.CENTER);
				lastMonth=new JLabel("<",JLabel.CENTER);
				center=new JLabel("",JLabel.CENTER);
				centercontainer=new JLabel("",JLabel.CENTER);
				nextMonth=new JLabel(">",JLabel.CENTER);
				nextYear=new JLabel(">>",JLabel.CENTER); 
				
				lastYear.setToolTipText("Last Year");
				lastMonth.setToolTipText("Last Month");
				nextMonth.setToolTipText("Next Month");
				nextYear.setToolTipText("Next Year");
				
				lastYear.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,10,0,0));
				lastMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 15, 0, 0));
				nextMonth.setBorder(javax.swing.BorderFactory.createEmptyBorder(2,0,0,15));
				nextYear.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 0, 0, 10));
				
				centercontainer.setLayout(new java.awt.BorderLayout());
				centercontainer.add(lastMonth,java.awt.BorderLayout.WEST);
				centercontainer.add(center,java.awt.BorderLayout.CENTER);
				centercontainer.add(nextMonth,java.awt.BorderLayout.EAST);
				
				this.add(lastYear,java.awt.BorderLayout.WEST);
				this.add(centercontainer,java.awt.BorderLayout.CENTER);
				this.add(nextYear,java.awt.BorderLayout.EAST);
				this.setPreferredSize(new java.awt.Dimension(210,25));
				
				updateDate();
				
				lastYear.addMouseListener(new MyMouseAdapter(lastYear,Calendar.YEAR,-1));
				lastMonth.addMouseListener(new MyMouseAdapter(lastMonth,Calendar.MONTH,-1));
				nextMonth.addMouseListener(new MyMouseAdapter(nextMonth,Calendar.MONTH,-1));
				nextYear.addMouseListener(new MyMouseAdapter(nextYear,Calendar.YEAR,-1));
			}
			
			private void updateDate() {
				center.setText(calendar.get(Calendar.YEAR)+"-"+(calendar.get(Calendar.MONTH)+1));
			}
			//监听事件
			class MyMouseAdapter extends java.awt.event.MouseAdapter{
				JLabel label;
				private int type,value;
				
				public MyMouseAdapter(final JLabel label,final int type,final int value) {
					this.label=label;
					this.type=type;
					this.value=value;
				}
				public void mouseEntered(java.awt.event.MouseEvent me) {
					label.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
					label.setForeground(hoverColor);
				}
				public void mouseExited(java.awt.event.MouseEvent me) {
					label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
					label.setForeground(java.awt.Color.BLACK);
				}
				public void mousePressed(java.awt.event.MouseEvent me) {
					calendar.add(type, value);
					label.setForeground(java.awt.Color.WHITE);
					refresh();
				}
				public void mouseReleased(java.awt.event.MouseEvent me) {
					label.setForeground(java.awt.Color.BLACK);
				}
			}
		}
		
		private class BodyPanel extends JPanel{
			public BodyPanel() {
				super(new GridLayout(7,7));
				this.setPreferredSize(new java.awt.Dimension(210,140));
				initMonthPanel();
			}
			private void initMonthPanel() {
				updateDate();
			}
			public void updateDate() {
				this.removeAll();
				LM.clear();
				java.util.Date temp=calendar.getTime();
				Calendar cal=Calendar.getInstance();
				cal.setTime(temp);
				cal.set(Calendar.DAY_OF_MONTH, 1);
				
				int index=cal.get(Calendar.DAY_OF_WEEK);
				// 从当月1号前移，一直移动到面板显示的第一天的前一天；当-index + defaultStartDAY为正数时，为避免面板从当月1号之后开始显示，需要前移一周，确保当月显示完全
				if(index>defaultStartDAY) 
					cal.add(Calendar.DAY_OF_MONTH, -index+defaultStartDAY);
				else cal.add(Calendar.DAY_OF_MONTH, -index+defaultStartDAY-7);
				//增强for循环
				for (WeekLabel weekLabel : weekLabels) {
					this.add(weekLabel);
				}
				for(int i=0;i<42;i++) {
					cal.add(Calendar.DAY_OF_MONTH, 1);
					LM.addLabel(new DayLabel(cal));
				}
				//增强for循环
				for(DayLabel my:LM.getLabels()) {
					this.add(my);
				}
			}
		}
		
		private class FooterPanel extends JPanel{
			private JLabel dateLabel;
			
			public FooterPanel() {
				super(new BorderLayout());
				initFooterPanel();
			}
			private void initFooterPanel() {
				dateLabel=new JLabel("Today is :"+SDF.format(new java.util.Date()));
				dateLabel.addMouseListener(new MouseListener() {
					public void mouseReleased(MouseEvent e) {}
					public void mousePressed(MouseEvent e) {
						calendar.setTime(new Date());
						refresh();
						commit();
					}
					
					public void mouseExited(MouseEvent e) {
						dateLabel.setForeground(Color.BLACK);
					}
					public void mouseEntered(MouseEvent e) {
						dateLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
						dateLabel.setForeground(hoverColor);
					}
					public void mouseClicked(MouseEvent e) {}
				});
				this.add(dateLabel);
			}
			public void updateDate() {};
		}
		//刷新画布
		private void refresh() {
			titlePanel.updateDate();
			bodyPanel.updateDate();
			footerPanel.updateDate();
			SwingUtilities.updateComponentTreeUI(this);
		}
		
		private class WeekLabel extends JLabel{
			private String name;
			
			public WeekLabel(int index,String name) {
				super(name,JLabel.CENTER);
				this.name=name;
			}
			public String toString() {
				return name;
			}
		}
		
		private class DayLabel extends JLabel implements java.util.Comparator<DayLabel>,java.awt.event.MouseListener,java.awt.event.MouseMotionListener{
			private boolean isSelected;
			private int year,month,day;
			
			public DayLabel(Calendar cal) {
				super(""+cal.get(Calendar.DAY_OF_MONTH),JLabel.CENTER);
				this.year=cal.get(Calendar.YEAR);
				this.month=cal.get(Calendar.MONTH);
				this.day=cal.get(Calendar.DAY_OF_MONTH);
				
				this.setFont(font);
				this.addMouseListener(this);
				this.addMouseMotionListener(this);
				if(month==calendar.get(Calendar.MONTH))
					this.setForeground(java.awt.Color.BLACK);
				else
					this.setForeground(java.awt.Color.LIGHT_GRAY);
			}
			public boolean getIsSelected() {
				return isSelected;
			}
			public void setSelected(boolean b,boolean isDrag) {
				isSelected=b;
				if(b&&!isDrag) {
					int temp=calendar.get(Calendar.MONTH);
					calendar.set(year, month,day);
					if(temp==month) {
						SwingUtilities.updateComponentTreeUI(bodyPanel);
					}else {
						refresh();
					}
					this.repaint();
				}
			}
		
		protected void painComponent(Graphics g) {
			//重写方法设置选择日期的背景
			if(day==calendar.get(Calendar.DAY_OF_MONTH)&& month==calendar.get(Calendar.MONTH)) {
				g.setColor(new java.awt.Color(0xBB,0xBF,0xDA));
				g.fillRect(0, 0, getWidth(),getHeight());
			}
			//设置布局
			if(year==now.get(Calendar.YEAR)&&month==now.get(Calendar.MONTH)&&day==now.get(Calendar.DAY_OF_MONTH)) {
				//2D抗锯齿
				Graphics2D gd=(Graphics2D)g;
				gd.setColor(new java.awt.Color(0x55,0x55,0x88));
				Polygon p=new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth()-1, 0);
				p.addPoint(getWidth()-1, getHeight()-1);
				p.addPoint(0, getHeight()-1);
				gd.drawPolygon(p);
			}
			if(isSelected) {
				Stroke s=new BasicStroke(1.0f,BasicStroke.CAP_SQUARE,BasicStroke.JOIN_BEVEL,1.0f,new float[] {2.0f,2.0f},1.0f);
				//2D抗锯齿
				Graphics2D gd=(Graphics2D) g;
				gd.setStroke(s);
				gd.setColor(Color.BLACK);
				Polygon p=new Polygon();
				p.addPoint(0, 0);
				p.addPoint(getWidth()-1,0);
				p.addPoint(getWidth()-1, getHeight()-1);
				p.addPoint(0,getHeight()-1);
				gd.drawPolygon(p);
			}
			super.paintComponent(g);
		}
		public boolean contains(Point p) {
			return this.getBounds().contains(p);
		}
		private void update() {
			repaint();
		}
		public void mouseDragged(MouseEvent e) {}
		public void mouseMoved(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {
			isSelected=true;
			update();
		}
		
		public void mouseReleased(MouseEvent e) {
			Point p=SwingUtilities.convertPoint(this, e.getPoint(), bodyPanel);
			this.setForeground(Color.BLACK);
			LM.setSelect(p,false);
			commit();
		}
		
		public void mouseEntered(MouseEvent e) {
			this.setForeground(hoverColor);
			this.repaint();
		}
		public void mouseExited(MouseEvent e) {
			if(month==calendar.get(Calendar.MONTH))
				this.setForeground(java.awt.Color.BLACK);
			else
				this.setForeground(java.awt.Color.LIGHT_GRAY);
				this.repaint();
		}
		public int compare(DayLabel o1,DayLabel o2) {
			Calendar c1=Calendar.getInstance();
			c1.set(o1.year, o1.month,o1.day);
			Calendar c2=Calendar.getInstance();
			c2.set(o2.year, o2.month,o2.day);
			return c1.compareTo(c2);
		}
	}
	private class LabelManager{
		private List<DayLabel> list;
		
		public LabelManager() {
			list=new ArrayList<Choose.DayLabel>();
		}
		public List<DayLabel> getLabels(){
			return list;
		}
		public void addLabel(DayLabel label) {
			list.add(label);
		}
		public void clear() {
			list.clear();
		}
		public void setSelect(Point p,boolean b) {
			//假设是拖动，需要优化提高效率
			if(b) {
				//表示是否能返回，比较标签，返回上一级，找到需要显示的标签
				boolean findPrevious=false,findNext =false;
				for(DayLabel lab:list) {
					if(lab.contains(p)) {
						findNext=true;
						if(lab.getIsSelected())
							findPrevious=true;
						else
							lab.setSelected(true,b);
					}else if(lab.getIsSelected()) {
						findPrevious=true;
						lab.setSelected(false,b);
					}
					if(findPrevious && findNext)
						return;
				}
						
			}else {
				DayLabel temp=null;
				for(DayLabel m:list) {
					if(m.contains(p)) {
						temp=m;
					}else if(m.getIsSelected()) {
						m.setSelected(false,b);
					}
				}
				if(temp!=null)
					temp.setSelected(true,b);
				}
			}
		}
	 public static void main(String[] args) {
	        JFrame jf = new JFrame("Date Picker Test");
	        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        jf.setLayout(null);
	        jf.setBounds(400, 200, 600, 400);
	        
	        Choose ser = Choose.getInstance();
	        javax.swing.JTextField text = new JTextField();
	        text.setBounds(10, 10, 200, 30);
	        text.setText("2021-06-23");
	        ser.register(text);
	        
	        Choose ser2 = Choose.getInstance("yyyy年MM月dd日");
	        JLabel label = new JLabel("please click me.");
	        label.setBounds(10, 50, 200, 30);
	        ser2.register(label);
	        
	        jf.add(text);
	        jf.add(label);
	        jf.setVisible(true);
	    }
	}