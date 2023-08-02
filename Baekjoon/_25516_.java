import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _25516_ { // 거리가 k이하인 트리 노드에서 사과 수확하기
	static ArrayList<ArrayList<Integer>> arr;
	static int apple[], k, result;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		int tree[] = new int[n];

		arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(new ArrayList<>());
			tree[i] = -1;
		}

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			arr.get(p).add(c);
			tree[c] = p;

		}

		int start = 0;
		for (int i = 0; i < n; i++) {
			if (tree[i] == -1) {
				start = i;
				break;
			}
		}

		apple = new int[n];
		st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) {
			apple[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;

		bfs(start);

		System.out.println(result);
	}

	private static void bfs(int start) {
		Queue<int[]> queue = new LinkedList<>();
		result += apple[start];
		queue.add(new int[] { start, 0 });

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();
			for (int num : arr.get(temp[0])) {
				result += apple[num];
				if (temp[1] + 1 < k) {
					queue.add(new int[] { num, temp[1] + 1 });
				}
			}
		}
	}
}
