package ATS.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1175 {
	private static int M = 6;
	private static int N;
	private static int goal;
	private static int[] result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		goal = Integer.parseInt(st.nextToken());
		result = new int[N];
		
		permutation1(0, 0);
	}
	
	public static void permutation1(int cnt, int sum) {
		if (cnt == N) {
			if (sum == goal) {
				for (int i : result) System.out.print(i + " ");
				System.out.println();
			}
			return;
		}
		
		for (int i = 1; i <= M; i++) {
			result[cnt] = i;
			permutation1(cnt + 1, sum + i);
		}
	}

}