# Pregunta 1

# Pregunta 2
## Requisito 1: Colocación de Piezas
### Prueba límites del tablero I
En esta prueba, estamos definiendo que se espera null cuando se invoca el método game.getCell(5, 2) ya que esta fila no es válida.
``` Java
@Test
    public void testInvalidRow() {
        game.makeMove(5, 2);
        assertEquals(game.getCell(5,2), null);
        // Retorna null por que no existe la fila
    }
```
### Prueba límites del tablero II
En esta prueba, estamos definiendo que se espera null cuando se invoca el método game.getCell(2, 5) ya que esta columna no es válida.
``` Java
@Test
    public void testInvalidColumn() {
        game.makeMove(2, 5);
        assertEquals(game.getCell(2,5), null);
        // Retorna null por que no existe la columna
    }
```
### Prueba lugar ocupado
En esta prueba, estamos definiendo que se espera una X cuando se invoca el método game.getCell(1, 1) ya que previamente se realizó un movimiento en esta celda.
``` Java
@Test
    public void testInvalidCell(){
        game.makeMove(1,1);
        assertEquals(game.getCell(1,1), TicTacToe.Cell.CROSS);
        // Retorna Cell por que ya la celda está ocupada
    }
```
## Requisito 2: Agregar soporte para 2 jugadores
### Prueba X juega primero
En esta prueba, estamos definiendo que se espera X cuando se invoca el método game.getTurn() ya que X es el primer turno.
``` Java
@Test
    public void testFirstTurn() {
        game.makeMove(0, 0);
        assertEquals(game.getTurn(), 'X');
        // Retorna X por que es el primero en jugar
    }
```
### Prueba O juega justo después de X
En esta prueba, estamos definiendo que se espera O cuando se invoca el método game.getTurn() ya que a O le corresponde el segundo turno.
``` Java
@Test
    public void testSecondTurn() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        assertEquals(game.getTurn(), 'O');
        // Retorna O por que es el segundo en jugar
    }
```
### Prueba x juega justo después de O
En esta prueba, estamos definiendo que se espera X cuando se invoca el método game.getTurn() ya que el tercer turno le corresponde a X.
``` Java
@Test
    public void testThirdTurn() {
        game.makeMove(0, 0);
        game.makeMove(1, 0);
        game.makeMove(2, 0);
        assertEquals(game.getTurn(), 'X');
        // Retorna X por que es el tercero en jugar
    }
```
## Requisito 3: Agregar condiciones ganadoras
### Prueba por defecto no hay ganador
En esta prueba, estamos definiendo que se espera tener el estado PLAYING ya que no hay ganadores.
``` Java
@Test
    public void noWinner() {
        assertEquals(game.getGameState(), TicTacToe.GameState.PLAYING);
        // Retorna el estado "PLAYING" por que no hay ganador
    }
```
### Prueba condición ganadora I
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea horizontal de tres.
``` Java
@Test
    public void testXWonHorizontally() {
        game.makeMove(0, 0);
        game.makeMove(1, 2);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(0, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        // Retorna el estado "CROSS_WON" por que X formó una linea de 3 horizontal
    }
```
### Prueba condición ganadora II
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea vertical de tres.
``` Java
 @Test
    public void testXWonVertically() {
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 0);
        game.makeMove(1, 1);
        game.makeMove(2, 0);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        // Retorna el estado "CROSS_WON" por que X formó una linea de 3 vertical
    }
```
### Prueba condición ganadora III
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea diagonal de tres.
``` Java
@Test
    public void testXWonDiagonally() {
        game.makeMove(0, 0);
        game.makeMove(0, 2);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(2, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        /* Retorna el estado "CROSS_WON" por que X formó una linea diagonal desde
         la parte superior izquierda hasta la parte inferior derecha */
    }
```
### Prueba condición ganadora IV
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea diagonal invertida de tres.
``` Java
@Test
    public void testXWonDiagonallyInverted() {
        game.makeMove(2, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(1, 2);
        game.makeMove(0, 2);
        assertEquals(game.getGameState(), TicTacToe.GameState.CROSS_WON);
        /* Retorna el estado "CROSS_WON" por que X formó una linea diagonal desde
         la parte inferior izquierda hasta la parte superior derecha */
    }
```
## Requisito 3: Condiciones de empate
### Prueba manejo de una situación de empate
En esta prueba, estamos definiendo que se espera un empate ya que no hay más movimientos por hacer y no hay ningún ganador.
``` Java
@Test
    public void testDraw(){
        game.makeMove(0, 0);
        game.makeMove(0, 1);
        game.makeMove(1, 1);
        game.makeMove(1, 0);
        game.makeMove(1, 2);
        game.makeMove(0, 2);
        game.makeMove(2, 1);
        game.makeMove(2, 2);
        game.makeMove(2,0);
        assertEquals(game.getGameState(),TicTacToe.GameState.DRAW);
        // Retorna el estado de juego "DRAW" por que hubo un empate
    }
```
# Pregunta 3
## Requisito 1: Colocación de Piezas
### Prueba límites del tablero I
En esta prueba, estamos definiendo que se espera null cuando se invoca el método game.getCell(5, 2) ya que esta fila no es válida.
``` Java

```
### Prueba límites del tablero II
En esta prueba, estamos definiendo que se espera null cuando se invoca el método game.getCell(2, 5) ya que esta columna no es válida.
``` Java
    
```
### Prueba lugar ocupado
En esta prueba, estamos definiendo que se espera una X cuando se invoca el método game.getCell(1, 1) ya que previamente se realizó un movimiento en esta celda.
``` Java

```
## Requisito 2: Agregar soporte para 2 jugadores
### Prueba X juega primero
En esta prueba, estamos definiendo que se espera X cuando se invoca el método game.getTurn() ya que X es el primer turno.
``` Java

```
### Prueba O juega justo después de X
En esta prueba, estamos definiendo que se espera O cuando se invoca el método game.getTurn() ya que a O le corresponde el segundo turno.
``` Java

```
### Prueba x juega justo después de O
En esta prueba, estamos definiendo que se espera X cuando se invoca el método game.getTurn() ya que el tercer turno le corresponde a X.
``` Java

```
## Requisito 3: Agregar condiciones ganadoras
### Prueba por defecto no hay ganador
En esta prueba, estamos definiendo que se espera tener el estado PLAYING ya que no hay ganadores.
``` Java

```
### Prueba condición ganadora I
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea horizontal de tres.
``` Java

```
### Prueba condición ganadora II
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea vertical de tres.
``` Java

```
### Prueba condición ganadora III
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea diagonal de tres.
``` Java

```
### Prueba condición ganadora IV
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea diagonal invertida de tres.
``` Java

```
## Requisito 3: Condiciones de empate
### Prueba manejo de una situación de empate
En esta prueba, estamos definiendo que se espera un empate ya que no hay más movimientos por hacer y no hay ningún ganador.
``` Java

```
# Pregunta 4
