package cisco.java.challenge;

import java.util.ArrayList;

public interface GNodeHandler {
    ArrayList walkGraph(GNode node);
    ArrayList paths(GNode node);
}
