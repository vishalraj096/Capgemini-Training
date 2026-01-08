public class MatrixOperations {
    public static double[][] createRandomMatrix(int rows, int cols, int min, int max) {
        double[][] matrix = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = (int) (Math.random() * (max - min + 1)) + min;
            }
        }
        return matrix;
    }

    public static double[][] add(double[][] a, double[][] b) {
        int rows = a.length, cols = a[0].length;
        double[][] res = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[r][c] = a[r][c] + b[r][c];
            }
        }
        return res;
    }

    public static double[][] subtract(double[][] a, double[][] b) {
        int rows = a.length, cols = a[0].length;
        double[][] res = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                res[r][c] = a[r][c] - b[r][c];
            }
        }
        return res;
    }

    public static double[][] multiply(double[][] a, double[][] b) {
        int rows = a.length, cols = b[0].length, inner = a[0].length;
        double[][] res = new double[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                double sum = 0.0;
                for (int k = 0; k < inner; k++)
                    sum += a[r][k] * b[k][c];
                res[r][c] = sum;
            }
        }
        return res;
    }

    public static double[][] transpose(double[][] m) {
        int rows = m.length, cols = m[0].length;
        double[][] t = new double[cols][rows];
        for (int r = 0; r < rows; r++)
            for (int c = 0; c < cols; c++)
                t[c][r] = m[r][c];
        return t;
    }

    public static double determinant2x2(double[][] m) {
        return m[0][0] * m[1][1] - m[0][1] * m[1][0];
    }

    public static double determinant3x3(double[][] m) {
        double a = m[0][0], b = m[0][1], c = m[0][2];
        double d = m[1][0], e = m[1][1], f = m[1][2];
        double g = m[2][0], h = m[2][1], i = m[2][2];
        return a * (e * i - f * h)
                - b * (d * i - f * g)
                + c * (d * h - e * g);
    }

    public static double[][] inverse2x2(double[][] m) {
        double det = determinant2x2(m);
        if (Math.abs(det) < 1e-9)
            return null;
        double invDet = 1.0 / det;
        return new double[][] {
                { m[1][1] * invDet, -m[0][1] * invDet },
                { -m[1][0] * invDet, m[0][0] * invDet }
        };
    }

    private static double minor2x2(double[][] m, int row, int col) {
        double[] vals = new double[4];
        int idx = 0;
        for (int r = 0; r < 3; r++) {
            if (r == row)
                continue;
            for (int c = 0; c < 3; c++) {
                if (c == col)
                    continue;
                vals[idx++] = m[r][c];
            }
        }
        return vals[0] * vals[3] - vals[1] * vals[2];
    }

    public static double[][] inverse3x3(double[][] m) {
        double det = determinant3x3(m);
        if (Math.abs(det) < 1e-9)
            return null;
        double[][] cof = new double[3][3];
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                double minor = minor2x2(m, r, c);
                double sign = ((r + c) % 2 == 0) ? 1 : -1;
                cof[r][c] = sign * minor;
            }
        }
        double[][] adj = transpose(cof);
        double invDet = 1.0 / det;
        double[][] inv = new double[3][3];
        for (int r = 0; r < 3; r++)
            for (int c = 0; c < 3; c++)
                inv[r][c] = adj[r][c] * invDet;
        return inv;
    }

    public static void displayMatrix(String title, double[][] m) {
        System.out.println(title);
        for (double[] row : m) {
            for (double v : row)
                System.out.printf("%8.2f ", v);
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        double[][] a2 = createRandomMatrix(2, 2, -9, 9);
        double[][] b2 = createRandomMatrix(2, 2, -9, 9);
        double[][] a3 = createRandomMatrix(3, 3, -5, 5);
        double[][] b3 = createRandomMatrix(3, 3, -5, 5);

        displayMatrix("A (2x2):", a2);
        displayMatrix("B (2x2):", b2);
        displayMatrix("A + B:", add(a2, b2));
        displayMatrix("A - B:", subtract(a2, b2));
        displayMatrix("A * B:", multiply(a2, b2));
        displayMatrix("transpose(A):", transpose(a2));
        double detA2 = determinant2x2(a2);
        System.out.println("det(A) 2x2 = " + String.format("%.2f", detA2));
        double[][] invA2 = inverse2x2(a2);
        if (invA2 != null)
            displayMatrix("inverse(A):", invA2);
        else
            System.out.println("inverse(A): not invertible\n");

        displayMatrix("A (3x3):", a3);
        displayMatrix("B (3x3):", b3);
        displayMatrix("A + B:", add(a3, b3));
        displayMatrix("A - B:", subtract(a3, b3));
        displayMatrix("A * B:", multiply(a3, b3));
        displayMatrix("transpose(A):", transpose(a3));
        double detA3 = determinant3x3(a3);
        System.out.println("det(A) 3x3 = " + String.format("%.2f", detA3));
        double[][] invA3 = inverse3x3(a3);
        if (invA3 != null)
            displayMatrix("inverse(A):", invA3);
        else
            System.out.println("inverse(A): not invertible\n");
    }
}
