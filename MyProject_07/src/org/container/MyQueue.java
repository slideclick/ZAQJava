package org.container;
import java.util.*;
public class MyQueue {
 	private LinkedList linkedlist=new LinkedList();
 	public void put(Object o){					// 添加一个元素到队列的队尾
	 	linkedlist.addLast(o);
 	}
 	// 使用removeFirst()方法，返回队列中第一个数据，然后将它从队列中删除
 	public Object get(){
  		return linkedlist.removeFirst();
 	}
 	public Object peek(){						// 返回队列中第一个数据
		return linkedlist.getFirst();
 	}
 	public boolean empty(){					// 判断队列是否为空
  		return linkedlist.isEmpty();
 	}
 	public String toString() {return linkedlist.toString();}
 	public static void main(String[] args){
 		MyQueue mq=new MyQueue();
  		mq.put("Spring");					// 向队列中添加元素
  		mq.put("Summer");
  		mq.put("Autumn");
  		mq.put("Winter");
  		System.out.println(mq.get());			
  		System.out.println(mq.peek());
  		System.out.println(mq.get());
  		System.out.println(mq.peek());
 		System.out.println(mq.empty());
  		System.out.println(mq);
 	}
}

