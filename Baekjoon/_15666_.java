import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class _15666_ { // N과 M (12)
	static int arr[], result[], n;
	static LinkedHashSet<String> set;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		result = new int[m];
		set = new LinkedHashSet<>();

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		search(0, 0, m);

		for (String x : set) {
			bw.write(x + "\n");
		}
		bw.flush();
	}

	private static void search(int start, int idx, int m) {
		if (idx == m) {
			String str = "";
			for (int i = 0; i < m; i++) {
				str += result[i];
				if (i < n - 1)
					str += " ";
			}
			set.add(str);
			return;
		}
		for (int i = start; i < n; i++) {
			result[idx] = arr[i];
			search(i, idx + 1, m);
		}
	}
}
