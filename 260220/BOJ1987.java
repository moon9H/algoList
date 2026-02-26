package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1987 {
	private static int R, C, maxPath;
	private static char[][] board;
	private static final int[] dr = {-1, 1, 0, 0};
	private static final int[] dc = {0, 0, -1, 1};
	
	static class Node {
		int row;
		int col;
		String path;
		public Node(int row, int col, String path) {
			super();
			this.row = row;
			this.col = col;
			this.path = path;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = line.charAt(j);
			}
		}
		
		maxPath = Integer.MIN_VALUE;
		
		dfs(new Node(0, 0, String.valueOf(board[0][0])));

		System.out.println(maxPath);
	}
	
	static void dfs(Node curNode) {
		for (int d = 0; d < 4; d++) {
			int nr = curNode.row + dr[d];
			int nc = curNode.col + dc[d];
			maxPath = Math.max(maxPath, curNode.path.length());
			if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
				String nextPath = String.valueOf(board[nr][nc]);
				if (!curNode.path.contains(nextPath)) {
					dfs(new Node(nr, nc, curNode.path.concat(nextPath)));
				}
			}
		}
	}
	
}