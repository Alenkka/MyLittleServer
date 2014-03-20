import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by e.perevaryukha on 3/17/14.
 */
public class LifecycleParams {
    public Map [] params;

    public void setParams(Map []  params){
        this.params = params;
    }

    public Map [] getParams(){
        return params;
    }

      public String toString(){
        return ""+this.getParams();
    }

    }

