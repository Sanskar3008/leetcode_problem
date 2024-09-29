class AllOne {
    private class Node {
        String key = "";
        int count = 0;
        Node next;
        Node prev;
    }

    private Node start;
    private Node end;
    private HashMap<String, Node> map;

    public AllOne() {
        map = new HashMap<>();
        start = new Node();
        end = new Node();
        start.next = end;
        end.prev = start;
    }
    
    public void inc(String key) {
        if (!map.containsKey(key)) {
            Node node = new Node();
            node.count = 1;
            node.key = key;
            start.next.prev = node;
            node.next = start.next;
            node.prev = start;
            start.next = node;
            map.put(key, node);
            return;
        }

        Node node = map.get(key);
        node.count++;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        Node cur = node.next;

        while (cur.count < node.count && cur != end) {
            cur = cur.next;
        }

        cur.prev.next = node;
        node.prev = cur.prev;
        cur.prev = node;
        node.next = cur;
    }
    
    public void dec(String key) {
        Node node = map.get(key);
        node.prev.next = node.next;
        node.next.prev = node.prev;

        if (node.count == 1) {
            map.remove(key);
            return;
        }

        node.count--;
        Node cur = node.prev;

        while (cur.count >= node.count && cur != start) {
            cur = cur.prev;
        }

        cur.next.prev = node;
        node.next = cur.next;
        cur.next = node;
        node.prev = cur;
    }
    
    public String getMaxKey() {
        return end.prev.key;
    }
    
    public String getMinKey() {
        return start.next.key;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */