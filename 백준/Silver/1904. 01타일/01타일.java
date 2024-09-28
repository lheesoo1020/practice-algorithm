import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[1000001];

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        for (int i = 3; i <= n; i++) {
            arr[i] = (arr[i-2] + arr[i-1])%15746;
        }

        System.out.println(arr[n]);

        /*
        n = 1 / 1
        n = 2 / 00 11
        n = 3 / 001 100 111
        n = 4 / 0011 1100 0000 1111 1001
        n = 5 / 00111 10011 11100 11001 10000 00001 11111 00100


         */
    }
}
