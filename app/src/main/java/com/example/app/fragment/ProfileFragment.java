package com.example.app.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.app.R;

import static com.example.app.MainActivity.*;


public class ProfileFragment extends Fragment {

    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        setHasOptionsMenu(true);

        return rootView;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        inflater.inflate(R.menu.toolbar_profile, menu);

        MenuItem coins = menu.findItem(R.id.playerCoins);
        coins.setTitle(String.valueOf(player.getCoins()));

        MenuItem xp = menu.findItem(R.id.playerXp);
        xp.setTitle(String.valueOf(player.getXpPoints()));


        super.onCreateOptionsMenu(menu, inflater);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.currentCourseFlag) {

            Toast.makeText(getActivity().getApplicationContext(), "Flag pressed.", Toast.LENGTH_SHORT).show();

        }

        return false;

    }
}