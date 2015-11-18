package org.arrays;
public class Test {
	int[][] arr = new int[4][4]; // ��ʼ��������к���
	int i = 0;					 // ������
	int j = 0;					 // ������
	int num = 1;				 // ��ʼֵΪ 1
	public void spire() {
		if (arr.length != 1) {
			Direction dir = Direction.RIGHT; // ��ʼ����
			while (arr[i][j] == 0) {
				arr[i][j] = num++;
				switch (dir) { // �жϵ�ǰ�����Լ�ת��
				case RIGHT:
					if ((j + 1 < arr[0].length) && (arr[i][j + 1] == 0)) {
						j++;
					} else {
						i++; // ת��������һ��
						dir = Direction.DOWN;
					}
					break;
				case DOWN:
					if ((i + 1 < arr.length) && (arr[i + 1][j] == 0)) {
						i++;
					} else {
						j--;
						dir = Direction.LEFT; // ת��������λ
					}
					break;
				case LEFT:
					if ((j - 1 >= 0) && (arr[i][j - 1] == 0)) {
						j--;
					} else {
						i--;
						dir = Direction.UP; // ת�������Ϸ�λ
					}
					break;
				case UP:
					if ((i - 1 >= 0) && (arr[i - 1][j] == 0)) {
						i--;
					} else {
						j++;
						dir = Direction.RIGHT; // ת�������ҷ�λ
					}
					break;
				}
			}
			print(arr); // ��ӡ
		} else
			System.out.println(1);
	}
	// ��ӡ��������
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	// ������ʾ�����ö��
	public enum Direction {
		RIGHT, DOWN, LEFT, UP
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.spire();
	}
}
