package ATS.Day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1169 {
	private static int M = 6;
	private static int N;
	private static int[] result;
	private static boolean[] isSelected;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int type = Integer.parseInt(st.nextToken());
		result = new int[N];
		isSelected = new boolean[M + 1];
		switch (type) {
		case 1:
			permutation1(0);
			break;

		case 2 :
			permutation2(0, 1);
			break;
			
		case 3 :
			permutation3(0);
			break;
		}
	}
	
	public static void permutation1(int cnt) {
		if (cnt == N) {
			for (int i : result) System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= M; i++) {
			result[cnt] = i;
			permutation1(cnt + 1);
		}
	}
	
	public static void permutation2(int cnt, int start) {
		if (cnt == N) {
			for (int i : result) System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		for (int i = start; i <= M; i++) {
			result[cnt] = i;
			permutation2(cnt + 1, i);
		}
	}
	
	public static void permutation3(int cnt) {
		if (cnt == N) {
			for (int i : result) System.out.print(i + " ");
			System.out.println();
			return;
		}
		
		for (int i = 1; i <= M; i++) {
			if (isSelected[i]) continue;
			
			isSelected[i] = true;
			result[cnt] = i;
			permutation3(cnt + 1);
			isSelected[i] = false;
		}
	}
}
