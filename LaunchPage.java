import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPage implements ActionListener {
    
    JFrame frame = new JFrame();
    JButton startButton = new JButton("Start");


    LaunchPage() {

        startButton.setBounds(100, 160, 200, 40);
        startButton.setFocusable(false);
        startButton.addActionListener(this);

        frame.add(startButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);


    }


    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
        if (e.getSource() == startButton) {
            Window mainWindow = new Window();
        }
    }


}
