package PrePareTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ2252SecondSolve {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N + 1];
		int[] inDegree = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			graph[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			graph[A].add(B);
			++inDegree[B];
		}
		
		Queue<Integer> queue = new ArrayDeque<Integer>();
		for (int i = 1; i <= N; i++) {
			if (inDegree[i] == 0) queue.add(i);
		}
		ArrayList<Integer> answer = new ArrayList<>();
		while(!queue.isEmpty()) {
			int curNode = queue.poll();
			answer.add(curNode);
			for (Integer node : graph[curNode]) {
				if (--inDegree[node] == 0) queue.add(node);
			}
		}
		
		for (Integer integer : answer) {
			System.out.print(integer + " ");
		}
	}
}
