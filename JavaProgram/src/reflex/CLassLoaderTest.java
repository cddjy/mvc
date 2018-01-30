package reflex;

import domain.Car;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CLassLoaderTest {

  public static void main(String[] args) {
//    printLoaderClass();
  /*  produceCarByNew();
    produceCarByNewInstance();*/
//    D:\cddDocument\zProject\JavaProgram\src\reflex\CLassLoaderTest.java
//    printMethod();
    try {
      produceCarByNewInstance();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static void printLoaderClass() {
    System.out.println("---------------produceCarByNewInstance start");
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    ClassLoader parent = loader.getParent();
    ClassLoader parent1 = parent.getParent();
    System.out.println(loader);
    System.out.println(parent);
    System.out.println(parent1);
    System.out.println("---------------produceCarByNewInstance end");
  }

  public static void printMethod() {
    System.out.println("---------------printMethod start");
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    Class<?> aClass = null;
    try {
      aClass = loader.loadClass("domain.Car");
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    Method[] declaredMethods = aClass.getDeclaredMethods();
    for (Method method : declaredMethods
        ) {
      System.out.println("___________________name:" + method.getName());
      System.out.println("getModifiers:" + method.getModifiers());
      System.out.println("getGenericReturnType:" + method.getGenericReturnType());
      System.out.println("ReturnType:" + method.getReturnType());
      System.out.println("parameters().length:" + method.getParameters().length);
    }
    System.out.println("---------------printMethod end");
  }

  public static Car produceCarByNewInstance()
      throws Exception {

    Object s = null;
    Class clazz = Car.class;
    s = clazz.newInstance();
    Car car = (Car) s;
    Field typeF = clazz.getDeclaredField("type");
    typeF.setAccessible(true);
    typeF.set(car,"mn");
    System.out.println("typeF:"+typeF.get(car));
//    public Method getDeclaredMethod(String name, Class<?>... parameterTypes)
    Method driveMethod = null;
    driveMethod = clazz.getDeclaredMethod("drive", (Class[]) null);
    driveMethod.setAccessible(true);
    driveMethod.invoke(car, (Object[]) null);
    clazz.getDeclaredMethods();

    return car;
  }
}
