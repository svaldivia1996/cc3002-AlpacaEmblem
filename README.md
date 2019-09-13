# cc3002-AlpacaEmblem
Para la implementación use double dispatch, tanto en equipar item como en las unidades para atacar, para desambiguar tipos
y darle extensibilidad al programa.
Para el caso del Heal no lo implemente como un ataque del tipo staff ya que me parece que tiene mas sentido un metodo llamado heal
que puede ser implementado en futuros posibles items que puedan helear, por ejemplo una poción.
Para ejecutar:
 -En AbstractTestUnit está el TestTrade que se puede ejecutar para ver como las unidades van intercambiando objetos.
 -En cada Clase Test de la unidades hay un cambatTest para ejecutar y ver como las unidades atacan y reciben daño
