class TestToString {
		private String s = "spring ";
		public TestToString(String str) {
			this.s = str + this.s;
		}
		public static void main(String[] args) {
			TestToString test = new TestToString("hibernate ");
			System.out.println(test);
			System.out.println(test.s);
		}
		public String toString() {						// ��дObject���toString()����
			this.s = "struts " + this.s;
			return s;
		}
	}

