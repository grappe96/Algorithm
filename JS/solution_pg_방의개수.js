function solution(arrows) {
  let adjMap = new Map();
  let dx = [0, 1, 1, 1, 0, -1, -1, -1];
  let dy = [1, 1, 0, -1, -1, -1, 0, 1];

  let now = { x: 0, y: 0 };
  let answer = 0;
  adjMap.set(JSON.stringify(now), []);

  for (let arrow of arrows) {
    for (let i = 0; i < 2; i++) {
      const next = { x: now.x + dx[arrow], y: now.y + dy[arrow] };
      const nowKey = JSON.stringify(now);
      const nextKey = JSON.stringify(next);

      if (!adjMap.has(nextKey)) {
        adjMap.set(nextKey, []);
        adjMap.get(nextKey).push(nowKey);
        adjMap.get(nowKey).push(nextKey);
      } else if (!adjMap.get(nextKey).includes(nowKey)) {
        adjMap.get(nextKey).push(nowKey);
        adjMap.get(nowKey).push(nextKey);
        answer++;
      }

      now = next;
    }
  }
  return answer;
}
