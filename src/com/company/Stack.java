package com.company;

/**
 * Created by LocalAdm on 22.09.2018.
 */
public class Stack {
    private final int MAX_SIZE = 20;
    private int[] stack;
    private int top;
    private int size;

    public Stack()
    {
        this.size = MAX_SIZE;
        stack = new int[size];
        top = -1;
    }

    public Stack(int size)
    {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int value)
    {
        stack[++top] = value;
    }

    public int pop()
    {
        return stack[top--];
    }

    public int peek()
    {
        return stack[top];
    }

    public int getLength()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return (top == -1);
    }

    public void show()
    {
        System.out.print(stack[top]);
    }
}
