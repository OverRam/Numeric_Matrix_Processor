package processor.Matrix;

public class TransposeMatrix {

    protected static double[][] mainDiagonal(double[][] matrix) {
        double[][] mainDiagonal = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mainDiagonal[i][j] = matrix[j][i];
            }
        }
        return mainDiagonal;
    }

    protected static double[][] sideDiagonal(double[][] matrix) {
        double[][] sideDiagonal = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                sideDiagonal[i][j] = matrix[matrix.length - 1 - j][matrix.length - 1 - i];
            }
        }
        return sideDiagonal;
    }

    protected static double[][] verticalLine(double[][] matrix) {
        double[][] verticalLine = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                verticalLine[i][j] = matrix[i][matrix.length - 1 - j];
            }
        }
        return verticalLine;
    }

    protected static double[][] horizontalLine(double[][] matrix) {
        double[][] horizontalLine = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                horizontalLine[i][j] = matrix[matrix.length - 1 - i][j];
            }
        }
        return horizontalLine;
    }

}
