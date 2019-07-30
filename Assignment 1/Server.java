/**
 * Create by Yinsheng Dong (yid164)
 * CMPT 350 Assignment 1 Part B Server
 */

import java.io.*;
import java.net.*;

/**
 * Server class
 **/
public class Server {
    
    protected static String directory;
    
    protected static String getFileName(String url)
    {
        String dir = url;
        if(dir.contains("?"))
        {
            dir = dir.split("\\?")[0];
        }
        if(dir.endsWith("/"))
        {
            dir = dir.substring(0, dir.length()-1);
        }
        
        return dir.substring(dir.lastIndexOf('/')+1, dir.length());
    }
    
    public static void main(String[] Args) throws Exception
    {
        String directory = Args[0];
        
        File file = new File(directory);
        
        if(!file.isDirectory())
        {
            System.out.println("This is not directory");
            return;
        }
        
        if(directory.endsWith("/"))
        {
            Server.directory = directory + "/";
        }else{
            if(directory.contains("/"))
            {
                Server.directory = directory + "/";
            }
        }
        
        ServerSocket serverSocket = new ServerSocket(8000,0, InetAddress.getByName(null));
        
        while(!Thread.currentThread().isInterrupted())
        {
            Socket client = serverSocket.accept();
            ClientServer clientServer = new ClientServer(client);
            new Thread(clientServer).start();
        }
    }
}

class ClientServer implements Runnable {
    private final Socket socket;
    
    @Override
    public void run()
    {
        try
        {
            //String CRCL = "\r\n";
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String getInput = reader.readLine();
            
            String getUrl = getInput.split(" ")[1];
            
            File file = new File(Server.directory + Server.getFileName(getUrl));
            
            
            //PrintStream ps = new PrintStream(socket.getOutputStream());
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
        
            
            if(file.exists())
            {
                /**
                ps.println("HTTP/1.1 200 OK  ");
                ps.println("Content-Type: text/html  ");
                ps.println("");
                ps.println(" <html> <body> <a href=\""+getUrl+"\"> The file has been found </a> </body> </html> ");
                ps.println("");
                socket.close();
                
                bufferedReader.close();
                socket.close();
                Thread.currentThread().join();
                 **/
                FileInputStream fileInputStream = new FileInputStream(file);
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(fileInputStream));
                String line;
                StringBuilder body = new StringBuilder();
                while ((line=fileReader.readLine())!=null){
                    body.append(line).append("\n");
                }
                fileReader.close();
                
                
                
                printWriter.write("HTTP/1.1 200 OK\r\n");
                printWriter.write("Content-Type: text/html\r\n");
                printWriter.write("");
                printWriter.write("Content-Length: " + body.length() + "\r\n");
                printWriter.write("\r\n");
                printWriter.write(body.toString());
                printWriter.flush();
                printWriter.close();
                reader.close();
                socket.close();
                Thread.currentThread().join();
                
            }
            else
            {
                /**
                ps.println("HTTP/1.1 404 NOT FOUND  ");
                ps.println("Content-Type: text/html  ");
                ps.println("");
                ps.println(" <html> <body> <a href=\""+getUrl+"\"> The file has not been found </a> </body> </html> ");
                ps.println("");
                bufferedReader.close();
                socket.close();
                Thread.currentThread().join();
                 **/
                printWriter.write("HTTP/1.1 404 NOT FOUND\r\n");
                printWriter.write("Content-Length: 0\r\n");
                printWriter.write("\r\n");
                printWriter.flush();
                
                reader.close();
                printWriter.close();
                socket.close();
                Thread.currentThread().join();
                return;
            }
        }catch(Exception E)
        {
            System.out.println(E);
        }
        
    }
    public ClientServer(Socket socket)
    {
        this.socket = socket;
    }
}
