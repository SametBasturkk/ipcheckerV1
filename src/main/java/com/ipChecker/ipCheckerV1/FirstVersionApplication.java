package com.ipChecker.ipCheckerV1;

import ipsorgu.firstVersion.ipDbReader;
import java.io.IOException;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = {
    MongoAutoConfiguration.class,
    MongoDataAutoConfiguration.class
})

public class FirstVersionApplication {

  public static void main(String[] args) throws IOException {
    ipDbReader ipDbReader = new ipDbReader();

    if (System.getProperty("os.name").contains("Windows")) {
      ipDbReader.readerDB("C:\\Users\\samet\\Desktop\\ipCheckerV1\\src\\data\\ip-db.csv");
    } else {
      ipDbReader.readerDB("./ip-db.csv");
    }

    webService webService = new webService();
    webService.run();
    System.out.println("FirstVersionApplication is running");

  }

}
