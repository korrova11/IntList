package pro.sky.java.course2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        long start2 = System.currentTimeMillis();
        sortInsertion(generateRandomArray());
        System.out.println(System.currentTimeMillis() - start2);//594

        long start = System.currentTimeMillis();
        sortBubble(generateRandomArray());
        System.out.println(System.currentTimeMillis() - start);//14381

        long start1 = System.currentTimeMillis();
        sortSelection(generateRandomArray());
        System.out.println(System.currentTimeMillis() - start1);//3166



       /* int [] arr1 = {7,6,5,4,3};
        sortBubble(arr1);
        System.out.println(Arrays.toString(arr1));
*/
    }
    public static int[] generateRandomArray() {
        java.util.Random random = new java.util.Random();
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        return arr;
    }
    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
    //пузырьковая сортировка
    public static void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }

    }
    //сортировка выбором
    public static void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }
    //сортировка вставкой
    public static void sortInsertion(int[] arr) {
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
    //бинарный поиск
    public static boolean contains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
   /*long start = System.currentTimeMillis();
    sortBubble(generateRandomArray());
        System.out.println(System.currentTimeMillis() - start);*/
}
