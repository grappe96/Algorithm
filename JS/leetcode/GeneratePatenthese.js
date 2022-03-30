var generateParenthesis = function (n) {
  const len = n * 2,
    answer = [],
    str = new Array(len);

  const combination = (now, open, close) => {
    if (now === len) {
      answer.push(str.join(''));
      return;
    }
    if (open < n) {
      str[now] = '(';
      combination(now + 1, open + 1, close);
    }
    if (open > close) {
      str[now] = ')';
      combination(now + 1, open, close + 1);
    }
  };

  combination(0, 0, 0);

  return answer;
};
