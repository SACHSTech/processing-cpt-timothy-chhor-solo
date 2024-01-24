import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

/**
 * An Attack on Titan themed fighting game
 * 
 */

public class Sketch extends PApplet {
	
  public void settings() {
    size(1800, 800);
  }

  public void setup() {
    background(210, 255, 173);
  }

    // Variables
    PFont backTo;
    PImage number1;
    PImage number2;
    PImage eren;
    PImage mikasa;
    PImage levi;
    PImage armin;
    PImage menueren;
    PImage menumikasa;
    PImage menulevi;
    PImage menuarmin;
    PImage battlebackground;
    PImage house1;
    PImage house2;
    PImage house3;
    PImage attackLogo;
    boolean gameStarted = false;
    boolean battleStarted = false;
    boolean gameEnded = false;
    boolean gameClose = false;
    boolean player1Ready = false;
    boolean player2Ready = false;
    boolean player1Confirm = false;
    boolean player2Confirm = false;
    boolean aPressed = false;
    boolean wPressed = false;
    boolean sPressed = false;
    boolean dPressed = false;
    boolean kPressed = false;
    boolean lPressed = false;
    boolean semicolonPressed = false;
    boolean oPressed = false;
    boolean pPressed = false;
    boolean ePressed = false;
    boolean periodPressed = false;
    boolean xPressed = false;
    boolean iPressed = false;
    boolean qPressed = false;
    int redScale = 0;
    int redScaleDirection = 5;
    int player1X = 400;
    int player2X = 1200;
    int player1Y = 750;
    int player2Y = 750;
    int verticalV1 = 0;
    int verticalV2 = 0;
    int player1Facing = 1;
    int player2Facing = -1;
    int drawPointX = 0;
    int drawPointY = 0;
    int player1HP = 200;
    int player2HP = 200;
    float choice1 = 1;
    float choice2 = 1;
    float rads1 = 0;
    float rads2 = 0;
    float lineAngle1;
    float lineAngle2;
    float horizontalV1 = 0;
    float horizontalV2 = 0;
    float totalV1;
    float totalV2;
    int[] swingPointX = {14, 74, 120, 145, 230, 260, 390, 595, 690, 795, 900, 990, 1144, 1210, 1238, 1277, 1362, 1390, 1526};
    int[] swingPointY = {560, 500, 460, 560, 545, 300, 300, 355, 245, 135, 245, 355, 560, 500, 460, 560, 545, 300, 300};


