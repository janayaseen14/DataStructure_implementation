
package javaapplication6;

public class dNode <T>{
    private T val;
    private dNode next;
    private dNode pre;

    public dNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public dNode getNext() {
        return next;
    }

    public void setNext(dNode next) {
        this.next = next;
    }

    public dNode getPre() {
        return pre;
    }

    public void setPre(dNode pre) {
        this.pre = pre;
    }

   
    
    
}
