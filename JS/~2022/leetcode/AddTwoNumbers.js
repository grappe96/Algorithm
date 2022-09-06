var addTwoNumbers = function (l1, l2) {
  let sum = [],
    next = 0;
  while (l1 !== null || l2 !== null || next > 0) {
    let n1 = 0,
      n2 = 0;
    if (l1 !== null) {
      n1 = l1.val;
      l1 = l1.next;
    }
    if (l2 !== null) {
      n2 = l2.val;
      l2 = l2.next;
    }
    let result = n1 + n2 + next;

    if (result >= 10) {
      next = Math.floor(result / 10);
      result = Math.floor(result % 10);
    } else next = 0;

    sum.push(result);
  }

  let answer = null;
  const len = sum.length;
  for (let i = len - 1; i >= 0; i--) answer = new ListNode(sum[i], answer);

  return answer;
};
