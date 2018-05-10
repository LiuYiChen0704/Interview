package leetcode;
import java.util.Map;
import java.util.HashMap;
public class Max_points_on_a_line {
	public int gcd(int a,int b){
		if(b==0)
			return a;
		return gcd(b,a%b);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Max_points_on_a_line s=new Max_points_on_a_line();
		System.out.println(s.gcd(-3,12));
		String a="b"+String.valueOf(12.3);
		System.out.println(a);
		Map<String,Integer> map=new HashMap<>();
		
	}

}
