package PrePareTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ17471 {
	private static int N, minDiff;
	private static int[] population;
	private static ArrayList<Integer>[] graph;
	private static boolean[] selected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		population = new int[N + 1];
		selected = new boolean[N + 1];
		graph = new ArrayList[N + 1];
		minDiff = Integer.MAX_VALUE;
		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 1; i <= N; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			for (int j = 0; j < M; j++) {
				graph[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		dfs(0, 1);
		
		if (minDiff == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(minDiff);			
		}
	}
	
	static void dfs(int count, int start) {
		if (count > 0) {
			ArrayList<Integer> groupA = new ArrayList<>();
			ArrayList<Integer> groupB = new ArrayList<>();
			for (int i = 1; i <= N; i++) {
				if (selected[i]) groupA.add(i);
				else groupB.add(i);
			}
			
			boolean isAConnected = isConnected(groupA);
			boolean isBConnected = isConnected(groupB);
			
			if (isAConnected && isBConnected) {
				int aSum = 0, bSum = 0;
				for (Integer integer : groupA) {
					aSum += population[integer];
				}
				
				for (Integer integer : groupB) {
					bSum += population[integer];
				}
				
				minDiff = Math.min(minDiff, Math.abs(aSum - bSum));
			}
		}
		
		if (count == N / 2) return;
		
		for (int i = start; i <= N; i++) {
			selected[i] = true;
			dfs(count + 1, i + 1);
			selected[i] = false;
		}
	}
	
	static boolean isConnected(ArrayList<Integer> subgraph) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(subgraph.get(0));
		visited[subgraph.get(0)] = true;
		
		while(!queue.isEmpty()) {
			int curNode = queue.poll();
			
			for (Integer integer : graph[curNode]) {
				if (subgraph.contains(integer) && !visited[integer]) {
					queue.add(integer);
					visited[integer] = true;
				}
			}
		}
		
		for (Integer integer : subgraph) {
			if (!visited[integer]) return false;
		}
		
		return true;
	}
}