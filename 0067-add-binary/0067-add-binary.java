class Solution {
    public String addBinary(String a, String b) {

        String ans = "";

int n = a.length() - 1;
int m = b.length() - 1;
int carry = 0;
 while (n>=0 || m>=0 || carry!=0) {

     int sum = carry;
 if (n>=0) {
      sum=sum+(a.charAt(n)-'0');
       n--;
   }
  if (m>=0) {
           sum= sum+(b.charAt(m) -'0');
         m--;
            }

            ans = (sum%2) +ans;
            carry = sum/ 2;
        }

return ans;
    }}