function getCombos(a,t){
    var heap = {},
      len = a.length,
        n = 0;
  
    for (var i = 0; i < len; i++){
      n = a[i];
      heap[n] ? heap[n].push([n]) : heap[n] = [[n]];
      for(var j = a[0]; j <= t; j++){
        heap[j] && (heap[j+n] = heap[j+n] ? heap[j+n].concat(heap[j].map(s => s.concat(n)))
                                 : heap[j].map(s => s.concat(n)));
      }
    }
    return heap[t] || [];
  }
  
  var arr = [1,2,5,9],
   target = 20,
   result = [];
  console.time("combos");
  result = getCombos(arr,target);
  console.timeEnd("combos");
  console.log(JSON.stringify(result));