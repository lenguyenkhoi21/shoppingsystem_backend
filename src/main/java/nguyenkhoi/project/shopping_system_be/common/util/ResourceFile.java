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
}
