import java.io.*;
import java.util.*;

public class BOJ17471 {
    static int N;
    static int[] pop;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());

        pop = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) pop[i] = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N];
        for (int i = 0; i < N; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cnt; j++) {
                int v = Integer.parseInt(st.nextToken()) - 1;
                adj[i].add(v);
            }
        }

        int answer = Integer.MAX_VALUE;

        // mask: A 구역(1), B 구역(0)
        // 공집합(0) / 전체집합((1<<N)-1) 제외
        for (int mask = 1; mask < (1 << N) - 1; mask++) {
            // A, B 각각 연결인지 체크
            if (!isConnected(mask, true)) continue;
            if (!isConnected(mask, false)) continue;

            int sumA = 0, sumB = 0;
            for (int i = 0; i < N; i++) {
                if ((mask & (1 << i)) != 0) sumA += pop[i];
                else sumB += pop[i];
            }
            answer = Math.min(answer, Math.abs(sumA - sumB));
        }

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }

    static boolean isConnected(int mask, boolean inA) {
        // 그룹에 속한 아무 노드나 start로 찾기
        int start = -1;
        int groupCount = 0;

        for (int i = 0; i < N; i++) {
            boolean isInGroup = inA ? ((mask & (1 << i)) != 0) : ((mask & (1 << i)) == 0);
            if (isInGroup) {
                groupCount++;
                if (start == -1) start = i;
            }
        }

        // 그룹이 비어있으면
        if (groupCount == 0) return false;

        boolean[] vis = new boolean[N];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        vis[start] = true;
        q.add(start);

        int visitedCount = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int nxt : adj[cur]) {
                if (vis[nxt]) continue;

                boolean nxtInGroup = inA ? ((mask & (1 << nxt)) != 0) : ((mask & (1 << nxt)) == 0);
                if (!nxtInGroup) continue;

                vis[nxt] = true;
                visitedCount++;
                q.add(nxt);
            }
        }

        return visitedCount == groupCount;
    }
}