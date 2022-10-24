function solution(n) {
  let answer = 0,
    col = new Array(n),
    findPosition = (r) => {
      if (r == n) {
        answer++;
        return;
      }

      for (let i = 0; i < n; i++) {
        col[r] = i;
        if (isPossible(r)) findPosition(r + 1);
      }
    },
    isPossible = (r) => {
      for (let i = 0; i < r; i++) {
        if (col[i] == col[r] || Math.abs(col[i] - col[r]) == r - i)
          return false;
      }
      return true;
    };

  findPosition(0);
  return answer;
}
