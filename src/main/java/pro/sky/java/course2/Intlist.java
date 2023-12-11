package pro.sky.java.course2;

public interface Intlist {
    Integer add(Integer item);

    Integer add(int index, Integer item);

    Integer set(int index, Integer item);

    Integer remove(Integer item);

    Integer remove(int index);

    boolean contains(Integer item);

    int indexOf(Integer item);

    int lastIndexOf(Integer item);

    Integer get(int index);


    int size();

    boolean isEmpty();

    void clear();

    Integer[] toArray();

    boolean equals(Object o);

    int hashCode();

}
