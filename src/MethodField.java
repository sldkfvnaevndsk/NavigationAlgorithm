import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Arrays;


public class MethodField extends JPanel {

    //Pictures
    private Image picButtonSpaceDefault;
    private Image picButtonSpaceObstacles;
    private Image picButtonSpaceObstaclesChosen;
    private Image picObstacles;
    private Image picButtonSpaceGoal;
    private Image picButtonSpaceGoalChosen;
    private Image picGoal;
    private Image picButtonSpaceStart;
    private Image picButtonSpaceStartChosen;
    private Image picStart;
    private Image picButtonSpaceGenerate;
    private Image picButtonSpaceGenerateChosen;
    private Image picButtonSpaceReset;
    private Image picMainSpace;
    private Image picWay;
    private Image picGenerateIsFault;
    //States
    boolean winObstacles;
    boolean winObstaclesMouse;
    boolean obstaclesExist;
    boolean checkObstaclesCollisions;
    boolean winGoal;
    boolean winGoalMouse;
    boolean goalExist;
    boolean checkGoalCollisions;
    boolean winStart;
    boolean winStartMouse;
    boolean startExist;
    boolean checkStartCollisions;
    boolean winGenerate;
    boolean winGenerateMouse;
    boolean generateExist;
    boolean winReset;
    boolean winResetMouse;
    boolean isFault;
    //Variables
    int obstaclesX;
    int obstaclesY;
    int goalX;
    int goalLastX;
    int goalY;
    int goalLastY;
    int startX;
    int startLastX;
    int startY;
    int startLastY;
    //Constants
    final int bias = 300;
    //Utility
    int[][] field = new int[700][700];
    int[][] radiusX = new int[360][163];
    int[][] radiusY = new int[360][163];
    int[][] radiusField = new int[360][163];

    public MethodField() {
        loadImage();
        initMethod();
        addMouseListener(new MouseApplying());
        addMouseMotionListener(new MouseApplying());
        setFocusable(true);
    }

    public void initMethod() {
        winObstacles = false;
        obstaclesExist = false;
        checkObstaclesCollisions = false;
        winGoal = false;
        goalExist = false;
        checkGoalCollisions = false;
        winStart = false;
        startExist = false;
        checkStartCollisions = false;
        winGenerate = false;
        generateExist = false;
        winReset = true;
        isFault = true;

        obstaclesX = -50;
        obstaclesY = -50;
        for (int i = 0; i < 700; i++)
            Arrays.fill(field[i],-1);
        goalX = 50;
        goalLastX = goalX + bias;
        goalY = 50;
        goalLastY = goalY;
        startX = 50;
        startLastX = startX + bias;
        startY = 50;
        startLastY = startY;
    }

