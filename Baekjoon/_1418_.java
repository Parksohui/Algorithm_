import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1418_ { // K-세준수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());
		int k = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[100001];
		for (int i = 2; i <= 50001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 100001; j += i) {
					arr[j] = true;
				}
			}
		}

		int cnt = 1;
		for (int i = 2; i <= n; i++) {
			if (arr[i]) {
				int temp = 2;
				int num = i;
				int max = -1;
				while (true) {
					if (num % temp == 0) {
						num /= temp;
						max = Math.max(max, temp);
					} else {
						temp++;
					}
					if (temp > num || !arr[num]) {
						max = Math.max(max, num);
						break;
					}
				}
				if (max <= k) {
					cnt += 1;
				}
			} else {
				if (i <= k) {
					cnt += 1;
				}
			}
		}
		System.out.println(cnt);
	}
}
