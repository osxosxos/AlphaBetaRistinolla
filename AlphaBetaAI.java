
package alphabetaristinolla;

import java.util.ArrayList;

public class AlphaBetaAI {

    public int MinValue(Node node, int alpha, int beta) {
        int[][] position = node.position;

        if (this.GameIsOver(position) || node.depth == 0) {
            return this.EvaluateGame(position, node.maxPlayer);
        }

        int value = Integer.MAX_VALUE;

        ArrayList<Node> children = node.GenerateChildren(node);

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            value = Math.min(value, MaxValue(child, alpha, beta));
            beta = Math.min(beta, value);
            if (alpha >= beta) {
                return value;
            }
        }

        return value;
    }

    public int MaxValue(Node node, int alpha, int beta) {
        int[][] position = node.position;

        if (this.GameIsOver(position) || node.depth == 0) {
            return this.EvaluateGame(position, node.maxPlayer);
        }

        int value = Integer.MIN_VALUE;

        ArrayList<Node> children = node.GenerateChildren(node);

        for (int i = 0; i < children.size(); i++) {
            Node child = children.get(i);
            value = Math.max(value, MinValue(child, alpha, beta));
            alpha = Math.max(alpha, value);
            if (alpha >= beta) {
                return value;
            }
        }

        return value;
    }

    public void PrintPosition(int[][] position, String situation) {
        System.out.println(situation);
        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position[0].length; j++) {
                System.out.print(position[i][j]);
            }
            System.lineSeparator();
        }
        System.lineSeparator();
    }

    public int EvaluateGame(int position[][], int player) {
        int winner = GameIsWonBy(position);

        if (winner == player) {
            return 1;
        } else if (winner == 0) {
            return 0;
        } else {
            return -1;
        }
    }

    public int GameIsWonBy(int position[][]) {
        int rows = CheckRows(position);
        int colums = CheckColumns(position);
        int diagonals = CheckDiagonals(position);

        if (rows != 0) {
            return rows;
        } else if (colums != 0) {
            return colums;
        } else if (diagonals != 0) {
            return diagonals;
        } else {
            return 0;
        }
    }

    public int CheckRows(int position[][]) {
        for (int i = 0; i < position.length; i++) {
            if (position[i][0] != 0) {
                if (position[i][1] != 0) {
                    if (position[i][2] != 0) {
                        if (position[i][0] == position[i][1]) {
                            if (position[i][1] == position[i][2]) {
                                return position[i][0];
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public int CheckColumns(int position[][]) {
        for (int i = 0; i < position.length; i++) {
            if (position[0][i] != 0) {
                if (position[1][i] != 0) {
                    if (position[2][i] != 0) {
                        if (position[0][i] == position[1][i]) {
                            if (position[1][i] == position[2][i]) {
                                return position[0][i];
                            }
                        }
                    }
                }
            }
        }

        return 0;
    }

    public int CheckDiagonals(int position[][]) {
        if (position[0][0] == position[1][1]) {
            if (position[1][1] == position[2][2]) {
                if (position[1][1] == position[2][2]) {
                    return position[0][0];
                }
            }
        }

        if (position[0][2] == position[1][1]) {
            if (position[1][1] == position[2][0]) {
                if (position[2][0] == position[0][2]) {
                    return position[1][1];
                }
            }
        }

        return 0;
    }

    public boolean GameIsOver(int position[][]) {

        if (this.GameIsWonBy(position) != 0) {
            return true;
        }

        for (int i = 0; i < position.length; i++) {
            for (int j = 0; j < position.length; j++) {
                if (position[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}
