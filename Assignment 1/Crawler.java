/**
 * Create By Yinsheng Dong (yid164)
 * CMPT 350 Assignment 1 Part A
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class Crawler
 */
public class Crawler {
    
    // Call it to executed Crawler
    public Crawler (String givenURL, int number)
    {
        executed(givenURL,number);
    }
    
    
    // ArrayList to reture the URL array list that got
    protected ArrayList<String> getUrlList(String givenURL)
    {
        
        ArrayList<String> urlList = new ArrayList<>();
        
        String s = givenURL;
        String url = s.replaceFirst("((ftp|http|https):\\/\\/)?","");
        String host = getHost(s);
        
        String page = url.replaceFirst(host,"");
        
        int index = page.lastIndexOf('/');
        if(index!=page.length())
        {
            page += "/";
        }
        
        if(page=="")
        {
            page = "/";
        }
        
        
        try {
            String CRLF = "\r\n";
            
            int port = 80;
            Socket socket = new Socket(host, port);
            
            
            BufferedReader br;
            PrintStream ps;
            
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            ps = new PrintStream(socket.getOutputStream());
            
            
            ps.print("GET "+page+" HTTP/1.0"+ CRLF);
            ps.print("Accept:text/html" + CRLF);
            
            ps.print("Host: " + host + CRLF);
            
            ps.print(CRLF +CRLF);
            
            String data = br.readLine();
            
            while(data != null)
            {
                
                
                
                Pattern pattern = Pattern.compile("((https?):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)");
                Matcher matcher = pattern.matcher(data);
                while(matcher.find())
                {
                    
                    
                    String s1 =matcher.group();
                    urlList.add(s1);
                    //System.out.println(matcher.group());
                    
                }
                
                //System.out.println(data);
                data = br.readLine();
                
            }
            br.close();
            ps.close();
            socket.close();
            
        }catch (Exception e)
        {
            System.out.println(e.fillInStackTrace().toString());
        }
        
        
        return urlList;
    }
    
    //executed the array while the number is less than 1, run once, else run number-1 times
    protected void executed(String urlGiven, int number)
    {
        
        
        System.out.println("Host URL:  "+urlGiven+"  count url get:  "+getUrlList(urlGiven).size());
        for(String s: getUrlList(urlGiven))
        {
            System.out.println("         "+s);
        }
        
        if(number>=1)
        {
            for(String s : getUrlList(urlGiven))
            {
                executed(s, number-1);
            }
        }
        
        //getUrlList(urlGiven);
    }
    
    // get host from the url
    protected String getHost(String url)
    {
        try {
            
            URL u = new URL(url);
            return u.getHost();
        }catch (Exception e)
        {
            return null;
        }
    }
    
    // main class
    public static void main (String args[])
    {
        String url = args[0];
        int number = Integer.parseInt(args[1]);
        Crawler crawler = new Crawler(url, number);
        
    }
    
}
