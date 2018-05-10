package leetcode;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
public class Day2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Solution s = new Solution();
		System.out.println(s.check("abcda"));
		String result = s.longestPalindrome("abcda");*/
		
	
		
	}

}
class Solution {
	int check(String s){
		int slen=s.length();
		if(slen==1){
			return 1;//true
		}
		int start,end;
		for(start=0,end=slen-1;start<end;start++,end--){
			if(s.charAt(start)!=s.charAt(end))
				return 0;//false
			
		}
		return 1;//true
	}
    public String longestPalindrome(String s) {
        int slen=s.length();
        Map<Character,List<Integer>> map=new HashMap<>();
        int i;
        for(i=0;i<slen;i++){
        	char ichar=s.charAt(i);
        	List<Integer> list=map.get(ichar);
        	if(list==null){
        		List<Integer> newlist=new ArrayList<>();
        		newlist.add(i);
        		map.put(ichar,newlist);
        	}else{
        		list.add(i);
        		map.put(ichar,list);
        	}
        }//end for
        for(Character key:map.keySet()){
        	List<Integer> list=map.get(key);
        	Collections.sort(list);
        	map.put(key,list);
        }
        int j;
        int maxlen=0;
        String longestPalindrome="";
        for(i=0;i<slen;i++){
        	int start=i;
        	char ichar=s.charAt(i);
        	List<Integer> list=map.get(ichar);
        	for(j=0;j<list.size();j++){
        		if(list.get(j)>=i){
        			int end=list.get(j);
        			if(check(s.substring(start,end+1))==1){
        				if(maxlen<end-start+1){
        					maxlen=end-start+1;
        					longestPalindrome=s.substring(start,end+1);
        				}
        				
        			}
        		}
        	}
        }
        return longestPalindrome;
    }
}