package com.org.mywebcrawler.message;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

public class Message extends JDialog {

  private final JLabel lbMessage = new JLabel();
  private final JLabel lbIcon = new JLabel();
  
  
  private static volatile Message instance = null;

  private Message() {
  }

  public static Message getInstance() {
    Message message = Message.instance;
    if (message == null) {
      synchronized (Message.class) {
        message = Message.instance;
        if (message == null) {
          Message.instance = message = new Message();
        }
      }
    }
    return message;
  }
  
  public void showMessage(JRootPane jRootPane) {
    ImageIcon img = new ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/Web-Crawler-thum.jpg"));
    ImageIcon imgGif = new ImageIcon(getClass().getResource("/com/org/mywebcrawler/icons/spinner.gif"));
    
    setLayout(null);
    setIconImage(img.getImage());
    
    setTitle("Antenção");
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    //setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
    //setUndecorated(true);
    setModal(true);
    setSize(370, 160);
    setResizable(false);
    
    lbMessage.setText("Por favor aguarde!");
    lbMessage.setBounds(125, 10, 200, 20);
    
    lbIcon.setIcon(imgGif);
    lbIcon.setBounds(165, 40, 40, 40);
    
    add(lbMessage);
    add(lbIcon);
    
    setLocationRelativeTo(null);
    setVisible(true);
  }
  
  public void hideMessage() {
    dispose();
  }

}
