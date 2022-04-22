function solution(dartResult) {
  const len = dartResult.length;
  let stack = [],
    check = false;
  for (let i = 0; i < len; i++) {
    const ch = dartResult.charAt(i);
    if (ch >= '0' && ch <= '9') {
      check ? stack.push(stack.pop() * 10) : stack.push(parseInt(ch));
      check = true;
    } else {
      check = false;
      if (ch === 'D') stack.push(Math.pow(stack.pop(), 2));
      else if (ch === 'T') stack.push(Math.pow(stack.pop(), 3));
      else if (ch === '#') stack.push(stack.pop() * -1);
      else if (ch === '*') {
        const n2 = stack.pop() * 2;
        if (stack.length > 0) {
          const n1 = stack.pop() * 2;
          stack.push(n1);
        }
        stack.push(n2);
      }
    }
  }

  let answer = 0;
  for (let i = 0; i < stack.length; i++) answer += stack[i];

  return answer;
}
