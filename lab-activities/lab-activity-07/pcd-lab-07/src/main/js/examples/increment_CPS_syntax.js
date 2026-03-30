// Incremento con callback in modo asincrono (analogo a succ())
function asyncInc(x, c) {
  setTimeout(() => c(x + 1), 0);
}

asyncInc(1, (res) => console.log(res))

console.log("hello")

// Esempio con chiamate innestate
asyncInc(1, res => {
  console.log(res);
  asyncInc(res, res1 => {
    console.log(res1);
  });
});

// Esempio con chiamate parallele
asyncInc(1, res => console.log(res));
asyncInc(5, res => console.log(res));
