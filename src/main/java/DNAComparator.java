import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class DNAComparator {

    static public Boolean dnaComparator(HashMap<String, ArrayList<Double>> listLucosSuspect,
                                     HashMap<String, ArrayList<Double>> comparedToList){
        int cptDiff = 0;
        int cptIdentitque = 0;
        String lucosError = null;
        for (String key : comparedToList.keySet()) {
            ArrayList<Double> currentComparedValue = comparedToList.get(key); // my entry
            ArrayList<Double> suspectListLucosAllel = listLucosSuspect.get(key); // gived from user
            Collections.sort(currentComparedValue);
            Collections.sort(suspectListLucosAllel);
            if(!suspectListLucosAllel.equals(currentComparedValue)){
                cptDiff++;
                if(cptDiff >1){
                    return false;
                }
                lucosError = key;
            }
            cptIdentitque++;
        }
        if(lucosError != null && cptIdentitque>10){
            //techniquement de rapprochement
            ArrayList<Double> currentComparedValue = comparedToList.get(lucosError); // my entry
            ArrayList<Double> suspectListLucosAllel = listLucosSuspect.get(lucosError); // gived from user
            int sizeCurrentComparedValue = currentComparedValue.size();
            int sizeSuspectListLucosAllel = suspectListLucosAllel.size();
            // il rest a voir seulement le cas de 3 / 2 et apres
            if(sizeSuspectListLucosAllel==2 && sizeCurrentComparedValue==3){
                for (Double aDouble : suspectListLucosAllel) {
                    if (!currentComparedValue.contains(aDouble)) {
                        return false;
                    }
                }
            }else if(sizeCurrentComparedValue == 2 && sizeSuspectListLucosAllel==3){
                for (Double aDouble : currentComparedValue) {
                    if (!suspectListLucosAllel.contains(aDouble)) {
                        return false;
                    }
                }
            }else{
                return false;
            }
        }
        return true;
    }
}
