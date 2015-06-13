import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Main extends PApplet {

public void setup() {size(512, 512);
	background(130, 255);
	fill(255, 150);
	ellipse(width/2, height/2, 30, 30);
	Boid boid = new Boid();
	println("var: " + boid.bb);
}

public void draw() {

}
class Boid{
	private String aa = "aaaa";
	public String bb = "bbbb";
	Boid(){
		fill(155, 255);
		ellipse(100, 100, 60, 60);
	}
};
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "Main" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
