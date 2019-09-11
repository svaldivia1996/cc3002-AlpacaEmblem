package model.units;

import model.items.IEquipableItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the alpaca unit
 * @author Sebastian Valdivia Reyes
 * @author Ignacio Slater Muñoz
 * @since 1.0
 */
public class AlpacaTest extends AbstractTestUnit {

  private Alpaca alpaca;

  @Override
  public void setTestUnit() {
    alpaca = new Alpaca(50, 2, field.getCell(0, 0));
  }

  @Override
  public Alpaca getTestUnit() {
    return alpaca;
  }

  /**
   * The unit alpaca cannot attack
   */
  @Test
  @Override
  public void normalAttackTest(){
    alpaca.equipItem(spear);
    assertEquals(50,alpaca.getCurrentHitPoints());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
    alpaca.attack(getTargetAlpaca());
    assertEquals(50,getTargetAlpaca().getCurrentHitPoints());
  }

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

  @Override
  public void combatTest() {
    assertEquals(50,alpaca.getCurrentHitPoints());
    assertEquals(50,targetAlpaca.getCurrentHitPoints());
    alpaca.attack(targetAlpaca);
    assertEquals(50,alpaca.getCurrentHitPoints());
    assertEquals(50,targetAlpaca.getCurrentHitPoints());
  }
}