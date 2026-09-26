import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) {

        LaunchPage launchPage = new LaunchPage();

    }

    public static boolean isValidMove(char[][] grid, int row, int column) {

        if (row < 0 || row >= grid.length) {
            return false;
        }

        if (column < 0 || column >= grid[row].length) {
            return false;
        }

        if (grid[row][column] == '#') {
            return false;
        }

        return true;
    }

    public static void findPath(char[][] grid, Node start, Node end) {

        Queue<Node> queue = new LinkedList<>();

        boolean[][] visited = new boolean[grid.length][];

        for (int row = 0; row < grid.length; row++) {
            visited[row] = new boolean[grid[row].length];
        }

        queue.add(start);

        visited[start.row][start.column] = true;

        while (!queue.isEmpty()) {

            Node current = queue.remove();

            if (current.row == end.row && current.column == end.column) {

                printPath(grid, current);

                return;
            }

            int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
            };

            for (int[] direction : directions) {

                int newRow = current.row + direction[0];
                int newColumn = current.column + direction[1];

                if (isValidMove(grid, newRow, newColumn)) {

                    if (!visited[newRow][newColumn]) {

                        visited[newRow][newColumn] = true;

                        Node neighbor = new Node(newRow, newColumn);

                        neighbor.parent = current;

                        queue.add(neighbor);
                    }
                }
            }
        }

        System.out.println("No path found.");
    }

    public static void printPath(char[][] grid, Node end) {

        Node current = end;

        int pathLength = 0;

        while (current.parent != null) {

            if (grid[current.row][current.column] != 'E') {

                grid[current.row][current.column] = '*';
            }

            current = current.parent;

            pathLength++;
        }

        System.out.println("Path found!");

        System.out.println("Path length: " + pathLength);
    }
}