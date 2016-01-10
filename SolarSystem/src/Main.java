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
    int windowWidth = 1000;
    int windowHeight = 500;
    public SolarSystem mySolarSystem;
    public Thread physicsThread;
    public Runnable physicsRunnable = Main.this::runPhysicsThread;
    GraphicsContext solarSystemGraphicsContext;

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
                System.out.println("breaking");
                break;
            }
            solarSystemGraphicsContext.setGlobalAlpha(0.1);
            solarSystemGraphicsContext.setFill(Color.WHITE);
            solarSystemGraphicsContext.fillRect(-windowWidth / 2, -windowHeight / 2, windowWidth, windowHeight);
            solarSystemGraphicsContext.setGlobalAlpha(1.0);
            mySolarSystem.draw(solarSystemGraphicsContext);
            nextTime = System.currentTimeMillis();
            mySolarSystem.handleTimeLapse(nextTime - currentTime);
            currentTime = nextTime;
        }
        System.out.println("broke");
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
        earth.setVelocity(new Point3D(0, 0.969704, 0));
        mySolarSystem.addCelestialBody(earth);
        SolidPlanet mars = new SolidPlanet("Mars", new Point3D(1.38, 0, 0), 0.107);
        mars.setColor(Color.RED);
        mars.setVelocity(new Point3D(0, 0.505932, 0));
        mySolarSystem.addCelestialBody(mars);
        physicsThread = new Thread(physicsRunnable);
        physicsThread.setDaemon(true);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group intro = new Group();
        Canvas canvas = new Canvas(windowWidth, windowHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        solarSystemGraphicsContext = gc;
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
        physicsThread.start();
    }
}
