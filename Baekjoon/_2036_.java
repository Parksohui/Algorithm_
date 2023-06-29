import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class _2036_ { // 수열의 점수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		long arr[] = new long[n];
		int neg = 0, zero = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Long.parseLong(bf.readLine());
			if (arr[i] < 0)
				neg += 1;
			else if (arr[i] == 0)
				zero += 1;
		}

		Arrays.sort(arr);

		long result = 0;
		int idx = 0, pos = n - neg - zero;
		while (idx < n) {
			if (neg > 0) {
				if (neg == 1) {
					if (zero > 0) {
						zero -= 1;
						neg -= 1;
						idx += 2;
					} else {
						result += arr[idx];
						neg -= 1;
						idx += 1;
					}
				} else {
					result += arr[idx] * arr[idx + 1];
					idx += 2;
					neg -= 2;
				}
			} else if (zero > 0) {
				idx += zero;
				zero = 0;
			} else if (pos > 0) {
				if (arr[idx] == 1) {
					result += arr[idx];
					idx += 1;
					pos -= 1;
				} else if (pos % 2 == 0) {
					result += arr[idx] * arr[idx + 1];
					idx += 2;
					pos -= 2;
				} else {
					result += arr[idx];
					pos -= 1;
					idx += 1;
				}
			}
		}
		System.out.println(result);
	}
}
