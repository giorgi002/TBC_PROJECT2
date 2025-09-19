package ge.tbc.testautomation.data;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DatabaseInitializer {
    public static void initialize() {
        try (Connection conn = DriverManager.getConnection(DBConfiguration.getURL(), DBConfiguration.getUsername(), DBConfiguration.getPassword());
             Statement stmt = conn.createStatement()) {

            try (InputStream is = DatabaseInitializer.class.getClassLoader().getResourceAsStream("init_locations.sql")) {
                if (is == null) {
                    throw new RuntimeException("init_locations.sql not found in resources");
                }
                String sql = new BufferedReader(new InputStreamReader(is))
                        .lines()
                        .collect(Collectors.joining("\n"));

                for (String s : sql.split(";")) {
                    String trimmed = s.trim();
                    if (!trimmed.isEmpty()) {
                        stmt.execute(trimmed);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }
}
