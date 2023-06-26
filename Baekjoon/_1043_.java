import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _1043_ { // 거짓말
	static boolean visited[], result[];
	static ArrayList<ArrayList<Integer>> arr, party;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		result = new boolean[n + 1];
		arr = new ArrayList<>(); 
		party = new ArrayList<>(); 
		for (int i = 0; i < n + 1; i++) {
			arr.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			party.add(new ArrayList<>());
		}

		st = new StringTokenizer(bf.readLine());
		int num = Integer.parseInt(st.nextToken());
		for (int i = 0; i < num; i++) {
			int idx = Integer.parseInt(st.nextToken());
			result[idx] = true;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(bf.readLine());
			num = Integer.parseInt(st.nextToken());
			for (int j = 0; j < num; j++) {
				int idx = Integer.parseInt(st.nextToken());
				party.get(i).add(idx);
			}
			for (int j = 0; j < num; j++) {
				for (int k = j + 1; k < num; k++) {
					int a = party.get(i).get(j);
					int b = party.get(i).get(k);
					arr.get(a).add(b);
					arr.get(b).add(a);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			if (result[i]) {
				visited[i] = true;
				bfs(i);
			}
		}

		int answer = 0;
		for (int i = 0; i < m; i++) {
			boolean flag = false;
			for (int j = 0; j < party.get(i).size(); j++) {
				if (result[party.get(i).get(j)]) {
					flag = true;
					break;
				}
			}
			if (!flag)
				answer += 1;
		}
		System.out.println(answer);
	}

	private static void bfs(int idx) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(idx);

		while (!queue.isEmpty()) {
			int num = queue.poll();
			for (int i = 0; i < arr.get(num).size(); i++) {
				int next = arr.get(num).get(i);
				if (!visited[next]) {
					visited[next] = true;
					result[next] = true;
					queue.add(next);
				}
			}
		}
	}
}
