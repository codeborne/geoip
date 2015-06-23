package com.codeborne.geoip;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class LookupServiceTest {
  LookupService lookupService;

  @Test
  public void usesProvidedDatabaseFile() throws IOException {
    lookupService = LookupService.indexCache();

    Location location = lookupService.getLocation("217.71.44.212");
    assertEquals("EE", location.countryCode);
    assertEquals("Estonia", location.countryName);
    assertEquals("Tallinn", location.city);
    assertEquals("01", location.region);
    assertEquals(59.4339, location.latitude, 0.0001);
    assertEquals(24.728104, location.longitude, 0.000001);

    Location location2 = lookupService.getLocation("213.172.3.234");
    assertEquals("RU", location2.countryCode);
    assertEquals("Russian Federation", location2.countryName);
    assertEquals(55.75, location2.latitude, 0.01);
    assertEquals(37.616592, location2.longitude, 0.000001);
  }

  @After
  public void tearDown() {
    if (lookupService != null)
      lookupService.close();
  }
}