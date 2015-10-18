
import edu.smu.tspell.wordnet.NounSynset;
import edu.smu.tspell.wordnet.Synset;
import edu.smu.tspell.wordnet.SynsetType;
import edu.smu.tspell.wordnet.WordNetDatabase;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guillermo Alienware
 */
public class WSDWordNet {
    
    String[] terms; 
    List<String[]> listSym;
    List<String[]> listHyp;
    
    public WSDWordNet(){
        
    }
    
    public void processSymHyp (String query){
        terms = query.split("\\s+");
        listSym = new ArrayList<>();
        listHyp = new ArrayList<>();
        
        WordNetDatabase database = WordNetDatabase.getFileInstance();    

        for (String t: terms){
            Synset [] synsets  = database.getSynsets(t, SynsetType.NOUN);
            NounSynset nounSynset;
            NounSynset[] hyponyms;

            for (Synset s:synsets){
                nounSynset = (NounSynset) (s);
                hyponyms = nounSynset.getHyponyms();
                
                String [] s_listSym = new String[nounSynset.getWordForms().length];
                String [] s_listHyp = new String[hyponyms.length];
                
                for (int j = 0; j < nounSynset.getWordForms().length; j++) {
                    s_listSym[j] = nounSynset.getWordForms()[j];
                    System.out.println("Sym: "+ nounSynset.getWordForms()[j]);
                }
                for (int j = 0; j < hyponyms.length; j++) {
                    s_listHyp[j] = hyponyms[j].getWordForms()[0];
                    System.out.println("Hyp: "+ hyponyms[j].getWordForms()[0]);
                }
                listSym.add(s_listSym);
                listHyp.add(s_listHyp);
            }
            
        }
    }

    public List<String[]> getListSym() {
        return listSym;
    }

    public void setListSym(List<String[]> listSym) {
        this.listSym = listSym;
    }

    public List<String[]> getListHyp() {
        return listHyp;
    }

    public void setListHyp(List<String[]> listHyp) {
        this.listHyp = listHyp;
    }

        
}
