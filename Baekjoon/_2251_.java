import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _2251_ { // 물통

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		Queue<int[]> queue = new LinkedList<>();
		ArrayList<Integer> list = new ArrayList<>();
		boolean visited[][][] = new boolean[a + 1][b + 1][c + 1];

		queue.add(new int[] { 0, 0, c });
		list.add(c);
		visited[0][0][c] = true;

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			if (temp[0] == 0 && !list.contains(temp[2])) {
				list.add(temp[2]);
			}

			if (temp[0] > 0) {
				// a->b
				if (temp[1] + temp[0] < b) {
					if (!visited[0][temp[1] + temp[0]][temp[2]]) {
						visited[0][temp[1] + temp[0]][temp[2]] = true;
						queue.add(new int[] { 0, temp[1] + temp[0], temp[2] });
					}
				} else {
					if (!visited[temp[0] - (b - temp[1])][b][temp[2]]) {
						visited[temp[0] - (b - temp[1])][b][temp[2]] = true;
						queue.add(new int[] { temp[0] - (b - temp[1]), b, temp[2] });
					}
				}

				// a->c
				if (temp[2] + temp[0] < c) {
					if (!visited[0][temp[1]][temp[2] + temp[0]]) {
						visited[0][temp[1]][temp[2] + temp[0]] = true;
						queue.add(new int[] { 0, temp[1], temp[2] + temp[0] });
					}
				} else {
					if (!visited[temp[0] - (c - temp[2])][temp[1]][c]) {
						visited[temp[0] - (c - temp[2])][temp[1]][c] = true;
						queue.add(new int[] { temp[0] - (c - temp[2]), temp[1], c });
					}
				}
			}

			if (temp[1] > 0) {
				// b->a
				if (temp[0] + temp[1] < a) {
					if (!visited[temp[0] + temp[1]][0][temp[2]]) {
						visited[temp[0] + temp[1]][0][temp[2]] = true;
						queue.add(new int[] { temp[1] + temp[0], 0, temp[2] });
					}
				} else {
					if (!visited[a][temp[1] - (a - temp[0])][temp[2]]) {
						visited[a][temp[1] - (a - temp[0])][temp[2]] = true;
						queue.add(new int[] { a, temp[1] - (a - temp[0]), temp[2] });
					}
				}

				// b->c
				if (temp[2] + temp[1] < c) {
					if (!visited[temp[0]][0][temp[2] + temp[1]]) {
						visited[temp[0]][0][temp[2] + temp[1]] = true;
						queue.add(new int[] { temp[0], 0, temp[2] + temp[1] });
					}
				} else {
					if (!visited[temp[0]][temp[1] - (c - temp[2])][c]) {
						visited[temp[0]][temp[1] - (c - temp[2])][c] = true;
						queue.add(new int[] { temp[0], temp[1] - (c - temp[2]), c });
					}
				}
			}

			if (temp[2] > 0) {
				// c->a
				if (temp[0] + temp[2] < a) {
					if (!visited[temp[0] + temp[2]][temp[1]][0]) {
						visited[temp[0] + temp[2]][temp[1]][0] = true;
						queue.add(new int[] { temp[2] + temp[0], temp[1], 0 });
					}
				} else {
					if (!visited[a][temp[1]][temp[2] - (a - temp[0])]) {
						visited[a][temp[1]][temp[2] - (a - temp[0])] = true;
						queue.add(new int[] { a, temp[1], temp[2] - (a - temp[0]) });
					}
				}

				// c->b
				if (temp[2] + temp[1] < b) {
					if (!visited[temp[0]][temp[1] + temp[2]][0]) {
						visited[temp[0]][temp[1] + temp[2]][0] = true;
						queue.add(new int[] { temp[0], temp[1] + temp[2], 0 });
					}
				} else {
					if (!visited[temp[0]][b][temp[2] - (b - temp[1])]) {
						visited[temp[0]][b][temp[2] - (b - temp[1])] = true;
						queue.add(new int[] { temp[0], b, temp[2] - (b - temp[1]) });
					}
				}
			}
		}
		Collections.sort(list);
		for (int x : list) {
			bw.write(x + " ");
		}
		bw.flush();
	}
}
