import edu.duke.*;
/**
 * Write a description of class findCTG here.
 *
 * @author (Kushal Ghosh)
 * @version (22/2/2019)
 */
public class findCTG
{
    public int findNoOfCTG(String dna){
        int startIndex=0,count=0;
        //int pos=0;
        while(true){
            startIndex=dna.indexOf("CTG",startIndex);
            if(startIndex==-1){
                break;
            }
            startIndex=startIndex+3;
            count++;
        }
        return count;
    }
    public void main(){
        FileResource fr = new FileResource();
        String dna=fr.asString();
        int countCTG=findNoOfCTG(dna);
        System.out.println("The no. of CTG is "+countCTG);
    }
}
