package pro.sky.java.course2;

import pro.sky.java.course2.exception.ListFillException;
import pro.sky.java.course2.exception.NotFoundElement;

import java.util.Arrays;

public class IntlistImpl implements Intlist {
    final Integer[] list;
    int size;

    int count;

    public IntlistImpl(int size) {
        this.size = size;
        this.list = new Integer[size];
        count = 0;
    }

    public IntlistImpl() {
        this.list = new Integer[10];
        size = 10;
        count = 0;
    }

    @Override
    public String toString() {
        return
                "list=" + Arrays.toString(list);
    }

    public void ifNull(Integer str) {
        if (str == null) {
            throw new NullPointerException("Элемент пустой");

        }

    }

    public void ifBadIndex(int in) {
        if (in < 0 || in > (list.length - 1)) {
            throw new ArrayIndexOutOfBoundsException("индекс выходит за границы размера списка");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IntlistImpl that = (IntlistImpl) o;
        return Arrays.equals(list, that.list);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(list);
    }


    @Override
    public Integer add(Integer item) {

        ifNull(item);

        if (count==size)  {throw new ListFillException("лист заполнен");}
        list[count] = item;
        count++;
        return item;

    }

    @Override
    public Integer add(int index, Integer item) {
        ifBadIndex(index);
        ifNull(item);

        if (list[list.length - 1] == null) {
            count++;
            Integer temp = item;
            Integer temp1 = 0;
            for (int i = index; i < list.length; i++) {
                temp1 = list[i];
                list[i] = temp;
                temp = temp1;
            }

            return list[index];
        } else {
            throw new ListFillException("лист заполнен");
        }
    }

    @Override
    public Integer set(int index, Integer item) {
        ifBadIndex(index);
        ifNull(item);
        list[index] = item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int i;
        for (i = 0; i < count; i++) {
            if (list[i]==item) break;
        }
        if (i == count) {
            throw new NotFoundElement("элемента нет в списке");
        } else {
            list[i] = null;
            while (i < list.length - 2) {
                list[i] = list[i + 1];
                list[i + 1] = null;
                i++;
            }
            count--;
            return item;

        }
    }

    @Override
    public Integer remove(int index) {
        ifBadIndex(index);
        if (list[index] == null) throw new NullPointerException("под этим индексом ничего нет");
        Integer temp = list[index];
        while (index < count) {
            list[index] = list[index + 1];
            index++;
        }
        count--;
        return temp;
    }
    public  void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }


    @Override
    public boolean contains( Integer item) {

       int i;
        for (i = 0; i < count; i++) {
            if (list[i]==item) break;
        }
        if (i == count) return false;
       else return true;
//        sortInsertion(list);
//        int min = 0;
//        int max = count-1;
//
//        while (min <= max) {
//            int mid = (min + max) / 2;
//
//            if (element == list[mid]) {
//                return true;
//            }
//
//            if (element < list[mid]) {
//                max = mid - 1;
//            } else {
//                min = mid + 1;
//            }
//        }
//        return false;
    }

    @Override
    public int indexOf(Integer item) {
        ifNull(item);

        int i;
        for (i = 0; i < count; i++) {
            if (list[i]==item) break;
        }
        if (i == count) return -1;
        else return i;

    }

    @Override
    public int lastIndexOf(Integer item) {
        int i = count - 1;
        for (i = count - 1; i > -1; i--) {
            if (list[i]==item) break;
        }
        return i;

    }

    @Override
    public Integer get(int index) {
        if (index < 0 || index > (count - 1)) {
            throw new ArrayIndexOutOfBoundsException("Элемента под таким индексом нет");
        } else
            return list[index];
    }


    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        if (list[0] == null) return true;
        else
            return false;
    }

    @Override
    public void clear() {
        Arrays.fill(list, null);
        count = 0;

    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(this.list, size);

    }
}
