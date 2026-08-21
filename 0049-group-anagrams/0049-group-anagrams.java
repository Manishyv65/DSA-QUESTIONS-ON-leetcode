class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        for (String s : strs) {

            boolean found = false;

            // Existing groups check karo
            for (List<String> group : result) {

                // Group ke first string se compare karo
                if (isAnagram(s, group.get(0))) {
                    group.add(s);
                    found = true;
                    break;
                }
            }

            // Kisi group mein nahi mila
            if (!found) {
                List<String> newGroup = new ArrayList<>();
                newGroup.add(s);
                result.add(newGroup);
            }
        }

        return result;
    }

    private boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}