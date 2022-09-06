var reverse = function (x) {
  const max = Math.pow(2, 31) - 1;
  const min = -1 * (max + 1);

  let arr = x.toString().split('').reverse();

  let answer;

  if (arr[arr.length - 1] === '-') {
    arr.pop();
    answer = -1 * Number.parseInt(arr.join(''));
  } else answer = Number.parseInt(arr.join(''));

  if (answer > max || answer < min) return 0;
  else return answer;
};
