package estrada.leon.rafael.pongrafa;

import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import estrada.leon.rafael.pongrafa.Tabla.SQLiteHelper;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SQLiteHelper conexion=new SQLiteHelper(this,"bd usuarios",null,1);
    }
}
