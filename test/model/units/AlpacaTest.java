package model.units;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test set for the alpaca unit
 *
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
}