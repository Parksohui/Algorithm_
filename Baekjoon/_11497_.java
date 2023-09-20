import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11497_ { // 통나무 건너뛰기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());
			st = new StringTokenizer(bf.readLine());

			int arr[] = new int[n];
			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			int result[] = new int[n];
			int start = 0, end = n - 1, idx = 0;
			for (int j = 0; j < n; j++) {
				if (idx % 2 == 0) {
					result[start++] = arr[idx++];
				} else {
					result[end--] = arr[idx++];
				}
			}

			int answer = Math.abs(result[n - 1] - result[0]);
			for (int j = 0; j < n - 1; j++) {
				if (answer < Math.abs(result[j] - result[j + 1]))
					answer = Math.abs(result[j] - result[j + 1]);
			}
			bw.write(answer + "\n");
		}
		bw.flush();
	}
}
