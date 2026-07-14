class Solution {
    public int lengthOfLastWord(String s) {
String[] words = s.trim().split(" ");
String LW = words[words.length - 1];
return LW.length();
    }}