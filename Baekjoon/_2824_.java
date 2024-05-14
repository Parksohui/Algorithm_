import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2824_ { // 최대공약수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int narr[] = new int[n];
		for (int i = 0; i < n; i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}

		int m = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int marr[] = new int[m];
		for (int i = 0; i < m; i++) {
			marr[i] = Integer.parseInt(st.nextToken());
		}

		long result = 1;
		boolean flag = false;
		for (int i = 0; i < n; i++) {
			if (narr[i] == 1) {
				continue;
			}
			for (int j = 0; j < m; j++) {
				if (marr[j] == 1 || narr[i] == 1) {
					continue;
				}
				int num = gcd(narr[i], marr[j]);
				result *= num;

				if (result >= 1000000000) {
					flag = true;
					result %= 1000000000;
				}

				narr[i] /= num;
				marr[j] /= num;
			}
		}

		String answer = Long.toString(result);
		if (flag) {
			for (int i = 0; i < 9 - answer.length(); i++) {
				System.out.print("0");
			}
		}
		System.out.println(answer);
	}

	private static int gcd(int a, int b) {
		if (b == 0)
			return a;
		else
			return gcd(b, a % b);
	}
}
