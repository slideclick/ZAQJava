package org.iostream;
	import java.io.*;
	import java.util.*;
	//********** 向管道输出流写数据的线程 ******************
	class Sender extends Thread {						// 继承Thread类来创建线程
		private PipedOutputStream out = new PipedOutputStream();
		public PipedOutputStream getPipedOutputStream() {
			return out;
		}
		public void run() {
			String s = "use PipedInputStream and PipedOutputStream to communication.";
			try {
				out.write(s.getBytes());
				out.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}
	//**********管道输入流读数据的线程 ******************
	public class Receiver extends Thread {
		private PipedInputStream in;
		public Receiver(Sender sender) throws IOException {
			in = new PipedInputStream(sender.getPipedOutputStream());
		}
		public void run() {
			try {
				int data;
				while ((data = in.read())!= -1)
					System.out.print((char)data);
				in.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
		public static void main(String args[]) throws Exception {
			Sender sender = new Sender();
			Receiver receiver = new Receiver(sender);
			sender.start();								// 启动线程
			receiver.start();
		}
	}

