package rea.toyrobot;

/**
 * Run the ToyRobot server and initialise any clients.  For this instance a
 * client represents a interface that can be used to communicate with the
 * server. By default the command line client is initialised and can be used
 * from standard input and output.
 */

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;
import rea.toyrobot.exceptions.RobotException;

public class ReaToyRobot {

    @Option(name = "-s", usage = "XML schema used to validate configuration")
    private String xmlSchema;

    @Option(name = "-c", usage = "configuration file")
    private String xmlConfig;

    @Option(name = "-h", usage = "print this help screen")
    private boolean help;

    public void showHelp() {
        System.out.println("-s [SCHEMA] XML Schema to use");
        System.out.println("-c [CONFIG] configuration file");
        System.out.println("-h show this help screen");
    }

    public void run() throws RobotException {
        if (help) {
            showHelp();
            return;
        }

        if (xmlConfig == null || xmlSchema == null) {
            System.out.println("missing required option");
            showHelp();
            return;
        }

    }

    public static void main(String[] args) {
        ReaToyRobot bean = new ReaToyRobot();
        CmdLineParser parser = new CmdLineParser(bean);
        try {
            parser.parseArgument(args);
            bean.run();

        }
        catch (CmdLineException e) {
            System.out.println("ERROR: could not process command line option - " + e.getMessage());
            bean.showHelp();
        }
        catch (RobotException e) {
            System.out.print("ERROR: a fatal error has occurred " + e.getMessage());
        }
    }
}
