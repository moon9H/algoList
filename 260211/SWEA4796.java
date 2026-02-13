import java.util.Scanner;

public class SWEA4796 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();					// 산의 개
			int[] h = new int[N];					// 산 i의 높이를 저장하는 배열
			
			for (int i = 0; i < N; i++) {
				h[i] = sc.nextInt();
			}
			
			int tallMountain = 0;
			boolean isIncreased = true;				// 증가 중인지 체크
			int upCnt = 0;							// 몇 번 증가했는지
			int downCnt = 0;						// 몇 번 감소했는지
			for (int i = 0; i < N - 1; i++) {		
				if (isIncreased) {
					if (h[i] < h[i + 1]) {			// 실제 높이가 증가하고 있다면 +
						upCnt++;
					} else {					
						if (upCnt != 0) {			// 증가한 것도 아니었고, upCnt가 있는 경우 (없다면 처음부터 내려가는 형태였던 것)
							isIncreased = false;
						}
					}
				}
				
				if (!isIncreased){					// 감소 시작
					if (h[i] > h[i + 1]) {			// 실제 감소하고 있다면 카운트 증가
						downCnt++;
						if (i == N - 2) {			// 감소하면서 탐색이 끝나는 경우 현재 카운트를 계산
							tallMountain += upCnt * downCnt;
						}
					} else {						// 감소가 끝난 경우 현재 봉우리에서 나올 수 있는 조합 계산
						tallMountain += upCnt * downCnt;
						upCnt = 1;					// 증가를 이미 시작한 것이니 1로 설정
						downCnt = 0;
						isIncreased = true;
					}
				}
			}
			
			sb.append("#" + tc + " ").append(tallMountain).append("\n");
		}
		System.out.println(sb);
	}
}