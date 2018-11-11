package com.game;

import java.util.Arrays;

public class CellSystem {

    private Cell[][] grid;
    private final int width;
    private final int height;

    public CellSystem(int width, int height) {
        this.width = width;
        this.height = height;
        grid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                grid[i][j] = new Cell();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return grid[x][y];
    }

    public boolean isUnderpopulated(int x, int y) {
        int neighborsAlive = getNeighborsAlive(x, y);
        return neighborsAlive < 2;
    }

    public boolean isInStasis(int x, int y) {
        int neighboursAlive = getNeighborsAlive(x, y);
        return neighboursAlive == 2 || neighboursAlive == 3;
    }

    public boolean isOverpopulated(int x, int y) {
        int neighboursAlive = getNeighborsAlive(x, y);
        return neighboursAlive > 3;
    }

    public boolean canReproduce(int x, int y) {
        int neighboursAlive = getNeighborsAlive(x, y);
        return neighboursAlive == 3;
    }

    private int getNeighborsAlive(int x, int y) {
        int neighborsAlive = 0;
        if (getCell(x - 1, y - 1).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x, y - 1).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x + 1, y - 1).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x - 1, y).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x + 1, y).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x - 1, y + 1).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x, y + 1).isAlive()) {
            neighborsAlive += 1;
        }
        if (getCell(x + 1, y + 1).isAlive()) {
            neighborsAlive += 1;
        }
        return neighborsAlive;
    }
}
