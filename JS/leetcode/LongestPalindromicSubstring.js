var longestPalindrome = (s) => {
  const len = s.length;
  let answer = '';

  for (let i = 0; i < len; i++) {
    let now = s.charAt(i);
    let idx = i + 1;

    while (s.charAt(idx) === s.charAt(i)) now += s.charAt(idx++);

    for (let j = 1; j <= i; j++) {
      if (s.charAt(i - j) !== s.charAt(idx - 1 + j)) break;

      now = s.charAt(i - j) + now + s.charAt(idx - 1 + j);
    }

    if (now.length > answer.length) answer = now;

    i = idx - 1;
  }

  return answer;
};
