package com.easysoftwarespringbootapp.easysoftwarespringbootapp.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeoIP {
    private String ipAddress;
    private String city;
    private String latitude;
    private String longitude;

    public GeoIP(String ipAddress) {
        this.ipAddress = ipAddress;
    }
}
