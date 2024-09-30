import java.util.Stack;

class CustomStack {

    Stack<Integer> newStack;
    int count;
    int maxSize1;

    public CustomStack(int maxSize) {
        this.maxSize1 = maxSize;
        this.newStack = new Stack<>();
        this.count = 0;
    }

    public void push(int x) {
        if (count < maxSize1) {
            newStack.push(x);
            count++;
        }
    }

    public int pop() {
        if (count > 0) {
            count--;
            return newStack.pop();
        }
        return -1;
    }

    public void increment(int k, int val) {
        // Only increment the bottom k elements
        int limit = Math.min(k, count);
        for (int i = 0; i < limit; i++) {
            newStack.set(i, newStack.get(i) + val);
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */