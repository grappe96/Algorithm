var romanToInt = function (s) {
  const map = new Map();
  map.set('I', 1);
  map.set('V', 5);
  map.set('X', 10);
  map.set('L', 50);
  map.set('C', 100);
  map.set('D', 500);
  map.set('M', 1000);

  const len = s.length;
  let before = map.get(s[0]),
    answer = before;
  for (let i = 1; i < len; i++) {
    const now = map.get(s[i]);
    answer += now;

    if (now > before) answer -= before * 2;

    before = now;
  }
  return answer;
};
