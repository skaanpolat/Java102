import java.util.Arrays;

public class Generics<T> {
    T[] arr;


    public Generics() {
        this.arr = (T[]) new Object[10];


    }

    public Generics(int i) {
        this.arr = (T[]) new Object[i];
    }

    public <T> void Generics() {

    }

    public <T> void Generics(int capacity) {

    }

    public int size() {

        int count = 0;
        for (T item : arr) {

            if (item != null) {

                count++;

            }
        }
        return count;
    }

    public int getCapacity() {
        return this.arr.length;
    }

    public void add(T data) {

        for (int i = size(); i < getCapacity(); i++) {

            arr[i] = data;

            if (getCapacity() == size()) {

                this.arr = Arrays.copyOf(this.arr, this.arr.length * 2);

            }
            break;

        }
    }

    public T getByIndex(int index) {
        if (index < 0 && this.arr.length > index) {
            return null;

        }
        return arr[index];
    }

    public T remove(int index) {

        if (index < 0 && this.arr.length >= index) {
            return null;

        }

        for (int i = 0; i < arr.length; i++) {
            if (index == i) {
                arr[i] = arr[i + 1];

            }

        }

        return null;
    }

    public void set(int index, T data) {

        arr[index] = data;

    }

    @Override
    public String toString() {
        StringBuilder outcome = new StringBuilder("[");
        if (size() > 0) {
            for (T item : this.arr) {
                if (item != null) {
                    outcome.append(item).append(",");
                }
            }
        }
        if (outcome.length() > 1) {
            outcome.deleteCharAt(outcome.length() - 1).append("]");
        } else {
            outcome.append("]");
        }
        return outcome.toString();
    }

    public int indexOf(T data) {
        for (int i = 0; i < size(); i++) {
            if (this.arr[i] == data) return i;
        }
        return -1;
    }

    public int lastIndexOf(T data) {
        int counter = 0;
        for (int i = 0; i < size(); i++) {
            if (this.arr[i] == data) {
                counter = i;

            }
        }
        return counter;
    }

    public boolean isEmpty() {

        return size() == 0;
    }

    public T[] toArray() {

        return Arrays.copyOfRange(this.arr, 0, size());

    }

    public Generics<T> sublist(int head, int toe) {
        Generics<Integer> sublist = new Generics<>((toe - head) - 1);

        for (int i = head; i <= toe; i++) {

            sublist.add((Integer) this.arr[i]);

        }
        return (Generics<T>) sublist;

    }

    public boolean contains(T a) {
        for (T item : arr) {
            if (item == a) {
                return true;

            }
        }
        return false;
    }

    public void clear() {
        this.arr = (T[]) new Object[10];
    }
}




