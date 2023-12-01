import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _2529_ { // 부등호
	static int num[] = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static char arr[];
	static int result[];
	static boolean visited[];
	static String max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int k = Integer.parseInt(bf.readLine());

		arr = new char[k];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < k; i++) {
			arr[i] = st.nextToken().charAt(0);
		}

		result = new int[k + 1];
		visited = new boolean[10];
		max = "-1";
		min = "100000000000";

		search(0, k);

		bw.write(max+"\n"+min);
		bw.flush();
	}

	private static void search(int idx, int k) {
		if (idx == k + 1) {
			String answer = "";
			for (int i = 0; i < k + 1; i++) {
				answer += result[i];
			}
			if (Long.parseLong(max) < Long.parseLong(answer)) {
				max = answer;
			}
			if (Long.parseLong(min) > Long.parseLong(answer)) {
				min = answer;
			}
			return;
		}
		for (int i = 0; i < 10; i++) {
			if (!visited[i]) {
				if (idx == 0) {
					result[idx] = num[i];
					visited[i] = true;
					search(idx + 1, k);
					visited[i] = false;
				} else {
					if (arr[idx - 1] == '<') {
						if (result[idx - 1] < num[i]) {
							result[idx] = num[i];
							visited[i] = true;
							search(idx + 1, k);
							visited[i] = false;
						}
					} else if (arr[idx - 1] == '>') {
						if (result[idx - 1] > num[i]) {
							result[idx] = num[i];
							visited[i] = true;
							search(idx + 1, k);
							visited[i] = false;
						}
					}
				}
			}
		}
	}
}
