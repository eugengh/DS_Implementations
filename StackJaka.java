public class StackJaka {

    public class Node{
        private int data;
        private Node next;
        public Node(int data)
        {
            this.data = data;
        }
    }

    private Node top;

    public boolean isEmpty()
    {
        return top == null;
    }

    public int peek()
    {
        return top.data;
    }

    public void push(int data)
    {
        Node node = new Node(data);
        node.next = top;
        top = node;

    }

    public int pop()
    {
        int data = top.data;
        top = top.next;     
        return data;
    }
    public static void main(String[] args) {
        
    }
}
