package org.container;
import java.util.*;
public class MyStack {
	LinkedList linkedlist = new LinkedList();
	public void push(Object obj){
	    linkedlist.addFirst(obj);
    }
    public Object pop(){					// 返回栈中第一个元素，并删除栈中该元素
         return linkedlist.removeFirst();
    }
    public Object peek(){					// 返回栈中第一个元素
         return linkedlist.getFirst();
    }
    public boolean empty(){				// 判断栈是否为空
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

