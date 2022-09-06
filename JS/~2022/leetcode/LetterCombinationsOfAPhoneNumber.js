var letterCombinations = function (digits) {
  const map = new Map();
  map.set('2', ['a', 'b', 'c']);
  map.set('3', ['d', 'e', 'f']);
  map.set('4', ['g', 'h', 'i']);
  map.set('5', ['j', 'k', 'l']);
  map.set('6', ['m', 'n', 'o']);
  map.set('7', ['p', 'q', 'r', 's']);
  map.set('8', ['t', 'u', 'v']);
  map.set('9', ['w', 'x', 'y', 'z']);

  const len = digits.length;
  const answer = [];
  let str = [];
  const combination = (num) => {
    const idx = parseInt(num);

    if (idx === len) {
      answer.push(str.join(''));
      return;
    }

    const arr = map.get(digits.charAt(num));
    const arrLen = arr.length;
    for (let i = 0; i < arrLen; i++) {
      str[idx] = arr[i];
      combination(idx + 1);
    }
  };
  if (digits.length > 0) combination(0);

  return answer;
};
