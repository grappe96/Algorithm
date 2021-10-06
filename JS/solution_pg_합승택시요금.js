function solution(n, s, a, b, fares) {
  let adj = [];
  const MAX = Number.MAX_SAFE_INTEGER;

  for (let i = 0; i <= n; i++) {
    adj.push([]);
    for (let j = 0; j <= n; j++) adj[i].push(MAX);
  }

  for (let fare of fares) {
    adj[fare[0]][fare[1]] = fare[2];
    adj[fare[1]][fare[0]] = fare[2];
  }

  for (let k = 1; k <= n; k++)
    for (let i = 1; i <= n; i++)
      for (let j = 1; j <= n; j++) {
        if (i == j) continue;
        if (adj[i][k] != MAX && adj[k][j] != MAX) {
          if (adj[i][k] + adj[k][j] < adj[i][j])
            adj[i][j] = adj[j][i] = adj[i][k] + adj[k][j];
        }
      }

  let answer = adj[s][a] + adj[s][b];
  for (let k = 1; k <= n; k++) {
    if (adj[s][k] == MAX) continue;
    if (adj[s][k] >= adj[s][a] + adj[a][k] || a == k) {
      if (adj[s][k] >= adj[s][b] + adj[b][k]) continue;
      answer = Math.min(answer, adj[s][k] + adj[k][b]);
    } else {
      if (adj[s][k] >= adj[s][b] + adj[b][k] || b == k)
        answer = Math.min(answer, adj[s][k] + adj[k][a]);
      else answer = Math.min(answer, adj[s][k] + adj[k][a] + adj[k][b]);
    }
  }
  return answer;
}

// function solution(n, s, a, b, fares) {
//   var arr = [];
//   for (var i = 1; i <= n; i++) {
//     arr[i] = [];
//     for (var j = 1; j <= n; j++) {
//       arr[i][j] = i == j ? 0 : Number.MAX_SAFE_INTEGER;
//     }
//   }

//   fares.forEach(([v1, v2, distance]) => {
//     arr[v1][v2] = distance;
//     arr[v2][v1] = distance;
//   });

//   for (var k = 1; k <= n; k++) {
//     for (var i = 1; i <= n; i++) {
//       for (var j = 1; j <= n; j++) {
//         if (arr[i][j] > arr[i][k] + arr[k][j]) {
//           arr[i][j] = arr[i][k] + arr[k][j];
//         }
//       }
//     }
//   }

//   var min = Number.MAX_SAFE_INTEGER;
//   for (var i = 1; i <= n; i++) {
//     var price = arr[s][i] + arr[i][a] + arr[i][b];
//     min = Math.min(min, price);
//   }

//   return min;
// }
