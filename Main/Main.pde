public static final int NUM_POINT = 100;
public static ArrayList<Boid> boids = new ArrayList<Boid>();

void setup() {size(512, 512);
	background(130);
	fill(255, 150);
	ellipse(width/2, height/2, 30, 30);
	for (int i = 0; i < 20; ++i) {
		Boid boid = new Boid();
		boid.SetRandom();
		boids.add(boid);
	}
//	println("boids.get(0).aa: " + boids.get(0).aa);
}

void draw() {
	background(130);

	for (Boid boid : boids) {
		boid.draw();
	}
//	Boid boid = boids.get(0);
}
