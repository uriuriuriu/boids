public static final int NUM_POINT = 100;
public static ArrayList<Boid> boids = new ArrayList<Boid>();

void setup() {size(512, 512);
	background(130);
	fill(255, 150);
	ellipse(width/2, height/2, 30, 30);
	for (int i = 0; i < 10; ++i) {
		Boid boid = new Boid();
		boid.SetRandom(width, height);
		boids.add(boid);
	}
	println("boids.get(0).aa: " + boids.get(0).aa);
}

void draw() {
	background(130);

	for (Boid boid : boids) {
		boid.pos.set(boid.pos.x + boid.vPos.x, boid.pos.y + boid.vPos.y);
		if(512 < boid.pos.x){boid.pos.x -=512;}
		if(512 < boid.pos.y){boid.pos.y -=512;}
		boid.draw();
	}
//	Boid boid = boids.get(0);
}
