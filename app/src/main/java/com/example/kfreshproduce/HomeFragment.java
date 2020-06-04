package com.example.kfreshproduce;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private static final String TAG = "HomeFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Button itemDetailsButton;
    private EditText toolbarTitleEditText;

    private String toolbarTitleString;

    private NavController navController;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initLayoutViews(view);
        initNavgation(view);
    }

    private void initLayoutViews(View view) {
        itemDetailsButton = view.findViewById(R.id.details_activity_button);
        itemDetailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toolbarTitleString = toolbarTitleEditText.getText().toString().trim();
                Log.d(TAG, "initLayoutViews: " + toolbarTitleString);
                Item sweetCorn = new Item("Sweet Corn", "P20.25", "Available");
//                HomeFragmentDirections.ActionHomeFragmentToItemDetailsFragment homeToDetailsAction = HomeFragmentDirections.actionHomeFragmentToItemDetailsFragment();
//                homeToDetailsAction.setToolbarTitle(toolbarTitleString);
//                navController.navigate(homeToDetailsAction);
                HomeFragmentDirections.ActionHomeFragmentToItemDetailsFragment homeToDetailsAction = HomeFragmentDirections.actionHomeFragmentToItemDetailsFragment(sweetCorn);
                homeToDetailsAction.setToolbarTitle(toolbarTitleString);
                navController.navigate(homeToDetailsAction);
            }
        });

        toolbarTitleEditText = view.findViewById(R.id.toolbar_title_arg_edit_text);
    }

    private void initNavgation(View view) {
        navController = Navigation.findNavController(view);
    }
}