import java.util.LinkedList;

public class LinkedListJaka<Type extends Comparable<? super Type>> {

    
    private class Node<Type extends Comparable<? super Type>> {
        private Type data;
        private Node next;

        public Node(Type data) {
            this.data = data;
            this.next = null;
        }
        private Type getData()
        {
            return data;
        }

        private void setData(Type data)
        {
            this.data = data;
        }
        private Node getNext()
        {
            return next;
        }
        private void setNext(Node next)
        {
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListJaka() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFront(Type data) {
        Node node = new Node(data);
        if(head == null)
        {
            head = tail = node;
        }
        else
        {
            node.setNext(head);
            head = node;
        }
        size++;
    }

    public void addBack(Type data) {
        Node node = new Node(data);
        if(head == null)
        {
            head = tail = node;
        }
        else
        {
            tail.setNext(node);
            tail = node;
        }
        size++;
    }

    public void add(Type data, int index) {
        if(index == 0)
        {
            addFront(data);
        } else if (index == size)    {
            addBack(data);
        }   else{
            
            Node newNode = new Node(data);
            Node previousNode = head;
            Node current = head.getNext();

            int tempIndex = 1;
    
            while(current != null)
            {
                if(index == tempIndex)
                {
                    previousNode.setNext(newNode);
                    newNode.setNext(current);
                    return;
                }
                previousNode = current;
                current = current.getNext();
                tempIndex++;
            }
            
        }

    }

    public void removeFront(){
        if(head != null)
        {
            head = head.getNext();
            size--;
        }
        else{
            System.out.println("List is empty");
            System.err.println();
        }
    }

    public void removeBack(){
        if(head != null)
        {
            Node tempNode = head;
            while(tempNode != null)
            {
                if(tempNode.getNext() == tail)
                {
                    tail = tempNode;
                    tempNode.setNext(null);
                }
                tempNode = tempNode.getNext();
            }
            size--;
        }
        else{
            System.out.println("List is empty");
            System.err.println();
        }
    }

    public void remove(int index) {
        if(head != null)
        {
            if(index == 0)
            {
                removeFront();
            }
            else if(index == size - 1)
            {
                removeBack();
            }
            else
            {
                Node current = head.getNext();
                Node previous = head;
                int Tempindex = 1;
                while(current!= null)
                {
                    if(index == Tempindex)
                    {
                        previous.setNext(current.getNext());
                        return;
                    }
                    previous = current;
                    current = current.getNext();
                    Tempindex++;
                }
            }
        }
        else {
            System.out.println("List is empty");
            System.err.println();
        }
    }

    public void printList()
    {
        Node tempNode = head;
        while(tempNode !=null)
        {
            System.out.print(tempNode.getData() + " ");
            tempNode = tempNode.getNext();
        }
    }

    public void insertSorted(Type data) {
        if(head != null)
        {
            Node current = head;
            Node previous = null;
            Node newNode = new Node(data);
            while(current!=null)
            {
                if(current.getData().compareTo(newNode.getData()) > 0)
                {
                    previous.setNext(newNode);
                    newNode.setNext(current);
                    return;
                }
                previous = current;
                current = current.getNext();
            }
        }
    }
}
