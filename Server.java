import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

class Server 
{
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    public Server()
    {
        try
        {
            server = new ServerSocket(7777);
            System.out.println("Server is ready to set the connection.");
            System.out.println("waiting...........");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            startReading();
            startWriting();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }

    public void startReading()
    {
        Runnable r1 = () ->{

        };
    }

    public void startWriting()
    {
        Runnable r2 = () ->{

        };
    }
    public static void main(String[] args) 
    {
        System.out.println("This is Server running.....");
    }
}