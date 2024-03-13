import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1990_ { // 소수인팰린드롬

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		boolean arr[] = new boolean[b + 1];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i < (b + 1) / 2 + 1; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < b + 1; j += i) {
					arr[j] = true;
				}
			}
		}

		boolean flag = false;
		for (int i = a; i <= b; i++) {
			if (!arr[i]) {
				String str = Integer.toString(i);
				for (int j = 0; j < str.length() / 2; j++) {
					if (str.charAt(j) != str.charAt(str.length() - 1 - j)) {
						flag = true;
						break;
					}
				}
				if (!flag) {
					bw.write(i + "\n");
				}
				flag = false;
			}
		}
		bw.write("-1");
		bw.flush();
	}
}
