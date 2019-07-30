package cisco.java.challenge;

import java.util.List;

public interface GNodeHandler {
    List walkGraph(GNode node);
    List paths(GNode node);
}
