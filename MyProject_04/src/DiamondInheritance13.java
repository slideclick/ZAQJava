interface CanDo {									// �ӿ�
		void doIt();
	}
	interface CanDoMore extends CanDo {
		void doMore();
	}
	interface CanDoFaster extends CanDo {						// δʵ�ֽӿ��еķ������ǽӿ�
		void doFaster();
	}
	interface CanDoMost extends CanDoMore, CanDoFaster {		// ��̳�
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
			((CanDoMore)d).doMore();						// ��������ת��
			((CanDoFaster)d).doFaster();
			((CanDo)d).doIt();	
		}
	}

