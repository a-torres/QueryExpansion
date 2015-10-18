
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.util.FileManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Guillermo Alienware
 */
public class Jena {
    
    public static void main (String args[]){
        FileManager.get().addLocatorClassLoader(Jena.class.getClassLoader());
        Model model = FileManager.get().loadModel(".rdf");
        model.write(System.out,"RDF/JSON");
        sparqlTest();
        
        
    }
    static void sparqlTest(){}
    
    
}
