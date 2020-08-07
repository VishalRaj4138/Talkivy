package com.example.talkivy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WarrantExpiryDashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WarrantExpiryDashboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WarrantExpiryDashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WarrantExpiryDashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WarrantExpiryDashboardFragment newInstance(String param1, String param2) {
        WarrantExpiryDashboardFragment fragment = new WarrantExpiryDashboardFragment();
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
        View v = inflater.inflate(R.layout.fragment_warrant_expiry_dashboard, container, false);

        setHasOptionsMenu(true);

        //setting up the toolbar
        Toolbar toolbar = v.findViewById(R.id.tool_bar);
        toolbar.setTitle("Warranty/Expiry Dashboard");
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);

        LinearLayout expiry = v.findViewById(R.id.expiry);
        LinearLayout warranty = v.findViewById(R.id.warranty);

        expiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ExpiryFragment expiryFragment = new ExpiryFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,expiryFragment,null);
                transaction.addToBackStack(null).commit();
            }
        });

        warranty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WarrantyFragment warrantyFragment = new WarrantyFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container,warrantyFragment,null);
                transaction.addToBackStack(null).commit();
            }
        });

        return v;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.tool_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.add) {

            startActivity(new Intent(getActivity(), FormActivity.class));

        }
        return super.onOptionsItemSelected(item);
    }

}