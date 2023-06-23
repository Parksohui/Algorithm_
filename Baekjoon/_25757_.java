import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class _25757_ { // 임스와 함께하는 미니게임

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		int n=Integer.parseInt(st.nextToken());
		char game=st.nextToken().charAt(0);
		
		HashSet<String> set=new HashSet<>();
		for(int i=0; i<n; i++) {
			String str=bf.readLine();
			set.add(str);
		}
		
		int result=0;
		if(game=='Y') {
			result=set.size();
		}else if(game=='F') {
			result=set.size()/2;
		}else if(game=='O') {
			result=set.size()/3;
		}
		System.out.println(result);
	}

}
