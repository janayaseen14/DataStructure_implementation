package javaapplication7;

public class circularLinkedList<T> {

    private cNode<T> head, tail;
    private int size;

    //addFirst
    public void addFirst(T val) {
        cNode x = new cNode(val);
        if (head == null) {
            head = x;
            tail = x;
            tail.setNext(head);
        } else {
            x.setNext(head);
            tail.setNext(x);
            head = x;
        }
        size++;
    }

    //addLast
    public void addLast(T value) {
        cNode x = new cNode(value);
        if (head == null) {
            head = x;
            tail = x;
            tail.setNext(head);
        } else {
            tail.setNext(x);
            x.setNext(head);
            tail = x;
        }
        size++;
    }

    //addByIndex
    public void addByIndex(int index, T val) {
        cNode x = new cNode(val);
        if (head == null) {
            head = x;
            tail = x;
            tail.setNext(head);
        } else if (index == 0) {
            addFirst(val);
        } else if (index == size - 1) {
            addLast(val);
        } else {
            cNode curr = head;
            for (int i = 0; i < index - 1; i++) {
                curr = curr.next;
            }
            if (curr != null) {
                x.setNext(curr.getNext());
                curr.setNext(x);
            } else {
                System.out.println("Position out of range");
                return;
            }
        }
        size++;
    }

    //removeFirst
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.getNext();
            tail.next = head;
        }
        size--;
    }

    //removeLast
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            cNode temp = head;
            while (temp.getNext() != tail) {
                temp = temp.getNext();
            }
            temp.setNext(head);
            tail = temp;
        }
        size--;
    }

    //toString
    public String toString() {
        String str = "[";
        if (head == null) {
            return "[]";
        }
        cNode temp = head;
        do {
            str += temp.getVal() + ", ";
            temp = temp.getNext();
        } while (temp != head);
        return str.substring(0, str.length() - 2) + "]";
    }
}
