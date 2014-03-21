import java.io.*;
import java.nio.file.*;
import java.util.TreeSet;

/**
 * Created by Laska on 18.03.14.
 */
public class Memory {
    public TreeSet<String> food = new TreeSet<String>();
    public TreeSet<String> drinks = new TreeSet<String>();
    public TreeSet<String> sleep = new TreeSet<String>();
    public TreeSet<String> play = new TreeSet<String>();
    private Path path = Paths.get("c:\\MyBag\\MyLittleServer\\foodMemory.txt");


    public void addToFoodMemory(String food) throws IOException {
        this.food.add(food);
        try {
            this.addToFile(this.food);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addToSleepMemory(String sleep){
        this.sleep.add(sleep);
    }

    public boolean checkFoodEnough(String food){
        return this.food.contains(food);
                      }

        public boolean checkSleepEnough(String sleep){
            return this.sleep.contains(sleep);
                }

    public void addToFile(TreeSet<String> food)throws  IOException {
        OutputStream out =  Files.newOutputStream(path);
        ObjectOutputStream oOut = new ObjectOutputStream(out);
        oOut.writeObject(food);
        //out.close();

        }

    }



