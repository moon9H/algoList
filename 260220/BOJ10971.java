package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ10971 {
	private static int N, minCost;
	private static boolean[] isSelected;
	private static int[][] W;
	private static ArrayList<Integer> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		isSelected = new boolean[N];
		W = new int[N][N];
		minCost = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				W[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		answer.add(0);
		isSelected[0] = true;
		
		dfs(1, 0);
		
		System.out.println(minCost);
	}
	
	static void dfs(int count, int sum) {
		if (sum >= minCost) return;
		
		if (count == N) {
			int last = answer.get(N - 1);
			int first = answer.get(0); 
			
			if (W[last][first] == 0) return;
			
			minCost = Math.min(sum + W[last][first], minCost);
			return;
		}
		
		int prev = answer.get(count - 1);
		
		for (int i = 1; i < N; i++) {
			if (isSelected[i]) continue;
			
			int cost = W[prev][i];
			if (cost == 0) continue;
			
			isSelected[i] = true;
			answer.add(i);
			
			dfs(count + 1, sum + cost);
			
			answer.remove(answer.size() - 1);
			isSelected[i] = false;
		}
	}
}