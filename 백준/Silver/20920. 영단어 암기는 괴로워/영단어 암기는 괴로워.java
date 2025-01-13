import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);

        Map<String, Integer> map = new HashMap<>();

        String str;

        for (int i = 0; i < n; i++) {
            str = br.readLine();
            if (str.length() < m) continue;
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
                continue;
            }
            map.put(str, 1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            public int compare(Pair pair1, Pair pair2) {
                if (pair1.getInteger() != pair2.getInteger()) {
                    return pair2.getInteger() - pair1.getInteger();
                } else {
                    if (pair1.getString().length() != pair2.getString().length()) {
                        return pair2.getString().length() - pair1.getString().length();
                    } else {
                        return pair1.getString().compareTo(pair2.getString());
                    }
                }
            }
        });

        Set<String> keys = map.keySet();
        for (String key : keys) {
            pq.add(new Pair(key, map.get(key)));
        }

        int size = pq.size();
        for (int i = 0; i < size; i++) {
            bw.write(pq.poll().getString());
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    public static class Pair {
        String string;
        Integer integer;

        public Pair(String string, Integer integer) {
            this.string = string;
            this.integer = integer;
        }

        public String getString() {
            return string;
        }
        public Integer getInteger() {
            return integer;
        }
    }
}
