package com.ipChecker.ipCheckerV1;

import java.util.List;

public class ipInformationCheck {

  private final String clientIP;
  private final List<List<String>> ipDb;

  public ipInformationCheck(String clientIP, List<List<String>> ipDb) {
    this.clientIP = clientIP;
    this.ipDb = ipDb;
  }

  public String check() {
    for (List<String> range : ipDb) {
      String start = range.get(0);
      String end = range.get(1);

      if (compareIP(clientIP, start) >= 0 && compareIP(clientIP, end) <= 0) {
        return range.toString();
      }
    }

    return "IP " + clientIP + " is not in any range.";
  }

  private int compareIP(String ipAddress1, String ipAddress2) {
    String[] ip1 = ipAddress1.split("\\.");
    String[] ip2 = ipAddress2.split("\\.");

    for (int i = 0; i < 4; i++) {
      int octet1 = Integer.parseInt(ip1[i]);
      int octet2 = Integer.parseInt(ip2[i]);

      if (octet1 != octet2) {
        return Integer.compare(octet1, octet2);
      }
    }
    return 0;
  }
}
