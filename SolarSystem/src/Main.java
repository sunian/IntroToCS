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

    /**
     * This is where the program begins execution.
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        mySolarSystem = new SolarSystem();
        Star sun = new Star("SUN", new Point3D(0, 0, 0), 3330000.0);
        sun.setColor(Color.ORANGERED);
        mySolarSystem.addCelestialBody(sun); // our SolarSystem now has a Star!
        SolidPlanet earth = new SolidPlanet("Earth", new Point3D(1.0, 0, 0), 1.0);
        earth.setColor(Color.BLUE);
        mySolarSystem.addCelestialBody(earth);
        System.out.println(mySolarSystem.myCelestialBodies);

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
//        gc.setFill(Color.ORANGE);
//        gc.fillOval(0, 0, 100, 100);
        intro.getChildren().add(canvas);
        Scene primaryScene = new Scene(intro);
        primaryStage.setTitle("stage");
        primaryStage.setScene(primaryScene);
        primaryStage.show();
        mySolarSystem.getMyCelestialBodies().get(0).draw(gc);
        mySolarSystem.getMyCelestialBodies().get(1).draw(gc);
    }
}
