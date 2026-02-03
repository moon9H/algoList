package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ29700_2 {
	public static void main(String[] args) throws IOException{
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[][] seats = new int[N][M];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < M; j++) {
				seats[i][j] = line.charAt(j) - '0';
			}
		}
		
		// 메인 로직 시작 (Two-Pointer 버전)
		int result = 0;
		for (int i = 0; i < N; i++) {
			if (K > M) break;
			int s = 0;
			for (int l = 0; l < M; l++) {
				if (seats[i][l] == 1) {
					s = l + 1;
					continue;
				}
				
				if (l - s + 1 >= K) {
					result++;
				}
			}
		}
		System.out.println(result);
	}
}