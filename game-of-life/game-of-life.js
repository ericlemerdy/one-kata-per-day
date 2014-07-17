function GameOfLife(width, height, grid) {
	var interval = null;

	this._grid = grid;

	this.startTimer = function() {
		interval = setInterval(nextGeneration, 500);
	}
	
	this.nextGeneration = function() {
		var nextGenerationGrid = new Array(height);
		grid.each(function (y) {
			nextGenerationGrid[y] = new Array(width);
			grid[y].each(function (x) {
				var isAlive = this.isAlive(x, y);
				var aliveNeighbours = this.aliveNeighbors(x, y);
				if (!isAlive && aliveNeighbours == 3) {
					nextGenerationGrid[y][x] = 1;
				} else if (isAlive && aliveNeighbours != 2 && aliveNeighbours != 3) {
					nextGenerationGrid[y][x] = 0;
				}
			});
		});
	}

	this.aliveNeighbors = function(x, y) {
		var aliveNeighbors = 0;
		aliveNeighbors += this.isAlive(x-1, y-1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x+0, y-1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x+1, y-1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x+1, y+0) ? 1 : 0;
		aliveNeighbors += this.isAlive(x+1, y+1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x+0, y+1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x-1, y+1) ? 1 : 0;
		aliveNeighbors += this.isAlive(x-1, y+0) ? 1 : 0;
		return aliveNeighbors;
	}
	
	this.isAlive = function(x, y) {
		if (x < 0 || x >= width || y < 0 || y >= height) {
			return false;
		}
		return grid[y][x] == 1;
	}
	
	this.isAliveJQuery = function(x, y) {
		return $("#grid .row-" + y + " .cell-" + x).hasClass("alive");
	}
	
	this.abortTimer = function() {
		clearInterval(interval);
	}

	this.randomDeadOrAlive = function() {
		return (Math.random()<.5) ? "alive" : "dead";
	}
	
	this.createGrid = function() {
		$("#grid").empty();
		var grid = "";
		for (var y = 0; y < $("#y").val(); y++) {
			var $tr = $("<tr>", { class: "row-" + y });
			for (var x = 0; x < $("#x").val(); x++) {
				var $td = $("<td>", { class: "cell-" + x + " " + randomDeadOrAlive() });
				$td.on("click", function() {
					$(this).toggleClass("dead alive");
				});
				$tr.append($td);
			}
			$("#grid").append($tr);
		}
	}
};