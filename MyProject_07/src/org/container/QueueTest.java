package org.container;
import java.util.*;
public class QueueTest {
	public static void printQ(Queue queue){
		while(queue.peek() != null)
			System.out.print(queue.remove() + " ");		// 返回并移取队列的元素
			System.out.println();
	}
	public static void main(String[] args){
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(99);
		for(int i = 0; i < 10; i++)
			queue.offer(rand.nextInt(i + 10));
		printQ(queue);				// 输出队列元素
		Queue<Character> qc = new LinkedList<Character>();
		// 将字符串转换为字符数组，放入到队列中
		for(char c : "Brontosaurus".toCharArray())	
			qc.offer(c);
		printQ(qc);
	}
}

