package org.swing;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class MyJDialog extends JFrame implements ActionListener{
    public MyJDialog(){
        Container contentPane=this.getContentPane();
        JButton bt=new JButton("��ʾ�Ի���");
        bt.addActionListener(this);
        contentPane.add(bt);
        setTitle("This is a JDialog");
        setSize(300,300);
        setLocation(400,400);
        setVisible(true);
    }
    /* ��Ӧ����İ�ť�¼� */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("��ʾ�Ի���")){
            MonitorDialog monitor=new MonitorDialog(this);
        }
    }
    class MonitorDialog implements ActionListener{
        JDialog jDialog=null;
        MonitorDialog(JFrame jf){
            jDialog=new JDialog(jf,"Dialog",true);
            JButton bt=new JButton("�ر�");
            bt.addActionListener(this);
            jDialog.getContentPane().add(bt);
            jDialog.setSize(80,80);
            jDialog.setLocation(450,450);
            jDialog.setVisible(true);
        }
        // ��Ӧ�Ի����еİ�ť�¼�
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("�ر�")){
                jDialog.dispose();
            }
        }
    }
    public static void main(String[] args){
    	new MyJDialog();
    }
}
