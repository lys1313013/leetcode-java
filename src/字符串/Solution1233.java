package 字符串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1233. 删除子文件夹
 */
class Solution1233 {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(folder);
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            String pre = ans.get(ans.size() - 1);
            if (pre.length() >= folder[i].length()) {
                ans.add(folder[i]);
            } else {
                if (folder[i].startsWith(pre) && folder[i].charAt(pre.length()) == '/') {
                    continue;
                } else {
                    ans.add(folder[i]);
                }
            }
        }
        return ans;
    }
}