import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] result = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(str[j]);
            }
        }

        check(arr, n, 0, 0);

        System.out.println(result[0]);
        System.out.println(result[1]);

    }

    public static void check(int[][] arr, int n, int row, int column) {
        int start = arr[row][column];
        for (int i = row; i < row + n; i++) {
            for (int j = column; j < column + n; j++) {
                if (arr[i][j] != start) {
                    if (n == 1) {
                        result[arr[row][column]]++;
                        result[arr[row+1][column]]++;
                        result[arr[row][column+1]]++;
                        result[arr[row+1][column+1]]++;
                    }
                    check(arr, n/2, row, column);
                    check(arr, n/2, row, column + n/2);
                    check(arr, n/2, row + n/2, column);
                    check(arr, n/2, row + n/2, column + n/2);
                    return;
                }
            }
        }
        result[start]++;
    }
}
