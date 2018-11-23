package src.ui.registrar;

import javax.swing.JPanel;
public class Registrar extends JPanel {
    private javax.swing.JComboBox<String> dataSelect;
    private javax.swing.JTable finishedRegistration;
    private javax.swing.JTable inRegistration;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane registerScroll;
    private javax.swing.JButton registerStudent;
    private javax.swing.JLabel studentLabel;
    private javax.swing.JScrollPane studentViewScroll;
    private javax.swing.JButton registerButton;
    private RegistrarUI registrarUI;

    public Registrar(RegistrarUI registrarUI) {
        this.registrarUI = registrarUI;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        registerStudent = new javax.swing.JButton();
        registerButton = new javax.swing.JButton();
        registerScroll = new javax.swing.JScrollPane();
        inRegistration = new javax.swing.JTable();
        studentViewScroll = new javax.swing.JScrollPane();
        finishedRegistration = new javax.swing.JTable();
        studentLabel = new javax.swing.JLabel();
        dataSelect = new javax.swing.JComboBox<String>();
        studentLabel.setText("Select a student");
        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(),
                                      "Registrar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
                                        new java.awt.Font("Trebuchet MS", 0, 24)));

        inRegistration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        inRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        registerScroll.setViewportView(inRegistration);

        finishedRegistration.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        finishedRegistration.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        studentViewScroll.setViewportView(finishedRegistration);

        registerStudent.setText("Register Student");
        registerStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageModulesActionPerformed();
            }
        });
        registerButton.setText("Register a new student");
            registerButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    manageStudentActionPerformed();
                }
        });
        placeComponents();
    }

    private void manageStudentActionPerformed() {
        getRegistrarUI().showManageStudents();
    }

    private void manageModulesActionPerformed() {
        getRegistrarUI().showManageModules();
    }

    private RegistrarUI getRegistrarUI() { return registrarUI; }

    private void placeComponents() {
        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(this);
        setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(registerScroll)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(registerStudent)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(registerButton)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(studentViewScroll)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(210, 210, 210)
                        .addComponent(studentLabel)
                        .addGap(18, 18, 18)
                        .addComponent(dataSelect, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(registerScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(registerStudent, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(registerButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataSelect)
                    .addComponent(studentLabel))
                .addGap(18, 18, 18)
                .addComponent(studentViewScroll, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                .addContainerGap())
        );
    }
}
