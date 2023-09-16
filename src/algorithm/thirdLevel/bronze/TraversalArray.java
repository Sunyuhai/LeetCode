package algorithm.thirdLevel.bronze;

public class TraversalArray {
    public static void arrayprint(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6};
        TraversalArray.arrayprint(arr);
    }
}
