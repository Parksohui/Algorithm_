import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class _2890_ { // 카약

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		ArrayList<int[]> arr = new ArrayList<>();

		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			int start = -1;
			int num = -1;
			int diff = 0;
			for (int j = 0; j < c; j++) {
				char x = str.charAt(j);
				if (Character.isDigit(x)) {
					start = j;
					num = x - '0';
				} else if (x == 'F') {
					diff = c - 1 - start;
				}
			}
			if (num != -1) {
				arr.add(new int[] { num, diff });
			}
		}

		arr.sort(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

		int result[] = new int[10];
		int diff = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			if (diff != arr.get(i)[1]) {
				result[arr.get(i)[0]] = ++idx;
				diff = arr.get(i)[1];
			} else {
				result[arr.get(i)[0]] = idx;
			}
		}

		for (int i = 1; i < 10; i++) {
			bw.write(result[i] + "\n");
		}

		bw.flush();
	}
}
