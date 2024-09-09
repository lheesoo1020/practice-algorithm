import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        Set<String> set = new HashSet<>();

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j <= str.length() - i; j++) {
                String subStr = str.substring(j, j + i);
                set.add(subStr);
            }
        }

        System.out.println(set.size());
    }
}