  public void draw() {
    
    // The Title Screen
    backTo = createFont("BACKTO1982.TTF", 128);
    attackLogo = loadImage("Attack-On-Titan-Logo-Transparent-Background.png");
    if (!gameStarted && !gameEnded) {
      textFont(backTo);
      textSize(50);
      background(0, 0, 0);
      image(attackLogo, 250, 100, 1050, 500);
      if (redScale > 255 || redScale < 0) {
        redScaleDirection = -1 * redScaleDirection;
      }
      redScale += 2 * redScaleDirection;
      fill(redScale, 0, 0);
      text("Press Space To Begin", width / 5, height / 8 * 7);
      if (keyPressed && key != 'b' && key != 'B') {
        gameStarted = true;
      }
    }

    // Character Selection Screen
    // Draws Characters and indicators on which choice
    // add later a "press up/w to confirm"
    else if (gameStarted && !battleStarted && gameEnded == false) {
      number1 = loadImage("number1.png");
      number2 = loadImage("number2.png");
      menueren = loadImage("menueren.png");
      menumikasa = loadImage("menumikasa.png");
      menulevi = loadImage("menulevi.png");
      menuarmin = loadImage("menuarmin.png");
      background(0, 0, 0);
      fill(24);
      rect(0, 200,  width, 350);
      image(number1, width / 18 * choice1, height / 8);
      image(number2, width / 18 * choice2 + width / 18, height / 8);
      image(menueren, width / 18, height / 4, 400, 400);
      image(menumikasa, 450, height / 4, 400, 400);
      image(menulevi, 800, height / 4, 400, 400);
      image(menuarmin, 1150, height / 4, 400, 400);
      textSize(50);
      fill(255, 255, 255);
      text("CHOOSE YOUR CHARACTER", 350, 60);
      textSize(20);
      fill(255, 0, 0);
      text("Press w/o to select, and l/s to cancel", 500, 700);
      textSize(30);
      fill(150);
      text("Eren", 235, 500);
      text("Mikasa", 560, 500);
      text("Levi", 950, 500);
      text("Armin", 1290, 500);

      // Both Players Ready?
      if (player1Ready && player2Ready) {
        fill(255, 0, 0);
        rect(0, 350, 1800, 200);
        fill(255, 255, 255);
        text("Press e/p to confirm", 200, 475);
      }
      if (player1Confirm && player2Confirm) {
        battleStarted = true;
      }

    }

    // The Actual Game
    else if (gameStarted && battleStarted) { 
      
      // Background Image
      battlebackground = loadImage("battlebackground.png");
      house1 = loadImage("house1.png");
      house2 = loadImage("house2.png");
      house3 = loadImage("house3.png");
      image(battlebackground, 0, 0, 1580, 800);
      image(house1, 0, 450, 250, 330);
      image(house2, 250, 300, 150, 465);
      image(house3, 450, 100, 685, 665);
      image(house1, 1135, 450, 250, 330);
      image(house2, 1385, 300, 150, 465);

      // Displaying the Characters
      eren = loadImage("EREN.png");
      mikasa = loadImage("MIKASA.png");
      levi = loadImage("LEVI.png");
      armin = loadImage("ARMIN.png");
      
      // Player 1 Character
      if (choice1 == 1) {
        image(eren, player1X, player1Y);
      }
      else if (choice1 > 4 && choice1 < 8) {
        image(mikasa, player1X, player1Y);
      }
      else if (choice1 > 8 && choice1 < 10) {
        image(levi, player1X, player1Y);
      }
      else if (choice1 > 10) {
        image(armin, player1X, player1Y);
      }

      // Player 2 Character
      if (choice2 == 1) {
        image(eren, player2X, player2Y);
      }
      else if (choice2 > 4 && choice2 < 8) {
        image(mikasa, player2X, player2Y);
      }
      else if (choice2 > 8 && choice2 < 10) {
        image(levi, player2X, player2Y);
      }
      else if (choice2 > 10) {
        image(armin, player2X, player2Y);
      }

      // Player 1 Movements
      if (aPressed) {
        player1X--;
      }
      if (wPressed) {
        if (rads1 > -PI/2) {
          rads1 += -0.1;
        }
      }
      if (sPressed) {
        if (rads1 < PI/2) {
          rads1 += + 0.1;
        }
      }
      if (dPressed) {
        player1X++;
      }

      // Player 2 Movements
      if (kPressed) {
        player2X--;
      }
      if (oPressed) {
        if (rads2 > -PI/2) {
          rads2 += -0.1;
        }
      }
      if (lPressed) {
        if (rads2 < PI/2) {
          rads2 += 0.1;
        }
      }
      if (semicolonPressed) {
        player2X++;
      }

      // Gravity
      // The floor is where the characters are at y = 750
      // Also have to make sure player doesn't fall through the ground
      // Every player will have a mass of 63000g based on eren's weight 
      // We'll assume eren has the shape of a 1.7m by 1.7m cube
      // Drag coefficient of 1
      // Eren should have a terminal velocity of 18.393 m/s 
      // If eren is 1.7m tall and is 32 pixels then a meter is around 20 pixels
      // Therefore the entire map is 40 meters tall
      // Terminal velocity is reached at 360 pixels/s

      if (player1Y < 750) {
        player1Y += verticalV1;
        if (verticalV1 < 360) {
          verticalV1 += 1;
        }
      }
      else {
        verticalV1 = 0;
      }
      if (player1Y > 750) {
        verticalV1 = 0;
        player1Y = 750;
      }
      if (player2Y < 750) {
        player2Y += verticalV2;
        if (verticalV2 < 360) {
          verticalV2 += 1;
        }
      }
      else {
        verticalV2 = 0;
      }
      if (player2Y > 750) {
        verticalV2 = 0;
        player2Y = 750;
      }

      // Friction
      if (player1Y > 740 && player1Y < 760 && horizontalV1 < -3) {
        horizontalV1 += 3;
      }
      else if (player1Y > 740 && player1Y < 760 && horizontalV1 < 0 && horizontalV1 > -3) {
        horizontalV1 += 1;
      }
      else if (player1Y > 740 && player1Y < 760 && horizontalV1 > 3) {
        horizontalV1 += -3;
      }
      else if (player1Y > 740 && player1Y < 760 && horizontalV1 > 0 && horizontalV1 < 3) {
        horizontalV1 += -1;
      }
      if (player2Y > 740 && player2Y < 760 && horizontalV2 < -3) {
        horizontalV2 += 3;
      }
      else if (player2Y > 740 && player2Y < 760 && horizontalV2 < 0 && horizontalV2 > -3) {
        horizontalV2 += 1;
      }
      else if (player2Y > 740 && player2Y < 760 && horizontalV2 > 3) {
        horizontalV2 += -3;
      }
      else if (player2Y > 740 && player2Y < 760 && horizontalV2 > 0 && horizontalV2 < 3) {
        horizontalV2 += -1;
      }
      
      // Directional Indicating Arrow
      fill(255, 255, 255);
      ellipse(player1X + 40 * cos(rads1) * player1Facing + 16, player1Y + 40 * sin(rads1) + 16, 10, 10);
      ellipse(player2X + 40 * cos(rads2) * player2Facing + 16, player2Y + 40 * sin(rads2) + 16, 10, 10);

      // Acceleration
      if (ePressed) {
        horizontalV1 += (int)(3 * cos(rads1) * player1Facing);
        verticalV1 += (int)(3 * sin(rads1));
      }
      if (player1X < 0 && player1Facing == -1) {
        player1X = 5;
        horizontalV1 = 0;
      }
      if (player1X < 0 && player1Facing == 1) {
        player1X = 5;
        if (horizontalV1 < 0) {
          horizontalV1 = 0;
        }
      }
      if (player1X > 1500 && player1Facing == 1) {
        player1X = 1500;
        horizontalV1 = 0;
      }
      if (player1X > 1500 && player1Facing == -1) {
        player1X = 1500;
        if (horizontalV1 > 0) {
          horizontalV1 = 0;
        }
      }
      player1X += horizontalV1;
      player1Y += verticalV1;
      if (pPressed) {
        horizontalV2 += (int)(3 * cos(rads2) * player2Facing);
        verticalV2 += (int)(3 * sin(rads2));
      }
      if (player2X < 0 && player2Facing == -1) {
        player2X = 5;
        horizontalV2 = 0;
      }
      if (player2X < 0 && player2Facing == 1) {
        player2X = 5;
        if (horizontalV2 < 0) {
          horizontalV2 = 0;
        }
      }
      if (player2X > 1500 && player2Facing == 1) {
        player2X = 1500;
        horizontalV2 = 0;
      }
      if (player2X > 1500 && player2Facing == -1) {
        player2X = 1500;
        if (horizontalV2 > 0) {
          horizontalV2 = 0;
        }
      }
      player2X += horizontalV2;
      player2Y += verticalV2;

      // The Grappling Hook
      if (xPressed) {
        for (int i = 0; i < swingPointX.length; i++) {
          if (swingPointX[i] <= player1X && swingPointX[i] > player1X - 100 && player1Facing == -1) {
            line(player1X,player1Y, swingPointX[i], swingPointY[i]);
            drawPointX = swingPointX[i];
            drawPointY = swingPointY[i];
            if (drawPointX - player1X != 0) {  
              lineAngle1 = (player1Y - drawPointY) / (drawPointX - player1X);
            }
            totalV1 = verticalV1 + horizontalV1;
            horizontalV1 = -totalV1 * cos(-lineAngle1);
            verticalV1 = (int)(totalV1 * sin(-lineAngle1));
          }
          if (swingPointX[i] > player1X && swingPointX[i] < player1X + 100 && player1Facing == 1) {
            line(player1X,player1Y, swingPointX[i], swingPointY[i]);
            drawPointX = swingPointX[i];
            drawPointY = swingPointY[i];
            totalV1 = verticalV1 + horizontalV1;
            horizontalV1 = totalV1 * cos(lineAngle1);
            verticalV1 = (int)(totalV1 * sin(lineAngle1));
          }
        }
      }
      if (periodPressed) {
        for (int i = 0; i < swingPointX.length; i++) {
          if (swingPointX[i] <= player2X && swingPointX[i] > player2X - 100 && player2Facing == -1) {
            line(player2X,player2Y, swingPointX[i], swingPointY[i]);
            drawPointX = swingPointX[i];
            drawPointY = swingPointY[i];
            if (drawPointX - player2X != 0) {  
              lineAngle2 = (player2Y - drawPointY) / (drawPointX - player2X);
            }
            totalV2 = verticalV2 + horizontalV2;
            horizontalV2 = -totalV2 * cos(-lineAngle2);
            verticalV2 = (int)(totalV2 * sin(-lineAngle2));
          }
          if (swingPointX[i] > player2X && swingPointX[i] < player2X + 100 && player2Facing == 1) {
            line(player2X, player2Y, swingPointX[i], swingPointY[i]);
            drawPointX = swingPointX[i];
            drawPointY = swingPointY[i];
            totalV2 = verticalV2 + horizontalV2;
            horizontalV2 = totalV2 * cos(lineAngle2);
            verticalV2 = (int)(totalV2 * sin(lineAngle2));
          }
        }
      }

      // Player 1 Health Bar
      fill(200);
      rect(80, 20, 300, 100);
      fill(255,255,0);
      rect(100, 100, player1HP, 10);
      fill(0, 0, 0);
      textSize(30);
      text("Player 1", 100, 60);
      textSize(15);
      text("HP: " + player1HP, 100, 90);

      // Player 2 Health Bar
      fill(200);
      rect(1180, 20, 300, 100);
      fill(255,255,0);
      rect(1200, 100, player2HP, 10);
      textSize(30);
      fill(0);
      text("Player 2", 1200, 60);
      textSize(15);
      text("HP: " + player2HP, 1200, 90);

      // Game ended?
      if (player1HP <= 0 || player2HP <= 0) {
        gameEnded = true;
        battleStarted = false;
        fill(200);
        rect(0, 350, 1800, 200);
        textSize(45);
        fill(180, 180, 0);
        if (player1HP > player2HP) {
          text("GAME! PLAYER 1 WINS", 200, 420);
        }
        else {
          text("GAME! PLAYER 2 WINS", 200, 420);
        }
        text("Press b To Restart", 200, 510);
  
        if (gameClose = true) {
          gameClose = false;
          gameStarted = false;
          battleStarted = false;
          player1Confirm = false;
          player2Confirm = false;
          player1Ready = false;
          player2Ready = false;
          player1X = 400;
          player2X = 1200;
          player1Y = 750;
          player2Y = 750;
          verticalV1 = 0;
          verticalV2 = 0;
          player1Facing = 1;
          player2Facing = -1;
          drawPointX = 0;
          drawPointY = 0;
          player1HP = 200;
          player2HP = 200;
          choice1 = 1;
          choice2 = 1;
          rads1 = 0;
          rads2 = 0;
          horizontalV1 = 0;
          horizontalV2 = 0;
        }
      }
    }
  }


