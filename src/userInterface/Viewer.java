/* ******************************************************
 * Project alpha - Composants logiciels 2015.
 * Copyright (C) 2015 <Binh-Minh.Bui-Xuan@ens-lyon.org>.
 * GPL version>=3 <http://www.gnu.org/licenses/>.
 * $Id: userInterface/Viewer.java 2015-03-11 buixuan.
 * ******************************************************/
package userInterface;

import tools.HardCodedParameters;

import specifications.ViewerService;
import specifications.ReadService;
import specifications.RequireReadService;
import specifications.ShotService;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import metier.Alien;
import metier.Map;
import javafx.scene.text.Font;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.ProgressBar; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorithm.ShotBonus;

public class Viewer implements ViewerService, RequireReadService{
	private static final int spriteSlowDownRate=HardCodedParameters.spriteSlowDownRate,
							varMainToFix=HardCodedParameters.varToFix;
	private static final double locationMainScoreJoueurX=HardCodedParameters.locationScoreJoueurX,
			locationMainScoreJoueurY=HardCodedParameters.locationScoreJoueurY,
			locationMainGameLevelX=HardCodedParameters.locationGameLevelX, 
			locationMainGameLevelY=HardCodedParameters.locationGameLevelY,
			defaultMainWidth=HardCodedParameters.defaultWidth,
			defaultMainHeight=HardCodedParameters.defaultHeight,
			defaultLifeMax=HardCodedParameters.lifeMax;
	private ReadService data;
	private ImageView heroesAvatar, starAvatar1, starAvatar2, starAvatar3, starAvatar4, starAvatar5;
	private double xShrink,yShrink,shrink,xModifier,yModifier,heroesScale;
	private Image starSprite;
	private ArrayList<ImageView> starAvatarGroup; 
	private ProgressBar lifeBar; 
	
	
	public Viewer(){}

	@Override
	public void bindReadService(ReadService service){
		data=service;
	}

	@Override
	public void init(){
		xShrink=1;
		yShrink=1;
		xModifier=0;
		yModifier=0;

		//Yucky hard-conding
		heroesAvatar = new ImageView(data.getHero().getImage());
		
		//alex 
        starSprite = new Image("file:src/images/life-icon.png"); 
     
	    starAvatar1 = new ImageView(starSprite); 
	    starAvatar2 = new ImageView(starSprite); 
	    starAvatar3 = new ImageView(starSprite); 
	    starAvatar4 = new ImageView(starSprite); 
	    starAvatar5 = new ImageView(starSprite); 
	    
        /*final ImageView[] StarAvatars = new ImageView[] {starAvatar1,starAvatar2,starAvatar3,starAvatar4,starAvatar5};
        
        final List<ImageView> listStarAvatars= new ArrayList<ImageView>();
        
        for (ImageView StarAvatar : StarAvatars) {
        		listStarAvatars.add(StarAvatar);
        }
        
        for (int i = 0; i < listStarAvatars.size(); i++) {
            System.out.println(listStarAvatars.get(i));
       }
        */
        
	    //position the remaining stars 
	    starAvatar1.setTranslateX(10); 
	    starAvatar1.setTranslateY(400); 
	     
	    starAvatar2.setTranslateX(40); 
	    starAvatar2.setTranslateY(400); 
	     
	    starAvatar3.setTranslateX(70); 
	    starAvatar3.setTranslateY(400); 
	     
	    starAvatar4.setTranslateX(100); 
	    starAvatar4.setTranslateY(400); 
	     
	    starAvatar5.setTranslateX(130); 
	    starAvatar5.setTranslateY(400);
	    //alex 
	}

