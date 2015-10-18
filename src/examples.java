
import org.apache.jena.query.QuerySolution;
import org.apache.jena.query.ResultSet;

public class examples {
// example using  jena.query.ResultSet  

    public static void main(String[] args) {
        // Example using String return 
        // use the code where u want :p
        //  String queryString;
        String wordToSearch = "Tool";
        String queryString =    "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#> " +
                                "PREFIX owl: <http://www.w3.org/2002/07/owl#> " +
                                "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> " +
                                "PREFIX xsd: <http://www.w3.org/2001/XMLSchema#> " +
                                "SELECT ?s ?p ?o WHERE { " +
                                "  ?s ?p ?o .FILTER regex(str(?o),\""+wordToSearch+"\") ."+
                                "FILTER regex(str(?p),\"subClassOf\") . "
                                + "} LIMIT 5";

        // call method ExecSparQlString from class  OpenOWL    
        // ExecSparQlString return a String  
        String s = OpenOWL.ExecSparQlString(queryString);

        //test 
        System.out.println(" resultado: '" + s + "'\n");
    }

    public static void BoxActivite() {  // method

        String rol = "";
        String p = "";
        try {
            // OntModel model = OpenOWL.OpenConnectOWL();

            System.out.println("Avoir les activités");  // get the activity from my File OWL 

            String queryString;
            queryString = "PREFIX saidi:<http://www.owl-ontologies.com/Ontology1364995044.owl#> "
                    + "SELECT  (str(?x) as ?xs) "
                    + "where { ?y saidi:hasnameactivite ?x."
                    + " ?y saidi:avoirrole ?ro. "
                    + " ?y saidi:Activitepour ?p. "
                    + "?ro saidi:hasnamerole ?nr."
                    + " FILTER (?p ='" + p + "') "
                    + "FILTER (?nr ='" + rol + "') }";

                      // call method ExecSparQl from class OpenOWL
            // ExecSparQl return a Resultset 
            ResultSet results = OpenOWL.ExecSparQl(queryString);

            while (results.hasNext()) {

                QuerySolution soln = results.nextSolution();
                String nomactiviter = soln.getLiteral("xs").getString();
                //test --
                System.out.println("nomactiviter  " + nomactiviter.toString());
                    // public ArrayList<String> ListActivite = new ArrayList<String>();
                //ListActivite.add(nomactiviter.toString());
                System.out.println("ListActivity: " + nomactiviter.toString());

            }
                //Jcombobox   (ac = new javax.swing.JComboBox();)

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }  // end first method
}
