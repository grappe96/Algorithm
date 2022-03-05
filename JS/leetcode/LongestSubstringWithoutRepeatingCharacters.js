var lengthOfLongestSubstring = function (s) {
  const len = s.length;
  let start = 0,
    end = 0,
    answer = 0;
  const map = new Map();

  for (let i = 0; i < len; i++) {
    const c = s.charAt(i);

    if (s.substring(start, end).includes(c)) start = map.get(c) + 1;
    map.set(c, i);
    end = i + 1;
    answer = Math.max(answer, end - start);
  }

  return answer;
};
