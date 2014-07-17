describe("Game of life", function() {
  var gameOfLife;

  beforeEach(function() {
    gameOfLife = new GameOfLife(6, 6, [
      [0, 0, 0, 0, 0, 0],
      [0, 0, 0, 1, 0, 0],
      [0, 1, 0, 0, 1, 0],
      [0, 1, 0, 0, 1, 0],
      [0, 0, 1, 0, 0, 0],
      [0, 0, 0, 0, 0, 0],
    ]);
  });

  it("should count alive neighbors", function() {
    expect(gameOfLife.aliveNeighbors(3, 2)).toEqual(3);
    expect(gameOfLife.aliveNeighbors(2, 4)).toEqual(1);
    expect(gameOfLife.aliveNeighbors(5, 5)).toEqual(0);
  });
});
