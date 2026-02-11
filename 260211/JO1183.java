import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1183 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int W = Integer.parseInt(br.readLine());
		int[] c = {500, 100, 50, 10, 5, 1};
		int[] coins = new int[6];					// 500, 100, 50, 10, 5 1 순서대로 인덱스
		int[] result = new int[6];
		int pocketMoney = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
			coins[i] = Integer.parseInt(st.nextToken());
			pocketMoney += c[i] * coins[i];
			
		}
		
		pocketMoney -= W;
		int idx = 0;
		while(pocketMoney > 0) {
			int cnt = coins[idx];
			int money = c[idx];			
			while (pocketMoney < cnt * money) cnt--;
			pocketMoney -= cnt * money;
			result[idx] = cnt;
			++idx;
		}
		int sum = 0;
		for (int i = 0; i < 6; i++) {
			sum += (coins[i] - result[i]);
		}
		System.out.println(sum);
		for (int i = 0; i < 6; i++) {
			System.out.print(coins[i] - result[i] + " ");
		}
	}
}
