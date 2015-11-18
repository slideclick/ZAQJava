public class Sum {
		static int P(int n) {
			return n == 0 ? 0 : n + P(n - 1);
		}
		public static void main(String[] args) {
			System.out.println("1+2+...+100÷Æ∫Õ «: " + P(100));
		}
}
