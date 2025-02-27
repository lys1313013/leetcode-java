package 字符串;

/**
 * w
 * w
 *
 * 注意点：只用String api会超时
 */
class TextEditor {
    StringBuilder str;
    /*
     * 光标位置
     * i = 0 代表前面没有字符
     * i = 1 代表前面有一个字符
     */
    int i;

    public TextEditor() {
        str = new StringBuilder();
        i = 0;
    }

    public void addText(String text) {
        str.insert(i, text);
        i += text.length();
    }

    public int deleteText(int k) {
        int start = Math.max(0, i - k);
        str.delete(start, i);
        int deleteCnt = i - start;
        i = start;
        return deleteCnt;
    }

    public String cursorLeft(int k) {
        i = Math.max(i - k, 0);
        final char[] chs = new char[Math.min(10, i)];
        int start = i - chs.length;
        for (int i = 0; i < chs.length; i++) {
            chs[i] = str.charAt(i + start);
        }
        return String.valueOf(chs);
    }

    public String cursorRight(int k) {
        i = Math.min(i + k, str.length());
        final char[] chs = new char[Math.min(10, i)];
        int start = i - chs.length;
        for (int i = 0; i < chs.length; i++) {
            chs[i] = str.charAt(i + start);
        }
        return String.valueOf(chs);
    }
}