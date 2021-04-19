/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cristi.lab8_pa;
import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;  
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author crist
 */
public class CSVReader {
    List<List<String>> dataSet = new ArrayList<>();
    public CSVReader(String nameCSV) {
        String line = "";  
        String splitBy = ",";  
        try   
        {  
            BufferedReader br = new BufferedReader(new FileReader(nameCSV));  
            while ((line = br.readLine()) != null) 
            {  
                dataSet.add(Arrays.asList(line.split(splitBy)));
            }  
        }   
        catch (IOException e)   
        {  
            e.printStackTrace();  
        }  
    }

    public List<List<String>> getDataSet() {
        return dataSet;
    }
    
    
}
