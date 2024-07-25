/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.youtubershub.controller;

import com.youtubershub.model.YoutuberHubModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Hridaya giri
 */
public class SortTableData {
    
    /**
     * The merge sort  algorithm is used in this method to sort an ArrayList of YoutuberHubModel objects.
     * @param modelMainArray  the ArrayList of YoutuberHubModel class object to be sorted
     * @param sortBy  this is the specific column to sort 
     */
    
    public static void mergeSort(ArrayList<YoutuberHubModel> modelMainArray,
            String sortBy) {
    
    //return if array size less than 2 as it is already sorted
    if (modelMainArray.size() < 2) {                            
        return;
    }
    
    int mid = modelMainArray.size() / 2;  // finding middle index to sort the array
    
    //main array is sort into two array
    ArrayList<YoutuberHubModel> leftArray = new ArrayList<>
    (modelMainArray.subList(0, mid)); 
    ArrayList<YoutuberHubModel> rightArray = new ArrayList<>
    (modelMainArray.subList(mid, modelMainArray.size()));

    
    //recursively apply mergersort to the left and right subarrays
    mergeSort(leftArray, sortBy);
    mergeSort(rightArray, sortBy);
    
    // merging the sorted subarrays
    merge(modelMainArray, leftArray, rightArray, sortBy);

}

    
    /**
     * This method mainly merges the two sorted ArrayList into single fully sorted ArrayList
     * @param mergeModelArray  the main array where two sorted sub ArrayList is merged and stored
     * @param leftArray     the first sorted list that is merged in mergeModelArray
     * @param rightArray    the second sorted list that is merged in mergeModelArray       
     * @param sortBy    this is the specific column to sort 
     */
    
