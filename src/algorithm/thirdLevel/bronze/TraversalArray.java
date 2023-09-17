package algorithm.thirdLevel.bronze;

import java.util.List;

public class TraversalArray {
    public static void arrayPrint(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void listStrngPrint(List<String> list){
        for (String em : list) {
            System.out.print(em + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        TraversalArray.arrayPrint(arr);
    }
}
