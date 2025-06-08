package com.example.projectmysql.view;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.projectmysql.R;
import com.example.projectmysql.controller.ProductController;
import com.example.projectmysql.model.TelescopeProduct;

public class FormActivity extends AppCompatActivity {
    private EditText txtName, txtModel, txtPrice, txtDiscount, txtLength, txtFocal, txtWeight, txtAperture, txtEyepieces, txtExtra;
    private Button btnSave;
    private ProductController controller = new ProductController();
    private int editId = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        txtName = findViewById(R.id.txtName);
        txtModel = findViewById(R.id.txtModel);
        txtPrice = findViewById(R.id.txtPrice);
        txtDiscount = findViewById(R.id.txtDiscount);
        txtLength = findViewById(R.id.txtLength);
        txtFocal = findViewById(R.id.txtFocal);
        txtWeight = findViewById(R.id.txtWeight);
        txtAperture = findViewById(R.id.txtAperture);
        txtEyepieces = findViewById(R.id.txtEyepieces);
        txtExtra = findViewById(R.id.txtExtra);
        btnSave = findViewById(R.id.btnSave);

        editId = getIntent().getIntExtra("edit_id", -1);
        if (editId != -1) loadProduct(editId);

        btnSave.setOnClickListener(v -> {
            String name = txtName.getText().toString();
            String model = txtModel.getText().toString();
            int price = Integer.parseInt(txtPrice.getText().toString());
            int discount = Integer.parseInt(txtDiscount.getText().toString());
            float length = Float.parseFloat(txtLength.getText().toString());
            int focal = Integer.parseInt(txtFocal.getText().toString());
            float weight = Float.parseFloat(txtWeight.getText().toString());
            int aperture = Integer.parseInt(txtAperture.getText().toString());
            String eyepieces = txtEyepieces.getText().toString();
            String extra = txtExtra.getText().toString();

            TelescopeProduct p = new TelescopeProduct(editId, name, model, price, discount, length, focal, weight, aperture, eyepieces, extra);

            new Thread(() -> {
                if (editId == -1) controller.addProduct(p);
                else controller.updateProduct(p);
                runOnUiThread(() -> finish());
            }).start();
        });
    }

    private void loadProduct(int id) {
        new Thread(() -> {
            TelescopeProduct p = controller.getDetail(id);
            if (p != null) {
                runOnUiThread(() -> {
                    txtName.setText(p.productName);
                    txtModel.setText(p.model);
                    txtPrice.setText(String.valueOf(p.originalPrice));
                    txtDiscount.setText(String.valueOf(p.discountedPrice));
                    txtLength.setText(String.valueOf(p.tubeLengthCm));
                    txtFocal.setText(String.valueOf(p.focalLengthMm));
                    txtWeight.setText(String.valueOf(p.weightKg));
                    txtAperture.setText(String.valueOf(p.apertureMm));
                    txtEyepieces.setText(p.eyepieces);
                    txtExtra.setText(p.additionalInfo);
                });
            }
        }).start();
    }
}