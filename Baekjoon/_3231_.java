import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3231_ { // 카드놀이

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		int arr[] = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
		}

		int idx = 1, result = 0;
		while (true) {
			for (int i = 0; i < N; i++) {
				if (arr[i] == idx) {
					idx++;
				}
				if (idx == N + 1) {
					break;
				}
			}
			if (idx == N + 1) {
				break;
			}
			result += 1;
		}
		System.out.println(result);
	}
}
