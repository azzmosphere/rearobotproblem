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

public class ReaToyRobot {

    @Option(name = "-s", usage = "XML schema used to validate configuration")
    private String xmlSchema;

    @Option(name = "-c", usage = "configuration file")
    private String xmlConfig;

    @Option(name = "-h", usage = "print this help screen")
    private boolean help;

    public void run() {

    }

    public static void main(String[] args) {
        ReaToyRobot bean = new ReaToyRobot();
        CmdLineParser parser = new CmdLineParser(bean);
        try {
            parser.parseArgument(args);
            bean.run();

        }
        catch (CmdLineException e) {
            // TODO: ...
            System.out.print("help");
        }
    }
}
