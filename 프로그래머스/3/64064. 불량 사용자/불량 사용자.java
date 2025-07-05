import java.util.*;

class Solution {
    static String[] userId, bannedId;
    static boolean[] used;       // userId 중복 사용 방지
    static Set<Set<String>> results = new HashSet<>();

    // 불량패턴 매칭 함수: '*'는 정확히 한 글자 와일드카드
    static boolean isBad(String pat, String id) {
        if (pat.length() != id.length()) return false;
        for (int i = 0; i < pat.length(); i++) {
            char pc = pat.charAt(i), uc = id.charAt(i);
            if (pc != '*' && pc != uc) return false;
        }
        return true;
    }

    // bannedId 순서대로 하나씩 대응할 유저를 골라보는 DFS
    static void dfs(int idx, Set<String> picked) {
        if (idx == bannedId.length) {
            // bannedId 전부 매칭 완료 → 결과 집합에 추가
            results.add(new HashSet<>(picked));
            return;
        }
        String pat = bannedId[idx];
        for (int i = 0; i < userId.length; i++) {
            if (used[i]) continue;
            if (isBad(pat, userId[i])) {
                used[i] = true;
                picked.add(userId[i]);

                dfs(idx + 1, picked);

                used[i] = false;
                picked.remove(userId[i]);
            }
        }
    }

    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        used = new boolean[userId.length];

        dfs(0, new HashSet<>());
        return results.size();
    }
}