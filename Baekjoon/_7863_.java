import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class _7863_ { // Very Simple Problem

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int p = Integer.parseInt(st.nextToken());

		HashMap<Integer, Integer> simple = new HashMap<>();
		Set<Integer> hard = new HashSet<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());

			int arr[] = new int[p];
			int min = 10001, max = 0;
			for (int j = 0; j < p; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
				min = Math.min(min, arr[j]);
				max = Math.max(max, arr[j]);
			}

			for (int j = 0; j < p; j++) {
				if (arr[j] == min) {
					if (simple.containsKey(j + 1)) {
						simple.replace(j + 1, simple.get(j + 1) + 1);
					} else {
						simple.put(j + 1, 1);
					}
				}
				if (arr[j] == max) {
					hard.add(j + 1);
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>(simple.keySet());
		Collections.sort(list, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return simple.get(o2) - simple.get(o1);
			}
		});

		boolean flag = false;
		ArrayList<Integer> result= new ArrayList<>();
		for (int num : list) {
			if (simple.get(num) > n / 2 && !hard.contains(num)) {
				flag = true;
				result.add(num);
			}
		}
		
		if (!flag) {
			bw.write("0");
		}else {
			Collections.sort(result);
			for(int num : result) {
				bw.write(num+" ");
			}
		}
		bw.flush();
	}
}
