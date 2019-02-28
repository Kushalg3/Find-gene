import java.util.*;
import java.lang.*;
/**
 * class find_gene find the gene using three three stopcodon.
 *
 * @author (Kushal Ghosh)
 * @version (18/2/2019)
 */
public class find_gene
{
    public int findStopcodon(String codon,int startcodon,String dna){
        int currdist = dna.indexOf(codon,startcodon+3);
        while(currdist!=-1){
            if((currdist-startcodon)%3==0){
                return currdist;
            }
            else{
                currdist=dna.indexOf(codon,currdist+1);
            }
        }
        return dna.length();
    }
    public String findGene(String dna){
        String taacodon = "TAA";
        String tagcodon = "TAG";
        String tgacodon = "TGA";
        int startcodon = dna.indexOf("ATG");
        if(startcodon==-1){
            return "";
        }
        int taaIndex = findStopcodon(taacodon,startcodon,dna);
        int tagIndex = findStopcodon(tagcodon,startcodon,dna);
        int tgaIndex = findStopcodon(tgacodon,startcodon,dna);
        int mindist = Math.min(taaIndex,(Math.min(tagIndex,tgaIndex)));
        if(mindist==dna.length()){
            return "";
        }
        return dna.substring(startcodon,mindist+3);
    }
    public void main(){
        System.out.println("Enter the DNA string");
        Scanner input = new Scanner(System.in);
        String dna = input.nextLine();
        dna = dna.toUpperCase();
        String result = findGene(dna);
        if(result==""){
            System.out.println("There is no appropriate gene");
        }
        else{
            System.out.println("The gene is "+result);
        }
    }
}
