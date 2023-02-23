package Stack;

public class CustomStack {
    protected int data[];
    private static final int DEFAULT_SIZE = 10;

    int ptr = -1;

    public CustomStack() {
       this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) {
        if (isFull()) {
            return false;
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public boolean isFull() {
        return ptr == data.length - 1;
    }

    public int peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot peek form empty stack");
        }
        return data[ptr];
    }

    public int pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Cannot pop from empty stack");
        }
        return data[ptr--];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

}
