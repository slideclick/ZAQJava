package org.awt;
		import java.awt.*;
	import java.awt.event.*;
	public class InnerListener{
		public static void main(String args[]){
			final Frame f=new Frame("");
			f.setBackground(Color.green);					// 设置窗体的颜色为绿色
			final FlowLayout fl=new FlowLayout();
			f.setLayout(fl);  							// 使Frame采用FlowLayout布局
			Button leftButton=new Button("left");
			leftButton.setBackground(Color.green);
			leftButton.addActionListener(new ActionListener(){ 		// 注册事件监听器
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.LEFT);  			// 左对齐
					fl.layoutContainer(f);  					// 使Frame重新布局
				}
			});
			Button centerButton=new Button("center");
			centerButton.setBackground(Color.green);
			centerButton.addActionListener(new ActionListener(){		// 注册事件监听器
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.CENTER);  		// 居中对齐
					fl.layoutContainer(f);  					
				}
			});
			Button rightButton=new Button("right");
			rightButton.addActionListener(new ActionListener(){  		// 注册事件监听器
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.RIGHT);  		// 右对齐
					fl.layoutContainer(f); 					
				}
			});
			rightButton.setBackground(Color.green);		
			f.add(leftButton);								// 将按钮加入到窗体上
			f.add(centerButton);
			f.add(rightButton);
			f.setSize(300,300);
			f.setVisible(true);
		}
	}

