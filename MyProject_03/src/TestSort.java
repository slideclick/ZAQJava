class SortDemo {
	int max, midst, mix;
	SortDemo() {
		max = -1;
		midst = -1;
		mix = -1;
	}
	void sort(int i, int j) {				//两个数排序
		int s;
		max = i;
		mix = j;
		if (max < mix) {
			s = max;
			max = mix;
			mix = s;
		}
	}
	void sort(int i, int j, int k) {		//三个数排序
		int s;	
		max = i;
		midst = j;
		mix = k;
		if (max < midst) {					//第一个数和第二个数比较
			s = max;
			max = midst;
			midst = s;
		}
		if (max < mix) {					//第一个数和第三个数比较
			s = max;
			max = mix;
			mix = s;
		}
		if (midst < mix) {					//第二个数和第三个数比较
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
		System.out.println("两个数从大到小为：" + sd.max + "," + sd.mix);
		sd.sort(20, 80, 50);
		System.out.println("三个数从大到小为：" + sd.max + "," + sd.midst + ","
				+ sd.mix);
	}
}
