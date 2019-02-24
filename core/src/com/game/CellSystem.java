package com.game;

import com.badlogic.gdx.Gdx;
import com.game.gameobjects.GameObject;

public class CellSystem extends GameObject {

    private Cell[][] currentGrid;

    private final int systemWidth;
    private final int systemHeight;
    private final int size = 32;

    public CellSystem(int systemWidth, int systemHeight) {
        this.systemWidth = systemWidth;
        this.systemHeight = systemHeight;
        currentGrid = new Cell[systemWidth][systemHeight];
        for (int i = 0; i < systemWidth; i++) {
            for (int j = 0; j < systemHeight; j++) {
                currentGrid[i][j] = new Cell(i * size, j * size, size, size);
            }
        }
    }

    public void addOffsetToTheCells() {
        int horizontalOffset = ((Gdx.graphics.getWidth() - size * systemWidth) / 2);
        int verticalOffset = ((Gdx.graphics.getHeight() - size * systemHeight) / 2);
        for (int i = 0; i < systemWidth; i++) {
            for (int j = 0; j < systemHeight; j++) {
                currentGrid[i][j].setX(getCell(i, j).getX() + horizontalOffset);
                currentGrid[i][j].setY(getCell(i, j).getY() + verticalOffset);
            }
        }
    }

    @Override
    public void act(float delta) {
        Cell[][] futureGrid = cloneCurrentGrid();

        for (int i = 0; i < systemWidth; i++) {
            for (int j = 0; j < systemHeight; j++) {
                if (getCell(i, j).isAlive()) {
                    if (isUnderpopulated(i, j)) {
                        futureGrid[i][j].kill();
                    } else if (isInStasis(i, j)) {
                        continue;
                    } else if (isOverpopulated(i, j)) {
                        futureGrid[i][j].kill();
                    }
                } else {
                    if (canReproduce(i, j)) {
                        futureGrid[i][j].revive();
                    }
                }

            }
        }
        currentGrid = futureGrid;
    }

    @Override
    public void draw() {
        for (Cell[] cellColumn : getCurrentGrid()) {
            for (Cell cell : cellColumn) {
                cell.draw();
            }
        }
    }

    public Cell getCell(int x, int y) {
        return currentGrid[x][y];
    }

    public Cell[][] getCurrentGrid() {
        return currentGrid;
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
        try {
            if (getCell(x - 1, y - 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x, y - 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x + 1, y - 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x - 1, y).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x + 1, y).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x - 1, y + 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x, y + 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        try {
            if (getCell(x + 1, y + 1).isAlive()) {
                neighborsAlive += 1;
            }
        } catch (ArrayIndexOutOfBoundsException ignored) {
        }
        return neighborsAlive;
    }

    private Cell[][] cloneCurrentGrid() {
        Cell[][] newGrid = new Cell[systemWidth][systemHeight];
        for (int i = 0; i < systemWidth; i++) {
            for (int j = 0; j < systemHeight; j++) {
                newGrid[i][j] = new Cell(getCell(i, j).getX(), getCell(i, j).getY(), size, size);
                if (getCell(i, j).isAlive()) {
                    newGrid[i][j].revive();
                }
            }
        }
        return newGrid;
    }
}
