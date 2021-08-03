package com.example.stack;

public interface Stack {

    void push(int obj) throws StackOverFlowException;
    int pop() throws StackUnderFlowException;
    int peek() throws StackUnderFlowException;
    boolean isEmpty();
    int size();
}
