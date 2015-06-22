package com.codeborne.geoip;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class timeZoneTest {

  @Test
  public void testTimeZoneByCountryAndRegion() {
    assertEquals("Europe/Tallinn", timeZone.timeZoneByCountryAndRegion("EE", null));
    assertEquals("Europe/Andorra", timeZone.timeZoneByCountryAndRegion("AD", null));
    assertEquals("Asia/Yerevan", timeZone.timeZoneByCountryAndRegion("AM", null));
    assertEquals("Europe/Istanbul", timeZone.timeZoneByCountryAndRegion("TR", null));
    assertEquals("Pacific/Pitcairn", timeZone.timeZoneByCountryAndRegion("PN", null));

    assertEquals("America/Argentina/Buenos_Aires", timeZone.timeZoneByCountryAndRegion("AR", "01"));
    assertEquals("Australia/Adelaide", timeZone.timeZoneByCountryAndRegion("AU", "05"));

    assertEquals("Europe/Volgograd", timeZone.timeZoneByCountryAndRegion("RU", "01"));
    assertEquals("Europe/Volgograd", timeZone.timeZoneByCountryAndRegion("RU", "07"));
    assertEquals("Europe/Moscow", timeZone.timeZoneByCountryAndRegion("RU", "06"));
    assertEquals("Europe/Moscow", timeZone.timeZoneByCountryAndRegion("RU", "10"));
    assertEquals("Asia/Yekaterinburg", timeZone.timeZoneByCountryAndRegion("RU", "13"));

    assertEquals("Asia/Samarkand", timeZone.timeZoneByCountryAndRegion("UZ", "02"));
    assertEquals("Europe/Kiev", timeZone.timeZoneByCountryAndRegion("UA", "01"));
    assertEquals("Europe/Simferopol", timeZone.timeZoneByCountryAndRegion("UA", "08"));

    assertEquals("America/Chicago", timeZone.timeZoneByCountryAndRegion("US", "AL"));
    assertEquals("America/Los_Angeles", timeZone.timeZoneByCountryAndRegion("US", "CA"));
    assertEquals("America/New_York", timeZone.timeZoneByCountryAndRegion("US", "KY"));
  }
}