package cisco.java.challenge;

import java.util.ArrayList;
import java.util.List;

public class GNodeHandlerImpl implements GNodeHandler {
    private ArrayList<GNode> list;
    private ArrayList<List<GNode>> pathList;
    /**
     * @param node
     * @return an ArrayList containing every GNode in the graph.
     * Each node should appear in the ArrayList exactly once.
     */
    public ArrayList walkGraph(GNode node) {
        list = new ArrayList<>();
        list.add(node);
        visitChildren(node.getChildren());
        return list;
    }

    private void visitChildren(GNode[] children) {
        if(children.length==0)return;
        for (GNode node:children) {
            list.add(node);
            visitChildren(node.getChildren());
        }
    }

    /**
     * @param node
     * @return ArrayList of ArrayLists, representing all possible
     * paths through the graph starting at 'node'.  The ArrayList returned can be
     * thought of as a ArrayList of paths, where each path is represented as an
     * ArrayList of GNodes
     */
    public ArrayList paths(GNode node) {
        pathList = new ArrayList<>();
        List<GNode> nodeList = new ArrayList<>();
        nodeList.add(node);
        walkPath(node, nodeList);
        return pathList;
    }

    private void walkPath(GNode node, List nodeList){
        if(node.getChildren().length==0) {pathList.add(nodeList); return;}

        for (GNode child: node.getChildren()) {
            List<GNode> childList = new ArrayList<>();
            childList.addAll(nodeList);
            childList.add(child);
            walkPath(child, childList);
        }
    }
}
