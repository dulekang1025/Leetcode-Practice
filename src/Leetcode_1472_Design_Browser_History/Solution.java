package Leetcode_1472_Design_Browser_History;

class BrowserHistory {

    class ListNode{
        String val;
        ListNode next;
        ListNode prev;
        public ListNode(String val){
            this.val = val;
        }
    }

    ListNode cur;
    ListNode head;

    public BrowserHistory(String homepage) {
        this.head = new ListNode(homepage);
        cur = head;
    }

    public void visit(String url) {
        if(cur.next != null){
            ListNode p = cur.next;
            cur.next = null;
            p.prev = null;
        }
        ListNode newPage = new ListNode(url);
        cur.next = newPage;
        newPage.prev = cur;
        cur = cur.next;
    }

    public String back(int steps) {
        while(steps > 0 && cur.prev != null){
            cur = cur.prev;
            steps--;
        }
        return cur.val;
    }

    public String forward(int steps) {
        while(steps > 0 && cur.next != null){
            cur = cur.next;
            steps--;
        }
        return cur.val;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */
