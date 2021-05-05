package com.easysoftwarespringbootapp.easysoftwarespringbootapp.controllers.v1;

import com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities.GeoIP;
import com.easysoftwarespringbootapp.easysoftwarespringbootapp.service.DBDemoGeoIPLocationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@AllArgsConstructor
public class GeoIPTestController {

    public  final DBDemoGeoIPLocationService dbDemoGeoIPLocationService;

    @RequestMapping(value = "/GeoIPTest", method = RequestMethod.POST)
    @ResponseBody
    public GeoIP getLocation(@RequestParam(value = "ipAddress", required = true) String ipAddress) throws Exception {

        return dbDemoGeoIPLocationService.getLocation(ipAddress);
    }
}
