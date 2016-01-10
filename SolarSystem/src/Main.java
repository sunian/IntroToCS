import javafx.application.Application;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * Created by Sun on 10/3/2015.
 */
public class Main extends Application {
    public SolarSystem mySolarSystem;
    public Thread physicsThread;
    public Runnable physicsRunnable = Main.this::runPhysicsThread;

    /**
     * This is where the program begins execution.
     */
    public static void main(String[] args) {
        launch(args);
    }

    //this method is being run in a different thread
    public void runPhysicsThread() {
        long currentTime = System.currentTimeMillis();
        long nextTime;
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            nextTime = System.currentTimeMillis();
            System.out.println(nextTime - currentTime);
            mySolarSystem.handleTimeLapse(nextTime - currentTime);
            currentTime = nextTime;
        }
    }

    @Override
    public void init() throws Exception {
        super.init();
        mySolarSystem = new SolarSystem();
        Star sun = new Star("SUN", new Point3D(0, 0, 0), 3330000.0);
        sun.setColor(Color.ORANGE);
        mySolarSystem.addCelestialBody(sun); // our SolarSystem now has a Star!
        SolidPlanet earth = new SolidPlanet("Earth", new Point3D(1.0, 0, 0), 1.0);
        earth.setColor(Color.BLUE);
        mySolarSystem.addCelestialBody(earth);
        SolidPlanet mars = new SolidPlanet("Mars", new Point3D(1.38, 0, 0), 0.107);
        mars.setColor(Color.RED);
        mySolarSystem.addCelestialBody(mars);
        physicsThread = new Thread(physicsRunnable);
        physicsThread.setDaemon(true);
        physicsThread.start();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group intro = new Group();
        Canvas canvas = new Canvas(1000, 500);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.BLACK);
        Font font = new Font(20);
        gc.setFont(font);
        gc.setStroke(Color.BLUE);
        gc.fillText("This is a solar system...", 10, 30);
        gc.translate(canvas.getWidth() / 2.0, canvas.getHeight() / 2.0);
        intro.getChildren().add(canvas);
        Scene primaryScene = new Scene(intro);
        primaryStage.setTitle("stage");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        mySolarSystem.draw(gc);
    }
}
