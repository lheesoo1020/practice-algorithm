import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cash = Integer.parseInt(br.readLine());
        int a_cash = cash;
        int a_stock = 0;

        int b_cash = cash;
        int b_stock = 0;
        int cnt = 0;


        int[] stockPrice = new int[14];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 14; i++) {
            stockPrice[i] = Integer.parseInt(st.nextToken());
        }

        if (stockPrice[0] < a_cash) {
            int buy = a_cash / stockPrice[0];
            a_stock += buy;
            a_cash -= buy * stockPrice[0];
        }

        for (int i = 1; i < 14; i++) {
            if (stockPrice[i] <= a_cash) {
                int buy = a_cash / stockPrice[i];
                a_stock += buy;
                a_cash -= buy * stockPrice[i];
            }

            if (stockPrice[i] > stockPrice[i - 1]) {
                if (cnt < 0) cnt = 1;
                else cnt++;
            } else if (stockPrice[i] < stockPrice[i - 1]) {
                if (cnt > 0) cnt = -1;
                else cnt--;
            } else {
                cnt = 0;
            }

            if (cnt > 2) {
                b_cash += b_stock * stockPrice[i];
                b_stock = 0;

            } else if (cnt < -2) {
                if (stockPrice[i] <= b_cash) {
                    int buy = b_cash / stockPrice[i];
                    b_stock += buy;
                    b_cash -= buy * stockPrice[i];
                }
            }
        }

        if ((stockPrice[13] * a_stock + a_cash) == (stockPrice[13] * b_stock + b_cash)) {
            System.out.println("SAMESAME");
        } else if ((stockPrice[13] * a_stock + a_cash) > (stockPrice[13] * b_stock + b_cash)) {
            System.out.println("BNP");
        } else {
            System.out.println("TIMING");
        }

    }
}
