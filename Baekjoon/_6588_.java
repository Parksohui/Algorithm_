import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _6588_ { // 골드바흐의 추측

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean arr[] = new boolean[1000001];
		for (int i = 2; i <= 500001; i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 1000001; j += i) {
					arr[j] = true;
				}
			}
		}

		int num = 0;
		while ((num = (Integer.parseInt(bf.readLine()))) != 0) {
			int x = 0, y = 0;
			for (int i = 2; i <= num / 2; i++) {
				if (!arr[i] && !arr[num - i]) {
					x = i;
					y = num - i;
					break;
				}
			}
			if (x != 0 && y != 0) {
				bw.write(num + " = " + x + " + " + y + "\n");
			} else {
				bw.write("Goldbach's conjecture is wrong.\n");
			}
		}
		bw.flush();
	}
}
