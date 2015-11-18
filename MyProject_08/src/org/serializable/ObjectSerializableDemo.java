package org.serializable;
import java.io.*;
import java.util.*;

class Point implements Serializable {
	private int x;
	private int y;
	private transient int z;
	public Point(int x, int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public String toString() {
		return "(" + x + "," + y + "," + z  + ","+")";
	}
}
public class ObjectSerializableDemo {
	public static void main(String[] args) throws Exception {
		String filename = "e:/workbench/MyProject_08/src/org/iostream/t11.obj";
		// 将二进制文件串接成一个对象输出流
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				filename));
		for (int k = 0; k < 10; k++) {
			oos.writeObject(new Point(k, 2 * k,3*k));		//将点对象写入文件中
			
		}
		oos.flush();
		oos.close();
		//将点对象写入文件中
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				filename));
		for (int k = 0; k < 10; k++) {
			Point pt = (Point) ois.readObject();		//从文件中读出点对象
			System.out.print(pt + " ");
		}
		ois.close();
	}
}
