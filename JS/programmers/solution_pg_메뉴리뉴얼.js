let N, R, order, menu, map, max;
function solution(orders, course) {
  for (let i in orders) {
    let arr = orders[i].split('');
    arr.sort();
    orders[i] = '';
    for (let a of arr) orders[i] += a;
  }
  let answer = [];
  for (let c of course) {
    R = c;
    max = 0;
    map = new Map();
    for (let o of orders) {
      order = o;
      N = order.length;
      menu = new Array(R);
      combination(0, 0);
    }
    if (max > 1) {
      for (let [key, value] of map) {
        if (value == max) answer.push(key);
      }
    }
  }
  answer.sort();
  return answer;
}
function combination(start, count) {
  if (count == R) {
    let newMenu = '';
    for (let i = 0; i < R; i++) newMenu += menu[i];
    if (map.has(newMenu)) map.set(newMenu, map.get(newMenu) + 1);
    else map.set(newMenu, 1);
    max = Math.max(max, map.get(newMenu));
    return;
  }
  for (let i = start; i < N; i++) {
    menu[count] = order.charAt(i);
    combination(i + 1, count + 1);
  }
}
