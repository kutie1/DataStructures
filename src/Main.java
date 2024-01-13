import ds.list.List;

import java.util.HashMap;
import java.util.Map;

public class Main {

    // show map
    

    public static void main(String[] args) {
        // create 2 lists: Standard Java list called jList & List called myList
        List myList = new List();
        java.util.List<String> jList = new java.util.ArrayList<>();
        java.util.Collection col = new java.util.ArrayList<>();

        Map<String, Double> map = new HashMap<>();
        // Canada 9_984.670
        map.put("Canada", 9_984.670);
        map.put("China", 9_596.961);
        map.put("United States", 9_833.517);
        map.put("Brazil", 8_515.779);
        map.put("Australia", 7_741.220);
        map.put("India", 3_287.590);
        map.put("Argentina", 2_780.400);
        map.put("Kazakhstan", 2_724.902);
        map.put("Algeria", 2_381.741);
        map.put("Democratic Republic of the Congo", 2_344.858);
        map.put("Mexico", 1_972.550);

        // Concatenation
        // "hello" + 7 -> Error
        String text = "I have a map: " + map;
//        String text = "I have a map: " + map.toString();

        System.out.println("text = " + text);

    }
}
