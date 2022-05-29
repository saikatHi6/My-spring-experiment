package org.practice;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public void reverseString(char[] s) {
        helper(0,s);
        for(int i=0;i<s.length;i++){
            System.out.print(s[i]);
        }
    }
    void helper(int index,char[] s){
        if(s.length%2==0 & index==s.length/2)
            return;
        if(s.length%2!=0 & index==s.length/2-1)
            return;
        helper(index+1,s);
        char temp = s[index];
        s[index] = s[s.length-1];
        s[s.length-1] = temp;
    }
}
