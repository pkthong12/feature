

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DictionaryNa {
    private static HashMap<String, String> lib;
    private static ArrayList<String> rsString;

    public static void main(String[] args) {
        int count = 0;
        rsString = new ArrayList<>();
        createLib();

        try (Scanner sc = new Scanner(System.in)) {
            String req = sc.nextLine();
            for (int i = 0; i < req.length(); i++) {
                if (i >= req.length() - 1) {
                }  else {

                    int rsInt = findRsDouble(req.charAt(i) + "" + req.charAt(i + 1));
                    count += rsInt;
                    i += rsInt;
                }
            }
        }
        System.out.println(count + " " + rsString);
    }

    private static void createLib() {
        lib = new HashMap<String, String>();
        lib.put("aa", "â");
        lib.put("aw", "ă");
        lib.put("dd", "đ");
        lib.put("ee", "ê");
        lib.put("oo", "ô");
        lib.put("ow", "ơ");
        lib.put("w", "ư");
    }

    private static int findRsDouble(String req) {

        if (lib.get(req) != null) {
            rsString.add(req);
            return 1;
        }
        return 0 + findRsSingle(req);
    }

    private static int findRsSingle(String req) {
        int resInt = 0;
        String[] rs = req.split("");
        if (lib.get(rs[0]) != null) {
            rsString.add(rs[0]);
            resInt = 1;
        } else if (lib.get(rs[1]) != null) {
            rsString.add(rs[1]);
            resInt = 1;
        }
        return resInt;
    }
    
}
