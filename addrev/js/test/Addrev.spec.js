import { Addrev } from '../src/Addrev'
import { expect } from 'chai'

describe('Addrev module', () => {
  it('should reverse a number', () => {
    expect(new Addrev().reverse(24)).to.equal(42);
  })
  it('should reverse another number', () => {
    expect(new Addrev().reverse(123)).to.equal(321);
  })
  it('should remove trailing zeros', () => {
    expect(new Addrev().reverse(1000)).to.equal(1);
  })
  it('should return the reversed sum of two reversed numbers', () => {
    expect(new Addrev().reversedSumOfReversedNumbers(24, 1)).to.equal(34);
  })
  it('should calculate for a whole input', () => {
    expect(new Addrev(`3
24 1
4358 754
305 794`).toString()).to.equal(`34
1998
1`);
  })
})
