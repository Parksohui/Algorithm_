import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class _10972_ { // 다음 순열

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[] = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		ArrayList<Integer> list = new ArrayList<>();
		int num = -1;
		int idx = -1;

		for (int i = n - 1; i >= 0; i--) {
			list.add(arr[i]);

			Collections.sort(list, Collections.reverseOrder());

			if (list.get(0) != arr[i]) {
				for (int j = list.size() - 1; j >= 0; j--) {
					if (list.get(j) > arr[i]) {
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
