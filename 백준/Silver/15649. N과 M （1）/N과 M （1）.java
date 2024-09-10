import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        String[] list = str.split(" ");

        int n = Integer.parseInt(list[0]);
        int m = Integer.parseInt(list[1]);

        int[] nums = new int[m];
        boolean[] check = new boolean[n+1];

        dfs(1, n, m, nums, check);

    }

    public static void dfs(int depth, int n, int m, int[] nums, boolean[] check) {
        if (depth == m+1) {
            for (int num : nums) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (check[i]) continue;
            check[i] = true;
            nums[depth-1] = i;
            dfs(depth+1, n, m, nums, check);
            check[i] = false;
        }
    }
}
