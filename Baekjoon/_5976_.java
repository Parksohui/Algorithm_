import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _5976_ { // A spiral walk

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(bf.readLine());

		int arr[][] = new int[N][N];
		int num = 1;

		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		int x = 0, y = -1, idx = 0;

		while (num <= N * N) {
			while (x+dx[idx]>=0 && x+dx[idx]<N && y+dy[idx]>=0 && y+dy[idx]<N && arr[x+dx[idx]][y+dy[idx]]==0) {
				x+=dx[idx];
				y+=dy[idx];
				arr[x][y] = num++;
			}
			idx += 1;
			if (idx == 4) {
				idx = 0;
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(arr[i][j] + " ");
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
