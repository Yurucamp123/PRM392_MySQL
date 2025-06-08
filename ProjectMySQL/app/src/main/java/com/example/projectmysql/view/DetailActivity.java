package com.example.projectmysql.view;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.projectmysql.R;
import com.example.projectmysql.controller.ProductController;
import com.example.projectmysql.model.TelescopeProduct;

public class DetailActivity extends AppCompatActivity {
    private TextView txtDetail;
    private ProductController controller = new ProductController();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtDetail = findViewById(R.id.txtDetail);
        int id = getIntent().getIntExtra("id", -1);

        new Thread(() -> {
            TelescopeProduct p = controller.getDetail(id);
            if (p != null) {
                String info = "Tên: " + p.productName + "\n" +
                        "Model: " + p.model + "\n" +
                        "Giá gốc: " + p.originalPrice + "\n" +
                        "Giảm giá: " + p.discountedPrice + "\n" +
                        "Chiều dài ống: " + p.tubeLengthCm + " cm\n" +
                        "Tiêu cự: " + p.focalLengthMm + " mm\n" +
                        "Trọng lượng: " + p.weightKg + " kg\n" +
                        "Đường kính: " + p.apertureMm + " mm\n" +
                        "Thị kính: " + p.eyepieces + "\n" +
                        "Thông tin thêm: " + p.additionalInfo;

                runOnUiThread(() -> txtDetail.setText(info));
            }
        }).start();
    }
}