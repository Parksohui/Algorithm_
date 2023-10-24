import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _9575_ { // 행운의 수

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int a[] = new int[n];
			for (int j = 0; j < n; j++) {
				a[j] = Integer.parseInt(st.nextToken());
			}

			int m = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int b[] = new int[m];
			for (int j = 0; j < m; j++) {
				b[j] = Integer.parseInt(st.nextToken());
			}

			int k = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());
			int c[] = new int[k];
			for (int j = 0; j < k; j++) {
				c[j] = Integer.parseInt(st.nextToken());
			}

			Set<Integer> set = new HashSet<>();
			int result = 0;
			for (int j = 0; j < n; j++) {
				for (int l = 0; l < m; l++) {
					for (int o = 0; o < k; o++) {
						result = a[j] + b[l] + c[o];

						String temp = Integer.toString(result);
						if (!(temp.contains("0") || temp.contains("1") || temp.contains("2") || temp.contains("3")
								|| temp.contains("4") || temp.contains("6") || temp.contains("7")
								|| temp.contains("9"))) {
							set.add(result);
						}
					}
				}
			}
			bw.write(set.size() + "\n");
		}
		bw.flush();
	}
}
