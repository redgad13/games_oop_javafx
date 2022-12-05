package ru.job4j.chess.firuges.black;

import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class BishopBlackTest {

    @Test
    void positionIsValid() {
        Cell firstBishopCell = Cell.C8;
        Cell secondBishopCell = Cell.F8;
        BishopBlack firstBishop = new BishopBlack(firstBishopCell);
        BishopBlack secondBishop = new BishopBlack(secondBishopCell);
        assertThat(firstBishop.position()).isEqualTo(Cell.findBy(2, 0));
        assertThat(secondBishop.position()).isEqualTo(Cell.findBy(5, 0));
    }

    @Test
    void positionIsNotValid() {
        Cell firstBishopCell = Cell.C8;
        Cell secondBishopCell = Cell.F8;
        BishopBlack firstBishop = new BishopBlack(firstBishopCell);
        BishopBlack secondBishop = new BishopBlack(secondBishopCell);
        assertThat(firstBishop.position()).isNotEqualTo(Cell.findBy(3, 0));
        assertThat(secondBishop.position()).isNotEqualTo(Cell.findBy(6, 0));
    }

    @Test
    void copyIsValid() {
        Cell firstBishopCell = Cell.C8;
        Cell secondBishopCell = Cell.F8;
        Cell firstBishopDestCell = Cell.F5;
        Cell secondBishopDestCell = Cell.C5;
        BishopBlack firstBishop = new BishopBlack(firstBishopCell);
        BishopBlack secondBishop = new BishopBlack(secondBishopCell);
        firstBishop.copy(firstBishopDestCell);
        secondBishop.copy(secondBishopDestCell);
        BishopBlack firstBishopMoved = new BishopBlack(Cell.F5);
        BishopBlack secondBishopMoved = new BishopBlack(Cell.C5);
        assertThat(firstBishopMoved.position()).isEqualTo(Cell.findBy(5, 3));
        assertThat(secondBishopMoved.position()).isEqualTo(Cell.findBy(2, 3));
    }

    @Test
    void wayC1G5() {
        BishopBlack firstBishop = new BishopBlack(Cell.C1);
        assertThat(firstBishop.way(Cell.G5)).isEqualTo(new Cell[]
                {Cell.D2, Cell.E3, Cell.F4, Cell.G5});
    }

    @Test
    void wayG5C1() {
        BishopBlack firstBishop = new BishopBlack(Cell.G5);
        assertThat(firstBishop.way(Cell.C1)).isEqualTo(new Cell[]
                {Cell.F4, Cell.E3, Cell.D2, Cell.C1});
    }

    @Test
    void wayG5F4() {
        BishopBlack firstBishop = new BishopBlack(Cell.G5);
        assertThat(firstBishop.way(Cell.F4)).isEqualTo(new Cell[]{Cell.F4});
    }

    @Test
    void wayH8A1() {
        BishopBlack firstBishop = new BishopBlack(Cell.H8);
        assertThat(firstBishop.way(Cell.A1)).isEqualTo(new Cell[]
                {Cell.G7, Cell.F6, Cell.E5, Cell.D4, Cell.C3, Cell.B2, Cell.A1});
    }

    @Test
    void diagonalH8A1IsTrue() {
        BishopBlack firstBishop = new BishopBlack(Cell.H8);
        assertThat(firstBishop.isDiagonal(Cell.H8, Cell.A1)).isTrue();
    }

    @Test
    void diagonalH8G6IsFalse() {
        BishopBlack firstBishop = new BishopBlack(Cell.H8);
        assertThat(firstBishop.isDiagonal(Cell.H8, Cell.G6)).isFalse();
    }

    @Test
    void diagonalG3D6IsTrue() {
        BishopBlack firstBishop = new BishopBlack(Cell.G3);
        assertThat(firstBishop.isDiagonal(Cell.G3, Cell.D6)).isTrue();
    }

    @Test
    void diagonalA1D6IsFalse() {
        BishopBlack firstBishop = new BishopBlack(Cell.A1);
        assertThat(firstBishop.isDiagonal(Cell.A1, Cell.D6)).isFalse();
    }
}