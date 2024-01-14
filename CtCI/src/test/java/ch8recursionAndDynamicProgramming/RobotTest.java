package ch8recursionAndDynamicProgramming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RobotTest {

    private Robot robot;

    @BeforeEach
    public void setup() {
        this.robot = new Robot();
    }

    @Test
    void whenGridSizeOfOne_returnPathSizeOfOne() {
        boolean[][] grid = {{true}};
        List<Position> directions = robot.pathThroughGrid(grid);

        assertEquals(Arrays.asList(new Position(0,0)), directions);
    }

    @Test
    void whenNoPathExists_returnNull() {
        boolean[][] grid = {{true, true, true}, {false, false, false}, {false, false, false}};
        assertNull(robot.pathThroughGrid(grid));
    }

    @Test
    void whenOnePathThroughGrid_returnPath() {
        boolean[][] grid = {{true, true, true}, {false, false, true}, {false, false, true}};
        List<Position> directions = robot.pathThroughGrid(grid);

        List<Position> expected = Arrays.asList(
                new Position(2, 2),
                new Position(1, 2),
                new Position(0, 2),
                new Position(0, 1),
                new Position(0, 0)
                );
        assertEquals(expected, directions);
    }

    @Test
    void whenDiagonalPathThroughGrid_returnPath() {
        boolean[][] grid = {{true, true, false}, {false, true, true}, {false, false, true}};
        List<Position> directions = robot.pathThroughGrid(grid);

        List<Position> expected = Arrays.asList(
                new Position(2, 2),
                new Position(1, 2),
                new Position(1, 1),
                new Position(0, 1),
                new Position(0, 0)
        );
        assertEquals(expected, directions);
    }
}
