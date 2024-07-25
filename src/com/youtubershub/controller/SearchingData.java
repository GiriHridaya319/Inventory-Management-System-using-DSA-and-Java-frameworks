/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.youtubershub.controller;

import com.youtubershub.model.YoutuberHubModel;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hridaya giri
 */
public class SearchingData {
    
    /**
     *  This method perform a Binary search from the search value of the YoutuberHubModel
     * class  objects based on the column selected by the user 
     * @param searchValue the value to search which is defined by users
     * @param model The list of YoutuberHubModel objects to search
     * @param low  The lowest index of the array
     * @param high  The highest index of the array
     * @param column The column the user selects to filter the search
     * @return A list of YoutuberHubModel objects that match the search 
     * value within the specified column.
     */
    
    public static List<YoutuberHubModel> performBinarySearch(String searchValue,
            List<YoutuberHubModel> model, int low, int high, String column) {
        List<YoutuberHubModel> resultModels = new ArrayList<>();                  // Initializing empty list to store to store search values
        while (low <= high) {
            int mid = low + (high - low) / 2;                                     // finding the mid of the list 
            String midColumnValue = columnValues(model.get(mid),
                    column);                                                      // getting the value of specific column selectde by user
            int result;
            if (column.equals("GlobalRank") || column.equals
                ("Uploads") || column.equals("Subscriber") || 
                    column.equals("NetWorth(in $)") ) {
                try {
                    // For numerical columns, remove the 'M'
                    // comapring string to double and comapring both of them
                    double midColumnValueNum = Double.parseDouble
                    (midColumnValue.replaceAll("[^0-9.]", ""));
                    double searchValueNum = Double.parseDouble
                    (searchValue.replaceAll("[^0-9.]", ""));
                    result = Double.compare(midColumnValueNum, 
                            searchValueNum);
                } catch (NumberFormatException e) {
                    return null;                                                   //  null is returned to indicate an error
                }
                
            } else {
   
                result = midColumnValue.compareToIgnoreCase(searchValue);      // comparing Integer values containing columns with String lexicographically
            }
            if (result == 0) {                                                    // check if the search value is in the middle if so then add in the empty list
                resultModels.add(model.get(mid));
                // search to the left for any matching value
                int left = mid - 1;                                               
                while (left >= low && columnValues(model.get(left),
                    column).trim().equalsIgnoreCase(
                    searchValue.trim())) {
                    resultModels.add(model.get(left));
                    left--;
                }

                // search to the right for any matching value
                int right = mid + 1;                                              
                while (right <= high && columnValues(model.get(right),
                    column).trim().equalsIgnoreCase(                              
                    searchValue.trim())) {
                    resultModels.add(model.get(right));
                    right++;
                }

                return resultModels;                                               // return the result list
                
    // if search value is less than 0 update low index to search the right half 
            } else if (result < 0) {
                low = mid + 1;
                
    // if search value is greater than 0 update high index to search the left half             
            } else if (result > 0) {
                high = mid - 1;
            }
        }
        return resultModels;
    }

    /**
     * This method retrieves the specific column that is selected by the user 
     * from the YoutuberHubModel object.
     * @param model The object of the YoutuberHubModel
     * @param column The column specified by the user to retrieve the value
     * @return The specific column value of the YoutuberHubModel object
     */
    
    private static String columnValues(YoutuberHubModel model, String column) {
        //determine the column and return the value
        return switch (column) {
            case "GlobalRank" -> String.valueOf(model.getGlobalRank());
            case "YoutuberName" -> model.getYoutubersName();
            case "YoutuberType" -> model.getYoutuberType();
            case "ChannelLink" -> model.getChannelLink();
            case "Grade" -> model.getGrade();
            case "Subscriber" -> model.getSubscriber();
            case "Country" -> model.getCountry();
            case "NetWorth(in $)" -> model.getNetWorth();
            case "UserCreated" -> model.getUserCreatedDate();
            case "Uploads" -> String.valueOf(model.getUploads());
            case "ActivityStatus" -> model.getActiveStatus();
            default -> "";// returning empty string if column is not found 
        };
    }
}





