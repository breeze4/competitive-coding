package graph;

import javafx.scene.control.Cell;
import org.junit.Assert;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MazeSearch {

    private final static int EMPTY = 0;
    private final static int WALL = 1;
    private final static int START = 2;
    private final static int END = 3;

    public static void main(String[] args) {
        Cell[][] maze4x4 = init4x4Maze();
        boolean bfsPathFound4x4 = findPathBFS(maze4x4, 0, 0);
        Assert.assertTrue(bfsPathFound4x4);

        maze4x4 = init4x4Maze();
        boolean dfsPathFound4x4 = findPathDFS(maze4x4, 0, 0);
        Assert.assertTrue(dfsPathFound4x4);
    }

    public static boolean findPathBFS(Cell[][] m, int startRow, int startCol) {
        boolean pathFound = false;
        Queue<Cell> queue = new ArrayDeque<>();
        queue.add(m[startRow][startCol]);

        while (!queue.isEmpty()) {
            Cell curr = queue.poll();
            int row = curr.row;
            int col = curr.col;

            if (curr.state == END) {
                pathFound = true;
                break;
            }
            if (shouldVisit(m, row + 1, col))
                queue.add(m[row + 1][col]);
            if (shouldVisit(m, row, col + 1))
                queue.add(m[row][col + 1]);
            if (shouldVisit(m, row - 1, col))
                queue.add(m[row - 1][col]);
            if (shouldVisit(m, row, col - 1))
                queue.add(m[row][col - 1]);

            curr.visited = true;
        }

        return pathFound;
    }

    public static boolean findPathDFS(Cell[][] m, int row, int col) {
        Cell curr = m[row][col];

        boolean pathFound = false;
        if (curr.state == END) {
            pathFound = true;
        }
        curr.visited = true;

        if (!pathFound && shouldVisit(m, row + 1, col))
            pathFound = findPathDFS(m, row + 1, col);

        if (!pathFound && shouldVisit(m, row, col + 1))
            pathFound = findPathDFS(m, row, col + 1);

        if (!pathFound && shouldVisit(m, row - 1, col))
            pathFound = findPathDFS(m, row - 1, col);

        if (!pathFound && shouldVisit(m, row, col - 1))
            pathFound = findPathDFS(m, row, col - 1);

        if (pathFound)
            System.out.println("row: " + row + " col: " + col);

        return pathFound;
    }

    private static boolean shouldVisit(Cell[][] m, int row, int col) {
        return row >= 0
                && col >= 0
                && row < m.length
                && col < m[row].length
                && !m[row][col].visited
                && m[row][col].state != WALL;
    }

    private static Cell[][] init4x4Maze() {
        Cell[][] m = new Cell[4][4];
        for (int row = 0; row < m.length; row++) {
            for (int col = 0; col < m[row].length; col++) {
                m[row][col] = cell(row, col);
            }
        }
        m[0][0].state = START;
        m[0][1].state = EMPTY;
        m[0][2].state = WALL;
        m[0][3].state = EMPTY;
        m[1][0].state = WALL;
        m[1][1].state = EMPTY;
        m[1][2].state = EMPTY;
        m[1][3].state = EMPTY;
        m[2][0].state = EMPTY;
        m[2][1].state = EMPTY;
        m[2][2].state = WALL;
        m[2][3].state = EMPTY;
        m[3][0].state = WALL;
        m[3][1].state = EMPTY;
        m[3][2].state = WALL;
        m[3][3].state = END;
        return m;
    }

    private static Cell cell(int row, int col) {
        Cell c = new Cell();
        c.state = EMPTY;
        c.row = row;
        c.col = col;
        return c;
    }

    static class Cell {
        boolean visited;
        int state;
        int row;
        int col;
    }
}


