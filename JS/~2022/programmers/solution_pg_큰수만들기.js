function solution(number, k) {
  let n = number.length,
    stack = [],
    idx = 0;

  for (let i = 0; i < n; i++) {
    let now = number[i];
    while (k > 0 && now > stack[idx - 1]) {
      stack.pop();
      k--;
      idx--;
    }
    stack.push(now);
    idx++;
  }

  stack = stack.slice(0, n - k);
  let answer = stack.join('');
  return answer;
}