  public void keyPressed() {
    
    // The Character Selection Screen
    if (gameStarted && !battleStarted) {

      // There should be 4 values
      // 1 = eren
      // 4.7 = mikasa
      // 8.4 = levi
      // 12.1 = armin

      // Player 1 Character Selection
      if (!player1Ready) { 
        if (key == 'd' || key == 'D') {
          choice1 += 3.7;
          if (choice1 > 14.8) {
            choice1 = 1;
          }
        }
        if (key == 'a' || key == 'A') {
          choice1 += -3.7;
          if (choice1 < 0) {
            choice1 = (float)(12.1);
          }
        }
        if (key == 'w' || key == 'W') {
          player1Ready = true;
        }
      }
      if (key == 's' || key == 'S') {
        player1Ready = false;
      }

      // Player 2 Character Selection
      if (!player2Ready) {
        if (key == ';') {
            choice2 += 3.7;
            if (choice2 > 14.8) {
              choice2 = 1;
            }
        }
        if (key == 'k' || key == 'K') {
          choice2 += -3.7;
          if (choice2 < 0) {
            choice2 = (float)(12.1);
          }
        }
        if (key == 'o' || key == 'O') {
          player2Ready = true;
        }
      }
      if (key == 'l' || key == 'L') {
        player2Ready = false;
      }
    }

    // Confirming Readiness
    if (!player1Confirm || !player2Confirm && player1Ready && player2Ready) {
      if (key == 'e' || key == 'E') {
        player1Confirm = true;
      }
      if (key == 's' || key == 'S') {
        player1Confirm = false;
      }
      if (key == 'p' || key == 'P') {
        player2Confirm = true;
      }
      if (key == 'l' || key == 'L') {
        player2Confirm = false;
      }
    }

    // Character Movements
    if (gameStarted && battleStarted) {
      if (key == 'a' || key == 'A') {
        aPressed = true;
        player1Facing = -1;
      }
      if (key == 's' || key == 'S') {
        sPressed = true;
      }
      if (key == 'w' || key == 'W') {
        wPressed = true;
      }
      if (key == 'd' || key == 'D') {
        dPressed = true;
        player1Facing = 1;
      }
      if (key == 'k' || key == 'K') {
        kPressed = true;
        player2Facing = -1; 
      }
      if (key == 'l' || key == 'L') {
        lPressed = true;
      }
      if (key == 'o' || key == 'O') {
        oPressed = true;
      }
      if (key == ';') {
        semicolonPressed = true;
        player2Facing = 1;
      }
      if (key == 'e' || key == 'E') {
        ePressed = true;
      }
      if (key == 'p' || key == 'P') {
        pPressed = true;
      }
      if (key == '.') {
        periodPressed = true;
      }
      if (key == 'x' || key == 'X') {
        xPressed = true;
      }
    }
  }

