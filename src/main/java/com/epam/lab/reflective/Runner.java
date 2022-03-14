package com.epam.lab.reflective;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

  public static void main(String[] args) {
    try {
      Class myClass = A.class;
      Method method = myClass.getMethod("aaa", String.class);
      A a = (A) myClass.getConstructor().newInstance();
      method.invoke(a, "Sss");
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
