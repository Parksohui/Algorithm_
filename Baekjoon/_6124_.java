import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _6124_ { // Good Grass

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int arr[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < c; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int max = 0, x = 0, y = 0;
		for (int i = 0; i <= r - 3; i++) {
			for (int j = 0; j <= c - 3; j++) {
				int sum = 0;
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						sum += arr[i + k][j + l];
					}
				}
				if (max < sum) {
					max = sum;
					x = i + 1;
					y = j + 1;
				}
			}
		}
		System.out.println(max);
		System.out.println(x + " " + y);
	}
}
