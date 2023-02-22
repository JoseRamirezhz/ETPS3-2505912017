package sv.edu.utec.controleslayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //importamos las clases de los componentes que tenemos en la vista
    Spinner spPais;
    EditText edNombre, edApellidos, edinfo;
    RadioButton rbFem, rbMas, rbOtr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //hacemos los match con los de la vista
        edNombre = findViewById(R.id.edtNombres);
        edApellidos = findViewById(R.id.edtApellidos);
        edinfo = findViewById(R.id.editTextTextMultiLine);
        spPais = findViewById(R.id.spnPais);
        /* forma 1 con areglos
            //Arreglo que permita llenar el spinner
            String[] opciones = {"Seleccione un Pais","Guatemala","El Salvador", "Honduras", "Nicaragua","Costa Rica","Panama"};
            ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,opciones);
            spPais.setAdapter(adaptador);
         */

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item){
            public  View getView(int posicion, View contenido, ViewGroup parent){
                View vista = super.getView(posicion,contenido,parent);
                if (posicion == getCount()){
                    ((TextView)vista.findViewById(android.R.id.text1)).setText("");
                    ((TextView)vista.findViewById(android.R.id.text1)).setHint(getItem(getCount()));
                }
                return vista;
            }
            public  int getCount(){
                return super.getCount()-1;
            }
        };

        //lenando el dopdowns
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adaptador.add("Guatemala");
        adaptador.add("El Salvador");
        adaptador.add("Honduras");
        adaptador.add("Nicaragua");
        adaptador.add("Costa Rica");
        adaptador.add("Panama");
        adaptador.add("Seleccione un Pais");//este es el elemento que va a restar el getCount() que quitara del spiner
        spPais.setAdapter(adaptador);
        spPais.setSelection(adaptador.getCount()); //realizando un conteo
    }

    public void Almacenar(View v){
        String datos = "";
        String seleccion = spPais.getSelectedItem().toString();

        if (seleccion.equals("Seleccione un Pais")){
            datos = "No ha seleccionado ningun pais";
            edinfo.append(datos);
        }else if (seleccion.equals("Guatemala")){ //intemoff
            datos = "Guatemala";
            edinfo.append(datos);
        }else if (seleccion.equals("El Salvador")){ //intemoff
            datos = "El Salvador";
            edinfo.append(datos);
        }else if (seleccion.equals("Honduras")){ //intemoff
            datos = "Honduras";
            edinfo.append(datos);
        }
    }
}