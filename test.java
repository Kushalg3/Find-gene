import java.util.*;
import java.lang.*;
import edu.duke.*;
/**
 * Write a description of class test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class test
{
   public void findAbc(String input) {
        int index = input.indexOf("abc");
        while (true) {
           if (index==-1||index>=input.length()-4) {
                break;
           }
           String found = input.substring(index+1, index+4);
           System.out.println(found);
           System.out.println(index);
           index = input.indexOf("abc", index+3);
           System.out.println("Index after updating"+index);
         }
   }
    public void test() {
     //no code yet
     findAbc("abcabcabcabca");
    }
}
