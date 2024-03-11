package collections.lists;

import collections.GBList;
import collections.lists.util.ArrayIterator;

import java.util.Iterator;

public class GBLinkedList<T> implements GBList<T> {
    private int size;
    private Node<T> head;

    public GBLinkedList() {
        this.size = 0;
        this.head = null;
    }

    @Override
    public void add(T value) {
        if (head == null) {
            this.head = new Node<>(value, null);
        }
        else {
            Node<T> curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = new Node<>(value, null);
        }
        size++;
    }
    @Override
    public void add(int index, T value) {
        if (index > size) index = size;
        Node<T> curr = head;
        if (index == 0) {
            curr = new Node<>(value, head);
            head = curr;
            size++;
            return;
        }
        Node<T> prev = curr;
        curr = curr.next;
        for (int i = 1; i <= index; i++) {
            if (i == index) {
                curr = new Node<>(value, curr);
                prev.next = curr;
                size++;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public T get(int index) {
        if (index >= size) return null;
        Node<T> ret = head;
        for (int i = 0; i < index; i++) {
            ret = ret.next;
        }
        return ret.item;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(value)) return true;
        }
        return false;
    }

    public int indexOf(T value) {
        for (int i = 0; i < size; i++) {
            if (get(i).equals(value)) return i;
        }
        return -1;
    }

    @Override
    public void remove(T value) {
        if (head.item.equals(value)) {
            head = head.next;
            size--;
            return;
        }
        Node<T> prev = head;
        Node<T> curr = head.next;
        while (curr != null) {
            if (curr.item.equals(value)) {
                prev.next = curr.next;
                size--;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    @Override
    public void removeIndex(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        int count = 1;
        Node<T> prev = head;
        Node<T> curr = head.next;
        while (count != index) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        prev.next = curr.next;
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<>(toArray());
    }

    public T[] toArray() {
        T[] ret = null;
        try {
            ret = (T[]) new Object[size];
            for (int i = 0; i < size; i++) {
                ret[i] = get(i);
            }
        }
        catch (ClassCastException e) {
            e.printStackTrace();
        }
        return ret;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> curr = head;
        for (int i = 0; i < size; i++) {
            sb.append(curr);
            curr = curr.next;
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    private static class Node<E> {
        E item;
        GBLinkedList.Node<E> next;

        Node(E element, GBLinkedList.Node<E> next) {
            this.item = element;
            this.next = next;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
