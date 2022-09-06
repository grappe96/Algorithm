function solution(numbers) {
  let obj = [];
  for (let number of numbers) {
    let s = '',
      idx = 0,
      n = String(number);
    while (s.length < 4) {
      s += n.charAt(idx);
      idx = (idx + 1) % n.length;
    }
    obj.push({ compare: s, num: number });
  }
  obj.sort(function (a, b) {
    return b.compare - a.compare;
  });
  let answer = '';
  if (obj[0].num === 0) answer = '0';
  else for (let o of obj) answer += o.num;
  return answer;
}
