package adminui;

import javax.swing.JPanel;

public class ManageDegreeMenu extends Menu {

    public ManageDegreeMenu(AdminUI adminUI) {

        super(adminUI);
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                        "Manage Degrees", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                        javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Trebuchet MS", 0, 12)));
    }
    protected void placeComponents(){}
}