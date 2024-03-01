import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _5107_ { // 마니또
	static boolean visited[];
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n;
		int cnt = 1;
		while ((n = Integer.parseInt(bf.readLine())) != 0) {
			ArrayList<String> list = new ArrayList<>();
			visited = new boolean[n];
			arr = new int[n];

			for(int i=0; i<n; i++) {
				st = new StringTokenizer(bf.readLine());
				String a = st.nextToken();
				String b = st.nextToken();

				if (!list.contains(a)) {
					list.add(a);
				}
				if (!list.contains(b)) {
					list.add(b);
				}
				arr[list.indexOf(a)] = list.indexOf(b);	
			}

			int result = 0;
			for (int i = 0; i < n; i++) {
				if (!visited[i]) {
					visited[i] = true;
					result += 1;

					search(i);
				}
			}
			bw.write(cnt++ + " " + result + "\n");
		}
		bw.flush();
	}

	private static void search(int num) {
		if (!visited[arr[num]]) {
			visited[arr[num]] = true;
			search(arr[num]);
		}
	}
}
