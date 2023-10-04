import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _19941_ { // 햄버거 분배

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		String str = bf.readLine();
		boolean visited[] = new boolean[n];
		boolean flag = false;
		int result = 0;

		for (int i = 0; i < str.length(); i++) {
			char x = str.charAt(i);
			if (x == 'P') {
				visited[i] = true;
				flag = false;
				for (int j = k; j > 0; j--) {
					if (i - j >= 0 && !visited[i - j]) {
						visited[i - j] = true;
						flag = true;
						break;
					}
				}
				if (!flag) {
					for (int j = 1; j < k + 1; j++) {
						if (i + j < n && !visited[i + j] && str.charAt(i + j) != 'P') {
							visited[i + j] = true;
							flag = true;
							break;
						}
					}
				}
				if (flag)
					result += 1;
			}
		}
		System.out.println(result);
	}
}
