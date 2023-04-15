package py.com.daas.java.testdome;

import java.util.HashMap;

public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        HashMap<Integer, Integer> hashMap= new HashMap<>();
        for (int i = 0; i < list.length; i++) {
            hashMap.put(list[i], i);
        }
        for (int i = 0; i < list.length; i++) {
            int rest = sum - list[i];
            if (hashMap.containsKey(rest) && hashMap.get(rest) != i) {
                return new int[] {i, hashMap.get(rest)};
            }
        }

        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[]{3, 1, 5, 7, 5, 9}, 10);
        if (indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}