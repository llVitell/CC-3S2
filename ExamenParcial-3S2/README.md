# Pregunta 1
### Código antes de LSP
``` Java
public abstract class Member {
private final String nombre;
public Member(String nombre) {
    this.name = nombre;
}
    public abstract void joinTournament();
    public abstract void organizeTournament();
}
```
``` Java
public class PremiumMember extends Member {
public PremiumMember(String nombre) {
super(nombre);
}
```
``` Java
public class FreeMember extends Member {
public FreeMember(String name) {
super(nombre);
}
public void joinTournament() {
System.out.println(“.....");
}
//Este método rompe LSP
public void organizeTournament() {
System.out.println("...");
}
}
```
``` Java
List<Member> miembros = List.of(
PremiumMember("Abejita Azul"),
new VipMember("Kaperucita Feliz"),
new FreeMember("Inspectora Motita")
);
```
### Código después de LSP
``` Java
public abstract class Member {
private final String nombre;
public Member(String nombre) {
    this.name = nombre;
}
    public abstract void joinTournament();
}
```
``` Java
public class PremiumMember extends Member {
public PremiumMember(String nombre) {
super(nombre);
}   
    @Override
    public void joinTournament(){
        System.out.println("Ingresaste Correctamente")
    }
    public void organizeTournament(){
        System.out.println("Organizando Torneo ....")
    }
}
```
``` Java
public class VipMember extends Member {
public VipMember(String nombre) {
super(nombre);
}
    @Override
    public void joinTournament(){
        System.out.println("Ingresaste Correctamente")
    }
    public void organizeTournament(){
        System.out.println("Organizando Torneo ....")
    }
}
```
``` Java
public class FreeMember extends Member {
public FreeMember(String name) {
super(nombre);
}   
    @Override
    public void joinTournament() {
    System.out.println(“Ingresaste correctamente");
    }
}
```
``` Java
List<Member> miembros = List.of(
PremiumMember("Abejita Azul"),
new VipMember("Kaperucita Feliz"),
new FreeMember("Inspectora Motita")
);
// Los miembros "Abejita Azul" y "Kaperucita Feliz" tienen acceso al método "Organizar Torneo" sin embargo la "Inspectora Motita" solo puede acceder al método "Ingresar Torneo".
```

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
### Prueba X juega justo después de O
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
En esta prueba, estamos definiendo que se espera un error cuando se invoca el método makeMove() ya que esta fila no es válida.
``` TypeScript
test("Prueba Límites del tablero I", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");

      expect(() => player1.makeMove(board, 2, 5, "S")).toThrow(
        "Cell position out of bounds."
      );
    });
```
### Prueba límites del tablero II
En esta prueba, estamos definiendo que se espera un error cuando se invoca el método makeMove() ya que esta columna no es válida.
``` TypeScript
test("Pruebas Límites del tablero II", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");

      expect(() => player1.makeMove(board, 5, 2, "S")).toThrow(
        "Cell position out of bounds."
      );
    });
```
### Prueba lugar ocupado
En esta prueba, estamos definiendo que se espera un false cuando se invoca el método makeMove(board,1,1,"O") ya que previamente se realizó un movimiento en la celda (1,1).
``` TypeScript
test("Prueba lugar ocupado", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");
      player1.makeMove(board,1,1,"S");
      expect(player1.makeMove(board, 1, 1, "O")).toBe(false);
    });
```
## Requisito 2: Agregar soporte para 2 jugadores
### Prueba X juega primero
En esta prueba, estamos definiendo que se espera true cuando se invoca el método makeMove(board,1,1,"X") ya que se efectuó el primer movimiento.
``` TypeScript
test("Prueba X juega primero", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");
      expect(player1.makeMove(board, 1, 1, "X")).toBe(true);
    });
```
### Prueba O juega justo después de X
En esta prueba, estamos definiendo que se espera true cuando se invoca el método makeMove(board,1,1,"O") por el player2 ya que se efectuó el segundo movimiento.
``` TypeScript
test("Prueba O juega justo después de X", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");
      const player2 = new Player("Blue");
      player1.makeMove(board,0,0,"X");
      expect(player2.makeMove(board, 1, 1, "O")).toBe(true);
    });
```
### Prueba X juega justo después de O
En esta prueba, estamos definiendo que se espera true cuando se invoca el método makeMove(board,1,1,"X") por el player1 ya que se efectuó el tercer turno.
``` TypeScript
test("Prueba X juega justo después de O", () => {
      const board = new Board(3, 3, true);
      const player1 = new Player("Red");
      const player2 = new Player("Blue");
      player1.makeMove(board,0,0,"X");
      player2.makeMove(board,1,0,"O")
      expect(player1.makeMove(board, 1, 1, "X")).toBe(true);
    });
```
## Requisito 3: Agregar condiciones ganadoras
### Prueba por defecto no hay ganador
En esta prueba, estamos definiendo que se espera tener el error "playing" ya que no hay ganadores.
``` TypeScript
test("Prueba por defecto no hay ganador", () => {
        expect(() => game.getWinner()).toThrow("Playing");
    });
```
### Prueba condición ganadora I
En esta prueba, estamos definiendo que se espera una victoria del player2 ya que formó una linea horizontal de tres.
``` TypeScript
test("Prueba condición ganadora I", () => {
      const board = new Board();
      const players = [new Player("Red"), new Player("Blue")];
      const mode = Mode.SIMPLE_GAME;
      const game = new Game(board, players, mode);
      const movements: [number, number, Letter][] = [
        [1, 1, Letter.S], // PJ1
        [0, 0, Letter.O], // PJ2
        [1, 0, Letter.O], // PJ1
        [0, 1, Letter.S], // PJ2
        [1, 2, Letter.S], // PJ1
        [0, 2, Letter.S], // PJ2
      ];
      movements.forEach((movement) => {
        game.makeMove(movement[0], movement[1], movement[2]);
      });
      expect(game.getWinner()).toBe(players[1]);
    });
```
### Prueba condición ganadora II
En esta prueba, estamos definiendo que se espera una victoria del player2 ya que formó una linea vertical de tres.
``` TypeScript
test("Prueba condición ganadora I", () => {
      const board = new Board();
      const players = [new Player("Red"), new Player("Blue")];
      const mode = Mode.SIMPLE_GAME;
      const game = new Game(board, players, mode);
      const movements: [number, number, Letter][] = [
        [1, 1, Letter.S], // PJ1
        [0, 0, Letter.O], // PJ2
        [1, 2, Letter.O], // PJ1
        [1, 0, Letter.S], // PJ2
        [2, 1, Letter.S], // PJ1
        [2, 0, Letter.S], // PJ2
      ];
      movements.forEach((movement) => {
        game.makeMove(movement[0], movement[1], movement[2]);
      });
      expect(game.getWinner()).toBe(players[1]);
    });
```
### Prueba condición ganadora III
En esta prueba, estamos definiendo que se espera una victoria del player1 ya que formó una linea diagonal de tres.
``` TypeScript
test("Prueba condición ganadora I", () => {
      const board = new Board();
      const players = [new Player("Red"), new Player("Blue")];
      const mode = Mode.SIMPLE_GAME;
      const game = new Game(board, players, mode);
      const movements: [number, number, Letter][] = [
        [0, 0, Letter.S], // PJ1
        [0, 1, Letter.O], // PJ2
        [1, 1, Letter.O], // PJ1
        [1, 0, Letter.S], // PJ2
        [2, 2, Letter.S], // PJ1
        [2, 0, Letter.S], // PJ2
      ];
      movements.forEach((movement) => {
        game.makeMove(movement[0], movement[1], movement[2]);
      });
      expect(game.getWinner()).toBe(players[0]);
    });
```
### Prueba condición ganadora IV
En esta prueba, estamos definiendo que se espera una victoria de la X ya que formó una linea diagonal invertida de tres.
``` TypeScript
test("Prueba condición ganadora I", () => {
      const board = new Board();
      const players = [new Player("Red"), new Player("Blue")];
      const mode = Mode.SIMPLE_GAME;
      const game = new Game(board, players, mode);
      const movements: [number, number, Letter][] = [
        [2, 0, Letter.S], // PJ1
        [0, 0, Letter.O], // PJ2
        [1, 1, Letter.O], // PJ1
        [1, 0, Letter.S], // PJ2
        [0, 2, Letter.S], // PJ1
        [2, 1, Letter.S], // PJ2
      ];
      movements.forEach((movement) => {
        game.makeMove(movement[0], movement[1], movement[2]);
      });
      expect(game.getWinner()).toBe(players[0]);
    });
```
## Requisito 3: Condiciones de empate
### Prueba manejo de una situación de empate
En esta prueba, estamos definiendo que se espera un error "DRAW" ya que no hay más movimientos por hacer y no hay ningún ganador.
``` TypeScript
test("Prueba por defecto no hay ganador", () => {
        expect(() => game.getWinner()).toThrow("DRAW");
    });
```
# Pregunta 4
