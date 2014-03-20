import com.google.gson.Gson;
import com.sun.net.httpserver.*;

import java.io.*;
import java.util.Map;


public class MyHandler implements HttpHandler {
    final Memory state = new Memory();

    public void handle(HttpExchange t) throws IOException {
        String instruction;
        Integer code = 200;
        String response = "";
        InputStream is = t.getRequestBody();
        BufferedReader requestReader = new BufferedReader(new InputStreamReader(is));
        while ((instruction = requestReader.readLine()) != null){
            System.out.println("instruction:"+instruction);
            Gson gson = new Gson();
            LifecycleParams lifecycleParams = gson.fromJson(instruction, LifecycleParams.class);
            System.out.println("lifecycleParams:"+ lifecycleParams.toString());
            for (Map m: lifecycleParams.params) {
                if (m.get("name").equals("food")){
                    String food = m.get("value").toString();
                    if (!state.checkFoodEnough(food)){
                        state.addToFoodMemory(food);
                        response = "Mmm... It's really delicious!";
                        System.out.println("food:"+food);
                    }   else  response = "One more" + " "+ food + " " + "?";
                              }
                else if (m.get("name").equals("sleep")){
                    String sleep = m.get("value").toString();
                    if (!state.checkSleepEnough(sleep)){
                        state.addToSleepMemory(sleep);
                        response = response + " " + "Pppppp...pppppp...";
                        System.out.println("sleep:"+sleep);
                    }   else  response = response + " " + "I don't want to sleep!";
                            }
                else response = "I don't understand! What do you want from me???";
            }
            t.sendResponseHeaders(code, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();

        }
    }


}

