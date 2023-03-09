import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _15558_ { // 점프 게임
	static int arr[][], n, k;
	static boolean visited[][], flag;
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		
		arr=new int[2][n];
		visited=new boolean[2][n];
		flag=false;
		
		String str=bf.readLine();
		String str2=bf.readLine();
		for(int i=0; i<n; i++) {
			arr[0][i]=str.charAt(i)-'0';
			if(arr[0][i]==0) visited[0][i]=true;
			arr[1][i]=str2.charAt(i)-'0';
			if(arr[1][i]==0) visited[1][i]=true;
		}
		search(0,0, 0);
		
		if(flag) System.out.println(1);
		else System.out.println(0);
	}

	private static void search(int x , int y, int i) {
		Queue<int[]>queue=new LinkedList<>();
		queue.add(new int [] {x,y,i});
		
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			int[] temp=queue.poll();
			if(temp[1]+1 > n || temp[1]+k >= n) { // 종료 조건
				flag=true;
				break;
			}
			if(!visited[temp[0]][temp[1]+1]) { // 한 칸 앞 이동
				visited[temp[0]][temp[1]+1]=true;
				queue.add(new int[] {temp[0], temp[1]+1, temp[2]+1});
			}
			if(temp[1]-1>=0 && !visited[temp[0]][temp[1]-1] && temp[1]-1>temp[2]) { // 한 칸 뒤로 이동
				visited[temp[0]][temp[1]-1]=true;
				queue.add(new int[] {temp[0], temp[1]-1, temp[2]+1});
			}
			// 반대편 줄로 점프
			if(temp[0]==0) {
				if(!visited[1][temp[1]+k]) {
					visited[1][temp[1]+k]=true;
					queue.add(new int[] {1,temp[1]+k, temp[2]+1});
				}
			}else if(temp[0]==1) {
				if(!visited[0][temp[1]+k]) {
					visited[0][temp[1]+k]=true;
					queue.add(new int[] {0, temp[1]+k, temp[2]+1});
				}
			}
		}
	}
}
