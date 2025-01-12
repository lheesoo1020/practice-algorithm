import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(
        ) {
            public int compare(Integer a, Integer b) {
                if (Math.abs(a) < Math.abs(b)) {
                    return -1;
                } else if (Math.abs(a) > Math.abs(b)) {
                    return 1;
                } else if (Math.abs(a) == Math.abs(b)) {
                    return a - b;
                }
                return 0;
            }
        });

        int n = Integer.parseInt(br.readLine());
        int x;

        for (int i = 0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if (pq.isEmpty()) {
                    System.out.println(0);
                    continue;
                }
                System.out.println(pq.poll());
            } else {
                pq.add(x);
            }
        }


    }
}
