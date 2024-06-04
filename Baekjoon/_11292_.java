import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _11292_ { // 키 큰 사람

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = -1;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {

			HashMap<Double, ArrayList<String>> map = new HashMap<>();
			Double[] arr = new Double[n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(bf.readLine());
				String name = st.nextToken();
				double height = Double.parseDouble(st.nextToken());

				ArrayList<String> list;
				if (map.containsKey(height)) {
					list = map.get(height);
				} else {
					list = new ArrayList<>();
				}
				list.add(name);
				map.put(height, list);
				arr[i] = height;
			}
			Arrays.sort(arr, Collections.reverseOrder());
			
			ArrayList<String> list=map.get(arr[0]);
			for(String name: list) {
				bw.write(name+" ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
