import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _9694_ { // 무엇을 아느냐가 아니라 누구를 아느냐가 문제다
	static class Node implements Comparable<Node> {
		private int node;
		private int d;
		private ArrayList<Integer> list;

		public Node(int node, int d, ArrayList<Integer> list) {
			this.node = node;
			this.d = d;
			this.list = list;
		}

		@Override
		public int compareTo(Node o) {
			return this.d - o.d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int t = Integer.parseInt(bf.readLine());

		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		Node answer[];

		for (int i = 0; i < t; i++) {
			st = new StringTokenizer(bf.readLine());

			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			answer = new Node[m];
			for (int j = 0; j < m; j++) {
				list.add(new ArrayList<>());
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(j);
				answer[j] = new Node(j, Integer.MAX_VALUE, temp);
			}

			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(bf.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int z = Integer.parseInt(st.nextToken());

				list.get(x).add(new int[] { y, z });
				list.get(y).add(new int[] { x, z });
			}

			PriorityQueue<Node> queue = new PriorityQueue<>();
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(0);
			answer[0].d = 0;
			queue.add(new Node(0, 0, temp));

			while (!queue.isEmpty()) {
				Node node = queue.poll();

				if (answer[node.node].d < node.d) {
					continue;
				}
				for (int j = 0; j < list.get(node.node).size(); j++) {
					int info[] = list.get(node.node).get(j);
					if (answer[info[0]].d > node.d + info[1]) {
						answer[info[0]].d = node.d + info[1];
						answer[info[0]].list.clear();
						ArrayList<Integer> route = new ArrayList<>();
						for (int k = 0; k < node.list.size(); k++) {
							answer[info[0]].list.add(node.list.get(k));
							route.add(node.list.get(k));
						}
						answer[info[0]].list.add(info[0]);
						route.add(info[0]);
						queue.add(new Node(info[0], node.d + info[1], route));
					}
				}
			}

			bw.write("Case #" + (i + 1) + ": ");

			if (answer[m - 1].d == Integer.MAX_VALUE) {
				bw.write("-1\n");
			} else {
				for (int j = 0; j < answer[m - 1].list.size(); j++) {
					bw.write(answer[m - 1].list.get(j) + " ");
				}
				bw.write("\n");
			}
			list.clear();
		}
		bw.flush();
	}
}
