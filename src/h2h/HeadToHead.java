package h2h;

import database.ConnectionToDatabase;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.SQLException;

import static h2h.Game.*;
import static h2h.DisplayTimer.*;

public class HeadToHead extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;

    static final int WIDTH = 1024, HEIGHT = 768+25;

    private ConnectionToDatabase conToDatabase;

    private Thread thread;
    private Menu menu;
    private Settings settings;
    private About about;
    private Loading loading;
    private Game game;
    private GameResult gameResult;
    private GameEnded gameEnded;
    private Timer myGameTimer;
    private Timer myLoadingTimer;
    private Timer myResultTimer;
    private DisplayTimer displayTimer;
    private boolean isRunning = false;

    public enum STATE {
        MENU,
        GAME,
        SETTINGS,
        ABOUT,
        LOADING,
        GAME_RESULT,
        GAME_ENDED
    }
    public static STATE state = STATE.MENU;

    public enum DIFFICULTY {
        EASY,
        HARD
    }
    static DIFFICULTY difficulty = DIFFICULTY.EASY;

    public enum KEY_CHANGE {
        OFF,
        PLAYER1A,
        PLAYER1B,
        PLAYER1C,
        PLAYER2A,
        PLAYER2B,
        PLAYER2C
    }
    static KEY_CHANGE keyChange = KEY_CHANGE.OFF;

    private BufferedImage startBackground = loadImage("/Background.png");
    private BufferedImage gameBackground = loadImage("/Background2.png");
    private BufferedImage loadingBackground = loadImage("/Background3.png");
    private BufferedImage gameResultBackground = loadImage("/Background4.png");
    private BufferedImage aboutBackground = loadImage("/Background5.png");
    private BufferedImage gameEndBackground = loadImage("/Background6.png");

    public HeadToHead() {
        new Window(this);

        myGameTimer = new Timer(1000, gameTimer);
        myLoadingTimer = new Timer(1300, loadingTimer);
        myResultTimer = new Timer(1000, resultTimer);

        menu = new Menu();
        settings = new Settings();
        about = new About();
        loading = new Loading();
        game = new Game();
        gameResult = new GameResult();
        gameEnded = new GameEnded();
        displayTimer = new DisplayTimer();
        conToDatabase = new ConnectionToDatabase("sql11225254","AvnMfj8fHx");
        try {
            conToDatabase.queryData(41, id, question, answer1, answer2, answer3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        this.addMouseListener(new MouseInput());
        this.addKeyListener(new KeyInput());
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        isRunning = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            isRunning = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        long lastTime = System.nanoTime();
        double targetTick = 60.0;
        double ns = 1000000000 / targetTick;
        double delta = 0;
        double timer = System.currentTimeMillis();
        int fps = 0;
        int ticks = 0;

        while(isRunning) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;

            while(delta >= 1) {
                tick();
                render();
                delta--;
                ticks++;
            }

            fps++;

            if((System.currentTimeMillis() - timer) >= 1000) {
                timer += 1000;
                //System.out.println("FPS: " + fps + ", TICKS: " + ticks);
                fps = 0;
                ticks = 0;
            }
        }
        stop();
    }

    private void tick() {
        if(state == STATE.GAME) {
            game.tick();
            myGameTimer.start();
            if(myResultTimer.isRunning()) {
                myResultTimer.stop();
                resultSecondsRemaining = 5;
            }
        } else if(state == STATE.MENU) {
            if(myGameTimer.isRunning()) {
                menu.tick();
                myGameTimer.stop();
                gameSecondsRemaining = 15;
            }
            if(myLoadingTimer.isRunning()) {
                myLoadingTimer.stop();
                loadingSecondsRemaining = 3;
            }
            if(myResultTimer.isRunning()) {
                myResultTimer.stop();
                resultSecondsRemaining = 5;
            }
        } else if(state == STATE.LOADING) {
            loading.tick();
            myLoadingTimer.start();
        } else if(state == STATE.GAME_RESULT) {
            gameResult.tick();
            myResultTimer.start();
            if(myGameTimer.isRunning()) {
                myGameTimer.stop();
                gameSecondsRemaining = 15;
            }
        }
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        if(state == STATE.GAME) {
            g.drawImage(gameBackground,0,0,null);
            game.render(g);
            displayTimer.gameRender(g);

        } else if(state == STATE.MENU) {
            g.drawImage(startBackground,0,0,null);
            menu.render(g);
        } else if(state == STATE.SETTINGS) {
            g.drawImage(startBackground,0,0,null);
            settings.render(g);
        } else if(state == STATE.ABOUT) {
            g.drawImage(aboutBackground,0,0,null);
            about.render(g);
        } else if(state == STATE.LOADING) {
            g.drawImage(loadingBackground,0,0,null);
            displayTimer.loadRender(g);
        } else if(state == STATE.GAME_RESULT) {
            g.drawImage(gameResultBackground,0,0,null);
            gameResult.render(g);
            displayTimer.resultRender(g);
        } else if(state == STATE.GAME_ENDED) {
            g.drawImage(gameEndBackground,0,0,null);
            gameEnded.render(g);
        }

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new HeadToHead();
    }

    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(getClass().getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ActionListener gameTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gameSecondsRemaining--;
        }
    };

    private ActionListener loadingTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            loadingSecondsRemaining--;
        }
    };

    private ActionListener resultTimer = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            resultSecondsRemaining--;
        }
    };
}