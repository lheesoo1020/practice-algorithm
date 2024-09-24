import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<Integer> time = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            time.add(sc.nextInt());
        }

        time.sort(Integer::compareTo);

        int result = 0;

        for (int i = 0; i < n; i++) {
            result += time.get(i)*(n-i);
        }

        System.out.println(result);
    }
}
