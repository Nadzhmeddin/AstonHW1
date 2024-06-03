package homework.sort;


import homework.model.MyArrayModel;

import java.util.Comparator;

public class QuickSort {


    /**
     * Method for sorting an array using a comparator
     * @param arr current array received from the user
     * @param comp comparator specified by an array element
     * @param <E> generic
     */
    public static <E> void sort(MyArrayModel<E> arr, Comparator<E> comp) {
        if(arr == null || arr.getSize() <= 1) {
            return;
        }
        quickSort(arr, 0, arr.size() - 1, comp);
    }

    /**
     * Method for sorting an array using a comparable
     * @param arr current array received from the user
     * @param <E> generic
     */
    public static <E extends Comparable<E>> void sort(MyArrayModel<E> arr) {
        if(arr == null || arr.getSize() <= 1) {
            return;
        }
        quickSort(arr, 0, arr.getSize() - 1);
    }

    private static <E> void quickSort(MyArrayModel<E> arr, int low, int high, Comparator<E> comp) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high, comp);
            quickSort(arr, low, pivotIndex - 1, comp);
            quickSort(arr, pivotIndex + 1, high, comp);
        }
    }

    private static <E> int partition(MyArrayModel<E> arr, int low, int high, Comparator<E> comp) {
        E pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(comp.compare(arr.get(j), pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i +1, high);
        return i + 1;
    }

    private static <E extends Comparable<E>> void quickSort(MyArrayModel<E> arr, int low, int high) {
        if(low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static <E extends  Comparable<E>> int partition(MyArrayModel<E> arr, int low, int high) {
        E pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if(arr.get(j).compareTo(pivot) < 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i +1, high);
        return i + 1;
    }

    private static <E> void swap(MyArrayModel<E> arr, int i, int j) {
        E temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }


}
