public static final int NUM_POINT = 100;
public static ArrayList<Boid> boids = new ArrayList<Boid>();

void setup() {size(512, 512);
	background(130, 255);
	fill(255, 150);
	ellipse(width/2, height/2, 30, 30);
	Boid boid = new Boid();
	boids.add(boid);
	println("var: " + boids.get(0).aa);
}

void draw() {

}
