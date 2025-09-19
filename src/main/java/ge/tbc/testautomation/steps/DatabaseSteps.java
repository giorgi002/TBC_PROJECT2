package ge.tbc.testautomation.steps;

import ge.tbc.testautomation.data.LocationModel;
import ge.tbc.testautomation.utils.MSSQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSteps {

    public List<LocationModel> getAllLocations() {
        List<LocationModel> locations = new ArrayList<>();
        String sql = "SELECT * FROM location_cases";

        try (Connection connection = MSSQLConnection.connect();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {

            while (rs.next()) {
                LocationModel location = new LocationModel();
                location.setId(rs.getInt("id"));
                location.setArea(rs.getString("area"));
                location.setExpectedMinResults(rs.getInt("expected_min_results"));
                locations.add(location);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Error reading from DB", e);
        }

        return locations;
    }
}
