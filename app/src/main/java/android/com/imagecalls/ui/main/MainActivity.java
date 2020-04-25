package android.com.imagecalls.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ImageViewCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.com.imagecalls.R;
import android.com.imagecalls.adapter.ImageRecyclerAdapter;
import android.com.imagecalls.pojo.ModelImage;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    ImageViewModel imageViewModel;
    RecyclerView mRecyclerView;
    ImageRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler);
        imageViewModel = ViewModelProviders.of(this).get(ImageViewModel.class);
        imageViewModel.getImage();

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new ImageRecyclerAdapter();
        mRecyclerView.setAdapter(adapter);

        imageViewModel.mutableLiveData.observe(this, modelImages -> adapter.setList(modelImages));
    }
}
