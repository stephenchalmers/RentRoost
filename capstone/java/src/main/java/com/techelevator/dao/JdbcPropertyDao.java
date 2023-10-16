package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import com.techelevator.model.Property;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    @Override
    public void createProperty(Property property, int landlordId) {
      String sql ="INSERT INTO property (prop_name, prop_address, prop_lat, prop_lng, prop_description, prop_bedrooms, prop_bathrooms, prop_rent, rented, url) VALUES " +
              "(?,?,?,?,?,?,?,?,?,?)";
        String sqlToAssignProperty = "INSERT INTO property_landlord (property_id, landlord_id) " +
                "VALUES ((SELECT property_id FROM property WHERE prop_address = ?), ?)";
     int newProp_id;
        try {
            jdbcTemplate.update(sql,property.getPropertyName(),property.getPropertyAddress(),property.getPropertyLat(), property.getPropertyLng(),property.getPropertyDescription(),property.getPropertyBedrooms(),property.getPropertyBathrooms(),property.getPropertyRent(),property.isRented(),property.getImageUrl());

        } catch(DataAccessException e ){
            System.out.println("Error inserting a property");
        } finally {
            jdbcTemplate.update(sqlToAssignProperty, property.getPropertyAddress(), landlordId);
            System.out.println(property.getPropertyAddress() + landlordId);
        }
    }

    @Override
    public Property getPropertyById(int propertyId) {
        Property property = null;
        String sql = "SELECT * " +
                "FROM property " +
                "WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if (results.next()) {
            property = mapRowToProperty(results);
        }
        return property;
    }

    @Override
    public List<Property> getPropertiesByLandlord(int landlord) {
        List<Property> outputList = new ArrayList<>();
        String sql = "SELECT p.property_id, p.prop_name, p.prop_address, p.prop_lat, p.prop_lng, p.prop_description, p.prop_bedrooms, p.prop_bathrooms, p.prop_rent, p.rented, p.url FROM property p LEFT JOIN property_landlord pl ON p.property_id = pl.property_id WHERE pl.landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlord);
        while (results.next()) {
            Property property = mapRowToProperty(results);
            outputList.add(property);
        }
        return outputList;
    }

    @Override
    public List<Property> getAllProperties() {
        List<Property> outputList = new ArrayList<>();
        String sql = "SELECT p.property_id, p.prop_name, p.prop_address, p.prop_lat, p.prop_lng, p.prop_description, p.prop_bedrooms, p.prop_bathrooms, p.prop_rent, p.rented, p.url " +
                "FROM property p LEFT JOIN property_landlord pl ON p.property_id = pl.property_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Property property = mapRowToProperty(results);
            outputList.add(property);
        }
        return outputList;
    }

    @Override
    public List<Property> searchProperties(int bedrooms, int bathrooms, double minRent, double maxRent) {
        List<Property> outputList = new ArrayList<>();
        String sql = "SELECT p.property_id, p.prop_name, p.prop_address, p.prop_lat, p.prop_lng, p.prop_description, p.prop_bedrooms, p.prop_bathrooms, p.prop_rent, p.rented, p.url " +
                "FROM property p LEFT JOIN property_landlord pl ON p.property_id = pl.property_id " +
                "WHERE p.prop_bedrooms >= ? AND p.prop_bathrooms >= ? AND p.prop_rent BETWEEN ? AND ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, bedrooms, bathrooms, minRent, maxRent);
        while (results.next()) {
            Property property = mapRowToProperty(results);
            outputList.add(property);
        }
        return outputList;
    }

    public boolean updateProperty(Property property) {
        // address price bedrooms bathrooms description
        String sql ="UPDATE property SET prop_name=?, prop_address=?, prop_lat=?, prop_lng=?, prop_description=?, prop_bedrooms=?, prop_bathrooms=?, prop_rent=? WHERE property_id = ?;";
        boolean outcome = false;
        int linesReturned = jdbcTemplate.update(sql, property.getPropertyName(), property.getPropertyAddress(), property.getPropertyLat(), property.getPropertyLng(), property.getPropertyDescription(), property.getPropertyBedrooms(), property.getPropertyBathrooms(), property.getPropertyRent(), property.getPropertyId());
        if (linesReturned == 1) {
            outcome = true;
        }
        return outcome;
    }

    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropertyId(rowSet.getInt("property_id"));
        property.setPropertyName(rowSet.getString("prop_name"));
        property.setPropertyAddress(rowSet.getString("prop_address"));
        property.setPropertyLat(rowSet.getDouble("prop_lat"));
        property.setPropertyLng(rowSet.getDouble("prop_lng"));
        property.setPropertyDescription(rowSet.getString("prop_description"));
        property.setPropertyBedrooms(rowSet.getInt("prop_bedrooms"));
        property.setPropertyBathrooms(rowSet.getInt("prop_bathrooms"));
        property.setPropertyRent(rowSet.getDouble("prop_rent"));
        property.setRented(rowSet.getBoolean("rented"));
        property.setImageUrl(rowSet.getString("url"));
        Map<String, Double> newPosition = new HashMap<>();
        newPosition.put("lat", rowSet.getDouble("prop_lat"));
        newPosition.put("lng", rowSet.getDouble("prop_lng"));

        property.setPropertyPosition(newPosition);

        return property;
    }

}
