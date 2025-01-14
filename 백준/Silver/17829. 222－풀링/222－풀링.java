import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][n];
        String[] arr;

        for (int i = 0; i < n; i++) {
            arr = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(arr[j]);
            }
        }

        System.out.println(dq(nums, n, 0, 0));


    }

    public static int dq(int[][] nums, int size, int row, int column) {
        int[] arr = new int[4];

        if (size == 2) {
            arr[0] = nums[row][column];
            arr[1] = nums[row][column + 1];
            arr[2] = nums[row + 1][column];
            arr[3] = nums[row + 1][column + 1];
        } else {
            arr[0] = dq(nums, size / 2, row, column);
            arr[1] = dq(nums, size / 2, row, column + size / 2);
            arr[2] = dq(nums, size / 2, row + size / 2, column);
            arr[3] = dq(nums, size / 2, row + size / 2, column + size / 2);
        }
        Arrays.sort(arr);
        return arr[2];
    }
}
