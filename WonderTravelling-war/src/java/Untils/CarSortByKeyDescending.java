/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Untils;

import entities.Car;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author REY
 */
public class CarSortByKeyDescending implements Comparator<Map.Entry<Integer, Car>> {

    @Override
    public int compare(Map.Entry<Integer, Car> o1, Map.Entry<Integer, Car> o2) {
        return (o2.getKey()).compareTo(o1.getKey());
    }

 
}
