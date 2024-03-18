import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _12931_ { // 두 배 더하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int answer = 0;
		int zero = 0;
		boolean flag = false;

		while (zero != n) {
			zero = 0;
			flag = false;

			for (int i = 0; i < n; i++) {
				if (arr[i] == 0) {
					zero += 1;
				}
			}
			if (zero == n) {
				break;
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] % 2 == 1) {
					arr[i] -= 1;
					answer += 1;
				}
			}
			for (int i = 0; i < n; i++) {
				if (arr[i] != 0 && arr[i] % 2 == 0) {
					if (!flag) {
						flag = true;
						answer += 1;
					}
					arr[i] /= 2;
				}
			}
		}
		System.out.println(answer);
	}
}
