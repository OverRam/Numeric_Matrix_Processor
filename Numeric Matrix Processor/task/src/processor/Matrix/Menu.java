package processor.Matrix;

import java.util.Scanner;

import static processor.Matrix.Deter.determinant;
import static processor.Matrix.InverseMatrix.inverse;
import static processor.Matrix.MatrixMathOperation.*;
import static processor.Matrix.TransposeMatrix.*;

public class Menu {
    private final Scanner sc = new Scanner(System.in);
    private int chose = 1;

    private void printMatrix(double[][] matrix) {
        System.out.println("The result is: ");
        for (double[] e : matrix) {
            for (double r : e) {
                System.out.printf("%.2f ", r);
            }
            System.out.println();
        }
    }

    public void run() {
        while (getChose() != 0) {
            System.out.println("\n1. Add matrices\n" +
                    "2. Multiply matrix by a constant\n" +
                    "3. Multiply matrices\n" +
                    "4. Transpose matrix \n" +
                    "5. Calculate a determinant \n" +
                    "6. Inverse matrix \n" +
                    "0. Exit");
            System.out.print("Your choice: ");
            chose = sc.nextInt();
            Chose();
        }
    }

    public int getChose() {
        return chose;
    }

    private void Chose() {
        switch (chose) {
            case 1:
                optionAddMatrixToMatrix();
                break;
            case 2:
                optionByConstant();
                break;
            case 3:
                optionMultiply();
                break;
            case 4:
                optionTranspose();
                break;
            case 5:
                optionDeterminant();
                break;
            case 6:
                optionInverseMatrix();
                break;
            case 0:
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + chose);
        }
    }

    private void optionInverseMatrix() {
        double[][] matrix1 = firstMatrix();
        double det = determinant(matrix1, matrix1.length);
        if (det == 0 || matrix1.length != matrix1[0].length){
            System.out.println("This matrix doesn't have an inverse.");
        } else {
            printMatrix(inverse(matrix1, det));
        }
    }

    private void optionDeterminant() {
        double[][] matrix1 = firstMatrix();
        System.out.println(determinant(matrix1, matrix1.length));
    }

    private void optionTranspose() {
        System.out.print("\n1. Main diagonal\n" +
                "2. Side diagonal\n" +
                "3. Vertical line\n" +
                "4. Horizontal line\n");

        System.out.print("Your choice: ");
        int transposeOption = sc.nextInt();

        double[][] matrix1 = firstMatrix();

        printMatrix(makeTransposeSelect(transposeOption, matrix1));
    }

    private double[][] makeTransposeSelect(int option, double[][] matrix) {
        switch (option) {
            case 1:
                return mainDiagonal(matrix);

            case 2:
                return sideDiagonal(matrix);

            case 3:
                return verticalLine(matrix);

            case 4:
                return horizontalLine(matrix);
            default:
                return matrix;
        }
    }

    private void optionAddMatrixToMatrix() {
        double[][] matrix1 = firstMatrix();
        double[][] matrix2 = secondMatrix();

        if (checkMatrixToSum(matrix1, matrix2)) {
            printMatrix(sumMatrix(matrix1, matrix2));
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    private void optionByConstant() {
        double[][] matrix1 = firstMatrix();
        System.out.println("Enter constant: ");
        double constant = sc.nextDouble();
        printMatrix(multiplicationByConstant(matrix1, constant));
    }

    private void optionMultiply() {
        double[][] matrix1 = firstMatrix();
        double[][] matrix2 = secondMatrix();

        if (checkMatrixToMultiplication(matrix1, matrix2)) {
            printMatrix(multiplicationMatrix(matrix1, matrix2));
        } else {
            System.out.println("The operation cannot be performed.");
        }
    }

    private double[][] firstMatrix() {
        System.out.print("Enter size of first matrix: ");
        Matrix matrix1 = new Matrix(sc.nextInt(), sc.nextInt());
        System.out.println("Enter first matrix: ");
        matrix1.setDoubleMatrix();
        return matrix1.getDoubleMatrix();
    }

    private double[][] secondMatrix() {
        System.out.print("Enter size of second matrix:");
        Matrix matrix2 = new Matrix(sc.nextInt(), sc.nextInt());
        System.out.print("Enter second matrix:");
        matrix2.setDoubleMatrix();
        return matrix2.getDoubleMatrix();
    }
}
