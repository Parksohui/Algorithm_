import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _27172_ { // 수 나누기 게임

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int card[] = new int[n];
		int result[] = new int[1000001];
		boolean arr[] = new boolean[1000001];
		int max = 0;

		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
			arr[card[i]] = true;
			max = Math.max(card[i], max);
		}

		for (int i = 0; i < n; i++) {
			for (int j = card[i] + card[i]; j <= max; j += card[i]) {
				if (arr[j]) {
					result[card[i]] += 1;
					result[j] -= 1;
				}
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(result[card[i]] + " ");
		}
		bw.flush();
	}
}
