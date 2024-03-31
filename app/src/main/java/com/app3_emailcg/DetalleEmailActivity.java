package com.app3_emailcg;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleEmailActivity extends AppCompatActivity {
    private TextView senderTextView, emTextView, subjectTextView, contentTextView, dateTextView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_email);
        Email email = getIntent().getParcelableExtra("email");

        // Recuperar los Id de los TextView
        senderTextView = findViewById(R.id.senderTextView);
        emTextView = findViewById(R.id.emTextView);
        subjectTextView = findViewById(R.id.subjectTextView);
        contentTextView = findViewById(R.id.contentTextView);
        dateTextView = findViewById(R.id.dateTextView);

        // Obtener datos del Intent
        String sender = getIntent().getStringExtra("sender");
        String em = getIntent().getStringExtra("email");
        String subject = getIntent().getStringExtra("subject");
        String content = getIntent().getStringExtra("content");
        String date = getIntent().getStringExtra("date");

        // Mostrar datos en los TextView
        senderTextView.setText(sender);
        emTextView.setText(em);
        subjectTextView.setText(subject);
        contentTextView.setText(content);
        dateTextView.setText(date);

        Button responderButton = findViewById(R.id.responderButton);
        responderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Linea para responder al correo electrónico
                Toast.makeText(DetalleEmailActivity.this, "Correo Respondido", Toast.LENGTH_SHORT).show();
            }
        });

        Button reenviarButton = findViewById(R.id.reenviarButton);
        reenviarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Reenviar el correo
                Toast.makeText(DetalleEmailActivity.this, "Correo Reenviado", Toast.LENGTH_SHORT).show();
            }
        });

        Button destacarButton = findViewById(R.id.destacarButton);
        destacarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para destacar el correo
                Toast.makeText(DetalleEmailActivity.this, "Correo Destacado", Toast.LENGTH_SHORT).show();
            }
        });

        Button eliminarButton = findViewById(R.id.eliminarButton);
        eliminarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para eliminar el correo
                Toast.makeText(DetalleEmailActivity.this, "Correo Eliminado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("isRead", true);
        setResult(RESULT_OK, resultIntent);
        super.onBackPressed();
    }
}
