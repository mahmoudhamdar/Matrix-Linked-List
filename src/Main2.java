import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        MatrixLinkedList list = new MatrixLinkedList();
        Scanner sr = new Scanner(System.in);
        int columns;
        int rows;
        try {
            System.out.println("Enter the number of columns");
            columns = sr.nextInt();
            System.out.println("Enter the number of rows");
            rows = sr.nextInt();
            System.out.println("Filling the First matrix");
            System.out.println("Enter only Integers to fill the matrix");
            ArrayList<Integer>[] matrix = createMatrixInput(sr, rows, columns);
            System.out.println("Filling the second Matrix....\n");
            System.out.println("Enter only Integers to fill the matrix");
            ArrayList<Integer>[] matrix2 = createMatrixInput(sr, rows, columns);
            MatrixLinkedList list2 = new MatrixLinkedList();
            list.createMatrix(matrix);
            list2.createMatrix(matrix2);
            System.out.println("operations on the first matrix\n");
            System.out.println(list);
            int index;
            System.out.println("\nEnter a valid rowIndex to that row");
            index = sr.nextInt();
            System.out.println(list.getRow(index));
            System.out.println("Enter a valid column Index to that column");
            index = sr.nextInt();
            System.out.println(list.getColumn(index));
            System.out.println("Enter a valid rowIndex to that row sum");
            index = sr.nextInt();
            System.out.println(list.rowSum(index));
            System.out.println("Enter a valid column Index to that column average");
            index = sr.nextInt();
            System.out.println(list.columnAverage(index));
            System.out.println("Printing the first matrix");
            System.out.println(list);
            int value;
            System.out.println("Enter a value to find in the matrix");
            value = sr.nextInt();
            System.out.println(list.Find(value));
            int rowindex;
            int colindex;
            System.out.println("enter the position of the element you want to change(Row then Column)");
            rowindex = sr.nextInt();
            colindex = sr.nextInt();
            System.out.println("enter the the new value ");
            value = sr.nextInt();
            list.replaceData(rowindex, colindex, value);
            System.out.println(list);
            System.out.println("enter aa scalar to multiply the matrix");
            value = sr.nextInt();
            list.scalarMultiply(value);
            System.out.println(list);
            System.out.println("adding the second matrix to the first....");
            list.add(list2);
            System.out.println(list);
            System.out.println("joining the second matrix to the first matrix");
            list.join(list);
            System.out.println(list);
            sr.close();
        } catch (InputMismatchException e) {
            System.out.println("NOT A NUMBER");
            System.exit(-1);
        }
    }

    private static ArrayList<Integer>[] createMatrixInput(Scanner scanner, int rows, int columns) {
        ArrayList<Integer>[] matrix = new ArrayList[rows];
        int M = 0;
        int input;
        while (M < rows) {
            matrix[M] = new ArrayList<>();
            for (int i = 0; i < columns; i++) {
                try {
                    input = scanner.nextInt();
                    matrix[M].add(input);
                } catch (InputMismatchException e) {
                    System.out.println("ONLY INTEGERS");
                    scanner.nextLine();
                    i--;
                }
            }
            M++;
        }
        return matrix;
    }
}