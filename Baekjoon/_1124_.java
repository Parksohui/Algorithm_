import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _1124_ { // 언더프라임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[100001];
		arr[0]=true;
		arr[1]=true;
		for (int i = 2; i < 50001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 100001; j += i) {
					arr[j] = true;
				}
			}
		}

		int result = 0;
		for (int i = a; i <= b; i++) {
			int num = i;
			int cnt = 0;
			int idx = 2;
			while (idx <= num) {
				if (num % idx == 0) {
					num /= idx;
					cnt += 1;
				} else {
					idx++;
				}
			}
			if (!arr[cnt]) {
				result += 1;
			}
		}
		System.out.println(result);
	}
}
