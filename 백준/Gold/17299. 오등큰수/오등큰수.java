import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] F = new int[10000001];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
            F[numbers[i]] += 1;
        }

        stack.push(0);

        for(int i = 1; i < n; i++) {
            while(!stack.isEmpty() && F[numbers[stack.peek()]] < F[numbers[i]]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        for(int num : result) {
            bw.write(String.valueOf(num));
            bw.write(" ");
        }
        bw.close();

    }
}
