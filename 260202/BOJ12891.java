package com.ssafy.ATS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
	private static boolean isPossible(int[] standard, int[] toCompare) {
		for (int j = 0; j < 4; j++) {
			if (toCompare[j] < standard[j]) {
				return false;
			}
		}
		return true;
	}
	
	private static void removeChar(int[] arr, char c) {
		switch(c) {
	        case 'A': arr[0]--; break;
	        case 'C': arr[1]--; break;
	        case 'G': arr[2]--; break;
	        case 'T': arr[3]--; break;
		}
	}
	private static void addChar(int[] arr, char c) {
		switch(c) {
		case 'A': arr[0]++; break;
		case 'C': arr[1]++; break;
		case 'G': arr[2]++; break;
		case 'T': arr[3]++; break;
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String tempPassword = br.readLine();
		st = new StringTokenizer(br.readLine());
		int[] ACGT = new int[4];
		for (int i = 0; i < 4; i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		int result = 0;
		int [] containDNA = new int[4];
		for (int j = 0; j < P; j++) {
			addChar(containDNA, tempPassword.charAt(j));
		}
		if (isPossible(ACGT, containDNA)) result++;
		for (int i = 1; i < S - P + 1; i++) {
			removeChar(containDNA, tempPassword.charAt(i - 1));
			addChar(containDNA, tempPassword.charAt(i + P - 1));
			if (isPossible(ACGT, containDNA)) result++;
		}
			
		System.out.println(result);
	}
}