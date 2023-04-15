package py.com.daas.java.testdome;

public class RoutePlanner {

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn, boolean[][] mapMatrix) {
        int[][] visited = new int[mapMatrix.length][mapMatrix[0].length];

        return search(fromRow, fromColumn, toRow, toColumn, visited, mapMatrix);
    }

    public static void main(String[] args) {
        boolean[][] mapMatrix = {
                {true, false, false},
                {true, true, false},
                {false, true, true}
        };

        System.out.println(routeExists(0, 0, 2, 2, mapMatrix));
    }

    private static boolean search(int fromRow, int fromColumn, int toRow, int toColumn, int[][] visited,
            boolean[][] mapMatrix) {
        if (isTraversable(fromRow, fromColumn, mapMatrix)) {
            if (fromRow == toRow && fromColumn == toColumn) return true;
            if (visited[fromRow][fromColumn] == 0) {
                visited[fromRow][fromColumn] = 1;
            } else {
                return false;
            }
        } else {
            return false;
        }
        /*
                     | i-1,    j  |
        i,      j-1  | i,      j  | i,    j+1
                     | i+1,    j  |
        */
        boolean upDir = search(fromRow - 1, fromColumn, toRow, toColumn, visited, mapMatrix);
        boolean lefDir = search(fromRow, fromColumn - 1, toRow, toColumn, visited, mapMatrix);
        boolean rightDir = search(fromRow, fromColumn + 1, toRow, toColumn, visited, mapMatrix);
        boolean dowDir = search(fromRow + 1, fromColumn, toRow, toColumn, visited, mapMatrix);

        return upDir || lefDir || rightDir || dowDir;
    }

    private static boolean isTraversable(int rowIndex, int columnIndex, boolean[][] mapMatrix) {
        boolean isDownOutOfBound = rowIndex < 0 || columnIndex < 0;
        boolean isUpOutOfBound = rowIndex > mapMatrix.length - 1 || columnIndex > mapMatrix[0].length - 1;
        if (isDownOutOfBound || isUpOutOfBound) {
            return false;
        }

        return mapMatrix[rowIndex][columnIndex];
    }

}