import { GameOfLife } from '../src/GameOfLife';

describe('Test environment', function() {
    it('should run test framework', function() {
        expect(true).toBe(true);
    });
});
describe('Game of life', function() {
    describe('Alive cells :', function() {
        it('should say if a cell is alive', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. . .' + '\n' +
                '. * .' + '\n' +
                '. . .');

            const nextGeneration = gameOfLife.isCellAlive(1, 1);

            expect(nextGeneration).toBe(true);
        });
        it('should say if a cell is dead', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. . .' + '\n' +
                '. . .' + '\n' +
                '. . .');

            const nextGeneration = gameOfLife.isCellAlive(1, 1);

            expect(nextGeneration).toBe(false);
        });
    });
    describe('Count neighbors :', function() {
        it('should count neighbors with blank matrix', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. . .' + '\n' +
                '. . .' + '\n' +
                '. . .');

            const neighbors = gameOfLife.countNeighbors(1, 1);

            expect(neighbors).toBe(0);
        });
        it('should count neighbors with one neighbor', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '* . .' + '\n' +
                '. . .' + '\n' +
                '. . .');

            const neighbors = gameOfLife.countNeighbors(1, 1);

            expect(neighbors).toBe(1);
        });
        it('should count neighbors on the edge', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '* * .' + '\n' +
                '* . .' + '\n' +
                '. . .');

            const neighbors = gameOfLife.countNeighbors(0, 0);

            expect(neighbors).toBe(2);
        });
    });
    describe('Rule #1 : Any live cell with fewer than two live neighbors dies, as if caused by under-population.', function() {
        it('should die with 0 neighbor', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. . .' + '\n' +
                '. * .' + '\n' +
                '. . .');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('.');
        });
        it('should die with 1 neighbor', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. . .' + '\n' +
                '. * *' + '\n' +
                '. . .');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('.');
        });
    });
    describe('Rule #2 : Any live cell with more than three live neighbors dies, as if by overcrowding.', function() {
        it('should die with 4 neighbors', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. * .' + '\n' +
                '* * *' + '\n' +
                '. * .');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('.');
        });
        it('should die with 5 neighbors', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '. * .' + '\n' +
                '* * *' + '\n' +
                '. * *');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('.');
        });
    });
    describe('Rule #3 : Any live cell with two or three live neighbors lives on to the next generation.', function() {
        it('should live with 2 neighbors', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '* . .' + '\n' +
                '* * .' + '\n' +
                '. . .');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('*');
        });
        it('should live with 3 neighbors', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '* . .' + '\n' +
                '* * .' + '\n' +
                '. . *');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('*');
        });
    });
    describe('Rule #4 : Any dead cell with exactly three live neighbors becomes a live cell.', function() {
        it('a dead cell should become live with 3 neighbors', function() {
            const gameOfLife = new GameOfLife(3, 3,
                '* * .' + '\n' +
                '* . .' + '\n' +
                '. . .');

            const nextGenerationCell = gameOfLife.nextGenerationCell(1, 1);

            expect(nextGenerationCell).toBe('*');
        });
    });
    describe('Acceptance :', function() {
        it('should compute generations', function() {
            const gameOfLife = new GameOfLife(4, 8,
                '. . . . . . . .' + '\n' +
                '. . . . * . . .' + '\n' +
                '. . . * * . . .' + '\n' +
                '. . . . . . . .');

            const nextGeneration = gameOfLife.nextGeneration();

            expect(nextGeneration).toBe('' +
                '. . . . . . . .' + '\n' +
                '. . . * * . . .' + '\n' +
                '. . . * * . . .' + '\n' +
                '. . . . . . . .');
        });
    });
});