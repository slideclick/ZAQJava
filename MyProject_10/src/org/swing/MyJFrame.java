package org.swing;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class MyJFrame extends JFrame{
	int i=0,j=0;
   	JLabel jLabel1=new JLabel(" "+i,JLabel.CENTER);
  	JLabel jLabel2=new JLabel(" "+j,JLabel.CENTER);
   	public MyJFrame(){
      	Container contentPane=this.getContentPane();
     	contentPane.setLayout(new GridLayout(2,2));			// ʹ�����񲼾ֹ�����
      	JButton jButton1=new JButton("ADD");
      	JButton jButton2=new JButton("ADD");
      	jButton1.addActionListener(new ActionListener(){ 	// ע�������
      		public void actionPerformed(ActionEvent e){
        			i++;
        		 	jLabel1.setText(" "+i);				//�ַ���ֵ������ֵ���ӳ�Ϊ�ַ���ֵ
         	   }
     	 });
     	 jButton2.addActionListener(new ActionListener(){
        	 	public void actionPerformed(ActionEvent e){
            		 j++;
              	 jLabel2.setText(" "+j);
         	 	}
     	 });
      	contentPane.add(jLabel1);
      	contentPane.add(jLabel2);
      	contentPane.add(jButton1);
      	contentPane.add(jButton2);
     	this.setTitle("This is a JFrame");
      	this.setSize(300,300);
      	this.setVisible(true);
  	}
	public static void main(String[] args){
   	   	new MyJFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // �رմ���
     }
}	

