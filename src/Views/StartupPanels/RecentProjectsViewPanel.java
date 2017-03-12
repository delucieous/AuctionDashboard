package Views.StartupPanels;

import Views.CustomComponents.CatPanel;
import Views.CustomComponents.CatTitlePanel;
import Views.ViewPresets.ColorSettings;

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
        this.setBorder(BorderFactory.createLineBorder(ColorSettings.PANEL_BORDER_COLOR.getColor()));

        CatTitlePanel titlePanel = new CatTitlePanel("Recent Projects");

        CatPanel recentProjectBoxesPanel = new CatPanel();
        recentProjectBoxesPanel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        recentProjectBoxesPanel.setLayout(new BoxLayout(recentProjectBoxesPanel, BoxLayout.Y_AXIS));

        RecentProjectInfoPanel infoPanel = new RecentProjectInfoPanel(new File("db/model3.db"));
        recentProjectBoxesPanel.add(infoPanel);
        recentProjectBoxesPanel.add(Box.createVerticalGlue());

        this.add(titlePanel, BorderLayout.NORTH);
        this.add(recentProjectBoxesPanel, BorderLayout.CENTER);
    }
}