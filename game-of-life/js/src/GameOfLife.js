export class GameOfLife {

    constructor(n, m, matrix) {
        this.tm = matrix.split("\n")
            .map(function (line) {
                return line.split(" ");
            });
    }

    isCellAlive(i, j) {
        if (i < 0 || i >= this.tm.length) {
            return false;
        }
        if (j < 0 || j >= this.tm[i].length) {
            return false;
        }
        return this.tm[i][j] === '*';
    }

    countNeighbors(i, j) {
        return 0
            + (this.isCellAlive(i-1, j-1) ? 1 : 0)
            + (this.isCellAlive(i-1, j+0) ? 1 : 0)
            + (this.isCellAlive(i-1, j+1) ? 1 : 0)
            + (this.isCellAlive(i+0, j-1) ? 1 : 0)
            + (this.isCellAlive(i+0, j+1) ? 1 : 0)
            + (this.isCellAlive(i+1, j-1) ? 1 : 0)
            + (this.isCellAlive(i+1, j+0) ? 1 : 0)
            + (this.isCellAlive(i+1, j+1) ? 1 : 0)
    }

    nextGenerationMatrix() {
        return this.tm.map((line, i) =>
            line.map((element, j) => {
                const neighborsCount = this.countNeighbors(i, j);
                if (this.isCellAlive(i, j)) {
                    if (neighborsCount < 2) {
                        return '.'
                    }
                    if (neighborsCount === 2) {
                        return '*'
                    }
                    if (neighborsCount === 3) {
                        return '*'
                    }
                    if (neighborsCount > 3) {
                        return '.'
                    }
                } else {
                    if (neighborsCount === 3) {
                        return '*'
                    }
                }
                return this.tm[i][j];
            })
        )
    }

    nextGenerationCell(i, j) {
        return this.nextGenerationMatrix()[i][j]
    }

    nextGeneration() {
        return this.nextGenerationMatrix().map((line, i) =>
            line.map((element) => element).join(' ')
        ).join('\n')
    }

}