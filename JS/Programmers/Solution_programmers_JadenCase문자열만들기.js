function solution(s) {
  s = s.toLowerCase();
  let len = s.length,
    answer = [],
    space = true;

  for (let i = 0; i < len; i++) {
    let c = s.charAt(i);

    if (c === ' ') space = true;
    else if (space) {
      c = c.toUpperCase();
      space = false;
    }

    answer.push(c);
  }
  return answer.join('');
}
