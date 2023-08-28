package algorithm.leetcode;


import java.util.ArrayList;
import java.util.List;

/***
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
 * 输入：matrix = [
 *  [1,2,3],
 *  [4,5,6],
 *  [7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 */
public class Spiral_matrix_1 {
    public static void main(String[] args) {
        int[][] matrix = {
                {2,5,8},
                {4,0,-1}
        };
        List<Integer> res = spiralOrder_2(matrix);
        for (Integer item : res) {
            System.out.print(item + " ");
        }
    }

    public static List<Integer> spiralOrder_1(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int rigth = matrix[0].length - 1;
        while (true){
            for (int i = left; i <= rigth; i++) {
                list.add(matrix[up][i]);
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                list.add(matrix[i][rigth]);
            }
            rigth--;
            if (rigth < left) break;
            for (int i = rigth; i >= left; i--) {
                list.add(matrix[down][i]);
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            if (left > rigth) break;
        }
        return list;
    }

    public static List<Integer> spiralOrder_2(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        //还有其他方法，暂搁置

        return list;
    }
}
