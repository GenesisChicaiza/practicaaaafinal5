import java.util.*;


/**
 * @author Genesis Chicaiza
 * @param <V>
 */
public class Graph<V>{
    //Lista de adyacencia.
    private Map<V, Set<V>> adjacencyList = new HashMap<>();
/******************************************************************
 * Añade el vértice `v` al grafo.
 *
 * @param v vértice a añadir.
contrario.
 * @return `true` si no estaba anteriormente y `false` en caso
 *
 ******************************************************************/
public boolean addVertex(V v){
    if (!adjacencyList.containsKey(v)) {
        adjacencyList.put(v, new HashSet<>());
        return true; //Este código hay que modificarlo.
    } return false;
}
    /******************************************************************
     * Añade un arco entre los vértices `v1` y `v2` al grafo. En
     * caso de que no exista alguno de los vértices, lo añade
     * también.
     *
     * @param v1 el origen del arco.
     * @param v2 el destino del arco.
     * @return `true` si no existía el arco y `false` en caso contrario.
     ******************************************************************/
    public boolean addEdge(V v1, V v2){
        addVertex(v1);
        addVertex(v2);
        adjacencyList.get(v1).add(v2);
        return true; //Este código hay que modificarlo.
    }
    /******************************************************************
     * Obtiene el conjunto de vértices adyacentes a `v`.
     *
     * @param v vértice del que se obtienen los adyacentes.
     * @return conjunto de vértices adyacentes.
     ******************************************************************/
    public Set<V> obtainAdjacents(V v) throws Exception{
        if (!adjacencyList.containsKey(v)) {
            throw new Exception("Vertex not found in graph");
        }
        return adjacencyList.get(v);
    }

    /******************************************************************
     * Comprueba si el grafo contiene el vértice dado.
     *
     * @param v vértice para el que se realiza la comprobación.
     * @return `true` si `v` es un vértice del grafo.
     ******************************************************************/
    public boolean containsVertex(V v){
        return adjacencyList.containsKey(v);
    }
/******************************************************************
 * Método `toString()` reescrito para la clase `Grafo.java`.
 * @return una cadena de caracteres con la lista de
 * adyacencia.
 ******************************************************************/
@Override
public String toString(){
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<V, Set<V>> entry : adjacencyList.entrySet()) {
        sb.append(entry.getKey()).append(": ");
        sb.append(entry.getValue()).append("\n");
    }
    return sb.toString();}
    /**
     * Obtiene, en caso de que exista, el camino más corto entre
     * `v1` y `v2`. En caso contrario, devuelve `null`.
     *
     * @param v1 el vértice origen.
     * @param v2 el vértice destino.
     * @return lista con la secuencia de vértices del camino más corto
     * entre `v1` y `v2`
     */
    public List<V> shortestPath(V v1, V v2){ //verifica si los vertices esta en el grafo
        if (!containsVertex(v1) || !containsVertex(v2)) {
            return null;
        }
//incializacion de la cola
        Queue<V> queue = new LinkedList<>(); //recorrido de anchura
        Map<V, V> previous = new HashMap<>(); //Los predecesores de un vertice son los vértices que se encuentran en el camino más corto desde el vertice de inicio hasta el vertice en cuestion.
        Set<V> visited = new HashSet<>(); //registro de vertice visitados durante el proceso

        queue.add(v1); //se añade a la cola
        visited.add(v1); //se añade a los visitados

        while (!queue.isEmpty()) {  //continua hasta que la cola este vacia o hasta que se encuentre el vertice de destino
            V current = queue.poll(); //para extraer y eliminar el elemento al frente de la cola.
            if (current.equals(v2)) { //compara si son iguales
                break; // Si hemos llegado al vertice destino, no necesitamos seguir buscando
            }

            for (V neighbor : adjacencyList.get(current)) { //obtiene los vecinos del vértice actual
                if (!visited.contains(neighbor)) {  //verifica si el vecino actual ya ha sido visitado.
                    queue.add(neighbor); //Añadimos el vecino al final de la cola
                    visited.add(neighbor); //vecino como visitado añadiéndolo al conjunto visited
                    previous.put(neighbor, current); //actualiza el mapa previous para registrar que el vertice neighbor fue alcanzado desde el vertice current.
                    //permite reconstruir el camino mas corto
                }
            }
        }

        // Reconstruir el camino desde v2 a v1
        List<V> path = new ArrayList<>(); //almacena los vertices en el camino mas corto desde el vertice de inicio hasta el vertice de destino.
        V current = v2; //establece el vertice actual en el vertice de destino.
        while (current != null) {  //continua hasta que llegue al vertice de inicio (v1) o hasta que no haya mas predecesores en el camino mas corto.
            path.add(current);//añade al vertice actual en la lista
            current = previous.get(current); // actualiza el vertice actual usando el mapa previous.
        }
        Collections.reverse(path); // Invertir el camino para que v1 sea el primer elemento
        return path.isEmpty() ? null : path; /*La condicion es path.isEmpty(). Esto verifica si la lista path esta vacia.
Si la condicion es verdadera (path vacio), se devuelve null.
Si la condición es falsa (path no esta vacia), se devuelve path.*/
    }

}
