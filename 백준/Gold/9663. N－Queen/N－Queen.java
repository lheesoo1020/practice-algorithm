import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] chess;
    static int n;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        chess = new int[n];

        nQueen(0);

        System.out.println(cnt);


    }

    public static void nQueen(int k) {
        /*for (int i = 0; i < n; i++) {
            chess[k] = i;
            if (promising(k)) {
                if (k < n - 1) {
                    nQueen(k + 1);
                }
                else {
                    cnt++;
                }
            }
            else {
                chess[k] = 0;
            }
        }*/
        /*for (int i = 0; i < n; i++) {
            if (promising(k, i)) {

                if (k < n - 1) {
                    nQueen(k + 1);
                }
                else {
                    cnt++;
                }
            }
        }*/
        for (int i = 0; i < n; i++) {
            if (promising(k, i)) {
                if (k < n - 1) {
                    nQueen(k + 1);
                }
                else {
                    cnt++;
                }
            }
        }
    }

    public static boolean promising(int k, int q) {

        if (k != 0) {
            for (int i = 0; i < k; i++) {
                if ((Math.abs(chess[i] - q) == Math.abs(i - k)) || (chess[i] == q)) {
                    return false;
                }
            }
        }
        chess[k] = q;
        return true;
    }
}
