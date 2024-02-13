import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _2312_ { // 수 복원하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());
		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(bf.readLine());

			int idx = 2;
			int cnt = 0;
			while (idx <= num) {
				if (num % idx == 0) {
					num /= idx;
					cnt += 1;
				} else {
					if (cnt > 0) {
						bw.write(idx + " " + cnt + "\n");
						cnt = 0;
					}
					idx++;
				}
			}
			if (cnt > 0) {
				bw.write(idx + " " + cnt + "\n");
			}
		}
		bw.flush();
	}
}
