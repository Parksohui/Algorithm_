import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class _3230_ { // 금메달, 은메달, 동메달은 누가?

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(bf.readLine()) - 1, i + 1);
		}

		ArrayList<Integer> result = new ArrayList<>();
		for (int i = M - 1; i >= 0; i--) {
			result.add(Integer.parseInt(bf.readLine()) - 1, list.get(i));
		}

		for (int i = 0; i < 3; i++) {
			bw.write(result.get(i) + "\n");
		}
		bw.flush();
	}
}
