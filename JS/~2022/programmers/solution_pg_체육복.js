function solution(n, lost, reserve) {
  let student = new Array(n + 1).fill(1);
  for (let r of reserve) student[r]++;
  for (let l of lost) student[l]--;
  const dc = [-1, 1];
  let answer = n - lost.length;
  lost.sort(function (a, b) {
    return a - b;
  });
  for (let l of lost) {
    if (student[l] == 1) {
      answer++;
      continue;
    }
    for (let d = 0; d < 2; d++) {
      const next = l + dc[d];
      if (next == 0 || next == n + 1) continue;
      if (student[next] == 2) {
        student[next]--;
        answer++;
        break;
      }
    }
  }
  return answer;
}
