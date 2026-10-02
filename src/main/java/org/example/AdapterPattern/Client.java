package org.example.AdapterPattern;

import org.example.AdapterPattern.Interface.IReports;

public class Client {
    public void printReport(IReports reportService, String rawData) {
        // Client only interacts with IReports interface
        String json = reportService.getJsonData(rawData);
        System.out.println("Client received JSON output:");
        System.out.println(json);
    }
}