# practicaaaafinal5
TITULO DESCRIPTIVO: 

El código proporciona una implementación de un algoritmo para encontrar el camino más corto entre dos vértices en un grafo dirigido.

DESCRIPCION:  

Esta práctica consiste en desarrollar un algoritmo para encontrar el camino más corto entre dos vértices en un grafo dirigido. Utilizando el método de búsqueda de camino más corto sobre una representación de lista de adyacencia del grafo, el algoritmo determina la ruta óptima entre dos puntos en el grafo.

INSTRUCCIONES DE INSTALACION:

1. Clonar el repositorio de GitHub de la calculadora de distancia más corta entre dos grafos.
2. Asegurarse de tener instalado Java en tu sistema.
3. Abre el proyecto en tu IDE preferido.
4. Compila el codigo si es necesario.
5. Ejecuta desde la clase main.

ESTRUCTURA DEL CODIGO: 

- Se verifica si los vértices de inicio (v1) y destino (v2) están presentes en el grafo. Si alguno de ellos no está presente, significa que no hay un camino posible entre ellos y se devuelve null.
- Se inicializan tres estructuras de datos: Una cola que realiza el recorrido en anchura. Un mapa que registrará los predecesores. y un conjunto que registrará los vértices que se han visitado durante el proceso de búsqueda.
- En resumen, la lógica del código consiste en realizar un recorrido en anchura en el grafo desde el vértice de inicio hasta el vértice destino, registrando los predecesores de cada vértice a medida que se avanza. Una vez que se encuentra el vértice destino, se reconstruye el camino más corto retrocediendo a través de los predecesores registrados.

LICENCIA: 

- Copyright [2024] [Genesis Chicaiza]Licensed under the Apache License, Version 2.0 (the "License");you may not use this file except in compliance with the License.You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0Unless required by applicable law or agreed to in writing, softwaredistributed under the License is distributed on an "AS IS" BASIS,WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.See the License for the specific language governing permissions andlimitations under the License.