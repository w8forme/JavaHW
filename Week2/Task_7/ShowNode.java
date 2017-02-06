package Week2.Task_7;

/**
 * Created by Pavel
 */
public class ShowNode
{

    public static void main(String[] args)
    {
        MyList a = new MyList();
        a.addTail(39);
        a.addTail(7);
        a.addTail(15);
        a.addTail(3);
        a.addTail(8);
        a.displayList(a.find(39));
        a.displayListReverse(a.find(15));


    }
}
