package com.assignmentQ3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class LogExecutionTimeProcessor {
	 public static Object createProxy(Object object) {
	        return Proxy.newProxyInstance(
	            object.getClass().getClassLoader(),
	            object.getClass().getInterfaces(),
	            new LogExecutionTimeHandler(object));
	    }

	    private static class LogExecutionTimeHandler implements InvocationHandler {
	        private final Object target;

	        public LogExecutionTimeHandler(Object target) {
	            this.target = target;
	        }

	        @Override
	        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
	            if (method.isAnnotationPresent(LogExecutionTime.class)) {
	                long startTime = System.nanoTime();
	                Object result = method.invoke(target, args);
	                long endTime = System.nanoTime();
	                long executionTime = endTime - startTime;
	                System.out.println(method.getName() + " executed in " + executionTime + " ns");
	                return result;
	            } else {
	                return method.invoke(target, args);
	            }
	        }
	    }
}
