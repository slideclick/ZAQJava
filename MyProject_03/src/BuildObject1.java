class Computer {
		Computer() {
			System.out.println("computer is very good!");
		}
		Computer(String s) {
			System.out.println("computer brand is"+s);
		}	
	} 
	public class BuildObject1 {
		public static void main(String[] args) {
			Computer k = new Computer();
			Computer k2 = new Computer("lenovo");
		}
	}
