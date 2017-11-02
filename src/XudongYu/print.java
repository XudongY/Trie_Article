package XudongYu;

import java.text.NumberFormat;
import java.util.HashMap;
import java.util.List;

public class print {

    public static void print(HashMap<String, Integer> map_of_result, HashMap<String,List<String>> company_List, int sum) {

        HashMap<String, Integer> print = new HashMap<>();
        NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMinimumFractionDigits(4);

        System.out.println("------------------------------------------------------------");
        String[] column_Name = {"Company", "Hit Count", "Relevance"};
        System.out.format("%1s %-20s %5s %-9s %5s %-9s %5s", "|", column_Name[0], "|", column_Name[1], "|", column_Name[2], "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        int count_of_total = 0;
        for (String str : company_List.keySet()) {
            int count = 0;
            for (String company : company_List.get(str)) {
                count += map_of_result.get(company);
            }
            System.out.format("%1s %-20s %5s %9s %5s %9s %5s", "|", str , "|", count, "|", nf.format(Double.valueOf(count) / Double.valueOf(sum)), "|");
            System.out.println("");
            count_of_total += count;
        }
        System.out.println("------------------------------------------------------------");
        int totol_hit = 0;
        for (String str : print.keySet()) {
            totol_hit += print.get(str);
        }
        System.out.format("%1s %-20s %5s %9s %5s %9s %5s", "|", "Total", "|", count_of_total, "|", nf.format(Double.valueOf(count_of_total) / Double.valueOf(sum)), "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
        System.out.format("%1s %-24s %5s %15s %11s", "|", "Total Words", "|", sum, "|");
        System.out.println("");
        System.out.println("------------------------------------------------------------");
    }
}
