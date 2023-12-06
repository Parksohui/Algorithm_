import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1446_ { // 지름길

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		int arr[] = new int[d + 1];
		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		for (int i = 0; i < d + 1; i++) {
			arr[i] = i;
			list.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			if (start > d || end > d) {
				continue;
			}
			list.get(start).add(new int[] { end, num });
		}

		for (int i = 0; i < d + 1; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				int temp[] = list.get(i).get(j);

				if (arr[temp[0]] > arr[i] + temp[1]) {
					arr[temp[0]] = arr[i] + temp[1];
					for (int k = temp[0]; k < d + 1; k++) {
						if (arr[k] > arr[temp[0]] + (k - temp[0])) {
							arr[k] = arr[temp[0]] + (k - temp[0]);
						}
					}
				}
			}
		}

		System.out.println(arr[d]);
	}
}
