package stack;

public class MinStack {
    int[] arr = new int[(int) (3 * Math.pow(10, 4))];
    int size = 0;
    int[] mins = new int[(int) (3 * Math.pow(10, 4))];
    int minSize = 0;

    public MinStack() {

    }

    public void push(int val) {
        if (size == 0) {
            arr[0] = val;
            size++;
            mins[0] = val;
            minSize++;
        } else {
            arr[size] = val;
            if (mins[minSize - 1] >= val) {
                mins[minSize] = val;
                minSize++;
            }
            size++;
        }
    }

    public void pop() {
        if (mins[minSize - 1] == arr[size - 1]) {
            minSize--;
        }
        size--;
    }

    public int top() {
        return size == 0 ? null : arr[size - 1];
    }

    public int getMin() {
        return minSize == 0 ? null : mins[minSize - 1];
    }
}

class A {
    public static void main(String[] args) {
        MinStack stack = new MinStack();
        stack.push(0);
        stack.push(1);
        stack.push(0);
        System.out.println(stack.getMin());
        stack.pop();
        stack.top();
        System.out.println(stack.getMin());
    }
}
