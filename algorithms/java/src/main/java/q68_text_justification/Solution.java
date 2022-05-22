package q68_text_justification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; ) {
            line.clear();
            line.add(words[i]);
            int wordWidth = words[i++].length();
            while (i < n && wordWidth + 1 + words[i].length() <= maxWidth) {
                wordWidth += 1 + words[i].length();
                line.add(words[i++]);
            }

            if (i == n) { // 最后一行
                ans.add(processTailSpace(line, maxWidth));
                break;
            }

            int cnt = line.size();
            if (cnt == 1) { // 每行只有一个词
                ans.add(processTailSpace(line, maxWidth));
                continue;
            }

            // 一般情况
            ans.add(processCommon(line, wordWidth, maxWidth));
        }

        return ans;
    }

    private String processCommon(List<String> line, int lineWidth, int maxWidth) {
        int cnt = line.size();
        int wordWidth = lineWidth - (cnt - 1); // 单词总长度
        int spaceWidth = maxWidth - wordWidth; // 所需空格长度
        int spaceItemWidth = spaceWidth / (cnt - 1); // 单词之间所需的空格数
        String spaceItem = String.join("", Collections.nCopies(spaceItemWidth, " "));

        StringBuilder sb = new StringBuilder();
        for (int k = 0, sum = 0; k < cnt; k++) {
            sb.append(line.get(k));
            if (k == cnt - 1) break;
            sb.append(spaceItem);
            sum += spaceItemWidth;
            int remain = cnt - k - 1 - 1;
            if (remain * spaceItemWidth + sum < spaceWidth) {
                sb.append(" ");
                sum++;
            }
        }
        return sb.toString();
    }

    private String processTailSpace(List<String> line, int maxWidth) {
        StringBuilder sb = new StringBuilder(line.get(0));
        for (int k = 1; k < line.size(); k++) {
            sb.append(" ").append(line.get(k));
        }
        while (sb.length() < maxWidth) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
        System.out.println(solution.fullJustify(new String[]{"What", "must", "be", "acknowledgment", "shall", "be"}, 16));
        System.out.println(solution.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20));
    }
}
