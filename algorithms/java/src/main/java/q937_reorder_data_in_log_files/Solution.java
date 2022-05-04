package q937_reorder_data_in_log_files;

import common.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    class Log {
        String raw;
        int idx;
        String identifier;
        String content;
        int type;

        public Log(String raw, int idx) {
            this.raw = raw;
            this.idx = idx;
            this.identifier = raw.substring(0, raw.indexOf(" "));
            this.content = raw.substring(raw.indexOf(" ") + 1);
            this.type = Character.isLetter(content.charAt(0)) ? 0 : 1;
        }
    }

    public String[] reorderLogFiles(String[] logs) {
        List<Log> logList = new ArrayList<>();
        for (int i = 0; i < logs.length; i++) {
            logList.add(new Log(logs[i], i));
        }
        Collections.sort(logList, new Comparator<Log>() {
            @Override
            public int compare(Log a, Log b) {
                if (a.type != b.type) {
                    return a.type - b.type;
                }
                if (a.type == 1) {
                    return a.idx - b.idx;
                }
                return a.content.equals(b.content) ? a.identifier.compareTo(b.identifier)
                        : a.content.compareTo(b.content);
            }
        });
        List<String> ans = logList.stream().map(e -> e.raw).collect(Collectors.toList());
        return ans.toArray(new String[ans.size()]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Util.printArray(solution.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"}));
    }


}
