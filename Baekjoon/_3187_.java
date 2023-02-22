import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _3187_ {
	static char arr[][];
	static boolean visited[][];
	static int sheep, wolf, r, c;
	static int[] dx= {-1,1,0,0};
	static int[] dy= {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(bf.readLine());
		
		r=Integer.parseInt(st.nextToken());
		c=Integer.parseInt(st.nextToken());
		
		arr=new char[r][c];
		visited=new boolean[r][c];
		for(int i=0; i<r; i++) { // inputs
			String str=bf.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j]=str.charAt(j);
				if(arr[i][j]=='#') visited[i][j]=true;
			}
		}
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(!visited[i][j]) {
					visited[i][j]=true;
					search(i,j);
				}
			}
		}
		System.out.println(sheep +" "+ wolf);
	}
	
	private static void search(int i, int j) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int[] {i,j});
		
		int sheep_temp=0, wolf_temp=0;
		
		if(arr[i][j]=='v') wolf_temp+=1;
		else if(arr[i][j]=='k') sheep_temp+=1;
		
		while(!queue.isEmpty()) {
			int[] temp=queue.poll();
			for(int k=0; k<4; k++) {
				int x=temp[0]+dx[k];
				int y=temp[1]+dy[k];
				if(x>=0 && x<r && y>=0 && y<c && !visited[x][y]) {
					visited[x][y]=true;
					queue.add(new int[] {x,y});
					if(arr[x][y]=='v') wolf_temp+=1;
					else if(arr[x][y]=='k') sheep_temp+=1;
				}
			}
		}
		if(sheep_temp>wolf_temp) sheep+=sheep_temp;
		else wolf+=wolf_temp;	
	}
}