    public void createObstacles(int x, int y) {
        for (int i = x - 11; i <= x + 11; i++)
            for (int j = y - 5; j <= y + 5; j++)
                if ((i - bias) >= 0 && (i - bias) < 700 && j >= 0 && j < 700)
                    if (field[i - bias][j] == -1)
                        field[i - bias][j] = -5;
        for (int i = x - 10; i <= x + 10; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 6) >= 0 && (y - 6) < 700)
                if (field[i - bias][y - 6] == -1)
                    field[i - bias][y - 6] = -5;
        for (int i = x - 9; i <= x + 9; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 7) >= 0 && (y - 7) < 700)
                if (field[i - bias][y - 7] == -1)
                    field[i - bias][y - 7] = -5;
        for (int i = x - 8; i <= x + 8; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 8) >= 0 && (y - 8) < 700)
                if (field[i - bias][y - 8] == -1)
                    field[i - bias][y - 8] = -5;
        for (int i = x - 7; i <= x + 7; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 9) >= 0 && (y - 9) < 700)
                if (field[i - bias][y - 9] == -1)
                    field[i - bias][y - 9] = -5;
        for (int i = x - 6; i <= x + 6; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 10) >= 0 && (y - 10) < 700)
                if (field[i - bias][y - 10] == -1)
                    field[i - bias][y - 10] = -5;
        for (int i = x - 5; i <= x + 5; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y - 11) >= 0 && (y - 11) < 700)
                if (field[i - bias][y - 11] == -1)
                    field[i - bias][y - 11] = -5;
        for (int i = x - 10; i <= x + 10; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 6) >= 0 && (y + 6) < 700)
                if (field[i - bias][y + 6] == -1)
                    field[i - bias][y + 6] = -5;
        for (int i = x - 9; i <= x + 9; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 7) >= 0 && (y + 7) < 700)
                if (field[i - bias][y + 7] == -1)
                    field[i - bias][y + 7] = -5;
        for (int i = x - 8; i <= x + 8; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 8) >= 0 && (y + 8) < 700)
                if (field[i - bias][y + 8] == -1)
                    field[i - bias][y + 8] = -5;
        for (int i = x - 7; i <= x + 7; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 9) >= 0 && (y + 9) < 700)
                if (field[i - bias][y + 9] == -1)
                    field[i - bias][y + 9] = -5;
        for (int i = x - 6; i <= x + 6; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 10) >= 0 && (y + 10) < 700)
                if (field[i - bias][y + 10] == -1)
                    field[i - bias][y + 10] = -5;
        for (int i = x - 5; i <= x + 5; i++)
            if ((i - bias) >= 0 && (i - bias) < 700 && (y + 11) >= 0 && (y + 11) < 700)
                if (field[i - bias][y + 11] == -1)
                    field[i - bias][y + 11] = -5;

        for (int i = x - 5; i <= x + 5; i++)
            for (int j = y - 2; j <= y + 2; j++)
                field[i - bias][j] = -10;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y - 3] = -10;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y - 4] = -10;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y - 5] = -10;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y + 3] = -10;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y + 4] = -10;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y + 5] = -10;
    }

    public void createGoal(int x, int y) {
        for (int i = x - 5; i <= x + 5; i++)
            for (int j = y - 2; j <= y + 2; j++)
                field[i - bias][j] = -20;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y - 3] = -20;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y - 4] = -20;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y - 5] = -20;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y + 3] = -20;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y + 4] = -20;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y + 5] = -20;
        field[x - bias][y] = -40;
    }

    public void createStart(int x, int y) {
        for (int i = x - 5; i <= x + 5; i++)
            for (int j = y - 2; j <= y + 2; j++)
                field[i - bias][j] = -30;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y - 3] = -30;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y - 4] = -30;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y - 5] = -30;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y + 3] = -30;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y + 4] = -30;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y + 5] = -30;
        field[x - bias][y] = -50;
    }

    public void deletePoint(int x, int y) {
        for (int i = x - 5; i <= x + 5; i++)
            for (int j = y - 2; j <= y + 2; j++)
                field[i - bias][j] = -1;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y - 3] = -1;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y - 4] = -1;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y - 5] = -1;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y + 3] = -1;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y + 4] = -1;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y + 5] = -1;
    }

    public void createWay(int x, int y) {
        for (int i = x - 5; i <= x + 5; i++)
            for (int j = y - 2; j <= y + 2; j++)
                field[i - bias][j] = -70;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y - 3] = -70;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y - 4] = -70;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y - 5] = -70;
        for (int i = x - 4; i <= x + 4; i++)
            field[i - bias][y + 3] = -70;
        for (int i = x - 3; i <= x + 3; i++)
            field[i - bias][y + 4] = -70;
        for (int i = x - 2; i <= x + 2; i++)
            field[i - bias][y + 5] = -70;
    }

    public void generateRoad(int beginX, int beginY) {
        int roadCounter = 0;
        double thetaRadians = Math.atan2((goalX - beginX), (goalY - beginY));
        for (int i = 0; i < 163; i++)
            for (int j = 0; j < 360; j++) {
                radiusX[j][i] = (int) (beginX + 6 * i * Math.sin((double) (j) / 180 * Math.PI + thetaRadians));
                radiusY[j][i] = (int) (beginY + 6 * i * Math.cos((double) (j) / 180 * Math.PI + thetaRadians));
            }
        for (int i = 0; i < 163; i++)
            for (int j = 0; j < 360; j++) {
                if (radiusX[j][i] >= 305 && radiusX[j][i] < 995 && radiusY[j][i] >= 5 && radiusY[j][i] < 695)
                    radiusField[j][i] = -1;
                else radiusField[j][i] = -60;
            }
        for (int i = 0; i < 163; i++) {
            if (Math.abs(goalX - radiusX[0][i]) < 6 && Math.abs(goalY - radiusY[0][i]) < 6) {
                radiusField[0][i] = roadCounter;
            }
        }
        boolean isBegin = false;
        int radius = 0;
        boolean isCheck;
        while (isBegin == false) {
            isCheck = false;
            for (int i = 0; i < 163; i++)
                for (int j = 0; j < 360; j++) {
                    if (radiusField[j][i] == roadCounter) {
                        if ((i + 1) < 163 && field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                (radiusField[j][i + 1] == -1 || radiusField[j][i + 1] > (roadCounter + 1))) {
                            radiusField[j][i + 1] = roadCounter + 1;
                            isCheck = true;
                        }
                        if ((i - 1) >= 0 && field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                (radiusField[j][i - 1] == -1 || radiusField[j][i - 1] > (roadCounter + 1))) {
                            radiusField[j][i - 1] = roadCounter + 1;
                            isCheck = true;
                            if (i - 1 == 0) {
                                isBegin = true;
                                radius = j;
                            }
                        }
                        if ((j + 1) < 360 && field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                (radiusField[j + 1][i] == -1 || radiusField[j + 1][i] > (roadCounter + 1))) {
                            radiusField[j + 1][i] = roadCounter + 1;
                            isCheck = true;
                        }
                        if (j + 1 == 360)
                            if (field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                    field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                    (radiusField[0][i] == -1 || radiusField[0][i] > (roadCounter + 1))) {
                                radiusField[0][i] = roadCounter + 1;
                                isCheck = true;
                            }
                        if ((j - 1) >= 0 && field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                (radiusField[j - 1][i] == -1 || radiusField[j - 1][i] > (roadCounter + 1))) {
                            radiusField[j - 1][i] = roadCounter + 1;
                            isCheck = true;
                        }
                        if (j - 1 == -1)
                            if (field[radiusX[j][i] - bias][radiusY[j][i]] != -10 &&
                                    field[radiusX[j][i] - bias][radiusY[j][i]] != -5 &&
                                    (radiusField[359][i] == -1 || radiusField[359][i] > (roadCounter + 1))) {
                                radiusField[359][i] = roadCounter + 1;
                                isCheck = true;
                            }
                    }
                }
            roadCounter++;
            if (isCheck == false) {
                isFault = false;
                return;
            }
        }
        createWay(radiusX[radius][1], radiusY[radius][1]);
        repaint();
        roadCounter--;
        for (int i = 1; i < 163; i++) {
            int pointCounter = 0;
            if ((i + 1) < 163 && radiusField[radius][i + 1] == (roadCounter - 1))
                pointCounter++;
            if (radius + 1 == 360) {
                if (radiusField[0][i] == (roadCounter - 1))
                    pointCounter++;
            }
            else if (radiusField[radius + 1][i] == (roadCounter - 1))
                pointCounter++;
            if (radius - 1 == -1) {
                if (radiusField[359][i] == (roadCounter - 1))
                    pointCounter++;
            }
            else if (radiusField[radius - 1][i] == (roadCounter - 1))
                pointCounter++;
            if (pointCounter == 1) {
                createWay(radiusX[radius][i + 1], radiusY[radius][i + 1]);
                repaint();
                roadCounter--;
            }
            if (Math.abs(goalX - radiusX[radius][i]) < 6 && Math.abs(goalY - radiusY[radius][i]) < 6)
                break;
            if (pointCounter > 1) {
                beginX = radiusX[radius][i];
                beginY = radiusY[radius][i];
                generateRoad(beginX, beginY);
                break;
            }
        }
    }

    public void loadImage() {
        ImageIcon iibsdefault = new ImageIcon("picButtonSpaceDefault.png");
        picButtonSpaceDefault = iibsdefault.getImage();
        ImageIcon iibsobstacles = new ImageIcon("picButtonSpaceObstacles.png");
        picButtonSpaceObstacles = iibsobstacles.getImage();
        ImageIcon iibsobstacleschosen = new ImageIcon("picButtonSpaceObstaclesChosen.png");
        picButtonSpaceObstaclesChosen = iibsobstacleschosen.getImage();
        ImageIcon iiobstacles = new ImageIcon("picObstacles.png");
        picObstacles = iiobstacles.getImage();
        ImageIcon iibsgoal = new ImageIcon("picButtonSpaceGoal.png");
        picButtonSpaceGoal = iibsgoal.getImage();
        ImageIcon iibsgoalchosen = new ImageIcon("picButtonSpaceGoalChosen.png");
        picButtonSpaceGoalChosen = iibsgoalchosen.getImage();
        ImageIcon iigoal = new ImageIcon("picGoal.png");
        picGoal = iigoal.getImage();
        ImageIcon iibsstart = new ImageIcon("picButtonSpaceStart.png");
        picButtonSpaceStart = iibsstart.getImage();
        ImageIcon iibsstartchosen = new ImageIcon("picButtonSpaceStartChosen.png");
        picButtonSpaceStartChosen = iibsstartchosen.getImage();
        ImageIcon iistart = new ImageIcon("picStart.png");
        picStart = iistart.getImage();
        ImageIcon iibsgenerate = new ImageIcon("picButtonSpaceGenerate.png");
        picButtonSpaceGenerate = iibsgenerate.getImage();
        ImageIcon iibsgeneratechosen = new ImageIcon("picButtonSpaceGenerateChosen.png");
        picButtonSpaceGenerateChosen = iibsgeneratechosen.getImage();
        ImageIcon iibsreset = new ImageIcon("picButtonSpaceReset.png");
        picButtonSpaceReset = iibsreset.getImage();
        ImageIcon iims = new ImageIcon("picMainSpace.png");
        picMainSpace = iims.getImage();
        ImageIcon iiway = new ImageIcon("picWay.png");
        picWay = iiway.getImage();
        ImageIcon iigif = new ImageIcon("picGenerateIsFault.png");
        picGenerateIsFault = iigif.getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.drawImage(picButtonSpaceDefault, 0, 0, this);
        g.drawImage(picMainSpace, 300, 0, this);
        if (winObstaclesMouse)
            g.drawImage(picButtonSpaceObstacles, 48, 98, this);
        if (winObstacles)
            g.drawImage(picButtonSpaceObstaclesChosen,48,98,this);
        if (obstaclesExist)
            for (int i = 0; i < 700; i++)
                for (int j = 0; j < 700; j++)
                    if (field[i][j] == -10)
                        g.drawImage(picObstacles,i + bias, j,this);
        if (winGoalMouse)
            g.drawImage(picButtonSpaceGoal,48,198,this);
        if (winGoal)
            g.drawImage(picButtonSpaceGoalChosen,48,198,this);
        if (goalExist)
            for (int i = 0; i < 700; i++)
                for (int j = 0; j < 700; j++)
                    if (field[i][j] == -20 || field[i][j] == -40)
                        g.drawImage(picGoal,i + bias,j,this);
        if (winStartMouse)
            g.drawImage(picButtonSpaceStart,48,298,this);
        if (winStart)
            g.drawImage(picButtonSpaceStartChosen,48,298,this);
        if (startExist)
            for (int i = 0; i < 700; i++)
                for (int j = 0; j < 700; j++)
                    if (field[i][j] == -30 || field[i][j] == -50)
                        g.drawImage(picStart,i + bias, j,this);
        if (winGenerateMouse)
            g.drawImage(picButtonSpaceGenerate,48,398,this);
        if (winGenerate) {
            g.drawImage(picButtonSpaceGenerateChosen, 48, 398, this);
            if (isFault == false)
                g.drawImage(picGenerateIsFault,48,398,this);
            for (int i = 0; i < 700; i++)
                for (int j = 0; j < 700; j++)
                    if (field[i][j] == -70)
                        g.drawImage(picWay, i + bias, j, this);
        }
        if (winResetMouse)
            g.drawImage(picButtonSpaceReset,48,498,this);
    }

    public class MouseApplying implements MouseListener, MouseMotionListener {

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 50  && e.getX() <= 249 && e.getY() >= 100 && e.getY() <= 149) {
                winObstacles = true;
                winGoal = false;
                winStart = false;
                winGenerate = false;
                winReset = false;
            }
            if (e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 50  && e.getX() <= 249 && e.getY() >= 200 && e.getY() <= 249) {
                winObstacles = false;
                winGoal = true;
                winStart = false;
                winGenerate = false;
                winReset = false;
            }
            if (e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 50  && e.getX() <= 249 && e.getY() >= 300 && e.getY() <= 349) {
                winObstacles = false;
                winGoal = false;
                winStart = true;
                winGenerate = false;
                winReset = false;
            }
            if (e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 50  && e.getX() <= 249 && e.getY() >= 400 && e.getY() <= 449) {
                winObstacles = false;
                winGoal = false;
                winStart = false;
                winGenerate = true;
                winReset = false;
                generateRoad(startX, startY);
            }
            if (e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 50  && e.getX() <= 249 && e.getY() >= 500 && e.getY() <= 549) {
                initMethod();
            }
            if (winGoal && e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 305 && e.getX() < 995 && e.getY() >= 5 && e.getY() < 695) {
                checkGoalCollisions = true;
                for (int i = e.getX() - 5; i <= e.getX() + 5; i++)
                    for (int j = e.getY() - 2; j <= e.getY() + 2; j++)
                        if (field[i - bias][j] == -10 || field[i - bias][j] == -30 || field[i - bias][j] == -50) {
                            checkGoalCollisions = false;
                            break;
                        }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() - 3] == -10 || field[i - bias][e.getY() - 3] == -30 || field[i - bias][e.getY() - 3] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() - 4] == -10 || field[i - bias][e.getY() - 4] == -30 || field[i - bias][e.getY() - 4] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() - 5] == -10 || field[i - bias][e.getY() - 5] == -30 || field[i - bias][e.getY() - 5] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() + 3] == -10 || field[i - bias][e.getY() + 3] == -30 || field[i - bias][e.getY() + 3] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() + 4] == -10 || field[i - bias][e.getY() + 4] == -30 || field[i - bias][e.getY() + 4] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() + 5] == -10 || field[i - bias][e.getY() + 5] == -30 || field[i - bias][e.getY() + 5] == -50) {
                        checkGoalCollisions = false;
                        break;
                    }
                if (checkGoalCollisions) {
                    deletePoint(goalLastX, goalLastY);
                    goalX = e.getX();
                    goalY = e.getY();
                    goalExist = true;
                    createGoal(goalX, goalY);
                    goalLastX = goalX;
                    goalLastY = goalY;
                }
            }
            if (winStart && e.getButton() == MouseEvent.BUTTON1 && e.getX() >= 305 && e.getX() < 995 && e.getY() >= 5 && e.getY() < 695) {
                checkStartCollisions = true;
                for (int i = e.getX() - 5; i <= e.getX() + 5; i++)
                    for (int j = e.getY() - 2; j <= e.getY() + 2; j++)
                        if (field[i - bias][j] == -10 || field[i - bias][j] == -20 || field[i - bias][j] == -40) {
                            checkStartCollisions = false;
                            break;
                        }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() - 3] == -10 || field[i - bias][e.getY() - 3] == -20 || field[i - bias][e.getY() - 3] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() - 4] == -10 || field[i - bias][e.getY() - 4] == -20 || field[i - bias][e.getY() - 4] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() - 5] == -10 || field[i - bias][e.getY() - 5] == -20 || field[i - bias][e.getY() - 5] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() + 3] == -10 || field[i - bias][e.getY() + 3] == -20 || field[i - bias][e.getY() + 3] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() + 4] == -10 || field[i - bias][e.getY() + 4] == -20 || field[i - bias][e.getY() + 4] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() + 5] == -10 || field[i - bias][e.getY() + 5] == -20 || field[i - bias][e.getY() + 5] == -40) {
                        checkStartCollisions = false;
                        break;
                    }
                if (checkStartCollisions) {
                    deletePoint(startLastX, startLastY);
                    startX = e.getX();
                    startY = e.getY();
                    startExist = true;
                    createStart(startX, startY);
                    startLastX = startX;
                    startLastY = startY;
                }
            }
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            if (winObstacles && e.getX() >= 305 && e.getX() < 995 && e.getY() >= 5 && e.getY() < 695) {
                checkObstaclesCollisions = true;
                for (int i = e.getX() - 5; i <= e.getX() + 5; i++)
                    for (int j = e.getY() - 2; j <= e.getY() + 2; j++)
                        if (field[i - bias][j] == -20 || field[i - bias][j] == -30 ||
                                field[i - bias][j] == -40 || field[i - bias][j] == -50) {
                            checkObstaclesCollisions = false;
                            break;
                        }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() - 3] == -20 || field[i - bias][e.getY() - 3] == -30 ||
                            field[i - bias][e.getY() - 3] == -40 || field[i - bias][e.getY() - 3] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() - 4] == -20 || field[i - bias][e.getY() - 4] == -30 ||
                            field[i - bias][e.getY() - 4] == -40 || field[i - bias][e.getY() - 4] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() - 5] == -20 || field[i - bias][e.getY() - 5] == -30 ||
                            field[i - bias][e.getY() - 5] == -40 || field[i - bias][e.getY() - 5] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 4; i <= e.getX() + 4; i++)
                    if (field[i - bias][e.getY() + 3] == -20 || field[i - bias][e.getY() + 3] == -30 ||
                            field[i - bias][e.getY() + 3] == -40 || field[i - bias][e.getY() + 3] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 3; i <= e.getX() + 3; i++)
                    if (field[i - bias][e.getY() + 4] == -20 || field[i - bias][e.getY() + 4] == -30 ||
                            field[i - bias][e.getY() + 4] == -40 || field[i - bias][e.getY() + 4] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                for (int i = e.getX() - 2; i <= e.getX() + 2; i++)
                    if (field[i - bias][e.getY() + 5] == -20 || field[i - bias][e.getY() + 5] == -30 ||
                            field[i - bias][e.getY() + 5] == -40 || field[i - bias][e.getY() + 5] == -50) {
                        checkObstaclesCollisions = false;
                        break;
                    }
                if (checkObstaclesCollisions) {
                    obstaclesX = e.getX();
                    obstaclesY = e.getY();
                    obstaclesExist = true;
                    createObstacles(obstaclesX, obstaclesY);
                }
            }
            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            winObstaclesMouse = e.getX() >= 50 && e.getX() <= 249 && e.getY() >= 100 && e.getY() <= 149;
            winGoalMouse = e.getX() >= 50 && e.getX() <= 249 && e.getY() >= 200 && e.getY() <= 249;
            winStartMouse = e.getX() >= 50 && e.getX() <= 249 && e.getY() >= 300 && e.getY() <= 349;
            winGenerateMouse = e.getX() >= 50 && e.getX() <= 249 && e.getY() >= 400 && e.getY() <= 449;
            winResetMouse = e.getX() >= 50 && e.getX() <= 249 && e.getY() >= 500 && e.getY() <= 549;
            repaint();
        }
    }
}
