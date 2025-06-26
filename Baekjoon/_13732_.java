import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.OutputStreamWriter;

public class _13732_ { // Falling Apples

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		char arr[][] = new char[r][c];
		Stack<int[]> stack = new Stack<>();

		for (int i = 0; i < r; i++) {
			String str = bf.readLine();
			for (int j = 0; j < c; j++) {
				if (str.charAt(j) == 'a') {
					stack.add(new int[] { i, j });
					arr[i][j]='.';
				}else {
					arr[i][j] = str.charAt(j);
				}
				
			}
		}

		while (!stack.isEmpty()) {
			int apple[] = stack.pop();
			int position = apple[0];
			for (int i = apple[0] + 1; i < r; i++) {
				if(arr[i][apple[1]]=='.') {
					position=i;
				}else {
					break;
				}
			}
			arr[position][apple[1]] = 'a';
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				bw.write(arr[i][j]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
}