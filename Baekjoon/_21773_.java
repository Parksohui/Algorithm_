import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class _21773_ { // 가희와 프로세스 1

	public static class Process implements Comparable<Process> {
		int id;
		int time;
		int level;

		public Process(int id, int time, int level) {
			this.id = id;
			this.time = time;
			this.level = level;
		}

		@Override
		public int compareTo(Process o) {
			if (level == o.level)
				return id - o.id;
			return o.level - level;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int t = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		PriorityQueue<Process> queue = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			queue.add(new Process(a, b, c));
		}

		for (int i = 0; i < t; i++) {
			if (queue.isEmpty())
				break;
			Process process = queue.poll();
			bw.write(process.id + "\n");

			process.time -= 1;

			if (process.time > 0) {
				process.level -= 1;
				queue.add(process);
			}
		}
		bw.flush();
	}
}
