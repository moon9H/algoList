import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2105 {
    private static int N, maxDessert;
    private static final int[] dr = {1, 1, -1, -1};
    private static final int[] dc = {1, -1, -1, 1};
    private static boolean[] used;
    private static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxDessert = -1;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

            }

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {

                    used = new boolean[101];
                    used[map[r][c]] = true;

                    dfs(r, c, r, c, 0, 1, used);
                }
            }

            sb.append('#').append(tc).append(' ').append(maxDessert).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int sr, int sc, int r, int c, int dir, int cnt, boolean[] used) {

        // 직진(dir) 또는 한 번 꺾기(dir+1)만 허용
        for (int nd = dir; nd <= dir + 1 && nd < 4; nd++) {
            int nr = r + dr[nd];
            int nc = c + dc[nd];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

            // 시작점으로 돌아오면 종료(성공)
            if (nr == sr && nc == sc) {
                if (cnt >= 4) maxDessert = Math.max(maxDessert, cnt);
                continue;
            }

            int dessert = map[nr][nc];
            if (used[dessert]) continue; // 디저트 중복 방지

            used[dessert] = true;
            dfs(sr, sc, nr, nc, nd, cnt + 1, used);
            used[dessert] = false;
        }
    }
}