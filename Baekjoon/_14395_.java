import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class _14395_ { // 4연산

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		
		long s=Integer.parseInt(st.nextToken());
		long t=Integer.parseInt(st.nextToken());
		
		HashSet<Long>set=new HashSet<>();
		String result="";

		// s와 t가 같은 경우
		if(s==t) System.out.println(0);
		else { // s와 t가 다른 경우
			Queue<Info>queue=new LinkedList<>();
			queue.add(new Info(s, ""));
			set.add(s);
			
			while(!queue.isEmpty()) {
				Info info=queue.poll();
				long arr[]= {info.value*info.value,info.value+info.value, 0, 1}; // *, +, -, /
				for(int i=0; i<4; i++) {
					if(!set.contains(arr[i])) {
						String str=info.cal;
						if(i==3 && info.value==0) break;
						if(i==0)str+="*";
						else if(i==1) str+="+";
						else if(i==2) str+="-";
						else if(i==3) str+="/";
						if(arr[i]==t) {
							result=str;
							break;
						}
						set.add(arr[i]);
						queue.add(new Info(arr[i], str));
					}
				}
				if(!result.equals("")) break;
			}
			if(result.equals("")) System.out.println(-1); // 바꿀 수 없는 경우
			else System.out.println(result);
		}
	}
	
	static class Info{
		long value; // 값
		String cal; // 방법
		public Info(long value, String cal) {
			this.value=value;
			this.cal=cal;
		}
	}
}
