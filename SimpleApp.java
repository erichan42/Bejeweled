import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

/** An example of launching a JavaFX application in a different thread */
public class SimpleApp extends Application {
  
  /** A student asked to add a button to the application in the interactions pane */
  private BorderPane borderPane;
  private static SimpleApp myApp;
  
  /** The start method creates a bare bones app with a border pane */
  public void start(Stage primaryStage) {
    
  }
  
  /** Get the border pane */
  public BorderPane getBorderPane() {
    return borderPane;
  }
  
  /** Let's me access "this" from outside the application */
  public static SimpleApp getMyApp() {
    return myApp;
  }
  
  /** Launches the application in a different thread, but so the 
    * Application.launch itself runs in the Application class */
  public static void launchInBackground(String... args) {
    Thread t = new Thread() {
      public void run() {
        SimpleApp.launchApp(args);
      }
    };
    
    t.start();
  }
 
  /** A static method to launch the application to avoid abusing "main" */
  public static void launchApp(String... args) {
    Application.launch(args);
  }
  
  /** The main method */
  public static void main(String[] args) {
    SimpleApp.launchApp(args);
  }
}