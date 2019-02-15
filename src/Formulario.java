import java.awt.Color;
import java.awt.Desktop;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jorge
 */
public class Formulario extends javax.swing.JFrame {

    /**
     * Creates new form Formulario
     */
    ConexionBBDD conector = new ConexionBBDD();
    public Formulario() 
    {
        initComponents();                  
        ocultar();
        
        //para seleccionar la fila de la Jtable y me ponga los datos en los jtextField
       jTableClientes.addMouseListener(new MouseAdapter() 
       {
          public void mousePressed(MouseEvent Mouse_evt)
            {
             
             if(Mouse_evt.getClickCount() == 1)
             {

                //para que me ponga los datos en los jtextField
                    jTextFieldDni.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),0).toString());
                    jTextFieldNombre.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),1).toString());
                    jTextFieldApellidos.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),2).toString());
                    jTextFieldCorreo.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),3).toString());
                    jTextFieldTelefono.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),4).toString());
         
                
             }
            }
       } );
       
       jTableLibro.addMouseListener(new MouseAdapter() 
       {
          public void mousePressed(MouseEvent Mouse_evt)
            {
             
             if(Mouse_evt.getClickCount() == 1)
             {

                //para que me ponga los datos en los jtextField
                    jTextFieldISBN.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),0).toString());
                    jTextFieldTitulo.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),1).toString());
                    jTextFieldAutor.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),2).toString());
                    jTextFieldNumPag.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),3).toString());
                    jTextFieldAnnoPubli.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),4).toString());
                    jTextFieldEdicion.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),5).toString());
                    jTextFieldGenero.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),6).toString());
                    jTextFieldTipoCubierta.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),7).toString());
                    jTextFieldIdioma.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),8).toString());
                
             }
            }
       } );
        
    }
    
    public void ocultar()
    {
        
        //Tablas       
            jScrollPaneClientes.setVisible(false);
            jScrollPaneLibro.setVisible(false);
        
        //Botones        
            //Clientes
                jButtonBuscarCliente.setVisible(false);
                jButtonEliminarCliente.setVisible(false);
                jButtonMostrarClientes.setVisible(false);
                jButtonInsertaClientes.setVisible(false);
                jButtonModificarClientes.setVisible(false);
            
            //Libros
                jButtonBuscarLibro.setVisible(false);
                jButtonEliminarLibro.setVisible(false);
                jButtonMostrarLibro.setVisible(false);
                jButtonInsertaLibro.setVisible(false);
                jButtonModificarLibro.setVisible(false);

        //Labels        
            //Clientes
                jLabelApellido.setVisible(false);
                jLabelCorreo.setVisible(false);
                jLabelDNI.setVisible(false);
                jLabelNombre.setVisible(false);
                jLabelTelefono.setVisible(false);   

            //Libros
                jLabelISBN.setVisible(false);
                jLabelAutor.setVisible(false);
                jLabelIdioma.setVisible(false);
                jLabelAnnoPubli.setVisible(false);
                jLabelEdicion.setVisible(false);  
                jLabelTipoCubierta1.setVisible(false);
                jLabelGenero.setVisible(false);
                jLabelTitulo.setVisible(false);
                jLabelNumPag.setVisible(false);
            
        //textField       
            //Clientes
                jTextFieldApellidos.setVisible(false);
                jTextFieldCorreo.setVisible(false);
                jTextFieldDni.setVisible(false);
                jTextFieldNombre.setVisible(false);        
                jTextFieldTelefono.setVisible(false);
            //Libros
                jTextFieldISBN.setVisible(false);
                jTextFieldAutor.setVisible(false);
                jTextFieldEdicion.setVisible(false);
                jTextFieldAnnoPubli.setVisible(false);
                jTextFieldIdioma.setVisible(false);  
                jTextFieldTipoCubierta.setVisible(false);
                jTextFieldTitulo.setVisible(false);
                jTextFieldGenero.setVisible(false);
                jTextFieldNumPag.setVisible(false);
        
        
        //conexion
        jPanelColor.setBackground(new Color(213, 0, 0, 246));
        botonConfiguracion.setText("activar la conexion");
    }
    
    public void mostrar()
    {
        
        //Tablas       
            jScrollPaneClientes.setVisible(true);
            jScrollPaneLibro.setVisible(true);
        
        //Botones        
            //Clientes
                jButtonBuscarCliente.setVisible(true);
                jButtonEliminarCliente.setVisible(true);
                jButtonMostrarClientes.setVisible(true);
                jButtonInsertaClientes.setVisible(true);
                jButtonModificarClientes.setVisible(true);
            
            //Libros
                jButtonBuscarLibro.setVisible(true);
                jButtonEliminarLibro.setVisible(true);
                jButtonMostrarLibro.setVisible(true);
                jButtonInsertaLibro.setVisible(true);
                jButtonModificarLibro.setVisible(true);

        //Labels        
            //Clientes
                jLabelApellido.setVisible(true);
                jLabelCorreo.setVisible(true);
                jLabelDNI.setVisible(true);
                jLabelNombre.setVisible(true);
                jLabelTelefono.setVisible(true);   

            //Libros
                jLabelISBN.setVisible(true);
                jLabelAutor.setVisible(true);
                jLabelIdioma.setVisible(true);
                jLabelAnnoPubli.setVisible(true);
                jLabelEdicion.setVisible(true);  
                jLabelTipoCubierta1.setVisible(true);
                jLabelGenero.setVisible(true);
                jLabelTitulo.setVisible(true);
                jLabelNumPag.setVisible(true);
            
        //textField       
            //Clientes
                jTextFieldApellidos.setVisible(true);
                jTextFieldCorreo.setVisible(true);
                jTextFieldDni.setVisible(true);
                jTextFieldNombre.setVisible(true);        
                jTextFieldTelefono.setVisible(true);
            //Libros
                jTextFieldISBN.setVisible(true);
                jTextFieldAutor.setVisible(true);
                jTextFieldEdicion.setVisible(true);
                jTextFieldAnnoPubli.setVisible(true);
                jTextFieldIdioma.setVisible(true);  
                jTextFieldTipoCubierta.setVisible(true);
                jTextFieldTitulo.setVisible(true);
                jTextFieldGenero.setVisible(true);
                jTextFieldNumPag.setVisible(true);
                
        //conexion
        jPanelColor.setBackground(new Color(0, 0, 145, 123));
        botonConfiguracion.setText("activar la conexion");
    }
    //parapoder seleccionar una fila en la tabla
    
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jDesktopPaneClientes = new javax.swing.JDesktopPane();
        jScrollPaneClientes = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jLabelDNI = new javax.swing.JLabel();
        jTextFieldDni = new javax.swing.JTextField();
        jLabelNombre = new javax.swing.JLabel();
        jTextFieldNombre = new javax.swing.JTextField();
        jLabelApellido = new javax.swing.JLabel();
        jTextFieldApellidos = new javax.swing.JTextField();
        jLabelCorreo = new javax.swing.JLabel();
        jTextFieldCorreo = new javax.swing.JTextField();
        jLabelTelefono = new javax.swing.JLabel();
        jTextFieldTelefono = new javax.swing.JTextField();
        jButtonBuscarCliente = new javax.swing.JButton();
        jButtonInsertaClientes = new javax.swing.JButton();
        jButtonEliminarCliente = new javax.swing.JButton();
        jButtonMostrarClientes = new javax.swing.JButton();
        botonConfiguracion = new javax.swing.JToggleButton();
        jPanelColor = new javax.swing.JPanel();
        jButtonModificarClientes = new javax.swing.JButton();
        jDesktopPaneLibro = new javax.swing.JDesktopPane();
        jScrollPaneLibro = new javax.swing.JScrollPane();
        jTableLibro = new javax.swing.JTable();
        jLabelISBN = new javax.swing.JLabel();
        jTextFieldISBN = new javax.swing.JTextField();
        jLabelTipoCubierta1 = new javax.swing.JLabel();
        jTextFieldTipoCubierta = new javax.swing.JTextField();
        jLabelAutor = new javax.swing.JLabel();
        jTextFieldAutor = new javax.swing.JTextField();
        jLabelNumPag = new javax.swing.JLabel();
        jTextFieldNumPag = new javax.swing.JTextField();
        jLabelAnnoPubli = new javax.swing.JLabel();
        jTextFieldAnnoPubli = new javax.swing.JTextField();
        jLabelIdioma = new javax.swing.JLabel();
        jTextFieldIdioma = new javax.swing.JTextField();
        jLabelTitulo = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jLabelGenero = new javax.swing.JLabel();
        jTextFieldGenero = new javax.swing.JTextField();
        jLabelEdicion = new javax.swing.JLabel();
        jTextFieldEdicion = new javax.swing.JTextField();
        jButtonMostrarLibro = new javax.swing.JButton();
        jButtonBuscarLibro = new javax.swing.JButton();
        jButtonInsertaLibro = new javax.swing.JButton();
        jButtonModificarLibro = new javax.swing.JButton();
        jButtonEliminarLibro = new javax.swing.JButton();
        jDesktopPaneCompra = new javax.swing.JDesktopPane();
        jScrollPaneCompra = new javax.swing.JScrollPane();
        jTableCompra = new javax.swing.JTable();
        jLabelCompra_ISBN = new javax.swing.JLabel();
        jTextFieldCompra_ISBN = new javax.swing.JTextField();
        jLabelCantidad = new javax.swing.JLabel();
        jTextFieldCompraCantidad = new javax.swing.JTextField();
        jLabelCompra_precio = new javax.swing.JLabel();
        jTextFieldCompra_precio = new javax.swing.JTextField();
        jLabelCompra_Dni = new javax.swing.JLabel();
        jTextFieldCompra_Dni = new javax.swing.JTextField();
        jLabelFecha = new javax.swing.JLabel();
        jTextFieldFecha_compra = new javax.swing.JTextField();
        jLabelCompra_titulo = new javax.swing.JLabel();
        jTextFieldCompraLibro = new javax.swing.JTextField();
        jButtonMostrarCompra = new javax.swing.JButton();
        jButtonBuscarCompra = new javax.swing.JButton();
        jButtonInsertaCompra = new javax.swing.JButton();
        jButtonModificarCompra = new javax.swing.JButton();
        jButtonEliminarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneClientes.setViewportView(jTableClientes);

        jLabelDNI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDNI.setText("Dni:");

        jTextFieldDni.setText("1");

        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");

        jTextFieldNombre.setText("Nombre1");

        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("Apellido:");

        jTextFieldApellidos.setText("Apellido1");

        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo:");

        jTextFieldCorreo.setText("Correo1");

        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Telefono:");

        jTextFieldTelefono.setText("123214");

        jButtonBuscarCliente.setText("BuscarClientePorDni");
        jButtonBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonBuscarClienteMousePressed(evt);
            }
        });

        jButtonInsertaClientes.setText("InsertarCliente");
        jButtonInsertaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonInsertaClientesMousePressed(evt);
            }
        });

        jButtonEliminarCliente.setText("EliminarCliente");
        jButtonEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonEliminarClienteMousePressed(evt);
            }
        });

        jButtonMostrarClientes.setText("MostrarClientes");
        jButtonMostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMostrarClientesMousePressed(evt);
            }
        });

        botonConfiguracion.setText("activarConexion");
        botonConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonConfiguracionMousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelColorLayout = new javax.swing.GroupLayout(jPanelColor);
        jPanelColor.setLayout(jPanelColorLayout);
        jPanelColorLayout.setHorizontalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelColorLayout.setVerticalGroup(
            jPanelColorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );

        jButtonModificarClientes.setText("ModificarCliente");
        jButtonModificarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonModificarClientesMousePressed(evt);
            }
        });

        jDesktopPaneClientes.setLayer(jScrollPaneClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jLabelDNI, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jTextFieldDni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jLabelNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jTextFieldNombre, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jLabelApellido, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jTextFieldApellidos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jLabelCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jTextFieldCorreo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jLabelTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jTextFieldTelefono, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jButtonBuscarCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jButtonInsertaClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jButtonEliminarCliente, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jButtonMostrarClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(botonConfiguracion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jPanelColor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneClientes.setLayer(jButtonModificarClientes, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneClientesLayout = new javax.swing.GroupLayout(jDesktopPaneClientes);
        jDesktopPaneClientes.setLayout(jDesktopPaneClientesLayout);
        jDesktopPaneClientesLayout.setHorizontalGroup(
            jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneClientesLayout.createSequentialGroup()
                                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCorreo)
                                    .addComponent(jLabelTelefono))
                                .addGap(9, 9, 9)
                                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                                        .addGap(5, 5, 5)
                                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(15, 15, 15)
                                .addComponent(jButtonMostrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneClientesLayout.createSequentialGroup()
                                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelDNI)
                                    .addComponent(jLabelNombre)
                                    .addComponent(jLabelApellido))
                                .addGap(15, 15, 15)
                                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)
                                .addComponent(jButtonBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                                .addComponent(jButtonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(jButtonModificarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jButtonInsertaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanelColor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botonConfiguracion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)))
                    .addComponent(jScrollPaneClientes))
                .addContainerGap())
        );
        jDesktopPaneClientesLayout.setVerticalGroup(
            jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                .addComponent(jScrollPaneClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabelDNI)
                                .addGap(24, 24, 24)
                                .addComponent(jLabelNombre)
                                .addGap(24, 24, 24)
                                .addComponent(jLabelApellido))
                            .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                                .addComponent(jTextFieldDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jButtonBuscarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5)
                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCorreo)
                        .addGap(24, 24, 24)
                        .addComponent(jLabelTelefono))
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jTextFieldCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonMostrarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botonConfiguracion, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonEliminarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jDesktopPaneClientesLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jDesktopPaneClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonModificarClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInsertaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jTabbedPane1.addTab("Clientes", jDesktopPaneClientes);

        jTableLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneLibro.setViewportView(jTableLibro);

        jLabelISBN.setForeground(new java.awt.Color(255, 255, 255));
        jLabelISBN.setText("ISBN:");

        jTextFieldISBN.setText("1");

        jLabelTipoCubierta1.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTipoCubierta1.setText("Cubierta:");

        jTextFieldTipoCubierta.setText("dura");

        jLabelAutor.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAutor.setText("Autor:");

        jTextFieldAutor.setText("autor1");

        jLabelNumPag.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNumPag.setText("Páginas:");

        jTextFieldNumPag.setText("1234");

        jLabelAnnoPubli.setForeground(new java.awt.Color(255, 255, 255));
        jLabelAnnoPubli.setText("Pubicado en:");

        jTextFieldAnnoPubli.setText("2018");

        jLabelIdioma.setForeground(new java.awt.Color(255, 255, 255));
        jLabelIdioma.setText("Idioma:");

        jTextFieldIdioma.setText("idioma1");

        jLabelTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTitulo.setText("Titulo:");

        jTextFieldTitulo.setText("Titulo1");

        jLabelGenero.setForeground(new java.awt.Color(255, 255, 255));
        jLabelGenero.setText("Genero:");

        jTextFieldGenero.setText("genero1");

        jLabelEdicion.setForeground(new java.awt.Color(255, 255, 255));
        jLabelEdicion.setText("Edicion:");

        jTextFieldEdicion.setText("1");

        jButtonMostrarLibro.setText("MostrarLibros");
        jButtonMostrarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMostrarLibroMousePressed(evt);
            }
        });

        jButtonBuscarLibro.setText("BuscarLibroPorIsbn");
        jButtonBuscarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonBuscarLibroMousePressed(evt);
            }
        });

        jButtonInsertaLibro.setText("InsertarLibro");
        jButtonInsertaLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonInsertaLibroMousePressed(evt);
            }
        });

        jButtonModificarLibro.setText("ModificarLibro");
        jButtonModificarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonModificarLibroMousePressed(evt);
            }
        });

        jButtonEliminarLibro.setText("EliminarLibro");
        jButtonEliminarLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonEliminarLibroMousePressed(evt);
            }
        });

        jDesktopPaneLibro.setLayer(jScrollPaneLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelISBN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldISBN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelTipoCubierta1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldTipoCubierta, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelAutor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldAutor, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelNumPag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldNumPag, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelAnnoPubli, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldAnnoPubli, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelIdioma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldIdioma, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldTitulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelGenero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldGenero, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jLabelEdicion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldEdicion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jButtonMostrarLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jButtonBuscarLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jButtonInsertaLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jButtonModificarLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jButtonEliminarLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneLibroLayout = new javax.swing.GroupLayout(jDesktopPaneLibro);
        jDesktopPaneLibro.setLayout(jDesktopPaneLibroLayout);
        jDesktopPaneLibroLayout.setHorizontalGroup(
            jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonMostrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                                .addComponent(jLabelNumPag)
                                .addGap(31, 31, 31)
                                .addComponent(jTextFieldNumPag, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelTipoCubierta1)
                                    .addComponent(jLabelISBN))
                                .addGap(27, 27, 27)
                                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTipoCubierta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelEdicion)
                                    .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelIdioma)
                                            .addComponent(jLabelGenero))
                                        .addGap(16, 16, 16)
                                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextFieldGenero, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                            .addComponent(jTextFieldIdioma)
                                            .addComponent(jTextFieldEdicion))
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabelAnnoPubli)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldAnnoPubli, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButtonBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonInsertaLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonModificarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                        .addComponent(jLabelAutor)
                        .addGap(18, 18, 18)
                        .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelTitulo)
                        .addGap(19, 19, 19)
                        .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneLibro, javax.swing.GroupLayout.DEFAULT_SIZE, 685, Short.MAX_VALUE))
        );
        jDesktopPaneLibroLayout.setVerticalGroup(
            jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneLibroLayout.createSequentialGroup()
                .addContainerGap(234, Short.MAX_VALUE)
                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelISBN))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jTextFieldEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabelEdicion))
                            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelTipoCubierta1)
                                .addComponent(jTextFieldTipoCubierta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelNumPag)
                                .addComponent(jTextFieldNumPag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelGenero)
                                .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelAutor)
                            .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelTitulo)))
                    .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldAnnoPubli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelAnnoPubli))
                    .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabelIdioma)
                        .addComponent(jTextFieldIdioma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostrarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsertaLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jDesktopPaneLibroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPaneLibroLayout.createSequentialGroup()
                    .addComponent(jScrollPaneLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Libro", jDesktopPaneLibro);

        jTableCompra.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPaneCompra.setViewportView(jTableCompra);

        jLabelCompra_ISBN.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_ISBN.setText("ISBN:");

        jTextFieldCompra_ISBN.setText("dura");

        jLabelCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidad.setText("Cantidad:");

        jTextFieldCompraCantidad.setText("2");

        jLabelCompra_precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_precio.setText("Precio:");

        jTextFieldCompra_precio.setText("14");

        jLabelCompra_Dni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_Dni.setText("Idioma:");

        jTextFieldCompra_Dni.setText("idioma1");

        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText("Titulo:");

        jTextFieldFecha_compra.setText("2018");

        jLabelCompra_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_titulo.setText("Titulo_Libro:");

        jTextFieldCompraLibro.setText("titulo1");

        jButtonMostrarCompra.setText("MostrarClientes");
        jButtonMostrarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMostrarCompraMousePressed(evt);
            }
        });

        jButtonBuscarCompra.setText("BuscarCliente");
        jButtonBuscarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonBuscarCompraMousePressed(evt);
            }
        });

        jButtonInsertaCompra.setText("InsertarClientes");
        jButtonInsertaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonInsertaCompraMousePressed(evt);
            }
        });

        jButtonModificarCompra.setText("ModificarClientes");
        jButtonModificarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonModificarCompraMousePressed(evt);
            }
        });

        jButtonEliminarCompra.setText("EliminarCliente");
        jButtonEliminarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonEliminarCompraMousePressed(evt);
            }
        });

        jDesktopPaneCompra.setLayer(jScrollPaneCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelCompra_ISBN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldCompra_ISBN, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldCompraCantidad, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelCompra_precio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldCompra_precio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelCompra_Dni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldCompra_Dni, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelFecha, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldFecha_compra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jLabelCompra_titulo, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldCompraLibro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jButtonMostrarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jButtonBuscarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jButtonInsertaCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jButtonModificarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jButtonEliminarCompra, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPaneCompraLayout = new javax.swing.GroupLayout(jDesktopPaneCompra);
        jDesktopPaneCompra.setLayout(jDesktopPaneCompraLayout);
        jDesktopPaneCompraLayout.setHorizontalGroup(
            jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addComponent(jLabelCantidad)
                                .addGap(31, 31, 31)
                                .addComponent(jTextFieldCompraCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addComponent(jLabelCompra_precio)
                                .addGap(47, 47, 47)
                                .addComponent(jTextFieldCompra_precio, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonMostrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addComponent(jButtonBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonInsertaCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonModificarCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCompra_titulo)
                                    .addComponent(jLabelFecha)
                                    .addComponent(jLabelCompra_Dni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldFecha_compra)
                                    .addComponent(jTextFieldCompraLibro)
                                    .addComponent(jTextFieldCompra_Dni, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))))
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addComponent(jLabelCompra_ISBN)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldCompra_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 662, Short.MAX_VALUE))
        );
        jDesktopPaneCompraLayout.setVerticalGroup(
            jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPaneCompraLayout.createSequentialGroup()
                .addContainerGap(237, Short.MAX_VALUE)
                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCompra_precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompra_precio))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCantidad)
                            .addComponent(jTextFieldCompraCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompra_titulo)
                            .addComponent(jTextFieldCompraLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCompra_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompra_ISBN)))
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCompra_Dni)
                            .addComponent(jTextFieldCompra_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFecha_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFecha))))
                .addGap(36, 36, 36)
                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonMostrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonInsertaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
            .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                    .addComponent(jScrollPaneCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(328, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Compra", jDesktopPaneCompra);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //funciones para los botones la tabla cliente  
    private void jButtonMostrarClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMostrarClientesMousePressed
        try
        {
        DefaultTableModel modelo = new DefaultTableModel();
        jTableClientes.setModel(modelo);          
           
            Statement sta = conector.conn1.createStatement();
            String query = "SELECT * FROM cliente";
            ResultSet rs = sta.executeQuery(query);
            //le pasamos el resultado de la consulta
            ResultSetMetaData rsMd = rs.getMetaData();
            //compruebo cuantos resultados me devuelve la consulta
            int numColumnas = rsMd.getColumnCount();
            
            //para que me devuelva las columnas
            modelo.addColumn("dni");
            modelo.addColumn("nombre");
            modelo.addColumn("apellidos");
            modelo.addColumn("correo");
            modelo.addColumn("telefono");
            
            //pararecorrer los datos de la consulta hago un while
            //me da los datos de una fila
            while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
               
            modelo.addRow(filas);
                
            }
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMostrarClientesMousePressed

    private void jButtonInsertaClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsertaClientesMousePressed
         conector.InsertaDatosClientes(jTextFieldDni.getText(), jTextFieldNombre.getText(),
                                       jTextFieldApellidos.getText(),jTextFieldCorreo.getText(),
                                       jTextFieldTelefono.getText());
    }//GEN-LAST:event_jButtonInsertaClientesMousePressed

    private void jButtonBuscarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarClienteMousePressed
              
    String buscaDni = jTextFieldDni.getText();
        
    jTableClientes.setModel(conector.BuscarClientes(buscaDni)/*, jTextFieldNombre.getText(), jTextFieldApellidos.getText(), jTextFieldCorreo.getText(), jTextFieldTelefono.getText()*/);
        
       
    }//GEN-LAST:event_jButtonBuscarClienteMousePressed

    private void botonConfiguracionMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonConfiguracionMousePressed
        if(botonConfiguracion.isSelected())
        {
            
            ocultar();
            conector.CerrarConexion();
            
            
        }
        else
        {
            
            mostrar();
            conector.ConexionBBDD();
        }
        
    }//GEN-LAST:event_botonConfiguracionMousePressed

    private void jButtonEliminarClienteMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarClienteMousePressed
        conector.EliminaCliente(jTextFieldDni.getText());
    }//GEN-LAST:event_jButtonEliminarClienteMousePressed

    private void jButtonModificarClientesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificarClientesMousePressed
        conector.ModificarCliente(jTextFieldDni.getText(), jTextFieldNombre.getText(),jTextFieldApellidos.getText(),jTextFieldCorreo.getText(),jTextFieldTelefono.getText());
    }//GEN-LAST:event_jButtonModificarClientesMousePressed

    
    //Funciones para los botones de la tabla libros
    
    private void jButtonMostrarLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMostrarLibroMousePressed
        try
        {
        DefaultTableModel modelo = new DefaultTableModel();
        jTableLibro.setModel(modelo);          
           
            Statement sta = conector.conn1.createStatement();
            String query = "SELECT * FROM libro";
            ResultSet rs = sta.executeQuery(query);
            //le pasamos el resultado de la consulta
            ResultSetMetaData rsMd = rs.getMetaData();
            //compruebo cuantos resultados me devuelve la consulta
            int numColumnas = rsMd.getColumnCount();
            
            //para que me devuelva las columnas
            modelo.addColumn("ISBN");
            modelo.addColumn("titulo");
            modelo.addColumn("autor");
            modelo.addColumn("NumPag");
            modelo.addColumn("Anno_publicacion");
            modelo.addColumn("edicion");
            modelo.addColumn("genero");
            modelo.addColumn("tipoCubierta");
            modelo.addColumn("idioma");
            
            //para recorrer los datos de la consulta hago un while
            //me da los datos de una fila
            while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
               
            modelo.addRow(filas);
                
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMostrarLibroMousePressed

    private void jButtonInsertaLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsertaLibroMousePressed
        conector.InsertarDatosLibros(jTextFieldISBN.getText(), jTextFieldTipoCubierta.getText(), jTextFieldAutor.getText(), jTextFieldNumPag.getText(), jTextFieldAnnoPubli.getText(),
                                     jTextFieldEdicion.getText(), jTextFieldGenero.getText(),jTextFieldTitulo.getText(),jTextFieldIdioma.getText());
    }//GEN-LAST:event_jButtonInsertaLibroMousePressed

    private void jButtonBuscarLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarLibroMousePressed
      //  conector.BuscaLibro(jTextFieldISBN.getText());
      try {
            String _ISBN = jTextFieldISBN.getText();
            String query ="SELECT * FROM libro WHERE ISBN like ?;";
           
            PreparedStatement pst = conector.conn1.prepareStatement(query);
            pst.setString(1,_ISBN);
            
            ResultSet rs = pst.executeQuery();
           
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

           DefaultTableModel modelo = new DefaultTableModel();

            this.jTableLibro.setModel(modelo);

            for (int i = 1; i <= numColumnas; i++)
            {
                modelo.addColumn(metaDatos.getColumnLabel(i));
            }

            
           while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
               
            modelo.addRow(filas);
                
            }

            rs.close();

            pst.close();
            

        } catch (Exception e) 
        {
            
             e.printStackTrace();
          
            
        }
    }//GEN-LAST:event_jButtonBuscarLibroMousePressed

    private void jButtonModificarLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificarLibroMousePressed
        conector.ModificaLibro(jTextFieldISBN.getText(), jTextFieldTipoCubierta.getText(), jTextFieldAutor.getText(),jTextFieldNumPag.getText(),jTextFieldAnnoPubli.getText(),jTextFieldEdicion.getText(),jTextFieldGenero.getText(),jTextFieldTitulo.getText(),jTextFieldIdioma.getText());
    }//GEN-LAST:event_jButtonModificarLibroMousePressed

    private void jButtonEliminarLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarLibroMousePressed
        conector.EliminaLibro(jTextFieldISBN.getText());
    }//GEN-LAST:event_jButtonEliminarLibroMousePressed

    
    //Funciones para los botones de la tabla compra
    private void jButtonMostrarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonMostrarCompraMousePressed
         try
        {
        DefaultTableModel modelo = new DefaultTableModel();
        jTableCompra.setModel(modelo);          
           
            Statement sta = conector.conn1.createStatement();
            String query = "SELECT * FROM compra";
            ResultSet rs = sta.executeQuery(query);
            //le pasamos el resultado de la consulta
            ResultSetMetaData rsMd = rs.getMetaData();
            //compruebo cuantos resultados me devuelve la consulta
            int numColumnas = rsMd.getColumnCount();
            
            //para que me devuelva las columnas
            modelo.addColumn("id_compra");
            modelo.addColumn("id_libro");
            modelo.addColumn("precio");
            modelo.addColumn("cantidad");
            modelo.addColumn("libro");
            modelo.addColumn("dni");
            modelo.addColumn("fecha_compra");
            
            
            //para recorrer los datos de la consulta hago un while
            //me da los datos de una fila
            while(rs.next())
            {
              //declaro un array de tipo objeto el model 
              //nececesitará  objetos
              Object[] filas =  new Object[numColumnas];
                //ahora hago un for para que me vaya dando 
                //los resultados de todas las filas,
                //e ir pasándole todos los datos a la variable filas.
                for(int i= 0; i<numColumnas; i++)
                {
                    filas[i] = rs.getObject(i + 1);                    
                }
               
            modelo.addRow(filas);
                
            }
        } catch (SQLException ex) 
        {
            Logger.getLogger(Formulario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonMostrarCompraMousePressed

    private void jButtonBuscarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarCompraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonBuscarCompraMousePressed

    private void jButtonInsertaCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsertaCompraMousePressed
        conector.InsertarDatosCompra(jTextFieldCompraLibro.getText(),jTextFieldCompra_precio.getText(),jTextFieldCompraCantidad.getText(),jTextFieldCompraLibro.getText(),jTextFieldCompra_Dni.getText(),jTextFieldFecha_compra.getText());
    }//GEN-LAST:event_jButtonInsertaCompraMousePressed

    private void jButtonModificarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificarCompraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificarCompraMousePressed

    private void jButtonEliminarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarCompraMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonEliminarCompraMousePressed

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
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Formulario().setVisible(true);
            }
        });
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton botonConfiguracion;
    private javax.swing.JButton jButtonBuscarCliente;
    private javax.swing.JButton jButtonBuscarCompra;
    private javax.swing.JButton jButtonBuscarLibro;
    private javax.swing.JButton jButtonEliminarCliente;
    private javax.swing.JButton jButtonEliminarCompra;
    private javax.swing.JButton jButtonEliminarLibro;
    private javax.swing.JButton jButtonInsertaClientes;
    private javax.swing.JButton jButtonInsertaCompra;
    private javax.swing.JButton jButtonInsertaLibro;
    private javax.swing.JButton jButtonModificarClientes;
    private javax.swing.JButton jButtonModificarCompra;
    private javax.swing.JButton jButtonModificarLibro;
    private javax.swing.JButton jButtonMostrarClientes;
    private javax.swing.JButton jButtonMostrarCompra;
    private javax.swing.JButton jButtonMostrarLibro;
    private javax.swing.JDesktopPane jDesktopPaneClientes;
    private javax.swing.JDesktopPane jDesktopPaneCompra;
    private javax.swing.JDesktopPane jDesktopPaneLibro;
    private javax.swing.JLabel jLabelAnnoPubli;
    private javax.swing.JLabel jLabelApellido;
    private javax.swing.JLabel jLabelAutor;
    private javax.swing.JLabel jLabelCantidad;
    private javax.swing.JLabel jLabelCompra_Dni;
    private javax.swing.JLabel jLabelCompra_ISBN;
    private javax.swing.JLabel jLabelCompra_precio;
    private javax.swing.JLabel jLabelCompra_titulo;
    private javax.swing.JLabel jLabelCorreo;
    private javax.swing.JLabel jLabelDNI;
    private javax.swing.JLabel jLabelEdicion;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelISBN;
    private javax.swing.JLabel jLabelIdioma;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumPag;
    private javax.swing.JLabel jLabelTelefono;
    private javax.swing.JLabel jLabelTipoCubierta1;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JPanel jPanelColor;
    private javax.swing.JScrollPane jScrollPaneClientes;
    private javax.swing.JScrollPane jScrollPaneCompra;
    private javax.swing.JScrollPane jScrollPaneLibro;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableClientes;
    private javax.swing.JTable jTableCompra;
    private javax.swing.JTable jTableLibro;
    private javax.swing.JTextField jTextFieldAnnoPubli;
    private javax.swing.JTextField jTextFieldApellidos;
    private javax.swing.JTextField jTextFieldAutor;
    private javax.swing.JTextField jTextFieldCompraCantidad;
    private javax.swing.JTextField jTextFieldCompraLibro;
    private javax.swing.JTextField jTextFieldCompra_Dni;
    private javax.swing.JTextField jTextFieldCompra_ISBN;
    private javax.swing.JTextField jTextFieldCompra_precio;
    private javax.swing.JTextField jTextFieldCorreo;
    private javax.swing.JTextField jTextFieldDni;
    private javax.swing.JTextField jTextFieldEdicion;
    private javax.swing.JTextField jTextFieldFecha_compra;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldISBN;
    private javax.swing.JTextField jTextFieldIdioma;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumPag;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTipoCubierta;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
