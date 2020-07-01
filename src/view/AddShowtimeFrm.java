/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import model.Time;
import dao.TimeDAO;
import model.Employee;
import model.Film;
import dao.FilmDAO;
import model.Room;
import dao.RoomDAO;
import model.Showtime;
import dao.ShowTimeDAO;

/**
 *
 * @author NamNguyen
 */
public class AddShowtimeFrm extends javax.swing.JFrame {

    private TimeDAO timeDao;
    private FilmDAO filmDao;
    private RoomDAO roomDao;
    private ShowTimeDAO showtimeDao;
    private Employee em;
   
    LoginFrm logfrm;
    DefaultTableModel dftableFilm;
    DefaultTableModel dftableRoom;
    DefaultTableModel dftableTime;
    ArrayList<Film> lstFilm;
    ArrayList<Room> lstRoom;

    /**
     * Creates new form AddShowtimeFrm
     */
    public AddShowtimeFrm(Employee em) {
        super("Add Showtime");
        initComponents();
        dftableFilm = (DefaultTableModel) jTableFilm.getModel();
        dftableTime = (DefaultTableModel) jTableTime.getModel();
        dftableRoom = (DefaultTableModel) jTableRoom.getModel();
        timeDao = new TimeDAO();
        this.em = em;
        showtimeDao = new ShowTimeDAO();
        filmDao = new FilmDAO();
        roomDao = new RoomDAO();
        

        jLabelName1.setText("Login in as:" + em.getName().replaceAll("\\s", ""));
        loadAllTime();
        loadAllFilmOnTable();
        loadAllRoomOnTable();

    }

    private void loadAllTime() {
        dftableTime.setNumRows(0);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        ArrayList<Time> list = timeDao.loadAllTime();
        for (Time lst : list) {
            Object[] obj = {lst.getId(), formatter.format(lst.getShowDate()), lst.getStartTime()};
            dftableTime.addRow(obj);

        }
    }

    private void loadAllTimeByDate(java.util.Date date) {
        dftableTime.setNumRows(0);
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

        ArrayList<Time> list = timeDao.loadTimeByDate(date);
        for (Time lst : list) {
            Object[] obj = {lst.getId(), formatter.format(lst.getShowDate()), lst.getStartTime()};
            dftableTime.addRow(obj);

        }
    }

    private void loadAllFilmOnTable() {
        dftableFilm.setRowCount(0);
        lstFilm = filmDao.loadAllPhim();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        for (int i = 0; i < lstFilm.size(); i++) {
            int id = lstFilm.get(i).getId();
            String name = lstFilm.get(i).getName();
            String airDate = formatter.format(lstFilm.get(i).getAirDate());
            String duration = lstFilm.get(i).getDuration();

            Object[] ojb = {id, name, airDate, duration};
            dftableFilm.addRow(ojb);
        }
    }

