import java.util.*;
import java.lang.*;
/**
 * to find the gene usig AND or OR.
 *
 * @author (Kushal Ghosh)
 * @version (19/02/2019)
 */
public class find_gene_2
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
        return -1;
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
        //int mindist = Math.min(taaIndex,(Math.min(tagIndex,tgaIndex)));
        //if(mindist==dna.length()){
          //  return "";
        //}
        //return dna.substring(startcodon,mindist+3);
        int mindist=0;
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
