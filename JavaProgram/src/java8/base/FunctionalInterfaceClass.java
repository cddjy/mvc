package java8.base;

public class FunctionalInterfaceClass {
	
	public int handle(HandleFunctionalInterface fi ,int a,int b){
		return fi.handle(a, b);
	};
	
	
}
/**
 * 函数式接口。
 * 函数式接口只能有一个方法.
 * @author jianyi
 *
 */
@FunctionalInterface
interface HandleFunctionalInterface{
	public int handle(int a,int b);
}
