function solution(routes) {
  routes.sort(function (a, b) {
    return a[1] - b[1];
  });

  let answer = 0,
    out = -30001;
  for (let route of routes) {
    if (route[0] <= out) continue;
    else {
      out = route[1];
      answer++;
    }
  }
  return answer;
}
