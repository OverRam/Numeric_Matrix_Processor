package processor.Matrix;

import java.util.Locale;
import java.util.Scanner;

class Matrix {

    private final Scanner sc = new Scanner(System.in);
    private final int row;
    private final int col;
    private final double[][] matrix;

    protected Matrix(int row, int col) {
        this.col = col;
        this.row = row;
        matrix = new double[row][col];
    }

    public static double[][] createSubMatrix(double[][] matrix, int excluding_row, int excluding_col) {
        Matrix mat = new Matrix(matrix.length - 1, matrix.length - 1);
        int r = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (i == excluding_row)
                continue;
            r++;
            int c = -1;
            for (int j = 0; j < matrix.length; j++) {
                if (j == excluding_col)
                    continue;
                mat.setValueAt(r, ++c, matrix[i][j]);
            }
        }
        return mat.getDoubleMatrix();
    }

    protected double setValueAt(int row, int col, double value) {
        return matrix[row][col] = value;
    }

    protected double getValueAt(int row, int col) {
        return matrix[row][col];
    }


    protected double[][] setDoubleMatrix() {
        sc.useLocale(Locale.US);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    protected double[][] getDoubleMatrix() {
        return matrix;
    }
}
