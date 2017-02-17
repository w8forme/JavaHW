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
                    line = in.readUTF(); // ожидаем пока клиент пришлет строку текста.

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

/*    @Override
    public void run()
    {
        InputStream ins = null;
        OutputStream outs = null;
        DataInputStream in = null;
        DataOutputStream out = null;
        try
        {
            address = InetAddress.getByName("127.0.0.1");
            socket = new Socket(address, SERVER_PORT);
            ins = socket.getInputStream();
            outs = socket.getOutputStream();
            in = new DataInputStream(ins);
            out = new DataOutputStream(outs);
            BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in)); //Read text from client
            String name = in.readUTF();



            String text;
            while (true) {
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
        }
        finally
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
                if (null != socket)
                {
                    socket.close();
                }

            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }*/
}
