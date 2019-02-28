//import java.util.*;
//import java.lang.*;
import edu.duke.*;
/**
 * To find genes in a DNA strand.
 *
 * @author (Kushal Ghosh)
 * @version (20/02/2019)
 */
public class findGene4_using_duke
{
    public int findStopcodon(String Stopcodon,int startIndex,String dna){
        int currdist = dna.indexOf(Stopcodon,startIndex+3);
        while(currdist!=-1){
            if((currdist-startIndex)%3==0){
                return currdist;
            }
            else{
                currdist=dna.indexOf(Stopcodon,currdist+1);
            }
        }
        return -1;
    }
    public String findGene(String dna,int startIndex){
        startIndex = dna.indexOf("ATG",startIndex);
        String taacodon = "TAA";
        String tagcodon = "TAG";
        String tgacodon = "TGA";
        if(startIndex==-1){
            return "";
        }
        int taaIndex = findStopcodon(taacodon,startIndex,dna);
        int tagIndex = findStopcodon(tagcodon,startIndex,dna);
        int tgaIndex = findStopcodon(tgacodon,startIndex,dna);
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
        return dna.substring(startIndex,mindist+3);
    }
    public StorageResource getAllGenes(String dna){
        dna = dna.toUpperCase();
        int startIndex=dna.indexOf("ATG");
        StorageResource geneList = new StorageResource();
        while(true){
            String currGene = findGene(dna,startIndex);
            if(currGene.isEmpty()){
                break;
            }
            geneList.add(currGene);
            startIndex = dna.indexOf(currGene,startIndex) + currGene.length();
        }
        return geneList;
    }
    public double getCgRatio(String dna){
        int cIndex=0,gIndex=0,countcg= 0;
        dna=dna.toUpperCase();
        while(true){
            cIndex = dna.indexOf("C",cIndex);
            if(cIndex==-1){
                break;
            }
            countcg++;
            cIndex++;
        }
        while(true){
            gIndex=dna.indexOf("G",gIndex);
            if(gIndex==-1){
                break;
            }
            countcg++;
            gIndex++;
        }
        return ((double)countcg/dna.length());
    }
    public void main(){
        int c =0,mlength=0;
        double countcg;
        FileResource fr = new FileResource();
        String dna = fr.asString();
        StorageResource gene=getAllGenes(dna);
        for(String g:gene.data()){
            //countcg = getCgRatio(g);
            //System.out.println(countcg);
                //if(countcg>0.35){
                //System.out.printf("%.2f\n",countcg);
                //c++;
                //System.out.printf("The gene no. %d is :",c);
                //System.out.println(g);
            //}
            //if(g.length()>60){
              //  c++;
            //}
            mlength=Math.max(g.length(),mlength);
        }
        System.out.println(mlength);
        //System.out.printf("\nThe no. genes who have CG ratio greater than 0.35 is %d.\n",c);
    }
}
