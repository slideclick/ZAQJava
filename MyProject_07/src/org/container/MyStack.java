package org.container;
import java.util.*;
public class MyStack {
	LinkedList linkedlist = new LinkedList();
	public void push(Object obj){
	    linkedlist.addFirst(obj);
    }
    public Object pop(){					// ����ջ�е�һ��Ԫ�أ���ɾ��ջ�и�Ԫ��
         return linkedlist.removeFirst();
    }
    public Object peek(){					// ����ջ�е�һ��Ԫ��
         return linkedlist.getFirst();
    }
    public boolean empty(){				// �ж�ջ�Ƿ�Ϊ��
    	    return linkedlist.isEmpty();
    }
    public String toString() {return linkedlist.toString();}
    public static void main(String[] args){
    	    MyStack ms=new MyStack();
         ms.push("Spring");
	     ms.push("Summer");
 ms.push("Autumn");
    		ms.push("Winter"); 
    		System.out.println(ms.pop());
    		System.out.println(ms.peek());
    		System.out.println(ms.pop());
    		System.out.println(ms.empty());
    		System.out.println(ms);
    }
}

