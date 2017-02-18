package week4.task_3.server_side;

import java.io.*;
import java.net.Socket;
import java.util.List;
import java.util.Set;

/**
 * Created by Pavel
 */
public class ServerLogic implements Runnable
{

    private Socket socket;
    private Set<String> names;
    private InputStream ins = null; // The input stream
    private OutputStream outs = null; // The output stream
    private DataInputStream in = null; // The input stream
    private DataOutputStream out = null; // The output stream
    private List<ServerLogic> countClients;

    public ServerLogic(Socket socket, Set<String> names, List<ServerLogic> countClients) throws IOException
    {
        this.socket = socket;
        this.names = names;
        this.countClients  = countClients;
        this.ins = socket.getInputStream();
        this.outs = socket.getOutputStream();
        this.in = new DataInputStream(ins);
        this.out = new DataOutputStream(outs);
    }

    private void sendMsg(String msg) throws IOException
    {
        out.writeUTF(msg + "\n");
        out.flush();
    }

    @Override
    public void run()
    {
        try
        {
            synchronized (this)
            {
                countClients.add(this);
            }

            String userName;
            while (true)
            {
                userName = "Введите Ваше имя: ";
                out.writeUTF(userName);
                userName = in.readUTF().trim(); //Receive user name
                if (names.add(userName))
                {
                    out.writeUTF("Ваше имя в чате: " + userName + "\n");
                    break;
                }
                else
                {
                    out.writeUTF("К сожалению, имя " + userName + " уже занято! Попробуйте еще раз! " + "\n");
                }
            }
            String line = null;
            while (true)
            {
                if (in.available() > 0)
                {
                    line = in.readUTF(); //Wait until client send a text

                    synchronized (this)
                    {
                        for (ServerLogic sl : countClients)
                        {
                            sl.sendMsg("<" + userName + ">: " + line);
                        }
                    }
                }
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
