package supermercadoLopez;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class ControllerSuper {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnFinalizarCompra;

    @FXML
    private Button btnLlegoUnCliente;

    @FXML
    private Button btnPagarCaja;

    @FXML
    private Button btnPagarEnCajaDos;

    @FXML
    private Button btnPagarEnCajaTres;

    @FXML
    private Button btnPagarEnCajaUno;

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
    private Label lblClientes;

    @FXML
    private Label lblClientesEnEspera;

    @FXML
    private Label lblSupermercado;

    @FXML
    private Label lblClientesCola;

    @FXML
    private Label lblClientesEnCola;

    @FXML
    private TextField txtCaja1;

    @FXML
    private TextField txtCaja2;

    @FXML
    private TextField txtCaja3;

    @FXML
    private TextField txtCarritosDisponibles;

    @FXML
    private TextField txtClientesEnEspera;

    @FXML
    private TextField txtColaCaja1;

    @FXML
    private TextField txtColaCaja2;

    @FXML
    private TextField txtColaCaja3;

    //Colas
    private ColaArray<Integer> carritosDisponibles = new ColaArray<>();
    private ColaArray<Integer> carritosEntienda = new ColaArray<>();
    private ColaArray<Integer> pagoCaja1 = new ColaArray<>();
    private ColaArray<Integer> pagoCaja2 = new ColaArray<>();
    private ColaArray<Integer> pagoCaja3 = new ColaArray<>();

    private ColaLista<Integer> colaCaja1 = new ColaLista<>();
    private ColaLista<Integer> colaCaja2 = new ColaLista<>();
    private ColaLista<Integer> colaCaja3 = new ColaLista<>();
    private ColaLista<Integer> clientesEnTienda = new ColaLista<>();
    private ColaLista<Integer> clientesEnEspera = new ColaLista<>();

    Supermercado superCarritosDisponibles = new Supermercado(carritosDisponibles);
    Supermercado superCarritosTienda = new Supermercado(carritosEntienda);
    Supermercado colaCajas = new Supermercado(pagoCaja1, pagoCaja2, pagoCaja3);

    @FXML
    void agregarCliente(ActionEvent event) throws Exception {

        if (carritosDisponibles.colaVacia()) {
            superCarritosDisponibles.añadirClientes(clientesEnEspera);

            String clientesStr = String.valueOf(clientesEnEspera.tamañoDeLaCola());

            txtClientesEnEspera.setText(clientesStr);
        } else {

            superCarritosDisponibles.añadirClientes(clientesEnTienda);
            String clientesStr = String.valueOf(clientesEnTienda.tamañoDeLaCola());

            lblCantidadDeClientes.setText(clientesStr);

            carritosEntienda.insertar(carritosDisponibles.quitar());

        }

        txtCarritosDisponibles.setText((String) (superCarritosDisponibles.mostrarCarritos(carritosDisponibles)));
    }

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
        } else if (colaCaja1.colaVacia() && colaCaja2.colaVacia() && colaCaja3.colaVacia()) {
            JOptionPane.showMessageDialog(null, "No hay clientes en la tienda");
        } else {
            JOptionPane.showMessageDialog(null, "Todos los clientes están haciendo cola en las cajas");
        }

    }

    @FXML
    void pagarCajas(ActionEvent event) throws Exception {
        
        
        
        if (!pagoCaja1.colaVacia()) {

            pagoCaja1.quitar();
            retornarCarritos();
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            txtCaja1.setText("");
        } else if (!pagoCaja2.colaVacia()) {

            pagoCaja2.quitar();
            retornarCarritos();
            txtCarritosDisponibles.setText(carritosDisponibles.print());
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            txtCaja2.setText("");
        } else if (!pagoCaja3.colaVacia()) {

            pagoCaja3.quitar();
            retornarCarritos();
            txtCarritosDisponibles.setText(carritosDisponibles.print());
            lblCantidadDeClientes.setText(String.valueOf(clientesEnTienda.tamañoDeLaCola()));
            txtCaja3.setText("");
        }else{
            JOptionPane.showMessageDialog(null, "No hay nadie en ninguna de las cajas");
        }
        lblClientesEnCola.setText(String.valueOf(colaCaja1.tamañoDeLaCola() + colaCaja2.tamañoDeLaCola() + colaCaja3.tamañoDeLaCola()));

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

    public void retornarCarritos() throws Exception {
        if (!clientesEnEspera.colaVacia() && carritosDisponibles.colaVacia()) {
            clientesEnTienda.insertar(clientesEnEspera.quitar());
            txtClientesEnEspera.setText(String.valueOf(clientesEnEspera.tamañoDeLaCola()));

        } else {
            carritosDisponibles.insertar(carritosEntienda.quitar());
            txtCarritosDisponibles.setText(carritosDisponibles.print());
        }
    }

    @FXML
    void initialize() throws Exception {
        assert btnFinalizarCompra != null : "fx:id=\"btnFinalizarCompra\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnLlegoUnCliente != null : "fx:id=\"btnLlegoUnCliente\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarCaja != null : "fx:id=\"btnPagarCaja\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaDos != null : "fx:id=\"btnPagarEnCajaDos\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaTres != null : "fx:id=\"btnPagarEnCajaTres\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert btnPagarEnCajaUno != null : "fx:id=\"btnPagarEnCajaUno\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja1 != null : "fx:id=\"lblCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja2 != null : "fx:id=\"lblCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCaja3 != null : "fx:id=\"lblCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCantidadDeClientes != null : "fx:id=\"lblCantidadDeClientes\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblCarritosDisponibles != null : "fx:id=\"lblCarritosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientes != null : "fx:id=\"lblClientes\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesEnEspera != null : "fx:id=\"lblClientesEnEspera\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblSupermercado != null : "fx:id=\"lblSupermercado\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesCola != null : "fx:id=\"lblClientesCola\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert lblClientesEnCola != null : "fx:id=\"lblClientesEnCola\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja1 != null : "fx:id=\"txtCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja2 != null : "fx:id=\"txtCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCaja3 != null : "fx:id=\"txtCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtCarritosDisponibles != null : "fx:id=\"txtCarritosDisponibles\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtClientesEnEspera != null : "fx:id=\"txtClientesEnEspera\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja1 != null : "fx:id=\"txtColaCaja1\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja2 != null : "fx:id=\"txtColaCaja2\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";
        assert txtColaCaja3 != null : "fx:id=\"txtColaCaja3\" was not injected: check your FXML file 'VistaSupermercado.fxml'.";

        superCarritosDisponibles.llenarColaCarritos(carritosDisponibles);
        txtCarritosDisponibles.setText((String) (superCarritosDisponibles.mostrarCarritos(carritosDisponibles)));
//        txtCarritosDisponibles.setText("Hola");
    }

}
