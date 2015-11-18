package org.circle;
/**
 * Title: 求圆的面积
 * Description: 已知圆的半径r，求圆的面积
 * Copyright: Copyright (c) 2009
 * Company: 南京师范大学
 * @author 郑阿奇
 * @version 2.0
 */
public class Area {
	public static void main(String[] args) {
		double PI = 3.1415; 					// 定义常量
		double r, area;
		r = 3;
		area = PI * r * r; 						// 求圆面积
		System.out.println("圆的面积=" + area); 	// 在屏幕上显示结果
	}
}
