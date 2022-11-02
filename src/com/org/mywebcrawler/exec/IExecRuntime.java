package com.org.mywebcrawler.exec;

/**
 * @param <T>
 */
public interface IExecRuntime<T> {
  T httpProcess(Class<?> o, String url);
}
