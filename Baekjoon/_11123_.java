import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _11123_ { // 양 한마리... 양 두마리...
	static int arr[][], H, W;
	static boolean visited[][];
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T=Integer.parseInt(bf.readLine());
		for(int i=0; i<T; i++) {
			st=new StringTokenizer(bf.readLine());
			H=Integer.parseInt(st.nextToken()); // 높이
			W=Integer.parseInt(st.nextToken()); // 너비
			arr=new int[H][W];
			visited=new boolean[H][W];
			for(int j=0; j<H; j++) { // input
				String str=bf.readLine();
				for(int k=0; k<W; k++) {
					arr[j][k]=str.charAt(k);
					if(arr[j][k]=='.') visited[j][k]=true;
				}
			}
			int result=0;
			for(int j=0; j<H; j++) {
				for(int k=0; k<W; k++) {
					if(!visited[j][k]) {
						result+=1;
						search(j,k);
					}
				}
			}
			System.out.println(result);
		}
	}
	private static void search(int j, int k) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {j,k});
		visited[j][k]=true;
		
		while(!queue.isEmpty()){
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<H && y>=0 && y<W && !visited[x][y]) {
					visited[x][y]=true;
					queue.add(new int[] {x,y});
				}
			}
		}
	}
}
