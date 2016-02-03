package lists;

import io.MyReader;
import java.io.File;

/**
 * A class to hold the contents of a text file, as an StringList.
 * Stores the pathname for use as a header.
 * @author levenick Jan 14, 2016 11:12:29 AM
 */
public class Pattern {
    static String gottaKeepEmSeparated = "\n**************************************************\n";
    public StringList list;
    File absFile;
    

    public Pattern(String path) {
        File aFile = new File(path);
        absFile = aFile.getAbsoluteFile();
        list = new StringList();
        readFile(absFile);
    }

    /**
     * @return A String containing a header consisting of the path of the file surrounded by *'s
     * then the contents of the file/Pattern and a blank line
     * (like the write-up asks for!)
     */
    public String toString() {
        String returnMe = "";

            returnMe +=  list.toString() + "\n";
        

        return returnMe;
    }

    /**
     * Reads a File into a StringList
     * each line of the file is stored in a String
     * @param path 
     */
    public void readFile(File path) {        
        MyReader mr = new MyReader(path.toString());

        while (mr.hasMoreData()) {
            list.add(mr.giveMeTheNextLine());
        }

        mr.close();
    }

    /**
     * Test code!
     * @param args 
     */
    public static void main(String[] args) {
        Pattern p = new Pattern("foo");
        System.out.println(p);
    }
}
