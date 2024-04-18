import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _10973_ { // 이전 순열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		st = new StringTokenizer(bf.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> list = new ArrayList<>();
		int idx = -1, num = -1;
		for (int i = n - 1; i >= 0; i--) {
			list.add(arr[i]);

			Collections.sort(list);
			if (arr[i] != list.get(0)) {
				for (int j = list.size() - 1; j >= 0; j--) {
					if (arr[i] > list.get(j)) {
						num = list.get(j);
						break;
					}
				}
				idx = i;
				break;
			}
		}

		if (num == -1) {
			System.out.println(-1);
		} else {
			boolean flag = false;

			for (int i = 0; i < idx; i++) {
				bw.write(arr[i] + " ");
			}
			bw.write(num + " ");
			for (int i = list.size() - 1; i >= 0; i--) {
				if (!flag && list.get(i) == num) {
					flag = true;
					continue;
				}
				bw.write(list.get(i) + " ");
			}
			bw.flush();
		}
	}
}
