package view;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;

/**
 * Created by Tobiasz Rumian on 20.03.2017.
 */
public class FileChooser extends JFrame {
    private String path;

    public FileChooser() {
        JFileChooser chooser = new JFileChooser();
        chooser.setFileFilter(new FileNameExtensionFilter("Pliki tekstowe", "txt"));
        chooser.setCurrentDirectory(new File("."));
        int result = chooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            this.path = chooser.getSelectedFile().getPath();
            this.toFront();
            this.repaint();
            pack();
        }
    }

    public String getPath() {
        return path;
    }
}
