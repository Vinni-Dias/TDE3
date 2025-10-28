# Análise de Desempenho de Algoritmos de Ordenação

Este projeto compara o desempenho de 6 algoritmos de ordenação em Java, analisando o número de trocas de elementos e o número de comparações (iterações do laço) em três cenários de teste distintos:

1.  **Vetor 1:** Um vetor desordenado com 20 elementos.
2.  **Vetor 2:** Um vetor já ordenado (melhor caso para alguns algoritmos).
3.  **Vetor 3:** Um vetor ordenado em ordem inversa (pior caso para alguns algoritmos).

Os algoritmos analisados são:
* Bubble Sort (com flag de parada)
* Selection Sort
* Cocktail Sort
* Gnome Sort
* Comb Sort
* Bucket Sort

---

## Resultados e Rankings

Os resultados foram obtidos executando os algoritmos em cada vetor e contando as operações.

### Cenário 1: Vetor Desordenado
`vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
| **1** | **Bucket Sort** | **0** |
| 2 | Selection Sort | 12 |
| 3 | Comb Sort | 30 |
| 4 | Bubble Sort (Flag) | 97 |
| 5 | Cocktail Sort | 97 |
| 6 | Gnome Sort | 97 |

#### Ranking de COMPARAÇÕES (Menos é melhor)
| Posição | Algoritmo | Comparações |
| :--- | :--- | :--- |
| **1** | **Comb Sort** | **114** |
| 2 | Bubble Sort (Flag) | 190 |
| 3 | Selection Sort | 190 |
| 4 | Cocktail Sort | 190 |
| 5 | Bucket Sort | 219 |
| 6 | Gnome Sort | 287 |

---

### Cenário 2: Vetor Ordenado (Melhor Caso)
`vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
| **1 (Empate)** | **Bucket Sort** | **0** |
| **1 (Empate)** | **Bubble Sort (Flag)** | **0** |
| **1 (Empate)** | **Selection Sort** | **0** |
| **1 (Empate)** | **Cocktail Sort** | **0** |
| **1 (Empate)** | **Gnome Sort** | **0** |
| **1 (Empate)** | **Comb Sort** | **0** |

#### Ranking de COMPARAÇÕES (Menos é melhor)
| Posição | Algoritmo | Comparações |
| :--- | :--- | :--- |
| **1 (Empate)** | **Bubble Sort (Flag)** | **19** |
| **1 (Empate)** | **Cocktail Sort** | **19** |
| **1 (Empate)** | **Gnome Sort** | **19** |
| 4 | Comb Sort | 48 |
| 5 | Selection Sort | 190 |
| 6 | Bucket Sort | 229 |

---

### Cenário 3: Vetor Invertido (Pior Caso)
`vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
| **1** | **Bucket Sort** | **0** |
| 2 | Selection Sort | 10 |
| 3 | Comb Sort | 24 |
| 4 | Bubble Sort (Flag) | 190 |
| 5 | Cocktail Sort | 190 |
| 6 | Gnome Sort | 190 |

#### Ranking de COMPARAÇÕES (Menos é melhor)
| Posição | Algoritmo | Comparações |
| :--- | :--- | :--- |
| **1** | **Comb Sort** | **76** |
| 2 | Bubble Sort (Flag) | 190 |
| 3 | Selection Sort | 190 |
| 4 | Gnome Sort | 209 |
| 5 | Bucket Sort | 239 |
| 6 | Cocktail Sort | 285 |

---

## Análise e Conclusão

Com a inclusão do Bucket Sort, a análise fica mais interessante:

### 1. Quem foi melhor em TROCAS?

O **Bucket Sort** é o vencedor técnico, pois ele não realiza nenhuma troca de elementos. Ele é um algoritmo "out-of-place", que reconstrói a estrutura de dados em vez de modificá-la.

Entre os algoritmos "in-place", o **Selection Sort** continua sendo o campeão de trocas, realizando o mínimo de movimentações necessárias.

### 2. Quem foi melhor em COMPARAÇÕES/ITERAÇÕES?

O **Comb Sort** é o claro vencedor em velocidade $O(n \log n)$ para vetores desordenados e invertidos, pois suas comparações são muito eficientes.

Para o vetor **já ordenado**, o **Bubble Sort (com flag)**, **Cocktail Sort** e **Gnome Sort** são imbatíveis, pois param em tempo $O(n)$.

O **Bucket Sort** teve um número de "comparações" (cálculos de índice e checagens) estável, mas mais alto que os outros. Isso é esperado: ele troca comparações diretas por operações matemáticas e de alocação de memória (criação de Nodos). Em um conjunto de dados muito maior, ele superaria os algoritmos $O(n^2)$.

### Conclusão Geral

* **Comb Sort:** É o melhor algoritmo de comparação testado para cenários genéricos (desordenado/invertido).
* **Bubble/Gnome/Cocktail:** Excelentes para dados quase ordenados.
* **Selection Sort:** O melhor se o custo de troca for a métrica mais importante.
* **Bucket Sort:** Demonstra uma lógica completamente diferente. Ele vence em "trocas" (com 0), mas seu custo real está na complexidade espacial (uso de memória para os baldes e listas) e nas operações de alocação de Nodos, que não foram medidas aqui.
