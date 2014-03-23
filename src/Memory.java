import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Files;
import java.nio.file.OpenOption.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

/**
 * Created by Laska on 18.03.14.
 */
public class Memory {
    public TreeSet<String> food = new TreeSet<String>();
    public TreeSet<String> drinks = new TreeSet<String>();
    public TreeSet<String> sleep = new TreeSet<String>();
    public TreeSet<String> play = new TreeSet<String>();
    private Path path = Paths.get("c:\\myBag\\MyLittleServer\\foodMemory");


    public void addToFoodMemory(String food) throws IOException {
        this.food.add(food);
        try {
            this.addToFile(food);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToSleepMemory(String sleep){
        this.sleep.add(sleep);
    }

    public boolean checkFoodEnough(String food) throws IOException, ClassNotFoundException {
        Charset cs = Charset.forName("UTF-8");

       BufferedReader is = Files.newBufferedReader(path, cs);
        String line = null;
        while ((line = is.readLine()) != null) {
            System.out.println(line);

        }
        return this.food.contains(food);
                      }

        public boolean checkSleepEnough(String sleep){
            return this.sleep.contains(sleep);
                }

    public void addToFile(String food)throws  IOException {
        Charset charset = Charset.forName("UTF-8");
        OutputStream out = Files.newOutputStream(path, StandardOpenOption.CREATE,StandardOpenOption.APPEND);
        OutputStreamWriter writer = new OutputStreamWriter(out, charset);
        ObjectOutputStream oOut = new ObjectOutputStream(out);

                oOut.writeObject(food);
        //writer.append("\n");

        }

    }



