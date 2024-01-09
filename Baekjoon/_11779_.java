import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class _11779_ { // 최소비용 구하기 2
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

		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());

		ArrayList<ArrayList<int[]>> list = new ArrayList<>();
		Node result[] = new Node[n + 1];
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			result[i] = new Node(i, Integer.MAX_VALUE, new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(start).add(new int[] { end, cost });
		}

		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		PriorityQueue<Node> queue = new PriorityQueue<>();
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(start);
		queue.add(new Node(start, 0, temp));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if(node.d > result[node.node].d) {
				continue;
			}
			for (int i = 0; i < list.get(node.node).size(); i++) {
				int info[] = list.get(node.node).get(i);
				if (node.d + info[1] < result[info[0]].d) {
					ArrayList<Integer> route = new ArrayList<>();
					result[info[0]].d = node.d + info[1];
					result[info[0]].list.clear();
					for (int j = 0; j < node.list.size(); j++) {
						route.add(node.list.get(j));
						result[info[0]].list.add(node.list.get(j));
					}
					result[info[0]].list.add(info[0]);
					route.add(info[0]);

					queue.add(new Node(info[0], node.d + info[1], route));
				}
			}
		}

		bw.write(result[end].d + "\n");
		bw.write(result[end].list.size() + "\n");
		for (int i = 0; i < result[end].list.size(); i++) {
			bw.write(result[end].list.get(i) + " ");
		}
		bw.flush();
	}
}
