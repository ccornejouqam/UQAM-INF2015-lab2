/*
 * 
 * Copyright 2014 Christian Cornejo.
 * 
 */
package jsonlab;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JSONSerializer;

/**
 * @author Christian
 * @version 2014.01.23
 */
public class JSONLab {


    public static void main(String[] args) 
            throws Exception {
       
        String filename = "myjsonfile.json";
        String txtJson = FileReader.loadFileIntoString(filename, "UTF-8");
        
        JSONArray root = (JSONArray)JSONSerializer.toJSON(txtJson);
        
        for (int i=0; i < root.size(); i++) {
            String day = root.getString(i);
            System.out.println(day);
        }
    }
    
}
