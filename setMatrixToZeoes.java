import java.util.Arrays;

public class setMatrixToZeoes {

    // Brute Force Approach
    // Mark the corresponding row and column with -1
    // whenever a zero is found, and convert -1 to 0 later
    public static int[][] setMAtrixZeroesBrute(int arr[][]) {

        int m = arr.length;
        int n = arr[0].length;

        // Find all zero elements
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (arr[i][j] == 0) {

                    // Mark all non-zero elements in the current row
                    for (int col = 0; col < n; col++) {
                        if (arr[i][col] != 0) {
                            arr[i][col] = -1;
                        }
                    }

                    // Mark all non-zero elements in the current column
                    for (int row = 0; row < m; row++) {
                        if (arr[row][j] != 0) {
                            arr[row][j] = -1;
                        }
                    }
                }
            }
        }

        // Convert all marked elements to zero
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    // Better Approach
    // Use separate arrays to keep track of rows and columns
    // that need to be converted to zero
    public static int[][] setMAtrixZeroesBetter(int arr[][]) {

        int n = arr.length;
        int m = arr[0].length;

        // row[i] = true means row i needs to be zero
        boolean row[] = new boolean[n];

        // col[j] = true means column j needs to be zero
        boolean col[] = new boolean[m];

        // Find all rows and columns containing zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (arr[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Set the marked rows and columns to zero
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (row[i] || col[j]) {
                    arr[i][j] = 0;
                }
            }
        }

        return arr;
    }

    // Optimal Approach
    // Use the first row and first column as markers
    // to achieve O(1) extra space
    public static int[][] setMAtrixZeroesOptimal(int matrix[][]) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Track whether the first row contains zero
        boolean firstRowZero = false;

        // Track whether the first column contains zero
        boolean firstColZero = false;

        // Check if the first row contains zero
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if the first column contains zero
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use the first row and first column as markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set cells to zero based on the markers
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set the first row to zero if required
        if (firstRowZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set the first column to zero if required
        if (firstColZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }

        return matrix;
    }

    public static void main(String[] args) {

        // Sample matrix
        int arr[][] = {
            {1, 1, 1, 1},
            {1, 0, 0, 1},
            {1, 1, 0, 1},
            {1, 1, 1, 1}
        };

        // Set matrix zeroes using the optimal approach
        System.out.println(
            Arrays.deepToString(setMAtrixZeroesOptimal(arr))
        );
    }
}