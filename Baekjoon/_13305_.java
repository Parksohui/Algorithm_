import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _13305_ { // 주유소

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		long d[] = new long[n - 1];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n - 1; i++) {
			d[i] = Long.parseLong(st.nextToken());
		}

		long m[] = new long[n];
		st = new StringTokenizer(bf.readLine());
		long value = Long.MAX_VALUE;
		long result = 0;

		for (int i = 0; i < n; i++) {
			m[i] =Long.parseLong(st.nextToken());
			if (value > m[i]) {
				value = m[i];
			}
			if (i < n - 1)
				result += value * d[i];
		}

		System.out.println(result);
	}
}
