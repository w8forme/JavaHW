package week4.task_3.client_side;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;

/**
 * Created by Pavel
 */
public class Client
{
    private final int SERVER_PORT = 2134;
    private Socket clientSocket; // The client clientSocket
    private InetAddress address; //Host address
    private InputStream ins = null; // The input stream
    private OutputStream outs = null; // The output stream
    private DataInputStream in = null; // The input stream
    private DataOutputStream out = null; // The output stream
    private BufferedReader keyboard = null; //Read text from client
    public static boolean closed = false;

    public static void main(String[] args)
    {
        Client client = new Client();
        client.connection();
        String str = "sss";
    }

    public void connection()
    {
     // Open a clientSocket on a given host and port. Open input and output streams.
        try
        {
            address = InetAddress.getByName("127.0.0.1");
            clientSocket = new Socket(address, SERVER_PORT);
            ins = clientSocket.getInputStream();
            outs = clientSocket.getOutputStream();
            in = new DataInputStream(ins);
            out = new DataOutputStream(outs);
            keyboard = new BufferedReader(new InputStreamReader(System.in));
        } catch (UnknownHostException e)
        {
            System.err.println("Don't know about host " + address);
        } catch (IOException e)
        {
            System.err.println("Couldn't get I/O for the connection to the host " + address);
        }

        if (clientSocket != null && out != null && in != null)
        {
            try
            {

        // Create a thread to read from the server.
                new Thread(new ClientLogic(in)).start();

                while (!closed)
                {
                    out.writeUTF(keyboard.readLine().trim());
                }

          //Close the output stream, close the input stream, close the clientSocket.

                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e)
            {
                System.err.println("IOException:  " + e);
            }
        }
    }
}
