package day13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	private static int L;
	private static char[] chars;
	private static ArrayList<Character> answer = new ArrayList<>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		chars = new char[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(chars);
		
		dfs(0, 0);
	}
	
	static void dfs(int count, int start) {
		if (count == L) {
			int vowel = 0;
			for (Character c : answer) if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u') vowel++;
			
			if (vowel > 0 && L - vowel > 1) {
				for (Character c : answer) {
					System.out.print(c);
				}				
				System.out.println();
			}
			return;
		}
		
		for (int i = start; i < chars.length; i++) {
			answer.add(chars[i]);
			dfs(count + 1, i + 1);
			answer.remove(answer.size() - 1);
		}
	}
}