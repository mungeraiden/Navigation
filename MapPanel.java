import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Color;
import java.awt.Graphics;

public class MapPanel extends JPanel implements MouseListener {

    private char[][] grid;

    private final int cellSize = 25;

    public MapPanel(char[][] grid) {

        this.grid = grid;

        setBounds(20, 120, 750, 500);
        setBackground(Color.WHITE);

        addMouseListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        for (int row = 0; row < grid.length; row++) {

            for (int column = 0; column < grid[row].length; column++) {

                int x = column * cellSize;
                int y = row * cellSize;

                if (grid[row][column] == '#') {

                    g.setColor(Color.DARK_GRAY);
                    g.fillRect(x, y, cellSize, cellSize);

                } else if (grid[row][column] == 'S') {

                    g.setColor(Color.GREEN);
                    g.fillRect(x, y, cellSize, cellSize);

                } else if (grid[row][column] == 'E') {

                    g.setColor(Color.RED);
                    g.fillRect(x, y, cellSize, cellSize);

                } else if (grid[row][column] == '*') {

                    g.setColor(Color.BLUE);
                    g.fillRect(x, y, cellSize, cellSize);

                } else {

                    g.setColor(Color.WHITE);
                    g.fillRect(x, y, cellSize, cellSize);
                }

                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(x, y, cellSize, cellSize);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        int column = e.getX() / cellSize;
        int row = e.getY() / cellSize;

        if (row < 0 || row >= grid.length) {
            return;
        }

        if (column < 0 || column >= grid[row].length) {
            return;
        }

        if (grid[row][column] == '.') {

            grid[row][column] = '#';

        } else if (grid[row][column] == '#') {

            grid[row][column] = '.';
        }

        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}