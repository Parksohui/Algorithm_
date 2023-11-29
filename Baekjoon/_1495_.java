import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1495_ { // 기타리스트

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int temp[] = new int[m + 1];
		temp[s] = 1;
		boolean flag = false;

		for (int i = 0; i < n; i++) {
			flag = false;
			ArrayList<Integer> list = new ArrayList<>();
			for (int j = 0; j < m + 1; j++) {
				if (temp[j] == i + 1) {
					if (j + arr[i] <= m) {
						list.add(j + arr[i]);
						flag = true;
					}
					if (j - arr[i] >= 0) {
						list.add(j - arr[i]);
						flag = true;
					}
				}
			}
			for (int j : list) {
				temp[j] = i + 2;
			}
			if (!flag) {
				break;
			}
		}

		int result = -1;
		for (int i = 0; i < m + 1; i++) {
			if (temp[i] == n + 1) {
				result = Math.max(result, i);
			}
		}
		System.out.println(result);
	}
}
