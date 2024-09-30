import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] cost = new int[n+1][3];

        for (int i = 1; i < n+1; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        for (int i = 2; i < n+1; i++) {
            cost[i][0] = Integer.min(cost[i-1][1], cost[i-1][2]) + cost[i][0];
            cost[i][1] = Integer.min(cost[i-1][0], cost[i-1][2]) + cost[i][1];
            cost[i][2] = Integer.min(cost[i-1][0], cost[i-1][1]) + cost[i][2];
        }

        int result = Integer.min(cost[n][0], cost[n][1]);
        result = Integer.min(result, cost[n][2]);

        System.out.println(result);
    }
}
