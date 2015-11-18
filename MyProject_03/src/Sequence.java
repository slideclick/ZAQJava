class Pupil {
		Pupil(int age) {
			System.out.println("pupil: " + age);
		}
	}
	class Teacher {
		Pupil p1 = new Pupil(9); 
		Teacher() {
			System.out.println("Teacher()");
			p3 = new Pupil(10); 
		}
		Pupil p2 = new Pupil(11); 
		void teach() {
			System.out.println("teach()");
		}
		Pupil p3 = new Pupil(12); 
	}
	public class Sequence {
		public static void main(String[] args) {
			Teacher t = new Teacher();
			t.teach(); 
		}
	}

