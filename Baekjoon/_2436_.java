import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2436_ { // 공약수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int max = b / a;
		int result = Integer.MAX_VALUE;
		int num1 = 0, num2 = 0;

		for (int i = 1; i <= max; i++) {
			if (max % i == 0 && result > i + (max / i) && gcd(i, max / i) == 1) {
				result = i + (max / i);
				num1 = i;
				num2 = max / i;
			}
		}
		bw.write((num1 * a) + " " + (num2 * a));
		bw.flush();
	}

	private static int gcd(int i, int j) {
		if (j == 0) {
			return i;
		}
		return gcd(j, i % j);
	}
}
