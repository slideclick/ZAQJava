package org.swing;
import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
public class MyJDialog extends JFrame implements ActionListener{
    public MyJDialog(){
        Container contentPane=this.getContentPane();
        JButton bt=new JButton("显示对话框");
        bt.addActionListener(this);
        contentPane.add(bt);
        setTitle("This is a JDialog");
        setSize(300,300);
        setLocation(400,400);
        setVisible(true);
    }
    /* 响应窗体的按钮事件 */
    public void actionPerformed(ActionEvent e){
        if(e.getActionCommand().equals("显示对话框")){
            MonitorDialog monitor=new MonitorDialog(this);
        }
    }
    class MonitorDialog implements ActionListener{
        JDialog jDialog=null;
        MonitorDialog(JFrame jf){
            jDialog=new JDialog(jf,"Dialog",true);
            JButton bt=new JButton("关闭");
            bt.addActionListener(this);
            jDialog.getContentPane().add(bt);
            jDialog.setSize(80,80);
            jDialog.setLocation(450,450);
            jDialog.setVisible(true);
        }
        // 响应对话框中的按钮事件
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("关闭")){
                jDialog.dispose();
            }
        }
    }
    public static void main(String[] args){
    	new MyJDialog();
    }
}
