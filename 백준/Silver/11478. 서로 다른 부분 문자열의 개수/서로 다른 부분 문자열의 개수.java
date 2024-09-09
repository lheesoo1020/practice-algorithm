import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Map<String, Integer> map = new HashMap<>();

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                String subStr = str.substring(j, j + i);
                if (!map.containsKey(subStr)) {
                    map.put(subStr, 1);
                }
            }
        }

        System.out.println(map.size());
    }
}
