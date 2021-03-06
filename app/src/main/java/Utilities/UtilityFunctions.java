package Utilities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static java.lang.System.in;

/**
 * Created by shafi on 7/18/2017.
 */

public  class UtilityFunctions {

    public  ArrayList<String> tagSplitter(String tags){
        String [] splits = tags.split(",");
        ArrayList<String> tagList = new ArrayList<>();

        for (String s : splits){
            tagList.add(s);
        }
        return tagList;
    }

    public String getStarBack(int n){
        String star = "";
        for (int i = 0; i < n; i++){
            star += "*";
        }
        return star;
    }

    public int properRatingGet (String aString){
        int toRet = 0;

        for (int i = 0; i < aString.length(); i++){
            if (!isNum(aString.charAt(i)))
                return  0;
        }
        toRet = Integer.parseInt(aString);
        return toRet;
    }

    private boolean isNum (char c){
        if (c >= '0' && c <= '9')
            return true;
        return false;
    }

    public String getTagsFromList(ArrayList<String> tags){
        String ret = "";
        for (String x : tags){
            ret += x + ", ";
        }
        return ret;
    }
}
