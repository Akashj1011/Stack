package com.example.stack;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class StackUsingArrayTest {

    StackUsingArray stackUsingArray = StackUsingArray.getInstance(2);

    @Test
    public void pushTest() throws StackOverFlowException, StackUnderFlowException {
        stackUsingArray.push(10);
        assertThat(stackUsingArray.peek()).isEqualTo(10);
        assertThat(stackUsingArray.size()).isEqualTo(1);
        stackUsingArray.pop();
        assertThat(stackUsingArray.isEmpty()).isTrue();
    }

    @Test
    public void popTest() throws StackOverFlowException, StackUnderFlowException {
        stackUsingArray.push(20);
        assertThat(stackUsingArray.pop()).isEqualTo(20);
        assertThat(stackUsingArray.size()).isEqualTo(0);
        assertThat(stackUsingArray.isEmpty()).isTrue();
    }

    @Test
    public void peekTest() throws StackOverFlowException, StackUnderFlowException {
        stackUsingArray.push(50);
        stackUsingArray.push(70);
        assertThat(stackUsingArray.peek()).isEqualTo(70);
        assertThat(stackUsingArray.size()).isEqualTo(2);
        assertThat(stackUsingArray.isEmpty()).isFalse();
        stackUsingArray.pop();
        stackUsingArray.pop();
        assertThat(stackUsingArray.isEmpty()).isTrue();
    }

    @Test
    public void isEmptyTest() throws StackOverFlowException, StackUnderFlowException {
        stackUsingArray.push(50);
        assertThat(stackUsingArray.peek()).isEqualTo(50);
        assertThat(stackUsingArray.size()).isEqualTo(1);
        assertThat(stackUsingArray.isEmpty()).isFalse();
        stackUsingArray.pop();
        assertThat(stackUsingArray.isEmpty()).isTrue();
    }

    @Test
    public void sizeTest() throws StackOverFlowException, StackUnderFlowException {
        stackUsingArray.push(100);
        assertThat(stackUsingArray.size()).isEqualTo(1);
        assertThat(stackUsingArray.peek()).isEqualTo(100);
        stackUsingArray.push(200);
        assertThat(stackUsingArray.size()).isEqualTo(2);
        assertThat(stackUsingArray.isEmpty()).isFalse();
        stackUsingArray.pop();
        stackUsingArray.pop();
        assertThat(stackUsingArray.isEmpty()).isTrue();
    }

}
