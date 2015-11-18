package org.container;
import java.util.*;
public class ComputerComparator implements Comparator<Computer> {
	public int compare(Computer c1, Computer c2) {
		if (c1.brand.compareTo(c2.brand) > 0)				// brand����������
			return -1;
		else if (c1.brand.compareTo(c2.brand) < 0)
			return 1;
		else
			return c1.place.compareTo(c2.place);			// place����������
	}
	public static void main(String[] args) {
		Set<Computer> set = new TreeSet<Computer>(new ComputerComparator());
		Computer computer1 = new Computer("dell", "shanghai");
		Computer computer2 = new Computer("hp", "shenzhen");
		Computer computer3 = new Computer("hp", "Guangzhou");
		Computer computer4 = new Computer("lenovo", "Beijing");
		Computer computer5 = new Computer("dell", "Beijing");
		set.add(computer1);							// �������м���Ԫ��
		set.add(computer2);
		set.add(computer3);
		set.add(computer4);
		set.add(computer5);
		Iterator<Computer> it = set.iterator();				// ����һ��������
		while (it.hasNext()) {
			Computer computer = it.next();
			System.out.println(computer);
		}
	}
}
class Computer {
	String brand;
	String place;
	public Computer(String b, String p) {
		this.brand = b;
		this.place = p;
	}
	public String toString() {
		return "computer brand: " + brand + ",  place:" + place;
	}
	public boolean equals(Object o) {						// ��дequals()
		if (!(o instanceof Computer))
			return false;
		Computer c = (Computer) o;
		if (this.brand.equals(c.brand) && this.place == c.place)
			return true;
		else
			return false;
	}
	public int hashCode() {							// ��дhashCode()
		int result;
		result = (brand == null ? 0 : brand.hashCode());
		return result;
	}
}

