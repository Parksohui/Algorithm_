import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class _1730_ { // 판화
	static int x, y, n;
	static char arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(bf.readLine());

		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				arr[i][j]='.';
			}
		}
		
		String str = bf.readLine();

		x = 0;
		y = 0;
		boolean flag;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == 'D') {
				flag = DU(x + 1, y);
				if (flag) {
					x += 1;
				}
			} else if (c == 'R') {
				flag = RL(x, y + 1);
				if (flag) {
					y += 1;
				}
			} else if (c == 'L') {
				flag = RL(x, y - 1);
				if (flag) {
					y -= 1;
				}
			} else {
				flag = DU(x - 1, y);
				if (flag) {
					x -= 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				bw.write(arr[i][j]+"");
			}
			bw.write("\n");
		}
		bw.flush();
	}

	private static boolean DU(int a, int b) {
		if (a >= 0 && a < n && b >= 0 && b < n) {
			if (arr[x][y] == '-') {
				arr[x][y] = '+';
			} else if(arr[x][y] == '.'){
				arr[x][y] = '|';
			}

			if (arr[a][b] == '-') {
				arr[a][b] = '+';
			} else if(arr[a][b] == '.'){
				arr[a][b] = '|';
			}
			return true;
		}
		return false;
	}

	private static boolean RL(int a, int b) {
		if (a >= 0 && a < n && b >= 0 && b < n) {
			if (arr[x][y] == '|') {
				arr[x][y] = '+';
			} else if(arr[x][y] == '.'){
				arr[x][y] = '-';
			}

			if (arr[a][b] == '|') {
				arr[a][b] = '+';
			} else if(arr[a][b]=='.'){
				arr[a][b] = '-';
			}
			return true;
		}
		return false;
	}
}
