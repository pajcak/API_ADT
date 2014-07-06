package scontainers.lists;

import java.util.Arrays;

/**
 *
 * @author Patrik Faistaver
 */
public class ListArray<T> implements IList<T> {
    private int size = 0;
    private Object data[];
    private static final int DEFAULT_CAPAICITY = 5;
    
    public static void main(String[] args) {
        ListArray<String> x = new ListArray<>();
        for (int i = 0; i < 26; i++) {
            x.add(Character.toString((char)('a' + i)));
        }
        System.out.println(x.subList(0, 3).contains("c"));
        for (int i = 0; i < x.getSize(); i++) {
            System.out.println("Elem: " + x.get(i));
        }
    }
    
    public ListArray() {
        data = new Object[DEFAULT_CAPAICITY];
    }
 
    public ListArray(int initialCapacity) {
        data = new Object[initialCapacity];
    }

    private void enlarge() {
        data = Arrays.copyOf(data, size * 2);
    }
    
    @Override
    public void add(T element) {
        if (size == data.length) {
            enlarge();
        }
        data[size++] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T remove(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index:" + index + " is out of bounds.");
        T tmp = (T) data[index];
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        size--;
        return tmp;
    }

    @Override
    public boolean remove(T element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) {
                for (int j = i; j < size; j++) {
                    data[j] = data[j+1];
                }
                size--;
                return true;
            }
        }
        return false;
    }

    @Override
    public void replace(int index, T element) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index:" + index + " is out of bounds.");
        data[index] = element;
    }

    @Override
    @SuppressWarnings("unchecked")
    public IList<T> subList(int fromIndex, int toIndex) {
        if (fromIndex > toIndex || fromIndex < 0 || toIndex > size - 1) 
            throw new IndexOutOfBoundsException("Indexes: (" + fromIndex + ", " + toIndex + ") are out of bounds.");
        ListArray<T> newOne = new ListArray<>(toIndex - fromIndex + 1);
        for (int i = fromIndex; i <= toIndex; i++) newOne.add((T) data[i]);
        return newOne;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index > size - 1) throw new IndexOutOfBoundsException("Index:" + index + " is out of bounds.");
        return (T) data[index];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    @Override
    public boolean contains(T elem) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(elem)) return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0 ? true : false);
    }

    public boolean equals(ListArray<T> list) {
        if (this.size != list.size) return false;
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(list.data[i])) return false;
        }
        return true;
    }
}
