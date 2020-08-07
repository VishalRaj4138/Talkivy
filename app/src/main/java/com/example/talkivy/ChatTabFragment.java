package com.example.talkivy;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ChatTabFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ChatTabFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ChatTabFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ChatTabFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ChatTabFragment newInstance(String param1, String param2) {
        ChatTabFragment fragment = new ChatTabFragment();
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
        View v = inflater.inflate(R.layout.fragment_chat_tab, container, false);

        Toolbar toolbar=v.findViewById(R.id.channelchat_toolbar);
        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);



        RecyclerView recyclerView=(RecyclerView)v.findViewById(R.id.channelchat_recyclerview);
        ArrayList<String> usernameslist=new ArrayList<String>();

        usernameslist.add("Aditya");
        usernameslist.add("Vishal");
        usernameslist.add("Harshith");
        usernameslist.add("Talivy");
        usernameslist.add("Ryd");

        MyAdapter adapter=new MyAdapter(getActivity().getApplicationContext(),usernameslist);
        recyclerView.setAdapter(adapter);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return v;
    }
}