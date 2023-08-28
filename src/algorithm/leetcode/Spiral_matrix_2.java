package algorithm.leetcode;

/***
 * 给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 * 输入：n = 3
 * 输出：[
 * [1,2,3],
 * [8,9,4],
 * [7,6,5]]
 */
public class Spiral_matrix_2 {
    public static void main(String[] args) {
        int[][] matrix = generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int num = 1;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int rigth = n - 1;
        while (true){
            for (int i = left; i <= rigth; i++) {
                matrix[up][i] = num++;
            }
            up++;
            if (up > down) break;
            for (int i = up; i <= down; i++) {
                matrix[i][rigth] = num++;
            }
            rigth--;
            if (rigth < left) break;
            for (int i = rigth; i >= left; i--) {
                matrix[down][i] = num++;
            }
            down--;
            if (down < up) break;
            for (int i = down; i >= up; i--) {
                matrix[i][left] = num++;
            }
            left++;
            if (left > rigth) break;
        }
        return matrix;
    }
}
