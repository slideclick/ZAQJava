package org.container;
	public class AssociativeArray<K, V> {
		private Object[][] pairs;
		private int index;
		public AssociativeArray(int length) {
			pairs = new Object[length][2];
		}
		public void put(K key, V value) {				// 向容器中加入元素
			if (index >= pairs.length)
				throw new ArrayIndexOutOfBoundsException();
				pairs[index++] = new Object[] { key, value };
			}
		public V get(K key) {						// 从容器中取出与键对象对应的值对象
			for (int i = 0; i < index; i++) {
				if (key.equals(pairs[i][0]))
					return (V) pairs[i][1];
			}
			return null;
		}
		public String toString() {
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < index; i++) {
				result.append(pairs[i][0].toString());
				result.append(" : ");
				result.append(pairs[i][1].toString());
				if (i < index - 1)
					result.append("\n");
			}
			return result.toString();
		}
		public static void main(String[] args) {
			AssociativeArray<String, String> map = new AssociativeArray<String, String>(6);
			map.put("sky", "blue");
			map.put("grass", "green");
			map.put("ocean", "dancing");
			map.put("tree", "tall");
			map.put("earth", "brown");
			map.put("sun", "warm");
			try {
				map.put("extra", "object");
			} catch (ArrayIndexOutOfBoundsException e) {		// 数组索引越界异常
				System.out.println("Too many objects!");
			}
			System.out.println(map);
			System.out.println(map.get("ocean"));
		}
	}

