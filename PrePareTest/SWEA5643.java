import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA5643 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());

            boolean[][] canReach = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                canReach[a][b] = true;
            }

            for (int k = 1; k <= N; k++) {
                for (int i = 1; i <= N; i++) {
                    if (!canReach[i][k]) continue; // 가지치기
                    for (int j = 1; j <= N; j++) {
                        if (canReach[k][j]) canReach[i][j] = true;
                    }
                }
            }

            int ans = 0;
            for (int i = 1; i <= N; i++) {
                int out = 0;
                int in = 0;
                for (int j = 1; j <= N; j++) {
                    if (i == j) continue;
                    if (canReach[i][j]) ++out;
                    if (canReach[j][i]) ++out;
                }
                if (out + in == N - 1) ++ans;
            }


            sb.append('#').append(tc).append(' ').append(ans).append('\n');
        }

        System.out.println(sb);
    }
}
