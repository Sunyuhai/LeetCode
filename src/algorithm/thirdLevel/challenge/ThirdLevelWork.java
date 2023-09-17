package algorithm.thirdLevel.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ThirdLevelWork {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,1,2,2,3,4,5};
        int[] arr2 = new int[]{0,2,2,2,2,2,5};
        arrayPrint(deleteRepeatElement(arr2));
    }

    public static int[] deleteRepeatElement(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]){
                set.add(arr[i]);
            }
        }
        int slow = 0;
        for (int fast = 0; fast < arr.length; fast++) {
            if (!set.contains(arr[fast])){
                swap(arr,slow,fast);
                slow++;
            }
        }
        return Arrays.copyOf(arr,slow);
    }

    public static void swap(int[] nums,int i,int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void arrayPrint(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

}
