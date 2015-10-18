
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import javax.swing.JApplet;
import javax.swing.JFrame;
import java.util.regex.*;
public class Sinonimos {

    String a[] = new String[2];

    public static void main(String a[]) {
        String ar[] = {"faith","arplane","teacher","exam"};
        int k = 0;
        while (k < ar.length) {
            //System.setProperty("wordnet.database.dir", "C:\\ProgramFiles(x86)\\WordNet\\2.1\\dict");
            System.setProperty("wordnet.database.dir","C:\\Program Files (x86)\\WordNet\\2.1\\dict\\");
            NounSynset nounSynset;
            NounSynset[] hyponyms;
            WordNetDatabase database = WordNetDatabase.getFileInstance();
            
            Synset[] synsets  = database.getSynsets(ar[k], SynsetType.NOUN);
            System.out.println("*********************************************");
            //System.out.println(database.getSynsets(ar[j], SynsetType.NOUN));
            for (int i = 0; i < synsets.length; i++) {
                nounSynset = (NounSynset) (synsets[i]);
                hyponyms = nounSynset.getHyponyms();
                System.out.println("Definition: "+nounSynset.getDefinition());
                System.out.println("Hyponyms nro: " + hyponyms.length);
                for (int j = 0; j < nounSynset.getWordForms().length; j++) {
                    System.out.println("Sym: "+ nounSynset.getWordForms()[j]);
                }
                for (int j = 0; j < hyponyms.length; j++) {
                    System.out.println("Hyp: "+ hyponyms[j].getWordForms()[0]);
                }
            }
            k++;
        }
        System.out.println("*********************************************");
    }
}
