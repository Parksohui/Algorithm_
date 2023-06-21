import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class _11478_ { // 서로 다른 부분 문자열의 개수

	public static void main(String[] args) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		
		String str=bf.readLine();
		HashSet<String> set=new HashSet<>();
		
		for(int i=0; i<=str.length(); i++) {
			for(int j=i; j<=str.length(); j++) {
				if(i==j) continue;
				set.add(str.substring(i,j));
			}
		}
		System.out.println(set.size());
	}

}
