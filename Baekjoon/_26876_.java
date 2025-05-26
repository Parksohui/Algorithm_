import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _26876_ { // New Time

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		String a = bf.readLine();
		String b = bf.readLine();

		int time[] = new int[3];
		time[0] = Integer.parseInt(a.split(":")[0]);
		time[1] = Integer.parseInt(a.split(":")[1]);

		int time2[] = new int[3];
		time2[0] = Integer.parseInt(b.split(":")[0]);
		time2[1] = Integer.parseInt(b.split(":")[1]);

		int result = 0;

		if (time[1] > time2[1]) {
			time2[1] += 60;
			time2[0] -= 1;
			if (time2[0] < 0) {
				time2[0] = 23;
			}
		}

		result += time2[1] - time[1];

		if (time[0] > time2[0]) {
			time2[0] += 24;
		}
		result += time2[0] - time[0];

		System.out.println(result);
	}
}
