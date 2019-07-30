package cisco.java.challenge;

public class Main {

    public static void main(String[] args) {
        GNode A = new GNodeImpl("A", new GNode[3]);

        GNode B = new GNodeImpl("B", new GNode[2]);
        GNode E = new GNodeImpl("E", new GNode[0]);
        GNode F = new GNodeImpl("F", new GNode[0]);

        GNode C = new GNodeImpl("C", new GNode[3]);
        GNode G = new GNodeImpl("G", new GNode[0]);
        GNode H = new GNodeImpl("H", new GNode[0]);
        GNode I = new GNodeImpl("I", new GNode[0]);

        GNode D = new GNodeImpl("D", new GNode[0]);

        A.getChildren()[0]=B;
        B.getChildren()[0]=E;
        B.getChildren()[1]=F;

        A.getChildren()[1]=C;
        C.getChildren()[0]=G;
        C.getChildren()[1]=H;
        C.getChildren()[2]=I;

        A.getChildren()[2]=D;

        GNodeHandler handler = new GNodeHandlerImpl();
        System.out.println("List of vertexes "+handler.walkGraph(A));
        System.out.println("List of path "+ handler.paths(A));
    }
}


