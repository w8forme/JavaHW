package week4.task_3.client_side;

import java.io.*;
import java.net.Socket;

/**
 * Created by Pavel
 */
public class ClientLogic implements Runnable
{

    private Socket clientSocket; // The client clientSocket
    private InputStream ins = null; // The input stream
    private OutputStream outs = null; // The output stream
    private DataInputStream in = null; // The input stream
    private DataOutputStream out = null; // The output stream
    private BufferedReader keyboard = null; //Read text from client

    public ClientLogic(DataInputStream in)
    {
        this.in = in;
    }

    /*
         * Create a thread to read from the server. (non-Javadoc)
         *
         * @see java.lang.Runnable#run()
         */
    @Override
    public void run()
    {
    /*
     * Keep on reading from the client socket till we receive "Bye" from the
     * server. Once we received that then we want to break.
     */
        String responseLine;
        try
        {
            while ((responseLine = in.readUTF()) != null)
            {
                System.out.print(responseLine);
                if (responseLine.equalsIgnoreCase("/quit"))
                    break;
            }
            Client.closed = true;
        } catch (IOException e)
        {
            System.err.println("IOException:  " + e);
        }
    }
}
