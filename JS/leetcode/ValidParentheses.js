var isValid = function (s) {
  const len = s.length,
    stack = [],
    pair = {
      ')': '(',
      '}': '{',
      ']': '[',
    };
  for (let i = 0; i < len; i++) {
    const ch = s.charAt(i);
    if (pair[ch] === undefined) stack.push(ch);
    else if (pair[ch] === stack.pop()) continue;
    else return false;
  }
  return stack.length === 0;
};
