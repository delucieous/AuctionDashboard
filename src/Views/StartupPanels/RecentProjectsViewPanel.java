package Views.StartupPanels;

import Views.CustomComponents.CatLabel;
import Views.CustomComponents.CatPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.List;

/**
 * RecentProjectsViewPanel is a panel which shows the recent projects the user has worked on
 */
public class RecentProjectsViewPanel extends CatPanel {

    private List<File> recentFiles;

    public RecentProjectsViewPanel(List<File> recentFiles) {
        this.recentFiles = recentFiles;
        this.initPanel();
    }

    private void initPanel() {

        this.setLayout(new BorderLayout());

        CatPanel titlePanel = new CatPanel();
        titlePanel.setLayout(new BoxLayout(titlePanel, BoxLayout.X_AXIS));
        CatLabel recentProjectsTitleLabel = new CatLabel("Recent Projects");
        titlePanel.add(Box.createRigidArea(new Dimension(0, 40)));
        titlePanel.add(Box.createHorizontalGlue());
        titlePanel.add(recentProjectsTitleLabel);
        titlePanel.add(Box.createHorizontalGlue());

        CatPanel recentProjectBoxesPanel = new CatPanel();
        recentProjectBoxesPanel.setLayout(new BoxLayout(recentProjectBoxesPanel, BoxLayout.Y_AXIS));

        RecentProjectInfoPanel infoPanel = new RecentProjectInfoPanel(new File("db/model3.db"));
        recentProjectBoxesPanel.add(infoPanel);
        recentProjectBoxesPanel.add(Box.createVerticalGlue());

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(recentProjectBoxesPanel, BorderLayout.CENTER);
    }
}
