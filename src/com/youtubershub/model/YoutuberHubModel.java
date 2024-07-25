/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.youtubershub.model;

/**
 *
 * @author Hridaya giri
 */
public class YoutuberHubModel {
    String youtubersName;
    int globalRank;
    int uploads;
    String youtuberType;
    String channelLink;
    String grade;
    String subscriber;
    String country;
    String netWorth;
    String userCreatedDate;
    String activeStatus;

    public YoutuberHubModel(String youtubersName, int globalRank, int uploads, String youtuberType, String channelLink, String grade, String subscriber, String country, String netWorth, String userCreatedDate, String activeStatus) {
        this.youtubersName = youtubersName;
        this.globalRank = globalRank;
        this.uploads = uploads;
        this.youtuberType = youtuberType;
        this.channelLink = channelLink;
        this.grade = grade;
        this.subscriber = subscriber;
        this.country = country;
        this.netWorth = netWorth;
        this.userCreatedDate = userCreatedDate;
        this.activeStatus = activeStatus;
    }

    public String getYoutubersName() {
        return youtubersName;
    }

    public void setYoutubersName(String youtubersName) {
        this.youtubersName = youtubersName;
    }

    public int getGlobalRank() {
        return globalRank;
    }

    public void setGlobalRank(int globalRank) {
        this.globalRank = globalRank;
    }

    public int getUploads() {
        return uploads;
    }

    public void setUploads(int uploads) {
        this.uploads = uploads;
    }

    public String getYoutuberType() {
        return youtuberType;
    }

    public void setYoutuberType(String youtuberType) {
        this.youtuberType = youtuberType;
    }

    public String getChannelLink() {
        return channelLink;
    }

    public void setChannelLink(String channelLink) {
        this.channelLink = channelLink;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getNetWorth() {
        return netWorth;
    }

    public void setNetWorth(String netWorth) {
        this.netWorth = netWorth;
    }

    public String getUserCreatedDate() {
        return userCreatedDate;
    }

    public void setUserCreatedDate(String userCreatedDate) {
        this.userCreatedDate = userCreatedDate;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    
    
}
