package week4.task_3.server_side;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Pavel
 */
public class ServerChat
{
    private final int PORT = 2134;
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private boolean serverOn;
    private Set<String> names; //Contains unique user names
    private List<ServerLogic> countClients; //Contains all clients, who successfully connected to server
    private ExecutorService exservice; //Each client receive own thread

    public ServerChat()
    {
        this.names = new HashSet<String>();
        this.countClients = new ArrayList<ServerLogic>();
    }

    public void showMessages()
    {
        exservice = Executors.newCachedThreadPool();
        try
        {
            serverSocket = new ServerSocket(PORT);
            serverOn = true; //Mark that server is running
            System.out.println("Сервер работает.\n Ожидаю клиентов...");
        } catch (IOException e)
        {
            System.err.println("Could not create server socket on port 2134.");
            System.exit(-1);
        }
        while (serverOn)
        {
            try
            {
                clientSocket = serverSocket.accept();                               // Server wait connection
                exservice.execute(new ServerLogic(clientSocket, names, countClients)); // and create thread for new client
                System.out.println("К серверу присоеденился клиент " + clientSocket.getInetAddress().getHostName());
            } catch (IOException e)
            {
                System.err.println("Error found on accept.");
                e.printStackTrace();
            }
        }
        try
        {
            exservice.shutdownNow();
            serverSocket.close();
            System.err.println("Server Stopped");
        } catch (Exception ex)
        {
            System.err.println("Error stopping server socket");
            System.exit(-1);
        }
    }



    public static void main(String[] args)
    {
        ServerChat chatServer = new ServerChat();
        chatServer.showMessages();

    }
}
