package com.example.stack;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StackUsingArray implements Stack{

    private int[] arr;
    private int top;
    private int capacity;

    private static StackUsingArray instance;
    private static final Logger log = LogManager.getLogger(StackUsingArray.class);

    public static StackUsingArray getInstance(int size) {
        if(instance == null) {
            synchronized (StackUsingArray.class) {
                if(instance == null) {
                    instance = new StackUsingArray(size);
                }
            }
        }
        return instance;
    }

    private StackUsingArray(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    @Override
    public void push(int obj) throws StackOverFlowException {
        if(isStackFull()) {
            log.error("Stack is already full. Not able to push {} ", obj);
            throw new StackOverFlowException("Stack already full. Cant push");
        }

        log.info("Inserting to stack: {}", obj);
        arr[++top] = obj;
    }

    @Override
    public int pop() throws StackUnderFlowException {
        if(!isEmpty()) {
            log.info("Popped elememt is: {}", arr[top]);
            return arr[top--];
        }
        else {
            log.error("Stack is already empty");
            throw new StackUnderFlowException("Stack is already empty. Cant pop");
        }
    }

    @Override
    public int peek() throws StackUnderFlowException {
        if(!isEmpty()) {
            log.info("Peeked elememt is: {}", arr[top]);
            return arr[top];
        }
        else {
            log.error("Stack is already empty");
            throw new StackUnderFlowException("Stack is already empty. Cant peek");
        }
    }

    @Override
    public boolean isEmpty() {
        return top == -1;
    }

    @Override
    public int size() {
        return top+1;
    }


    private boolean isStackFull() {
        return top == capacity-1;
    }
}
