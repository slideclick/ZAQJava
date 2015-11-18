package org.awt;
import java.awt.*;
import java.awt.event.*;
public class TextAreaDemo {
		private Frame f = new Frame("�����б༭���е�������ӵ����б༭����");;
		private TextField tf = new TextField(20);
		/*����һ��TextArea�Ķ���ta����ˮƽ�������ʹ�ֱ������*/
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
			tf.addActionListener(new TextHandler());   				 // ע�������		
			// ������fע�ᵽ������WindowHandler��
			f.addWindowListener(new WindowHandler());			 // ע��������
			f.setSize(450, 250);
			f.setResizable(true);
			f.setVisible(true);
		}
		// ������TextHandlerʵ���˽ӿ�ActionListener������ʵ�ַ���actionPerformed
		class TextHandler implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				ta.append(tf.getText() + "\n");		// �ı����е�������ӵ��ı���ta�ĺ���
				tf.setText("");
			}
		}
		class WindowHandler extends WindowAdapter {
			public void windowClosing(WindowEvent e) {	
				System.exit(1);					// �رմ���
			}
		}
}

