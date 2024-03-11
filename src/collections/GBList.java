package collections;

public interface GBList<T> extends Iterable<T> {

    void add(T value);

    void add(int index, T value);

    T get(int index);

    void remove(T value);

    void removeIndex(int index);

    int size();

    boolean contains(T value);

    int indexOf(T value);

}
