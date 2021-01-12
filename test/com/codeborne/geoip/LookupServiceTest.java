package com.codeborne.geoip;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class LookupServiceTest {
  LookupService lookupService;

  @Before
  public void usesProvidedDatabaseFile() throws IOException {
    lookupService = LookupService.indexCache();
  }

  @Test
  public void location1() {
    Location location = lookupService.getLocation("217.71.44.212");
    assertEquals("EE", location.countryCode);
    assertEquals("Estonia", location.countryName);
    assertEquals("Tallinn", location.city);
    assertEquals("01", location.region);
    assertEquals(59.4339, location.latitude, 0.0001);
    assertEquals(24.728104, location.longitude, 0.000001);
  }
  
  @Test
  public void location2() {
    Location location = lookupService.getLocation("213.172.3.234");
    assertEquals("RU", location.countryCode);
    assertEquals("Russian Federation", location.countryName);
    assertEquals(59.89, location.latitude, 0.01);
    assertEquals(30.2642059, location.longitude, 0.000001);
  }

  @Test
  public void location3() {
    Location location = lookupService.getLocation("85.117.103.134");
    assertEquals("KZ", location.countryCode);
    assertEquals("Kazakhstan", location.countryName);
    assertEquals("Almaty", location.city);
    assertEquals(43.2565, location.latitude, 0.01);
    assertEquals(76.9284, location.longitude, 0.0001);
  }

  @Test @Ignore("current implementation of geo-ip fails for this South Sudan address (it's quite new country)")
  public void location4() {
    Location location = lookupService.getLocation("105.235.210.70");
    assertEquals("SS", location.countryCode);
    assertEquals("Южный Судан", location.countryName);
    assertEquals("Африка", location.city);
    assertEquals(4.85, location.latitude, 0.01);
    assertEquals(31.6, location.longitude, 0.0001);
  }

  @Test
  public void databaseInfo() throws ParseException {
    DatabaseInfo databaseInfo = lookupService.getDatabaseInfo();
    // based on "GEO-533LITE 20180327 Build 1 Copyright (c) 2018 MaxMind Inc All Rights Reserved"
    assertEquals(428, databaseInfo.getType());
    assertEquals(new SimpleDateFormat("dd.MM.yyyy").parse("27.03.2018"), databaseInfo.getDate());
  }

  @After
  public void tearDown() {
    if (lookupService != null)
      lookupService.close();
  }
}