package org.awt;
		import java.awt.*;
	import java.awt.event.*;
	public class InnerListener{
		public static void main(String args[]){
			final Frame f=new Frame("");
			f.setBackground(Color.green);					// ���ô������ɫΪ��ɫ
			final FlowLayout fl=new FlowLayout();
			f.setLayout(fl);  							// ʹFrame����FlowLayout����
			Button leftButton=new Button("left");
			leftButton.setBackground(Color.green);
			leftButton.addActionListener(new ActionListener(){ 		// ע���¼�������
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.LEFT);  			// �����
					fl.layoutContainer(f);  					// ʹFrame���²���
				}
			});
			Button centerButton=new Button("center");
			centerButton.setBackground(Color.green);
			centerButton.addActionListener(new ActionListener(){		// ע���¼�������
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.CENTER);  		// ���ж���
					fl.layoutContainer(f);  					
				}
			});
			Button rightButton=new Button("right");
			rightButton.addActionListener(new ActionListener(){  		// ע���¼�������
				public void actionPerformed(ActionEvent event){
					fl.setAlignment(FlowLayout.RIGHT);  		// �Ҷ���
					fl.layoutContainer(f); 					
				}
			});
			rightButton.setBackground(Color.green);		
			f.add(leftButton);								// ����ť���뵽������
			f.add(centerButton);
			f.add(rightButton);
			f.setSize(300,300);
			f.setVisible(true);
		}
	}

