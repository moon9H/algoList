import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1828 {

	public static void main(String[] args) throws IOException{
		
		// 입력 처리
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] materials = new int[N][2];							// 물질 저장 배열, [0] : 최저보관온도 / [1] : 최고보관온도
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			materials[i][0] = Integer.parseInt(st.nextToken());
			materials[i][1] = Integer.parseInt(st.nextToken());
		}
		
		// 주요 로직 시작
		Arrays.sort(materials, (o1, o2) -> {
		    if(o1[1] == o2[1]) return Integer.compare(o1[0], o2[0]);
		    return Integer.compare(o1[1], o2[1]);
		});
		
		for (int[] is : materials) {
			System.out.println(Arrays.toString(is));
		}
		int count = 1;
		int currnetMax = materials[0][1];
		
		for (int i = 1; i < N; i++) {
			if (materials[i][0] > currnetMax) {
				++count;
				currnetMax = materials[i][1];
			}
		}
		System.out.println(count);
	}
}
