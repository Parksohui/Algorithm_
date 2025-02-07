import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _18706_ { // Coffee

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(bf.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(bf.readLine());

			int C = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());

			HashMap<String, ArrayList<Integer>> map = new HashMap<>();
			for (int j = 0; j < C; j++) {
				st = new StringTokenizer(bf.readLine());

				String coffee = st.nextToken();

				ArrayList<Integer> temp = new ArrayList<>();
				for (int k = 0; k < 3; k++) {
					temp.add(Integer.parseInt(st.nextToken()));
				}

				map.put(coffee, temp);
			}

			for (int j = 0; j < P; j++) {
				st = new StringTokenizer(bf.readLine());
				String name = st.nextToken();

				String size = st.nextToken();

				String coffee = st.nextToken();

				int money = 0;
				if (size.equals("small")) {
					money = map.get(coffee).get(0) + (100 / P);
				} else if (size.equals("medium")) {
					money = map.get(coffee).get(1) + (100 / P);
				} else {
					money = map.get(coffee).get(2) + (100 / P);
				}

				if ((money + 1) % 5 == 0) {
					money += 1;
				} else if ((money - 1) % 5 == 0) {
					money -= 1;
				}
				bw.write(name + " " + money + "\n");
			}
		}
		bw.flush();
	}
}
