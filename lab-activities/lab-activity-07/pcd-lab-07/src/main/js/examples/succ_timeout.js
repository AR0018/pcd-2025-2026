// Esempio succ()
async function succ(x, c) {
  c(x + 1)
}
succ(10, res => console.log(res))

/* Esempio setTimeout. Anche se mettiamo come timeout 0,
* non potrà mai succedere che "hello 2" verrà visualizzata prima di
* "hello 1", perché la setTimeout mette il suo callback in coda
* DOPO l'handler principale del programma.
*/
setTimeout( () => {
  console.log("Hello 2");
}, 0);

console.log("Hello 1")