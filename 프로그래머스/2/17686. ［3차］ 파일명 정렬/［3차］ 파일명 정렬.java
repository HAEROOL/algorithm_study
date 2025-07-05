import java.util.*;

class Solution {
    static String[] parseString(String file){
        // 1) res를 빈 문자열로 초기화
        String[] res = {"", "", ""};
        int state = 0;  // 0=head, 1=number, 2=tail

        for (char c : file.toCharArray()) {
            if (state == 0 && Character.isDigit(c)) {
                state = 1;
            } else if (state == 1 && !Character.isDigit(c)) {
                state = 2;
            }

            if (state == 0)       res[0] += c;
            else if (state == 1)  res[1] += c;
            else                  res[2] += c;
        }
        return res;
    }

    static class File {
        String head, headLower, number, tail;
        int     id;
        File(String h, String num, String t, int idx) {
            head       = h;
            headLower  = h.toLowerCase();
            number     = num;
            tail       = t;
            id         = idx;
        }
        String original() { return head + number + tail; }
    }

    public String[] solution(String[] files) {
        List<File> list = new ArrayList<>();
        for (int i = 0; i < files.length; i++) {
            String[] p = parseString(files[i]);
            list.add(new File(p[0], p[1], p[2], i));
        }

        // 안정 정렬 보장되는 List.sort()
        list.sort((a, b) -> {
            int cmp = a.headLower.compareTo(b.headLower);
            if (cmp != 0) return cmp;

            int na = Integer.parseInt(a.number);
            int nb = Integer.parseInt(b.number);
            if (na != nb) return na - nb;

            // HEAD 같고 숫자 값도 같으면, 입력 순서
            return a.id - b.id;
        });

        String[] answer = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).original();
        }
        return answer;
    }
}