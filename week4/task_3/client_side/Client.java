package week4.task_3.client_side;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

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


    }

    public void connection()
    {
        /*
     * Open a clientSocket on a given host and port. Open input and output streams.
     */
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

    /*
     * If everything has been initialized then we want to write some data to the
     * clientSocket we have opened a connection to on the port portNumber.
     */
        if (clientSocket != null && out != null && in != null)
        {
            try
            {

        /* Create a thread to read from the server. */
                new Thread(new ClientLogic(in)).start();

                while (!closed)
                {
                    out.writeUTF(keyboard.readLine().trim());
                }
        /*
         * Close the output stream, close the input stream, close the clientSocket.
         */
                out.close();
                in.close();
                clientSocket.close();
            } catch (IOException e)
            {
                System.err.println("IOException:  " + e);
            }
        }
    }





    /*public void run()
    {
        InputStream ins = null;
        OutputStream outs = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        try
        {

            ins = clientSocket.getInputStream();
            outs = clientSocket.getOutputStream();
            in = new DataInputStream(ins);
            out = new DataOutputStream(outs);
            String name = in.readUTF();

            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); //Read text from client

            String text;
            while (true)
            {
                text = keyboard.readLine(); // Wait until user input something and press Enter
                System.out.println("Sending this line to the server...");
                out.writeUTF(text); // отсылаем введенную строку текста серверу.
                out.flush(); // заставляем поток закончить передачу данных.
                text = in.readUTF(); // ждем пока сервер отошлет строку текста.
                System.out.println(text);
            }

        } catch (UnknownHostException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                if (null != ins)
                {
                    ins.close();
                }
                if (null != outs)
                {
                    outs.close();
                }
                if (null != in)
                {
                    in.close();
                }
                if (null != out)
                {
                    out.close();
                }
                if (null != clientSocket)
                {
                    clientSocket.close();
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }*/
}