	@Override
	public Parent getPanel(){
		shrink=Math.min(xShrink,yShrink);
		xModifier=.01*shrink*defaultMainHeight;
		yModifier=.01*shrink*defaultMainHeight;

		//Yucky hard-conding
		Rectangle map = new Map(xModifier, yModifier, -2*xModifier+shrink*defaultMainWidth, -.2*shrink*defaultMainHeight+shrink*defaultMainHeight).draw();

		data.getMap().setAxeX(xModifier);
		data.getMap().setAxeY(yModifier);
		data.getMap().setWidth(map.getWidth());
		data.getMap().setHeight(map.getHeight());
		historiqueShoot();

		Text score = new Text(locationMainScoreJoueurX,locationMainScoreJoueurY,"Score : " + data.getScore()); 
	    score.setFont(new Font(.05*shrink*defaultMainHeight)); 
	    
	    Text levelNumber = new Text(locationMainGameLevelX,locationMainGameLevelY,"Level : " + data.getLevelNumber()); 
	    levelNumber.setFont(new Font(.05*shrink*defaultMainHeight));

		//int index=heroesAvatarViewportIndex/spriteSlowDownRate;
		heroesScale=data.getHero().getSizeY()*shrink/data.getHero().getImage().getHeight();
		heroesAvatar.setFitHeight(data.getHero().getSizeY()*shrink);
		heroesAvatar.setPreserveRatio(true);
		heroesAvatar.setTranslateX(shrink*data.getHero().getPosition().x+
				shrink*xModifier+
				-heroesScale*.5*data.getHero().getImage().getWidth());

		heroesAvatar.setTranslateY(shrink*data.getHero().getPosition().y+
				shrink*yModifier+
				-heroesScale*.5*data.getHero().getImage().getHeight()
				);
		
		//Barre de progression 
        lifeBar = new ProgressBar(data.getHero().getLife()/defaultLifeMax); 
        lifeBar.setTranslateX(shrink*data.getHero().getPosition().x+ 
            shrink*xModifier+ 
            -heroesScale*.5*data.getHero().getImage().getWidth()); 
        lifeBar.setTranslateY(shrink*data.getHero().getPosition().y+ 
            shrink*yModifier+ 
            -heroesScale*.5*data.getHero().getImage().getHeight() - 50); 
        //System.out.println("vie max " + defaultLifeMax); 
        
        System.out.println("data.getHero().getLife() = " + data.getHero().getLife());
        System.out.println("vie current " + data.getHero().getLife()/defaultLifeMax); 


		//heroesAvatarViewportIndex=(heroesAvatarViewportIndex+1)%(heroesAvatarViewports.size()*spriteSlowDownRate);
		Group panel = new Group();
		panel.getChildren().addAll(map,levelNumber,score,heroesAvatar);

		ArrayList<Alien> aliens = data.getAliens();
		Alien alien;

		for (int i=0; i<aliens.size();i++){
			alien=aliens.get(i);
			ImageView imageAlien = new ImageView(alien.getImage());
			
			imageAlien.setFitHeight(alien.getSizeY()*shrink);
			imageAlien.setPreserveRatio(true);
			imageAlien.setTranslateX(shrink*alien.getPosition().x+
					shrink*xModifier+
					-heroesScale*.5*alien.getImage().getWidth());

			imageAlien.setTranslateY(shrink*alien.getPosition().y+
					shrink*yModifier+
					-heroesScale*.5*alien.getImage().getHeight()
					);			

			for (int j =0; j<alien.getListShot().size();j++){
				double radius=2*Math.min(shrink*4,shrink*4);
				Circle shoot = new Circle(radius,  Color.BLUE);
				shoot.setEffect(new Lighting());
				shoot.setTranslateX(shrink*(alien.getListShot().get(j).x+radius));
				shoot.setTranslateY(shrink*alien.getListShot().get(j).y);
				panel.getChildren().add(shoot);
			}
			
			historiqueAlienShoot(alien);
			
			panel.getChildren().add(imageAlien);
		}

		for (int i =0; i<data.getHero().getListShot().size();i++){
			double radius=2*Math.min(shrink*4,shrink*4);
			Circle shoot = new Circle(radius,  Color.YELLOW);
			shoot.setEffect(new Lighting());
			shoot.setTranslateX(shrink*(data.getHero().getListShot().get(i).x+radius));
			shoot.setTranslateY(shrink*data.getHero().getListShot().get(i).y);
			panel.getChildren().add(shoot);
		}
		
		if (data.getBonusService() != null) {
			double radius=2*Math.min(shrink*4,shrink*4);
			Circle bonusIcon = new Circle(radius);
			bonusIcon.setFill(Color.GREEN);
			if (data.getBonusService() instanceof ShotBonus) {
				bonusIcon.setFill(Color.RED);
			}
			bonusIcon.setTranslateX(shrink*(data.getBonusService().getPosition().x+radius));
			bonusIcon.setTranslateY(shrink*data.getBonusService().getPosition().y);
			bonusIcon.setEffect(new Lighting());
			panel.getChildren().add(bonusIcon);
		}
		
		
		List <ImageView> listAvatar= new ArrayList<ImageView>(); 
	    
		
		listAvatar.add(starAvatar1); 
	    listAvatar.add(starAvatar2); 
	    listAvatar.add(starAvatar3); 
	    listAvatar.add(starAvatar4); 
	    listAvatar.add(starAvatar5);	   
	    
		if(data.getHero().getLife() <= -5){ 
	    		listAvatar.remove(starAvatar5); 
		} 
	    System.out.println(listAvatar.size());
		
		if(data.getHero().getLife() <= -7){ 
    			listAvatar.remove(starAvatar4); 
		} 
		System.out.println(listAvatar.size());
		
		if(data.getHero().getLife() <= -10){ 
			listAvatar.remove(starAvatar3); 
		}	 
		System.out.println(listAvatar.size());
		
		
		if(data.getHero().getLife() <= -12){ 
			listAvatar.remove(starAvatar2); 
		}	
		System.out.println(listAvatar.size());
		
		if(data.getHero().getLife() <= -14){ 
			listAvatar.remove(starAvatar1); 
		}	 
		System.out.println(listAvatar.size());
		
		
		//TODO ça plante
		/*
		while (listAvatar.size() > 0){
			
			
			if(data.getHero().getLife() <= -5){ 
	    			listAvatar.remove(starAvatar5); 
			} 
			System.out.println("size : " + listAvatar.size());
			
			
			if(data.getHero().getLife() <= -8){ 
    				listAvatar.remove(starAvatar4); 
			} 
		
			if(data.getHero().getLife() <= -12){ 
				listAvatar.remove(starAvatar3); 
			} 
			
			if(data.getHero().getLife() <= -18){ 
				listAvatar.remove(starAvatar2); 
			}
			
			if(data.getHero().getLife() <= -22){ 
				listAvatar.remove(starAvatar1);
				JOptionPane.showMessageDialog(null,"You are dead ! You can quit the game.");
			}
			
			
		} */
		
	    panel.getChildren().addAll(listAvatar);
	    
	    
	    panel.getChildren().addAll(lifeBar); 
		

		return panel;
	}

	@Override
	public void setMainWindowWidth(double width){
		xShrink=width/defaultMainWidth;
	}

	@Override
	public void setMainWindowHeight(double height){
		yShrink=height/defaultMainHeight;
	}

	private void historiqueShoot(){		
		for (int i =0; i<data.getHero().getListShot().size();i++){
			if (data.getHero().getListShot().get(i).y<0){
				data.getHero().getListShot().remove(i);
			}
			else
				data.getHero().getListShot().get(i).y= data.getHero().getListShot().get(i).y-data.getHero().getShotSpeedRate();
		}
	}
	private void historiqueAlienShoot(Alien alien) {
		for (int i =0; i<alien.getListShot().size();i++){
			if (alien.getListShot().get(i).y<0){
				alien.getListShot().remove(i);
			} else {
				alien.getListShot().get(i).x += alien.getFireX()*0.01;
				alien.getListShot().get(i).y += alien.getFireY()*0.01;				
			}
		}
	}
	
}
