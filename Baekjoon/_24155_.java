import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _24155_ { // 得点 (Score)

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			list.add(new int[] { Integer.parseInt(bf.readLine()), i });
		}

		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});

		int result[] = new int[n];
		for (int i = 0; i < n; i++) {
			if (i == 0) {
				result[list.get(i)[1]] = (i + 1);
			} else {
				if (list.get(i - 1)[0] == list.get(i)[0]) {
					result[list.get(i)[1]] = result[list.get(i - 1)[1]];
				} else {
					result[list.get(i)[1]] = (i + 1);
				}
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(result[i] + "\n");
		}
		bw.flush();
	}
}
