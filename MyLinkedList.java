package javaapplication2;

public class MyLinkedList<T> {

    private int size;
    private Node head, tail;

    //size
    public int Size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return head == null;
    }

    //addLast
    void add(T val) {
        Node x = new Node(val);
        if (head == null) {
            head = x;
            tail = x;
        } else {
            tail.next = x;
            tail = x;
        }
        size++;
    }

    //addFirst
    void addFirst(T val) {
        Node x = new Node(val);
        if (head == null) {
            head = x;
            tail = x;
        } else {
            x.next = head;
            head = x;
        }
        size++;
    }

    //addByIndex
    void addByIndex(T val, int index) {
        if (index < 0 || index > size) {
            throw new RuntimeException("invalid index");
        } else if (index == 0) {
            addFirst(val);
        } else if (index == size) {
            add(val);
        } else {
            Node x = new Node(val);
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            x.setNext(curr.getNext());
            curr.setNext(x);
            size++;
        }
    }

    //removeFirst
    T removeFirst() {
        if (size == 0) {
            throw new RuntimeException("invalid");
        }
        Node curr = head;
        head = curr.next;
        if (head == null) {
            tail = null;
        }
        size--;
        T x = (T) curr.getVal();
        return x;
    }

    //removeLast
    T removeLast() {
        if (head == null) {
            throw new RuntimeException("emptyy");
        }
        T res = (T) tail.getVal();
        if (size == 1) {
            head = tail = null;
            size = 0;
        } else {
            Node pre = head;
            while (pre.getNext().getNext() != null) {
                pre = pre.getNext();
            }
            tail = pre;
            tail.setNext(null);
        }
        size--;
        return res;
    }

    //removeByIndex
    T removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("invalid index");
        } else if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.getNext();
            }
            T res = (T) curr.getNext().getVal();
            curr.setNext(curr.getNext().getNext());
            size--;
            return res;
        }
    }

    //add a
    void add(int... a) {
        Node dummy = new Node(0);
        Node curr = dummy;
        for (int i = 0; i < a.length; i++) {
            curr.next = new Node(a[i]);
            curr = curr.next;
        }
        size += a.length;
        if (tail != null) {
            tail.next = dummy.next;
        }
        if (head == null) {
            head = dummy.next;
        }
    }
    
    //toString
    @Override
    public String toString() {
        String str = "[";
        if (head == null) {
            return "[]";
        } else {
            Node curr = head;
            while (curr != null) {
                str += curr.getVal() + ", ";
                curr = curr.getNext();
            }
            return str.substring(0, str.length() - 2) + "]";
        }
    }

}
