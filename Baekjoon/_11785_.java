import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class _11785_ { // Programming Contest Strategy

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());

			int N = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());

			int arr[] = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			Arrays.sort(arr);

			int num = 0, time = 0, total = 0;
			for (int j = 0; j < N; j++) {
				if (time + arr[j] <= L) {
					num += 1;
					time += arr[j];
					total += time;
				} else {
					break;
				}
			}
			bw.write("Case " + (i + 1) + ": " + num + " " + time + " " + total + "\n");
		}
		bw.flush();
	}
}
