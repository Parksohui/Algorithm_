import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _3024_ { // 마라톤 틱택토

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(bf.readLine());

		char arr[][] = new char[N][N];
		for (int i = 0; i < N; i++) {
			String str = bf.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		boolean flag = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == '.') {
					continue;
				}
				if (j + 1 < N && j + 2 < N && arr[i][j] == arr[i][j + 1] && arr[i][j] == arr[i][j + 2]) {
					System.out.println(arr[i][j]);
					flag = true;
					break;
				}
				if (i + 1 < N && i + 2 < N && arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i + 2][j]) {
					System.out.println(arr[i][j]);
					flag = true;
					break;
				}
				if (i + 1 < N && j + 1 < N && i + 2 < N && j + 2 < N && arr[i][j] == arr[i + 1][j + 1]
						&& arr[i][j] == arr[i + 2][j + 2]) {
					System.out.println(arr[i][j]);
					flag = true;
					break;
				}
				if (i + 1 < N && j - 1 >= 0 && i + 2 < N && j - 2 >= 0 && arr[i][j] == arr[i + 1][j - 1]
						&& arr[i][j] == arr[i + 2][j - 2]) {
					System.out.println(arr[i][j]);
					flag = true;
					break;
				}
			}
			if (flag) {
				break;
			}
		}
		if (!flag) {
			System.out.println("ongoing");
		}
	}
}
