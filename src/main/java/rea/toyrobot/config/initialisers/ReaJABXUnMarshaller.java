package rea.toyrobot.config.initialisers;

import org.xml.sax.SAXException;
import rea.toyrobot.config.mapper.jabx.ToyRobot;
import rea.toyrobot.exceptions.RobotInitialisationException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

import static javax.xml.XMLConstants.W3C_XML_SCHEMA_NS_URI;

public class ReaJABXUnMarshaller implements ReaUnMarshaller {
    private String fschema;
    private String fxml;
    private ToyRobot toyRobotConfig;

    public ReaJABXUnMarshaller(String schema, String xml) {
        this.fschema = schema;
        this.fxml = xml;
    }

    @Override
    public void readConfigProperties() throws RobotInitialisationException {

        try {
            if (fschema == null || fxml == null) {
                throw new RobotInitialisationException("configuration file is not defined");
            }

            SchemaFactory factory = SchemaFactory.newInstance(W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(fschema));

            JAXBContext jc = JAXBContext.newInstance(ToyRobot.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            unmarshaller.setSchema(schema);
            File xml = new File(fxml);
            toyRobotConfig = (ToyRobot) unmarshaller.unmarshal(xml);
        }
        catch (RobotInitialisationException e) {
            throw e;
        }
        catch (SAXException e) {
            throw new RobotInitialisationException("SAXException has occurred " + e.getMessage());
        }
        catch (JAXBException e) {
            throw new RobotInitialisationException("JABException has occurred " + e.getMessage());
        }
        catch (Exception e) {
            throw new RobotInitialisationException("Unchecked error has occurred " + e.getMessage());
        }
    }

    @Override
    public ToyRobot getToyRobotConfig() {
        return toyRobotConfig;
    }
}
