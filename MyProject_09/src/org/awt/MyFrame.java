package org.awt;
import java.awt.*;
public class MyFrame{	
	public static void main(String args[]){	
		Frame fr=new Frame();				
		fr.setTitle("This is a Frame");			// 设定窗体标题
		fr.setSize(400,300);					// 设定窗体的宽度为400，高度为300
		fr.setBackground(Color.green);			// 设定窗体的背景色为绿色
		fr.setLocation(300,500);				// 设定窗体左上角的初始位置为(300,500)
		fr.setResizable(false);					// 设定窗体为不可调整大小
		fr.setVisible(true); 					// 将窗体设为可见
	}
}

