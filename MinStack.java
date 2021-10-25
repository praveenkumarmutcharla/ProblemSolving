public final class MinStack {
    private StackNode stack;
    private StackNode minNodes;

    public MinStack() {
    }

    public void push(final int val) {
        stack = new StackNode(val, stack);

        if (minNodes == null || minNodes.value() >= val) {
            minNodes = new StackNode(val, minNodes);
        }
    }

    public void pop() {
        if (isEmpty()) {
            return;
        }

        var curr = stack.value();
        stack = stack.prev();

        if (minNodes != null && minNodes.value() == curr) {
            minNodes = minNodes.prev();
        }
    }

    public int top() {
        return isEmpty() ? -1 : stack.value();
    }

    public int getMin() {
        return isMinEmpty() ? -1 : minNodes.value();
    }

    private boolean isEmpty() {
        return null == stack;
    }

    private boolean isMinEmpty() {
        return null == minNodes;
    }

    private static final class StackNode {
        private final int value;
        private final StackNode prev;

        StackNode(int value, StackNode p) {
            this.value = value;
            this.prev = p;
        }

        int value() {
            return value;
        }

        StackNode prev() {
            return prev;
        }
    }
}