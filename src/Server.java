import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;


public class Server {

    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext context = server.createContext("/letsCommunicate/", new MyHandler());
        server.setExecutor(null);
        server.start();}
}