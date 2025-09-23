package com.example.exe_1;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class ExploreActivity extends AppCompatActivity implements ProfilesAdapter.ProfileCallbacks {

    private DrawerLayout drawerLayout;
    private MaterialToolbar toolbar;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        
        // Set status bar color to black
        getWindow().setStatusBarColor(getResources().getColor(android.R.color.black, getTheme()));
        
        setContentView(R.layout.activity_explore);

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.cd_open_drawer, R.string.cd_close_drawer);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toolbar.setOnMenuItemClickListener(this::onToolbarMenuItemClick);

        View appBarContainer = findViewById(R.id.appBarContainer);
        ViewCompat.setOnApplyWindowInsetsListener(appBarContainer, (v, insets) -> {
            int top = insets.getInsets(WindowInsetsCompat.Type.statusBars()).top;
            v.setPadding(v.getPaddingLeft(), top, v.getPaddingRight(), v.getPaddingBottom());
            return insets;
        });

        RecyclerView recycler = findViewById(R.id.recyclerProfiles);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        ProfilesRepository repo = new ProfilesRepository();
        List<Profile> data = repo.getProfiles();
        ProfilesAdapter adapter = new ProfilesAdapter(data, this);
        recycler.setAdapter(adapter);

        navigationView.setNavigationItemSelectedListener(item -> {
            drawerLayout.closeDrawers();
            return true;
        });
    }

    private boolean onToolbarMenuItemClick(@NonNull MenuItem item) {
        Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public void onCardClick(@NonNull String id) {
        Toast.makeText(this, "Open profile: " + id, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBookmarkToggle(@NonNull String id, boolean state) {
        Toast.makeText(this, (state ? "Saved " : "Unsaved ") + id, Toast.LENGTH_SHORT).show();
    }
}


