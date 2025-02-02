//22BCS10552
//Harsh Kumar Singh

class MyQueue {
    class Stack{
        public int arr[];
        public int top;
        public int size;

        Stack(int capacity){
            arr=new int[capacity];
            size=capacity;
            top =-1;
        }
        public void push(int x) {
            if (top == size - 1) {
                int[] newArr = new int[size * 2];
                System.arraycopy(arr, 0, newArr, 0, size);
                arr = newArr;
                size = size*2;
            }
            arr[++top] = x;
        }
        public int pop() {
            if (empty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return arr[top--];
        }
        public int peek() {
            if (empty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return arr[top];
        }
        public boolean empty() {
            return top == -1;
        }
    }
    public Stack stack1;
    public Stack stack2;

    public MyQueue() {
        stack1 = new Stack(10);
        stack2 = new Stack(10);
        
    }
    
    public void push(int x) {
        stack1.push(x);
        
    }
    
    public int pop() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
        
    }
    
    public int peek() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
        
    }
    
    public boolean empty() {
        return stack1.empty() && stack2.empty();
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
