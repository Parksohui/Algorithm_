import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _23895_ { // Allocation

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(bf.readLine());
			int arr[] = new int[N];

			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			Arrays.sort(arr);

			int cnt = 0;
			for (int j = 0; j < N; j++) {
				if (B - arr[j] >= 0) {
					B -= arr[j];
					cnt += 1;
				}
			}
			bw.write("Case #" + (i + 1) + ": " + cnt + "\n");
		}
		bw.flush();
	}
}
