import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _11501_ { // 주식

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			st = new StringTokenizer(bf.readLine());

			int arr[] = new int[n];
			long result = 0;

			for (int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}

			int max_value = arr[n - 1];
			for (int j = n - 2; j >= 0; j--) {
				if (max_value < arr[j]) {
					max_value = arr[j];
				} else {
					result += max_value - arr[j];
				}
			}
			bw.write(result + "\n");
		}
		bw.flush();
	}
}
