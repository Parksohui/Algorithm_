import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _26169_ { // 세 번 이내에 사과를 먹자
	static int arr[][];
	static boolean result, visited[][];
	static int dx[] = { -1, 1, 0, 0 };
	static int dy[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		arr = new int[5][5];
		visited=new boolean[5][5];
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(bf.readLine());
			for (int j = 0; j < 5; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==-1) visited[i][j]=true;
			}
		}

		st = new StringTokenizer(bf.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		result = false;
		int num=0;
		if(arr[r][c]==1) num+=1;
		visited[r][c]=true;
		dfs(r, c, 0, num);

		if (result)
			System.out.println("1");
		else
			System.out.println("0");

	}

	private static void dfs(int r, int c, int cnt, int num) {
		if (cnt == 3) {
			if (num >= 2) {
				result = true;
				return;
			}
		}
		for(int i=0; i<4; i++) {
			int x=r+dx[i];
			int y=c+dy[i];
			if(x>=0 && x<5 && y>=0 && y<5 && !visited[x][y]) {
				visited[x][y]=true;
				if(arr[x][y]==1) {
					dfs(x,y,cnt+1, num+1);
				}else {
					dfs(x,y,cnt+1, num);
				}
				visited[x][y]=false;
			}
		}
	}
}
