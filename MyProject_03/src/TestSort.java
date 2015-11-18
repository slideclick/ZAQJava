class SortDemo {
	int max, midst, mix;
	SortDemo() {
		max = -1;
		midst = -1;
		mix = -1;
	}
	void sort(int i, int j) {				//����������
		int s;
		max = i;
		mix = j;
		if (max < mix) {
			s = max;
			max = mix;
			mix = s;
		}
	}
	void sort(int i, int j, int k) {		//����������
		int s;	
		max = i;
		midst = j;
		mix = k;
		if (max < midst) {					//��һ�����͵ڶ������Ƚ�
			s = max;
			max = midst;
			midst = s;
		}
		if (max < mix) {					//��һ�����͵��������Ƚ�
			s = max;
			max = mix;
			mix = s;
		}
		if (midst < mix) {					//�ڶ������͵��������Ƚ�
			s = midst;
			midst = mix;
			mix = s;
		}
	}
}
public class TestSort {
	public static void main(String args[]) {
		SortDemo sd = new SortDemo();
		sd.sort(30, 60);
		System.out.println("�������Ӵ�СΪ��" + sd.max + "," + sd.mix);
		sd.sort(20, 80, 50);
		System.out.println("�������Ӵ�СΪ��" + sd.max + "," + sd.midst + ","
				+ sd.mix);
	}
}
