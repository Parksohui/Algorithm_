import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _10709_ { // 기상캐스터

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());

		int arr[][] = new int[h][w];

		Queue<int[]> queue = new LinkedList<>();

		for (int i = 0; i < h; i++) {
			String str = bf.readLine();
			for (int j = 0; j < w; j++) {
				char x = str.charAt(j);
				if (x == 'c') {
					queue.add(new int[] { i, j });
					arr[i][j] = 0;
				} else
					arr[i][j] = -1;
			}
		}

		while (!queue.isEmpty()) {
			int num[] = queue.poll();
			int y = num[1] + 1;
			if (y >= 0 && y < w && arr[num[0]][y] == -1) {
				arr[num[0]][y] = arr[num[0]][num[1]] + 1;
				queue.add(new int[] { num[0], y });
			}
		}

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
