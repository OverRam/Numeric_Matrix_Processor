package processor.Matrix;

public class Deter {

    public static double determinant(double[][] matrix, int length) {
        {
            double det = 0;
            if (length == 1) {
                det = matrix[0][0];
            } else if (length == 2) {
                det = matrix[0][0] * matrix[1][1] - matrix[1][0] * matrix[0][1];
            } else {
                det = 0;
                double[][] m = new double[length - 1][length - 1];
                for (int j1 = 0; j1 < length; j1++) {
                    // fill minors without org 1st col
                    for (int i = 1; i < length; i++) {
                        for (int j = 0, j2 = 0; j < length; j++) {
                            if (j == j1)
                                continue;
                            m[i - 1][j2] = matrix[i][j];
                            j2++;
                        }
                    }
                    //1st we change sign * 1st col org matrix * det minors
                    det += Math.pow(-1.0, 1.0 + j1 + 1.0) * matrix[0][j1] * determinant(m, length - 1);
                }

            }
            return det;
        }
    }
}

