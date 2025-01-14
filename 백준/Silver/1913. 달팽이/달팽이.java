import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] snail = new int[n][n];

        int row = n / 2;
        int column = n / 2;
        snail[row][column] = 1;
        int num = 2;

        int resultRow = row;
        int resultColumn = column;


        while(true) {
            for (int j = 1; j < n + 1; j++) {
                if (num == n * n + 1) break;
                if (j % 2 == 1) {
                    for (int k = 1; k < j + 1; k++) {
                        if (num == n * n + 1) break;
                        row -= 1;
                        snail[row][column] = num;
                        if (num == m) {
                            resultRow = row;
                            resultColumn = column;
                        }
                        num++;
                    }
                    for (int k = 1; k < j + 1; k++) {
                        if (num == n * n + 1) break;
                        column += 1;
                        snail[row][column] = num;
                        if (num == m) {
                            resultRow = row;
                            resultColumn = column;
                        }
                        num++;
                    }
                } else {
                    if (num == n * n + 1) break;
                    for (int k = 1; k < j + 1; k++) {
                        if (num == n * n + 1) break;
                        row += 1;
                        snail[row][column] = num;
                        if (num == m) {
                            resultRow = row;
                            resultColumn = column;
                        }
                        num++;
                    }
                    for (int k = 1; k < j + 1; k++) {
                        if (num == n * n + 1) break;
                        column -= 1;
                        snail[row][column] = num;
                        if (num == m) {
                            resultRow = row;
                            resultColumn = column;
                        }
                        num++;
                    }
                }
            }
            if (num == n * n + 1) break;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                bw.write(snail[i][j] + " ");
            }
            bw.write("\n");
        }

        resultRow += 1;
        resultColumn += 1;

        bw.write(resultRow + " " + resultColumn);

        bw.flush();
        bw.close();
    }
}
