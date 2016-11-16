export class Tennis {

    constructor(playerOne, playerTwo) {
        this.players = [playerOne, playerTwo];
        this.currentPlayer = 0;
        this.gameScores = [0, 15, 30, 40];
        this.games = {};
        this.players.forEach(player => this.games[player] = 0);
        this.score = this.players.reduce((map, player) => {
            map[player] = 0;
            return map;
        }, {});
    }

    getPlayers() {
        return this.players;
    }

    getScore() {
        let currentGame = {};
        this.players.map((player) => {
            currentGame[player] = this.gameScores[this.score[player]];
        });
        return {'games' : this.games, 'currentGame': currentGame };
    }

    currentPlayerWins(won) {
        let winner = -1;
        if (won)
            winner = this.players[this.currentPlayer];
        else
            winner = this.players[this.currentPlayer + 1 % 2];

        ++this.score[winner];

        if (this.score[winner] == 4) {
            this.score[winner] = 0;
            this.games[winner] = 1;
        }
    }
}