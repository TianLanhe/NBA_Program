package nba.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class NBASearcher<T> {
  private List<T> list;

  public NBASearcher(List<T> list) {
    this.list = list;
  }

  public List<T> findAll(String methodName, Object target) {
    if (list == null || list.size() == 0) return null;
    List<T> ret = new ArrayList<T>();
    Class<? extends Object> c = list.get(0).getClass();
    Method method = null;
    try {
      method = c.getMethod(methodName);
      for (T t : list)
        if (method.invoke(t).equals(target)) ret.add(t);
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return ret;
  }

  public T find(String methodName, Object target) {
    if (list == null || list.size() == 0) return null;
    Class<? extends Object> c = list.get(0).getClass();
    Method method = null;
    try {
      method = c.getMethod(methodName);
      for (T t : list)
        if (method.invoke(t).equals(target)) return t;
    } catch (NoSuchMethodException e) {
      e.printStackTrace();
    } catch (SecurityException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (IllegalArgumentException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
    return null;
  }
}
