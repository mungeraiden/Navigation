import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Timer;

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

    public static void findPath(char[][] grid, Node start, Node end, Runnable repaint) {

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

                printPath(grid, current, repaint);

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

    public static void printPath(char[][] grid, Node end, Runnable repaint) {

        List<Node> path = new ArrayList<>();

        Node current = end;

        while (current.parent != null) {

            path.add(current);

            current = current.parent;
        }

        Collections.reverse(path);

        final int[] index = {0};

        Timer timer = new Timer(40, e -> {

            if (index[0] < path.size()) {

                Node node = path.get(index[0]);

                if (grid[node.row][node.column] != 'E') {

                    grid[node.row][node.column] = '*';
                }

                repaint.run();

                index[0]++;

            } else {

                ((Timer) e.getSource()).stop();

                System.out.println("Path found!");
                System.out.println("Path length: " + path.size());
            }
        });

        timer.start();
    }
}