import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _1865_ { // 웜홀
	static class Edge {
		private int start;
		private int end;
		private int d;

		public Edge(int start, int end, int d) {
			this.start = start;
			this.end = end;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		ArrayList<Edge> list = new ArrayList<>();
		int result[];
		boolean visited[];
		boolean flag = false;

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			result = new int[n + 1];
			visited = new boolean[n + 1];
			flag = false;

			for (int j = 0; j < m; j++) {
				st = new StringTokenizer(bf.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Edge(s, e, d));
				list.add(new Edge(e, s, d));
			}

			for (int j = 0; j < w; j++) {
				st = new StringTokenizer(bf.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				list.add(new Edge(s, e, -d));
			}

			for (int j = 1; j <= n; j++) {
				if (visited[j]) {
					continue;
				}
				for (int k = 1; k <= n; k++) {
					result[k] = Integer.MAX_VALUE;
				}
				visited[j] = true;
				result[j] = 0;

				for (int k = 0; k < n; k++) {
					for (int v = 0; v < list.size(); v++) {
						Edge edge = list.get(v);
						if (result[edge.start] != Integer.MAX_VALUE && result[edge.end] > result[edge.start] + edge.d) {
							result[edge.end] = result[edge.start] + edge.d;
							visited[edge.end] = true;
							if (k == n - 1) {
								flag = true;
								break;
							}
						}
					}
					if (flag) {
						break;
					}
				}
				if (flag) {
					break;
				}
			}
			if (flag) {
				bw.write("YES\n");
			} else {
				bw.write("NO\n");
			}
			list.clear();
		}
		bw.flush();
	}
}
