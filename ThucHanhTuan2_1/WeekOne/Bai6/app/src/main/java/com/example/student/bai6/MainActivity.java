package com.example.student.bai6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Product> listProduct;
    ProductListViewAdapter productListViewAdapter;
    ListView listViewProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listProduct  = new ArrayList<>();
        listProduct.add(new Product(1, "Iphone 6", 500, R.drawable.ip6));
        listProduct.add(new Product(2, "Iphone 7", 700, R.drawable.ip7));
        listProduct.add(new Product(3, "Sony Abc", 800, R.drawable.sony));
        listProduct.add(new Product(4, "Samsung XYZ", 900, R.drawable.samsung));
        listProduct.add(new Product(5, "SP 5", 500, R.drawable.vn));
        listProduct.add(new Product(6, "SP 6", 700, R.drawable.vn));
        listProduct.add(new Product(7, "SP 7", 800, R.drawable.vn));
        listProduct.add(new Product(8, "SP 8", 900, R.drawable.vn));
        listProduct.add(new Product(9,"SP 9",1000, R.drawable.vn));
        productListViewAdapter = new ProductListViewAdapter(listProduct);

        listViewProduct = findViewById(R.id.listproduct);
        listViewProduct.setAdapter(productListViewAdapter);

        //Lắng nghe bắt sự kiện một phần tử danh sách được chọn
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = (Product) productListViewAdapter.getItem(position);
                //Làm gì đó khi chọn sản phẩm (ví dụ tạo một Activity hiện thị chi tiết, biên tập ..)
                Toast.makeText(MainActivity.this, product.name, Toast.LENGTH_LONG).show();
            }
        });

        findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listProduct.size() > 0) {
                    //Xoá phần tử đầu tiên của danh sách
                    int productpost = 0;
                    listProduct.remove(productpost);
                    //Thông báo cho ListView biết dữ liệu đã thay đổi (cập nhật, xoá ...)
                    productListViewAdapter.notifyDataSetChanged();
                }
            }
        });
    }
}
