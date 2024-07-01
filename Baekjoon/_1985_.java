import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _1985_ { // 디지털 친구
	static Set<Integer> set1, set2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(bf.readLine());

			String x = st.nextToken();
			String y = st.nextToken();

			set1 = new HashSet<>();
			set2 = new HashSet<>();

			for (int j = 0; j < x.length(); j++) {
				set1.add(x.charAt(j) - '0');
			}
			for (int j = 0; j < y.length(); j++) {
				set2.add(y.charAt(j) - '0');
			}

			boolean flag = false;
			for (int num : set1) {
				if (set1.size() != set2.size() || !set2.contains(num)) {
					flag = true;
					break;
				}
			}
			if (!flag) {
				bw.write("friends\n");
			} else {
				if (change(x, true) || change(y, false)) {
					bw.write("almost friends\n");
				} else {
					bw.write("nothing\n");
				}
			}
		}
		bw.flush();
	}

	private static boolean change(String num, boolean flag) {
		char arr[] = num.toCharArray();
		for (int i = 0; i < num.length() - 1; i++) { // + -
			Set<Integer> answer = new HashSet<>();

			if (arr[i] - '0' + 1 > 9 || arr[i + 1] - '0' - 1 < 0) {
				continue;
			}
			answer.add(arr[i] - '0' + 1);
			answer.add(arr[i + 1] - '0' - 1);

			for (int j = 0; j < num.length(); j++) {
				if (j == i || j == i + 1) {
					continue;
				}
				answer.add(arr[j] - '0');
			}
			boolean check = false;
			for (int x : answer) {
				if (flag) {
					if (answer.size() != set2.size() || !set2.contains(x)) {
						check = true;
						break;
					}
				} else {
					if (answer.size() != set1.size() || !set1.contains(x)) {
						check = true;
						break;
					}
				}
			}
			if (!check) {
				return true;
			}
		}

		for (int i = 0; i < num.length() - 1; i++) { // - +
			Set<Integer> answer = new HashSet<>();

			if (arr[i] - '0' - 1 < 0 || arr[i + 1] - '0' + 1 > 9 || (i == 0 && arr[i] - '0' - 1 == 0)) {
				continue;
			}
			answer.add(arr[i] - '0' - 1);
			answer.add(arr[i + 1] - '0' + 1);

			for (int j = 0; j < num.length(); j++) {
				if (j == i || j == i + 1) {
					continue;
				}
				answer.add(arr[j] - '0');
			}
			boolean check = false;
			for (int x : answer) {
				if (flag) {
					if (answer.size() != set2.size() || !set2.contains(x)) {
						check = true;
						break;
					}
				} else {
					if (answer.size() != set1.size() || !set1.contains(x)) {
						check = true;
						break;
					}
				}
			}
			if (!check) {
				return true;
			}
		}
		return false;
	}
}
