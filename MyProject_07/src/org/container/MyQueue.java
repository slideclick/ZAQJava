package org.container;
import java.util.*;
public class MyQueue {
 	private LinkedList linkedlist=new LinkedList();
 	public void put(Object o){					// ���һ��Ԫ�ص����еĶ�β
	 	linkedlist.addLast(o);
 	}
 	// ʹ��removeFirst()���������ض����е�һ�����ݣ�Ȼ�����Ӷ�����ɾ��
 	public Object get(){
  		return linkedlist.removeFirst();
 	}
 	public Object peek(){						// ���ض����е�һ������
		return linkedlist.getFirst();
 	}
 	public boolean empty(){					// �ж϶����Ƿ�Ϊ��
  		return linkedlist.isEmpty();
 	}
 	public String toString() {return linkedlist.toString();}
 	public static void main(String[] args){
 		MyQueue mq=new MyQueue();
  		mq.put("Spring");					// ����������Ԫ��
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

