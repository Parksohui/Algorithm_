import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class _2303_ { // 숫자 게임
	static int arr[], arr_temp[], max_num;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr=new int[5];
		arr_temp=new int[3];
		visited=new boolean[5];
		
		int n=Integer.parseInt(bf.readLine());
		int value=-1;
		int result=-1;
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(bf.readLine());
			max_num=-1;
			for(int j=0; j<5; j++) {
				arr[j]=Integer.parseInt(st.nextToken());
			}
			search(0);
			if(value<=max_num) {
				result=i+1;
				value=max_num;
			}
		}
		System.out.println(result);
	}

	private static void search(int idx) {
		if(idx==3) {
			int value=0;
			for(int i=0; i<3; i++) {
				value+=arr_temp[i];
			}
			value%=10;
			if(value>=max_num) max_num=value%10;
			return;
		}
		for(int i=0; i<5; i++) {
			if(!visited[i]) {
				visited[i]=true;
				arr_temp[idx]=arr[i];
				search(idx+1);
				visited[i]=false;
			}
		}
	}
}
