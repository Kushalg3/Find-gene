import java.util.*;
import java.lang.*;
/**
 * To find genes in a DNA strand.
 *
 * @author (Kushal Ghosh)
 * @version (20/02/2019)
 */
public class find_gene3
{
    private int loop_variable=0;
    public int findStopcodon(String Stopcodon,int startcodon,String dna){
        int currdist = dna.indexOf(Stopcodon,startcodon+3);
        while(currdist!=-1){
            if((currdist-startcodon)%3==0){
                return currdist;
            }
            else{
                currdist=dna.indexOf(Stopcodon,currdist+1);
            }
        }
        return -1;
    }
    public String findGene(String dna){
        String taacodon = "TAA";
        String tagcodon = "TAG";
        String tgacodon = "TGA";
        int startcodon = dna.indexOf("ATG",loop_variable);
        if(startcodon==-1){
            return "";
        }
        int taaIndex = findStopcodon(taacodon,startcodon,dna);
        int tagIndex = findStopcodon(tagcodon,startcodon,dna);
        int tgaIndex = findStopcodon(tgacodon,startcodon,dna);
        int mindist = Math.min(taaIndex,(Math.min(tagIndex,tgaIndex)));
        if(taaIndex==-1||(tagIndex!=-1&&tagIndex<taaIndex)){
            mindist=tagIndex;
        }
        else{
            mindist=taaIndex;
        }
        if(mindist==-1||(tgaIndex!=-1&&tgaIndex<mindist)){
            mindist=tgaIndex;
        }
        if(mindist==-1){
            return "";
        }
        loop_variable=mindist+2;
        return dna.substring(startcodon,mindist+3);
    }
    public void main(){
        int c=0;
        System.out.println("Enter the DNA string");
        Scanner input = new Scanner(System.in);
        String dna = input.nextLine();
        dna = dna.toUpperCase();
        while(true){
            String result = findGene(dna);
            if(result.isEmpty()){
                System.out.printf("There is only %d Gene.",c);
                break;
            }
            System.out.println("The gene is "+result);
            c++;
        }
    }
}
