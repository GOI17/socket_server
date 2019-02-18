package Windows;

import Models.Reading;
import Models.Sensor;
import Models.Station;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MainWindow extends javax.swing.JFrame {
    
    DefaultTableModel readingsTable;
    DefaultTableModel sensorsTable;
    DefaultTableModel stationsTable;
    DefaultTableModel socketTable;
    JOptionPane frame = new JOptionPane();
   
    
    public MainWindow() {
        initComponents();
        readingsTable = new DefaultTableModel();
        sensorsTable = new DefaultTableModel();
        stationsTable = new DefaultTableModel();
        socketTable = new DefaultTableModel();
        fillComboBox_station_stationId();
        fillComboBox_sensor_stationId();
        socketTable();
        fillReadingsTable();
        fillSensorsTable();
        fillStationsTable();
    }
    
    public void styleTable(JTable table, DefaultTableModel dfTable) {
        table.setModel(dfTable);
        table.setEnabled(false);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        int columns = table.getColumnModel().getColumnCount();
        for(int x = 0; x < columns; x++) {
            table.getColumnModel().getColumn(x).setCellRenderer(centerRenderer);
        }
    }
    
    public void fillComboBox_station_stationId() {
        jComboBox_station_stationId.removeAllItems();
        jComboBox_station_stationId.setBackground(Color.WHITE);
        jComboBox_station_stationId.addItem("Select id");
        ArrayList<Station> list = Station.getAll();
        for(Station s: list) {
            String item = String.valueOf(s.getId() + " - " + s.getDescription());
            jComboBox_station_stationId.addItem(item);
        }
    }
    
    public void fillComboBox_sensor_stationId() {
        jComboBox_sensor_stationId.removeAllItems();
        jComboBox_sensor_stationId.setBackground(Color.WHITE);
        jComboBox_sensor_stationId.addItem("Select id");
        ArrayList<Station> list = Station.getAll();
        for(Station s: list) {
            String item = String.valueOf(s.getId() + " - " + s.getDescription());
            jComboBox_sensor_stationId.addItem(item);
        }
    }
    
    public void fillReadingsTable(){
        ArrayList<Reading> readingsList = Reading.getAll();
        readingsTable.addColumn("Id");
        readingsTable.addColumn("Date");
        readingsTable.addColumn("Temperature");
        readingsTable.addColumn("Humidity");
        readingsTable.addColumn("Wind Quality");
        readingsTable.addColumn("Station");
        for(Reading r : readingsList){
            String data[] = new String[6];
            data[0] = String.valueOf(r.getId());
            data[1] = String.valueOf(r.getDate());
            data[2] = String.valueOf(r.getTemperature());
            data[3] = String.valueOf(r.getHumidity());
            data[4] = String.valueOf(r.getWindQuality());
            data[5] = String.valueOf(r.getStation().getId() + " - " + r.getStation().getDescription());
            readingsTable.addRow(data);
        }
        styleTable(jTable_readings,readingsTable);
    }
    
    public void fillStationsTable(){
        stationsTable = new DefaultTableModel();
        ArrayList<Station> stationsList = Station.getAll();
        stationsTable.addColumn("Id");
        stationsTable.addColumn("Description");
        stationsTable.addColumn("Ip Address");
        for(Station s : stationsList){
            String data[] = new String[4];
            data[0] = String.valueOf(s.getId());
            data[1] = String.valueOf(s.getDescription());
            data[2] = String.valueOf(s.getIpAddress());
            stationsTable.addRow(data);
        }
        styleTable(jTable_stations,stationsTable);
    }
    
    public void fillSensorsTable(){
        sensorsTable = new DefaultTableModel();
        ArrayList<Sensor> sensorsList = Sensor.getSensors();
        sensorsTable.addColumn("Id");
        sensorsTable.addColumn("Description");
        sensorsTable.addColumn("Station");
        for(Sensor s : sensorsList){
            String data[] = new String[4];
            data[0] = String.valueOf(s.getId());
            data[1] = String.valueOf(s.getDescription());
            data[2] = String.valueOf(s.getIdStation());
            sensorsTable.addRow(data);
        }
        styleTable(jTable_sensors,sensorsTable);
    }
    
    public void fillSearchReadingsTable(ArrayList<Reading> readings){
        readingsTable = new DefaultTableModel();
        readingsTable.addColumn("Id");
        readingsTable.addColumn("Date");
        readingsTable.addColumn("Temperature");
        readingsTable.addColumn("Humidity");
        readingsTable.addColumn("Wind Quality");
        for(Reading r : readings){
            String data[] = new String[5];
            data[0] = String.valueOf(r.getId());
            data[1] = String.valueOf(r.getDate());
            data[2] = String.valueOf(r.getTemperature());
            data[3] = String.valueOf(r.getHumidity());
            data[4] = String.valueOf(r.getWindQuality());
            readingsTable.addRow(data);
        }
        styleTable(jTable_readings,readingsTable);
    }
    
    public void socketTable() {
        socketTable.addColumn("Id");
        socketTable.addColumn("Station");
        socketTable.addColumn("Temperature");
        socketTable.addColumn("Humidity");
        socketTable.addColumn("Wind Quality");
        socketTable.addColumn("Powder");
        socketTable.addColumn("Ip Address");
        socketTable.addColumn("Date");
    }
    
    public void realTimeValues(String[] values){
//        socketTable.addRow(values);
        socketTable.insertRow(0, values);
        jTable_socket.setModel(socketTable);
        styleTable(jTable_socket,socketTable);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_readings = new javax.swing.JTable();
        jButton_showAll = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton_search = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_station_stationId = new javax.swing.JComboBox<>();
        jDateChooser_start = new com.toedter.calendar.JDateChooser();
        jDateChooser_end = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_stations = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_dscStation = new javax.swing.JTextField();
        jTextField_iaStation = new javax.swing.JTextField();
        jButton_addStation = new javax.swing.JButton();
        jButton_cancelStation = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_dscSensor = new javax.swing.JTextField();
        jButton_cancelSensor = new javax.swing.JButton();
        jButton_addSensor = new javax.swing.JButton();
        jComboBox_sensor_stationId = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_sensors = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_socket = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Main");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setLocation(new java.awt.Point(600, 150));
        setResizable(false);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Sensors readings");

        jTable_readings.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Date", "Value", "Station"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_readings.setEditingColumn(0);
        jTable_readings.setEditingRow(0);
        jTable_readings.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_readings.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable_readings);
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer ();
        dtcr.setHorizontalAlignment (SwingConstants.RIGHT);
        jTable_readings.getColumn("Id").setCellRenderer(dtcr);
        jTable_readings.getColumn("Date").setCellRenderer(dtcr);
        jTable_readings.getColumn("Value").setCellRenderer(dtcr);
        jTable_readings.getColumn("Station").setCellRenderer(dtcr);

        jButton_showAll.setText("Show all");
        jButton_showAll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_showAllActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Sensor id :");

        jButton_search.setBackground(new java.awt.Color(51, 237, 44));
        jButton_search.setForeground(new java.awt.Color(255, 255, 255));
        jButton_search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        jButton_search.setText("Search");
        jButton_search.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_searchActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Start Date :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("End Date :");

        jComboBox_station_stationId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox_station_stationId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_station_stationIdActionPerformed(evt);
            }
        });

        jDateChooser_start.setBackground(new java.awt.Color(255, 255, 255));
        jDateChooser_start.setDateFormatString("yyyy/MM/dd");
        jDateChooser_start.setNextFocusableComponent(jDateChooser_end);

        jDateChooser_end.setDateFormatString("yyyy/MM/dd");
        jDateChooser_end.setNextFocusableComponent(jButton_addStation);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton_search))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox_station_stationId, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jDateChooser_start, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser_end, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 24, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDateChooser_end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(jButton_search)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jComboBox_station_stationId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jDateChooser_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 736, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_showAll)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton_showAll)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Readings", jPanel1);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jTable_stations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Description", "Ip Address"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_stations.setEditingColumn(0);
        jTable_stations.setEditingRow(0);
        jTable_stations.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_stations.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTable_stations);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Station"));
        jPanel3.setForeground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Description");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Ip Address");

        jButton_addStation.setBackground(new java.awt.Color(51, 237, 44));
        jButton_addStation.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addStation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accept.png"))); // NOI18N
        jButton_addStation.setText("Add");
        jButton_addStation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_addStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addStationActionPerformed(evt);
            }
        });

        jButton_cancelStation.setBackground(new java.awt.Color(255, 51, 0));
        jButton_cancelStation.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cancelStation.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png"))); // NOI18N
        jButton_cancelStation.setText("Cancel");
        jButton_cancelStation.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_cancelStation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelStationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField_dscStation)
                    .addComponent(jTextField_iaStation)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton_cancelStation)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_addStation, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jTextField_dscStation, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jTextField_iaStation, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addStation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelStation, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Add Sensor"));
        jPanel7.setForeground(new java.awt.Color(51, 51, 51));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Description");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Station");

        jButton_cancelSensor.setBackground(new java.awt.Color(255, 51, 0));
        jButton_cancelSensor.setForeground(new java.awt.Color(255, 255, 255));
        jButton_cancelSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cancel.png"))); // NOI18N
        jButton_cancelSensor.setText("Cancel");
        jButton_cancelSensor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_cancelSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_cancelSensorActionPerformed(evt);
            }
        });

        jButton_addSensor.setBackground(new java.awt.Color(51, 237, 44));
        jButton_addSensor.setForeground(new java.awt.Color(255, 255, 255));
        jButton_addSensor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/accept.png"))); // NOI18N
        jButton_addSensor.setText("Add");
        jButton_addSensor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_addSensor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addSensorActionPerformed(evt);
            }
        });

        jComboBox_sensor_stationId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox_sensor_stationId, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField_dscSensor)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jButton_cancelSensor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton_addSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addComponent(jTextField_dscSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jComboBox_sensor_stationId, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_addSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton_cancelSensor, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jTable_sensors.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Description", "Station"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_sensors.setEditingColumn(0);
        jTable_sensors.setEditingRow(0);
        jTable_sensors.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_sensors.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTable_sensors);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sensors", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jTable_socket.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Station", "Temperature", "Humidity", "Wind Quality", "Powder", "Ip Address", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable_socket.setGridColor(new java.awt.Color(255, 255, 255));
        jTable_socket.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTable_socket);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Real Time Data");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(327, 327, 327)
                .addComponent(jLabel2)
                .addContainerGap(347, Short.MAX_VALUE))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(34, 34, 34)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(195, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Socket", jPanel4);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 765, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 765, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 587, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_addStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addStationActionPerformed
        String description = jTextField_dscStation.getText();
        String ipAddress = jTextField_iaStation.getText();
        if("".equals(description)) { JOptionPane.showMessageDialog(frame,"Please fill description field","Warning",JOptionPane.WARNING_MESSAGE); } else {
        if("".equals(ipAddress)) { JOptionPane.showMessageDialog(frame,"Please fill ipAddress field","Warning",JOptionPane.WARNING_MESSAGE); } else {
            Station.add(description, ipAddress);
            jTextField_dscStation.setText("");
            jTextField_iaStation.setText("");
            sensorsTable = new DefaultTableModel();
            fillStationsTable();
            fillComboBox_station_stationId();
            fillComboBox_sensor_stationId();
        }}
    }//GEN-LAST:event_jButton_addStationActionPerformed

    private void jButton_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_searchActionPerformed
        int idStation = jComboBox_station_stationId.getSelectedIndex();
        SimpleDateFormat dFormat = new SimpleDateFormat("yyyy-MM-dd");
        String startDate = "";
        String endDate = "";
        if(jDateChooser_start.getDate() != null) 
            startDate = dFormat.format(jDateChooser_start.getDate());
        if(jDateChooser_end.getDate() != null)
            endDate = dFormat.format(jDateChooser_end.getDate());
        if(idStation <= 0 && "".equals(startDate) && "".equals(endDate)) {
                JOptionPane.showMessageDialog(frame, "Please fill id field or the date fields");
        }
        else {
            if(idStation > 0 && !"".equals(startDate) && !"".equals(endDate)) {
                jDateChooser_start.setDate(null);
                jDateChooser_end.setDate(null);
                ArrayList<Reading> list = Station.getReadingsDate(idStation, startDate, endDate);
                fillSearchReadingsTable(list);
                jComboBox_station_stationId.setSelectedIndex(0);
            } else {
                if(idStation > 0 && "".equals(startDate) && "".equals(endDate)) {
                    ArrayList<Reading> list = Station.getReadings(idStation);
                    fillSearchReadingsTable(list);
                    jComboBox_station_stationId.setSelectedIndex(0);
                    JOptionPane.showMessageDialog(frame, String.valueOf(idStation));
                }
                else {
                    if("".equals(startDate)) {
                        JOptionPane.showMessageDialog(frame, "Fill the start date field");
                    }
                    else {
                        if("".equals(endDate)) {
                            JOptionPane.showMessageDialog(frame, "Fill the end date field");
                        }
                        else {
                            ArrayList<Reading> list = Reading.getReadingsDate(startDate, endDate);
                            fillSearchReadingsTable(list);
                            jDateChooser_start.setDate(null);
                            jDateChooser_end.setDate(null);
                            JOptionPane.showMessageDialog(frame, (startDate + " " + endDate));
                        } 
                    }
                }
            }
        }
    }//GEN-LAST:event_jButton_searchActionPerformed

    private void jButton_showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_showAllActionPerformed
        readingsTable = new DefaultTableModel();
        fillReadingsTable();
    }//GEN-LAST:event_jButton_showAllActionPerformed

    private void jButton_cancelStationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelStationActionPerformed
        jTextField_dscStation.setText("");
        jTextField_iaStation.setText("");
    }//GEN-LAST:event_jButton_cancelStationActionPerformed

    private void jComboBox_station_stationIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_station_stationIdActionPerformed
      
    }//GEN-LAST:event_jComboBox_station_stationIdActionPerformed

    private void jButton_cancelSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_cancelSensorActionPerformed
        jTextField_dscSensor.setText("");
        jComboBox_sensor_stationId.setSelectedIndex(0);
    }//GEN-LAST:event_jButton_cancelSensorActionPerformed

    private void jButton_addSensorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addSensorActionPerformed
       String description = jTextField_dscSensor.getText();
       int idStation = jComboBox_sensor_stationId.getSelectedIndex();
       if("".equals(description)) { JOptionPane.showMessageDialog(frame,"Please fill description field","Warning",JOptionPane.WARNING_MESSAGE); } else {
       if(idStation == 0) { JOptionPane.showMessageDialog(frame,"Please select one station field","Warning",JOptionPane.WARNING_MESSAGE); } else {
            Sensor.add(description, idStation);
            jTextField_dscSensor.setText("");
            jComboBox_sensor_stationId.setSelectedIndex(0);
            sensorsTable = new DefaultTableModel();
            fillSensorsTable();
        }}
    }//GEN-LAST:event_jButton_addSensorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_addSensor;
    private javax.swing.JButton jButton_addStation;
    private javax.swing.JButton jButton_cancelSensor;
    private javax.swing.JButton jButton_cancelStation;
    private javax.swing.JButton jButton_search;
    private javax.swing.JButton jButton_showAll;
    private javax.swing.JComboBox<String> jComboBox_sensor_stationId;
    private javax.swing.JComboBox<String> jComboBox_station_stationId;
    private com.toedter.calendar.JDateChooser jDateChooser_end;
    private com.toedter.calendar.JDateChooser jDateChooser_start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable_readings;
    private javax.swing.JTable jTable_sensors;
    private javax.swing.JTable jTable_socket;
    private javax.swing.JTable jTable_stations;
    private javax.swing.JTextField jTextField_dscSensor;
    private javax.swing.JTextField jTextField_dscStation;
    private javax.swing.JTextField jTextField_iaStation;
    // End of variables declaration//GEN-END:variables
}
