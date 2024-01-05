import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _1895_ { // 필터

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

		int t = Integer.parseInt(bf.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		int result = 0;

		for (int i = 0; i <= r - 3; i++) {
			for (int j = 0; j <= c - 3; j++) {
				for (int x = i; x < i + 3; x++) {
					for (int y = j; y < j + 3; y++) {
						list.add(arr[x][y]);
					}
				}
				Collections.sort(list);
				if (list.get(4) >= t) {
					result += 1;
				}
				list.clear();
			}
		}
		System.out.println(result);
	}
}
