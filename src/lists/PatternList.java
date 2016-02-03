package lists;

import java.util.ArrayList;

/**
 * Wrapper for an ArrayList &lt;Pattern
 * The only method is toString()
 * Everything else is ArrayList
 * @author levenick Jan 14, 2016 11:12:11 AM
 */
public class PatternList extends ArrayList<Pattern> {

    /**
     * 
     * @return 
     */
    public String toString() {
        String returnMe = "";

        for (Pattern nextP : this) {
            returnMe += nextP.toString() + "\n";
        }

        return returnMe;
    }
}
