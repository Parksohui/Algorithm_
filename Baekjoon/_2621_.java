import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _2621_ { // 카드게임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		char card[] = new char[5];
		int num[] = new int[5];

		int result = -1;

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			card[i] = st.nextToken().charAt(0);
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);

		// 1. 
		boolean flag = false;

		for (int i = 0; i < 4; i++) {
			if (card[i] != card[i + 1]) {
				flag = true;
				break;
			}
		}
		if (!flag) {
			for (int i = 0; i < 4; i++) {
				if (num[i] + 1 != num[i + 1]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				result = num[4] + 900;
			}
		}

		// 2. 
		int cnt = 1, idx = -1, max = -1, max_idx = -1;
		if (result == -1) {
			for (int i = 0; i < 4; i++) {
				if (num[i] == num[i + 1]) {
					cnt += 1;
					idx = i + 1;
				} else {
					cnt = 1;
				}
				if (max < cnt) {
					max = cnt;
					max_idx = idx;
				}
			}
			if (max == 4) {
				result = num[max_idx] + 800;
			}
		}

		// 3. 
		if (result == -1) {
			if (max == 3) {
				if (max_idx == 2) {
					if (num[3] == num[4]) {
						result = num[2] * 10 + num[3] + 700;
					}
				} else {
					if (num[0] == num[1]) {
						result = num[2] * 10 + num[0] + 700;
					}
				}
			}
		}

		// 4.
		if (result == -1) {
			if (card[0] == card[1] && card[1] == card[2] && card[2] == card[3] && card[3] == card[4]) {
				result = num[4] + 600;
			}
		}

		// 5.
		if (result == -1) {
			if (num[0] + 1 == num[1] && num[1] + 1 == num[2] && num[2] + 1 == num[3] && num[3] + 1 == num[4]) {
				result = num[4] + 500;
			}
		}

		// 6. 
		if (result == -1) {
			if (max == 3) {
				result = num[max_idx] + 400;
			}
		}

		// 7. 
		if (result == -1) {
			if (max == 2) {
				for (int i = 0; i < 4; i++) {
					if (i == max_idx - 1)
						continue;
					if (num[i] == num[i + 1]) {
						if (num[max_idx] > num[i]) {
							result = num[max_idx] * 10 + num[i] + 300;
						} else {
							result = num[i] * 10 + num[max_idx] + 300;
						}
					}
				}
			}
		}

		// 8.
		if (result == -1) {
			if (max == 2) {
				result = num[max_idx] + 200;
			}
		}

		// 9.
		if (result == -1)
			result = num[4] + 100;

		System.out.println(result);
	}

}
