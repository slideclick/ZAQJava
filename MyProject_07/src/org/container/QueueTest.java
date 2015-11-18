package org.container;
import java.util.*;
public class QueueTest {
	public static void printQ(Queue queue){
		while(queue.peek() != null)
			System.out.print(queue.remove() + " ");		// ���ز���ȡ���е�Ԫ��
			System.out.println();
	}
	public static void main(String[] args){
		Queue<Integer> queue = new LinkedList<Integer>();
		Random rand = new Random(99);
		for(int i = 0; i < 10; i++)
			queue.offer(rand.nextInt(i + 10));
		printQ(queue);				// �������Ԫ��
		Queue<Character> qc = new LinkedList<Character>();
		// ���ַ���ת��Ϊ�ַ����飬���뵽������
		for(char c : "Brontosaurus".toCharArray())	
			qc.offer(c);
		printQ(qc);
	}
}

