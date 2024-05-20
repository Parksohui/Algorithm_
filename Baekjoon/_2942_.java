import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2942_ { // 퍼거슨과 사과

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());

		int num = gcd(r, g);

		for (int i = 1; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				bw.write(i + " " + r / i + " " + g / i + "\n");
				if (num / i != i)
					bw.write(num / i + " " + r / (num / i) + " " + g / (num / i) + "\n");
			}
		}
		bw.flush();
	}

	private static int gcd(int r, int g) {
		if (g == 0) {
			return r;
		}
		return gcd(g, r % g);
	}
}
