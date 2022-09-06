var mergeKLists = function (lists) {
  const binarySearch = function (l, r) {
    if (l >= r) return lists[l];

    let mid = Math.floor((l + r) / 2);

    let l1 = binarySearch(l, mid);
    let l2 = binarySearch(mid + 1, r);

    return mergeLists(l1, l2);
  };

  const mergeLists = function (l1, l2) {
    if (l1 === null) return l2;
    if (l2 === null) return l1;

    if (l1.val < l2.val) {
      l1.next = mergeLists(l1.next, l2);
      return l1;
    } else {
      l2.next = mergeLists(l1, l2.next);
      return l2;
    }
  };

  const k = lists.length;

  if (k === 0) return null;
  return binarySearch(0, k - 1);
};
