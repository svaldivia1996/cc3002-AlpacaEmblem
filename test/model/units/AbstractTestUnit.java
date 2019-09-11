package model.units;

import model.items.*;
import model.map.Field;
import model.map.Location;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Ignacio Slater Muñoz
 * @author Sebastian Valdivia Reyes
 * @since 1.0
 */
public abstract class AbstractTestUnit implements ITestUnit {

  protected Alpaca targetAlpaca;
  protected Hero targetHero;
  protected Fighter targetFighter;
  protected SwordMaster targetSwordMaster;
  protected Archer targetArcher;
  protected Sorcerer targetSorcerer;
  protected Bow bow;
  protected Field field;
  protected Axe axe;
  protected Sword sword;
  protected Staff staff;
  protected Spear spear;
  protected Anima anima;
  protected Dark dark;
  protected Light light;

  @Override
  public void setTargetAlpaca() {
    targetAlpaca = new Alpaca(50, 2, field.getCell(1, 0));
  }

  @Override
  public void setTargetHero() {
    targetHero = new Hero(50, 2, field.getCell(1, 0));
  }

  @Override
  public void setTargetFighter() {
    targetFighter = new Fighter(50, 2, field.getCell(1, 0));
  }

  @Override
  public void setTargetSwordMaster(){
    targetSwordMaster = new SwordMaster(50, 2, field.getCell(1, 0));
  }

  @Override
  public void setTargetArcher(){
    targetArcher = new Archer(50,2,field.getCell(0, 2));
  }

  @Override
  public void setTargetSorcerer(){
    targetSorcerer = new Sorcerer(50, 2, field.getCell(1, 0));
  }

  /**
   * Sets up the units and weapons to be tested
   */
  @BeforeEach
  public void setUp() {
    setField();
    setTestUnit();
    setTargetAlpaca();
    setWeapons();
    setTargetHero();
    setTargetFighter();
    setTargetSwordMaster();
    setTargetArcher();
    setTargetSorcerer();
  }

  /**
   * Set up the game field
   */
  @Override
  public void setField() {
    this.field = new Field();
    this.field.addCells(true, new Location(0, 0), new Location(0, 1), new Location(0, 2),
        new Location(1, 0), new Location(1, 1), new Location(1, 2), new Location(2, 0),
        new Location(2, 1), new Location(2, 2));
  }

  /**
   * Set up the main unit that's going to be tested in the test set
   */
  @Override
  public abstract void setTestUnit();

  /**
   * Creates a set of testing weapons
   */
  @Override
  public void setWeapons() {
    this.axe = new Axe("Axe", 10, 1, 2);
    this.sword = new Sword("Sword", 10, 1, 2);
    this.spear = new Spear("Spear", 10, 1, 2);
    this.staff = new Staff("Staff", 10, 1, 2);
    this.bow = new Bow("Bow", 10, 2, 3);
    this.anima = new Anima("anima",10,1,3);
    this.dark = new Dark("dark",10,1,3);
    this.light = new Light("light", 10,1,3);
  }

  /**
   * Checks that the constructor works properly.
   */
  @Override
  @Test
  public void constructorTest() {
    assertEquals(50, getTestUnit().getCurrentHitPoints());
    assertEquals(50,getTestUnit().getMaxHitPoints());
    assertEquals(2, getTestUnit().getMovement());
    assertEquals(new Location(0, 0), getTestUnit().getLocation());
    assertTrue(getTestUnit().getItems().isEmpty());
  }

  /**
   * @return the current unit being tested
   */
  @Override
  public abstract IUnit getTestUnit();

  /**
   * Checks if the axe is equipped correctly to the unit
   */
  @Override
  @Test
  public void equipAxeTest() {
    assertNull(getTestUnit().getEquippedItem());
    checkEquippedItem(getAxe());
  }

  /**
   * Tries to equip a weapon to the alpaca and verifies that it was not equipped
   *
   * @param item
   *     to be equipped
   */
  @Override
  public void checkEquippedItem(IEquipableItem item) {
    assertNull(getTestUnit().getEquippedItem());
    getTestUnit().equipItem(item);
    assertNull(getTestUnit().getEquippedItem());
  }

  /**
   * @return the test axe
   */
  @Override
  public Axe getAxe() {
    return axe;
  }

  @Override
  @Test
  public void equipSwordTest() {
    checkEquippedItem(getSword());
  }

  /**
   * @return the test sword
   */
  @Override
  public Sword getSword() {
    return sword;
  }

  @Override
  @Test
  public void equipSpearTest() {
    checkEquippedItem(getSpear());
  }

  /**
   * @return the test spear
   */
  @Override
  public Spear getSpear() {
    return spear;
  }

