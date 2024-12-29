package javaapplication6;

public class doubleLinkedList<T> {

    dNode head;
    dNode tail;
    int size;

    //size
    public int size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    //addLast
    public void addLast(T val) {
        dNode x = new dNode(val);
        if (head == null) {
            head = tail = x;
        } else {
            x.setPre(tail);
            tail.setNext(x);
            tail = x;
        }
        size++;
    }

    //addFirst
    public void addFirst(T val) {
        dNode x = new dNode(val);
        if (head == null) {
            head = tail = x;
        } else {
            head.setPre(x);
            x.setNext(head);
            head = x;
        }
        size++;
    }

    //addByIndex
    public void addByIndex(T val, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("invalid index: " + index);
        }
        if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            addLast(val);
        } else {
            dNode x = new dNode(val);
            dNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            curr.getNext().setPre(x);
            x.setNext(curr.getNext());
            curr.setNext(x);
            x.setPre(curr);
        }
        size++;
    }

    //removeFirst
    public T removeFirst() {
        if (head == null) {
            throw new RuntimeException("empty");
        }
        dNode curr = head;
        head = head.getNext();
        if (head == null) {
            tail = null;
        } else {
            head.setPre(null);
        }
        size--;
        return (T) curr.getVal();
    }

    //removeLast
    public T removeLast() {
        if (size == 0) {
            throw new RuntimeException("empty");
        }
        T curr = (T) tail.getVal();
        if (size == 1) {
            head = tail = null;
        } else {
            dNode temp = head;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            temp.setNext(null);
            tail.setPre(null);
            tail = temp;
        }
        size--;
        return (T) curr;

    }

    //toString
    @Override
    public String toString() {
        String str = "[";
        if (head == null) {
            return "[]";
        } else {
            dNode curr = head;
            while (curr != null) {
                str += curr.getVal() + ", ";
                curr = curr.getNext();
            }
            return str.substring(0, str.length() - 2) + "]";
        }
    }

}
