export class Addrev {
  constructor(input) {
    if (input === undefined) {
      return;
    }
    const lines = input.split('\n');
    this.out = lines
      .map(line => {
        const numbers = line.split(' ');
        if (numbers.length != 2) {
          return NaN;
        }
        return this.reversedSumOfReversedNumbers(numbers[0], numbers[1]);
      })
      .filter(number => !Number.isNaN(number))
      .join('\n');
  }

  reversedSumOfReversedNumbers(n, m) {
    return this.reverse(this.reverse(n) + this.reverse(m));
  }

  reverse(number) {
    let output = 0;
    const numbers = Array.from(new String(number));
    for (let i = numbers.length - 1; i >= 0; i--) {
      output += numbers[i] * Math.pow(10, i);
    }
    return output;
  }

  toString() {
    return this.out;
  }
}
