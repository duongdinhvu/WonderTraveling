package Untils;

import entities.Tours;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;


public class SortByKeyDescending implements Comparator<Map.Entry<Date, Tours>> {

    @Override
    public int compare(Map.Entry<Date, Tours> o1, Map.Entry<Date, Tours> o2) {
        return (o2.getKey()).compareTo(o1.getKey());
    }

 
}
