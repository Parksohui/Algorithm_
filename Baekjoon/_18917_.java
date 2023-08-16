import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _18917_ { // 수열과 쿼리 38

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int m = Integer.parseInt(bf.readLine());

		long sum = 0;
		long xor = 0;

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int num = Integer.parseInt(st.nextToken());

			if (num == 1) {
				int x = Integer.parseInt(st.nextToken());
				sum += x;
				xor = xor ^ x;
			} else if (num == 2) {
				int x = Integer.parseInt(st.nextToken());
				sum -= x;
				xor = xor ^ x;
			} else if (num == 3) {
				bw.write(sum + "\n");
			} else {
				bw.write(xor + "\n");
			}
		}
		bw.flush();
	}
}
