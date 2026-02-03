package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1940 {
	public static void main(String[] args) throws IOException{
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] numList = new int[N];
		for (int i = 0; i < N; i++) {
			numList[i] = Integer.parseInt(st.nextToken());
		}
		// 투포인터 작업을 위한 정렬
		Arrays.sort(numList);
		int s = 0, l = N - 1;
		int pairCnt = 0;
		int sum = 0;
		while (l > s) {
			sum = numList[s] + numList[l];
			if (sum > M) {
				l--;
			} else if (sum < M) {
				s++;
			} else {						// 카운트하고 다른 케이스 찾으러 두 포인터 모두 이동
				s++;
				l--;
				pairCnt++;
			}
		}
		System.out.println(pairCnt);
	}
}