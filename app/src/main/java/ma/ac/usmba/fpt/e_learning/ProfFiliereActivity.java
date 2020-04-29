package ma.ac.usmba.fpt.e_learning;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Iterator;

import ma.ac.usmba.fpt.e_learning.Controller.ProfFiliereController;
import ma.ac.usmba.fpt.e_learning.Model.Filiere;

import static android.graphics.Color.WHITE;
import static android.widget.LinearLayout.VERTICAL;

public class ProfFiliereActivity extends AppCompatActivity {
    ArrayList<Filiere> list_filiere = ProfFiliereController.set_Filiere();
    LinearLayout filier_layout;
    Button bouton;
    ArrayList<Button> button_filier_list = new ArrayList<>();

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prof_filiere);
        androidx.appcompat.widget.Toolbar toolbar= findViewById(R.id.constraintLayout4);
        setSupportActionBar(toolbar);
        ImageView img=findViewById(R.id.GoBackIcon);
        img.setImageResource(R.drawable.trace_52);
        TextView txt=findViewById(R.id.textView);
        txt.setText("Espace Enseignant");
        toolbar.setBackgroundColor(Color.parseColor("#E31731"));
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        filier_layout = (LinearLayout) findViewById(R.id.filiere_layout);

        filier_layout.addView(new TextView(this));
        Iterator<Filiere> iter_filiere = list_filiere.iterator();
        int i = 0;
        while (iter_filiere.hasNext()) {
            Filiere f = iter_filiere.next();
            button_filier_list.add(new Button(this));
            button_filier_list.get(i).setBackgroundResource(R.drawable.rectangle_11);
            button_filier_list.get(i).setWidth(500);
            button_filier_list.get(i).setWidth(150);
            button_filier_list.get(i).setTextColor(WHITE);
            button_filier_list.get(i).setTextSize(20);
            button_filier_list.get(i).setText(f.getNom_filere());
            button_filier_list.get(i).setTag(i);
            button_filier_list.get(i).setPadding(100, 0, 100, 0);
            button_filier_list.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String from = getIntent().getStringExtra("from");
                    if (from.equals("Creer")) {
                        Intent intent = new Intent(ProfFiliereActivity.this, ProfCreerSeanceActivity.class);
                        startActivity(intent);
                    } else if (from.equals("Gerer")) {
                        Intent intent = new Intent(ProfFiliereActivity.this, ProfModuleActivity.class);
                        intent.putExtra("from", ProfFiliereActivity.class.getName());
                        startActivity(intent);
                    }
                }
            });
            filier_layout.addView(button_filier_list.get(i));
            i++;
        }
    }


    public void goback(View view) {
        finish();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }
}
