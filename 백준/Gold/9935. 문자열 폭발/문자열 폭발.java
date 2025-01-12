import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        String ex = br.readLine();

        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        boolean flag = false;

        for (int i = 0; i < str.length(); i++) {
            //일단 넣고 확인
            stack1.push(str.charAt(i));
            //방금 넣은게 폭탄 마지막 글자랑 같으면 flag 설정하고 역순으로 검사
            if (stack1.peek() == ex.charAt(ex.length() - 1)) {
                flag = true;
                //검사
                for (int j = 0; j < ex.length(); j++) {
                    //폭탄이 아니면 flag 해제
                    if (stack1.isEmpty() || stack1.peek() != ex.charAt(ex.length() - j - 1)) {
                        flag = false;
                        break;
                    }
                    //폭탄은 stack2에 빼놓기
                    stack2.push(stack1.pop());
                }
                //폭탄이 아니었다면 stack2에서 stack1으로 전부 되돌리기
                if (!flag) {
                    int size = stack2.size();
                    for (int k = 0; k < size; k++) {
                        stack1.push(stack2.pop());
                    }
                }
            }
            stack2.clear();
        }

        if (stack1.isEmpty()) {
            bw.write("FRULA");
        } else {
            int size = stack1.size();
            for (int i = 0; i < size; i++) {
                stack2.push(stack1.pop());
            }
            for (int i = 0; i < size; i++) {
                bw.write(stack2.pop());
            }
        }
        bw.write("\n");
        bw.flush();
        bw.close();

    }
}
