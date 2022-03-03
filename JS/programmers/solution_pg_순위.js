function solution(n, results) {
  let adj = [];
  for (let i = 0; i <= n; i++) adj.push([]);
  for (let result of results) adj[result[0]][result[1]] = 1;

  for (let k = 1; k <= n; k++)
    for (let i = 1; i <= n; i++)
      for (let j = 1; j <= n; j++) {
        if (i == j || adj[i][j] == 1) continue;
        if (adj[i][k] == 1 && adj[k][j] == 1) adj[i][j] = 1;
      }

  let answer = n;
  for (let i = 1; i <= n; i++)
    for (let j = 1; j <= n; j++)
      if (i != j && adj[i][j] != 1 && adj[j][i] != 1) {
        answer--;
        break;
      }

  return answer;
}
