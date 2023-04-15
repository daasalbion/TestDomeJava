package py.com.daas.java.testdome;

import java.util.Arrays;

public class SortedSearch {
    public static int countNumbers(int[] sortedArray, int lessThan) {
        int index = Arrays.binarySearch(sortedArray, lessThan);
        // not found, negative value
        if (index < 0) {
            index = index * (-1) - 1;
        }
        int count = 0;
        for (int i = 0; i < index; i++) {
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(SortedSearch.countNumbers(new int[] { 1, 3, 5, 7 }, 4));
    }
}