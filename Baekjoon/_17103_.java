import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _17103_ { // 골드바흐 파티션

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[1000001];
		for (int i = 2; i < 500001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 1000001; j += i) {
					arr[j] = true;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(bf.readLine());
			int cnt = 0;

			for (int j = 2; j <= num / 2; j++) {
				if (!arr[j] && !arr[num - j]) {
					cnt += 1;
				}
			}
			bw.write(cnt + "\n");
		}
		bw.flush();
	}
}
