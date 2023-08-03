package com.ipChecker.ipCheckerV1;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class ipCheck {

  String clientIP;

  public ipCheck(String clientIP) {
    this.clientIP = clientIP;
  }

  public String getClientIP() {
    ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
    String clientIP = requestAttributes.getRequest().getHeader("X-Forwarded-For");
    String[] headerNames = {"X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP",
        "HTTP_CLIENT_IP", "HTTP_X_FORWARDED_FOR"};
    for (String header : headerNames) {
      String value = requestAttributes.getRequest().getHeader(header);
      if (value != null && !value.isEmpty() && !"unknown".equalsIgnoreCase(value)) {
        clientIP = value;
        break;
      }
    }
    if (clientIP == null || clientIP.isEmpty() || "unknown".equalsIgnoreCase(clientIP)) {
      clientIP = requestAttributes.getRequest().getRemoteAddr();
    }
    //localcheck fix
    if (clientIP == "0:0:0:0:0:0:0:1") {
      clientIP = "127.0.0.1";
    }
    return clientIP;
  }
}
