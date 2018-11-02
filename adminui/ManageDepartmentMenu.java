package adminui;

import javax.swing.JPanel;

public class ManageDepartmentMenu extends JPanel {

    private JPanel mainMenu;

    public ManageDepartmentMenu(JPanel mainMenu) {

        this.mainMenu = mainMenu;
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Departments", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
    }
}
