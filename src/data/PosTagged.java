package data;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import edu.stanford.nlp.tagger.maxent.MaxentTagger;
 
public class PosTagged {
    public static void main(String[] args) throws IOException,ClassNotFoundException {
    	String sample="";
    	String tagged;
        // Initialize the tagger
        MaxentTagger tagger = new MaxentTagger("taggers/english-left3words-distsim.tagger");
        FileInputStream fstream = new FileInputStream("Inputs/input_5.txt");
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        
        //we will now pick up sentences line by line from the file input.txt and store it in the string sample
        while((sample = br.readLine())!=null)
        {
        //tag the string
        tagged = tagger.tagString(sample);
        FileWriter q = new FileWriter("Outputs/output.txt",true);
        BufferedWriter out =new BufferedWriter(q);
        //write it to the file output.txt
        out.write(tagged);
        out.newLine();
        out.close();
        }
    }
}
