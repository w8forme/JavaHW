package Week2.Task_7;

/**
 * Created by Pavel
 */
public class Node
{
    private Node next;
    private int elem;

    public Node()
    {
        this.next = null;
        this.elem = 0;
    }

    public Node(int elem, Node next)
    {
        this.next = next;
        this.elem = elem;
    }

    public Node(int elem)
    {
        this.elem = elem;
    }

    @Override
    public String toString()
    {
        return this.elem + " ";
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }

    public int getElem()
    {
        return elem;
    }

    public void setElem(int elem)
    {
        this.elem = elem;
    }
}
