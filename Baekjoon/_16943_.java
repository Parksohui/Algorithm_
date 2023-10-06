import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class _16943_ { // 숫자 재배치
	static Integer temp[];
	static int result[], b;
	static boolean flag, visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		String a = st.nextToken();
		b = Integer.parseInt(st.nextToken());

		if (a.length() > Integer.toString(b).length())
			System.out.println(-1);
		else {
			temp = new Integer[a.length()];
			result = new int[a.length()];
			visited = new boolean[a.length()];
			flag = false;

			for (int i = 0; i < a.length(); i++) {
				temp[i] = a.charAt(i) - '0';
			}
			Arrays.sort(temp, Collections.reverseOrder());

			search(0);
			
			if(!flag)
				System.out.println(-1);
		}

	}

	private static void search(int idx) {
		if (idx == result.length) {
			String answer = "";
			for (int i = 0; i < result.length; i++) {
				answer += result[i];
			}
			if (Integer.parseInt(answer) < b) {
				System.out.println(answer);
				flag = true;
			}
			return;
		}
		for (int i = 0; i < temp.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = temp[i];
				if (result[0] == 0)
					return;
				search(idx + 1);
				visited[i] = false;
				if (flag)
					return;
			}
		}
	}
}
