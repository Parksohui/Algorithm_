import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15591_ { // MooTube (Silver)
	static int N;
	static boolean visited[];
	static LinkedList<int[]> arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		arr = new LinkedList[N];

		for (int i = 0; i < N; i++) {
			arr[i] = new LinkedList<int[]>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			arr[p - 1].add(new int[] { q - 1, r });
			arr[q - 1].add(new int[] { p - 1, r });
		}

		for (int i = 0; i < Q; i++) {
			visited = new boolean[N];
			st = new StringTokenizer(bf.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			System.out.println(search(k, v));
		}
	}

	private static int search(int k, int v) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { v - 1, 0 });
		visited[v - 1] = true;
		int result = 0;

		while (!queue.isEmpty()) {
			int num[] = queue.poll();
			for (int i = 0; i < arr[num[0]].size(); i++) {
				if (visited[arr[num[0]].get(i)[0]] == false && arr[num[0]].get(i)[1] >= k) {
					visited[arr[num[0]].get(i)[0]] = true;
					if (num[1] == 0 || num[1] > arr[num[0]].get(i)[1])
						queue.add(new int[] { arr[num[0]].get(i)[0], arr[num[0]].get(i)[1] });
					else
						queue.add(new int[] { arr[num[0]].get(i)[0], num[1] });
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (visited[i])
				result += 1;
		}
		return result-1;
	}
}
