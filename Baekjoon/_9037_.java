import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _9037_ { // The candy war

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			int N = Integer.parseInt(bf.readLine());

			int cnt = 0;

			int arr[] = new int[N];
			int temp[] = new int[N];
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				if (arr[j] % 2 != 0) {
					arr[j] += 1;
				}
			}

			boolean flag = false;
			for (int j = 0; j < N - 1; j++) {
				if (arr[j] != arr[j + 1]) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				bw.write(cnt + "\n");
			} else {
				while (true) {
					flag = false;
					for (int j = 0; j < N; j++) {
						arr[j] /= 2;
						temp[j] = arr[j];
					}
					for (int j = 0; j < N; j++) {
						if (j + 1 == N) {
							arr[0] += temp[j];
							if (arr[0] % 2 != 0) {
								arr[0] += 1;
							}
						} else {
							arr[j + 1] += temp[j];
							if (arr[j + 1] % 2 != 0) {
								arr[j + 1] += 1;
							}
						}

					}
					cnt += 1;
					for (int j = 0; j < N - 1; j++) {
						if (arr[j] != arr[j + 1]) {
							flag = true;
							break;
						}
					}
					if (!flag) {
						bw.write(cnt + "\n");
						break;
					}
				}
			}
		}
		bw.flush();
	}
}
