package javaapplication1;

import java.util.*;

public class MyQueueArray<T> {

    myArrayList<T> lst;

    public MyQueueArray() {
        lst = new myArrayList();
    }

    //isEmpty
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    //size
    public int size() {
        return lst.size();
    }

    //addLast
    public void enqueue(T val) {
        lst.addLast(val);
    }

    //removeFirst
    public T dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return lst.removeFirst();
    }

    //getFirst(peek)
    public T getfirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return lst.get(0);
    }

    //toString
    @Override
    public String toString() {
        return lst.toString();
    }
}
