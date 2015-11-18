package org.awt;
import java.awt.*;
import java.awt.event.*;
public class MyGridLayout extends Frame{
	private final String names[]={"A","B","C","D","E","F","G","H","I","J","K","L"};
	private Button[] bts=new Button[12];
	private boolean flag=true;
	final GridLayout grid1=new GridLayout(3,4,5,10);
	final GridLayout grid2=new GridLayout(4,3);
	public MyGridLayout(String title){
		super(title);
		setBackground(Color.orange);
		setLayout();								
		ActionListener listener=new ActionListener(){
			public void actionPerformed(ActionEvent event){
				setLayout();  						// 切换网格布局
				MyGridLayout.this.validate();   			// 使新的布局生效
			}
		};
		for(int i=0;i<bts.length;i++){
			bts[i]=new Button(names[i]);
			bts[i].addActionListener(listener);
			add(bts[i]);
		}
		setSize(300,300);
		setVisible(true);
	}
	//*******切换窗体布局管理器************
	private void setLayout(){
		if(flag) 
			setLayout(grid1);
		else
			setLayout(grid2);
		flag=!flag;
	}
	public static void main(String args[]){
		new MyGridLayout("This is a GridLayout");
	}
}

