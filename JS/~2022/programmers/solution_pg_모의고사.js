function solution(answers) {
  const supo1 = [1, 2, 3, 4, 5];
  const supo2 = [2, 1, 2, 3, 2, 4, 2, 5];
  const supo3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
  const len1 = 5,
    len2 = 8,
    len3 = 10,
    len = answers.length;
  let count = [0, 0, 0];
  for (let i = 0; i < len; i++) {
    const answer = answers[i];
    if (supo1[i % len1] == answer) ++count[0];
    if (supo2[i % len2] == answer) ++count[1];
    if (supo3[i % len3] == answer) ++count[2];
  }

  let max = Math.max(count[0], count[1], count[2]);
  let answer = [];
  for (let i = 0; i < 3; i++) if (count[i] == max) answer.push(i + 1);
  return answer;
}
