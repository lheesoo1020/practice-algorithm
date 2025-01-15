import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        boolean[] status = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            status[i] = st.nextToken().equals("1");
        }

        int m = Integer.parseInt(br.readLine());
        int gender;
        int number;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            gender = Integer.parseInt(st.nextToken());
            number = Integer.parseInt(st.nextToken());

            if (gender == 1) {
                for (int j = 1; j * number <= n; j++) {
                    status[number * j] = !status[number * j];
                }
            } else {
                status[number] = !status[number];
                for (int j = 1; number + j <= n && number - j >= 1; j++) {
                    if (status[number + j] == status[number - j]) {
                        status[number + j] = !status[number + j];
                        status[number - j] = !status[number - j];
                    } else {
                        break;
                    }
                }

            }
        }

        for (int i = 1; i <= n; i++) {
            if (status[i]) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
            if (i % 20 == 0) {
                bw.write("\n");
            }
        }

        bw.flush();
        bw.close();
    }
}
