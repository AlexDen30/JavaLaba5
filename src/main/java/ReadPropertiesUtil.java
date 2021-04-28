import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadPropertiesUtil {
    public String getRealizationValue(String interfaceToSearch) {
        String propValue = "";
        Properties props = new Properties();

        try (InputStream inputStream = this.getClass().getResourceAsStream("Realizations.properties")) {
            props.load(inputStream);
            propValue = props.getProperty(interfaceToSearch);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return propValue;
    }
}
