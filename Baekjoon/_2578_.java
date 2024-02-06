import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2578_ { // 빙고
	static int arr[][], line;
	static boolean check1, check2;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		line = 0;
		check1=false;
		check2=false;
		boolean flag = false;
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 1; j <= 5; j++) {
				int num = Integer.parseInt(st.nextToken());
				int position[] = find(num);

				if ((5 * i) + j >= 5) {
					bingo(position[0], position[1]);
					if (line >= 3) {
						flag = true;
						System.out.println((5 * i) + j);
						break;
					}
				}
			}
			if (flag) {
				break;
			}
		}
	}

	private static void bingo(int x, int y) {
		int cnt = 0;

		// 가로
		for (int i = 0; i < 5; i++) {
			if (arr[x][i] != -1) {
				break;
			}
			cnt += 1;
		}
		if(cnt==5) {
			line+=1;
		}

		// 세로
		cnt=0;
		for(int i=0; i<5; i++) {
			if(arr[i][y] !=-1) {
				break;
			}
			cnt+=1;
		}
		if(cnt==5) {
			line+=1;
		}

		// 대각선
		if(!check1 && arr[0][0]==-1 && arr[1][1]==-1 && arr[2][2]==-1 && arr[3][3]==-1 && arr[4][4]==-1) {
			check1=true;
			line+=1;
		}
		
		if(!check2 && arr[0][4]==-1 && arr[1][3]==-1 && arr[2][2]==-1 && arr[3][1]==-1 && arr[4][0]==-1) {
			check2=true;
			line+=1;
		}

	}

	private static int[] find(int num) {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[i][j] == num) {
					arr[i][j] = -1;
					return new int[] { i, j };
				}
			}
		}
		return null;
	}
}
