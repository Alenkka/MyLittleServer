import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Laska on 18.03.14.
 */
public class ParamsCollections {
    public TreeSet<String> phones = new TreeSet<String>();
    public TreeSet<String> emails = new TreeSet<String>();


    public void addToPhonesCollection (String phone){
        this.phones.add(phone);
    }

    public void addToEmailsCollection (String email){
        this.emails.add(email);
    }

    public boolean checkPhoneExist(String phone){
        return phones.contains(phone);
                      }

        public boolean checkEmailExist(String email){
            return emails.contains(email);
                }
}

