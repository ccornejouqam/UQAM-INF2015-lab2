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
            readJSONArray();
            readSeveralJSONArrays();
            readJSONManipArray();
    }
    
    public static void readJSONArray() 
            throws Exception {
        String filename = "myjsonfile.json";
        String txtJson = FileReader.loadFileIntoString(filename, "UTF-8");       
        JSONArray root = (JSONArray)JSONSerializer.toJSON(txtJson);        
        for (int i=0; i < root.size(); i++) {
            String day = root.getString(i);
            System.out.println(day);
        }   
    }
    
    public static void readSeveralJSONArrays()
            throws Exception {
        String filename = "newjson.json";
        String txtJson = FileReader.loadFileIntoString(filename, "UTF-8");       
        JSONArray root = (JSONArray)JSONSerializer.toJSON(txtJson);        
        for (int i=0; i < root.size(); i++) {
            JSONObject document = root.getJSONObject(i);
            JSONArray personnages = (JSONArray)document.get("personnages");
            for (int j=0; j < personnages.size(); j++) {
                String personnage = personnages.getString(j);
                System.out.println(personnage);
            }
        }        
    }
    
    public static void readJSONManipArray() 
            throws Exception {
        String filename = "myjsonfile.json";
        String txtJson = FileReader.loadFileIntoString(filename, "UTF-8");       
        JSONArray root = (JSONArray)JSONSerializer.toJSON(txtJson);        
        
        for (int i=0; i < root.size(); i++) {
            if(root.getString(i).equals("lundi") == true) {
                root.remove(i);
                root.add(i, "mardi");
            }else if(root.getString(i).equals("mardi") == true) {
                root.remove(i);
                root.add(i, "samedi");
            }else if(root.getString(i).equals("mercredi") == true) {
                root.remove(i);
                root.add(i, "jeudi");
            }else if(root.getString(i).equals("jeudi") == true) {
                root.remove(i);
                root.add(i, "vendredi");
            }else if(root.getString(i).equals("vendredi") == true) {
                root.remove(i);
                root.add(i, "samedi");
            }            
            System.out.println(root.getString(i));   
        }
        
        root.add("dimanche");
        System.out.println(root.getString(root.size()-1));  
        System.out.println(root);
    }
}
