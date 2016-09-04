package mandarine.dam.isi.frsf.utn.edu.ar.lab02c2016;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;


import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener, AdapterView.OnItemClickListener{
    DecimalFormat f = new DecimalFormat("##.00");

    private ElementoMenu[] listaBebidas;
    private ElementoMenu[] listaPlatos;
    private ElementoMenu[] listaPostre;
    private ArrayList<ElementoMenu> listaElementos;
    private ToggleButton botonTipoPedido;
    private TextView textoPedidos;
    private Button botonAgregar;
    private Button botonConfirmar;
    private Button botonReiniciar;
    private ListView listaProductos;
    private RadioGroup radioGroup;
    private RadioButton radioButtonPlato;
    private RadioButton radioButtonPostre;
    private RadioButton radioButtonBebida;

    private ArrayAdapter<ArrayList> adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonTipoPedido = (ToggleButton) findViewById(R.id.botonTipoCena);
        textoPedidos = (TextView) findViewById(R.id.textoPedidos);
        botonAgregar = (Button) findViewById(R.id.buttonAgregar);
        botonConfirmar = (Button) findViewById(R.id.buttonConfirmar);
        botonReiniciar = (Button) findViewById(R.id.buttonReiniciar);
        listaProductos = (ListView) findViewById(R.id.listViewProductos);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioButtonPlato = (RadioButton) findViewById(R.id.radioButtonComida);
        radioButtonPostre = (RadioButton) findViewById(R.id.radioButtonPostre);
        radioButtonBebida = (RadioButton) findViewById(R.id.radioButtonBebida);


        adaptador = new ArrayAdapter(this,android.R.layout.simple_list_item_single_choice,listaElementos);

        radioGroup.setOnCheckedChangeListener(this);
        botonAgregar.setOnClickListener(this);
        botonConfirmar.setOnClickListener(this);
        botonReiniciar.setOnClickListener(this);
        botonTipoPedido.setOnClickListener(this);
        listaProductos.setAdapter(adaptador);



    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        listaProductos.clearChoices();
        switch (checkedId){
            case 0:
                listaElementos.addAll(Arrays.asList(listaPlatos));

                break;
            case 1:
                listaElementos.addAll(Arrays.asList(listaPostre));
                break;
            case 2:
                listaElementos.addAll(Arrays.asList(listaBebidas));

                break;
            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    class ElementoMenu {
        private Integer id;
        private String nombre;
        private Double precio;

        public ElementoMenu() {
        }

        public ElementoMenu(Integer i, String n, Double p) {
            this.setId(i);
            this.setNombre(n);
            this.setPrecio(p);
        }

        public ElementoMenu(Integer i, String n) {
            this(i,n,0.0);
            Random r = new Random();
            this.precio= (r.nextInt(3)+1)*((r.nextDouble()*100));
        }


        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public Double getPrecio() {
            return precio;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }

        @Override
        public String toString() {
            return this.nombre+ " ( "+f.format(this.precio)+" )";
        }
    }

    private void iniciarListas(){
        // inicia lista de bebidas
        listaBebidas = new ElementoMenu[7];
        listaBebidas[0]=new ElementoMenu(1,"Coca");
        listaBebidas[1]=new ElementoMenu(4,"Jugo");
        listaBebidas[2]=new ElementoMenu(6,"Agua");
        listaBebidas[3]=new ElementoMenu(8,"Soda");
        listaBebidas[4]=new ElementoMenu(9,"Fernet");
        listaBebidas[5]=new ElementoMenu(10,"Vino");
        listaBebidas[6]=new ElementoMenu(11,"Cerveza");
        // inicia lista de platos
        listaPlatos= new ElementoMenu[14];
        listaPlatos[0]=new ElementoMenu(1,"Ravioles");
        listaPlatos[1]=new ElementoMenu(2,"Gnocchi");
        listaPlatos[2]=new ElementoMenu(3,"Tallarines");
        listaPlatos[3]=new ElementoMenu(4,"Lomo");
        listaPlatos[4]=new ElementoMenu(5,"Entrecot");
        listaPlatos[5]=new ElementoMenu(6,"Pollo");
        listaPlatos[6]=new ElementoMenu(7,"Pechuga");
        listaPlatos[7]=new ElementoMenu(8,"Pizza");
        listaPlatos[8]=new ElementoMenu(9,"Empanadas");
        listaPlatos[9]=new ElementoMenu(10,"Milanesas");
        listaPlatos[10]=new ElementoMenu(11,"Picada 1");
        listaPlatos[11]=new ElementoMenu(12,"Picada 2");
        listaPlatos[12]=new ElementoMenu(13,"Hamburguesa");
        listaPlatos[13]=new ElementoMenu(14,"Calamares");
        // inicia lista de postres
        listaPostre= new ElementoMenu[15];
        listaPostre[0]=new ElementoMenu(1,"Helado");
        listaPostre[1]=new ElementoMenu(2,"Ensalada de Frutas");
        listaPostre[2]=new ElementoMenu(3,"Macedonia");
        listaPostre[3]=new ElementoMenu(4,"Brownie");
        listaPostre[4]=new ElementoMenu(5,"Cheescake");
        listaPostre[5]=new ElementoMenu(6,"Tiramisu");
        listaPostre[6]=new ElementoMenu(7,"Mousse");
        listaPostre[7]=new ElementoMenu(8,"Fondue");
        listaPostre[8]=new ElementoMenu(9,"Profiterol");
        listaPostre[9]=new ElementoMenu(10,"Selva Negra");
        listaPostre[10]=new ElementoMenu(11,"Lemon Pie");
        listaPostre[11]=new ElementoMenu(12,"KitKat");
        listaPostre[12]=new ElementoMenu(13,"IceCreamSandwich");
        listaPostre[13]=new ElementoMenu(14,"Frozen Yougurth");
        listaPostre[14]=new ElementoMenu(15,"Queso y Batata");

    }

}
