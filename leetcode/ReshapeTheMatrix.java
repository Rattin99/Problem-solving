import java.util.Collections;
import java.util.LinkedList;

public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] a = { { 2, 3 }, { 1, 2 } };

        print(matrixReshape2(a, 1, 4));

    }

    // one loop, O(r*c)
    public static int[][] matrixReshape2(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] res = new int[r][c];

        if (m * n != r * c)
            return mat;

        for (int i = 0; i < m * n; i++) {
            res[i / c][i % c] = mat[i / n][i % n];
        }

        return res;
    }

    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        int col = 0, row = 0;
        int[][] res = new int[r][c];

        if (m * n != r * c)
            return mat;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row % r][col % c] = mat[i][j];
                col++;
                row++;
            }

        }

        return res;
    }

    public static int[][] AmarmatrixReshape(int[][] mat, int r, int c) {
        LinkedList<Integer> set = new LinkedList();

        int[][] res = new int[r][c];

        if (mat.length * mat[0].length != r * c)
            return mat;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                set.add(mat[i][j]);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (!set.isEmpty()) {
                    res[i][j] = set.getFirst();
                    set.removeFirst();
                }
            }
        }

        return res;
    }

    public static void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]);
            }
        }
    }
}
