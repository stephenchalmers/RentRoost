package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import com.techelevator.model.User;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.RestGeocodingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {
    private PropertyDao propertyDao;
    private RestGeocodingService restGeocodingService;
    private LandlordDao landlordDao;
    private UserDao userDao;


    public PropertyController(PropertyDao propertyDao, RestGeocodingService restGeocodingService, LandlordDao landlordDao, UserDao userDao) {
        this.propertyDao = propertyDao;
        this.restGeocodingService = restGeocodingService;
        this.landlordDao = landlordDao;
        this.userDao = userDao;
    }
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Property> getProperties() {
        List<Property> newList = propertyDao.getAllProperties();
        System.out.println("SIZE OF RETURNING LIST: " + newList.size());
        return newList;
    }

    @RequestMapping(path = "/{propertyId}", method = RequestMethod.GET)
    public Property getPropertyById(@PathVariable int propertyId) {
        return propertyDao.getPropertyById(propertyId);
    }

    @RequestMapping(path = "/{propertyId}", method = RequestMethod.PUT)
    public boolean updateProperty(@PathVariable int propertyId, @RequestBody Property property) {
        System.out.println("Updating property: " + property.toString());
        Map <String,Double> newMap = restGeocodingService.getGeocode(property.getPropertyAddress());
        System.out.println(newMap.toString());
        property.setPropertyLat(newMap.get("lat"));
        property.setPropertyLng(newMap.get("lng"));
        return propertyDao.updateProperty(property);
    }

    @RequestMapping(path = "/landlord/{landlord}", method = RequestMethod.GET)
    public List<Property> getPropertyByLandlord(@PathVariable int landlord) {
        return propertyDao.getPropertiesByLandlord(landlord);
    }
    @RequestMapping(path = "/landlord/myproperties", method = RequestMethod.GET)
    public List<Property> getMyProperties(Principal principal) {
        String principalName = principal.getName();
        // get landlord id from principalName
        User authenticatedUser = userDao.findByUsername(principalName);
        Landlord landlord = landlordDao.getLandlordByUserId(authenticatedUser.getId());
        return propertyDao.getPropertiesByLandlord(authenticatedUser.getId());
    }
    @RequestMapping(path ="/addproperty", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property, Principal principal) {
        System.out.println(property.toString());
        System.out.println(principal.getName());
        System.out.println(principal);
        User user = userDao.findByUsername(principal.getName());
        Landlord landlord = landlordDao.getLandlord(user.getId());
        landlord.getLandlordId();
        Map <String,Double> newMap = restGeocodingService.getGeocode(property.getPropertyAddress());
        property.setPropertyLat(newMap.get("lat"));
        property.setPropertyLng(newMap.get("lng"));
        propertyDao.createProperty(property, landlord.getLandlordId());

    }

    @RequestMapping(path="/search")
    public List<Property> searchProperties(@RequestParam(defaultValue = "0") int bedrooms, @RequestParam(defaultValue = "0") int bathrooms, @RequestParam(defaultValue = "0.00") double minrent, @RequestParam(defaultValue = "99999.00") double maxrent) {
        List<Property> newList = propertyDao.searchProperties(bedrooms, bathrooms, minrent, maxrent);
        return newList;
    }
    @RequestMapping(path="/geocode", method = RequestMethod.GET)
    public Map<String, Double> getGeocode(@RequestParam(defaultValue = "") String address) {
        return restGeocodingService.getGeocode(address);
    }

    @RequestMapping(path = "/updateTenantUnit/{propertyName}/{tenantId}", method = RequestMethod.PUT)
    public boolean updateTenantUnit(@PathVariable String propertyName, @PathVariable int tenantId) {

        return landlordDao.changeTenantAddress(propertyName, tenantId);
    }

    @RequestMapping(path = "/landlordstenants", method = RequestMethod.GET)
    public List<Tenant> getLandlordsTenants(Principal principal) {
        System.out.println("Search Performed On: " + principal.getName());
        User user = userDao.findByUsername(principal.getName());
        Landlord landlord = landlordDao.getLandlord(user.getId());
        return landlordDao.listOfLandlordsTenants(landlord.getLandlordId());
    }

    @RequestMapping(path = "/landlordsproperties", method = RequestMethod.GET)
    public List<Property> getLandlordsProperties(Principal principal) {
        User user = userDao.findByUsername(principal.getName());
        Landlord landlord = landlordDao.getLandlord(user.getId());
        System.out.println("Search Performed On: " + principal.getName());
        return landlordDao.getLandlordsProperties(landlord.getLandlordId());
    }


}
