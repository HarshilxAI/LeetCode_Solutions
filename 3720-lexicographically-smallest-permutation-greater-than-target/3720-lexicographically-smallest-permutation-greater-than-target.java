class Solution {
    public String lexGreaterPermutation(String s, String target) {

        int n = s.length();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[s.charAt(i) - 'a']++;
        }
        char[] ans = new char[n];
        for (int i = 0; i < n; i++) {
            int cur = target.charAt(i) - 'a';
            if (freq[cur] > 0) {
                ans[i] = target.charAt(i);
                freq[cur]--;
            } else {
                int bigger = -1;
                for (int j = cur + 1; j < 26; j++) {
                    if (freq[j] > 0) {
                        bigger = j;
                        break;
                    }}
                if (bigger != -1) {
                    ans[i] = (char)('a' + bigger);
                    freq[bigger]--;
                    int pos = i + 1;
                    for (int j = 0; j < 26; j++) {
                        while (freq[j] > 0) {
                            ans[pos] = (char)('a' + j);
                            pos++;
                            freq[j]--;
                        }}
                    return new String(ans);
                }
                for (int p = i - 1; p >= 0; p--) {
                    freq[ans[p] - 'a']++;
                    int old = target.charAt(p) - 'a';
                    bigger = -1;
                    for (int j = old + 1; j < 26; j++) {
                        if (freq[j] > 0) {
                            bigger = j;
                            break;
                        }}
                    if (bigger != -1) {
                        ans[p] = (char)('a' + bigger);
                        freq[bigger]--;
                        int pos = p + 1;
                        for (int j = 0; j < 26; j++) {
                            while (freq[j] > 0) {
                                ans[pos] = (char)('a' + j);
                                pos++;
                                freq[j]--;
                            }}
                        return new String(ans);
                    }}
                return "";
            }}
        for (int p = n - 1; p >= 0; p--) {
            freq[ans[p] - 'a']++;
            int old = target.charAt(p) - 'a';
            int bigger = -1;
            for (int j = old + 1; j < 26; j++) {
                if (freq[j] > 0) {
                    bigger = j;
                    break;
                }}
            if (bigger != -1) {
                ans[p] = (char)('a' + bigger);
                freq[bigger]--;
                int pos = p + 1;
                for (int j = 0; j < 26; j++) {
                    while (freq[j] > 0) {
                        ans[pos] = (char)('a' + j);
                        pos++;
                        freq[j]--;
                    }}
                return new String(ans);
            }}
        return "";
    }}