package com.techelevator.dao;

import com.sun.tools.javac.Main;
import com.techelevator.model.Maintenance;
import com.techelevator.model.Property;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcMaintenanceDao implements MaintenanceDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createMaintenanceRequest(int tenantId, Maintenance maintenance) {

        String sql ="INSERT INTO maintenance (user_id, property_id, request, assigned_to, repair_status) " +
                "VALUES (?, (SELECT property_id FROM tenant_unit " +
                "INNER JOIN tenant ON tenant_unit.tenant_id = tenant.tenant_id " +
                "WHERE tenant_user_id = ?),?,null,'incomplete')";
        jdbcTemplate.update(sql,tenantId, tenantId,maintenance.getMaintenanceRequest());
    }

    @Override
    public List<Maintenance> getAllMaintenanceReqs() {
        List<Maintenance> outputList = new ArrayList<>();
        String sql = "SELECT * " +
                "FROM maintenance";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Maintenance maintenance = mapRowToMaintenance(results);
            outputList.add(maintenance);
        }
        return outputList;
    }

    public boolean updateMaintenanceRequest(Maintenance maintenance) {
        String sql ="UPDATE maintenance SET request=?, assigned_to=?, repair_status=? WHERE maintenance_id=?";
        boolean success = false;
        int linesReturned = jdbcTemplate.update(sql,maintenance.getMaintenanceRequest(), maintenance.getAssignedTo(), maintenance.getRepairStatus());
        if (linesReturned == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public Maintenance getMaintenanceRequest(int maintenanceId) {
        Maintenance maintenance = null;
        String sql = "SELECT maintenance_id, property_id, request, assigned_to, repair_status " +
                "FROM maintenance " +
                "WHERE maintenance_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, maintenanceId);
        if (results.next()) {
            maintenance = mapRowToMaintenance(results);
        }
        return maintenance;
    }

    @Override
    public List<Maintenance> searchTickets(int propertyId, String maintenanceRequest, int assignedTo, String repairStatus) {
        return null;
    }

    @Override
    public List<Maintenance> maintenanceRequestByLandlord(int landlordId) {
        ArrayList<Maintenance> requests = new ArrayList<>();
        String sql = "SELECT * FROM maintenance m " +
                "LEFT JOIN property p ON m.property_id = p.property_id " +
                "LEFT JOIN property_landlord pl ON m.property_id = pl.property_id " +
                "LEFT JOIN tenant t ON m.user_id = t.tenant_user_id " +
                "LEFT JOIN landlord l ON pl.landlord_id = l.landlord_id " +
                "WHERE l.landlord_user_id = ?";
        SqlRowSet returnedRequests = jdbcTemplate.queryForRowSet(sql, landlordId);
        while(returnedRequests.next()) {
            requests.add(mapRowToMaintenanceWithName(returnedRequests));
        }
        return requests;
    }

    @Override
    public boolean assignEmployeeToRequest(int employeeId, int maintenanceId) {
        String sql = "UPDATE maintenance " +
                "SET assigned_to = ?" +
                "WHERE maintenance_id = ?;";
        jdbcTemplate.update(sql, employeeId, maintenanceId);
        return true;
    }

    private Maintenance mapRowToMaintenanceWithName(SqlRowSet rowSet) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(rowSet.getInt("maintenance_id"));
        maintenance.setPropertyId(rowSet.getInt("property_id"));
        maintenance.setMaintenanceRequest(rowSet.getString("request"));
        maintenance.setAssignedTo(rowSet.getInt("assigned_to"));
        maintenance.setRepairStatus(rowSet.getString("repair_status"));
        maintenance.setTenantName(rowSet.getString("tenant_name"));
        maintenance.setPropertyAddress(rowSet.getString("prop_address"));

        return maintenance;
    }

    private Maintenance mapRowToMaintenance(SqlRowSet rowSet) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(rowSet.getInt("maintenance_id"));
        maintenance.setPropertyId(rowSet.getInt("property_id"));
        maintenance.setMaintenanceRequest(rowSet.getString("request"));
        maintenance.setAssignedTo(rowSet.getInt("assigned_to"));
        maintenance.setRepairStatus(rowSet.getString("repair_status"));

        return maintenance;
    }
}
