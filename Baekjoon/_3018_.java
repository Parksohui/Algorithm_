import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _3018_ { // 캠프파이어

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());
		int e = Integer.parseInt(bf.readLine());

		ArrayList<HashSet<Integer>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new HashSet<>());
		}

		int idx = 0;
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(bf.readLine());

			int k = Integer.parseInt(st.nextToken());
			int num[] = new int[k];
			boolean flag = false;
			for (int j = 0; j < k; j++) {
				num[j] = Integer.parseInt(st.nextToken());
				if (num[j] == 1) {
					flag = true;
				}
			}
			if (flag) {
				idx += 1;
				for (int j = 0; j < k; j++) {
					list.get(num[j]).add(idx);
				}
			} else {
				for (int j = 0; j < k; j++) {
					for (int l = 0; l < k; l++) {
						if (j == l) {
							continue;
						}
						for (int m : list.get(num[j])) {
							list.get(num[l]).add(m);
						}
					}
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (list.get(i).size() == idx) {
				bw.write(i + "\n");
			}
		}
		bw.flush();
	}
}
