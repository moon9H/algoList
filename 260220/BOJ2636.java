package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2636 {
	private static int R, C;
	private static int[] dr = {-1, 1, 0, 0};
	private static int[] dc = {0, 0, -1, 1};
	private static int[][] board;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		board = new int[R][C];
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ArrayList<int[]> borderList = new ArrayList<>();
		int time = 0;
		ArrayList<Integer> cheeseList = new ArrayList<>();
		while(isThereCheese()) {
			queue.add(new int[] {0, 0});
			visited[0][0] = true;
			while(!queue.isEmpty()) {
				int[] curPos = queue.poll();
				
				for (int i = 0; i < 4; i++) {
					int nr = curPos[0] + dr[i];
					int nc = curPos[1] + dc[i];
					if (nr >= 0 && nr < R && nc >= 0 && nc < C &&
						!visited[nr][nc]) {
						visited[nr][nc] = true;
						if (board[nr][nc] == 0) {
							queue.add(new int[] {nr, nc});
						} else {
							borderList.add(new int[] {nr, nc});
						}
					}
				}
			}
			int remainCheese = 0;
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 1) ++remainCheese;
				}
			}
			
			for (int[] is : borderList) {
				board[is[0]][is[1]] = 0;
			}
			++time;
			cheeseList.add(remainCheese);
			borderList.clear();
			visited = new boolean[R][C];
		}
		
		System.out.println(time);
		System.out.println(cheeseList.get(cheeseList.size() - 1));
	}
	
	static boolean isThereCheese() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) return true;
			}
		}
		return false;
	}
}
