import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _11502_ { // 세 개의 소수 문제

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[1000];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < 501; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 1000; j += i) {
					arr[j] = true;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(bf.readLine());
			boolean flag = false;

			for (int a = 2; a <= k; a++) {
				if (!arr[a]) {
					for (int b = a; b <= k - a; b++) {
						if (!arr[b]) {
							if (!arr[k - a - b]) {
								bw.write(a + " " + b + " " + (k - a - b) + "\n");
								flag = true;
								break;
							}
						}
					}
					if (flag) {
						break;
					}
				}
			}
			if (!flag) {
				bw.write("0\n");
			}
		}
		bw.flush();
	}
}