package com.codeborne.geoip;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LookupServiceTest {
  LookupService lookupService;

  @Before
  public void usesProvidedDatabaseFile() throws IOException {
    lookupService = LookupService.indexCache();
  }

  @Test
  public void location1() throws IOException {
    Location location = lookupService.getLocation("217.71.44.212");
    assertEquals("EE", location.countryCode);
    assertEquals("Estonia", location.countryName);
    assertEquals("Tallinn", location.city);
    assertEquals("01", location.region);
    assertEquals(59.4339, location.latitude, 0.0001);
    assertEquals(24.728104, location.longitude, 0.000001);
  }
  
  @Test
  public void location2() throws IOException {
    Location location = lookupService.getLocation("213.172.3.234");
    assertEquals("RU", location.countryCode);
    assertEquals("Russian Federation", location.countryName);
    assertEquals(55.75, location.latitude, 0.01);
    assertEquals(37.616592, location.longitude, 0.000001);
  }

  @Test
  public void location3() throws IOException {
    Location location = lookupService.getLocation("85.117.103.134");
    assertEquals("KZ", location.countryCode);
    assertEquals("Kazakhstan", location.countryName);
    assertEquals("Almaty", location.city);
    assertEquals(43.2565, location.latitude, 0.01);
    assertEquals(76.9284, location.longitude, 0.0001);
  }

  @After
  public void tearDown() {
    if (lookupService != null)
      lookupService.close();
  }
}