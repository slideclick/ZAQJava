package org.awt;
import java.awt.*;
public class MyFrame{	
	public static void main(String args[]){	
		Frame fr=new Frame();				
		fr.setTitle("This is a Frame");			// �趨�������
		fr.setSize(400,300);					// �趨����Ŀ��Ϊ400���߶�Ϊ300
		fr.setBackground(Color.green);			// �趨����ı���ɫΪ��ɫ
		fr.setLocation(300,500);				// �趨�������Ͻǵĳ�ʼλ��Ϊ(300,500)
		fr.setResizable(false);					// �趨����Ϊ���ɵ�����С
		fr.setVisible(true); 					// ��������Ϊ�ɼ�
	}
}

