package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ15900 {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// index를 1부터 사용할거여서 N + 1로 생성
		ArrayList<Integer>[] adj = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) adj[i] = new ArrayList<Integer>();
		
		// 인접 행렬로 생성
		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			adj[A].add(B);
			adj[B].add(A);
		}
		
		int totalDepth = 0;
		int[] depth = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new ArrayDeque<>();
		
		// 루트 노드 마킹
		queue.add(1);
		visited[1] = true;
		depth[1] = 0;
		
		// 루트 노드부터 BFS 수행하며 깊이 저장
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if (cur != 1 && adj[cur].size() == 1) {
				totalDepth += depth[cur];
				continue;
			}
			for (int child : adj[cur]) {
				if(!visited[child]) {
					visited[child] = true;
					depth[child] = depth[cur] + 1;
					queue.add(child);
				}
			}
		}
		System.out.println(totalDepth % 2 == 1 ? "Yes" : "No");
	}
}