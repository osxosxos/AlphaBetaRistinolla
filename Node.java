
package alphabetaristinolla;

import java.util.ArrayList;

public class Node {

    int depth;
    int maxPlayer;
    int currentPlayer;
    int previousPlayer;
    int[][] position;
    Node parent;

    public Node(int depth, int maxPlayer, int currentPlayer,
            int previousPlayer, int[][] position, Node parent) {
        this.depth = depth;
        this.maxPlayer = maxPlayer;
        this.currentPlayer = currentPlayer;
        this.previousPlayer = previousPlayer;
        this.position = position;
        this.parent = parent;
    }

    public int[][] copyPosition(int[][] position) {
        int[][] copy = new int[position.length][position[0].length];
        
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position.length; j++) {
                copy[i][j] = position[i][j];
            }
        }
        
        return copy;
    }

    public ArrayList<Node> GenerateChildren(Node node) {
        ArrayList<Node> children = new ArrayList();
        int[][] startPosition = this.position;

        for (int i = 0; i < startPosition.length; i++) {
            for (int j = 0; j < startPosition[0].length; j++) {

                if (startPosition[i][j] == 0) {
                    int[][] newPosition = this.copyPosition(this.position);
                    int nextPlayer = node.previousPlayer;
                    int prevPlayer = node.currentPlayer;

                    newPosition[i][j] = node.currentPlayer;

                    Node newNode = new Node(
                            node.depth -1,
                            node.maxPlayer,
                            nextPlayer,
                            prevPlayer,
                            newPosition,
                            node
                    );
                    
                    children.add(newNode);
                }

            }
        }

        return children;
    }

}
