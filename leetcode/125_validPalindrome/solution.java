/**
 * Author: Grant Nasution
 * leetcode #125 Determine whether the given string is a valid palindrome considering only alphanumeric characters
 */

class Solution {
    public boolean isPalindrome(String s) {
        char[] str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase().toCharArray();
        if(str.length <= 1) {
            return true;
        }
        
        char[] queue = new char[str.length / 2];
        for(int i = 0; i < str.length/2; ++i) {
            queue[i] = str[i];
        }
        for(int i = 0; i < str.length/2; ++i) {
            if(str[str.length - 1 - i] != queue[i]) {
                return false;
            }
        }
        return true;
    }
}
