import { Tennis } from '../src/Tennis';

describe('Test environment', function() {
  it('should run test framework', function () {
    expect(true).toBe(true);
  });
});

describe('Tennis game', function() {
    it('should have 2 players', function() {
        const tennis = new Tennis('Alex', 'Bob');

        const players = tennis.getPlayers();

        expect(players).toContain('Alex', 'Bob');
    });

  it('should have an initial score of 0-0', function() {
    const tennis = new Tennis('Alex', 'Bob');

    const score = tennis.getScore().currentGame;

    expect(score).toEqual({'Alex': 0, 'Bob': 0});
  });

  it('with female players', function() {
    const tennis = new Tennis('Alice', 'Bobbette');

    const score = tennis.getScore().currentGame;

    expect(score).toEqual({'Alice': 0, 'Bobbette': 0});
  });

  it('Alice wins first ball', function() {
    const tennis = new Tennis('Alice', 'Bobbette');
    tennis.currentPlayerWins (true);

    const score = tennis.getScore().currentGame;

    expect(score).toEqual({'Alice': 15, 'Bobbette': 0});
  });

  it('Alice wins first ball and Bobbette wins second ball', function() {
    const tennis = new Tennis('Alice', 'Bobbette');
    tennis.currentPlayerWins (true);
    tennis.currentPlayerWins (false);

    const score = tennis.getScore().currentGame;

    expect(score).toEqual({'Alice': 15, 'Bobbette': 15});
  });

  it('Alice wins first and second ball', function() {
    const tennis = new Tennis('Alice', 'Bobbette');
    tennis.currentPlayerWins (true);
    tennis.currentPlayerWins (true);

    const score = tennis.getScore().currentGame;

    expect(score).toEqual({'Alice': 30, 'Bobbette': 0});
  });

  it('Alice wins game', function() {
    const tennis = new Tennis('Alice', 'Bobbette');
    tennis.currentPlayerWins (true);
    tennis.currentPlayerWins (true);
    tennis.currentPlayerWins (true);
    tennis.currentPlayerWins (true);

    const score = tennis.getScore().games;

    expect(score).toEqual({'Alice': 1, 'Bobbette': 0});
  });

});