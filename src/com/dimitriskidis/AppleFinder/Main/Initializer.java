package com.dimitriskidis.AppleFinder.Main;

import javax.swing.JFrame;

public class Initializer {

    private static Initializer instance;

    private Initializer() {
        // FACADE

        JFrame window = new JFrame("Apple Finder");

        window.add(new GamePanel());

        window.setResizable(false);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static Initializer getInstance() {
        if ( instance == null ) {
            instance = new Initializer();
        }
        return instance;
    }
}
