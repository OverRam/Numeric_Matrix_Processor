package processor.Matrix;

class MatrixMathOperation {

    protected static double[][] sumMatrix(double[][] matrix1, double[][] matrix2) {
        double[][] sumMatrix = new double[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        return sumMatrix;
    }

    protected static double[][] multiplicationMatrix(double[][] matrix, double[][] matrix2) {
        double[][] multiplicationMatrix = new double[matrix.length][matrix2[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                for (int k = 0; k < matrix2.length; k++) {
                    multiplicationMatrix[i][j] = multiplicationMatrix[i][j] + matrix[i][k] * matrix2[k][j];
                }
            }
        }
        return multiplicationMatrix;
    }

    protected static double[][] multiplicationByConstant(double[][] matrix, double constant) {
        double[][] byConstant = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                byConstant[i][j] = matrix[i][j] * constant;
            }
        }
        return byConstant;
    }

    protected static boolean checkMatrixToSum(double[][] matrix1, double[][] matrix2) {
        return matrix1.length == matrix2.length && matrix1[0].length == matrix2[0].length;
    }

    protected static boolean checkMatrixToMultiplication(double[][] matrix1, double[][] matrix2) {
        return matrix1[0].length == matrix2.length;
    }

}
