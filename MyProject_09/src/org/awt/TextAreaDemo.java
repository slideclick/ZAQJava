package org.awt;
import java.awt.*;
import java.awt.event.*;
public class TextAreaDemo {
		private Frame f = new Frame("将单行编辑框中的内容添加到多行编辑框中");;
		private TextField tf = new TextField(20);
		/*创建一个TextArea的对象ta，有水平滚动条和垂直滚动条*/
		private TextArea ta = new TextArea("", 5, 10, TextArea.SCROLLBARS_BOTH);	
		Font ft = new Font("Serif", Font.BOLD, 28);
		public static void main(String args[]) {
			TextAreaDemo tad = new TextAreaDemo();
			tad.go();	
		}
		void go() {
			f.setLayout(new BorderLayout(0, 10));
			f.add("North", tf);
			f.add("Center", ta);
			ta.setFont(ft);
			tf.setFont(ft);
			tf.addActionListener(new TextHandler());   				 // 注册监听器		
			// 将窗口f注册到监听器WindowHandler上
			f.addWindowListener(new WindowHandler());			 // 注册适配器
			f.setSize(450, 250);
			f.setResizable(true);
			f.setVisible(true);
		}
		// 监听器TextHandler实现了接口ActionListener，必须实现方法actionPerformed
		class TextHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText() + "\n");		// 文本框中的文字添加到文本区ta的后面
				tf.setText("");
			}
		}
		class WindowHandler extends WindowAdapter {
			public void windowClosing(WindowEvent e) {	
				System.exit(1);					// 关闭窗口
			}
		}
}

