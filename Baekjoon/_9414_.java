import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class _9414_ { // 프로그래밍 대회 전용 부지

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(bf.readLine());
		for (int i = 0; i < T; i++) {
			ArrayList<Integer> list = new ArrayList<>();
			int num = -1;
			while ((num = Integer.parseInt(bf.readLine())) != 0) {
				list.add(num);
			}
			Collections.sort(list, Collections.reverseOrder());

			int result = 0;
			boolean flag = false;
			for (int j = 0; j < list.size(); j++) {
				result += 2 * (Math.pow(list.get(j), j + 1));
				if (result > 5000000) {
					flag = true;
					break;
				}
			}
			if (flag) {
				bw.write("Too expensive\n");
			} else {
				bw.write(result + "\n");
			}
		}
		bw.flush();
	}
}
