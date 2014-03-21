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
    private File file = new File("foodMemory.txt");
    private Path path = Paths.get("c:\\MyBag\\MyLittleServer\\");


    public void addToFoodMemory(String food){
        this.food.add(food);
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

    public void addToFile(Memory food)throws  IOException {
        OutputStream out =  Files.newOutputStream(path);
        FileWriter writer = new FileWriter(file);
        writer.write();

        }

    }

}

