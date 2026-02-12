import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1654 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int maxLan = 0;
		int lan[] = new int[K];
		for (int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			maxLan = Math.max(maxLan, lan[i]);
		}
		
		long left = 1;
		long right = maxLan;
		long result = -1;
		while (left <= right) {
			long mid = (left + right) / 2;
			
			long count = 0;
			// mid의 길이로 모든 랜 등분 시킴.
			for (int i = 0; i < K; i++) {
				count += (lan[i] / mid);
			}
			
			// 그 갯수가 N개에 최대한 가깝게 만듬
			if (count >= N) {
				result = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		System.out.println(result);
	}
}