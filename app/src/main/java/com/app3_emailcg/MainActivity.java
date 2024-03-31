package com.app3_emailcg;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    private static final int DETAIL_REQUEST_CODE = 1;
    private RecyclerView recyclerView;
    private EmailAdapter emailAdapter;
    private List<Email> emailList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtener referencia al TextView donde se muestra el estado del mensaje

        // Inicializar la lista de correos electrónicos
        emailList = new ArrayList<>();
        emailList.add(new Email(1, "Andrés Pérez", "andrespz10@miemail.com", "Hoja de vida", "Hola amigo, no olvides enviar la hoja de vida, tienes hasta mañana", "02-04-2024 8:25 AM"));
        emailList.add(new Email(2, "Sara López", "saralopez34@miemail.com", "Envío de proyecto", "Buenos días, te envío mi parte de nuestro proyecto final. Que tengas buen día.", "02-04-2024 5:29 AM"));
        emailList.add(new Email(3, "Juliana Restrepo", "julires80@miemail.com", "Notificación hoja de vida", "El presente correo es para recordarle que tiene plazo hasta el 3 de abril para el envío de la hoja de vida, muchas gracias.", "31-03-2024 5:00PM"));
        emailList.add(new Email(4, "Diego Norrea", "diegon@miemail.com", "Confirmación de pedido", "Confirmamos el pago del producto, la entrega será en 2-3 días. Gracias por comprar con nosotros", "30-03-2024 1:26 PM"));
        emailList.add(new Email(5, "IUPB", "iupb@miemail.com", "Invitación a Conferencia", "Le invitamos cordialmente a nuestra conferencia el próximo jueves.", "30-03-2024 10:30 AM"));
        emailList.add(new Email(6, "Diego Norrea", "diegon@miemail.com", "Realización de pago", "Buenas tardes, para el envío de su producto por favor debe hacer el pago primero", "29-03-2024 6:40 PM"));
        emailList.add(new Email(6, "Angie Torres", "angietorres911@miemail.com", "Proyecto Final", "Hola, anexo mi parte del proyecto final, espero los demás ya lo tengan listo. Bye", "29-03-2024 11:00 AM"));

        // Inicializar el RecyclerView
        recyclerView = findViewById(R.id.recyclerViewEmails);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Inicializar y configurar el adaptador
        emailAdapter = new EmailAdapter(this, emailList);
        recyclerView.setAdapter(emailAdapter);

        // Configurar el OnClickListener para abrir la DetalleEmailActivity al hacer clic en un correo
        emailAdapter.setOnItemClickListener(new EmailAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // Abrir la DetalleEmailActivity con la información del correo seleccionado
                Email email = emailList.get(position);
                Intent intent = new Intent(MainActivity.this, DetalleEmailActivity.class);
                intent.putExtra("sender", email.getSender());
                intent.putExtra("email", email.getEmail());
                intent.putExtra("subject", email.getSubject());
                intent.putExtra("content", email.getContent());
                intent.putExtra("date", email.getDate());
                startActivityForResult(intent, DETAIL_REQUEST_CODE);
            }
        });
    }

}