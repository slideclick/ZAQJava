interface CanDo {									// 接口
		void doIt();
	}
	interface CanDoMore extends CanDo {
		void doMore();
	}
	interface CanDoFaster extends CanDo {						// 未实现接口中的方法仍是接口
		void doFaster();
	}
	interface CanDoMost extends CanDoMore, CanDoFaster {		// 多继承
		void doMost();
	}
	class Doer implements CanDoMost {
		public void doIt() {
			System.out.println("doIt()");
		}
		public void doMore() {
			System.out.println("doMore()");
		}
		public void doFaster() {
			System.out.println("doFaster()");
		}
		public void doMost() {
			System.out.println("doMost()");
		}
	}
	public class DiamondInheritance13 {				
		public static void main(String[] args) {
			Doer d = new Doer();
			((CanDoMore)d).doMore();						// 向下类型转换
			((CanDoFaster)d).doFaster();
			((CanDo)d).doIt();	
		}
	}

