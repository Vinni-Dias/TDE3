import java.util.Scanner;

class Nodo {
    int k;
    Nodo next;

    public Nodo(int val) {
        this.k = val;
        this.next = null;
    }
}

public class Main {

    private static long bucketTrocas;
    private static long bucketComparacoes;
    private static Nodo lastNode; 
    private static final int M = 10;
 
    public static void main(String[] args) {
        int[] vetor1 = { 12, 18, 9, 25, 17, 31, 22, 27, 16, 13, 19, 23, 20, 30, 14, 11, 15, 24, 26, 28 };
        int[] vetor2 = { 5, 7, 9, 10, 12, 14, 15, 17, 19, 21, 22, 23, 24, 25, 27, 28, 29, 30, 31, 32 };
        int[] vetor3 = { 99, 85, 73, 60, 50, 40, 35, 30, 25, 20, 15, 14, 13, 12, 11, 10, 9, 8, 7, 6 };

        System.out.println("--- Iniciando Análise de Algoritmos de Ordenação ---");

        System.out.println("\n### VETOR 1 (Desordenado)");
        rodarTestes(copiarVetor(vetor1));

        System.out.println("\n### VETOR 2 (Ordenado - Melhor Caso)");
        rodarTestes(copiarVetor(vetor2));

        System.out.println("\n### VETOR 3 (Invertido - Pior Caso)");
        rodarTestes(copiarVetor(vetor3));
    }
    
    public static int[] copiarVetor(int[] original) {
        int[] novo = new int[20];
        for (int i = 0; i < 20; i++) {
            novo[i] = original[i];
        }
        return novo;
    }

    public static void rodarTestes(int[] vetor) {
        System.out.println("Algoritmo, Trocas, Comparações");
        
        long[] resBubble = bubbleSort(copiarVetor(vetor));
        System.out.println("Bubble Sort (Flag), " + resBubble[0] + ", " + resBubble[1]);

        long[] resSelection = selectionSort(copiarVetor(vetor));
        System.out.println("Selection Sort, " + resSelection[0] + ", " + resSelection[1]);

        long[] resCocktail = cocktailSort(copiarVetor(vetor));
        System.out.println("Cocktail Sort, " + resCocktail[0] + ", " + resCocktail[1]);

        long[] resGnome = gnomeSort(copiarVetor(vetor));
        System.out.println("Gnome Sort, " + resGnome[0] + ", " + resGnome[1]);

        long[] resComb = combSort(copiarVetor(vetor));
        System.out.println("Comb Sort, " + resComb[0] + ", " + resComb[1]);

        long[] resBucket = bucketSort(copiarVetor(vetor));
        System.out.println("Bucket Sort, " + resBucket[0] + ", " + resBucket[1]);
    }

    public static long[] bubbleSort(int[] arr) {
        long trocas = 0;
        long comparacoes = 0;
        int n = 20;
        boolean trocou;
        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - 1 - i; j++) {
                comparacoes++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) {
                break;
            }
        }
        return new long[] { trocas, comparacoes };
    }

    public static long[] selectionSort(int[] arr) {
        long trocas = 0;
        long comparacoes = 0;
        int n = 20;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                comparacoes++;
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }
            if (min_idx != i) {
                int temp = arr[min_idx];
                arr[min_idx] = arr[i];
                arr[i] = temp;
                trocas++;
            }
        }
        return new long[] { trocas, comparacoes };
    }

    public static long[] cocktailSort(int[] arr) {
        long trocas = 0;
        long comparacoes = 0;
        boolean trocou = true;
        int inicio = 0;
        int fim = 20;

        while (trocou) {
            trocou = false;
            for (int i = inicio; i < fim - 1; ++i) {
                comparacoes++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou)
                break;
            trocou = false;
            fim--;
            
            for (int i = fim - 1; i >= inicio; i--) {
                comparacoes++;
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            inicio++;
        }
        return new long[] { trocas, comparacoes };
    }

    public static long[] gnomeSort(int[] arr) {
        long trocas = 0;
        long comparacoes = 0;
        int n = 20;
        int pos = 0;
        while (pos < n) {
            if (pos == 0) {
                pos++;
            }
            comparacoes++;
            if (arr[pos] >= arr[pos - 1]) {
                pos++;
            } else {
                int temp = arr[pos];
                arr[pos] = arr[pos - 1];
                arr[pos - 1] = temp;
                trocas++;
                pos--;
            }
        }
        return new long[] { trocas, comparacoes };
    }

    public static long[] combSort(int[] arr) {
        long trocas = 0;
        long comparacoes = 0;
        int n = 20;
        int gap = n;
        boolean trocou = true;

        while (gap != 1 || trocou) {
            gap = (gap * 10) / 13;
            if (gap < 1) {
                gap = 1;
            }

            trocou = false;
            
            for (int i = 0; i < n - gap; i++) {
                comparacoes++;
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    trocas++;
                    trocou = true;
                }
            }
        }
        return new long[] { trocas, comparacoes };
    }

    public static long[] bucketSort(int[] arr) {
        bucketTrocas = 0;
        bucketComparacoes = 0;
        lastNode = null;

        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < 20; i++) {
            bucketComparacoes++;
            if (arr[i] < min) {
                min = arr[i];
            }
            bucketComparacoes++;
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        Nodo head = new Nodo(arr[0]);
        Nodo current = head;
        for (int i = 1; i < 20; i++) {
            current.next = new Nodo(arr[i]);
            current = current.next;
        }

        Nodo sortedHead = sort(head, min, max);

        current = sortedHead;
        int i = 0;
        while (current != null) {
            arr[i] = current.k;
            i++;
            current = current.next;
        }

        return new long[] { bucketTrocas, bucketComparacoes };
    }

    private static Nodo sort(Nodo s, int min, int max) {
        if (s == null) {
            lastNode = null;
            return null;
        }

        if (min == max) {
            Nodo tail = s;
            while (tail.next != null) {
                tail = tail.next;
            }
            lastNode = tail; 
            return s;
        }

        int div = (max - min) / M;
        if (div == 0) {
            div = 1;
        }

        Nodo[] head = new Nodo[M];
        int[] minb = new int[M];
        int[] maxb = new int[M];
        
        for(int i = 0; i < M; i++) {
            head[i] = null;
        }
        
        while (s != null) {
            bucketComparacoes++; 
            int i = (s.k - min) / div;

            bucketComparacoes++; 
            if (i < 0) i = 0;
            else if (i >= M) i = M - 1;

            Nodo t = s;
            s = s.next;
            
            t.next = head[i];

            bucketComparacoes++; 
            if (head[i] == null) {
                minb[i] = maxb[i] = t.k;
            } else {
                bucketComparacoes++;
                if (t.k > maxb[i]) {
                    maxb[i] = t.k;
                }
                bucketComparacoes++;
                if (t.k < minb[i]) {
                    minb[i] = t.k;
                }
            }
            head[i] = t;
        }

        Nodo dummy = new Nodo(0); 
        Nodo t = dummy;

        for (int i = 0; i < M; i++) {
            if (head[i] != null) {
                t.next = sort(head[i], minb[i], maxb[i]);
                t = lastNode; 
            }
        }
        
        lastNode = t; 
        return dummy.next;
    }
}
