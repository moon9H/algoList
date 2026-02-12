import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA6782 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			// 입력 처리
			long N = Long.parseLong(br.readLine());
			long cnt = 0;
			
			// 주요 로직 시작 : N이 2가 될 때까지 N이 제곱수라면? 루트 or 아니라면? 그 다음 제곱수까지 + 1
			while (N != 2) {
				double sqN = Math.sqrt(N);
				if (isLong(sqN)) {							// 제곱수 인가?
					N = (long) sqN;
					cnt++;
				}
				else {										// 다음 제곱수까지 + 1 및 N 업데이트
					cnt += ((long)sqN + 1) * ((long)sqN + 1) - N;
					N = ((long)sqN + 1) * ((long)sqN + 1);
				}
			}
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.println(sb);
	}
	
	public static boolean isLong(double num) {
		return num == (long) num;
	}
}