import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n, m;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Map<Integer, String> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i < n+1; i++) {
            map1.put(i, br.readLine());
            map2.put(map1.get(i), i);
        }

        String str;

        for (int i = 0; i < m; i++) {
            str = br.readLine();
            if (map2.containsKey(str)) {
                System.out.println(map2.get(str));
            }
            else {
                System.out.println(map1.get(Integer.parseInt(str)));
            }
        }

    }
}
