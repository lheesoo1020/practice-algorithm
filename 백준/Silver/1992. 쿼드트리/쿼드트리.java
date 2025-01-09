import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        dp(arr, n, 0, 0);

        bw.flush();
        bw.close();
    }

    public static void dp(int[][] arr, int n, int row, int column) throws IOException {
        int start = arr[row][column];
        for (int i = row; i < row + n; i++) {
            for (int j = column; j < column + n; j++) {
                if (arr[i][j] != start) {
                    bw.write("(");
                    if (n == 1) {
                        bw.write(arr[row][column]);
                        bw.write(arr[row][column + 1]);
                        bw.write(arr[row + 1][column]);
                        bw.write(arr[row + 1][column + 1]);
                    }
                    dp(arr, n/2, row, column);
                    dp(arr, n/2, row, column + n/2);
                    dp(arr, n/2, row + n/2, column);
                    dp(arr, n/2, row + n/2, column + n/2);
                    bw.write(")");
                    return;
                }
            }
        }
        bw.write(start + "");
    }
}
