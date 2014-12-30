import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by tom on 30.12.14.
 */
public class PojoSerializationXML {
    public void serialize(Object obj) {
        XStream xStream = new XStream(new StaxDriver());
        String xml = xStream.toXML(obj);
        try (FileOutputStream outputStream = new FileOutputStream(new File("Person.xml"))) {
            outputStream.write(xml.getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public Object deserialize(){
        String xml = null;
        try {
            xml = new String(Files.readAllBytes(Paths.get("Person.xml")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        XStream xStream;
        xStream = new XStream(new StaxDriver());
        return (Object)xStream.fromXML(xml);
    }
}