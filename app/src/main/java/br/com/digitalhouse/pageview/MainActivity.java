package br.com.digitalhouse.pageview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private LinearLayout linearCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        linearCategories = findViewById(R.id.linearCategories);

        // Lista de fragmentos para mostrar, aqui coloquei 4 fotos
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(PhotoFragment.newInstance(R.drawable.android_image, "Android texto de test 1"));
        fragments.add(PhotoFragment.newInstance(R.drawable.android_image_2, "Android texto de test 2"));
        fragments.add(PhotoFragment.newInstance(R.drawable.android_image, "Android texto de test 3"));
        fragments.add(PhotoFragment.newInstance(R.drawable.android_image_2, "Android texto de test 4"));

        // pageStateAdapter para mostrar os fragmentos de fotos no view pager
        PhotoPageStateAdapter pageStateAdapter = new PhotoPageStateAdapter(getSupportFragmentManager(), fragments);

        // Vincula o pageStateAdapter com o viewpager
        viewPager.setAdapter(pageStateAdapter);

        // For para a quantidade de categorias aqui estou percorrendo 5 vezes
        //adicionar os items dinamicamente no container
        for (int i = 0; i < 5; i++) {
            addCategoryListItems(linearCategories, "Texto para a categoria " + i);
        }
    }

    // seto o texto e adiciono no container
    private void addCategoryListItems(LinearLayout container, String text) {
        //Infla o layout
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.category_item, null);
        //Procura a view do texto
        TextView textViewCategory = layout.findViewById(R.id.category_item_name);
        //seta o texto
        textViewCategory.setText(text);

        //adiciona no container
        container.addView(layout);
    }
}
