import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class _9421_ { // 소수상근수
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[n + 1];
		for (int i = 2; i < (n + 1) / 2 + 1; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < n + 1; j += i) {
					arr[j] = true;
				}
			}
		}

		for (int i = 3; i <= n; i++) {
			if (!arr[i]) {
				set.clear();
				boolean result = check(i);
				if (result) {
					bw.write(i + "\n");
				}
			}
		}
		bw.flush();
	}

	private static boolean check(int i) {
		
		String num = Integer.toString(i);
		int answer = 0;
		for (int j = 0; j < num.length(); j++) {
			int temp = num.charAt(j) - '0';
			answer += (temp * temp);
		}
		
		if (i == 1) {
			return true;
		} else if (set.contains(answer)) {
			return false;
		}
		
		set.add(answer);
		return check(answer);
	}
}
