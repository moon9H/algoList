import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO2543 {
	static int[][][] polyomino = {  { {0, 1}, {1, 1} }, 			// 타일 모양 선언
									{ {2, 0}, {2, 2} }, 
									{ {3, 3}, {0, 3} }, 
									{ {4, 4}, {4, 0} }};	
	static int[][] map; 
	static int N;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		map = new int[N][N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map[R][C] = -1;											// 구멍에 위치를 -1로 마킹 (이 후 0으로 원상 복귀 필요)
		
		dfs(0, 0, N);
		
		map[R][C] = 0;											// 구멍 원복 (출력 형식 맞춤)
		
		
		for (int[] is : map) {
			for (int i : is) {
				sb.append(i).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int row, int col, int size) {
		if (size == 1) return;
		
		int half = size / 2;
		int holePos = findHole(row, col, size);
		
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int fillTile = polyomino[holePos - 1][i][j];
				
				if (fillTile != 0 && map[row + half - 1 + i][col + half - 1 + j] == 0) {
                    map[row + half - 1 + i][col + half - 1 + j] = fillTile;
                }
			}
		}
		
		dfs(row, col, size / 2);
		dfs(row, col + size / 2, size / 2);
		dfs(row + size / 2, col, size / 2);
		dfs(row + size / 2, col + size / 2, size / 2);
	}
	
	static int findHole(int row, int col, int size) {
		for (int r = row; r < row + size / 2; r++) {
			for (int c = col; c < col + size / 2; c++) {
				if (map[r][c] != 0) return 1;
			}
		}
		
		for (int r = row; r < row + size / 2; r++) {
			for (int c = col + size / 2; c < col + size; c++) {
				if (map[r][c] != 0) return 2;
			}
		}
		
		for (int r = row + size / 2; r < row + size; r++) {
			for (int c = col; c < col + size / 2; c++) {
				if (map[r][c] != 0) return 3;
			}
		}
				
		return 4;
	}
}
