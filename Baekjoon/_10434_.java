import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _10434_ { // 행복한 소수
	static Set<Integer> set;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int p = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[10001];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < 5001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 10001; j += i) {
					arr[j] = true;
				}
			}
		}

		set = new HashSet<>();
		for (int i = 0; i < p; i++) {
			st = new StringTokenizer(bf.readLine());
			int t = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			if (arr[m]) {
				bw.write(t + " " + m + " NO\n");
			} else {
				set.add(m);
				check(Integer.toString(m));

				if (set.contains(1)) {
					bw.write(t + " " + m + " YES\n");
				} else {
					bw.write(t + " " + m + " NO\n");
				}
				set.clear();
			}
		}
		bw.flush();
	}

	private static void check(String m) {
		int sum = 0;
		for (int i = 0; i < m.length(); i++) {
			int x = m.charAt(i) - '0';
			sum += (x * x);
		}
		if (set.contains(sum)) {
			return;
		}
		set.add(sum);
		if(sum==1) {
			return;
		}
		check(Integer.toString(sum));
	}
}
