# Análise de Desempenho de Algoritmos de Ordenação

Este projeto compara o desempenho de 5 algoritmos de ordenação em Java, analisando o número de **trocas de elementos** e o número de **comparações** (iterações do laço) em três cenários de teste distintos:

1.  **Vetor 1:** Um vetor desordenado com 20 elementos.
2.  **Vetor 2:** Um vetor já ordenado (melhor caso para alguns algoritmos).
3.  **Vetor 3:** Um vetor ordenado em ordem inversa (pior caso para alguns algoritmos).

Os algoritmos analisados são:
* Bubble Sort 
* Selection Sort
* Cocktail Sort
* Gnome Sort
* Comb Sort

## Resultados

Os resultados foram obtidos executando os algoritmos em cada vetor e contando as operações.

### Cenário 1: Vetor Desordenado
`vetor1 = {12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
| **1** | **Selection Sort** | **12** |
| 2 | Comb Sort | 30 |
| 3 | Bubble Sort (Flag) | 97 |
| 4 | Cocktail Sort | 97 |
| 5 | Gnome Sort | 97 |

#### Ranking de COMPARAÇÕES (Menos é melhor)
| Posição | Algoritmo | Comparações |
| :--- | :--- | :--- |
| **1** | **Comb Sort** | **114** |
| 2 | Bubble Sort (Flag) | 190 |
| 3 | Selection Sort | 190 |
| 4 | Cocktail Sort | 190 |
| 5 | Gnome Sort | 287 |

---

### Cenário 2: Vetor Ordenado (Melhor Caso)
`vetor2 = {5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
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

---

### Cenário 3: Vetor Invertido (Pior Caso)
`vetor3 = {99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6}`

#### Ranking de TROCAS (Menos é melhor)
| Posição | Algoritmo | Trocas |
| :--- | :--- | :--- |
| **1** | **Selection Sort** | **10** |
| 2 | Comb Sort | 24 |
| 3 | Bubble Sort (Flag) | 190 |
| 4 | Cocktail Sort | 190 |
| 5 | Gnome Sort | 190 |

#### Ranking de COMPARAÇÕES (Menos é melhor)
| Posição | Algoritmo | Comparações |
| :--- | :--- | :--- |
| **1** | **Comb Sort** | **76** |
| 2 | Bubble Sort (Flag) | 190 |
| 3 | Selection Sort | 190 |
| 4 | Gnome Sort | 209 |
| 5 | Cocktail Sort | 285 |

---

## Análise e Conclusão

Analisando os três cenários, podemos tirar as seguintes conclusões:

### 1. Quem foi melhor em TROCAS?

O **Selection Sort** foi o vencedor disparado na métrica de trocas em vetores desordenados e invertidos. Ele faz, no máximo, $O(n)$ trocas (uma para cada elemento), o que é excelente se a operação de troca for muito custosa.

### 2. Quem foi melhor em COMPARAÇÕES/ITERAÇÕES?

O **Comb Sort** foi o vencedor claro em comparações para vetores desordenados e invertidos, mostrando sua eficiência na prática.

Para o vetor **já ordenado**, o **Bubble Sort**, **Cocktail Sort** e **Gnome Sort** foram os melhores, pois todos possuem mecanismos para detectar que o vetor está ordenado e parar cedo, alcançando um desempenho de $O(n)$.

### 3. Quem foi o Pior?

* O **Selection Sort**, apesar de ótimo em trocas, foi o pior em comparações no cenário ordenado, pois ele *sempre* executa seus dois laços independentemente da ordenação inicial.
* O **Gnome Sort** e o **Cocktail Sort** tiveram um desempenho de comparações muito ruim nos cenários desordenado e invertido, sendo piores que o Bubble Sort simples.

### Conclusão Geral

* **Melhor Algoritmo Geral:** O **Comb Sort** é o algoritmo mais eficiente dos testados, dominando os cenários desordenado e invertido.
* **Melhor para "Quase Ordenado":** O **Bubble Sort (com flag)** ou o **Gnome Sort** são as melhores escolhas se houver alta probabilidade de o vetor já estar ordenado ou quase ordenado, devido à sua parada antecipada $O(n)$.
* **Melhor para "Poucas Trocas":** O **Selection Sort** é a escolha ideal se o custo de trocar elementos for muito mais alto que o custo de compará-los.
