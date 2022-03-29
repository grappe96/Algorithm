var mergeTwoLists = function (list1, list2) {
  let node1 = list1,
    node2 = list2,
    answer = new ListNode(101, null),
    node = answer;

  while (node1 !== null && node2 !== null) {
    if (node1.val < node2.val) {
      node = node.next = new ListNode(node1.val, null);
      node1 = node1.next;
    } else {
      node = node.next = new ListNode(node2.val, null);
      node2 = node2.next;
    }
  }
  if (node1 !== null) node.next = node1;
  else node.next = node2;

  return answer.next;
};