    public static void merge(ArrayList<YoutuberHubModel> mergeModelArray, 
    ArrayList<YoutuberHubModel> leftArray, 
    ArrayList<YoutuberHubModel> rightArray, String sortBy) {
    
    int firstCounterValue = 0;
    int secondCounterValue = 0;
    int mainArray = 0;

    
    // check until left or right array is less than 1
    while (firstCounterValue < leftArray.size() 
            && secondCounterValue < rightArray.size()) {
            

        switch (sortBy) {
            case "YoutuberName" -> {
                
                //comparing the youtuber name and updating the main array
                if (leftArray.get(firstCounterValue).getYoutubersName()
                .compareTo(rightArray.get(secondCounterValue)
                        .getYoutubersName()) < 0) {
                    
                    mergeModelArray.set(mainArray, 
                    leftArray.get(firstCounterValue++));
                    mainArray++;
                } else {
                    mergeModelArray.set(mainArray,
                            rightArray.get(secondCounterValue++));
                    mainArray++;
                }
            }
            case "GlobalRank" -> {
                
                //comparing the Global rank  and updating the main array
                int leftRank = leftArray.
                        get(firstCounterValue).getGlobalRank();
                int rightRank =rightArray.
                        get(secondCounterValue).getGlobalRank();
                if (leftRank < rightRank) {
                    mergeModelArray.set(mainArray, 
                            leftArray.get(firstCounterValue++));
                } else {
                    mergeModelArray.set(mainArray, 
                            rightArray.get(secondCounterValue++));
                }
                mainArray++;
            }
            case "YoutuberType" -> {
                
                //comparing the Youtuber Type  and updating the main array
                if (leftArray.get(firstCounterValue).
                    getYoutuberType().compareTo(rightArray.
                    get(secondCounterValue).getYoutuberType()) < 0) {
                    mergeModelArray.set(mainArray, 
                            leftArray.get(firstCounterValue++));
                    mainArray++;
                } else {
                    mergeModelArray.set(mainArray,
                            rightArray.get(secondCounterValue++));
                    mainArray++;
                }
            }
                
            case "ChannelLink" -> {
                
                //comparing the Channel Link  and updating the main array
                if (leftArray.get(firstCounterValue).
                        getChannelLink().compareTo(rightArray.
                        get(secondCounterValue).getChannelLink()) < 0) {
                        mergeModelArray.set(mainArray, leftArray.
                        get(firstCounterValue++));
                    mainArray++;
                } else {
                    mergeModelArray.set(mainArray, rightArray.
                            get(secondCounterValue++));
                    mainArray++;
                }
            }
                
            case "Grade" -> {
                
                //comparing the Grade and updating the main array
                if (leftArray.get(firstCounterValue).
                        getGrade().compareTo(rightArray.
                                get(secondCounterValue).getGrade()) < 0) {
                    mergeModelArray.set(mainArray, leftArray.
                            get(firstCounterValue++));
                    mainArray++;
                } else {
                    mergeModelArray.set(mainArray, rightArray.
                            get(secondCounterValue++));
                    mainArray++;
                }
            }
                
                
               
            case "Subscriber" -> {
                // Removing the suffix and converting to a number
                String leftSubscriber = leftArray.get(firstCounterValue).
                        getSubscriber().replaceAll("[^0-9.]", "");
                String rightSubscriber = rightArray.get(secondCounterValue).
                        getSubscriber().replaceAll("[^0-9.]", "");

        //checking if leftSubscriber is empty if it is, 0 is assigned to leftsubs
        // if leftSubscriber is not empty parsing leftSubscriber as double and assigned to leftsubs
                double leftSubs = leftSubscriber.isEmpty() ? 0 :
                        Double.parseDouble(leftSubscriber);
                
        //checking if rightSubscriber is empty if it is 0 is assign to rightsubs
        // if rightSubscriber is not empty parsing rightSubscriber as double and assigned to rightsubs
                double rightSubs = rightSubscriber.isEmpty() ? 0 : 
                        Double.parseDouble(rightSubscriber);

                // Comparing the numerical values
                if (leftSubs < rightSubs) {
                    mergeModelArray.set(mainArray, leftArray.
                            get(firstCounterValue++));
                } else {
                    mergeModelArray.set(mainArray, rightArray.
                            get(secondCounterValue++));
                }
                mainArray++;
}

            case "NetWorth(in $)" -> {
                // Removing the suffix and converting to a number
                String leftNetWorth = leftArray.get(firstCounterValue).
                        getNetWorth().replaceAll("[^0-9.]", "");
                String rightNetWorth = rightArray.get(secondCounterValue).
                        getNetWorth().replaceAll("[^0-9.]", "");

        //checking if leftNetWorth is empty if it is, 0 is assigned to leftValue
        // if leftNetWorth is not empty parsing leftNetWorth as Integer and assigned to leftValue
                int leftValue = 
                        leftNetWorth.isEmpty() ? 0 : Integer.parseInt
                        (leftNetWorth);
                
        //checking if rightNetWorth is empty if it is, 0 is assigned to rightValue
        // if rightNetWorth is not empty parsing rightNetWorth as Integer and assigned to rightValue
                int rightValue = 
                        rightNetWorth.isEmpty() ? 0 : Integer.parseInt
                        (rightNetWorth);

                // Comparing the numerical values
                if (leftValue < rightValue) {
                    mergeModelArray.set(mainArray, leftArray.get
                    (firstCounterValue++));
                } else {
                    mergeModelArray.set(mainArray, rightArray.get
                    (secondCounterValue++));
                }
                mainArray++;
            }


           
           case "Country" -> {
               
                //comparing the Country and updating the main array
                if (leftArray.get(firstCounterValue).getCountry().
                        compareTo(rightArray.get
                        (secondCounterValue).getCountry()) < 0) {
                        mergeModelArray.set(mainArray, leftArray.
                        get(firstCounterValue++));
                    mainArray++;
                } else {
                    mergeModelArray.set(mainArray, rightArray.get
                    (secondCounterValue++));
                    mainArray++;
                }
            }
           
           case "UserCreated" -> {
               
                //comparing the Global rank  and updating the main array
               if (leftArray.get(firstCounterValue).getUserCreatedDate().
                       compareTo(rightArray.get
                       (secondCounterValue).getUserCreatedDate()) < 0) {
                   
                   mergeModelArray.set(mainArray, leftArray.
                           get(firstCounterValue++));
                mainArray++;
               }
               
               else {
                   mergeModelArray.set(mainArray, rightArray.get
                    (secondCounterValue++));
                   mainArray++;
               }
            }
                
            case "Uploads" -> {
                
               //comparing the Uploads  and updating the main array
                int leftUploads = leftArray.get(firstCounterValue).getUploads();
                int rightUploads = rightArray.get(secondCounterValue).getUploads();
                if (leftUploads < rightUploads) {
                    mergeModelArray.set(mainArray, leftArray.get(firstCounterValue++));
                } else {
                    mergeModelArray.set(mainArray, rightArray.get(secondCounterValue++));
                }
                mainArray++;
            }
                
            case "ActivityStatus" -> {
                
                //comparing the ActivityStatus  and updating the main array
                if (leftArray.get(firstCounterValue).getActiveStatus().
                        compareTo(rightArray.get
                        (secondCounterValue).getActiveStatus()) < 0) {
                    
                    mergeModelArray.set(mainArray, 
                            leftArray.get(firstCounterValue++));
                mainArray++;
                }
                
                else {
                    mergeModelArray.set(mainArray,
                            rightArray.get(secondCounterValue++));
                    mainArray++;
                }
            }
              default -> {
            JOptionPane.showMessageDialog(null, 
            "Column not found", "No result found",
            JOptionPane.ERROR_MESSAGE);
            
        }
    }
}

   
    while (firstCounterValue < leftArray.size()) {
        //set arr element from leftarray
        mergeModelArray.set(mainArray, leftArray.get(firstCounterValue++));
        mainArray++;
    }

    while (secondCounterValue < rightArray.size()) {
        //set arr element from rightarray
        mergeModelArray.set(mainArray, rightArray.get(secondCounterValue++));
        mainArray++;
    }
}


}
