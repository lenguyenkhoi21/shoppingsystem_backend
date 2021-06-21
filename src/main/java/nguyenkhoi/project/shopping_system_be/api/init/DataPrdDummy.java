/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.api.init;

import nguyenkhoi.project.shopping_system_be.common.util.ResourceFile;

import java.io.IOException;

public class DataPrdDummy {
    private String name1 = "Trà tắt";
    private String image1;
    private String description1;
    private int price1 = 16000;
    private boolean status1 = true;

    private String name2 = "Nước cam ép";
    private String image2;
    private String description2;
    private int price2 = 23000;
    private boolean status2 = true;

    private String name3 = "Trà Đào";
    private String image3;
    private String description3;
    private int price3 = 23000;
    private boolean status3 = true;

    private String name4 = "Nước dưa hấu ép";
    private String image4;
    private String description4;
    private int price4 = 24000;
    private boolean status4 = true;

    private String name5 = "Nước dưa chanh dây ép";
    private String image5;
    private String description5;
    private int price5 = 23000;
    private boolean status5 = true;

    private String name6 = "Bạc sĩu đá";
    private String image6;
    private String description6;
    private int price6 = 14000;
    private boolean status6 = true;

    private String name7 = "Bạc sĩu nóng";
    private String image7;
    private String description7;
    private int price7 = 14000;
    private boolean status7 = true;

    public String getImage1() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage2() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage3() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage4() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage5() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage6() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getImage7() throws IOException {
        return ResourceFile.getProductImage();
    }

    public String getDescription1() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription2() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription3() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription4() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription5() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription6() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getDescription7() throws IOException {
        return ResourceFile.getLoremipsum();
    }

    public String getName1() {
        return name1;
    }

    public String getName2() {
        return name2;
    }

    public String getName3() {
        return name3;
    }

    public String getName4() {
        return name4;
    }

    public String getName5() {
        return name5;
    }

    public String getName6() {
        return name6;
    }

    public String getName7() {
        return name7;
    }

    public int getPrice1() {
        return price1;
    }

    public int getPrice2() {
        return price2;
    }

    public int getPrice3() {
        return price3;
    }

    public int getPrice4() {
        return price4;
    }

    public int getPrice5() {
        return price5;
    }

    public int getPrice6() {
        return price6;
    }

    public int getPrice7() {
        return price7;
    }

    public boolean isStatus1() {
        return status1;
    }

    public boolean isStatus2() {
        return status2;
    }

    public boolean isStatus3() {
        return status3;
    }

    public boolean isStatus4() {
        return status4;
    }

    public boolean isStatus5() {
        return status5;
    }

    public boolean isStatus6() {
        return status6;
    }

    public boolean isStatus7() {
        return status7;
    }
}
