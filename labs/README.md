# Descrição de cada problema

## :mag: Problema 1

Faça um programa que receba cinco valores inteiros e encontre o menor deles.

* `Entradas` - 5 valores inteiros (entre 1 e 30), um por linha.
* `Saída` - O menor valor inteiro.
---

### Exemplo de entradas
```bash
>>
1
4
2
5
2
<<
1
```
```bash
>>
4
2
6
8
3
<<
2
```

```bash
>>
4
7
6
4
3
<<
3
```

## :mag: Problema 2

### Descrição

Vários competidores disputaram uma competição interessante. Eles tinham duas pedras para lançar. Chamemos de pedra A e pedra B. Eles tinham que arremessar ambas as pedras a pelo menos 10 metros de distância. Ganhava a competição, o competidor que arremessou as duas além da linha de 10 m o mais próximo possível uma da outra. Se alguma das pedras tiver distância menor que 10 metros, o competidor estará desclassificado.

### Ação

Faça um programa que retorne o número do vencedor do jogo. O primeiro jogador recebe o número 0.

Ganha a competição, o competidor que arremessar as duas além da linha de 10 m o mais próximo possível uma da outra; e que tiver o arremesso (A ou B) mais próximo de 10m. Arremessos com distância menor que 10 metros do jogador são ignorados e o jogador já está desclassificado.

* `Entradas`
  * O número N de competidores.
  * Distância das pedras A e B de cada competidor.
* `Saída`
  * O número do competidor vitorioso. O primeiro competidor tem número 0. Caso haja empate, mostre o de menor número. Se ninguém ganhar o jogo, porque não conseguiram lançar as bolas além dos 10 metros, imprima "sem ganhador".
---
### Exemplo de entradas
```bash
>>
2
8 11
10 15
<<
1
```
```bash
>>
3
9 12
11 13
10 11
<<
2
```
```bash
>>
3
12 15
16 14
10 9
<<
1
```
```bash
>>
2
10 8
9 13
<<
sem ganhador
```

## :mag: Problema 3

### Descrição
O número de Euler (2,71828182846...) pode ser aproximado pela série abaixo:

$$
  E=1 + \frac{1}{1!} + \frac{1}{2!} + \frac{1}{3!} + ⋯ + \frac{1}{N!}
$$

Faça uma função que retorna o fatorial de um número inteiro positivo n passado como parâmetro, ou seja, retorna 1 * 2 * 3 * ... * (n-1) * n.
Chame esta função de `fatorial`.
O valor retornado, e a variável que armazena o fatorial, devem ser do tipo double, pois esta função cresce muito rápido. Uma variável do tipo int só é capaz de armazenar até 12!.

Em seguida, crie uma função chamada `euler` que recebe um inteiro N e retorna o valor da série

$$
  E=1 + \frac{1}{1!} + \frac{1}{2!} + \frac{1}{3!} + ⋯ + \frac{1}{N!}
$$

A função `euler` deve chamar a função `fatorial`.

A função `main` lê o inteiro N e imprime o valor de `euler(N)`.

* `Entradas`
  * 1a linha: valor do inteiro positivo N
* `Saída`
  * Aproximação do número de Euler somando até 1/N!

Dica: Para esta questão, estude o método System.out.printf() e suas opções de formatação. 

### Exemplos de entradas

```bash

>>
10
<<
2.718282
```

```bash
>>
5
<<
2.716667
```
```bash
>>
3
<<
2.666667
```
## :mag: Problema 4

### Descrição

Faça uma função chamada primo que recebe um inteiro positivo n e retorna true (verdadeiro) se n é primo, ou false (falso) caso contrário. Um número inteiro é primo quando é divisível apenas por 1 e por ele mesmo.

Uma estratégia simples para testar se um número n é primo consiste em procurar um divisor de n do número 2 até o número n−1. Se algum valor nesta faixa é divisor do n, então n não é primo. Caso contrário, n é primo.

Note que a função pode retornar true assim que encontrar um divisor de n entre 2 e n−1.
Ou seja, não é necessário retornar apenas no final da função.

Na função main, leia dois inteiros positivos A e B, com `A ≤ B`, e imprima todos os primos de A até B. Portanto, use a função primo dentro da função main.

* `Entradas`
  * 1a linha: valor do inteiro positivo A.
  * 2a linha: valor do inteiro positivo B (com A≤B).

