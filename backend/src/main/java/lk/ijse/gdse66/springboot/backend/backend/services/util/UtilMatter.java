package lk.ijse.gdse66.springboot.backend.backend.services.util;

import java.util.UUID;

public class UtilMatter {
    public static String generateId() {
        return UUID.randomUUID().toString();
    }
}
