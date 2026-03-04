package PrePareTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17070 {
	private static final int[] dr = {0, 1, 1};
	private static final int[] dc = {1, 1, 0};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ans = 0;
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] {0, 1, 0});
		
		while(!queue.isEmpty()) {
			int[] curPos = queue.poll();
			
			if (curPos[0] == N - 1 && curPos[1] == N - 1) ++ans;
			
			if (curPos[2] == 0) {
				int horizNr = curPos[0] + dr[0];
				int horizNc = curPos[1] + dc[0];
				
				if (horizNr >= 0 && horizNr < N && horizNc >= 0 && horizNc < N &&
					map[horizNr][horizNc] != 1) queue.add(new int[] {horizNr, horizNc, 0});
				
				int crossNr = curPos[0] + dr[1];
				int crossNc = curPos[1] + dc[1];
				
				if (crossNr >= 0 && crossNr < N && crossNc >= 0 && crossNc < N && map[crossNr][crossNc] != 1 &&
					map[crossNr - 1][crossNc] != 1 && map[crossNr][crossNc - 1]!= 1)
					queue.add(new int[] {crossNr, crossNc, 1});
			}
			
			if (curPos[2] == 1) {
				int horizNr = curPos[0] + dr[0];
				int horizNc = curPos[1] + dc[0];
				
				if (horizNr >= 0 && horizNr < N && horizNc >= 0 && horizNc < N &&
					map[horizNr][horizNc] != 1) queue.add(new int[] {horizNr, horizNc, 0});
				
				int crossNr = curPos[0] + dr[1];
				int crossNc = curPos[1] + dc[1];
				
				if (crossNr >= 0 && crossNr < N && crossNc >= 0 && crossNc < N && map[crossNr][crossNc] != 1 &&
					map[crossNr - 1][crossNc] != 1 && map[crossNr][crossNc - 1]!= 1)
					queue.add(new int[] {crossNr, crossNc, 1});
				
				int vertNr = curPos[0] + dr[2];
				int vertNc = curPos[1] + dc[2];
				
				if (vertNr >= 0 && vertNr < N && vertNc >= 0 && vertNc < N && 
					map[vertNr][vertNc] != 1) queue.add(new int[] {vertNr, vertNc, 2});
			}
			
			if (curPos[2] == 2) {
				int crossNr = curPos[0] + dr[1];
				int crossNc = curPos[1] + dc[1];
				
				if (crossNr >= 0 && crossNr < N && crossNc >= 0 && crossNc < N && map[crossNr][crossNc] != 1 &&
					map[crossNr - 1][crossNc] != 1 && map[crossNr][crossNc - 1]!= 1)
					queue.add(new int[] {crossNr, crossNc, 1});
				
				int vertNr = curPos[0] + dr[2];
				int vertNc = curPos[1] + dc[2];
				
				if (vertNr >= 0 && vertNr < N && vertNc >= 0 && vertNc < N && 
					map[vertNr][vertNc] != 1) queue.add(new int[] {vertNr, vertNc, 2});
			}
		}
		
		System.out.println(ans);
	}
}