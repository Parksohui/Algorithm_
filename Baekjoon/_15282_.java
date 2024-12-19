import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _15282_ { // Frosh Week

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		Integer task[] = new Integer[n];
		Integer interval[] = new Integer[m];

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			task[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < m; i++) {
			interval[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(task, Collections.reverseOrder());
		Arrays.sort(interval, Collections.reverseOrder());

		int idx = 0, idx2 = 0, result = 0;
		while (idx < m && idx2 < n) {
			if (interval[idx] >= task[idx2]) {
				result += 1;
				idx += 1;
			}
			idx2 += 1;
		}
		System.out.println(result);
	}
}
