import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class _9609_ { // PSU Campuses
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(bf.readLine());

		HashMap<String, Integer> map = new HashMap<String, Integer>() {
			{
				put("Hatyai Pattani", 103);
				put("Hatyai Suratthani", 329);
				put("Hatyai Phuket", 466);
				put("Hatyai Trang", 148);

				put("Pattani Suratthani", 408);
				put("Pattani Trang", 260);
				put("Pattani Phuket", 577);
				put("Pattani Hatyai", 103);

				put("Phuket Pattani", 577);
				put("Phuket Trang", 312);
				put("Phuket Suratthani", 287);
				put("Phuket Hatyai", 466);

				put("Suratthani Trang", 226);
				put("Suratthani Hatyai", 329);
				put("Suratthani Pattani", 408);
				put("Suratthani Phuket", 287);

				put("Trang Hatyai", 148);
				put("Trang Pattani", 260);
				put("Trang Phuket", 312);
				put("Trang Suratthani", 226);
			}
		};

		for (int i = 0; i < n; i++) {
			String str = bf.readLine();

			int d = 0;
			String start = "Hatyai", end = "";
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'H') {
					end = "Hatyai";
				} else if (str.charAt(j) == 'P') {
					end = "Pattani";
				} else if (str.charAt(j) == 'S') {
					end = "Suratthani";
				} else if (str.charAt(j) == 'K') {
					end = "Phuket";
				} else {
					end = "Trang";
				}

				d += map.get(start + " " + end);

				start = end;
			}
			d += map.get(start + " " + "Hatyai");

			bw.write("Case " + (i + 1) + ": " + d + "\n");
		}
		bw.flush();
	}
}
