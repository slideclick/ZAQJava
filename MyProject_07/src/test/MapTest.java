package test;

import java.util.*;

	class Student {
		public int id ;								// ѧ��
		public String name;							// ����
		public int math_score;							// ��ѧ�ɼ�
		public int english_score;						// Ӣ��ɼ�
		public int computer_score;						// ������ɼ�
		public Student(int id,String name,int math_score,int english_score,int computer_score){
			this.id = id;
			this.name = name;
			this.math_score = math_score;
			this.english_score= english_score;
			this.computer_score = computer_score;
		}
	}
	public class MapTest {
		public static void main(String[] args) {
			TreeMap<Integer, Student> map = new TreeMap<Integer, Student>();
			int total = 0;
			int[] grade = new int[5];
			Student[] s = new Student[5];
			s[0] = new Student(100001, "����", 85, 75, 95);
			s[1] = new Student(100002, "���", 90, 70, 80);
			s[2] = new Student(100003, "�Ϻ�", 92, 80, 80);
			s[3] = new Student(100004, "����", 80, 87, 76);
			s[4] = new Student(100005, "����", 80, 70, 60);
			map.put(100001, s[0]);								// ��������뵽������
			map.put(100002, s[1]);
			map.put(100003, s[2]);
			map.put(100004, s[3]);
			map.put(100005, s[4]);
			int[] arr = new int[5];
			int i = 0;
			int j = Integer.parseInt(args[0]);						// ���ַ���ת��Ϊ����
			System.out.println("ѧ��                ����        ������ɼ�          ��ѧ�ɼ�        Ӣ��ɼ�              ��ѧ��");	
			if(map.containsKey(j)){
				System.out.println("��Ҫ���ҵ�ѧ����Ϣ�ǣ�");
				Student stu = map.get(j);						// ��������ȡ��һ��ѧ��
				System.out.print(stu.id+"    ");
				System.out.print(stu.name+"               ");
				System.out.print(stu.computer_score+"           ");
				System.out.print(stu.english_score+"           ");
				System.out.print(stu.math_score+"          ");
				total = stu.computer_score + stu.english_score + stu.math_score;	// ������ѧ��
				System.out.print(total);
			}
			System.out.println();
			TreeMap<Integer, Student> tp = new TreeMap<Integer, Student>();
			Iterator<Map.Entry<Integer, Student>> it = map.entrySet().iterator();		// ����һ��������
			System.out.println("����ѧ������ǰ��");
			while (it.hasNext()) {
				Map.Entry entry = it.next();
				arr[i] = (Integer) entry.getKey();							// ��ȡ������
				s[i] = (Student) entry.getValue();							// ��ȡֵ����
				System.out.print(s[i].id+"    ");
				System.out.print(s[i].name+"               ");
				System.out.print(s[i].computer_score+"           ");
				System.out.print(s[i].english_score+"           ");
				System.out.print(s[i].math_score+"          ");
				total = s[i].computer_score + s[i].english_score + s[i].math_score;
				System.out.print(total);
				System.out.println();
				grade[i] = total;
				tp.put(grade[i], s[i]);
				i++;
			}
			i=0;
			System.out.println("����ѧ�������");
			Iterator<Map.Entry<Integer, Student>> iter = tp.entrySet().iterator();
			while(iter.hasNext()){
				Map.Entry entry1 = iter.next();
				arr[i] = (Integer) entry1.getKey();
				s[i] = (Student) entry1.getValue();
				System.out.print(s[i].id+"    ");
				System.out.print(s[i].name+"               ");
				System.out.print(s[i].computer_score+"           ");
				System.out.print(s[i].english_score+"           ");
				System.out.print(s[i].math_score+"          ");
				total = s[i].computer_score + s[i].english_score + s[i].math_score;
				System.out.print(total);
				System.out.println();
			}
		}
	}

