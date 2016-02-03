package lists;

import java.util.ArrayList;

/**
 * Wrapper for an ArrayList
 * The only method is toString()
 * Everything else is ArrayList
 * @author levenick Jan 14, 2016 11:12:11 AM
 */

public class StringList extends ArrayList<String> {

    public String toString() {
        String returnMe = "";
        
        for (String nextS: this) {
            returnMe += nextS + "\n";
        }
        
        return returnMe;
    }
}
