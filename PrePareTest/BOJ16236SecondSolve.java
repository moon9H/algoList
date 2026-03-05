import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16236SecondSolve {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int sharkSize = 2, sharkNeedToEat = 2;
        int sr = -1, sc = -1;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9){
                    sr = i;
                    sc = j;
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            PriorityQueue<int[]> pq = new PriorityQueue<>( (o1, o2) -> {
                if (o1[2] != o2[2]) return Integer.compare(o1[2], o2[2]);
                if (o1[0] != o2[0]) return Integer.compare(o1[0], o2[0]);
                return Integer.compare(o1[1], o2[1]);
            });

            boolean[][] visited = new boolean[N][N];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[] {sr, sc, 0});
            visited[sr][sc] = true;

            while (!queue.isEmpty()){
                int[] curPos = queue.poll();

                for (int d = 0; d < 4; d++) {
                    int nr = curPos[0] + dr[d];
                    int nc = curPos[1] + dc[d];

                    if (nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]
                        || map[nr][nc] > sharkSize) continue;

                    queue.add(new int[]{nr, nc, curPos[2] + 1});
                    visited[nr][nc] = true;

                    if (map[nr][nc] != 0 && map[nr][nc] < sharkSize) {
                        pq.add(new int[] {nr, nc, curPos[2] + 1});
                    }
                }
            }

            if (pq.isEmpty()) break;
            sr = pq.peek()[0];
            sc = pq.peek()[1];
            time += pq.peek()[2];
            map[sr][sc] = 0;
            if (--sharkNeedToEat == 0) {
                sharkSize++;
                sharkNeedToEat = sharkSize;
            }
        }

        System.out.println(time);
    }
}