  @Override
  @Test
  public void equipStaffTest() {
    checkEquippedItem(getStaff());
  }

  /**
   * @return the test staff
   */
  @Override
  public Staff getStaff() {
    return staff;
  }

  @Override
  @Test
  public void equipBowTest() {
    checkEquippedItem(getBow());
  }

  /**
   * @return the test bow
   */
  @Override
  public Bow getBow() {
    return bow;
  }

  @Override
  @Test
  public  void equipAnimaTest(){
    checkEquippedItem(getAnima());
  }

  /**
   * @return the test anima
   */
  @Override
  public Anima getAnima(){
    return anima;
  }

  @Override
  @Test
  public void equipDarkTest(){
    checkEquippedItem(getDark());
  }

  /**
   * @return the test dark
   */
  @Override
  public Dark getDark(){
    return dark;
  }

  @Override
  @Test
  public void equipLightTest(){
    checkEquippedItem(getLight());
  }

  @Override
  public Light getLight(){
    return light;
  }



  /**
   * Checks if the unit moves correctly
   */
  @Override
  @Test
  public void testMovement() {
    getTestUnit().moveTo(getField().getCell(2, 2));
    assertEquals(new Location(0, 0), getTestUnit().getLocation());

    getTestUnit().moveTo(getField().getCell(0, 2));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());

    getField().getCell(0, 1).setUnit(getTargetAlpaca());
    getTestUnit().moveTo(getField().getCell(0, 1));
    assertEquals(new Location(0, 2), getTestUnit().getLocation());
  }


  /**
   * Checks if the unit trades correctly
   */
  @Override
  @Test
  public void TestTrade(){
    getTestUnit().addItem(axe);
    getTestUnit().addItem(sword);
    getTestUnit().addItem(spear);
    getTargetAlpaca().addItem(anima);
    getTargetAlpaca().addItem(dark);
    getTargetAlpaca().addItem(light);
    List<IEquipableItem> expectedInitialUnit = new ArrayList<>();
    List<IEquipableItem> expectedInitialAlpaca = new ArrayList<>();
    expectedInitialUnit.add(axe);
    expectedInitialUnit.add(sword);
    expectedInitialUnit.add(spear);
    expectedInitialAlpaca.add(anima);
    expectedInitialAlpaca.add(dark);
    expectedInitialAlpaca.add(light);
    assertEquals(expectedInitialUnit,getTestUnit().getItems());
    assertEquals(expectedInitialAlpaca,getTargetAlpaca().getItems());
    expectedInitialUnit.remove(axe);
    expectedInitialUnit.add(anima);
    expectedInitialAlpaca.remove(anima);
    expectedInitialAlpaca.add(axe);
    getTestUnit().tradeItem(axe,getTargetAlpaca(),anima);// trade axe->anima
    assertEquals(expectedInitialUnit,getTestUnit().getItems());
    assertEquals(expectedInitialAlpaca,getTargetAlpaca().getItems());
    expectedInitialUnit.remove(anima);
    expectedInitialAlpaca.remove(axe);
    getTestUnit().removeItem(anima);//remove anima testUnit has (sword, spear)
    getTargetAlpaca().removeItem(axe);//remove axe targetAlpaca has(dark, light)
    assertEquals(expectedInitialUnit,getTestUnit().getItems());
    assertEquals(expectedInitialAlpaca,getTargetAlpaca().getItems());
    expectedInitialUnit.add(dark);//expected Unit has (sword, spear, dark)
    expectedInitialAlpaca.remove(dark);//expected Alpaca has (light)
    getTestUnit().tradeItem(null,getTargetAlpaca(),dark);//alpaca gives dark
    assertEquals(expectedInitialUnit,getTestUnit().getItems());
    assertEquals(expectedInitialAlpaca,getTargetAlpaca().getItems());



  }

  /**
   * @return the test field
   */
  @Override
  public Field getField() {
    return field;
  }

  /**
   * @return the target Alpaca
   */
  @Override
  public Alpaca getTargetAlpaca() {
    return targetAlpaca;
  }

  /**
   * @return the target Hero
   */
  @Override
  public Hero getTargetHero() {
    return targetHero;
  }

  /**
   * @return the target Fighter
   */
  @Override
  public Fighter getTargetFighter(){
    return targetFighter;
  }

  /**
   * @return the target SwordMaster
   */
  @Override
  public SwordMaster getTargetSwordMaster(){
    return targetSwordMaster;
  }

  /**
   * @return the target Archer
   */
  @Override
  public Archer getTargetArcher(){
    return targetArcher;
  }

  /**
   * @return the target Sorcerer
   */
  @Override
  public Sorcerer getTargetSorcerer(){
    return targetSorcerer;
  }



}
