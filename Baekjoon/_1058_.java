import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _1058_ { // 친구

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		char arr[][] = new char[n][n];
		int visited[][] = new int[n][n];
		int result[] = new int[n];

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 'Y' && visited[i][j] == 0) {
					visited[i][j] = 1;
					result[i] += 1;
				}
			}
			for (int j = 0; j < n; j++) {
				if (visited[i][j] == 1) {
					for (int k = 0; k < n; k++) {
						if (i != k && arr[j][k] == 'Y' && visited[i][k] == 0) {
							visited[i][k] = 2;
							result[i] += 1;
						}
					}
				}
			}
		}

		int answer = result[0];
		for (int i = 0; i < n; i++) {
			if (answer < result[i])
				answer = result[i];
		}
		System.out.println(answer);
	}
}
