import com.sun.net.httpserver.*;
import java.io.*;
import java.net.InetSocketAddress;
import java.util.Map;

import com.google.gson.*;

public class Server {

    public static void main(String[] args) throws IOException {
        final ParamsCollections pCol = new ParamsCollections();

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        HttpContext context = server.createContext("/myapp", new HttpHandler() {
            String line;
            public void handle(HttpExchange t) throws IOException {
                InputStream is = t.getRequestBody();
                BufferedReader requestReader = new BufferedReader(new InputStreamReader(is));
                while ((line = requestReader.readLine()) != null){
                    System.out.println("line:"+line);
                    Gson gson = new Gson();
                    Params param = gson.fromJson(line, Params.class);
                    String response = "";
                    if  (param.type.equals("String")){
                        response = "Good work!";
                    } else {
                     response = "Try again!";

                    }
                    t.sendResponseHeaders(200, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();
                   }
}
        });

        HttpContext context2 = server.createContext("/myapp/second/", new HttpHandler() {
            String line;
            public void handle(HttpExchange t) throws IOException {
                InputStream is = t.getRequestBody();
                Integer code = 200;
                String response = "";
                BufferedReader requestReader = new BufferedReader(new InputStreamReader(is));

                while ((line = requestReader.readLine()) != null){
                    System.out.println("line2:"+line);
                    Gson gson = new Gson();
                    Params2 params2 = gson.fromJson(line, Params2.class);
                    System.out.println("params2:"+params2.toString());
                    for (Map m: params2.params) {
                        if (m.get("name").equals("phone")){
                            String phone = m.get("value").toString();
                            if (!pCol.checkPhoneExist(phone)){
                                pCol.addToPhonesCollection(phone);
                                response = "phone added to collection";
                                System.out.println("phone:"+phone);
                            }   else  response = "phone exists";

                        } if (m.get("name").equals("email")){
                            String email = m.get("value").toString();
                            if (!pCol.checkEmailExist(email)){
                                pCol.addToEmailsCollection(email);
                                response = response + " " + "email added to collection";
                                System.out.println("email:"+email);
                            }   else  response = response + " " + "email exists";
                    }
                        else response = "wrong params";
                    }
                    t.sendResponseHeaders(code, response.length());
                    OutputStream os = t.getResponseBody();
                    os.write(response.getBytes());
                    os.close();

           }
       }
      } );
        server.setExecutor(null);
        server.start();}
}