package org.awt;
	import java.awt.*;
	import java.awt.event.*;
	import java.util.*;
	public class StudentInfo extends Frame implements ActionListener{
		static HashMap map = new HashMap();
		Button bt1 = new Button();
		Button bt2 = new Button();
		TextArea textArea1 = new TextArea();
		Button bt3 = new Button();
		public StudentInfo() {
			try {
				initialize();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) {
			StudentInfo student = new StudentInfo();
			student.setBackground(Color.cyan);
			student.setVisible(true);
			student.setSize(new Dimension(400, 250));				// 指定宽度和高度
			student.setTitle("学生信息");
		}
		private void initialize() throws Exception {
			this.setLayout(null);
			bt1.setLabel("注册");
			bt1.setBackground(Color.cyan);
			bt1.setBounds(new Rectangle(85, 200, 70, 25));
			bt1.addActionListener(this);							// 本身实现监听接口
			
			bt2.setBounds(new Rectangle(170, 200, 70, 25));
			bt2.addMouseListener(new actionAdapter(this));			// 外部类实现监听接口
			bt2.setLabel("查看");
			bt2.setBackground(Color.cyan);
			textArea1.setEditable(false);
			textArea1.setText("");
			textArea1.setBackground(Color.white);
			textArea1.setBounds(new Rectangle(80, 40, 250, 150));
			bt3.setLabel("关闭");
			bt3.setBackground(Color.cyan);
			//********内部类实现监听接口************************
			bt3.addActionListener(new ActionListener(){		
				public void actionPerformed(ActionEvent evt){
					System.exit(0);
				}
			});
			bt3.setBounds(new Rectangle(255, 200, 70, 25));
			this.setResizable(false);
			this.add(textArea1);
			this.add(bt2);
			this.add(bt1);
			this.add(bt3);
		}
//		void button3_actionPerformed(ActionEvent e) {
//			System.exit(0);
//		}
		//********实现监听器ActionListener的actionPerformed方法
		public void actionPerformed(ActionEvent e) {			
			RegisterFrame regf = new RegisterFrame();
			regf.setTitle("信息注册");
			regf.setVisible(true);
			regf.setSize(new Dimension(350, 180));
			regf.setBackground(Color.cyan);
		}
	}
	class RegisterFrame extends Frame implements ActionListener {
		Label label1 = new Label();
		TextField textField1 = new TextField();
		Label label2 = new Label();
		TextField textField2 = new TextField();
		Button button1 = new Button();
		Button button2 = new Button();
		public RegisterFrame() {
			try {
				register();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		private void register() throws Exception {
			this.setLayout(null);
			label1.setText("学生学号：");
			label1.setBackground(Color.cyan);
			label1.setBounds(new Rectangle(50, 50, 60, 20));
			
			textField1.setText("");
			textField1.setBounds(new Rectangle(120, 50, 140, 20));
			label2.setBounds(new Rectangle(50, 80, 60, 20));
			label2.setText("学生姓名：");
			label2.setBackground(Color.cyan);
			textField2.setText("");
			textField2.setBounds(new Rectangle(120, 80, 140, 20));
			button1.setLabel("确定");
			button1.setBackground(Color.cyan);
			button1.setBounds(new Rectangle(85, 120, 70, 25));
			button1.addActionListener(this);
			button2.setBounds(new Rectangle(180, 120, 70, 25));
			button2.setBackground(Color.cyan);
			button2.addActionListener(new ActionListener(){				// 内部类
				public void actionPerformed(ActionEvent evt){
					System.exit(0);
				}
			});
			button2.setLabel("取消");
			this.setResizable(false);
			this.add(button2);
			this.add(label1);
			this.add(label2);
			this.add(textField2);
			this.add(textField1);
			this.add(button1);
			}
		//********事件监听器******************************
		public void actionPerformed(ActionEvent e) {	
			String id = textField1.getText();
			String name = textField2.getText();
			StudentInfo.map.put(id, name);
			this.dispose();
		}
	}
	/*********鼠标事件适配器******************************/
	class actionAdapter extends MouseAdapter{		
		StudentInfo studentAdapter;
		public actionAdapter(StudentInfo studentInfo) {
			this.studentAdapter = studentInfo;
		}
		public void mouseClicked(MouseEvent evt) {
			Button button = (Button)evt.getSource();
			studentAdapter.textArea1.setText("");
			Iterator iter = studentAdapter.map.keySet().iterator();		// 遍历map容器
			while (iter.hasNext()) {
				String id = iter.next().toString();
				studentAdapter.textArea1.append("学号：" + id + "         姓名："
						+ studentAdapter.map.get(id).toString() + '\n');
			}
		}
	}

