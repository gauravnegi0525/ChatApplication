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
        try
        {
            Runnable r1 = () ->{
                System.out.println("Reader start......");
                while(true)
                {
                    String msg = br.readLine();
                    if(msg.equals("exit"))
                    {
                        System.out.println("Clint has stopped");
                        break;
                    }
                    System.out.println("Clint: "+msg);
                }
            };
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
       
    }
    

    public void startWriting()
    {   
        try
        {
            Runnable r2 = () ->{
                System.out.println("Writer start......");
                while(true)
                {
                    String input = out.readLine();
                    if(input.equals("terminate"))
                    {
                        System.out.println("You Stops the messaging.");
                        break;
                    }
                    socket.getOutputStream(input);
                }
            };
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        
    }
    public static void main(String[] args) 
    {
        System.out.println("This is Server running.....");
    }
}