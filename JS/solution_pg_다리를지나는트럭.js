class Queue {
  constructor() {
    this.queue = [];
  }
  offer(item) {
    this.queue.push(item);
  }
  poll() {
    return this.queue.shift();
  }
  peek() {
    return this.queue[0];
  }
}

function solution(bridge_length, weight, truck_weights) {
  let time = 0,
    idx = 0,
    sum = 0,
    num = truck_weights.length;
  const queue = new Queue();

  queue.offer([time++, idx]);
  sum += truck_weights[idx++];
  while (true) {
    if (time - queue.peek()[0] == bridge_length) {
      let out = queue.poll();
      sum -= truck_weights[out[1]];

      if (out[1] === num - 1) {
        time++;
        break;
      }
    }

    if (sum + truck_weights[idx] <= weight) {
      queue.offer([time++, idx]);
      sum += truck_weights[idx++];
    } else time += time - queue.peek()[0];
  }

  return time;
}
