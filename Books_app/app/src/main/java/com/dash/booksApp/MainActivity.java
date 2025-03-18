package com.dash.booksApp;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dash.booksApp.dataaccess.BookDA;
import com.dash.booksApp.dataaccess.Book;
import com.dash.booksApp.dataaccess.IBookDA;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Spinner spnCats;
    private Button searchBtn;
    private TextView resultLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bindSpinner();
        setup();
    }

    private void setup() {
        spnCats = findViewById(R.id.spn);
        searchBtn = findViewById(R.id.searchBtn);
        resultLabel = findViewById(R.id.resultLabel);

        if (spnCats == null || searchBtn == null || resultLabel == null) {
            Log.e("MainActivity", "One or more views are null. Check your layout file.");
            return;
        }

        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IBookDA data = new BookDA();
                String cat = spnCats.getSelectedItem().toString();
                List<Book> books = data.getBooks(cat);

                if (books == null || books.isEmpty()) {
                    resultLabel.setText("No books found for this category.");
                    return;
                }

                StringBuilder str = new StringBuilder();
                for (Book book : books) {
                    str.append(book.getName()).append("\n");
                }
                resultLabel.setText(str.toString());
            }
        });
    }

    private void bindSpinner() {
        IBookDA data = new BookDA();
        String[] cats = data.getCats();

        if (cats == null) {
            Log.e("MainActivity", "Categories array is null");
            return;
        }

        Log.d("MainActivity", "Categories: " + Arrays.toString(cats));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, cats);
        spnCats.setAdapter(adapter);
    }
}