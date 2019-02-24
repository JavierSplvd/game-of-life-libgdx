package com.game;

import com.badlogic.gdx.Gdx;
import com.game.gameobjects.GameObject;

public class CellSystem extends GameObject {

    private Cell[][] currentGrid;

    private final int systemWidth;
    private final int systemHeight;
    private final int size = 32;

    private float clock = 0;

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
    public void start(){
        getCell(13, 2).revive();
        getCell(14, 2).revive();

        getCell(12, 3).revive();
        getCell(16, 3).revive();

        getCell(11, 4).revive();
        getCell(17, 4).revive();
        getCell(25, 4).revive();

        getCell(1, 5).revive();
        getCell(2, 5).revive();
        getCell(11, 5).revive();
        getCell(15, 5).revive();
        getCell(17, 5).revive();
        getCell(18, 5).revive();
        getCell(23, 5).revive();
        getCell(25, 5).revive();

        getCell(1, 6).revive();
        getCell(2, 6).revive();
        getCell(11, 6).revive();
        getCell(17, 6).revive();
        getCell(21, 6).revive();
        getCell(22, 6).revive();

        getCell(12, 7).revive();
        getCell(16, 7).revive();
        getCell(21, 7).revive();
        getCell(22, 7).revive();
        getCell(35, 7).revive();
        getCell(36, 7).revive();

        getCell(13, 8).revive();
        getCell(14, 8).revive();
        getCell(21, 8).revive();
        getCell(22, 8).revive();
        getCell(35, 8).revive();
        getCell(36, 8).revive();

        getCell(23, 9).revive();
        getCell(25, 9).revive();

        getCell(25, 10).revive();


        addOffsetToTheCells();

    }

    @Override
    public void update(float delta) {
        clock += delta;
        if (clock > 0.05) {
            clock -= 0.05;

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
