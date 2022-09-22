function solution(n, computers) {
  let answer = 0,
    visited = new Array(n),
    dfs = (num) => {
      for (let i = 0; i < n; i++)
        if (!visited[i] && i != num && computers[num][i]) {
          visited[i] = true;
          dfs(i);
        }
    };

  visited.fill(false);
  for (let i = 0; i < n; i++) {
    if (!visited[i]) {
      answer++;
      visited[i] = true;
      dfs(i);
    }
  }

  return answer;
}
