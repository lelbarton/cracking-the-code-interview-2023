package ch8recursionAndDynamicProgramming;

import java.util.*;

public class Robot {

    // Finds a path from the top left to bottom right
    public List<Position> pathThroughGrid(boolean[][] grid) {
        if (grid == null || grid.length == 0) return Collections.emptyList();
        return pathThroughGridRecursive(grid, new Position(0,0), new ArrayList<>(), new HashSet<>());
    }

    private List<Position> pathThroughGridRecursive(boolean[][] grid, Position pos, List<Position> path, Set<Position> failedPositions) {
        // out of bounds
        if (pos.getRow() >= grid.length || pos.getCol() >= grid[0].length) return null;
        // position not allowed
        if (!grid[pos.getRow()][pos.getCol()]) return null;

        // we've been here before and it didn't work
        if (failedPositions.contains(pos)) return null;

        // success
        if (pos.getRow() == grid.length - 1 && pos.getCol() == grid[0].length - 1) {
            path.add(pos);
            return path;
        }

        // if there's a path to the goal, add this position to the path
        if (pathThroughGridRecursive(grid, new Position(pos.getRow() + 1, pos.getCol()), path, failedPositions) != null ||
        pathThroughGridRecursive(grid, new Position(pos.getRow(), pos.getCol() + 1), path, failedPositions) != null) {
            path.add(pos);
            return path;
        }

        failedPositions.add(pos);
        return null;
    }
}

