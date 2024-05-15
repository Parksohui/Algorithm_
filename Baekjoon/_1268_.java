import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _1268_ { // 임시 반장 정하기

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(bf.readLine());

		int arr[][] = new int[n][5];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayList<HashSet<Integer>> result = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			result.add(new HashSet<>());
		}

		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(new ArrayList<>());
		}

		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < 10; i++) {
				list.get(i).clear();
			}
			for (int i = 0; i < n; i++) {
				list.get(arr[i][j]).add(i);
			}
			for (int i = 0; i < n; i++) {
				if (list.get(arr[i][j]).size() > 1) {
					for (int k = 0; k < list.get(arr[i][j]).size(); k++) {
						result.get(i).add(list.get(arr[i][j]).get(k));
					}
				}
			}
		}

		int max = 0;
		int answer = 0;
		for (int i = 0; i < n; i++) {
			if (max < result.get(i).size()) {
				max = result.get(i).size();
				answer = i;
			}
		}
		System.out.println(answer + 1);
	}
}
