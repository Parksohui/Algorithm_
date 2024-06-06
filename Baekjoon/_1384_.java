import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _1384_ { // 메시지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = -1;
		int idx = 1;

		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			bw.write("Group " + idx++ + "\n");
			String arr[] = new String[n];
			char info[][] = new char[n][n - 1];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());

				String name = st.nextToken();
				arr[i] = name;

				for (int j = 0; j < n - 1; j++) {
					info[i][j] = st.nextToken().charAt(0);
				}
			}

			boolean flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (info[i][j] == 'N') {
						flag = true;
						if (i - (j + 1) < 0) {
							bw.write(arr[i + n - (j + 1)] + " was nasty about " + arr[i] + "\n");
						} else {
							bw.write(arr[i - (j + 1)] + " was nasty about " + arr[i] + "\n");
						}
					}
				}
			}
			if (!flag) {
				bw.write("Nobody was nasty\n");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
