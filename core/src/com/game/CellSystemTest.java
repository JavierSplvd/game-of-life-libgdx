package com.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellSystemTest {
    @Test
    public void testCheckCellIsUnderpopulatedWithZeroNeighbours() {
        //Given
        CellSystem cellSystem = new CellSystem(3,3);
        //When
        cellSystem.getCell(1, 1).revive();
        //Then
        assertTrue(cellSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsUnderpopulatedWithOneNeighbours() {
        //Given
        CellSystem cellSystem = new CellSystem(3,3);
        //When
        cellSystem.getCell(1, 1).revive();
        cellSystem.getCell(2, 1).revive();
        //Then
        assertTrue(cellSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsNotUnderpopulatedWithTwoNeighbours() {
        //Given
        CellSystem cellSystem = new CellSystem(3,3);
        //When
        cellSystem.getCell(1, 1).revive();
        cellSystem.getCell(0, 1).revive();
        cellSystem.getCell(2, 1).revive();
        //Then
        assertFalse(cellSystem.isUnderpopulated(1, 1));
    }

    @Test
    public void testCheckCellIsInStasis() {

    }

    @Test
    public void testCheckCellIsOverpopulated() {

    }

    @Test
    public void testCheckCellCanReproduce() {

    }
}