* `Saída`
  * Todos os primos de A até B (um por linha).

```bash
>>
3
11
<<
3
5
7
11
```
```bash
>>
4
10
<<
5
7
```

## :mag: Problema 5

### Ação

Faça um programa que dado um numero N inteiro (0<N<50) mostre na tela um triangulo isósceles formado por apenas N e com altura igual a N.

* `Entradas`
  * Inteiro N(0<N<50)
* `Saída`
  * Um triângulo isósceles formado por apenas pelo numero N e com altura igual a N.

```bash
<< 3
>>
..3.. 
.3.3.
3.3.3
```
```bash 
>> 2
<<
.2.
2.2
```
```bash
>> 4
<<
...4...  
..4.4..
.4.4.4. 
4.4.4.4

```

## :mag: Problema 6

### Ação
Leia um vetor(array) de tamanho n (quantidade de dominós) , e diga se ele está ordenado de forma crescente.

* `Entradas`
  * O número n ( 0 < n <= 50) de dominós.
  * A altura (inteira) de cada dominó.
* `Saída`
  * "ok" caso  caso vetor esteja ordenado.
  * "precisa de ajuste" caso vetor esteja desordenado.

```bash
>>
5
1 2 3 4 4
<<
ok
```
```bash
>>
6
2 4 2 6 8 10
<<
precisa de ajuste
```
```bash
>>
1
2
<<
ok
```

## :mag: Problema 7

### Ação

Imprima todos os números ímpares na ordem em que foram inseridos na primeira linha, e imprima todos os pares na segunda linha de forma análoga.

* `Entradas`
  * Quantidade N de pessoas na fila.
  * N valores inteiros onde um número ímpar representa um aluno e um par representa um servidor.

* `Saída`
  * Os números ímpares na ordem que aparecem na entrada.
  * Os números pares na ordem que aparecem na entrada.

```bash
>>
2
4 2
<<
[ ]
[ 4 2 ]
```

```bash
>>
4
2 6 4 1
<<
[ 1 ]
[ 2 6 4 ]
```

```bash
6
1 2 5 3 4 9
<<
[ 1 5 3 9 ]
[ 2 4 ]
```

## :mag: Problema 8

### Ação

Faça um programa para calcular a quantidade de números diferentes inseridos, dado um vetor e seu tamanho como entrada.

  * `Entradas`
    * Inteiro com a quantidade de elementos do vetor (1 até 50).
    * Elementos inteiros do vetor.
  * `Saída`
    * Quantidade de números diferentes.

```bash
>>
8
1 9 3 3 3 2 1 4
<<
5
```

```bash
>>
3 
1 1 2
<<
2
```
```bash
>>
5 
1 3 2 2 3
<<
3
```

## :mag: Problema 9

### Motivação

Pedro e João foram no Silvio Santos. O programa era aquele que o Silvio mostrava um produto do mercantil e a pessoa que chegasse mais próximo do preço real ganhava.

João e Pedro são concorrentes. O objetivo do seu programa é informar quem ganhou a disputa.

O primeiro jogador informa o preço e o segundo jogador informa maior ou menor.
Quem vencer mais disputas ganha o jogo. Se o valor do produto for igual ao chute, ganha o primeiro concorrente.

Se ambos vencerem a mesma quantidade então acontece o empate. 

Se ambos tiverem igualmente próximos do preço então nenhum dos dois ganha a disputa.

* `Entrada`

linha 1: a quantidade de produtos (1 a 50)

linha 2: o valor dos produtos (0.01 até 1000.0)

linha 3: os chutes do Primeiro (float)

linha 4: as escolhas do segundo (m para menor, M para maior)

* `Saída`

"primeiro" ou "segundo" ou "empate"

```bash
>>
1
1.0
1.0
M
<<
primeiro
```
```bash
>>
2
1.0 2.0
1.0 2.1
m m
<<
empate
```
```bash
>>
2
1.0 2.0
1.0 2.1
m M
<<
primeiro
```
```bash
>>
2
1.0 2.0
1.1 2.1
m M
<<
empate
```
```bash
>>
3
1.0 2.0 4.0
1.1 2.1 4.0
m M m
<<
primeiro
```
```bash
>>
3
1.0 2.0 4.02
1.1 2.1 4.1
M m m
<<
segundo
```