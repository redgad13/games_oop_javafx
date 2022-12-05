package ru.job4j.chess;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;
import ru.job4j.chess.firuges.white.PawnWhite;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class LogicTest {

    @Test
    public void whenMoveThenFigureNotFoundException()
            throws FigureNotFoundException, OccupiedCellException, ImpossibleMoveException {
        Logic logic = new Logic();
        FigureNotFoundException exception = assertThrows(FigureNotFoundException.class, () -> {
            logic.move(Cell.C1, Cell.H6);
        });
        assertThat(exception.getMessage()).isEqualTo("Figure not found on the board.");
    }

    @Test
    void moveC8ToE6throughD7IsImpossible() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C8);
        Figure pawn = new PawnBlack(Cell.D7);
        logic.add(bishopBlack);
        logic.add(pawn);
        OccupiedCellException oce = assertThrows(
                OccupiedCellException.class,
                () -> {
                    logic.move(Cell.C8, Cell.E6);
                });
    }

    @Test
    void moveC8ToF5IsPossible() throws OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        Figure bishopBlack = new BishopBlack(Cell.C8);
        for (int i = 0; i < 32; i++) {
            logic.add(bishopBlack);
        }
        logic.move(Cell.C8, Cell.F5);
    }
}