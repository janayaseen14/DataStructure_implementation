package javaapplication1;

public class myArrayList<T> {

    private int size;
    private T[] a;

    public myArrayList() {
        a = (T[]) new Object[3];
        size = 0;
    }

    //size
    public int size() {
        return size;
    }

    //isEmpty
    public boolean isEmpty() {
        return size == 0;
    }

    //isFull
    public boolean isFull() {
        return size == a.length;
    }

    //clear
    public void clear() {
        a = (T[]) new Object[3];
        //or 
//        for(int i=0;i<size;i++){
//            a[i]=0;
//        }
//        size=0;
    }

    //set
    public void set(T value, int index) {
        if (index > 0 || index >= size) {
            return;
        } else {
            a[index] = value;
        }
    }

    //get
    public T get(int index) {
        if (index >= 0 && index < size) {
            return a[index];
        } else {
            throw new RuntimeException(); //او شو مبدنا
        }
    }

    //addLast
    public void addLast(T value) {
        if (size == a.length) {
            ensurCapa();
        }
        a[size] = value;
        size++;
    }

    //addByIndex
    public void addByIndex(T value, int index) {
        if (index >= 0 && index <= size) {
            if (size == a.length) {
                ensurCapa();
            }
            for (int i = size - 1; i >= index; i--) {
                a[i + 1] = a[i];
            }
            a[index] = value;
            size++;
        } else {
            throw new RuntimeException();
        }

    }

    //addFirst
    public void addFist(T value) {
        addByIndex(value, 0);
    }

    //addAll 
    public void addAll(T[] a) {
        for (int i = 0; i < size; i++) {
            addLast(a[i]);
        }
    }

    //ensurCapa
    private void ensurCapa() {
        T[] temp = (T[]) new Object[a.length * 2];
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }

    //removeLast
    public T removeLast() {
        T res = a[size - 1];
        if (size != 0) {
            size--;
            return res;
        }
        throw new RuntimeException();

    }

    //removeByIndex
    public T removeByIndex(int index) {
        T res;
        if (index >= 0 && index < size) {
            res = a[index];
            for (int i = index; i < size - 1; i++) {
                a[i] = a[i + 1];
            }
            size--;
            return res;
        }
        throw new RuntimeException();
    }

    //removeFirst
    public T removeFirst() {
        T res;
        if (size != 0) {
            res = a[0];
            for (int i = 0; i < size; i++) {
                a[i] = a[i + 1];
            }
            size--;
            return res;
        }
        throw new RuntimeException();
    }

    //indexOf
    public int indexOf(T value) {
        int res = -1;
        for (int i = 0; i < size; i++) {
            if (a[i] == value) {
                res = i;
            }
        }
        return res;
    }

    //contain
    public boolean contain(T value) {
        for (int i = 0; i < size; i++) {
            if (a[i] == value) {
                return true;
            }
            //or
            //if(get(i) == value)
            //وبقدر احط بدل المساواة ايكوال يعني اعمل فنشكن
        }
        return false;
    }

    //toString
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += (a[i] + " ");
        }
        return str;
    }

}
