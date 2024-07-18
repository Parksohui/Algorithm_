import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class _2817_ { // ALPS식 투표
	static class Participant implements Comparable<Participant> {
		private String name;
		private double value;

		public Participant(String name, double value) {
			this.name = name;
			this.value = value;
		}

		@Override
		public int compareTo(Participant o) {
			return Double.compare(o.value, this.value);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int X = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());

		ArrayList<Participant> list = new ArrayList<>();
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(bf.readLine());

			String name = st.nextToken();
			int value = Integer.parseInt(st.nextToken());

			if (value < X * 0.05) {
				continue;
			}
			map.put(name, 0);
			for (int j = 1; j <= 14; j++) {
				list.add(new Participant(name, (double) value / j));
			}
		}
		Collections.sort(list);

		for (int i = 0; i < 14; i++) {
			Participant participant = list.get(i);
			if (map.containsKey(participant.name)) {
				map.replace(participant.name, map.get(participant.name) + 1);
			}
		}

		ArrayList<String> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for (String name : keySet) {
			bw.write(name + " " + map.get(name) + "\n");
		}
		bw.flush();
	}
}
