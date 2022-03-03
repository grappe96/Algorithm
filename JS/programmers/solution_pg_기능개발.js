class Queue {
  constructor() {
    this.queue = [];
    this.size = 0;
  }
  offer(value) {
    this.queue.push(value);
    this.size++;
  }
  poll() {
    this.size--;
    return this.queue.shift();
  }
  peek() {
    return this.queue[0];
  }
  isEmpty() {
    if (this.size == 0) return true;
    else return false;
  }
}
function solution(progresses, speeds) {
  const queue = new Queue();
  for (let i in progresses) {
    let count = Math.ceil((100 - progresses[i]) / speeds[i]);
    queue.offer(count);
  }
  let answer = [],
    count = 1,
    first = queue.poll();
  while (!queue.isEmpty()) {
    if (queue.peek() <= first) {
      queue.poll();
      count++;
    } else {
      answer.push(count);
      count = 1;
      first = queue.poll();
    }
  }
  answer.push(count);

  return answer;
}
