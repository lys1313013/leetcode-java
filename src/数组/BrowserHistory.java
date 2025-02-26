package 数组;

import java.util.ArrayList;
import java.util.List;

/**
 * 1472. 设计浏览器历史记录
 * https://leetcode.cn/problems/design-browser-history/description/?envType=daily-question&envId=2025-02-26
 */
class BrowserHistory {
    List<String> list;
    /*
     * 当前所在页面
     */
    int i = 0;

    public BrowserHistory(String homepage) {
        list = new ArrayList<>();
        list.add(homepage);
    }

    public void visit(String url) {
        i++;
        if (i == list.size()) {
            list.add(url);
        } else {
            // 一旦前进，就要把之前遗留的前进清楚
            list.set(i, url);
            while (list.size() > i + 1) {
                list.remove(i + 1);
            }
        }

    }

    public String back(int steps) {
        if (i - steps >= 0) {
            i -= steps;
            return list.get(i);
        } else {
            i = 0;
            return list.get(i);
        }
    }

    public String forward(int steps) {
        if (i + 1 + steps > list.size()) {
            i = list.size() - 1;
            return list.get(i);
        } else {
            i += steps;
            return list.get(i);
        }
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */