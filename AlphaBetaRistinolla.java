
package alphabetaristinolla;

public class AlphaBetaRistinolla {

    public static void main(String[] args) {

        AlphaBetaAI ai = new AlphaBetaAI();

        int[][] game = new int[][]{
            {1, 1, 2},
            {0, 2, 0},
            {1, 2, 0}
        };

        Node start = new Node(5, 2, 2, 1, game, null);
        
        int result = ai.MinValue(start, -1, -1);
        System.out.println(result);

    }
}
