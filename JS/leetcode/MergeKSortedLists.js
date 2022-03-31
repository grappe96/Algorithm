var mergeKLists = function (lists) {
  const answer = new ListNode(-1, null);

  for (let list of lists) {
    let listNode = list,
      node = answer,
      nextNode = answer.next;
    while (listNode !== null) {
      while (nextNode !== null && nextNode.val < listNode.val) {
        node = nextNode;
        nextNode = nextNode.next;
      }

      node = node.next = new ListNode(listNode.val, nextNode);
      nextNode = node.next;
      listNode = listNode.next;
    }
  }
  return answer.next;
};
