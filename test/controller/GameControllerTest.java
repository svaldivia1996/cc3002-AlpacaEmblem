package controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import model.Tactician;
import model.items.Axe;
import model.items.IEquipableItem;
import model.items.Spear;
import model.items.Sword;
import model.map.Field;
import model.map.Location;
import model.units.Fighter;
import model.units.Hero;
import model.units.IUnit;
import model.units.SwordMaster;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author Sebastian Valdivia Reyes
 * @author Ignacio Slater Muñoz
 * @since v2.0
 */
class GameControllerTest {

  private GameController controller;
  private long randomSeed;
  private List<String> testTacticians;
  private Field field;
  private IUnit fighter,hero, swordMaster;
  private IEquipableItem spear, sword, axe;

  @BeforeEach
  void setUp() {
    // Se define la semilla como un número aleatorio para generar variedad en los tests
    randomSeed = new Random().nextLong();
    controller = new GameController(4, 128);
    testTacticians = List.of("Player 0", "Player 1", "Player 2", "Player 3");
    setField();
    setUnits();
    setWeapon();
  }

  // crea un mapa 3x3 completo
  public void setField() {
      this.field = new Field();
      this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
              new Location(1, 0), new Location(1, 1), new Location(1, 2),
              new Location(2, 0), new Location(2, 1), new Location(2, 2));
    }

    public void setUnits(){
      fighter = new Fighter(50, 2, field.getCell(0, 0));
      hero = new Hero(50, 2, field.getCell(0, 1));
      swordMaster = new SwordMaster(50, 2, field.getCell(1, 0));
    }

    public void setWeapon(){
      spear =new  Spear("Spear", 10,1,2 );
      sword = new Sword("Sword", 10, 1, 1);
      axe = new Axe("Axe",10, 1 ,1);
    }


  @Test
  void getTacticians() {
    List<Tactician> tacticians = controller.getTacticians();
    assertEquals(4, tacticians.size());
    for (int i = 0; i < tacticians.size(); i++) {
      assertEquals("Player " + i, tacticians.get(i).getName());
    }
  }

  @Test
  void getGameMap() {
    Field gameMap = controller.getGameMap();
    assertEquals(128, gameMap.getSize()); // getSize deben definirlo
    assertTrue(controller.getGameMap().isConnected());
    Random testRandom = new Random(randomSeed);
    gameMap.setRandom(testRandom);
    Field anotherMap = new Field();
    anotherMap.setRandom(testRandom);
    anotherMap.newRandomMap(128);
    gameMap.newRandomMap(128);
    assertEquals(gameMap,anotherMap);
    //controller.getGameMap().ge
    // Para testear funcionalidades que dependen de valores aleatorios se hacen 2 cosas:
    //  - Comprobar las invariantes de las estructuras que se crean (en este caso que el mapa tenga
    //    las dimensiones definidas y que sea conexo.
    //  - Setear una semilla para el generador de números aleatorios. Hacer esto hace que la
    //    secuencia de números generada sea siempre la misma, así pueden predecir los
    //    resultados que van a obtener.
    //    Hay 2 formas de hacer esto en Java, le pueden pasar el seed al constructor de Random, o
    //    usar el método setSeed de Random.
    //  ESTO ÚLTIMO NO ESTÁ IMPLEMENTADO EN EL MAPA, ASÍ QUE DEBEN AGREGARLO (!)
  }

  @Test
  void getTurnOwner() {
    assertEquals(4,controller.getTacticians().size());
    Random testRandom = new Random(randomSeed);
    GameController otherController = new GameController(4,128);
    controller.setRandom(testRandom);
    otherController.setRandom(testRandom);
    while(controller.getRoundNumber() == 2){
        controller.endTurn();
        otherController.endTurn();
    }
    assertEquals(controller.getTurnOwner().getName(),otherController.getTurnOwner().getName());
  }

  @Test
  void getRoundNumber() {
    controller.initGame(10);
    for (int i = 1; i < 10; i++) {
      assertEquals(i, controller.getRoundNumber());
      for (int j = 0; j < 4; j++) {
        controller.endTurn();
      }
    }
  }

  @Test
  void getMaxRounds() {
    Random randomTurnSequence = new Random();
    IntStream.range(0, 50).forEach(i -> {
      controller.initGame(randomTurnSequence.nextInt());
      assertEquals(randomTurnSequence.nextInt(), controller.getMaxRounds());
    });
    controller.initEndlessGame();
    assertEquals(-1, controller.getMaxRounds());
  }

  @Test
  void endTurn() {
    Tactician firstPlayer = controller.getTurnOwner();
    // Nuevamente, para determinar el orden de los jugadores se debe usar una semilla
    Tactician secondPlayer = controller.getTacticians().get(1);
    //Tactician secondPlayer = new Tactician(); // <- Deben cambiar esto (!)
    assertNotEquals(secondPlayer.getName(), firstPlayer.getName());

    controller.endTurn();
    assertNotEquals(firstPlayer.getName(), controller.getTurnOwner().getName());
    assertEquals(secondPlayer.getName(), controller.getTurnOwner().getName());
  }

  @Test
  void tacticianTest(){
    String expectedName = "Tactitian";
    Field expectedField = field;
    IUnit expectedUnit = hero;
    Tactician testTactician = new Tactician(expectedName,expectedField, expectedUnit);
    testTactician.setGameController(controller);
    assertEquals(expectedName, testTactician.getName());
    assertEquals(expectedField, testTactician.getMap());
    testTactician.selectUnit(0);
    assertEquals(expectedUnit, testTactician.getSelectedUnit());
    assertEquals(50, testTactician.getMaxHitPointsSelectUnit());
    testTactician.getSelectedUnit().receiveDamage(10);
    assertEquals(40, testTactician.getCurrentHitPointsSelectedUnit());
    testTactician.addItemSelectedUnit(spear);
    assertEquals(1,testTactician.getItemsSelectedUnit().size());
    assertEquals(spear,testTactician.getItemsSelectedUnit().get(0));
    testTactician.moveSelectedUnit(field.getCell(0,2));
    assertEquals(field.getCell(0,2),testTactician.getLocationSelectedUnit());
    testTactician.equipItemSelectedUnit(spear);
    assertEquals(spear, testTactician.getSelectedUnit().getEquippedItem());
    testTactician.removeItemSelectedUnit(spear);
    assertEquals(0, testTactician.getSelectedUnit().getItems().size());
  }

  @Test
  void removeTactician() {
    assertEquals(4, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 0");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians().forEach(tactician -> assertNotEquals("Player 1", tactician));
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));

    controller.removeTactician("Player 5");
    assertEquals(3, controller.getTacticians().size());
    controller.getTacticians()
        .forEach(tactician -> Assertions.assertTrue(testTacticians.contains(tactician.getName())));
  }

  @Test
  void getWinners() {
    controller.initGame(2);
    IntStream.range(0, 8).forEach(i -> controller.endTurn());
    assertEquals(4, controller.getWinners().size());
    controller.getWinners()
        .forEach(player -> Assertions.assertTrue(testTacticians.contains(player)));

    controller.initGame(2);
    IntStream.range(0, 4).forEach(i -> controller.endTurn());
    assertNull(controller.getWinners());
    controller.removeTactician("Player 0");
    controller.removeTactician("Player 2");
    IntStream.range(0, 2).forEach(i -> controller.endTurn());
    List<String> winners = controller.getWinners();
    assertEquals(2, winners.size());
    assertTrue(List.of("Player 1", "Player 2").containsAll(winners));

    controller.initEndlessGame();
    for (int i = 0; i < 3; i++) {
      assertNull(controller.getWinners());
      controller.removeTactician("Player " + i);
    }
    assertTrue(List.of("Player 3").containsAll(controller.getWinners()));
  }

  // Desde aquí en adelante, los tests deben definirlos completamente ustedes
  @Test
  void getSelectedUnit() {
    controller.getTacticians().get(0).addUnit(hero);
    controller.getTacticians().get(0).selectUnit(0);
    assertEquals(hero,controller.getSelectedUnit());
  }

  @Test
  void selectUnitIn() {
    controller.getTacticians().get(0).addUnit(hero);
    controller.getTacticians().get(0).selectUnit(0);
    assertEquals(hero,controller.getSelectedUnit());
    controller.moveSelectedUnit(field.getCell(0,2));
    assertEquals(hero,field.getCell(0,2).getUnit());
    controller.selectUnitIn(0,2);
    assertEquals(hero,controller.getSelectedUnit());
  }

  @Test
  void TestItems() {
    controller.setMap(field);
    controller.getTacticians().get(0).addUnit(hero);
    controller.getTacticians().get(0).selectUnit(0);
    hero.addItem(spear);
    controller.selectItem(0);
    assertEquals(spear, controller.getSelectedItem());
    controller.equipItem(0);
    assertEquals(spear,controller.getSelectedUnit().getEquippedItem());
    controller.moveSelectedUnit(field.getCell(0,2));
    controller.endTurn();
    controller.getTacticians().get(1).addUnit(fighter);
    controller.getTacticians().get(1).selectUnit(0);
    fighter.addItem(axe);
    controller.selectItem(0);
    controller.equipItem(0);
    controller.moveSelectedUnit(field.getCell(0,1));
    controller.useItemOn(0,2);
    assertEquals(50,controller.getSelectedUnit().getCurrentHitPoints());
    controller.selectUnitIn(0,1);
    assertEquals(35,controller.getTacticians().get(0).getSelectedUnit().getCurrentHitPoints());
    controller.giveItemTo(0,2);
    assertTrue(controller.getTacticians().get(1).getSelectedUnit().getItems().size() == 0);
    assertTrue(controller.getTacticians().get(0).getSelectedUnit().getItems().size() == 2);
  }

}