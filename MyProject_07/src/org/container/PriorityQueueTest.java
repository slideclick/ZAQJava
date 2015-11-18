package org.container;
import java.util.*;
import org.container.QueueTest;
public class PriorityQueueTest{
	public static void main(String[] args) {
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>();
		Random rand = new Random(99);
		for(int i = 0; i < 10; i++)
			priorityQueue.offer(rand.nextInt(i + 10));		// 将一个随机数插入到随机队列中
		QueueTest.printQ(priorityQueue);	
		List<Integer> list = Arrays.asList(20, 18, 16,14, 12, 9, 6, 1, 1, 2, 6, 9, 14, 16, 18, 12, 20);
		priorityQueue = new PriorityQueue<Integer>(list);
		QueueTest.printQ(priorityQueue);
	priorityQueue = new PriorityQueue<Integer>(list.size(), Collections.reverseOrder());	// 逆序
		priorityQueue.addAll(list);
		QueueTest.printQ(priorityQueue);
		String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
		List<String> strings = Arrays.asList(fact.split(""));		// 分裂字符串并返回字符数组
		PriorityQueue<String> stringPQ =new PriorityQueue<String>(strings);
		QueueTest.printQ(stringPQ);
		stringPQ = new PriorityQueue<String>(strings.size(), Collections.reverseOrder());
		stringPQ.addAll(strings);
		QueueTest.printQ(stringPQ);
	}
}


