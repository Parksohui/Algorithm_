import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class _3980_ { // 선발 명단
	static int arr[][], answer[], result;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int c = Integer.parseInt(bf.readLine());

		arr = new int[11][11];
		answer = new int[11];
		visited = new boolean[11];

		for (int i = 0; i < c; i++) {
			result = 0;
			for (int j = 0; j < 11; j++) {
				st = new StringTokenizer(bf.readLine());
				for (int k = 0; k < 11; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			team(0);
			bw.write(result + "\n");
		}
		bw.flush();
	}

	private static void team(int idx) {
		if (idx == 11) {
			int sum = 0;
			for (int i = 0; i < 11; i++) {
				sum += answer[i];
			}
			result = Math.max(result, sum);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (!visited[i] && arr[i][idx] > 0) {
				visited[i] = true;
				answer[idx] = arr[i][idx];
				team(idx + 1);
				visited[i] = false;
			}
		}
	}
}
