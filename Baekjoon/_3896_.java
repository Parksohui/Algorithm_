import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _3896_ { // 소수 사이 수열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[1299710];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < 649856; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 1299710; j += i) {
					arr[j] = true;
				}
			}
		}

		for (int i = 0; i < t; i++) {
			int k = Integer.parseInt(bf.readLine());

			if (!arr[k]) {
				bw.write(0 + "\n");
			} else {
				int cnt = 1;
				int num = k - 1;
				while (num>1 && arr[num--]) {
					cnt++;
				}
				num = k + 1;
				while (num<=1299710 && arr[num++]) {
					cnt++;
				}
				bw.write((cnt+1) + "\n");
			}
		}
		bw.flush();
	}
}
