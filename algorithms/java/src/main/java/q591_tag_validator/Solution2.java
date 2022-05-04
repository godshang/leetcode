package q591_tag_validator;

public class Solution2 {

    private String code;
    private int i;
    private int n;

    private void error() {
        throw new RuntimeException();
    }

    private void match(char c) {
        if (i >= n || c != code.charAt(i)) {
            error();
        }
        i++;
    }

    private void match(String s) {
        for (char c : s.toCharArray()) {
            match(c);
        }
    }

    private String tagNameBegin() {
        match('<');
        int start = i;
        while (i < n && Character.isUpperCase(code.charAt(i))) i++;
        int end = i;
        if (end - start < 1 || end - start > 9) {
            error();
        }
        match('>');
        return code.substring(start, end);
    }

    private void tagNameEnd(String tag) {
        match("</");
        for (char c : tag.toCharArray()) {
            match(c);
        }
        match('>');
    }

    private void cdata() {
        match("<![CDATA[");
        int state = 0;
        while (true) {
            if (i >= n) error();
            char c = code.charAt(i);
            switch (c) {
                case ']':
                    if (state <= 1) ++state;
                    else state = 2;
                    break;
                case '>':
                    if (state == 2) {
                        state = 3;
                        break;
                    }
                default:
                    state = 0;
                    break;
            }
            i++;
            if (state == 3) break;
        }
    }

    private void tag() {
        String tag = tagNameBegin();
        int state = 0;
        while (i < n) {
            char c = code.charAt(i++);
            switch (state) {
                case 0:
                    if (c == '<') {
                        state = 1;
                    }
                    break;
                case 1:
                    i -= 2;
                    switch (c) {
                        case '/':
                            tagNameEnd(tag);
                            return;
                        case '!':
                            cdata();
                            break;
                        default:
                            tag();
                            break;
                    }
                default:
                    state = 0;
                    break;
            }
        }
        error();
    }

    public boolean isValid(String code) {
        this.code = code;
        this.n = code.length();
        try {
            tag();
            return i == n;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(solution2.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
//        System.out.println(solution2.isValid("<A>  <B> </A>   </B>"));
    }
}
