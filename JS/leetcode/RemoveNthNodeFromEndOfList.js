var removeNthFromEnd = function (head, n) {
  let len = 1,
    pointer = head;
  while (pointer.next !== null) {
    len++;
    pointer = pointer.next;
  }

  const target = len - n;
  let answer = head;
  pointer = answer;

  if (target === 0) answer = pointer.next;
  else {
    for (let i = 0; i < target - 1; i++) pointer = pointer.next;
    pointer.next = pointer.next.next;
  }

  return answer;
};
