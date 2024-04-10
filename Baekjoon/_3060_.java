import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3060_ { // 욕심쟁이 돼지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		int arr[] = new int[6];
		int sum = 0;
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			int day = 1;
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 6; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				sum += arr[j];
			}

			while (true) {
				if (n - sum == 0) {
					bw.write((day + 1) + "\n");
					break;
				}
				if (n - sum < 0) {
					bw.write(day + "\n");
					break;
				} else {
					day += 1;
				}

				sum = 0;
				for (int j = 0; j < 6; j++) {
					arr[j] *= 4;
					sum += arr[j];
				}
			}
			sum = 0;
		}
		bw.flush();
	}
}
