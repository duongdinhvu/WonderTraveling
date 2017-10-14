/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Untils;

import entities.Car;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sessionbean.CarFacadeLocal;

/**
 *
 * @author REY
 */
public class CarPagination {

    //CarFacadeLocal carFacade = lookupCarFacadeLocal();

    CarFacadeLocal carFacade = lookupCarFacadeLocal();
    private int recordOnPage;
    private int totalPage;
    private int currentPage;
    private int recordOnLastPage;
    private List<Car> listOnPage;
    private List<String> listAllKey;
    private int startPage;
    private int endPage;

    public int getRecordOnPage() {
        return recordOnPage;
    }

    public void setRecordOnPage(int recordOnPage) {
        this.recordOnPage = recordOnPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRecordOnLastPage() {
        return recordOnLastPage;
    }

    public void setRecordOnLastPage(int recordOnLastPage) {
        this.recordOnLastPage = recordOnLastPage;
    }

    public List<Car> getListOnPage() {
        return listOnPage;
    }

    public void setListOnPage(List<Car> listOnPage) {
        this.listOnPage = listOnPage;
    }

    public List<String> getListAllKey() {
        return listAllKey;
    }

    public void setListAllKey(List<String> listAllKey) {
        this.listAllKey = listAllKey;
    }

    public int getStartPage() {
        return startPage;
    }

    public void setStartPage(int startPage) {
        this.startPage = startPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public void GetCarFromListKey() {
        try {
            int start = 0;
            int end = 0;
            totalPage = listAllKey.size() / recordOnPage;
            recordOnLastPage = listAllKey.size() % recordOnPage;
            if (recordOnLastPage > 0) {
                totalPage++;
            }
            start = currentPage * recordOnPage - recordOnPage;
            end = start + recordOnPage - 1;
            if (currentPage == totalPage) {
                if (recordOnLastPage > 0) {
                    end = start + recordOnLastPage - 1;
                }
            }
            String keyOnPages = "";
            for (int i = start; i <= end; i++) {
                String key = listAllKey.get(i);
                keyOnPages += ("'" + key + "',");

            }

            String keySql = keyOnPages.substring(0, keyOnPages.length() - 1);
            System.out.println("key:" + keySql);

            //  listOnPage = toursFacade.findListToursOnPage(keySql);
            Map<Integer, Car> mapCar = new HashMap<>();
            List<Car> listCar = carFacade.findListCarOnPage(keySql);
            listOnPage = carFacade.findListCarOnPage(keySql);
            for (Car car : listCar) {
                mapCar.put(car.getCarID(), car);
            }
            Set<Map.Entry<Integer, Car>> entrySet = mapCar.entrySet();
            List<Map.Entry<Integer, Car>> listOfEntrySet = new ArrayList<Map.Entry<Integer, Car>>(entrySet);

            //Collections.sort(listOfentrySet, new SortByKeyDescending()); // sort Descending
            Collections.sort(listOfEntrySet, new CarSortByKeyDescending());

            System.out.print("\nAfter sorting by key(ascending): ");

            listOnPage = new ArrayList<>();
            Car car = null;
            for (Map.Entry<Integer, Car> entry : listOfEntrySet) {
                System.out.print(entry.getKey() + "=" + entry.getValue().getCarID() + "  ");
                listOnPage.add(entry.getValue());
                // listOnPage.add(entry.getValue()); // add into lsit to show
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void GetStartEnd() {
        try {
            if (totalPage < 5) {
                startPage = 1;
                endPage = totalPage;
            } else {
                if (currentPage == totalPage || currentPage == totalPage - 1) {
                    startPage = totalPage - 4;
                    endPage = totalPage;
                } else if (currentPage == 1 || currentPage == 2) {
                    startPage = 1;
                    endPage = 5;
                } else {
                    startPage = currentPage - 2;
                    endPage = currentPage + 2;
                }
            }
        } catch (Exception e) {
            System.out.println("Error:" + e.getMessage());
        }
    }

    private CarFacadeLocal lookupCarFacadeLocal() {
        try {
            Context c = new InitialContext();
            return (CarFacadeLocal) c.lookup("java:global/WonderTravelling/WonderTravelling-ejb/CarFacade!sessionbean.CarFacadeLocal");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

}
