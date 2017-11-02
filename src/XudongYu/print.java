package XudongYu;

import java.text.NumberFormat;
import java.util.HashMap;

public class print {

    public static void print(HashMap<String, Integer> map_of_result, HashMap<String,Integer> map, Integer sum) {

        HashMap<String, Integer> print = new HashMap<>();
        for (String str : map.keySet()) {
            String newStr = "";
            for (char c : str.toCharArray()) {
                if ((c -'a' >= 0 && c-'a' <=26) || (c -'A' >= 0 && c- 'A' <= 26) || c == ' ') {
                    newStr += c;
                }
            }
            print.put(str, map_of_result.get(newStr));
        }

        NumberFormat nf = NumberFormat.getPercentInstance();
        Double[] percent = new Double[map.size()];
        nf.setMinimumFractionDigits(5);

        System.out.println("------------------------------------------------------------");
        String[] column_Name = {"Company", "Hit Count", "Relevance"};
        System.out.format("%1s %-20s %5s %-9s %5s %-9s %5s", "|", column_Name[0], "|", column_Name[1], "|", column_Name[2], "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        for (String str : print.keySet()) {
            System.out.format("%1s %-20s %5s %9s %5s %9s %5s", "|", str , "|", print.get(str), "|", nf.format(Double.valueOf(print.get(str)) / Double.valueOf(sum)), "|");
            System.out.println("");
        }
        System.out.println("------------------------------------------------------------");
        int totol_hit = 0;
        for (String str : print.keySet()) {
            totol_hit += print.get(str);
        }
        System.out.format("%1s %-20s %5s %9s %5s %9s %5s", "|", "Total", "|", totol_hit, "|", nf.format(Double.valueOf(totol_hit) / Double.valueOf(sum)), "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        System.out.format("%1s %-24s %5s %15s %11s", "|", "Total Words", "|", sum, "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
    }
}
