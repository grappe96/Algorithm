function solution(clothes) {
  const map = new Map();
  for (let c of clothes) {
    if (map.has(c[1])) map.put(c[1], map.get(c[1]) + 1);
    else map.put(c[1], 1);
  }
  let answer = 1;
  for (let [key, value] of map) answer *= value + 1;

  return answer - 1;
}
