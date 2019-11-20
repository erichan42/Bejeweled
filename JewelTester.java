import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import org.junit.*;
import static org.junit.Assert.*;

public class JewelTester {
  
  private static final Color[] colorArr = {Color.rgb(218, 64, 61),Color.rgb(238, 189, 77),Color.rgb(71, 146, 137),Color.rgb(95, 87, 120), Color.rgb(38, 70, 83), Color.rgb(224, 168, 144)};
  
  public Button[][] buttonArray(int x, int y) {
    Button[][] button = new Button[x][y];
    
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        button[i][j] = new Button();
      }
    }
    return button;
  }
  
  public Color[][] colorArray(int x, int y, int count) {
    Color[][] color = new Color[x][y];
    
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        color[i][j] = colorArr[(int)Math.floor(Math.random() * count)];
      }
    }
    return color;
  }
  
  public boolean[][] starmap(int x, int y) {
    return new boolean[x][y];
  }
  
  @Test
  public void storeButton1Tester() {
    Jewels jewelObj = new Jewels();
    Color[][] color = colorArray(5, 5, 3);
    
    assertTrue(jewelObj.storeButton1(0,0,color[0][0]));
  }
  
  @Test
  public void adjacentButtonsTester() {
    Button[][] bArr = buttonArray(5,5);
    Color[][] color = colorArray(5, 5, 3);
    Jewels jewelObj = new Jewels();
    Jewels.JewelClick jClick = jewelObj.new JewelClick(2,2);
    
    // Adjacent by rows
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(4,2,color[4][2]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(0,2,color[0][2]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(1,2,color[1][2]);
    assertTrue(jClick.adjacentButtons());  // Next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(3,2,color[3][2]);
    assertTrue(jClick.adjacentButtons());  // Next to
    jewelObj.setNull();
    
    // Adjacent by columns
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(2,4,color[2][4]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(2,0,color[2][0]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(2,3,color[2][3]);
    assertTrue(jClick.adjacentButtons());  // Next to
    jewelObj.setNull();
    
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(2,1,color[2][1]);
    assertTrue(jClick.adjacentButtons());  // Next to
    jewelObj.setNull();
    
    // Diagonal
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(3,3,color[3][3]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
    
    // Not adjacent at all
    jewelObj.storeButton2(2,2,color[2][2]);
    jewelObj.storeButton1(4,4,color[4][4]);
    assertFalse(jClick.adjacentButtons());  // Not next to
    jewelObj.setNull();
  }
  
  @Test
  public void swapColorsTester() {
    // Check testing report
  }
    
  @Test
  public void tileMarkRowTester() {
    // Check testing report
  }
  
  @Test
  public void tileMarkColTester() {
    // Check testing report
  }
  
  @Test
  public void winConditionTester() {
    // Instantiating inner class JewelClick
    Jewels jc = new Jewels();
    Jewels.JewelClick jClick = jc.new JewelClick(0,0);
    
    boolean[][] allFalse = starmap(5,5);  // None meet the condition
    
    boolean[][] allTrue = starmap(5,5);  // Meets the condition
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 5; j++) {
        allTrue[i][j] = true;
      }
    }
    
    boolean[][] someTrue = starmap(5,5);  // Some meet the condition
    someTrue[0][0] = true;
    someTrue[4][4] = true;
    someTrue[0][4] = true;
    someTrue[4][0] = true;
    someTrue[3][1] = true;
    
    assertFalse(jClick.winCondition(allFalse));  // none
    assertTrue(jClick.winCondition(allTrue));  // all
    assertFalse(jClick.winCondition(someTrue));  //some
  }
}