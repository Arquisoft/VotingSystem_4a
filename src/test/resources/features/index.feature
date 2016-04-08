# language: es
Característica: Página Index
  Escenario: el cliente llama mediante GET a /
    Cuando el cliente llama a /
    Entonces el cliente recibe el código de estado 200
    Y el cliente recibe la cadena "Voting"
