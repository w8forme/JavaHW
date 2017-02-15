package week2.Task_7;

/**
 * Created by Pavel
 */
public class MyList
{
    private Node head;                  //Head of the list
    private Node tail;                  //Tail of the list
    private int sizeList = 0;           //Size of the list

    //The method is for adding elements to the head of the list
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

    //The method is for adding elements to the tail of the list
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

    //The method is used for finding the first element of the list, if
    public Node find(int firstKey)
    {
        Node current = head;
        while (current.getElem() != firstKey)
        {
            if (current.getNext() == null)
            {
                System.out.println("Значение не найдено!");
                return null; //didn't find it
            }
            else
            {
                current = current.getNext(); //It's not the end of the list, go to the next link
            }
        }
        return current;
    }

    //The method is used for showing our list in the sorted order
    public void displayList(Node node)
    {
        if (null == node)
        {
            return;
        }
        else
        {
            System.out.print("Список: ");
            Node current = node;
            while (current != null)
            {
                System.out.print(current);
                current = current.getNext();
            }
            System.out.println("\nРазмер списка: " + sizeList + "\n");
        }
    }

    //The method is used for showing our list in the reverse order
    public void displayListReverse(Node node)
    {
        Node current = node; //head of un reversed lis
        Node previous = null; //head of reversed list
        Node next; //node to be reversed
        while (current != null)
        {
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        displayList(previous); //After the list was sorted in reverse order, we call the method to show our list
    }


    public MyList()
    {
        this.head = null;
        this.sizeList = 0;
    }
}
