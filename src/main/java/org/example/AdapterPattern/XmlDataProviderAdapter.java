package org.example.AdapterPattern;

import org.example.AdapterPattern.Interface.IReports;
import org.example.AdapterPattern.XmlData.XmlDataProvider;

// Adapter implementing Target and wrapping Adaptee (Composition)
public class XmlDataProviderAdapter implements IReports {
    private XmlDataProvider xmlDataProvider;

    public XmlDataProviderAdapter(XmlDataProvider xmlDataProvider) {
        this.xmlDataProvider = xmlDataProvider;
    }

    @Override
    public String getJsonData(String rawData) {
        // Step 1: Fetch XML data from 3rd party Adaptee
        String xmlData = xmlDataProvider.getXmlData(rawData);

        // Step 2: Convert XML data to JSON format
        String name = extractXmlTagValue(xmlData, "name");
        String id = extractXmlTagValue(xmlData, "id");

        return "{\n  \"name\": \"" + name + "\",\n  \"id\": " + id + "\n}";
    }

    private String extractXmlTagValue(String xml, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";
        int start = xml.indexOf(openTag) + openTag.length();
        int end = xml.indexOf(closeTag);
        return xml.substring(start, end);
    }
}