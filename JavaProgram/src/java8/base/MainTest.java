package java8.base;

public class MainTest {

	public static void main(String[] args) {
		int a = 1;
		int b = 2;
		System.out.println(testDefaultMethod(1,2));
		System.out.println(testLambda1(1,2));
		System.out.println(testFunctionalInterfaceByClass(1,2));
		System.out.println(testFunctionalInterfaceByMethod(1,2));

	}

	/**
	 * 函数式接口
	 * @param a
	 * @param b
	 * @return
	 */
	public static int  testFunctionalInterfaceByClass(int a, int b) {
	FunctionalInterfaceClass  f = new FunctionalInterfaceClass();
	return f.handle((ac,bc) -> ac*bc, a, b);
	}
	
	/**
	 * 函数式接口
	 * @param a
	 * @param b
	 * @return
	 */
	public static int  testFunctionalInterfaceByMethod(int a, int b) {
		return functionalInterfaceDo( (ac,bc) -> ac*bc , a, b);
		}
	
	/**
	 * 函数式接口
	 * @param a
	 * @param b
	 * @return
	 */
	private static int functionalInterfaceDo(HandleFunctionalInterface fun,int a, int b) {
		return  fun.handle(a, b);
	}
	/**
	 * 扩展方法 default method
	 */
	public static int  testDefaultMethod(int a, int b) {
		HandleInterface handleInterface = new HandleInterface() {
			@Override
			public int handle(int a, int b) {
				return a * b;
			}

		};
		return handleInterface.handle(a, b);
	}

	/**
	 * Lambda
	 */
	public static int  testLambda1(int a, int b) {
		HandleInterface handleInterface = (ac, bc) -> ac * bc + a*b;
		return handleInterface.handle(a, b);
	}

}
