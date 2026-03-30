// Versione asyncInc con Promise
function asyncInc(x, c) {
  let p = new Promise((resolved, rejected) => resolved(x + 1));
  return p;
}

let p = asyncInc(1);
p.then(res => {
  console.log(res);
  return asyncInc(res);
}).then(res2 => {
  console.log(res2);
});
