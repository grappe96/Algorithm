var divide = function (dividend, divisor) {
  let quotient = 0;
  const max = Math.pow(2, 31),
    check = divisor < 0 === dividend < 0;

  dividend = Math.abs(dividend);
  divisor = Math.abs(divisor);

  if (divisor === 1) quotient = dividend;
  else {
    while (dividend >= divisor) {
      let tmpSor = divisor,
        tmpEnd = dividend >> 1,
        i = 1;
      while (tmpEnd >= tmpSor) {
        i <<= 1;
        tmpSor <<= 1;
      }
      dividend -= tmpSor;
      quotient += i;
    }
  }

  quotient = check ? quotient : -quotient;
  quotient = Math.min(max - 1, Math.max(-max, quotient));
  return quotient;
};
