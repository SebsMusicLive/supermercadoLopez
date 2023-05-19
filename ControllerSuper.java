package supermercadoLopez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ControllerSuper {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAgregarCliente;

    @FXML
    private Button btnCerrarSupermercado;

    @FXML
    private Button btnFinalizarCompra;

    @FXML
    private Button btnGenerarClienteAleatorio;

    @FXML
    private Button btnPagarCaja1;

    @FXML
    private Button btnPagarCaja2;

    @FXML
    private Button btnPagarCaja3;

    @FXML
    private Button btnPagarEnCajaDos;

    @FXML
    private Button btnPagarEnCajaTres;

    @FXML
    private Button btnPagarEnCajaUno;

    @FXML
    private Label lblClientesEnLaTienda;

    @FXML
    private Label lblCaja1;

    @FXML
    private Label lblCaja2;

    @FXML
    private Label lblCaja3;

    @FXML
    private Label lblCantidadDeClientes;

    @FXML
    private Label lblCarritosDisponibles;

    @FXML
    private Label lblCedula;

    @FXML
    private Label lblClientes;

    @FXML
    private Label lblClientesCola;

    @FXML
    private Label lblClientesEnCola;

    @FXML
    private Label lblClientesEnEspera;

    @FXML
    private Label lblFacturadoCaja1;

    @FXML
    private Label lblFacturadoCaja2;

    @FXML
    private Label lblFacturadoCaja3;
    
    @FXML
    private Label lblFacturadoCajas;

    @FXML
    private Label lblFacturadoCajas1;

    @FXML
    private Label lblFacturadoCajas2;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblNuevoCliente;

    @FXML
    private Label lblProductosDisponibles;

    @FXML
    private Label lblSupermercado;

    @FXML
    private TextField txtCaja1;

    @FXML
    private TextField txtCaja2;

    @FXML
    private TextField txtCaja3;

    @FXML
    private TextField txtCarritosDisponibles;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtClientesEnEspera;

    @FXML
    private TextField txtColaCaja1;

    @FXML
    private TextField txtColaCaja2;

    @FXML
    private TextField txtColaCaja3;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextArea txtProductosDisponibles;

    @FXML
    private TextArea txtClientesEnTienda;

    //Colas
    private ColaArray<Integer> carritosDisponibles = new ColaArray<>();
    private ColaArray<Integer> carritosEntienda = new ColaArray<>();
    private ColaArray<Cliente> pagoCaja1 = new ColaArray<>();
    private ColaArray<Cliente> pagoCaja2 = new ColaArray<>();
    private ColaArray<Cliente> pagoCaja3 = new ColaArray<>();

    private ColaLista<Cliente> colaCaja1 = new ColaLista<>();
    private ColaLista<Cliente> colaCaja2 = new ColaLista<>();
    private ColaLista<Cliente> colaCaja3 = new ColaLista<>();
    private ColaLista<Cliente> clientesEnTienda = new ColaLista<>();
    private ColaLista<Cliente> clientesEnEspera = new ColaLista<>();

    Supermercado superMerc = new Supermercado();

    Supermercado superCarritosDisponibles = new Supermercado(carritosDisponibles);
    Supermercado superCarritosTienda = new Supermercado(carritosEntienda);
    Supermercado colaCajas = new Supermercado(pagoCaja1, pagoCaja2, pagoCaja3);

    @FXML
    void finalizarCompra(ActionEvent event) throws Exception {
        if (!clientesEnTienda.colaVacia()) {
            if (colaCaja1.colaVacia() || colaCaja1.tamañoDeLaCola() <= colaCaja2.tamañoDeLaCola() && colaCaja1.tamañoDeLaCola() <= colaCaja3.tamañoDeLaCola()) {

                colaCaja1.insertar(clientesEnTienda.quitar());

                txtColaCaja1.setText(colaCaja1.print());
                lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            } else if (colaCaja2.colaVacia() || colaCaja2.tamañoDeLaCola() <= colaCaja1.tamañoDeLaCola() && colaCaja2.tamañoDeLaCola() <= colaCaja3.tamañoDeLaCola()) {

                colaCaja2.insertar(clientesEnTienda.quitar());

                txtColaCaja2.setText(colaCaja2.print());
                lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            } else if (colaCaja3.colaVacia() || colaCaja3.tamañoDeLaCola() <= colaCaja2.tamañoDeLaCola() && colaCaja3.tamañoDeLaCola() <= colaCaja1.tamañoDeLaCola()) {

                colaCaja3.insertar(clientesEnTienda.quitar());

                txtColaCaja3.setText(colaCaja3.print());
                lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            }
            lblClientesEnCola.setText(String.valueOf(colaCaja1.tamañoDeLaCola() + colaCaja2.tamañoDeLaCola() + colaCaja3.tamañoDeLaCola()));
            txtClientesEnTienda.setText(superMerc.mostrarClientes(clientesEnTienda));
        } else if (colaCaja1.colaVacia() && colaCaja2.colaVacia() && colaCaja3.colaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay clientes en la tienda");
        } else {
            JOptionPane.showMessageDialog(null, "Todos los clientes están haciendo cola en las cajas");
        }

    }

    @FXML
    void pasarACajaUno(ActionEvent event) throws Exception {
        if (!colaCaja1.colaVacia()) {
            if (!pagoCaja1.colaLlena()) {
                pagoCaja1.insertar(colaCaja1.quitar());
                txtCaja1.setText(pagoCaja1.print());
                txtColaCaja1.setText(colaCaja1.print());
            } else {
                JOptionPane.showMessageDialog(null, "Hay un cliente pagando en la caja 1");
            }

        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
        }
    }

    @FXML
    void pasarACajaDos(ActionEvent event) throws Exception {
        if (!colaCaja2.colaVacia()) {
            if (!pagoCaja2.colaLlena()) {
                pagoCaja2.insertar(colaCaja2.quitar());

                txtCaja2.setText(pagoCaja2.print());
                txtColaCaja2.setText(colaCaja2.print());
            } else {
                JOptionPane.showMessageDialog(null, "Hay un cliente pagando en la caja 2");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
        }
    }

    @FXML
    void pasarACajaTres(ActionEvent event) throws Exception {
        if (!colaCaja3.colaVacia()) {
            if (!pagoCaja3.colaLlena()) {
                pagoCaja3.insertar(colaCaja3.quitar());
                txtCaja3.setText(pagoCaja3.print());
                txtColaCaja3.setText(colaCaja3.print());
            } else {
                JOptionPane.showMessageDialog(null, "Hay un cliente pagando en la caja 3");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay clientes en la cola");
        }
    }

    @FXML
    void pagarCaja1(ActionEvent event) throws Exception {
        if (!pagoCaja1.colaVacia()) {
            lblFacturadoCaja1.setText(pagoCaja1.print());
            pagoCaja1.quitar();
            retornarCarritos();
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));

            if (!colaCaja1.colaVacia()) {
                pasarACajaUno(event);

            } else {
                txtCaja1.setText("");
            }
            
            
        } else {
            JOptionPane.showMessageDialog(null, "No hay nadie en la cola de la caja 1");
        }
        lblClientesEnCola.setText(String.valueOf(colaCaja1.tamañoDeLaCola() + colaCaja2.tamañoDeLaCola() + colaCaja3.tamañoDeLaCola()));

    }

    @FXML
    void pagarCaja2(ActionEvent event) throws Exception {
        if (!pagoCaja2.colaVacia()) {

            pagoCaja2.quitar();
            retornarCarritos();
            txtCarritosDisponibles.setText(carritosDisponibles.print());
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));

            if (!colaCaja2.colaVacia()) {
                pasarACajaDos(event);
            } else {
                txtCaja2.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay nadie en la cola de la caja 2");
        }
        lblClientesEnCola.setText(String.valueOf(colaCaja1.tamañoDeLaCola() + colaCaja2.tamañoDeLaCola() + colaCaja3.tamañoDeLaCola()));

    }

    @FXML
    void pagarCaja3(ActionEvent event) throws Exception {
        if (!pagoCaja3.colaVacia()) {

            pagoCaja3.quitar();
            retornarCarritos();
            txtCarritosDisponibles.setText(carritosDisponibles.print());
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            if (!colaCaja3.colaVacia()) {
                pasarACajaTres(event);
            } else {
                txtCaja3.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "No hay nadie en la cola de la caja 3");
        }
        lblClientesEnCola.setText(String.valueOf(colaCaja1.tamañoDeLaCola() + colaCaja2.tamañoDeLaCola() + colaCaja3.tamañoDeLaCola()));

    }

    @FXML
    void cerrarSupermercado(ActionEvent event) {

    }

    @FXML
    void agregarClienteNuevo(ActionEvent event) throws Exception {
        if (isNumeric(txtCedula.getText())) {
            int cedulaCliente = Integer.valueOf(txtCedula.getText());
            String nombreCliente = txtNombre.getText();
            if (carritosDisponibles.colaVacia()) {
                superMerc.añadirClientes(clientesEnEspera, cedulaCliente, nombreCliente);

                String clientesStr = String.valueOf(clientesEnEspera.tamañoDeLaCola());

                txtClientesEnEspera.setText(clientesStr);

                txtNombre.setText("");
                txtCedula.setText("");

            } else {

                superCarritosDisponibles.añadirClientes(clientesEnTienda, cedulaCliente, nombreCliente);
                String clientesStr = String.valueOf(clientesEnTienda.tamañoDeLaCola());

                lblCantidadDeClientes.setText(clientesStr);
                carritosEntienda.insertar(carritosDisponibles.quitar());
                txtNombre.setText("");
                txtCedula.setText("");

            }
            txtClientesEnTienda.setText(superMerc.mostrarClientes(clientesEnTienda));

            txtCarritosDisponibles.setText((String) (superCarritosDisponibles.mostrarCarritos(carritosDisponibles)));
        } else {
            JOptionPane.showMessageDialog(null, "No ingresaste una cédula correcta");
        }

    }

    @FXML
    void generarClienteAleatorio(ActionEvent event) throws Exception {
        if (carritosDisponibles.colaVacia()) {
            superCarritosDisponibles.añadirClientesAleatorios(clientesEnTienda);

            String clientesStr = String.valueOf(clientesEnEspera.tamañoDeLaCola());

            txtClientesEnEspera.setText(clientesStr);

        } else {

            superCarritosDisponibles.añadirClientesAleatorios(clientesEnTienda);
            String clientesStr = String.valueOf(clientesEnTienda.tamañoDeLaCola());

            lblCantidadDeClientes.setText(clientesStr);

            carritosEntienda.insertar(carritosDisponibles.quitar());

        }
        txtClientesEnTienda.setText(superMerc.mostrarClientes(clientesEnTienda));
        txtCarritosDisponibles.setText((String) (superCarritosDisponibles.mostrarCarritos(carritosDisponibles)));

    }

    public void retornarCarritos() throws Exception {
        if (!clientesEnEspera.colaVacia() && carritosDisponibles.colaVacia()) {
            clientesEnTienda.insertar(clientesEnEspera.quitar());
            txtClientesEnEspera.setText(String.valueOf(clientesEnEspera.tamañoDeLaCola()));

        } else {
            carritosDisponibles.insertar(carritosEntienda.quitar());
            txtCarritosDisponibles.setText(carritosDisponibles.print());
        }
    }

    private boolean isNumeric(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    @FXML
    void initialize() throws Exception {
        assert btnAgregarCliente != null : "fx:id=\"btnAgregarCliente\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnCerrarSupermercado != null : "fx:id=\"btnCerrarSupermercado\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnFinalizarCompra != null : "fx:id=\"btnFinalizarCompra\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnGenerarClienteAleatorio != null : "fx:id=\"btnGenerarClienteAleatorio\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarCaja1 != null : "fx:id=\"btnPagarCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarCaja2 != null : "fx:id=\"btnPagarCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarCaja3 != null : "fx:id=\"btnPagarCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaDos != null : "fx:id=\"btnPagarEnCajaDos\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaTres != null : "fx:id=\"btnPagarEnCajaTres\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaUno != null : "fx:id=\"btnPagarEnCajaUno\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesEnLaTienda != null : "fx:id=\"lblClientesEnLaTienda\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja1 != null : "fx:id=\"lblCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja2 != null : "fx:id=\"lblCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja3 != null : "fx:id=\"lblCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCantidadDeClientes != null : "fx:id=\"lblCantidadDeClientes\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCarritosDisponibles != null : "fx:id=\"lblCarritosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCedula != null : "fx:id=\"lblCedula\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientes != null : "fx:id=\"lblClientes\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesCola != null : "fx:id=\"lblClientesCola\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesEnCola != null : "fx:id=\"lblClientesEnCola\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesEnEspera != null : "fx:id=\"lblClientesEnEspera\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCaja1 != null : "fx:id=\"lblFacturadoCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCaja2 != null : "fx:id=\"lblFacturadoCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCaja3 != null : "fx:id=\"lblFacturadoCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCajas != null : "fx:id=\"lblFacturadoCajas\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCajas1 != null : "fx:id=\"lblFacturadoCajas1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblFacturadoCajas2 != null : "fx:id=\"lblFacturadoCajas2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblNombre != null : "fx:id=\"lblNombre\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblNuevoCliente != null : "fx:id=\"lblNuevoCliente\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblProductosDisponibles != null : "fx:id=\"lblProductosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblSupermercado != null : "fx:id=\"lblSupermercado\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja1 != null : "fx:id=\"txtCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja2 != null : "fx:id=\"txtCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja3 != null : "fx:id=\"txtCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCarritosDisponibles != null : "fx:id=\"txtCarritosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCedula != null : "fx:id=\"txtCedula\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtClientesEnEspera != null : "fx:id=\"txtClientesEnEspera\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja1 != null : "fx:id=\"txtColaCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja2 != null : "fx:id=\"txtColaCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja3 != null : "fx:id=\"txtColaCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtNombre != null : "fx:id=\"txtNombre\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtProductosDisponibles != null : "fx:id=\"txtProductosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtClientesEnTienda != null : "fx:id=\"txtClientesEnTienda\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";

        superCarritosDisponibles.llenarColaCarritos(carritosDisponibles);
        txtCarritosDisponibles.setText((String) (superCarritosDisponibles.mostrarCarritos(carritosDisponibles)));

        txtProductosDisponibles.setText(superMerc.mostrarProductos());
//        txtCarritosDisponibles.setText("Hola");
    }

}
