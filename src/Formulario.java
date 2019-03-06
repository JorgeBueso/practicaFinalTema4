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
                
                //para la sección de 
                    jTextFieldCompra_Dni.setText(jTableClientes.getValueAt(jTableClientes.getSelectedRow(),0).toString());
                
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
                    jTextFieldStock.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),2).toString());
                    jTextFieldAutor.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),3).toString());
                    jTextFieldNumPag.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),4).toString());                    
                    jTextFieldEdicion.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),5).toString());
                    jTextFieldGenero.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),6).toString());
                    jTextFieldTipoCubierta.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),7).toString());
                    jTextFieldIdioma.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),8).toString());
                
                //en al seccion compra
                    jTextFieldCompra_ISBN.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),0).toString());
                    jTextFieldCompraLibro.setText(jTableLibro.getValueAt(jTableLibro.getSelectedRow(),1).toString());
                
             }
            }
       } );
       
       jTableCompra.addMouseListener(new MouseAdapter() 
       {
          public void mousePressed(MouseEvent Mouse_evt)
            {
             
             if(Mouse_evt.getClickCount() == 1)
             {

                //para que me ponga los datos en los jtextField
                    jTextFieldId_compra.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),0).toString());
                    jTextFieldCompra_ISBN.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),1).toString());
                    jTextFieldCompra_precio.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),2).toString());
                    jTextFieldCompraCantidad.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),3).toString());
                    jTextFieldCompraLibro.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),4).toString());
                    jTextFieldCompra_Dni.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),5).toString());
                    jTextFieldFecha_compra.setText(jTableCompra.getValueAt(jTableCompra.getSelectedRow(),6).toString());
                                  
             }
            }
       } );
        
    }
    
    public void ocultar()
    {
        
        //Tablas       
            jScrollPaneClientes.setVisible(false);
            jScrollPaneLibro.setVisible(false);
            jScrollPaneCompra.setVisible(false);
        
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
            
            //Compra
                jButtonBuscarCompra.setVisible(false);
                jButtonEliminarCompra.setVisible(false);
                jButtonMostrarCompra.setVisible(false);
                jButtonInsertaCompra.setVisible(false);
                jButtonModificarCompra.setVisible(false);

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
                jLabelStock.setVisible(false);
                jLabelEdicion.setVisible(false);  
                jLabelTipoCubierta1.setVisible(false);
                jLabelGenero.setVisible(false);
                jLabelTitulo.setVisible(false);
                jLabelNumPag.setVisible(false);
            
            //Compra
                jLabelId_compra.setVisible(false);
                jLabelCompra_Dni.setVisible(false);
                jLabelCompra_ISBN.setVisible(false);
                jLabelCompra_titulo.setVisible(false);
                jLabelCompra_precio.setVisible(false); 
                jLabelCantidad.setVisible(false);
                jLabelFecha.setVisible(false); 
            
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
                jTextFieldStock.setVisible(false);
                jTextFieldIdioma.setVisible(false);  
                jTextFieldTipoCubierta.setVisible(false);
                jTextFieldTitulo.setVisible(false);
                jTextFieldGenero.setVisible(false);
                jTextFieldNumPag.setVisible(false);
            
            //Compra
                jTextFieldId_compra.setVisible(false);
                jTextFieldCompra_ISBN.setVisible(false);
                jTextFieldCompra_Dni.setVisible(false);
                jTextFieldCompraLibro.setVisible(false);
                jTextFieldCompraCantidad.setVisible(false);  
                jTextFieldCompra_precio.setVisible(false);
                jTextFieldFecha_compra.setVisible(false);
        
        //conexion
        jPanelColor.setBackground(new Color(213, 0, 0, 246));
        botonConfiguracion.setText("desactivar la conexion");
    }
    
    public void mostrar()
    {
        
        //Tablas       
            jScrollPaneClientes.setVisible(true);
            jScrollPaneLibro.setVisible(true);
            jScrollPaneCompra.setVisible(true);
        
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
                
            //Compra
                jButtonBuscarCompra.setVisible(true);
                jButtonEliminarCompra.setVisible(true);
                jButtonMostrarCompra.setVisible(true);
                jButtonInsertaCompra.setVisible(true);
                jButtonModificarCompra.setVisible(true);

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
                jLabelStock.setVisible(true);
                jLabelEdicion.setVisible(true);  
                jLabelTipoCubierta1.setVisible(true);
                jLabelGenero.setVisible(true);
                jLabelTitulo.setVisible(true);
                jLabelNumPag.setVisible(true);
            
            //Compra
                jLabelId_compra.setVisible(true);
                jLabelCompra_Dni.setVisible(true);
                jLabelCompra_ISBN.setVisible(true);
                jLabelCompra_titulo.setVisible(true);
                jLabelCompra_precio.setVisible(true); 
                jLabelCantidad.setVisible(true);
                jLabelFecha.setVisible(true); 
                
                
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
                jTextFieldStock.setVisible(true);
                jTextFieldIdioma.setVisible(true);  
                jTextFieldTipoCubierta.setVisible(true);
                jTextFieldTitulo.setVisible(true);
                jTextFieldGenero.setVisible(true);
                jTextFieldNumPag.setVisible(true);
            
            //Compra
                jTextFieldId_compra.setVisible(true);
                jTextFieldCompra_ISBN.setVisible(true);
                jTextFieldCompra_Dni.setVisible(true);
                jTextFieldCompraLibro.setVisible(true);
                jTextFieldCompraCantidad.setVisible(true);  
                jTextFieldCompra_precio.setVisible(true);
                jTextFieldFecha_compra.setVisible(true);
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
        jLabelStock = new javax.swing.JLabel();
        jTextFieldStock = new javax.swing.JTextField();
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
        jLabelId_compra = new javax.swing.JLabel();
        jTextFieldId_compra = new javax.swing.JTextField();
        jButtonModificarCompra = new javax.swing.JButton();
        jButtonEliminarCompra = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDesktopPaneClientes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jDesktopPaneClientes.add(jScrollPaneClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 173));

        jLabelDNI.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDNI.setText("Dni:");
        jDesktopPaneClientes.add(jLabelDNI, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 219, -1, -1));

        jTextFieldDni.setText("1");
        jDesktopPaneClientes.add(jTextFieldDni, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 216, 210, -1));

        jLabelNombre.setForeground(new java.awt.Color(255, 255, 255));
        jLabelNombre.setText("Nombre:");
        jDesktopPaneClientes.add(jLabelNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 257, -1, -1));

        jTextFieldNombre.setText("Nombre1");
        jDesktopPaneClientes.add(jTextFieldNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 254, 210, -1));

        jLabelApellido.setForeground(new java.awt.Color(255, 255, 255));
        jLabelApellido.setText("Apellido:");
        jDesktopPaneClientes.add(jLabelApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 295, -1, -1));

        jTextFieldApellidos.setText("Apellido1");
        jDesktopPaneClientes.add(jTextFieldApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 292, 210, -1));

        jLabelCorreo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCorreo.setText("Correo:");
        jDesktopPaneClientes.add(jLabelCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 335, -1, -1));

        jTextFieldCorreo.setText("Correo1");
        jDesktopPaneClientes.add(jTextFieldCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 332, 210, -1));

        jLabelTelefono.setForeground(new java.awt.Color(255, 255, 255));
        jLabelTelefono.setText("Telefono:");
        jDesktopPaneClientes.add(jLabelTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 373, -1, -1));

        jTextFieldTelefono.setText("123214");
        jDesktopPaneClientes.add(jTextFieldTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 200, -1));

        jButtonBuscarCliente.setText("BuscarClientePorDni");
        jButtonBuscarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonBuscarClienteMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(jButtonBuscarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 156, 75));

        jButtonInsertaClientes.setText("InsertarCliente");
        jButtonInsertaClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonInsertaClientesMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(jButtonInsertaClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, 156, 78));

        jButtonEliminarCliente.setText("EliminarCliente");
        jButtonEliminarCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonEliminarClienteMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(jButtonEliminarCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 418, 116, 80));

        jButtonMostrarClientes.setText("MostrarClientes");
        jButtonMostrarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMostrarClientesMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(jButtonMostrarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 317, 156, 80));

        botonConfiguracion.setText("activarConexion");
        botonConfiguracion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                botonConfiguracionMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(botonConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 317, 140, 80));

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

        jDesktopPaneClientes.add(jPanelColor, new org.netbeans.lib.awtextra.AbsoluteConstraints(525, 420, 140, -1));

        jButtonModificarClientes.setText("ModificarCliente");
        jButtonModificarClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonModificarClientesMousePressed(evt);
            }
        });
        jDesktopPaneClientes.add(jButtonModificarClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 130, 78));

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

        jLabelStock.setForeground(new java.awt.Color(255, 255, 255));
        jLabelStock.setText("En Stock:");

        jTextFieldStock.setText("1");

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
        jDesktopPaneLibro.setLayer(jLabelStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneLibro.setLayer(jTextFieldStock, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                                        .addComponent(jLabelStock)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(270, Short.MAX_VALUE)
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
                        .addComponent(jTextFieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabelStock))
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
                    .addContainerGap(364, Short.MAX_VALUE)))
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

        jLabelCantidad.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCantidad.setText("Cantidad:");

        jLabelCompra_precio.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_precio.setText("Precio:");

        jLabelCompra_Dni.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_Dni.setText("Dni:");

        jLabelFecha.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFecha.setText("Fecha:");

        jLabelCompra_titulo.setForeground(new java.awt.Color(255, 255, 255));
        jLabelCompra_titulo.setText("Titulo_Libro:");

        jButtonMostrarCompra.setText("MostrarCompras");
        jButtonMostrarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonMostrarCompraMousePressed(evt);
            }
        });

        jButtonBuscarCompra.setText("BuscarCompra");
        jButtonBuscarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonBuscarCompraMousePressed(evt);
            }
        });

        jButtonInsertaCompra.setText("InsertarCompra");
        jButtonInsertaCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonInsertaCompraMousePressed(evt);
            }
        });

        jLabelId_compra.setForeground(new java.awt.Color(255, 255, 255));
        jLabelId_compra.setText("Id_compra:");

        jButtonModificarCompra.setText("ModificarCompra");
        jButtonModificarCompra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButtonModificarCompraMousePressed(evt);
            }
        });

        jButtonEliminarCompra.setText("EliminarCompra");
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
        jDesktopPaneCompra.setLayer(jLabelId_compra, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jDesktopPaneCompra.setLayer(jTextFieldId_compra, javax.swing.JLayeredPane.DEFAULT_LAYER);
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
                            .addComponent(jButtonMostrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelCompra_titulo)
                                    .addComponent(jLabelFecha)
                                    .addComponent(jLabelCompra_Dni))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextFieldFecha_compra)
                                    .addComponent(jTextFieldCompraLibro)
                                    .addComponent(jTextFieldCompra_Dni, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)))
                            .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                                .addComponent(jButtonBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonInsertaCompra))))
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addComponent(jLabelCompra_ISBN)
                        .addGap(41, 41, 41)
                        .addComponent(jTextFieldCompra_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldId_compra, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jButtonEliminarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 123, Short.MAX_VALUE)
                    .addComponent(jLabelId_compra)
                    .addComponent(jButtonModificarCompra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(7, Short.MAX_VALUE))
            .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPaneCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE))
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
                        .addGap(52, 52, 52)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCompra_ISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelCompra_ISBN))
                        .addGap(44, 44, 44)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonMostrarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonInsertaCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCompra_Dni)
                            .addComponent(jTextFieldCompra_Dni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelId_compra))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldFecha_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelFecha)
                            .addComponent(jTextFieldId_compra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminarCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
            .addGroup(jDesktopPaneCompraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jDesktopPaneCompraLayout.createSequentialGroup()
                    .addComponent(jScrollPaneCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 364, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Compra", jDesktopPaneCompra);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, -1));

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
            modelo.addColumn("stock");
            modelo.addColumn("autor");
            modelo.addColumn("NumPag");
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
        conector.InsertarDatosLibros(jTextFieldISBN.getText(), jTextFieldTitulo.getText(), jTextFieldAutor.getText(), jTextFieldNumPag.getText(),jTextFieldStock.getText(),
                                     jTextFieldEdicion.getText(), jTextFieldGenero.getText(),jTextFieldTipoCubierta.getText(),jTextFieldIdioma.getText());
    }//GEN-LAST:event_jButtonInsertaLibroMousePressed

    private void jButtonBuscarLibroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonBuscarLibroMousePressed
      //  conector.BuscaLibro(jTextFieldISBN.getText());
      try {
            String _ISBN = jTextFieldISBN.getText()+ "%";
            String query ="SELECT * FROM libro WHERE ISBN like ? ;";
           
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
        conector.ModificaLibro(jTextFieldISBN.getText(), jTextFieldTitulo.getText(), jTextFieldAutor.getText(),jTextFieldNumPag.getText(),jTextFieldStock.getText(),jTextFieldEdicion.getText(),jTextFieldGenero.getText(),jTextFieldTipoCubierta.getText(),jTextFieldIdioma.getText());
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
           //  conector.BuscaLibro(jTextFieldISBN.getText());
      try {
            String _idCompra = jTextFieldId_compra.getText();
            String query ="SELECT * FROM compra WHERE id_compra like ?;";
           
            PreparedStatement pst = conector.conn1.prepareStatement(query);
            pst.setString(1,_idCompra);
            
            ResultSet rs = pst.executeQuery();
           
            ResultSetMetaData metaDatos = rs.getMetaData();

            int numColumnas = metaDatos.getColumnCount();

           DefaultTableModel modelo = new DefaultTableModel();

            this.jTableCompra.setModel(modelo);

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
    }//GEN-LAST:event_jButtonBuscarCompraMousePressed

    private void jButtonInsertaCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonInsertaCompraMousePressed
        conector.InsertarDatosCompra(jTextFieldCompra_ISBN.getText(),jTextFieldCompra_precio.getText(),jTextFieldCompraCantidad.getText(),jTextFieldCompraLibro.getText(),jTextFieldCompra_Dni.getText(),jTextFieldFecha_compra.getText());
    }//GEN-LAST:event_jButtonInsertaCompraMousePressed

    private void jButtonModificarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonModificarCompraMousePressed
        conector.ModificaCompra(jTextFieldId_compra.getText(), jTextFieldISBN.getText(), jTextFieldCompra_precio.getText(), jTextFieldCompraCantidad.getText(),jTextFieldCompraLibro.getText(), jTextFieldDni.getText(), jTextFieldFecha_compra.getText());
    }//GEN-LAST:event_jButtonModificarCompraMousePressed

    private void jButtonEliminarCompraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonEliminarCompraMousePressed
        conector.EliminaCompra(jTextFieldId_compra.getText());
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
    private javax.swing.JLabel jLabelId_compra;
    private javax.swing.JLabel jLabelIdioma;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelNumPag;
    private javax.swing.JLabel jLabelStock;
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
    private javax.swing.JTextField jTextFieldId_compra;
    private javax.swing.JTextField jTextFieldIdioma;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldNumPag;
    private javax.swing.JTextField jTextFieldStock;
    private javax.swing.JTextField jTextFieldTelefono;
    private javax.swing.JTextField jTextFieldTipoCubierta;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
