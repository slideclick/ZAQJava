package org.awt;
	import java.awt.*;
	import java.util.Arrays;
	import java.util.regex.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	public class ArraySort extends Frame implements ActionListener{
		static TextArea ta1 = new TextArea();
		static TextArea ta2 = new TextArea();
		static Button bt1 = new Button("排序前");
		static Button bt2 = new Button("排序后");
		public static void main(String[] args) {
			ArraySort as = new ArraySort();
			as.setLayout(null);							// 取消布局管理器
			as.setBackground(Color.cyan);
			as.setSize(300, 200);
			as.setVisible(true);
			ta1.setBounds(70, 40, 220, 70);
			ta2.setBounds(70,120,220,70);
			as.add(ta1);
			bt1.setBounds(10,60,50,30);
			bt2.setBounds(10,140,50,30);
			bt1.setBackground(Color.cyan);
			bt2.setBackground(Color.cyan);
			as.add(bt1);
			as.add(bt2);
			bt2.addActionListener(as);					// 注册事件监听器
			as.add(ta2);
		}
		public void actionPerformed(ActionEvent e) {
			String s = ta1.getText();
			int[] arr = new int[10];						// 创建1个整型数组
			Pattern p = Pattern.compile("(\\d{1,4})");		// 编译正则表达式
			Matcher m = p.matcher(s);						// 对字符串进行匹配
			int i =0; 
			while(m.find()) {								// 寻找与指定模式匹配的下一个子序列
				int j = 0;
				j = Integer.parseInt(m.group());			// 将字符串类型转换为整型
				arr[i]= j;
				i++;
			}
			Arrays.sort(arr);								// 对数组进行排序
			for(int c = 0;c<i;c++){ 
				String str1 = String.valueOf(arr[c]);
				ta2.append(str1+"   ");						// 将数组中的内容输出到文本区中
			}
		}
	}

