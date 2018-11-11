import com.sun.org.apache.xml.internal.utils.StringComparable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class functionalfun {
    public static void main(String[] args) {
        Kattio katt = new Kattio(System.in);
        String domain;
        while((domain = katt.getLine()) != null){
            ArrayList<String> domainStrings = new ArrayList<>(Arrays.asList(domain.split(" ")));
            String codomain = katt.getLine();
            ArrayList<String> codomainStrings = new ArrayList<>(Arrays.asList(codomain.split(" ")));
            int nrFunctions = katt.getInt();
            HashMap<String, ArrayList<String>> functions = new HashMap<>();
            HashMap<String, Integer> f2Hits = new HashMap<>();
            boolean notFunction = false;
            for (int i = 0; i < nrFunctions; i++) {
                String f1 = katt.getWord();
                katt.getWord();
                String f2 = katt.getWord();
                if(f2Hits.containsKey(f2)){
                    f2Hits.put(f2, f2Hits.get(f2)+1);
                } else {
                    f2Hits.put(f2, 1);
                }
                if(functions.containsKey(f1) && !functions.get(f1).contains(f2)){
                    notFunction = true;
                } else if(functions.containsKey(f1)){
                    functions.get(f1).add(f2);
                } else {
                    ArrayList<String> tmp = new ArrayList<>();
                    tmp.add(f2);
                    functions.put(f1, tmp);
                }
            }
            if(notFunction){
                System.out.println("not a function");
            } else {
                if(isBijective(domainStrings, codomainStrings, functions,
                        f2Hits)){
                    System.out.println("bijective");
                } else if(isSurjective(domainStrings, codomainStrings,
                        functions)){
                    System.out.println("surjective");
                } else if(isInjective(domainStrings, codomainStrings,
                        functions, f2Hits)){
                    System.out.println("injective");
                } else {
                    System.out.println("neither injective nor surjective");
                }
            }
        }
    }

    private static boolean isBijective(ArrayList<String> domain,
                                       ArrayList<String> codomain,
                                       HashMap<String,
                                               ArrayList<String>> functions,
                                       HashMap<String, Integer> hits){
        return isSurjective(domain, codomain, functions)
                && isInjective(domain, codomain, functions, hits);
    }

    private static boolean isSurjective(ArrayList<String> domain,
                                        ArrayList<String> codomain,
                                        HashMap<String,
                                                ArrayList<String>> functions){
        /* get all functionValues */
        ArrayList<String> functionValues = new ArrayList<>();
        for (String dom : domain) {
            if(functions.containsKey(dom)) {
                for (String f : functions.get(dom)) {
                    if(!functionValues.contains(f)) {
                        functionValues.add(f);
                    }
                }
            }
        }
        ArrayList<String> tmp = new ArrayList<>(codomain.subList(1, codomain.size()));
        functionValues.sort(String.CASE_INSENSITIVE_ORDER);
        tmp.sort(String.CASE_INSENSITIVE_ORDER);
        return functionValues.equals(tmp);
    }

    private static boolean isInjective(ArrayList<String> domain,
                                       ArrayList<String> codomain,
                                       HashMap<String,
                                               ArrayList<String>> functions,
                                       HashMap<String, Integer> hits){
        for (Integer integer : hits.values()) {
            if(integer > 1){
                return false;
            }
        }
        return true;
    }
}