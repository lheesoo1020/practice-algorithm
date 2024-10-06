import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int command;
        int num;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            switch (command) {
                case 1:
                    num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;
                case 2:
                    if (stack.isEmpty()) {
                        bw.write(-1+"\n");
                    }
                    else {
                        bw.write(stack.pop()+"\n");
                    }
                    bw.flush();
                    break;
                case 3:
                    bw.write(stack.size()+"\n");
                    bw.flush();
                    break;
                case 4:
                    if (stack.isEmpty()) {
                        bw.write(1+"\n");
                    }
                    else {
                        bw.write(0+"\n");
                    }
                    bw.flush();
                    break;
                case 5:
                    if (stack.isEmpty()) {
                        bw.write(-1+"\n");
                    }
                    else {
                        bw.write(stack.peek()+"\n");
                    }
                    bw.flush();
                    break;
            }
        }
    }
}
