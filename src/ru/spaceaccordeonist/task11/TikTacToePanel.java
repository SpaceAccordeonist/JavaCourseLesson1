package ru.spaceaccordeonist.task11;

import javax.swing.*;
import java.awt.*;

public class TikTacToePanel {
    private JButton[][] buttons = new JButton[3][3];
    private JPanel panel = new JPanel(new GridBagLayout());
    private JLabel informLabel = new JLabel( " ");
    private GridLayout gridLayout = new GridLayout(3, 3);
    private JPanel fieldPanel = new JPanel(gridLayout);
    private ImageIcon crossImg;
    private ImageIcon roundImg;
    private Game game;

    public TikTacToePanel(Dimension size, Game game) {
        crossImg = new ImageIcon(new ImageIcon("src/ru/spaceaccordeonist/task11/res/cross.png")
                .getImage().getScaledInstance(size.width/5 - 10,size.height/5 - 10, Image.SCALE_SMOOTH));
        roundImg = new ImageIcon(new ImageIcon("src/ru/spaceaccordeonist/task11/res/round.png")
                .getImage().getScaledInstance(size.width/5 - 10,size.height/5 - 10, Image.SCALE_SMOOTH));

        this.game = game;

        for(int x = 0; x < 3; x++){
            buttons[x] = new JButton[3];
            for(int y = 0; y < 3; y++){
                buttons[x][y] = new JButton();
                buttons[x][y].setActionCommand(x+" "+y);
                buttons[x][y].addActionListener(e ->{
                    game.step(
                            Integer.parseInt(e.getActionCommand().substring(0,1)),
                            Integer.parseInt(e.getActionCommand().substring(2)));
                    this.updateView();
                });
                buttons[x][y].setPreferredSize(new Dimension(size.width/5, size.height/5));
                buttons[x][y].setContentAreaFilled(false);
                buttons[x][y].setFocusPainted(false);
                fieldPanel.add(buttons[x][y]);
            }
        }

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.ipady = 50;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        informLabel.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 24));
        panel.add(informLabel, constraints);
        constraints.ipady = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.BOTH;
        fieldPanel.setMinimumSize(size);
        panel.add(fieldPanel, constraints);
    }

    public JButton getButton(int x, int  y){
        return buttons[x][y];
    }

    public JPanel getFieldPanel() {
        return fieldPanel;
    }

    public JLabel getInformLabel() {
        return informLabel;
    }

    public JPanel getPanel(){
        return panel;
    }

    public void drawGraphics(int x, int y, Game.Figure figure){
        if(x < 3 && y < 3){
            switch (figure){
                case CROSS:
                    buttons[x][y].setIcon(crossImg);
                    break;
                case ROUND:
                    buttons[x][y].setIcon(roundImg);
                    break;
                case NONE:
                    buttons[x][y].setIcon(new ImageIcon());
                    break;
            }
        }
    }

    public void updateView(){
        Game.Figure[][] figures = game.getGameField().getGameField();
        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                drawGraphics(x, y, figures[x][y]);
            }
        }
    }
}