    private void loadAllRoomOnTable() {
        dftableRoom.setRowCount(0);
        lstRoom = roomDao.loadAllRoom();

        for (int i = 0; i < lstRoom.size(); i++) {
            int id = lstRoom.get(i).getId();
            String name = lstRoom.get(i).getName();
            int nofSeat = lstRoom.get(i).getNumber_of_seat();
            String acreage = lstRoom.get(i).getAcreage();
            Object[] ojb = {id, name, nofSeat, acreage};
            dftableRoom.addRow(ojb);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTime = new javax.swing.JTable();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        jSpinner = new javax.swing.JSpinner(sm);
        jButtonAddShowtime = new javax.swing.JButton();
        jButtonDeleteTime = new javax.swing.JButton();
        jTextFieldIdTime = new javax.swing.JTextField();
        JButtonNext = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFilm = new javax.swing.JTable();
        jButtonAddTime = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableRoom = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldIDFilm = new javax.swing.JTextField();
        jTextFieldIDRoom = new javax.swing.JTextField();
        jTextFieldIDShowtime = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabelName1 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font(".VnArialH", 1, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_Watch_701487.png"))); // NOI18N
        jLabel5.setText("Choose time");

        jTableTime.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "ShowDate", "StartTime"
            }
        ));
        jTableTime.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTimeMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableTime);

        jDateChooser1.setDateFormatString("dd/MM/yyyy");
        jDateChooser1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        JSpinner.DateEditor de = new JSpinner.DateEditor(jSpinner, "HH:mm");
        jSpinner.setEditor(de);
        jSpinner.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonAddShowtime.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButtonAddShowtime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_sign-add_299068.png"))); // NOI18N
        jButtonAddShowtime.setText("Add");
        jButtonAddShowtime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddShowtimeActionPerformed(evt);
            }
        });

        jButtonDeleteTime.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButtonDeleteTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_minus_1645995.png"))); // NOI18N
        jButtonDeleteTime.setText("Delete");
        jButtonDeleteTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteTimeActionPerformed(evt);
            }
        });

        JButtonNext.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        JButtonNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_sign-add_299068.png"))); // NOI18N
        JButtonNext.setText("Next");
        JButtonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JButtonNextActionPerformed(evt);
            }
        });

        jButtonCancel.setFont(new java.awt.Font("Arial Black", 1, 11)); // NOI18N
        jButtonCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancel.PNG"))); // NOI18N
        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jButtonAddShowtime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jButtonDeleteTime))
                        .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextFieldIdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(187, 187, 187))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JButtonNext)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonCancel)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextFieldIdTime, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jLabel5)))
                .addGap(29, 29, 29)
                .addComponent(jSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAddShowtime)
                    .addComponent(jButtonDeleteTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JButtonNext)
                    .addComponent(jButtonCancel))
                .addGap(38, 38, 38))
        );

        jTabbedPane1.addTab("TIME", new javax.swing.ImageIcon(getClass().getResource("/images/if_clock_1055090.png")), jPanel2); // NOI18N

        jLabel1.setFont(new java.awt.Font("Arial Black", 1, 24)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-calendar-document-64.png"))); // NOI18N
        jLabel1.setText("Add show time");

        jTableFilm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Air_Date", "Duration"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFilm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFilmMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableFilm);

        jButtonAddTime.setBackground(new java.awt.Color(255, 255, 255));
        jButtonAddTime.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButtonAddTime.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/if_sign-add_299068.png"))); // NOI18N
        jButtonAddTime.setText("Add");
        jButtonAddTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddTimeActionPerformed(evt);
            }
        });

        jTableRoom.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Number Of Seat", "Areage"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRoom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRoomMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableRoom);

        jLabel3.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel3.setText("List Film");

        jLabel4.setFont(new java.awt.Font("Arial Black", 2, 18)); // NOI18N
        jLabel4.setText("List Room");

        jLabel2.setFont(new java.awt.Font("Arial Black", 2, 14)); // NOI18N
        jLabel2.setText("ID");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldIDShowtime, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(jTextFieldIDFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldIDRoom, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 394, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(697, Short.MAX_VALUE)
                .addComponent(jButtonAddTime, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIDShowtime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(47, 47, 47)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldIDFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldIDRoom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jButtonAddTime, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("ADDSHOWTIME", new javax.swing.ImageIcon(getClass().getResource("/images/icons8-calendar-document-64.png")), jPanel3); // NOI18N

        jLabelName1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N

        jButton8.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 0, 0));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8-back-40.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(594, 594, 594)
                        .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 856, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonDeleteTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteTimeActionPerformed
        
        JOptionPane.showConfirmDialog(null, "Are you sure??");
        timeDao.deleteTime(Integer.parseInt(jTextFieldIdTime.getText()));
        loadAllTime();
     
       
    }//GEN-LAST:event_jButtonDeleteTimeActionPerformed

    private void jButtonAddShowtimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddShowtimeActionPerformed
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        Time t = new Time();
         //check date if datecreated is greater or not than today
        Date today = new Date();
        if (jDateChooser1.getDate().before(today)) {
            JOptionPane.showMessageDialog(null, "Date is not allowed less than today");
            jDateChooser1.requestFocus();
            return;
        }
        
        //Check whether datecreated and time have existed
        if(timeDao.checkTime(jDateChooser1.getDate(), formatter.format(jSpinner.getValue()))){
            JOptionPane.showMessageDialog(null, "Date or time has been existed already!!!");
            jDateChooser1.requestFocus();
            return;
        }
        
        jTextFieldIdTime.setText(generateID());
        t.setId(Integer.parseInt(jTextFieldIdTime.getText()));
        t.setShowDate(jDateChooser1.getDate());
        t.setStartTime(formatter.format(jSpinner.getValue()));
        timeDao.AddTime(t);
        loadAllTime();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAddShowtimeActionPerformed

    private void jTableTimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTimeMouseClicked
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm");
            int selectedIndexRow = jTableTime.getSelectedRow();
            jTextFieldIdTime.setText(dftableTime.getValueAt(selectedIndexRow, 0).toString());
            jDateChooser1.setDate(formatter.parse(dftableTime.getValueAt(selectedIndexRow, 1).toString()));
            jSpinner.setValue(formatter1.parse(dftableTime.getValueAt(selectedIndexRow, 2).toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }//GEN-LAST:event_jTableTimeMouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        logfrm = new LoginFrm();
        logfrm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ManageShowtimeFrm(em).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddTimeActionPerformed
        Showtime showtime = new Showtime();
        
        Room room = new Room();
        Film film = new Film();
        Time time = new Time();
        if(jTextFieldIDFilm.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please choose film for showtime!!!");
            jTextFieldIDFilm.requestFocus();
            return;
        }
         if(jTextFieldIDRoom.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please choose room for showtime!!!");
            jTextFieldIDRoom.requestFocus();
            return;
        }
         if(jTextFieldIdTime.getText().equals("")){
             JOptionPane.showMessageDialog(null, "Please choose date and time for showtime!!!");
            jTextFieldIdTime.requestFocus();
            return;
        }
         
         if(showtimeDao.checkShowTime(showtime.getId(), showtime.getFilm().getId(),showtime.getRoom().getId(),showtime.getTime().getId())){
            JOptionPane.showMessageDialog(null, "Showtime has been existed already!!!");
            jTextFieldIDShowtime.requestFocus();
            return;
        }
        
        jTextFieldIDShowtime.setText(generateID());
        time.setId(Integer.parseInt(jTextFieldIdTime.getText()));
        room.setId(Integer.parseInt(jTextFieldIDRoom.getText()));
        film.setId(Integer.parseInt(jTextFieldIDFilm.getText()));
        showtime.setId(Integer.parseInt(jTextFieldIDShowtime.getText()));
        showtime.setTime(time);
        showtime.setRoom(room);
        showtime.setFilm(film);
        showtimeDao.AddShowTime(showtime);
        JOptionPane.showMessageDialog(null, "Add Showtime Successfully!!!");
        new ManageHomeFrm(em).setVisible(true);
        this.dispose();
       
    }//GEN-LAST:event_jButtonAddTimeActionPerformed

    private void jTableFilmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFilmMouseClicked
        int select = jTableFilm.getSelectedRow();
        jTextFieldIDFilm.setText(jTableFilm.getValueAt(select, 0).toString());    }//GEN-LAST:event_jTableFilmMouseClicked

    private void jTableRoomMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRoomMouseClicked
        int select = jTableRoom.getSelectedRow();
        jTextFieldIDRoom.setText(jTableRoom.getValueAt(select, 0).toString());    }//GEN-LAST:event_jTableRoomMouseClicked

    private void JButtonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JButtonNextActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_JButtonNextActionPerformed

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        new ManageShowtimeFrm(em).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JButtonNext;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButtonAddShowtime;
    private javax.swing.JButton jButtonAddTime;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDeleteTime;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabelName1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSpinner jSpinner;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableFilm;
    private javax.swing.JTable jTableRoom;
    private javax.swing.JTable jTableTime;
    private javax.swing.JTextField jTextFieldIDFilm;
    private javax.swing.JTextField jTextFieldIDRoom;
    private javax.swing.JTextField jTextFieldIDShowtime;
    private javax.swing.JTextField jTextFieldIdTime;
    // End of variables declaration//GEN-END:variables

    private String generateID() {
        Random rd = new Random();
        String id = "";
        for (int i = 0; i < 7; i++) {
            id += rd.nextInt(10);
        }
        return id;

    }
}
