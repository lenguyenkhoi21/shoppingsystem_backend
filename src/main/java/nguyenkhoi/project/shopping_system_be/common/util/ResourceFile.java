/*
 * Copyright (c) 2021. By Le Nguyen Khoi All Rights Reserved.
 * AdoptOpenJDK 11
 * Spring Boot 2.5.1
 * The Shopping System
 */

package nguyenkhoi.project.shopping_system_be.common.util;

import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceFile {
    public static String getAvatarImage() throws Exception {
        File file = ResourceUtils.getFile("classpath:image/base64/avatar.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getProductImage() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/water.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getLoremipsum() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/loremipsum.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage1() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/tra_tat.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage2() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_cam_ep.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage3() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/tra_dao.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage4() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_dua_hau_ep.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage5() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_chanh_day_ep.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage6() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/bac_xiu_da.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getImage7() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/bac_xiu_nong.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes1() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/tra_tac_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes2() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_cam_ep_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes3() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/tra_dao_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes4() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_dua_hau_ep_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes5() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/nuoc_chanh_day_ep_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes6() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/Bac_siu_da_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

    public static String getDes7() throws IOException {
        File file = ResourceUtils.getFile("classpath:image/base64/bac_siu_nong_des.txt");
        return new String(Files.readAllBytes(file.toPath()));
    }

}
