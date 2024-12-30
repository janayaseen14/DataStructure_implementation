package javaapplication7;

public class cNode<T> {

    T val;
    cNode next;

    public cNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public cNode getNext() {
        return next;
    }

    public void setNext(cNode next) {
        this.next = next;
    }

}
