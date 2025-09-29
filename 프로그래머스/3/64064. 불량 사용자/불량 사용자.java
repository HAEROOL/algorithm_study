import java.util.*;

class Solution {
    static String[] bans, users;
    static Set<Set<String>> resultSet = new HashSet<>();
    
    static void combination(int banIdx, Set<String> selected) {
        if (banIdx == bans.length) {
            resultSet.add(new HashSet<>(selected));
            return;
        }
        for (String user : users) {
            if (selected.contains(user)) continue;
            if (isSame(user, bans[banIdx])) {
                selected.add(user);
                combination(banIdx + 1, selected);
                selected.remove(user);
            }
        }
    }
    
    static boolean isSame(String user, String ban) {
        if (user.length() != ban.length()) return false;
        
        for (int i = 0; i < user.length(); i++) {
            if (ban.charAt(i) == '*') continue;
            if (user.charAt(i) != ban.charAt(i)) return false;
        }
        return true;
    }
    
    public int solution(String[] user_id, String[] banned_id) {
        bans = banned_id;
        users = user_id;
        resultSet = new HashSet<>();
        
        combination(0, new HashSet<>());
        
        return resultSet.size();
    }
}