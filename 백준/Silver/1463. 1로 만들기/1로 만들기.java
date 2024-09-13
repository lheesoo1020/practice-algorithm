import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1000001];

        for(int i = 2; i < dp.length; i++) {

            if(i%6 == 0) {
                if(dp[i/3] < dp[i/2]) dp[i] = dp[i/3] + 1;
                else dp[i] = dp[i/2] + 1;
            }

            else if(i%3 == 0) {
                if(dp[i/3] < dp[i-1]) dp[i] = dp[i/3] + 1;
                else dp[i] = dp[i-1] + 1;
            }

            else if(i%2 == 0) {
                if(dp[i/2] < dp[i-1]) dp[i] = dp[i/2] + 1;
                else dp[i] = dp[i-1] + 1;
            }

            else dp[i] = dp[i-1] + 1;
        }

        int num = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(dp[num]));
        bw.flush();
        bw.close();
    }
}
