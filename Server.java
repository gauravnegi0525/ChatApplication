import java.io.BufferedReader;
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
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    public static void main(String[] args) 
    {
        System.out.println("This is Server running.....");
    }
}