package com.codeborne.geoip;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TimeZoneTest {

  @Test
  public void testTimeZoneByCountryAndRegion() {
    assertEquals("Europe/Tallinn", TimeZone.timeZoneByCountryAndRegion("EE", null));
    assertEquals("Europe/Andorra", TimeZone.timeZoneByCountryAndRegion("AD", null));
    assertEquals("Asia/Yerevan", TimeZone.timeZoneByCountryAndRegion("AM", null));
    assertEquals("Europe/Istanbul", TimeZone.timeZoneByCountryAndRegion("TR", null));
    assertEquals("Pacific/Pitcairn", TimeZone.timeZoneByCountryAndRegion("PN", null));

    assertEquals("America/Argentina/Buenos_Aires", TimeZone.timeZoneByCountryAndRegion("AR", "01"));
    assertEquals("Australia/Adelaide", TimeZone.timeZoneByCountryAndRegion("AU", "05"));

    assertEquals("Europe/Volgograd", TimeZone.timeZoneByCountryAndRegion("RU", "01"));
    assertEquals("Europe/Volgograd", TimeZone.timeZoneByCountryAndRegion("RU", "07"));
    assertEquals("Europe/Moscow", TimeZone.timeZoneByCountryAndRegion("RU", "06"));
    assertEquals("Europe/Moscow", TimeZone.timeZoneByCountryAndRegion("RU", "10"));
    assertEquals("Asia/Yekaterinburg", TimeZone.timeZoneByCountryAndRegion("RU", "13"));

    assertEquals("Asia/Samarkand", TimeZone.timeZoneByCountryAndRegion("UZ", "02"));
    assertEquals("Europe/Kiev", TimeZone.timeZoneByCountryAndRegion("UA", "01"));
    assertEquals("Europe/Simferopol", TimeZone.timeZoneByCountryAndRegion("UA", "08"));

    assertEquals("America/Chicago", TimeZone.timeZoneByCountryAndRegion("US", "AL"));
    assertEquals("America/Los_Angeles", TimeZone.timeZoneByCountryAndRegion("US", "CA"));
    assertEquals("America/New_York", TimeZone.timeZoneByCountryAndRegion("US", "KY"));
  }
}