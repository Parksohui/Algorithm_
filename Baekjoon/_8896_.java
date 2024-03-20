import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class _8896_ { // 가위 바위 보

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(bf.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(bf.readLine());

			String str = bf.readLine();
			char arr[][] = new char[n][str.length()];
			boolean visited[] = new boolean[n];

			for (int j = 0; j < n; j++) {
				for (int k = 0; k < str.length(); k++) {
					arr[j][k] = str.charAt(k);
				}
				if (j == n - 1)
					break;
				str = bf.readLine();
			}

			Set<Character> set = new HashSet<>();
			int cnt = 0;

			for (int j = 0; j < str.length(); j++) {
				cnt = 0;
				for (int k = 0; k < n; k++) {
					if (visited[k]) {
						continue;
					}
					cnt += 1;
					set.add(arr[k][j]);
				}
				if (cnt == 1) {
					break;
				}
				if (set.size() == 2) {
					char a = '0', b = '0';
					char result = 0;
					for (char x : set) {
						if (a != '0' && b == '0')
							b = x;
						if (a == '0')
							a = x;
					}
					if ((a == 'R' && b == 'S') || (a == 'S' && b == 'R')) {
						result = 'S';
					} else if ((a == 'S' && b == 'P') || (a == 'P' && b == 'S')) {
						result = 'P';
					} else if ((a == 'R' && b == 'P') || (a == 'P' && b == 'R')) {
						result = 'R';
					}

					for (int k = 0; k < n; k++) {
						if (!visited[k] && arr[k][j] == result) {
							visited[k] = true;
						}
					}
				}
				set.clear();
			}

			if (cnt != 1) {
				cnt = 0;
				for (int j = 0; j < n; j++) {
					if (!visited[j]) {
						cnt += 1;
					}
				}
			}
			if (cnt == 1) {
				for (int j = 0; j < n; j++) {
					if (!visited[j]) {
						bw.write((j + 1) + "\n");
						break;
					}
				}
			} else {
				bw.write("0\n");
			}
		}
		bw.flush();
	}
}
