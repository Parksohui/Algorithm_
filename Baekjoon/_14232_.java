import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class _14232_ { // 보석 도둑

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		Long k = Long.parseLong(bf.readLine());

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2; i <= Math.sqrt(k) + 1; i++) {
			while (k%i == 0) {
				list.add(i);
				k/=i;
			}
		}

		if (k > 1) {
			bw.write(list.size() + 1 + "\n");
		} else {
			bw.write(list.size() + "\n");
		}

		for (int i = 0; i < list.size(); i++) {
			bw.write(list.get(i) + " ");
		}
		if (k > 1) {
			bw.write(k + "");
		}

		bw.flush();
	}
}
