import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _9753_ { // 짝 곱

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[100001];
		for (int i = 2; i <= Math.sqrt(100001); i++) {
			if (!arr[i]) {
				for (int j = i * i; j < 100001; j += i) {
					arr[j] = true;
				}
			}
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 2; i < 100001; i++) {
			if (arr[i]) {
				continue;
			}
			for (int j = i + 1; j < 100001; j++) {
				if (arr[j]) {
					continue;
				}
				if ((long) i * (long) j > 100001) {
					break;
				}
				result.add(i * j);
			}
		}
		Collections.sort(result);

		for (int i = 0; i < T; i++) {
			int K = Integer.parseInt(bf.readLine());
			for (int num : result) {
				if (num >= K) {
					bw.write(num + "\n");
					break;
				}
			}
		}
		bw.flush();
	}
}
