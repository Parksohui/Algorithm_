import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _9417_ { // 최대 GCD

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int m = Integer.parseInt(bf.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());

			while (st.hasMoreTokens()) {
				list.add(Integer.parseInt(st.nextToken()));
			}

			int max = 0;
			for (int j = 0; j < list.size(); j++) {
				for (int k = j + 1; k < list.size(); k++) {
					int num = gcd(list.get(j), list.get(k));
					max = Math.max(num, max);
				}
			}
			bw.write(max + "\n");
			list.clear();
		}
		bw.flush();
	}

	private static Integer gcd(Integer a, Integer b) {
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
