/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligofx;

import com.leapmotion.leap.Controller;
import com.leapmotion.leap.Frame;
import com.leapmotion.leap.Gesture;
import com.leapmotion.leap.Listener;

/**
 *
 * @author Mike
 */
public class MainLeapListener extends Listener {
    
    @Override
    public void onConnect(Controller c){
        
        c.enableGesture(Gesture.Type.TYPE_SWIPE);
        c.enableGesture(Gesture.Type.TYPE_SCREEN_TAP);
        c.enableGesture(Gesture.Type.TYPE_KEY_TAP);
        c.enableGesture(Gesture.Type.TYPE_CIRCLE);
        
    }
    @Override
    public void onFrame(Controller c){
        
        Frame frame = controller.frame();
    }
    
}
