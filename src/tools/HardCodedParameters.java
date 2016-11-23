/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: tools/HardCodedParameters.java 2015-03-11 buixuan.
 * ******************************************************/
package tools;

public class HardCodedParameters {
  //---HARD-CODED-PARAMETERS---//
  public static String defaultParamFileName = "in.parameters";
  public static int defaultWidth = 800, defaultHeight = 600,
                          heroesStartX = 400, heroesStartY = 450, heroesWidth=60, heroesHeight=50, heroesStep = 10, heroesHealth = 125, bulletHero = 5, bulletSpeedRateHero = 3,
                          alienWidth = 50, alienHeight = 40, alienStep = 14, alienFrontSensor = 150, alienHealth = 20, bulletAlien = 5, bulletSpeedRateAlien = 5,
                          bossAlienWidth = 100, bossAlienHeight = 80, bossAlienStep = 8, bossAlienHealth = 500, bulletBossAlien = 25,
                          locationGameLevelX = 20, locationGameLevelY = 35, 
                          locationScoreJoueurX = 20, locationScoreJoueurY = 90,
                          phantomWidth = 30, phantomHeight = 30, phantomStep = 10,
                          lifeMax = 5,
                        	  varToFix = 5;
  public static final int enginePaceMillis = 100,
                          spriteSlowDownRate = 7;
  public static int nbAliensSpawn = 9;
  public static final double friction = 0.5;
  public static final double resolutionShrinkFactor = 0.95,
                             userBarShrinkFactor = 0.25,
                             menuBarShrinkFactor = 0.5,
                             logBarShrinkFactor = 0.15,
                             logBarCharacterShrinkFactor = 0.1175,
                             logBarCharacterShrinkControlFactor = 0.01275,
                             menuBarCharacterShrinkFactor = 0.175;
  public static final int displayZoneXStep = 5,
                          displayZoneYStep = 5,
                          displayZoneXZoomStep = 5,
                          displayZoneYZoomStep = 5;
  public static final double displayZoneAlphaZoomStep = 0.98;

  //---MISCELLANOUS---//
  public static final Object loadingLock = new Object();
  public static final String greetingsZoneId = String.valueOf(0xED1C7E),
                             simulatorZoneId = String.valueOf(0x51E77E);
  
  public static <T> T instantiate(final String className, final Class<T> type){
    try{
      return type.cast(Class.forName(className).newInstance());
    } catch(final InstantiationException e){
      throw new IllegalStateException(e);
    } catch(final IllegalAccessException e){
      throw new IllegalStateException(e);
    } catch(final ClassNotFoundException e){
      throw new IllegalStateException(e);
    }
  }
}
