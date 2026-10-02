    package org.example.AdapterPattern.XmlData;

// Third-party class returning data in XML format
public class XmlDataProvider {
    public String getXmlData(String rawData) {
        // Simulating 3rd party library behavior
        // Assuming rawData format: "Name:Alice,ID:42"
        String[] parts = rawData.split(",");
        String name = parts[0].split(":")[1];
        String id = parts[1].split(":")[1];

        return "<user><name>" + name + "</name><id>" + id + "</id></user>";
    }
}