import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _8978_ { // VLAK

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];
		HashMap<Integer, HashMap<Character, Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new HashMap<>());
		}

		int p = Integer.parseInt(bf.readLine());

		for (int i = 0; i < p; i++) {
			char name = bf.readLine().charAt(0);
			int idx = -1, cnt = 0, sum = 0;

			for (int j = 0; j < n; j++) {
				if (arr[j] == k) {
					continue;
				}
				if (idx == -1) {
					idx = j;
					if (map.get(idx).containsKey(name)) {
						cnt = map.get(idx).get(name);
					}
					sum = arr[idx];
				} else {
					if (map.get(j).containsKey(name)) {
						if (cnt > map.get(j).get(name) || (cnt == map.get(j).get(name) && sum > arr[j])) {
							idx = j;
							sum = arr[j];
							cnt = map.get(j).get(name);
						}
					} else {
						if (cnt > 0 || (cnt == 0 && sum > arr[j])) {
							idx = j;
							sum = arr[j];
							cnt = 0;
						}
					}
				}

			}
			arr[idx] += 1;
			if (map.get(idx).containsKey(name)) {
				map.get(idx).put(name, map.get(idx).get(name) + 1);
			} else {
				map.get(idx).put(name, 1);
			}
		}

		for (int i = 0; i < n; i++) {
			bw.write(arr[i] + " ");
		}
		bw.flush();
	}
}
