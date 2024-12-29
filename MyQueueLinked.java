package javaapplication2;

import java.util.*;

public class MyQueueLinked<T> {

    MyLinkedList<T> lst;

    public MyQueueLinked() {
        lst = new MyLinkedList();
    }

    //size
    public int size() {
        return lst.Size();
    }

    //isEmpty
    public boolean isEmpty() {
        return lst.isEmpty();
    }

    //addLast
    public void enqueue(T val) {
        lst.add(val);
    }

    //removeFirst
    public T dequeue() {
        if (lst.Size() == 0) {
            throw new NoSuchElementException();
        } else {
            return (T) lst.removeFirst();
        }
    }

    //getFirst(peek)
    public T getfirst() {
        if (lst.Size() == 0) {
            throw new NoSuchElementException();
        } else {
            return (T) lst.getFirst();
        }
    }

    //toString
    @Override
    public String toString() {
        return lst.toString();
    }

}
