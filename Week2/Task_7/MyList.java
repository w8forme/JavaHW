package Week2.Task_7;
import java.util.List;

/**
 * Created by Pavel
 */
public class MyList
{
    private Node head;
    private Node tail;
    private int sizeList = 0;

    public void addHead(int elem)
    {
        if (null == head)
        {
            head = new Node(elem, null);
            tail = head;
        }
        else
        {
            Node node = new Node(elem, head);
            head = node;
        }
        sizeList++;
    }

    public void addTail(int elem) {
        if (null == head) {
            head = new Node(elem, null);
            tail = head;
        } else {
            Node node = new Node(elem, null);
            tail.setNext(node);
            tail = node;
        }
        sizeList++;
    }

    public Node find(int key)
    {
        Node current = head;
        while (current.getElem() != key)
        {
            if (current.getNext() == null)
            {
                return null; // didn't find it
            }
            else
            {
                current = current.getNext(); // not end of list, go to next link
            }
        }
        return current; // found it
    }

    public void displayList()
    {
        System.out.println("List (first to last): ");
        Node current = head;
        while (current != null)
        {
            System.out.print(current);
            current = current.getNext();
        }
        System.out.println();
    }

    public void displayListReverse(Node node)
    {
        Node current = node;
        Node previous = null;
        Node next = null;
        while (current != null)
        {
            System.out.print(current);
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        System.out.println();
    }




    public MyList()
    {
        this.head = null;
        this.sizeList = 0;
    }
}
