Достаточно интересная и головоломная задачка оказалась.

Итеративный DFS (Deep First Search) здесь не канает, подошёл только рекурсивный.
* Сначала я перевёл исходный граф в удобный вид, чтобы можно было быстро по номеру вершины получить все смежные с ней
```java
List<List<Integer>> graph = new ArrayList<>();
for (int i = 0; i < n; ++i){
    graph.add(new ArrayList<>());
}

for (int[] edge : edges) {
    graph.get(edge[0]).add(edge[1]);
    graph.get(edge[1]).add(edge[0]);
}
```
* Затем начинается вызов DFS. То есть рекурсивный обход ненаправленного дерева
```java
private int dfs(List<List<Integer>> graph, int root, int parent, List<Boolean> hasApple)
```
```java
int minimumTime = dfs(graph, 0, -1, hasApple);
```
* dfs возвращает минимальное время, чтобы собрать в нем все яблоки, но может и вернуть -1 (служебное значение), когда нет яблок среди всех детей и сам текущий <code>root</code> не является яблоком, то есть в такое поддерево даже нет смысла идти, ибо яблок там нет.
Сама реализация dfs выглядит следующим образом
```java
private int dfs(List<List<Integer>> graph, int root, int parent, List<Boolean> hasApple) {
    int totalTime = 0;
    for (Integer x : graph.get(root)) {
        if (x == parent) continue;
        int childTime = dfs(graph, x, root, hasApple);
        if (childTime >= 0) {
            totalTime += childTime + 2;
        }
    }

    if (totalTime == 0 && !hasApple.get(root)) {
        return -1;
    }
    return totalTime;
}
```