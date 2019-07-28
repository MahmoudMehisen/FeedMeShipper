package FoodOrder.feedmeshipper;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rengwuxian.materialedittext.MaterialEditText;

import FoodOrder.feedmeshipper.Common.Common;
import FoodOrder.feedmeshipper.Model.Shipper;
import info.hoang8f.widget.FButton;

public class MainActivity extends AppCompatActivity {

    FButton btn_sign_in;
    MaterialEditText edtPhone, edtPassword;

    FirebaseDatabase database;
    DatabaseReference shippers;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_sign_in = findViewById(R.id.btnSignIn);
        edtPhone = findViewById(R.id.edtPhone);
        edtPassword = findViewById(R.id.edtPassword);

        database = FirebaseDatabase.getInstance();
        shippers = database.getReference(Common.SHIPPER_TABLE);

        btn_sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login(edtPhone.getText().toString(), edtPassword.getText().toString());
            }
        });

    }

    private void login(String phone, final String password) {
        shippers.child(phone)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        if(dataSnapshot.exists()){
                            Shipper shipper = dataSnapshot.getValue(Shipper.class);
                            if(shipper.getPassword().equals(password)){
                                startActivity(new Intent(MainActivity.this, HomeActivity.class));
                                Common.currentShipper = shipper;
                                finish();
                            }
                            else{
                                Toast.makeText(MainActivity.this, "Incorrect Password !!!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Your shipper's phone is not exist !!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }
}
