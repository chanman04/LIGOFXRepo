/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligofx;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Hand;
import com.leapmotion.leap.KeyTapGesture;
import com.leapmotion.leap.Listener;
import com.leapmotion.leap.Screen;
import com.leapmotion.leap.ScreenTapGesture;
import com.leapmotion.leap.SwipeGesture;
import com.leapmotion.leap.Vector;
import java.awt.Dimension;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;

/**
 *
 * @author Mike
 */
public class MainLeapListener extends Listener {
    
    private ObjectProperty<Point2D> point=new SimpleObjectProperty<>();

    public ObservableValue<Point2D> pointProperty(){ return point; }
    
    @Override
    public void onConnect(Controller c){
        
        c.enableGesture(Gesture.Type.TYPE_SWIPE);
        c.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        c.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        c.enableGesture(Gesture.Type.TYPE_CIRCLE);
        
        //Set minimum standards for key tap gestures
        
        
        
    }
    
        
//    public static void nextSlide(){
//        int temp = (checkPanel("next", current_panel));
//        current_panel = temp;
//        JPanel tempPanel = panels[temp];
//        pnl.setVisible(false);
//        pnl.remove(1);
//        //tempPanel.setPreferredSize(new Dimension(r.width-200, r.height-250));
//        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-100));
//        pnl.add(tempPanel, 1);
//        pnl.setVisible(true);
//    }
//    
//    public static void prevSlide(){
//        int temp = (checkPanel("prev", current_panel));
//        current_panel = temp;
//        JPanel tempPanel = panels[temp];
//        pnl.setVisible(false);
//        pnl.remove(1);      
//        //tempPanel.setPreferredSize(new Dimension(r.width-200, r.height-250));
//        tempPanel.setPreferredSize(new Dimension(screenSize.width-200, screenSize.height-100));
//        pnl.add(tempPanel, 1);
//        pnl.setVisible(true); 
//    }
    
    @Override
    public void onFrame(Controller c){
        com.leapmotion.leap.Frame frame = c.frame();

        
      System.out.println("Frame id: " + frame.id()
                   + ", timestamp: " + frame.timestamp()
                   + ", hands: " + frame.hands().count()
                   + ", fingers: " + frame.fingers().count()
                   + ", gestures " + frame.gestures().count());
        
        if(frame.gestures().count() > 0) {
            System.out.println("Wow, a gesture!");
                        Gesture gesture = frame.gestures().get(0);
            switch(gesture.type()) {
            	case TYPE_SCREEN_TAP:
            		//System.out.println("You've made a screen tap gesture!");
            		break;
            	case TYPE_KEY_TAP:
                    KeyTapGesture keyTap = new KeyTapGesture(gesture);
                    Vector tapVector = keyTap.direction();
                    float keyTapDirection = tapVector.getY();
                    
                    
                    
                    if(keyTapDirection > 0){
                        
                        //perform the method which starts the video
                        
                        
                        
                        //not sure if we need this try/catch for this case but we'll put it in
                         try {
                                        Thread.sleep(1000); //1000 milliseconds is one second.
                                    } catch(InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                         
                         System.out.println("You made a key tap gesture!");
                         break;
                    }
                    
            	case TYPE_CIRCLE:
            		//System.out.println("You've made a circle gesture!");
            		break;
            	case TYPE_SWIPE:
                    
                                SwipeGesture swipeGesture = new SwipeGesture(gesture);
                                Vector swipeVector = swipeGesture.direction();
                                float swipeDirection = swipeVector.getX();
                                
                                
                                if(swipeDirection < 0){
//                                    prevSlide();
                                    try {
                                        Thread.sleep(1000); //1000 milliseconds is one second.
                                    } catch(InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                else if(swipeDirection > 0){
//                                    nextSlide();
                                    try {
                                        Thread.sleep(1000); //1000 milliseconds is one second.
                                    } catch(InterruptedException ex) {
                                        Thread.currentThread().interrupt();
                                    }
                                }
                                
                                
        			System.out.println("You've made a swipe gesture!");
        			break;
            	default:
        			System.out.println("Broken gesture");
        			break;
            }
            System.out.println(gesture.type());
        	ScreenTapGesture screentap = new ScreenTapGesture(frame.gestures().get(0));
        	System.out.println(screentap.position());
        }
    }
    
}
