function solution(n, works) {
  let len = works.length,
    idx = len,
    result = 0;

  works.sort((a, b) => {
    return b - a;
  });

  for (let i = 1; i < len; i++) {
    let diff = works[i - 1] - works[i];

    if (diff > 0) {
      // 더 큰 작업량 수만큼 현재 작업량에 맞출 수 있는지
      if (diff * (i - 0) <= n) {
        for (let j = 0; j < i; j++) {
          works[j] -= diff;
          n -= diff;
        }
      } else {
        idx = i;
        break;
      }
    }
  }

  // 못 맞춘 부분부터 n이 0이 될때까지 1씩 감소
  while (n > 0) {
    for (let i = 0; i < idx; i++) {
      if (works[i] == 0) break;
      works[i]--;
      if (--n == 0) break;
    }
  }

  for (let i = 0; i < len; i++) result += Math.pow(works[i], 2);

  return result;
}
