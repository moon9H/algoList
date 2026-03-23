import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ4485SecondSolve {
    private static final int[] dr = {-1, 1, 0, 0};
    private static final int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int problem = 1;
        while (true){
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            int[][] map = new int[N][N];
            int[][] dist = new int[N][N];
            for (int[] ints : dist) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
                return Integer.compare(o1[2], o2[2]);
            });

//            Queue<int[]> pq = new ArrayDeque<>();

            dist[0][0] = map[0][0];
            pq.add(new int[] {0, 0, dist[0][0]});
            while (!pq.isEmpty()) {
                int[] curPos = pq.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curPos[0] + dr[d];
                    int nc = curPos[1] + dc[d];
                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;
                    int newDist = curPos[2] + map[nr][nc];
                    if (dist[nr][nc] > newDist){
                        dist[nr][nc] = newDist;
                        pq.add(new int[] {nr, nc, newDist});
                    }
                }
            }

            sb.append("Problem ").append(problem).append(": ").append(dist[N - 1][N - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
