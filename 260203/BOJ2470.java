package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2470 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] liquidList = new int[N];
		for (int i = 0; i < N; i++) {
			liquidList[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(liquidList);
		int s = 0, l = N - 1;
		int A = 0, B = 0;
		long closest = Long.MAX_VALUE;
		while (l > s) {
			int sum = liquidList[l] + liquidList[s];
			long absSum = Math.abs((long)sum);
			if (absSum < closest) {
				closest = absSum;
				A = liquidList[s];
				B = liquidList[l];
			}
			if (sum > 0) {
				l--;
			} else if (sum < 0) {
				s++;
			} else {
				break;
			}
		}
		System.out.println(A + " " + B);
	}
}