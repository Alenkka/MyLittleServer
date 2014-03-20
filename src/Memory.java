import java.util.TreeSet;

/**
 * Created by Laska on 18.03.14.
 */
public class Memory {
    public TreeSet<String> food = new TreeSet<String>();
    public TreeSet<String> drinks = new TreeSet<String>();
    public TreeSet<String> sleep = new TreeSet<String>();
    public TreeSet<String> play = new TreeSet<String>();


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
}

