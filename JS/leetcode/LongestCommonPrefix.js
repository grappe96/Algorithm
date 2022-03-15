var longestCommonPrefix = function (strs) {
  strs.sort((a, b) => {
    return a.length - b.length;
  });
  const len = strs.length;
  let answer = strs[0];
  for (let i = 1; i < len; i++) {
    let j,
      prefixLen = answer.length;
    for (j = 0; j < prefixLen; j++) {
      if (answer[j] !== strs[i][j]) break;
    }
    answer = answer.substring(0, j);
    if (answer.length === 0) break;
  }
  return answer;
};
