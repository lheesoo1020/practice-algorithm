import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int cnt = 0;

        List<Integer[]> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time.add(new Integer[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        time.sort((arr1, arr2) -> {
            if (arr1[1] == arr2[1]) return arr1[0] - arr2[0];
            return arr1[1] - arr2[1];
        });

        int endTime = -1;

        for (int i = 0; i < n; i++) {
            if (time.get(i)[0] > endTime) {
                endTime = time.get(i)[1] - 1;
                cnt++;
            }
        }

        System.out.println(cnt);



    }
}
