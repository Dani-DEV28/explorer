import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        // Implement your method here!
        // Please also make more test cases
        // I STRONGLY RECOMMEND testing some helpers you might make too
        boolean[][] visited = new boolean[island.length][island[0].length];
        int[] start = islanderLocation(island);

        return reachableArea(island, visited, start);
    }

    public static int reachableArea(int[][] island, boolean[][] visited, int[] current) {
        int curR = current[0];
        int curC = current[1];

        if (curR < 0 || curR >= island.length || curC < 0 || curC >= island[0].length) return 0;
        if (visited[curR][curC]) return 0;
        if (island[curR][curC] == 2 || island[curR][curC] == 3) return 0;
        
        if (island[curR][curC] == 0) {
            throw new IllegalArgumentException("Extra Explorer found");
        }

        visited[curR][curC] = true;

        int space = 1;

        List<int[]> neighbors = possibleMoves(island, current);

        for (int[] neighbor : neighbors) {
            space += reachableArea(island, visited, neighbor);
        }

        return space;
    }

    public static List<int[]> possibleMoves(int[][] enclosure, int[] currentLocation) {
        List<int[]> moves = new ArrayList<>();

        int curR = currentLocation[0];
        int curC = currentLocation[1];

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int[] d : directions) {
            int newR = curR + d[0];
            int newC = curC + d[1];
            if (newR >= 0 && newR < enclosure.length && newC >= 0 && newC < enclosure[0].length) {
                if (enclosure[newR][newC] != 2 && enclosure[newR][newC] != 3) {
                    moves.add(new int[]{newR, newC});
                }
            }
        }

        return moves;
    }

    public static int[] islanderLocation(int[][] island) {
        for (int i = 0; i < island.length; i++) {
            for (int j = 0; j < island[i].length; j++) {
                if (island[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No explorer starting point (value 0) found");
    }
}
