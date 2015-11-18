package org.concurrency.collation;
	import java.util.*;
	public class TaskQueue {
		private List queue = new LinkedList();					// 创建队列
		//********从队列中取出任务并从队列中移除该任务*********
		public synchronized Task getTask() {							
			while (queue.size() == 0) {
				try {
					this.wait();							// 等待客户端新的请求
				} catch (InterruptedException e) {
					e.printStackTrace();
					return null;
				}
			}
			return (Task) queue.remove(0);					// 移除当前任务
		}
		//*********把当前的任务放入队列中**********
		public synchronized void putTask(Task task) {													queue.add(task);
			this.notifyAll();								// 等待服务器处理
		}
	}
