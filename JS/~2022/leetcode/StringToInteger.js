var myAtoi = function (s) {
  let answer = s
    .trim()
    .split(/\s+/)[0]
    .split(/[a-zA-z]+/);
  answer = parseInt(answer[0]);
  answer = isNaN(answer) ? 0 : answer;

  const max = Math.pow(2, 31);
  answer = answer > max - 1 ? max - 1 : answer;
  answer = answer < -max ? -max : answer;

  return answer;
};
