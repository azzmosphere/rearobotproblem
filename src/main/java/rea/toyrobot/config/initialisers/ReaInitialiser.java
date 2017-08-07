package rea.toyrobot.config.initialisers;

import rea.toyrobot.client.RobotClient;
import rea.toyrobot.exceptions.RobotInitialisationException;

import java.util.List;

public class ReaInitialiser implements Initialiser {
    @Override
    public void setSchema(String xmlschema) {

    }

    @Override
    public void setConfig(String xmlconfig) {

    }

    @Override
    public void initialise() throws RobotInitialisationException {

    }

    @Override
    public List<RobotClient> getClients() {
        return null;
    }

    @Override
    public void setReaUnMarshaller(ReaUnMarshaller reaUnMarshaller) {

    }
}
