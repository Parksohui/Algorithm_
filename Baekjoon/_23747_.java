import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _23747_ { // 와드
	static char arr[][];
	static boolean visited[][];
	static int dx[]= {-1,1,0,0};
	static int dy[]= {0,0,-1,1};
	static int r,c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		arr=new char[r][c];
		visited=new boolean[r][c];
		for(int i=0; i<r; i++) {
			String str=bf.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j]=str.charAt(j);
			}
		}
		
		st=new StringTokenizer(bf.readLine());
		int hr=Integer.parseInt(st.nextToken())-1;
		int hc=Integer.parseInt(st.nextToken())-1;
		
		String str=bf.readLine();
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i)=='W') {
				bfs(hr, hc);
			}else if(str.charAt(i)=='U') {
				hr-=1;
			}else if(str.charAt(i)=='D') {
				hr+=1;
			}else if(str.charAt(i)=='L') {
				hc-=1;
			}else if(str.charAt(i)=='R') {
				hc+=1;
			}
		}
		
		visited[hr][hc]=true;
		for(int i=0; i<4; i++) {
			int x=hr+dx[i];
			int y=hc+dy[i];
			if(x>=0 && x<r && y>=0 && y<c && !visited[x][y]) {
				visited[x][y]=true;
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(visited[i][j]) {
					bw.write(".");
				}else {
					bw.write("#");
				}
			}
			bw.write("\n");
		}
		bw.flush();
	}
	private static void bfs(int hr, int hc) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {hr,hc});
		visited[hr][hc]=true;
		
		while(!queue.isEmpty()) {
			int temp[]=queue.poll();
			for(int i=0; i<4; i++) {
				int x=temp[0]+dx[i];
				int y=temp[1]+dy[i];
				if(x>=0 && x<r && y>=0 && y<c && !visited[x][y]) {
					if(arr[temp[0]][temp[1]]==arr[x][y]) {
						visited[x][y]=true;
						queue.add(new int[] {x,y});
					}
				}
			}
		}
	}
}
