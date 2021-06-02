package processor.Matrix;

public class InverseMatrix {


    protected static double[][] inverse(double[][] matrix, double determinant) {
        int lenMat = matrix.length;
        if (lenMat <= 2) {
            for (int i = 0; i < lenMat; i++) {
                for (int j = 0; j < lenMat; j++) {
                    matrix[i][j] = Math.pow(-1, 2 + j + i) * matrix[i][j] / 1 / determinant;
                }
            }
            matrix = TransposeMatrix.sideDiagonal(matrix);
        } else {
            matrix = makeCofactorsMatrix(matrix, lenMat);
            matrix = MatrixMathOperation.multiplicationByConstant(matrix, 1 / determinant);
            for (int i = 0; i < lenMat; i++) {
                for (int j = 0; j < lenMat; j++) {
                    matrix[i][j] = Math.pow(-1, 2 + j + i) * matrix[i][j];
                }
            }
            matrix = TransposeMatrix.mainDiagonal(matrix);
        }
        return matrix;
    }

    private static double[][] makeCofactorsMatrix(double[][] matrix, int len) {
        double[][] minors = new double[len][len];
        double[][] calc;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                calc = getMinor(matrix, len, i, j);
                minors[i][j] = Deter.determinant(calc, len - 1);
            }
        }
        return minors;
    }

    private static double[][] getMinor(double[][] matrix, int len, int colI, int rowJ) {
        double[][] minor = new double[len - 1][len - 1];
        int c = 0;
        int r = 0;
        for (int i = 0; i < len; i++) {
            if (i != colI) {
                for (int j = 0; j < len; j++) {
                    if (j != rowJ) {
                        minor[c][r] = matrix[i][j];
                        r++;
                    }
                }
                r = 0;
                c++;
            }
        }
        return minor;
    }

}
