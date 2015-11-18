package org.iostream;
	import java.io.*;
	public class DataStreamDemo {
		public static void main(String[] args) throws IOException {
			FileOutputStream fos = new FileOutputStream(
					"e:/workbench/MyProject_08/src/org/iostream/t4.txt");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			DataOutputStream dos = new DataOutputStream(bos);
			dos.writeByte(75);
			dos.writeLong(10000);
			dos.writeChar('a');
			dos.writeUTF("±±¾©");
			dos.close();
			FileInputStream fis = new FileInputStream(
					"e:/workbench/MyProject_08/src/org/iostream/t4.txt");
			BufferedInputStream bis = new BufferedInputStream(fis);
			DataInputStream dis = new DataInputStream(bis);
			System.out.print(dis.readByte() + " ");
			System.out.print(dis.readLong() + " ");
			System.out.print(dis.readChar() + " ");
			System.out.print(dis.readUTF() + " ");
			dis.close();
		}
	}