  public void keyReleased() {
    if (key == 'a' || key == 'A') {
      aPressed = false;
    }
    if (key == 's' || key == 'S') {
      sPressed = false;
    }
    if (key == 'w' || key == 'W') {
      wPressed = false;
    }
    if (key == 'd' || key == 'D') {
      dPressed = false;
    }
    if (key == 'k' || key == 'K') {
      kPressed = false;
    }
    if (key == 'l' || key == 'L') {
      lPressed = false;
    }
    if (key == 'o' || key == 'O') {
      oPressed = false;
    }
    if (key == ';') {
      semicolonPressed = false;
    }
    if (key == 'p' || key == 'P') {
      pPressed = false;
    }
    if (key == 'e' || key == 'E') {
      ePressed = false;
    }
    if (key == '.') {
      periodPressed = false;
    }
    if (key == 'x' || key == 'X') {
      xPressed = false;
    }
    
  }
  public void keyTyped() {
    if (key == 'q' || key == 'Q') {
      if ((player2X + 16) < (player1X + 16) + 30 && (player2X + 16) > (player1X + 16) - 30 && (player2Y + 16) < (player1Y + 16) + 30 && (player2Y + 16) > (player1Y + 16) - 30) {
        player2HP += -1;
      }
    }
    if (key == 'i' || key == 'I') {
      if ((player1X + 16) < (player2X + 16) + 30 && (player1X + 16) > (player2X + 16) - 30 && (player1Y + 16) < (player2Y + 16) + 30 && (player1Y + 16) > (player2Y + 16) - 30) {
        player1HP += -1; 
      }
    }
    if (gameEnded == true) {
      if (key == 'b' || key == 'B') {
        gameClose = true;
        gameEnded = false;
      }
    }
  }
}