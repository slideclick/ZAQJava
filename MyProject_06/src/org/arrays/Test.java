package org.arrays;
public class Test {
	int[][] arr = new int[4][4]; // 初始化矩阵的行和列
	int i = 0;					 // 横坐标
	int j = 0;					 // 纵坐标
	int num = 1;				 // 初始值为 1
	public void spire() {
		if (arr.length != 1) {
			Direction dir = Direction.RIGHT; // 初始方向
			while (arr[i][j] == 0) {
				arr[i][j] = num++;
				switch (dir) { // 判断当前方向以及转向
				case RIGHT:
					if ((j + 1 < arr[0].length) && (arr[i][j + 1] == 0)) {
						j++;
					} else {
						i++; // 转入矩阵的下一行
						dir = Direction.DOWN;
					}
					break;
				case DOWN:
					if ((i + 1 < arr.length) && (arr[i + 1][j] == 0)) {
						i++;
					} else {
						j--;
						dir = Direction.LEFT; // 转入矩阵的左方位
					}
					break;
				case LEFT:
					if ((j - 1 >= 0) && (arr[i][j - 1] == 0)) {
						j--;
					} else {
						i--;
						dir = Direction.UP; // 转入矩阵的上方位
					}
					break;
				case UP:
					if ((i - 1 >= 0) && (arr[i - 1][j] == 0)) {
						i--;
					} else {
						j++;
						dir = Direction.RIGHT; // 转入矩阵的右方位
					}
					break;
				}
			}
			print(arr); // 打印
		} else
			System.out.println(1);
	}
	// 打印矩阵数组
	public static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
	// 用来表示方向的枚举
	public enum Direction {
		RIGHT, DOWN, LEFT, UP
	}
	public static void main(String[] args) {
		Test t = new Test();
		t.spire();
	}
}
