import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> list = new LinkedList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (st.nextToken().equals("0")) mark[i] = true;
            else mark[i] = false;
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (mark[i]) list.addFirst(Integer.parseInt(st.nextToken()));
            else st.nextToken();
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            list.addLast(Integer.parseInt(st.nextToken()));
            bw.write(list.removeFirst() + " ");
        }

        bw.flush();
        bw.close();

    }

}
