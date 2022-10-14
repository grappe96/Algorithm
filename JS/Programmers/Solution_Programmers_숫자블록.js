function solution(begin, end) {
  const lastNum = 10000000;
  let answer = new Array(end - begin + 1);
  answer.fill(1);
  if (begin == 1) answer[0] = 0;

  for (let i = begin; i <= end; i++) {
    for (let j = 2; j <= Math.sqrt(i); j++)
      if (i % j == 0 && i / j <= lastNum) {
        answer[i - begin] = i / j;
        break;
      }
  }

  return answer;
}
