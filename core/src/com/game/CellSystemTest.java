package com.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CellSystemTest {
    private CellSystem setUpSystemWithNeighbours(int numberOfNeighbours) {
        CellSystem cellSystem = new CellSystem(3, 3);

        if (numberOfNeighbours == 0) {
            cellSystem.getCell(1, 1).revive();
        } else if (numberOfNeighbours == 1) {
            cellSystem.getCell(1, 1).revive();
            cellSystem.getCell(2, 1).revive();

        } else if (numberOfNeighbours == 2) {
            cellSystem.getCell(1, 1).revive();
            cellSystem.getCell(0, 1).revive();
            cellSystem.getCell(2, 1).revive();
        } else if (numberOfNeighbours == 3) {
            cellSystem.getCell(1, 1).revive();
            cellSystem.getCell(0, 1).revive();
            cellSystem.getCell(0, 2).revive();
            cellSystem.getCell(1, 0).revive();
        } else if (numberOfNeighbours == 4) {
            cellSystem.getCell(1, 1).revive();
            cellSystem.getCell(0, 1).revive();
            cellSystem.getCell(0, 2).revive();
            cellSystem.getCell(2, 1).revive();
            cellSystem.getCell(1, 0).revive();
        } else if (numberOfNeighbours == 5) {
            cellSystem.getCell(1, 1).revive();
            cellSystem.getCell(0, 1).revive();
            cellSystem.getCell(0, 2).revive();
            cellSystem.getCell(1, 0).revive();
            cellSystem.getCell(1, 2).revive();
            cellSystem.getCell(2, 2).revive();
        }
        return cellSystem;
    }

    @Test
    public void testCheckCellIsUnderpopulatedWithZeroNeighbours() {
        //Given
        CellSystem zeroNeighbourSystem = setUpSystemWithNeighbours(0);
        //When
        //Then
        assertTrue(zeroNeighbourSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsUnderpopulatedWithOneNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(1);
        //When
        //Then
        assertTrue(cellSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsNotUnderpopulatedWithTwoNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(2);
        //When
        //Then
        assertFalse(cellSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsInStasisWithTwoNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(2);
        //When
        //Then
        assertTrue(cellSystem.isInStasis(1, 1));
    }

    @Test
    public void testCheckCellIsInStasisWithThreeNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(3);
        //When
        //Then
        assertTrue(cellSystem.isInStasis(1, 1));
    }

    @Test
    public void testCheckCellIsNotInStasisWithZeroNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(0);
        //When
        //Then
        assertFalse(cellSystem.isInStasis(1, 1));
    }

    @Test
    public void testCheckCellIsNotInStasisWithFourNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(4);
        //Then
        assertFalse(cellSystem.isInStasis(1, 1));
    }

    @Test
    public void testCheckCellIsOverpopulatedWithFourNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(4);
        //Then
        assertTrue(cellSystem.isOverpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsNotOverpopulatedWithThreeNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(3);
        //When
        //Then
        assertFalse(cellSystem.isOverpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsOverpopulatedWithFiveNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(5);
        //When
        //Then
        assertTrue(cellSystem.isOverpopulated(1, 1));
    }

    @Test
    public void testCheckCellCanReproduceWithThreeNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(3);
        //When
        //Then
        assertTrue(cellSystem.canReproduce(1, 1));
    }

    @Test
    public void testCheckCellCanNotReproduceWithTwoNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(2);
        //When
        //Then
        assertFalse(cellSystem.canReproduce(1, 1));
    }

    @Test
    public void testCheckCellCanNotReproduceWithFourNeighbours() {
        //Given
        CellSystem cellSystem = setUpSystemWithNeighbours(4);
        //When
        //Then
        assertFalse(cellSystem.canReproduce(1, 1));
    }
}