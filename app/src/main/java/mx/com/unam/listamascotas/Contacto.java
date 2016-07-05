package mx.com.unam.listamascotas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Contacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);
    }

    public void sendEmail(View view){
        TextView nombre = (TextView) findViewById(R.id.nameField);
        TextView email = (TextView)findViewById(R.id.mailField);
        TextView comment = (TextView)findViewById(R.id.commentField);

        System.out.println(email.getText().toString());
        Mail m = new Mail("frodriguez@faktos.com", "");

        String[] toArr = {"frodriguez@faktos.com",email.getText().toString()};
        m.setTo(toArr);
        m.setFrom("frodriguez@faktos.com");
        m.setSubject("This is an email sent using my Mail JavaMail wrapper from an Android device.");
        m.setBody(comment.getText().toString());

        try {

            if(m.send()) {
                Toast.makeText(this.getBaseContext(), "Email enviado exitosamente.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this.getBaseContext(), "Email no enviado.", Toast.LENGTH_LONG).show();
            }

        } catch(Exception e) {
            Toast.makeText(this.getBaseContext(), "Hubo un error al enviar el email.", Toast.LENGTH_LONG).show();

        }

    }
}
