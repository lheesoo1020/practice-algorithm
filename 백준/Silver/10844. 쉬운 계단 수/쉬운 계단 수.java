import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[101][10];

        arr[1][0] = 0;

        for (int i = 1; i < 10; i++) {
            arr[1][i] = 1;
        }
        
        for (int i = 2; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i-1][1] % 1000000000;
                }
                else if (j < 9){
                    arr[i][j] = (arr[i-1][j-1] + arr[i-1][j+1]) % 1000000000;
                }
                else {
                    arr[i][j] = arr[i-1][8] % 1000000000;
                }
            }
        }

        int result = 0;

        for (int i = 0; i < 10; i++) {
            result = (result + arr[n][i]) % 1000000000;
        }


        System.out.println(result);
    }
}
