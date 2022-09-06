function solution(n, costs) {
  function union(a, b) {
    let rootA = find(a);
    let rootB = find(b);
    if (rootA === rootB) return false;
    parent[rootB] = rootA;
    return true;
  }
  function find(a) {
    if (parent[a] === a) return a;
    return (parent[a] = find(parent[a]));
  }
  costs.sort(function (a, b) {
    return a[2] - b[2];
  });
  let answer = 0,
    parent = [],
    count = 0;
  for (let i = 0; i < n; i++) parent.push(i);
  while (count < n - 1) {
    const min = costs.shift();
    if (find(min[0]) != find(min[1])) {
      union(min[0], min[1]);
      answer += min[2];
      count++;
    }
  }
  return answer;
}
