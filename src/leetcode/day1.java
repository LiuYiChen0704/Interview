package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class day1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int answer = s.lengthOfLongestSubstring(
				"tmmzuxt");
		System.out.println(answer);

	}

}

class Solution1 {
	/*
	 * int check(String s){ int len=s.length(); Set<Character> set=new
	 * HashSet<Character>(); int i; for(i=0;i<len;i++){ set.add(s.charAt(i)); }
	 * if(set.size()!=len) return 0; return 1; } public int
	 * lengthOfLongestSubstring(String s) { int tlen=s.length(); int i,j;
	 * for(i=tlen;i>=0;i--){ for(j=0;j<=tlen-i;j++){ String
	 * substr=s.substring(j,j+i); if(check(substr)==1) return i;
	 * 
	 * } } return 0; }
	 */

	
	/*
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		int i = 0, j = 0;
		Map<Character, Integer> map = new HashMap<>();
		while (i < n && j < n) {
			char j_ch=s.charAt(j);
			if (map.containsKey(j_ch)){
				int inx=map.get(j_ch);
				if(inx>=i)
					i = inx + 1;
			}
			map.put(j_ch, j);
			j++;
			ans = Math.max(ans, j - i);
		}

		return ans;

	}
	
	*/
	
	
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int ans = 0;
		int i = 0, j = 0;
		int[] inx=new int[128];
		while(i<n && j<n){
			char j_ch=s.charAt(j);
			if(inx[j_ch]>0)
				i=Math.max(i,inx[j_ch]);
			inx[j_ch]=j+1;
			ans=Math.max(ans, j-i+1);
			j++;
		}
		return ans;

	}
}