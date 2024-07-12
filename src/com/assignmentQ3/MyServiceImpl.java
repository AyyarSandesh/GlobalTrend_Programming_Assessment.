package com.assignmentQ3;

public class MyServiceImpl implements MyService {
    @Override
    public void performTask() {
        // Simulate some task
        try {
            Thread.sleep(1000); // Simulate some work
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MyService service = (MyService) LogExecutionTimeProcessor.createProxy(new MyServiceImpl());
        service.performTask();
    }
}
