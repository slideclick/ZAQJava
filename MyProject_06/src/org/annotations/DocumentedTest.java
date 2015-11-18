package org.annotations;
	import java.lang.annotation.Documented;
	@Documented
	 @interface DocumentedAnnotations {				// 自定义注解
		String studying();
	}

	public class DocumentedTest {
		@DocumentedAnnotations(studying = "Java")
		public void method() {
			System.out.println("Java is excellent");
		}
		public static void main(String[] args) {
			DocumentedTest usage = new DocumentedTest();
			usage.method();
		}
	}

