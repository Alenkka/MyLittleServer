import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * Created by e.perevaryukha on 3/17/14.
 */
public class Params2 {
    public Integer spServiceId;
    public Map [] params;

    public void setSpServiceId(Integer spServiceId){
        this.spServiceId = spServiceId;
    }

    public void setParams(Map []  params){
        this.params = params;
    }

    public Map [] getParams(){
        return params;
    }

    public Integer getSpServiceId(){
        return spServiceId;
    }

    public String toString(){
        return ""+this.getSpServiceId()+this.getParams();
    }

    }

