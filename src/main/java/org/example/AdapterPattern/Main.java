package org.example.AdapterPattern;

import org.example.AdapterPattern.Interface.IReports;
import org.example.AdapterPattern.XmlData.XmlDataProvider;

public class Main {
    public static void main(String[] args) {
        // 1. Third-party Adaptee instance
        XmlDataProvider xmlProvider = new XmlDataProvider();

        // 2. Wrap Adaptee inside Adapter
        IReports adapter = new XmlDataProviderAdapter(xmlProvider);

        // 3. Client processes request seamlessly via Adapter
        Client client = new Client();
        String rawData = "Name:Alice,ID:42";

        client.printReport(adapter, rawData);
    }
}