package ru.spaceaccordeonist.task11;

import javax.swing.*;
import java.awt.*;

public class Loader implements GameOverListener{
    private static final Dimension WINDOW_SIZE = new Dimension(500, 500);
    private Game game;
    private JFrame frame = new JFrame("Tik Tak Toe");
    private TikTacToePanel gamePanel;
    private Player player1, player2;
    public void run() {
        //Window initialization
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(WINDOW_SIZE);


        player1 = new ManualPlayer("Player1", Game.Figure.CROSS);
        player2 = new TacticalPlayer("Player2", Game.Figure.ROUND);

        game = new Game(player1, player2);
        game.setGameOverListener(this);
        gamePanel = new TikTacToePanel(WINDOW_SIZE, game);

        frame.add(gamePanel.getPanel());
        frame.setVisible(true);
    }

    @Override
    public void gameover(String message) {
        gamePanel.getInformLabel().setText(message);
        gamePanel.updateView();
        switch (JOptionPane.showConfirmDialog(frame, "Try again?", "Game Over", JOptionPane.YES_NO_OPTION)){
            case JOptionPane.YES_OPTION:
                frame.remove(gamePanel.getPanel());
                game.refresh();
                gamePanel = new TikTacToePanel(WINDOW_SIZE, game);
                frame.add(gamePanel.getPanel());
                frame.repaint();
                frame.revalidate();
                break;
            case JOptionPane.NO_OPTION:
                System.exit(0);
                break;
        }
    }

    public void doClick(int x, int y){
        gamePanel.getButton(x, y).doClick();
    }
}
