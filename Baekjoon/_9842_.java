import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class _9842_ { // Prime

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bf.readLine());

		boolean arr[] = new boolean[100000001];
		arr[0] = true;
		arr[1] = true;
		for (int i = 2; i <= Math.sqrt(100000001); i++) {
			if (!arr[i]) {
				for (int j = i + i; j < 100000001; j += i) {
					arr[j] = true;
				}
			}
		}

		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 2; i < 100000001; i++) {
			if (!arr[i]) {
				list.add(i);
			}
		}
		
		System.out.println(list.get(n-1));
	}
}
