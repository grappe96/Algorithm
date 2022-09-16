function solution(s) {
  let count = 0,
    zero = 0,
    len = s.length;
  while (len > 1) {
    let num = s.replaceAll('0', '').length;
    zero += len - num;
    s = num.toString(2);
    len = s.length;
    count++;
  }
  return [count, zero];
}
