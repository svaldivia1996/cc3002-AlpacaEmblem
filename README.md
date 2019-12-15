# cc3002-AlpacaEmblem
Para la implementación use double dispatch, tanto en equipar item como en las unidades para atacar, para desambiguar tipos
y darle extensibilidad al programa.
Para el caso del Heal no lo implemente como un ataque del tipo staff ya que me parece que tiene mas sentido un metodo llamado heal
que puede ser implementado en futuros posibles items que puedan helear, por ejemplo una poción.
Para ejecutar:
 -En AbstractTestUnit está el TestTrade que se puede ejecutar para ver como las unidades van intercambiando objetos.
 -En cada Clase Test de la unidades hay un cambatTest para ejecutar y ver como las unidades atacan y reciben daño.
 -Para el orden de los turnos se creo un list con los tactitian que estan jugando actualmente y se hace un shuffle al final de cada ronda verificando que no se pueda jugar dos
 veces seguidas con el mismo tactitian.
 -Tanto para el shuuffle de turnos como la creacion del mapa se usaron variables auxiliares random
 que funcionan como seed para poder realizar los test.
 -Para facilitar la creacion de objetos como unidades e items se implemento factory pattern ya que hace mas legible el codigo en el supuesto 
 de que se tengan que inicializar muchos objetos usando un "molde" como argumento.
 -Para mantener el controller del juego al tanto de las acciones de los Tacticians se implemento el observer pattern,
 aqui tuve muchos mas problemas de lo que pensaba al implementarlo pero la idea principal es que el controllador observa los tacticians,
 y cada vez que un tactician realiza acciones clave: como matar una unidad, un heroe, usar/dar un item, el controller reciese un "notificacion" para poder responder correspondiendo a la situacion, por ejemplo
 si muere un heroe el controller debe terminar el turno del jugador y despues eliminarlo de la lista de tactitians jugando.
 
