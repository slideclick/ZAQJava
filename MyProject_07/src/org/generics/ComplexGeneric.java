package org.generics;
public class ComplexGeneric<T1, T2> {
	private T1 first;
	private T2[] second;								// 数组类型
	public void setFirst(T1 f) {
		this.first = f;
	}
	public T1 getFirst() {
		return first;
	}
	public void setSecond(T2[] s) {
		this.second = s;
	}
	public T2[] getSecond() {
		return second;
	}
	public static void main(String[] args) {
		ComplexGeneric<Integer, String> generic = new ComplexGeneric<Integer, String>();
		String[] season = { "spring", "summer", "autumn","winter"};
		generic.setFirst(new Integer(9));
		generic.setSecond(season);
		System.out.println(generic.getFirst());
		String[] strs = generic.getSecond();
		for (String str : strs) {
			System.out.println(str);
		}
	}
}

