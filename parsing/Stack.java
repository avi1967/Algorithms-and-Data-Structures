// Data Structure: Stack (Array-based)
// Time Complexity: O(1) for push/pop
// Space Complexity: O(n)
// Key Idea: LIFO discipline for parsing and evaluation

package parsing;

class Stack {

    private int top;
    private int[] data;

    Stack(int capacity) {
        data = new int[capacity];
        top = -1;
    }

    boolean isEmpty() {
        return top == -1;
    }

    void push(int value) {
        data[++top] = value;
    }

    int pop() {
        return data[top--];
    }
}
